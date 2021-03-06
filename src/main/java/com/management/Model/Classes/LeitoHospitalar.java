package com.management.Model.Classes;

import java.util.ArrayList;


public class LeitoHospitalar implements Comparable <LeitoHospitalar>{
    private String idLeito;
    private boolean ocupado;
    private String nomeLeito;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente paciente;
    private ArrayList<Equipamento> equipamentos;

    public LeitoHospitalar(String nomeLeito, String idLeito, boolean ocupado) {
        this.nomeLeito = nomeLeito;
        this.idLeito = idLeito;
        this.paciente = new Paciente();
        this.ocupado = ocupado;
        this.equipamentos = new ArrayList<Equipamento>();
    }

    public String getNomeLeito() {
        return this.nomeLeito;
    }

    public void setNomeLeito(String nomeLeito) {
        this.nomeLeito = nomeLeito;
    }

    public String getIdLeito() {
        return idLeito;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public boolean setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
        return true;
    }


    public void setidLeito(String idLeito) {
        this.idLeito = idLeito;
    }

    public void addEquipamento(Equipamento equipamentos) {
        this.equipamentos.add(equipamentos);
    }

    public String imformacao() {
        String texto = "";
        texto = texto + "ID do leito :" + this.idLeito + " \n";
        texto = texto + "Ocupado ? " + this.ocupado + " \n";
        texto = texto + "\n * Paciente no leito * \n";
        texto = texto + this.paciente.imformacaoPacientes();
        return texto;
    }

    public String toString() {
        String texto = "";
        texto = texto + "Leito:" + this.nomeLeito + " \n";
        return texto;
    }

    public int compareTo(LeitoHospitalar leitoHospitalar) {
        if (this.paciente.getIdade() < leitoHospitalar.getPaciente().getIdade()) {
            return -1;
        } else if (this.paciente.getIdade() > leitoHospitalar.getPaciente().getIdade()) {
            return +1;
        }
        return 0;
    }
    // ADICIONAR METODOS IMPRIME LeitoHospitalar():String
    // ADICIONAR METODOS IMPRIME LeitoHospitalar(ocupado:boolen):String

}