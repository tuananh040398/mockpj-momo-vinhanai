package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.config.jwt.JWTTokenUtils;
import com.vti.mockpjmomovinhanai.exception.AppException;
import com.vti.mockpjmomovinhanai.exception.ErrorResponseBase;
import com.vti.mockpjmomovinhanai.modal.dto.LoginDto;
import com.vti.mockpjmomovinhanai.modal.entity.Account;
import com.vti.mockpjmomovinhanai.modal.request.LoginRequest;
import com.vti.mockpjmomovinhanai.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin("*")
@Validated
public class AuthController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JWTTokenUtils jwtTokenUtils;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @PostMapping("/login")
    public LoginDto loginJWT(@RequestBody LoginRequest request) {
        // Tìm kiếm xem User có tồn tại trong hệ thống này hay không
        Optional<Account> accountOptional = accountRepository.findByUsername(request.getUsername());
        if (accountOptional.isEmpty()) {
            throw new AppException(ErrorResponseBase.LOGIN_FAILS_USERNAME);
        }
        // Kiếm tra password người dùng truyền vào có đúng hay không
        if (!encoder.matches(request.getPassword(), accountOptional.get().getPassword())) {
            throw new AppException(ErrorResponseBase.LOGIN_FAILS_PASSWORD); // Nếu không khớp bắn ra lỗi
        }
        // Tạo đối tượng LoginDto để trả về
        LoginDto loginDto = new LoginDto();
        BeanUtils.copyProperties(accountOptional.get(), loginDto);
        loginDto.setUserAgent(httpServletRequest.getHeader("User_Agent")); // Lấy thông tin trình duyệt đang sử dụng
        String token = jwtTokenUtils.createAccessToken(loginDto); // Tạo token
        loginDto.setToken(token); // Set giá trị token vào loginDto để trả về cho người dùng sử dụng
        return loginDto;
    }

}
