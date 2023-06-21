package com.vti.mockpjmomovinhanai.repository;

import com.vti.mockpjmomovinhanai.modal.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByToken(String token);

    List<Token> findAllByExpirationIsAfter(Date exDate);
}
