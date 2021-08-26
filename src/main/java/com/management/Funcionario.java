package com.management;

import com.management.ItemFuncionarioPaciente.Item;

public class Funcionario extends Item {
    private String cargo;
    private String statusFuncionario;

    public Funcionario(String nome, int id, String telefone) {
        super(nome, id, telefone);
    }

    public String getStatusFuncionario() {
        return statusFuncionario;
    }

    public boolean setStatusFuncionario(String statusFuncionario) {
        if(statusFuncionario.isEmpty()){
            return false;
        }
        this.statusFuncionario = statusFuncionario;
        return true;
    }

    public String getCargo() {
        return cargo;
    }

    public boolean setCargo(String cargo){
        if(cargo.isEmpty()){
            return false;
        }
        this.cargo = cargo;
        return true;
    }

    @Override
    public String toString(){
        String texto = "";
        texto = texto + super.toString();
        texto =  texto + "Cargo: " + this.getCargo()+", \n";
        return texto;
    }
}
