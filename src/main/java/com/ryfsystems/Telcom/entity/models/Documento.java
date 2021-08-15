package com.ryfsystems.Telcom.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sysdoc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long n;
    private String docnum;
    private String emirtn;
    private String emiema;
    private String emicai;
    private String emicae;
    private Date fecini;
    private Date fecfin;
    private String vinini;
    private String vinfin;
    private int numini;
    private int numfin;
    private int faccod;
    private String doctip;
    private String faccom;
    private int docact;
}
