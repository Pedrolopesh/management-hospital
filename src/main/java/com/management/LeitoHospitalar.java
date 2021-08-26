package com.management;

import java.util.ArrayList;

public class LeitoHospitalar {
    private int idLeito;
    private boolean ocupado;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Equipamento> equipamentos;

    public LeitoHospitalar ( int idLeito){
        this.idLeito = idLeito;

        this.pacientes = new ArrayList<Paciente>();
        this.equipamentos = new ArrayList<Equipamento>();
    }

    public int getIdLeito(){
        return idLeito;
    }

    public boolean getOcupado(){
        return ocupado;
    }

    public boolean setOcupado(boolean ocupado){
        this.ocupado = ocupado;
        return true;
    }

    public void addPaciente(Paciente umPaciente){
        this.pacientes.add(umPaciente);
    }
    public void addEquipamento(Equipamento equipamentos){this.equipamentos.add(equipamentos);}

    public String imformacao(){
        String texto = "";
        texto = texto + "ID do leito :"+ this.idLeito + " \n";
        texto = texto + "Ocupado ? "+ this.ocupado+ " \n";
        for (Paciente umPaciente : this.pacientes){
            texto = texto + "\n *** Paciente no leito *** \n";
            texto = texto + umPaciente.imformacaoPacientes();
        }
        return texto;
    }

    public String toString(){
        String texto = "";
        texto = texto + "ID do leito :"+ this.idLeito + " \n";
        texto = texto + "Ocupado ?"+ this.ocupado+ " \n";
        return texto;
    }
    //ADICIONAR METODOS IMPRIME LeitoHospitalar():String
    //ADICIONAR METODOS IMPRIME LeitoHospitalar(ocupado:boolen):String

}
