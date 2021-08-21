package com.management.demo;

import com.management.Equipe;
import com.management.Funcionario;

public class ExecObjcts {

    public static void main(String[] args){
//        Funcionario fun1 = new Funcionario("Bob", 160, 6.15, 2);

        Equipe eqp1 = new Equipe("Equipe 1", 1,"Pedro");

        Funcionario fun1 = new Funcionario("Pedro", 1, "2");
        Funcionario fun2 = new Funcionario("Alisson", 2, "1");

        fun1.setCargo("Medico Geral");
        fun2.setCargo("Medico Cirurgião");

        eqp1.addFuncionario(fun1);
        eqp1.addFuncionario(fun2);

        eqp1.imprimeFuncionarios();
        eqp1.imprimeFuncionarios(1);
        eqp1.imprimeFuncionarios("Alisson");

    }
}
