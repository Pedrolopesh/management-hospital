package com.management.ItemFuncionarioPaciente;

public class Item {
    protected String nome;
    protected int id;
    protected String telefone;

    public Item(String nome, int id, String telefone){
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public boolean setNome(String nome) {
        if(nome.isEmpty()){
            return false;
        }
        this.nome = nome;
        return true;
    }

    public boolean setTelefone(String telefone) {
        if(telefone.isEmpty()){
            return false;
        }
        this.telefone = telefone;
        return true;
    }
}
