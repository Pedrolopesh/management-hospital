package com.management.Model.Classes;

import com.management.Controller.ItemFuncionarioPaciente.Item;

public class Funcionario extends Item {
    private String email;
    private String cargo;
    private String statusFuncionario;
    private String pacientesAtendidos;
    private String password;

    public Funcionario(String nome, String email, String id, String telefone, String cargo, String statusFuncionario, String pacientesAtendidos, String password) {
        super(nome, id, telefone);
        this.email = email;
        this.cargo = cargo;
        this.statusFuncionario = statusFuncionario;
        this.pacientesAtendidos = pacientesAtendidos;
        this.password = password;
    }

    @Override
    public void atendimento(String pacienteAtendido) {
        this.pacientesAtendidos = pacienteAtendido;
    }

    public String getPacientesAtendidos() {
        return this.pacientesAtendidos;
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
        return this.cargo;
    }


    public String getEmail() { return  this.email; }

    public String getPassword() { return this.password; }

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
