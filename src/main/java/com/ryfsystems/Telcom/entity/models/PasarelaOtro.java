package com.ryfsystems.Telcom.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pasarelaotros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasarelaOtro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String pasarela;
    private String dsp1;
    private String dsp2;
    private String dsp3;
    private String dsp4;
}
