package com.azure.assignment.catalogue.service.Repository;

import com.azure.assignment.catalogue.service.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByproductType(String category);
}
