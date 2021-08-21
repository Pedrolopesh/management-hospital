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
        texto =  texto + "Cargo: " + this.getCargo()+", \n";
        return texto + super.toString();
    }

//    public void imprimeFuncionario(){
//        System.out.println("--- Todos os Funcionários ---");
//        for (Funcionario umFuncionario : this.funcionarios){
//            System.out.println(umFuncionario.toString());
//        }
//
//        String texto = "nomeEquipe: "+this.getNomeEquipe()+", \n";
//        texto = texto + "ID da equipe: "+this.getIdEquipe()+", \n";
//        texto = texto + "Lider da equipe: "+this.getLiderEquipe()+", \n";
//        for(Item it : this.funcionarios){
//            texto = texto + it.toString();
//            System.out.println(texto);
//        }
//    }
}
