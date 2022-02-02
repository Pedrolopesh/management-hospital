package com.management.Model.Classes;

import com.management.View.Alerts.AlertaGeralUI;

public class Excessao extends Exception {

    public Excessao(String string){
        super(string);
    }

    public void ExcessaoAlertaGeral(String textoAlerta) throws Exception {
        AlertaGeralUI alertaGeralUI = new AlertaGeralUI(textoAlerta);
        alertaGeralUI.setVisible(true);
    }

}
