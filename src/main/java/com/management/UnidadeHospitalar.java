package com.management;

import java.util.ArrayList;

public class UnidadeHospitalar {
    private String nomeUnidade;
    private int idUnidadeHospitalar;
    private String especialidade;
    private ArrayList<Equipe> equipes;
    private ArrayList<QuartoHospitalar> quartoHospitalars;

    public UnidadeHospitalar(String nomeUnidade, int idUnidadeHospitalar, String especialidade){
        this.nomeUnidade = nomeUnidade;
        this.idUnidadeHospitalar = idUnidadeHospitalar;
        this.especialidade = especialidade;
        this.equipes = new ArrayList<Equipe>();
        this.quartoHospitalars = new ArrayList<QuartoHospitalar>();
    }

    public int getIdUnidadeHospitalar() {
        return idUnidadeHospitalar;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public boolean setNomeUnidade(String nomeUnidade) {
        if(nomeUnidade.isEmpty()){
            return false;
        }
        this.nomeUnidade = nomeUnidade;
        return true;
    }

    public boolean setEspecialidade(String especialidade) {
        if(especialidade.isEmpty()){
            return false;
        }
        this.especialidade = especialidade;
        return true;
    }

    public void addQuartoHospitalar(QuartoHospitalar umQuartoHospitalar){
        this.quartoHospitalars.add(umQuartoHospitalar);
    }

    public void addEquipe(Equipe umaEquipe){
        this.equipes.add(umaEquipe);
    }

    public void imprimeQuarto(){
        System.out.println("--- Todos os quartos ---");
        for (QuartoHospitalar umQuarto: this.quartoHospitalars){
            System.out.println(umQuarto.toString());
        }
    }

    public void imprimeQuarto(int idQuarto){
        System.out.println("--- Quarto Hospitalar ---");
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

    public void imprimeEquipe(){
        System.out.println("--- Todas as Equipes ---");
        for (Equipe umaEquipe : this.equipes){
            System.out.println(umaEquipe.toString());
        }
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
}
