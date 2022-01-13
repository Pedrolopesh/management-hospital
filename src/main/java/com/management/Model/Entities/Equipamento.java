package com.management.Model.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipamento;

    @Column(name = "nomeEquipamento", nullable = false)
    private String nomeEquipamento;

    @Column(name = "qntEquipamento")
    private int qntEquipamento;

    private Date createdAt;

    //    INITIALIZER NO-ARGS PUBLIC CLASS
    public Equipamento() { }

    @PrePersist
    protected void onCreate() {this.createdAt = new Date(); }

    public Equipamento(String nomeEquipamento, int qntEquipamento, int idEquipamento, Date createdAt){
        this.nomeEquipamento = nomeEquipamento;
        this.qntEquipamento = qntEquipamento;
        this.idEquipamento = idEquipamento;
        this.createdAt = createdAt;
    }

    public int getQntEquipamento(){
        return qntEquipamento;
    }

    public boolean setQntEquipamento(int qntEquipamento){
        if(qntEquipamento < 0){
            return false;
        }
        this.qntEquipamento = qntEquipamento;
        return true;
    }

    public String getNomeEquipamento (){
        return nomeEquipamento;
    }

    public boolean setNomeEquipamento( String nomeEquipamento){
        if(nomeEquipamento.isEmpty()){
            return false;
        }
        this.nomeEquipamento = nomeEquipamento;
        return true;
    }
    public int getIdEquipamento(){
        return idEquipamento;
    }

}
