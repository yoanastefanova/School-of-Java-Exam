package com.endava.exam.repository;


import com.endava.exam.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    Item findItemByUuid(String UUID);
}
