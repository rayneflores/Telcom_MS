package com.ryfsystems.Telcom.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "soporte")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Soporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int idcliente;
    private int idsoporte;
    private String asunto;
    private Date fechaSoporte;
    private String estado;
    private String operador;
    private Date fechaCerrado;
    private String procede;
    private String solicitante;
    private Date fechavisita;
    private String turno;
    private String agendado;
    private Date lastdate;
    private int dp;
    private String cun;
    private String motivoCierre;

    @OneToMany(targetEntity = Login.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Login> logins;

    @OneToMany(targetEntity = Usuario.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Usuario> usuarios;
}
