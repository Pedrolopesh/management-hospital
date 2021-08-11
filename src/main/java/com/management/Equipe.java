package com.management;

import java.util.ArrayList;

public class Equipe {
    private String nomeEquipe;
    private int idEquipe;
    private String liderEquipe;
    private ArrayList<Funcionario> funcionarios;

    public Equipe(String nomeEquipe, int idEquipe, String liderEquipe){
        this.nomeEquipe = nomeEquipe;
        this.idEquipe = idEquipe;
        this.liderEquipe = liderEquipe;
        this.funcionarios = new ArrayList<Funcionario>();
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

    public void addFuncionario(Funcionario umFuncionario){
        this.funcionarios.add(umFuncionario);
    }
}
