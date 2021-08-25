package com.management.demo;

import com.management.*;

public class Main {

    public static void main(String[] args){
//        Funcionario fun1 = new Funcionario("Bob", 160, 6.15, 2);

        Equipe eqp1 = new Equipe("Equipe 1", 1,"Pedro");
        Equipe eqp2 = new Equipe("Equipe 2", 2,"Alisson");

        Funcionario fun1 = new Funcionario("Pedro", 1, "2");
        Funcionario fun2 = new Funcionario("Alison", 2, "1");

//        fun1.setCargo("Medico Geral");
//        fun2.setCargo("Medico Cirurgião");

        eqp1.addFuncionario(fun1);
        eqp1.addFuncionario(fun2);

//        eqp1.imprimeFuncionarios();
        System.out.println(eqp1.toString());
//        eqp1.addFuncionario(fun2);

//        eqp1.imprimeFuncionarios();
//        eqp1.imprimeFuncionarios(1);
//        eqp1.imprimeFuncionarios("Alisson");

//        UnidadeHospitalar unit1 = new UnidadeHospitalar("D", 1, "Cirurgia");
//
//        QuartoHospitalar quart1 = new QuartoHospitalar("Quarto da unidade D", 1, 3, 0);
//
//        LeitoHospitalar leit1 = new LeitoHospitalar(false,1111,"respirador");
//        Paciente pac1 = new Paciente("Alison",172,"98431091",18,1.96,115,false,"Cancer terminal",false,"Consolo");
//        leit1.addPaciente(pac1);
//        leit1.imprimePacientes();
//        quart1.addLeitoHospitalar(leit1);
//        quart1.imprimeLeitoHospitalar();
//        System.out.println(quart1.toString());
//        unit1.addEquipe(eqp1);
//        unit1.addEquipe(eqp2);

//        unit1.addQuartoHospitalar(quart1);
//        unit1.imprimeEquipe();
//        unit1.imprimeQuarto();

     /*   Equipamento respirador = new Equipamento("Respirador", 3);
        respirador.toString();
        System.out.println(respirador.toString());
        leit1.addEquipamento(respirador);*/




    }
}
