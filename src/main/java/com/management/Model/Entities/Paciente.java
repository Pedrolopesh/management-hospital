package com.management.Model.Entities;

import com.management.Controller.ItemFuncionarioPaciente.Item;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Paciente extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idade", nullable = false)
    private int idade;

    @Column(name = "altura", nullable = false)
    private double altura;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "comorbidade", nullable = false)
    private String comorbidade;

    @Column(name = "diagnostico", nullable = false)
    private String diagnostico;

    @Column(name = "isolamento", nullable = false)
    private boolean isolamento;

    @Column(name = "necessidade", nullable = false)
    private String necessidade;

    @Column(name = "statusPaciente", nullable = false)
    private String statusPaciente;

    @Column(name = "funcionarioAtendimento", nullable = false)
    private String funcionarioAtendimento;

    public Paciente(String nome, int id, String telefone, int idade, double altura, double peso, String comorbidade, String diagnostico, boolean isolamento, String necessidade, String statusPaciente) {
        super(nome, id, telefone);
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.comorbidade = comorbidade;
        this.diagnostico = diagnostico;
        this.isolamento = isolamento;
        this.necessidade = necessidade;
        this.statusPaciente = statusPaciente;
    }

    @Override
    public void atendimento(String funcionarioAtendimento) {
        this.funcionarioAtendimento = funcionarioAtendimento;
    }
}
