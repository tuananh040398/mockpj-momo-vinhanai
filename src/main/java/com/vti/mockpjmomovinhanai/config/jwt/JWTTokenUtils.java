package com.vti.mockpjmomovinhanai.config.jwt;


import com.alibaba.fastjson.JSON;
import com.vti.mockpjmomovinhanai.exception.AppException;
import com.vti.mockpjmomovinhanai.modal.dto.LoginDto;
import com.vti.mockpjmomovinhanai.modal.entity.Role;
import com.vti.mockpjmomovinhanai.modal.entity.Token;
import com.vti.mockpjmomovinhanai.repository.TokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
public class JWTTokenUtils {

    private static final long EXPIRATION_TIME = 864000000; // Thời hạn của token: 10 ngày
    private static final String SECRET = "123456"; // Chữ kí bí mật
    private static final String PREFIX_TOKEN ="Bearer";

    @Autowired
    private TokenRepository tokenRepository;

    // Hàm tạo ra token
    public String createAccessToken(LoginDto loginDto) {
    // Tạo giá trị thời hạn token ( = thời gian hiện tại + 10 hoặc tùy )
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        String token = Jwts.builder()
                .setId(String.valueOf(loginDto.getId())) // Set giá trị Id
                .setSubject(loginDto.getUsername()) // Set giá trị Subject
                .setIssuedAt(new Date())
                .setIssuer("VTI")
                .setExpiration(expirationDate) // Set thời hạn của token
                .signWith(SignatureAlgorithm.HS512, SECRET) // Khai báo phương thức mã hóa Token và chữ kí bí mật
                .claim("authorities", loginDto.getRole().name()) // Thêm trường authorities để lưu giá trị phân quyền
                .claim("user_agent", loginDto.getUserAgent()).compact(); // Thêm trường user_agent để lưu thông tin trình duyệt đang dùng

        // Tạo đối tượng Token lưu vào Database
        Token tokenEntity = new Token();
        tokenEntity.setToken(token);
        tokenEntity.setExpiration(expirationDate);
        tokenEntity.setUserAgent(loginDto.getUserAgent());
        tokenRepository.save(tokenEntity);
        return token;
    }

    // Hàm dùng để mã hóa Token
    public LoginDto parseAccessToken(String token) {
        LoginDto loginDto = new LoginDto();
        if (!token.isEmpty()) {
            try {
                token = token.replace(PREFIX_TOKEN, "").trim();
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token).getBody();
                // Lấy ra các thông tin
                String user = claims.getSubject();
                Role role = Role.valueOf(claims.get("authorities").toString());
                String userAgent = claims.get("user_agent").toString();

                // Gán các thông tin vào đối tượng LoginDto, có thể sử dụng Constructor
                loginDto.setUsername(user);
                loginDto.setRole(role);
                loginDto.setUserAgent(userAgent);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return loginDto;
    }

    public boolean checkToken(String token, HttpServletResponse response, HttpServletRequest httpServletRequest){
        try {
            if (StringUtils.isBlank(token) || !token.startsWith(PREFIX_TOKEN)) { // Token bị trống -> lỗi
                responseJson(response, new AppException("Token không hợp lệ", 401, httpServletRequest.getRequestURI()));
                return false;
            }
            token = token.replace(PREFIX_TOKEN, "").trim();

            Token tokenEntity = tokenRepository.findByToken(token);
            if (tokenEntity == null) { // không có token trên hệ thống
                responseJson(response, new AppException("Token không tồn tại", 401, httpServletRequest.getRequestURI()));
                return false;
            }
            if (tokenEntity.getExpiration().after(new Date(System.currentTimeMillis() + EXPIRATION_TIME))) { // Token hết hạn
                responseJson(response, new AppException("Token hết hiệu lực", 401, httpServletRequest.getRequestURI()));
                return false;
            }
        } catch (Exception e) {
            responseJson(response, new AppException(e.getMessage(), 401, httpServletRequest.getRequestURI()));
            return false;
        }
        return true;
    }

    // Hàm dùng để response dữ liệu khi gặp lỗi
    private void responseJson(HttpServletResponse response, AppException appException) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(appException.getCode());
        try {
            response.getWriter().print(JSON.toJSONString(appException));
        } catch (IOException e) {
            log.debug(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
