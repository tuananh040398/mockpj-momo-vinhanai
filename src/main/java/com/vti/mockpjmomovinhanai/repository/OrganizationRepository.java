package com.vti.mockpjmomovinhanai.repository;

import com.vti.mockpjmomovinhanai.modal.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
