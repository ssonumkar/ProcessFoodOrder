package com.orderfood.process.ProcessOrder.dao;

import com.orderfood.process.ProcessOrder.entity.ItemType;
import com.orderfood.process.ProcessOrder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;

@Repository
@Retryable(maxAttempts = 3)
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
    @Query("SELECT CASE WHEN COUNT(id) > 0 THEN TRUE ELSE FALSE END from ItemType where type_name = ?1")
    boolean isItemTypeExist(String typeName);
}
