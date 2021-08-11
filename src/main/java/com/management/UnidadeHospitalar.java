package com.management;

import java.util.ArrayList;

public class UnidadeHospitalar {
    private String nomeUnidade;
    private int idUnidadeHospitalar;
    private String especialidade;
    private ArrayList<Equipe> equipes;

    UnidadeHospitalar(String nomeUnidade, int idUnidadeHospitalar, String especialidade){
        this.nomeUnidade = nomeUnidade;
        this.idUnidadeHospitalar = idUnidadeHospitalar;
        this.especialidade = especialidade;
        this.equipes = new ArrayList<Equipe>();
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

    public void addEquipe(){

    }
}
