package com.management;

import com.management.ItemFuncionarioPaciente.Item;

public class Funcionario extends Item {
    private String cargo;

    public Funcionario(String nome, int id, String telefone) {
        super(nome, id, telefone);
    }

    public String getCargo() {
        return cargo;
    }
}
