package com.management.View.LeitoHospitalar;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.management.Controller.LeitoController;
import com.management.Model.Classes.LeitoHospitalar;
import com.management.Model.Classes.Paciente;
import com.management.Model.Tables.LeitoTables;
import com.management.View.Paciente.PacienteListaUI;
import com.management.View.PrincipalUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class LeitoListaUI extends JFrame {
    private JPanel mainPanel;
    private LeitoFormUI leitoFormUI;
    private JTable JTable;
    private PrincipalUI mainUI;
    private LeitoController leitoController = new LeitoController(this.leitoFormUI);
    private LeitoTables leitoTables;

    public LeitoListaUI(PrincipalUI principalUI){
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(750, 250));
        this.setContentPane(mainPanel);
        this.pack();
        createTable();

    }

    public void createTable() {
        try {
            List<LeitoHospitalar> leitoHospitalarList = new ArrayList<>();

            ArrayList<LeitoHospitalar> leitoHospitalarArrayList;

            leitoHospitalarArrayList = this.leitoController.getLeitos();

            for (LeitoHospitalar umLeito : leitoHospitalarArrayList) {
                leitoHospitalarList.add( new LeitoHospitalar(umLeito.getNomeLeito(), umLeito.getIdLeito(), umLeito.getOcupado()) );
            }

            LeitoTables leitoTables = new LeitoTables(leitoHospitalarList);
            JTable.setModel(leitoTables);
            JTable.setAutoCreateRowSorter(true);

        } catch (java.sql.SQLException SQLException) {
            System.out.println(SQLException);

        } catch (ClassNotFoundException ClassNotFoundException) {
            System.out.println(ClassNotFoundException);
        }
    }

}
