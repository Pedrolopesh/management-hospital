package com.management.Model.Classes;

public class Equipamento {
    private String nomeEquipamento;
    private int qntEquipamento;
    private String idEquipamento;

    public Equipamento(String nomeEquipamento, int qntEquipamento, String idEquipamento){
        this.nomeEquipamento = nomeEquipamento;
        this.qntEquipamento = qntEquipamento;
        this.idEquipamento = idEquipamento;
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
    public String getIdEquipamento(){
        return this.idEquipamento;
    }

    public String toString(){
        String texto = "";
        texto = texto + "equipamento: "+ this.getNomeEquipamento() + ", \n";
        texto = texto + "Quantidade: "+ this.getQntEquipamento() + ", \n";
        return texto;
    }
}
