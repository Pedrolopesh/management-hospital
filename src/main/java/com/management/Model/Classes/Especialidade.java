package com.management.Model.Classes;

public class Especialidade {
    private String nomeEspecialidade;
    private String idEspecialidade;

    public Especialidade(String idEspecialidade, String nomeEspecialidade){
        this.idEspecialidade = idEspecialidade;
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public Especialidade(String idEspecialidade){
        this.nomeEspecialidade = null;
        this.idEspecialidade = idEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public boolean setNomeEspecialidade(String nomeEspecialidade) {
        if(nomeEspecialidade.isEmpty()){
            return false;
        }
        this.nomeEspecialidade = nomeEspecialidade;
        return true;
    }

    public String getIdEspecialidade() {
        return idEspecialidade;
    }

    @Override
    public String toString() {
        String texto = "";
        texto = texto + "especialidade: "+this.getNomeEspecialidade()+"\n";
        return texto;
    }
}
