package com.management;

public class LeitoHospitalar {
    private int idLeito;
    private String equipamento;
    boolean ocupado;

    public LeitoHospitalar ( boolean ocupado, int idLeito, String equipamento){
        this.ocupado = ocupado;
        this.idLeito = idLeito;
        this.equipamento = equipamento;
    }

    public int getIdLeito(){
        return idLeito;
    }
    public String getEquipamento(){
        return equipamento;
    }
    public boolean setEquipamento(String equipamento){
        if(equipamento.isEmpty()){
            return false;
        }
        return true;
    }
    public boolean getOcupado(){
        return ocupado;
    }
    public boolean setOcupado(boolean ocupado){
        if (ocupado){
            return true;
        }
        return false;
    }
    //ADICIONAR METODOS IMPRIME LeitoHospitalar():String
    //ADICIONAR METODOS IMPRIME LeitoHospitalar(ocupado:boolen):String

}
