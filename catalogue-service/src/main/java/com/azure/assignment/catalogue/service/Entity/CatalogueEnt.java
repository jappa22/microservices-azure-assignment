package com.azure.assignment.catalogue.service.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CatalogueTable")
public class CatalogueEnt {

    @Id
    @SequenceGenerator(
            name = "Catalogue_sequence",
            sequenceName = "Catalogue_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "Catalogue_sequence",
            strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Long catalogueId;
    private String categoryName;
    private String product;
}
