package com.ryfsystems.Telcom.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "smsmensajes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmsMensaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int user;
    private Date enviado;
    private String ndestino;
    private String stado;
    private String mensaje;
    private int proveedor;
    private String error;
    private String adjunto;
}
