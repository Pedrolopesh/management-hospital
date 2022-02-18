package com.management.Model.Classes;

import java.util.ArrayList;

public class QuartoHospitalar {
    private String nomeQuarto;
    private String idQuarto;
    private int numLeitos;
    private ArrayList<LeitoHospitalar> leitoHospitalares;

    public QuartoHospitalar(String nomeQuarto, String idQuarto, int numLeitos){
        this.nomeQuarto = nomeQuarto;
        this.idQuarto = idQuarto;
        this.numLeitos = numLeitos;
        this.leitoHospitalares = new ArrayList<LeitoHospitalar>();
    }

    public String getNomeQuarto(){
        return nomeQuarto;
    }

    public String getIdQuarto(){
        return idQuarto;
    }

    public int getNumLeitos(){
        return numLeitos;
    }

    public boolean setNumLeitos(int numLeitos) {
        if (numLeitos < 0) {
            return false;
        }
        this.numLeitos = numLeitos;
        return true;
    }

    public void addLeitoHospitalar(LeitoHospitalar leitoHospitalares){
       this.leitoHospitalares.add(leitoHospitalares);
    }

    public String informaLeitos(){
        String texto = "";
        texto = texto + toString();
        texto = texto + "\n *** Leitos da Unidade *** \n";
        for (LeitoHospitalar leitoHospitalers : this.leitoHospitalares){
            texto = texto + leitoHospitalers.toString();
        }
        texto = texto + "\n ************* \n";
        return texto;
    }



    public String toString(){
        String texto = "";
        texto = texto + "Nome do quarto: "+this.getNomeQuarto()+", \n";

        return texto;
    }
}
