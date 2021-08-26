package com.management;

import com.management.ItemFuncionarioPaciente.Item;

import java.util.ArrayList;

public class Equipe {
    private String nomeEquipe;
    private int idEquipe;
    private String liderEquipe;
    private String statusEquipe;
    private ArrayList<Funcionario> funcionarios;

    public Equipe(String nomeEquipe, int idEquipe, String statusEquipe){
        this.nomeEquipe = nomeEquipe;
        this.idEquipe = idEquipe;
        this.funcionarios = new ArrayList<Funcionario>();
        this.statusEquipe = statusEquipe;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public String getLiderEquipe() {
        return liderEquipe;
    }

    public boolean setNomeEquipe(String nomeEquipe) {
        if(nomeEquipe.isEmpty()){
            return false;
        }
        this.nomeEquipe = nomeEquipe;
        return true;
    }

    public boolean setLiderEquipe(String liderEquipe) {
        if(liderEquipe.isEmpty()){
            return false;
        }
        this.liderEquipe = liderEquipe;
        return true;
    }

    public String getStatusEquipe(){
        return this.statusEquipe;
    }

    public boolean setStatusEquipe(String statusEquipe) {
        if(statusEquipe.isEmpty()){
            return false;
        }
        this.statusEquipe = statusEquipe;
        return true;
    }

    public void addFuncionario(Funcionario umFuncionario){
        this.funcionarios.add(umFuncionario);
    }

    public void removeFuncionario(Funcionario umFuncionario){
        this.funcionarios.remove(umFuncionario);
    }

    public String toString(){
        String texto = "";
        texto = texto + "ID da equipe: "+this.getIdEquipe()+", \n";
        texto = texto + "nomeEquipe: "+this.getNomeEquipe()+", \n";
        texto = texto + "Lider da equipe: "+this.getLiderEquipe()+", \n";
        return texto;
    }

    public String imprimeFuncionarios(){
        String texto = "";
        texto = texto + "--- Informações das Equipes --- \n";
        texto = texto + toString();
        texto = texto + "--- Funcionarios da equipe --- \n";
        for(Item it : this.funcionarios){
            texto = texto + it.toString();
        }
        return texto;
    }
}
