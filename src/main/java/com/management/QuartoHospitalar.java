package com.management;

import java.util.ArrayList;

public class QuartoHospitalar {
    private String nomeQuarto;
    private int idQuarto;
    private int numLeitos;
    private int numPacientes;
    private ArrayList<LeitoHospitalar> leitoHospitalares;

    public QuartoHospitalar(String nomeQuarto, int idQuarto, int numLeitos, int numPacientes){
        this.nomeQuarto = nomeQuarto;
        this.idQuarto = idQuarto;
        this.numLeitos = numLeitos;
        this.numPacientes = numPacientes;
        this.leitoHospitalares = new ArrayList<LeitoHospitalar>();
    }

    public String getNomeQuarto(){
        return nomeQuarto;
    }

    public int getIdQuarto(){
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

    public int getNumPacientes(){
        return numPacientes;
    }

    public boolean setNumPacientes(int numPacientes){
        if (numPacientes < 0){
            return false;
        }
        this.numPacientes = numPacientes;
        return true;
    }

    public void addLeitoHospitalar(LeitoHospitalar leitoHospitalares){
       this.leitoHospitalares.add(leitoHospitalares);
    }

    public void imprimeLeitoHospitalar(){
        System.out.println("--- Todos os Leitos ---");
        for (LeitoHospitalar leitoHospitalers : this.leitoHospitalares);
        System.out.println(leitoHospitalares.toString());
    }
    public String toString(){
        String texto = "";
        texto = texto + "ID do quarto: "+this.getIdQuarto()+", \n";
        texto = texto + "Nome do quarto: "+this.getNomeQuarto()+", \n";
        texto = texto + "Número de leitos: "+this.getNumLeitos()+", \n";
        texto = texto + "Número de pacientes: "+this.getNumPacientes()+", \n";
        return texto;
    }
}
