package com.vti.mockpjmomovinhanai.repository;

import com.vti.mockpjmomovinhanai.modal.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
