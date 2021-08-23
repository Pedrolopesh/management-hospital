package com.management;

import java.util.ArrayList;

public class LeitoHospitalar {
    private int idLeito;
    private String equipamento;
    private boolean ocupado;
    private ArrayList<Paciente> pacientes;

    public LeitoHospitalar ( boolean ocupado, int idLeito, String equipamento){
        this.ocupado = ocupado;
        this.idLeito = idLeito;
        this.equipamento = equipamento;
        this.pacientes = new ArrayList<Paciente>();
    }

    public int getIdLeito(){
        return idLeito;
    }

    public String getEquipamento(){
        return equipamento;
    }

    public boolean setEquipamento(String equipamento){
        if(equipamento.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean getOcupado(){
        return ocupado;
    }

    public boolean setOcupado(boolean ocupado){
        if (ocupado){
            return true;
        }
        return false;
    }

    public void addPaciente(Paciente umPaciente){
        this.pacientes.add(umPaciente);
    }

    public void imprimePacientes(){
        System.out.println("--- Todas os pacientes ---");
        for (Paciente umPaciente : this.pacientes){
            System.out.println(umPaciente.toString());
        }
    }

    public void imprimePacientes(int idPaciente){
        System.out.println("--- Informações do paciente ---");
        for (Paciente umPaciente : this.pacientes){
            if(umPaciente.getId() == idPaciente){
                System.out.println(umPaciente.toString());
            }
        }
    }

    public void imprimePacientes(String nomePaciente){
        System.out.println("--- Informações do paciente ---");
        for (Paciente umPaciente : this.pacientes){
            if(umPaciente.getNome().equals(nomePaciente)){
                System.out.println(umPaciente.toString());
            }
        }
    }

    public void imprimePacientes(boolean comorbidade){
        System.out.println("--- Pacientes com comorbidade ---");
        for (Paciente umPaciente : this.pacientes){
            if(umPaciente.getComorbidade() == comorbidade){
                System.out.println(umPaciente.toString());
            }
        }
    }

    public void imprimePacientesIsolados(boolean isolamento){
        System.out.println("--- Pacientes em isolamento ---");
        for (Paciente umPaciente : this.pacientes){
            if(umPaciente.getIsolamento() == isolamento){
                System.out.println(umPaciente.toString());
            }
        }
    }
    //ADICIONAR METODOS IMPRIME LeitoHospitalar():String
    //ADICIONAR METODOS IMPRIME LeitoHospitalar(ocupado:boolen):String

}
