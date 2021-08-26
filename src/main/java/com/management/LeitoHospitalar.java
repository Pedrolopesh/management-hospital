package com.management;

import java.util.ArrayList;

public class LeitoHospitalar {
    private int idLeito;
    private boolean ocupado;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Equipamento> equipamentos;

    public LeitoHospitalar ( boolean ocupado, int idLeito){
        this.ocupado = ocupado;
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

    public void imprimePacientesComorbidade(String comorbidade){
        System.out.println("--- Pacientes com comorbidade ---");
        for (Paciente umPaciente : this.pacientes){
            if(umPaciente.getComorbidade().equals(comorbidade)){
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
    public String imprimeEquipamento(){
        String texto = "";
        for(Equipamento umEquipamento : this.equipamentos){
            texto = texto + umEquipamento.toString();
        }
        return texto;
    }

    public String toString(){
        String texto = "";
        texto = texto + "Ocupado ?"+ this.ocupado+ " \n";
        texto = texto + "ID do leito :"+ this.idLeito + " \n";
        return texto;
    }
    //ADICIONAR METODOS IMPRIME LeitoHospitalar():String
    //ADICIONAR METODOS IMPRIME LeitoHospitalar(ocupado:boolen):String

}
