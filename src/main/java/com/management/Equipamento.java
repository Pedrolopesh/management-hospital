package com.management;

public class Equipamento {
    private String nomeEquipamento;
    private int qntEquipamento;

    public Equipamento(String nomeEquipamento, int qntEquipamento){
        this.nomeEquipamento = nomeEquipamento;
        this.qntEquipamento = qntEquipamento;
    }

    public int getQntEquipamento(){
        return qntEquipamento;
    }

    public boolean setQntEquipamento(){
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
}
