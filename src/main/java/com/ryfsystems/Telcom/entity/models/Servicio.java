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
@Table(name = "tblservicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int idcliente;
    private int idperfil;
    private int nodo;
    private String descripcion;
    private float costo;
    private String ipap;
    private String mac;
    private String ip;
    private Date instalado;
    private int antena;
    private String pppuser;
    private String ppppass;
    private int emisor;
    private String userUbnt;
    private String passUbnt;
    private String tiposervicio;
    private String statusUser;
    private int tipoipv4;
    private int redipv4;
    private String coordenadas;
    private String direccion;
    private String snmpComunidad;
    private String firewallState;

    @OneToMany(targetEntity = Usuario.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Usuario> usuarios;
}
