package com.management;

import com.management.UI.Alerts.AlertaGeralUI;

public class Excessao extends Exception {

    public Excessao(String string){
        super(string);
    }

    public void ExcessaoAlertaGeral(String textoAlerta) throws Exception {
        AlertaGeralUI alertaGeralUI = new AlertaGeralUI(textoAlerta);
        alertaGeralUI.setVisible(true);
    }

}
