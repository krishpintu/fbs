package com.ks.fbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sector")
public class Sector extends BaseEntity {

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String sectorName;

    @Column(nullable = false)
    @NotEmpty
    private String status;


}
