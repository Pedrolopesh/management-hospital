package com.management.Model.Classes;

import com.management.Controller.ItemFuncionarioPaciente.Item;

public class Funcionario {
    private String id;
    private String nome;
    private String telefone;
    private String email;
    private String cargo;
    private String statusFuncionario;
    private String pacientesAtendidos;
    private String password;

    public Funcionario(String id, String nome, String telefone, String email, String cargo, String statusFuncionario, String pacientesAtendidos, String password) {
//        super(nome, id, telefone);
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cargo = cargo;
        this.statusFuncionario = statusFuncionario;
        this.pacientesAtendidos = pacientesAtendidos;
        this.password = password;
    }

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

    public String getNome() {
        return this.nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return this.id;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPacientesAtendidos(String pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

    public void setPassword(String password) {
        this.password = password;
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
        texto = texto + "Nome: " + this.getId();
        texto =  texto + " - email: " + this.getEmail();
        return texto;
    }
}
