package com.endava.exam.repository;

import com.endava.exam.model.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupermarketRepository extends JpaRepository<Supermarket, String> {

    Optional<Supermarket> findSupermarketByUuid(String uuid);
}
