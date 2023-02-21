package com.azure.assignment.product.search.service.Repository;

import com.azure.assignment.product.search.service.Messages.InHandProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface InHandProductRepository extends JpaRepository<InHandProducts, Long> {
    InHandProducts findByModelNumber(String modelNumber);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE IN_HAND_PRODUCTS SET in_hand_product =?1  WHERE model_number = ?2",
            nativeQuery = true
    )
    void updateItemsinDb(String productCount, String modelNumber);

    @Transactional
    @Query(
            value = "select IN_HAND_PRODUCT from IN_HAND_PRODUCTS WHERE MODEL_NUMBER = ?1",
            nativeQuery = true
    )
    String getCount(String modelNumber);

    @Transactional
    @Query(
            value = "UPDATE IN_HAND_PRODUCTS SET in_hand_product =?1  WHERE model_number = ?2",
            nativeQuery = true
    )
    String removeItems(String toString, String modelNumber);
}

