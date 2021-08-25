package com.management;

import java.util.ArrayList;

public class LeitoHospitalar {
    private int idLeito;
    private String equipamento;
    private boolean ocupado;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Equipamento> equipamentos;

    public LeitoHospitalar ( boolean ocupado, int idLeito, String equipamento){
        this.ocupado = ocupado;
        this.idLeito = idLeito;
        this.equipamento = equipamento;
        this.pacientes = new ArrayList<Paciente>();
        this.equipamentos = new ArrayList<Equipamento>();
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
    public void addEquipamento(Equipamento equipamentos){this.equipamentos.add(equipamentos);}

    public void imprimePacientes(){
        System.out.println("--- Todos os pacientes ---");
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
    public void imprimeEquipamento(String nomeEquipamento){
        System.out.println("--- Todos os Equipamentos  ---");
        for(Equipamento umEquipamento : this.equipamentos){
            System.out.println(umEquipamento.toString());
        }
    }

    public String toString(){
        String texto = "";
        texto = texto + "Ocupado ?"+ this.ocupado+ " \n";
        texto = texto + "ID do leito :"+ this.idLeito + " \n";
        texto = texto + "Equipamentos do leito :"+this.equipamento;
        return texto;
    }
    //ADICIONAR METODOS IMPRIME LeitoHospitalar():String
    //ADICIONAR METODOS IMPRIME LeitoHospitalar(ocupado:boolen):String

}
