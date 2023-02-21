package com.azure.assignment.catalogue.service.Repository;

import com.azure.assignment.catalogue.service.Entity.GetProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetProductRepository extends JpaRepository<GetProduct, Long> {
    GetProduct findByModelNumber(String id);
}
