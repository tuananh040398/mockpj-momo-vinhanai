package com.vti.mockpjmomovinhanai.repository;

import com.vti.mockpjmomovinhanai.modal.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Optional<Organization> findOrganizationByName(String name);
}
