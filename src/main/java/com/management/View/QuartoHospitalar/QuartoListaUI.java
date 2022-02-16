package com.management.View.QuartoHospitalar;

import com.management.Controller.QuartoController;
import com.management.Model.Classes.Funcionario;
import com.management.Model.Classes.QuartoHospitalar;
import com.management.Model.Classes.UnidadeHospitalar;
import com.management.View.Funcionario.FuncionarioListaUI;
import com.management.View.PrincipalUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartoListaUI extends JFrame {
    private JPanel mainPanel;
    private JTable JTable;
    private PrincipalUI mainUI;
    private QuartoController quartoController = new QuartoController();

    public QuartoListaUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(600, 200));
        this.setContentPane(mainPanel);
        this.pack();
        createTable();

    }

    public void createTable() throws SQLException, ClassNotFoundException {
        try {
            List<QuartoHospitalar> quartoHospitalarList = new ArrayList<>();

            ArrayList<QuartoHospitalar> quartoHospitalarArrayList;

            quartoHospitalarArrayList = this.quartoController.getQuartos();

            for (QuartoHospitalar umQuarto : quartoHospitalarArrayList) {
                quartoHospitalarList.add(new QuartoHospitalar(umQuarto.getNomeQuarto(), umQuarto.getIdQuarto(), umQuarto.getNumLeitos()));
            }

            QuartoModel quartoModel = new QuartoModel(quartoHospitalarList);
            JTable.setModel(quartoModel);
            JTable.setAutoCreateRowSorter(true);

        } catch (SQLException SQLException) {
            System.out.println(SQLException);

        } catch (ClassNotFoundException ClassNotFoundException) {
            System.out.println(ClassNotFoundException);
        }
    }

    public static class QuartoModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Id Quarto", "nome do quarto", "Quantidade de leitos"};
        private List<QuartoHospitalar> quartoModelList;

        public QuartoModel(List<QuartoHospitalar> quartoHospitalars){
            this.quartoModelList = quartoHospitalars;
        }

        @Override
        public int getRowCount() {
            return this.quartoModelList.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> quartoModelList.get(rowIndex).getIdQuarto();
                case 1 -> quartoModelList.get(rowIndex).getNomeQuarto();
                case 2 -> quartoModelList.get(rowIndex).getNumLeitos();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0, columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            }else {
                return Object.class;
            }
        }
    }
}
