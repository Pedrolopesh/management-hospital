package com.management.Model.Entities;

import com.management.Controller.ItemFuncionarioPaciente.Item;

import javax.persistence.*;
import java.util.Date;

public class PacienteEntitie extends Item {
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

    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public PacienteEntitie(String nome, int id, String telefone, int idade, double altura, double peso, String comorbidade, String diagnostico, boolean isolamento, String necessidade, String statusPaciente) {
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

    public int getIdade() {
        return idade;
    }


    public String getStatusPaciente() {
        return this.statusPaciente;
    }

    public boolean setStatusPaciente(String statusPaciente) {
        if (statusPaciente.isEmpty()) {
            return false;
        }
        this.statusPaciente = statusPaciente;
        return true;
    }

    public boolean setIdade(int idade) {
        if (idade < 0) {
            return false;
        }
        this.idade = idade;
        return true;
    }


    public double getAltura() {
        return altura;
    }


    public boolean setAltura(double altura) {
        if (altura < 0) {
            return false;
        }
        this.altura = altura;
        return true;
    }


    public double getPeso() {
        return peso;
    }


    public boolean setPeso(double peso) {
        if (peso < 0) {
            return false;
        }
        this.peso = peso;
        return true;
    }


    public String getComorbidade() {
        return comorbidade;
    }


    public boolean setComorbidade(String comorbidade) {
        if (comorbidade.isEmpty()) {
            return false;
        }
        this.comorbidade = comorbidade;
        return true;
    }


    public String getDiagnostico() {
        return diagnostico;
    }


    public boolean setDiagnostico(String diagnostico) {
        if (diagnostico.isEmpty()) {
            return false;
        }
        return true;
    }


    public boolean getIsolamento() {
        return isolamento;
    }


    public boolean setIsolamento(boolean isolamento) {
        this.isolamento = isolamento;
        return true;
    }


    public String getNecessidade() {
        return necessidade;
    }


    public boolean setNecessidade(String necessidade) {
        if (necessidade.isEmpty()) {
            return false;
        }
        this.necessidade = necessidade;
        return true;
    }

    public String getFuncionarioAtendimento() { return this.funcionarioAtendimento; }

    @Override
    public void atendimento(String funcionarioAtendimento) {
        this.funcionarioAtendimento = funcionarioAtendimento;
    }
}
