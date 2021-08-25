package com.management;

public class Especialidade {
    private String nomeEspecialidade;
    private int idEspecialidade;

    public Especialidade(String nomeEspecialidade, int idEspecialidade){
        this.nomeEspecialidade = nomeEspecialidade;
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

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    @Override
    public String toString() {
        String texto = "";
        texto = texto + "id: "+this.getIdEspecialidade()+", \n";
        texto = texto + "especialidade: "+this.getNomeEspecialidade()+"\n";
        return texto;
    }
}
