package com.management;

import java.util.ArrayList;

public class UnidadeHospitalar {
    private String nomeUnidade;
    private int idUnidadeHospitalar;
    private String especialidade;
    private ArrayList<Equipe> equipes;
    private ArrayList<QuartoHospitalar> quartoHospitalars;
    private ArrayList<Especialidade> especialidades;

    public UnidadeHospitalar(String nomeUnidade, int idUnidadeHospitalar){
        this.nomeUnidade = nomeUnidade;
        this.idUnidadeHospitalar = idUnidadeHospitalar;
        this.equipes = new ArrayList<Equipe>();
        this.quartoHospitalars = new ArrayList<QuartoHospitalar>();
        this.especialidades = new ArrayList<Especialidade>();
    }

    public String getEspecialidade(){
        return this.especialidade;
    }

    public boolean setEspecialidade(String especialidade){
        if(especialidade.isEmpty()){
            return false;
        }
        this.especialidade = especialidade;
        return true;
    }

    public int getIdUnidadeHospitalar() {
        return idUnidadeHospitalar;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public boolean setNomeUnidade(String nomeUnidade) {
        if(nomeUnidade.isEmpty()){
            return false;
        }
        this.nomeUnidade = nomeUnidade;
        return true;
    }

    public void addQuartoHospitalar(QuartoHospitalar umQuartoHospitalar){
        this.quartoHospitalars.add(umQuartoHospitalar);
    }

    public void addEquipe(Equipe umaEquipe){
        this.equipes.add(umaEquipe);
    }

    public void addEspecialidades(Especialidade especialidades){
        this.especialidades.add(especialidades);
    }

    public String imprimeQuarto(){
        String texto = "";
        texto = texto + "--- Quarto da Unidade --- \n";
        for (QuartoHospitalar umQuarto: this.quartoHospitalars){
            texto = texto + umQuarto.toString();
        }
        return texto;
    }

    public void imprimeQuarto(int idQuarto){
        for (QuartoHospitalar umQuarto: this.quartoHospitalars){
            if(umQuarto.getIdQuarto() == idQuarto){
                System.out.println(umQuarto.toString());
            }
        }
    }

    public void imprimeQuarto(String nomeQuarto){
        System.out.println("--- Quarto Hospitalar por nome ---");
        for (QuartoHospitalar umQuarto: this.quartoHospitalars){
            if(umQuarto.getNomeQuarto().equals(nomeQuarto)){
                System.out.println(umQuarto.toString());
            }
        }
    }

    public String imprimeEquipe(){
        String texto = "";
        texto = texto + "--- Equipes da Unidade --- \n";
        for (Equipe umaEquipe : this.equipes){
            texto = texto + umaEquipe.toString();
        }
        return texto;
    }

    public void imprimeEquipe(int idEquipe){
        System.out.println("--- Unidade Hospitalar ---");
        for (Equipe umaEquipe : this.equipes){
            if(umaEquipe.getIdEquipe() == idEquipe)
            System.out.println(umaEquipe.toString());
        }
    }

    public void imprimeEquipe(String nomeEquipe){
        System.out.println("--- Unidade hospitalar por nome ---");
        for (Equipe umaEquipe : this.equipes){
            if(umaEquipe.getNomeEquipe().equals(nomeEquipe))
                System.out.println(umaEquipe.toString());
        }
    }

    @Override
    public String toString() {
        String texto = "";
        texto = texto + "ID: " + this.getIdUnidadeHospitalar() + ", \n";
        texto = texto + "Nome Unidade: " + this.getNomeUnidade() + ", \n";
        texto = texto + "Especialidade: " + this.getEspecialidade() + ", \n";
        return texto;
    }
}
