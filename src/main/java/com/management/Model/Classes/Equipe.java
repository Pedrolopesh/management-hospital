package com.management.Model.Classes;

import com.management.Controller.ItemFuncionarioPaciente.Item;

import java.util.ArrayList;

public class Equipe {
    private String nomeEquipe;
    private String idEquipe;
    private String liderEquipe;
    private String statusEquipe;
    private ArrayList<Funcionario> funcionarios;

    public Equipe(String nomeEquipe, String idEquipe, String statusEquipe, String liderEquipe){
        this.nomeEquipe = nomeEquipe;
        this.idEquipe = idEquipe;
        this.funcionarios = new ArrayList<Funcionario>();
        this.statusEquipe = statusEquipe;
        this.liderEquipe = liderEquipe;
    }

    public String getIdEquipe() {
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
        try {
            this.funcionarios.add(umFuncionario);
        }catch (Exception ex){
            System.err.printf("%s\n\n" , ex.getMessage());
            ex.printStackTrace();

            StackTraceElement[] traceElements = ex.getStackTrace();
            System.out.println("\n StackTrace:");
        }
    }

    public void removeFuncionario(Funcionario umFuncionario){
        this.funcionarios.remove(umFuncionario);
    }

    public String toString(){
        String texto = "";
        texto = texto + "nomeEquipe: "+this.getNomeEquipe()+", \n";
        return texto;
    }

}
