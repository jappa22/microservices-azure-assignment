package com.azure.assignment.catalogue.service.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Spec {
    private String supported;
    private String internet;
    private String services;
    private String display;
    private String resolution;
}
