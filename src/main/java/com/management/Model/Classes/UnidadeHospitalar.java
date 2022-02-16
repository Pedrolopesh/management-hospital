package com.management.Model.Classes;

import java.util.ArrayList;

public class UnidadeHospitalar {
    private String nomeUnidade;
    private String idUnidadeHospitalar;
    private String especialidade;
    private ArrayList<Equipe> equipes;
    private ArrayList<QuartoHospitalar> quartoHospitalars;
    private ArrayList<Especialidade> especialidades;

    public UnidadeHospitalar(String nomeUnidade, String idUnidadeHospitalar){
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

    public String getIdUnidadeHospitalar() {
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

    public String imprimeEquipe(){
        String texto = "";
        texto = texto + "--- Equipes da Unidade --- \n";
        for (Equipe umaEquipe : this.equipes){
            texto = texto + umaEquipe.toString();
        }
        return texto;
    }

    @Override
    public String toString() {
        String texto = "";
        texto = texto + "Unidade: " + this.getNomeUnidade() + ", \n";
        return texto;
    }
}
