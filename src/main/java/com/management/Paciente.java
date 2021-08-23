package com.management;

import com.management.ItemFuncionarioPaciente.Item;

public class Paciente extends Item {
    private int idade;
    private double altura;
    private double peso;
    private boolean comorbidade;
    private String diagnostico;
    private boolean isolamento;
    private String necessidade;

    public Paciente(String nome, int id, String telefone, int idade, double altura, double peso, boolean comorbidade, String diagnostico, boolean isolamento, String necessidade){
        super(nome, id, telefone);
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.comorbidade = comorbidade;
        this.diagnostico = diagnostico;
        this.isolamento = isolamento;
        this.necessidade = necessidade;
    }


    public int getIdade(){
        return idade;
    }


    public boolean setIdade(int idade) {
        if(idade < 0){
            return false;
        }
        this.idade = idade;
        return true;
    }


    public double getAltura() {
        return altura;
    }


    public boolean setAltura(double altura){
        if(altura < 0){
            return false;
        }
        this.altura = altura;
        return true;
    }


    public double getPeso() {
        return peso;
    }


    public boolean setPeso(double peso){
        if(peso < 0){
            return false;
        }
        this.peso = peso;
        return true;
    }


    public boolean getComorbidade(){
        return comorbidade;
    }


    public boolean setComorbidade(boolean comorbidade){
        this.comorbidade = comorbidade;
        return true;
    }


    public String getDiagnostico(){
        return diagnostico;
    }


    public boolean setDiagnostico(String diagnostico){
        if(diagnostico.isEmpty()){
            return false;
        }
        return true;
    }


    public boolean getIsolamento(){
        return isolamento;
    }


    public boolean setIsolamento(boolean isolamento){
        this.isolamento = isolamento;
        return true;
    }


    public String getNecessidade(){
        return necessidade;
    }


    public boolean setNecessidade(String necessidade){
        if(necessidade.isEmpty()){
            return false;
        }
        this.necessidade = necessidade;
        return true;
    }

    @Override
    public String toString(){
        String texto = "";
        texto = texto + super.toString();
        texto = texto + "Idade: " + this.getIdade() + ", \n";
        texto = texto + "Altura: " + this.getAltura() + ", \n";
        texto = texto + "Peso: " + this.getPeso() + ", \n";
        texto = texto + "Comorbidades: " + this.getComorbidade() + ", \n";
        texto = texto + "Diagnóstico: " + this.getDiagnostico() + ", \n";
        texto = texto + "Isolamento: " + this.getIsolamento() + ", \n";
        texto = texto + "Necessidades: " + this.getNecessidade() + ", \n";
        return texto;
    }
}
