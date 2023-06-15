package com.vti.mockpjmomovinhanai.repository;

import com.vti.mockpjmomovinhanai.modal.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
      // cách 2: gộp acc nếu 1 người quyên góp 1 ct nhiều lần
//    @Query(value = "SELECT count(DISTINCT donate_by) FROM mock_project.donation WHERE product_id = ?", nativeQuery = true)
//    int countDonateBy(int productId);
}
