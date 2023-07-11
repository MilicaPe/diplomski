package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String type;
    @Column
    private String layer;
    @Column
    private String intensity;
    @Column
    private int min;
    @Column
    private int max;
    @Column
    private boolean   finalResult;
    @Column
    private String text;
}
