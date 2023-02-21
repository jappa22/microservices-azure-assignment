package com.azure.assignment.catalogue.service.Repository;

import com.azure.assignment.catalogue.service.Entity.CatalogueEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogueRepository extends JpaRepository<CatalogueEnt, Long> {

    List<CatalogueEnt> findByCategoryName(String catName);

    List<CatalogueEnt> findAllByOrderByCategoryName();
}
