package com.management;
import com.management.ItemFuncionarioPaciente.Item;


public class Paciente extends Item {
    private int idade;
    private double altura;
    private double peso;
    private String comorbidade;
    private String diagnostico;
    private boolean isolamento;
    private String necessidade;
    private String statusPaciente;
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
    public Paciente (){

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

    public String imformacaoPacientes() {
        String texto = "";
        texto = texto + super.toString();
        texto = texto + "Idade: " + this.getIdade() + ", \n";
        texto = texto + "Altura: " + this.getAltura() + ", \n";
        texto = texto + "Peso: " + this.getPeso() + ", \n";
        texto = texto + "Comorbidades: " + this.getComorbidade() + ", \n";
        texto = texto + "Diagnóstico: " + this.getDiagnostico() + ", \n";
        texto = texto + "Isolamento: " + this.getIsolamento() + ", \n";
        texto = texto + "Necessidades: " + this.getNecessidade() + ", \n";
        texto = texto + "Status do paciente: " + this.getStatusPaciente() + ", \n";
        texto = texto + "Funcionário atendido por: " + this.getFuncionarioAtendimento() + ", \n";
        return texto;
    }

    @Override
    public void atendimento(String funcionarioAtendimento) {
        this.funcionarioAtendimento = funcionarioAtendimento;
    }

    public String getFuncionarioAtendimento() {
        return this.funcionarioAtendimento;
    }

    @Override
    public String toString() {
        String texto = "";
        texto = texto + super.toString();
        return texto;
    }
}
