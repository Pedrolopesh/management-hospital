package com.management;

public class QuartoHospitalar {
    private String nomeQuarto;
    private int idQuarto;
    private int numLeitos;
    private int numPacientes;

    public QuartoHospitalar(String nomeQuarto, int idQuarto, int numLeitos, int numPacientes){
        this.nomeQuarto = nomeQuarto;
        this.idQuarto = idQuarto;
        this.numLeitos = numLeitos;
        this.numPacientes = numPacientes;
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
}
