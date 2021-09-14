package com.ryfsystems.Telcom.entity.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "login")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private int privilege;
    private String nombre;
    private String nodo;
    private String correo;
    private int chat;
    private String acceso;
    private int estado;
    private int timeout;
    private int mail;
    private int api;
    private long avatar;
    private String colorAvatar;
    private String movil;
    private String fb;
    private String twitter;
    private float comisionCobro;
    private String tokenApi;
    private String recover;
    private String diaAcceso;
    private String inicioAcceso;
    private String finAcceso;
    private String pass;
    private String OpMen1;
    private String OpMen2;
    private String OpMen3;
    private String OpMen4;
    private String OpMen5;
}
