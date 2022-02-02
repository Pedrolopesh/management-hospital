package com.management.Model.Classes;

import java.util.ArrayList;


public class LeitoHospitalar implements Comparable <LeitoHospitalar>{
    private int idLeito;
    private boolean ocupado;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente paciente;
    private ArrayList<Equipamento> equipamentos;

    public LeitoHospitalar(int idLeito) {
        this.idLeito = idLeito;
        this.paciente = new Paciente();
        this.equipamentos = new ArrayList<Equipamento>();
    }


    public int getIdLeito() {
        return idLeito;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public boolean setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
        return true;
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
        texto = texto + "ID do leito :" + this.idLeito + " \n";
        texto = texto + "Ocupado ?" + this.ocupado + " \n";
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