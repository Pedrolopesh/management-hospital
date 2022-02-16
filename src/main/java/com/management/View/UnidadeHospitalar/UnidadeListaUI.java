package com.management.View.UnidadeHospitalar;

import com.management.Controller.UnidadeHospitalarController;
import com.management.Model.Classes.Funcionario;
import com.management.View.Funcionario.FuncionarioListaUI;
import com.management.View.PrincipalUI;
import com.management.Model.Classes.UnidadeHospitalar;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadeListaUI extends JFrame{
    private JPanel mainPanel;
    private JTextArea txShowList;
    private JTable JTable;
    private PrincipalUI mainUI;
    private UnidadeHospitalarController unidadeHospitalarController = new UnidadeHospitalarController();

    public UnidadeListaUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(300, 300));
        this.setContentPane(mainPanel);
        this.pack();
        createTable();
    }

    public void createTable() throws SQLException, ClassNotFoundException {
        try{
            List<UnidadeHospitalar> unidadeHospitalarList = new ArrayList<>();

            ArrayList<UnidadeHospitalar> unidadeHospitalarArrayList;

            unidadeHospitalarArrayList = this.unidadeHospitalarController.getUnidades();

            for(UnidadeHospitalar umaUnidade : unidadeHospitalarArrayList){
                unidadeHospitalarList.add(new UnidadeHospitalar(umaUnidade.getNomeUnidade(), umaUnidade.getIdUnidadeHospitalar()));
            }

            UnidadeModel unidadeModel = new UnidadeModel(unidadeHospitalarList);
            JTable.setModel(unidadeModel);
            JTable.setAutoCreateRowSorter(true);
//            FuncionarioListaUI.FuncionarioModel funcionarioModel = new FuncionarioListaUI.FuncionarioModel(unidadeHospitalarList);
//            JTable.setModel(funcionarioModel);
//            JTable.setAutoCreateRowSorter(true);

        }catch (SQLException SQLException){
            System.out.println(SQLException);

        }catch (ClassNotFoundException ClassNotFoundException){
            System.out.println(ClassNotFoundException);
        }
    }

    public static class UnidadeModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Id Unidade", "nome da unidade"};
        private List<UnidadeHospitalar> unidadeHospitalarList;

        public UnidadeModel(List<UnidadeHospitalar> unidadeHospitalars){
            this.unidadeHospitalarList = unidadeHospitalars;
        }

        @Override
        public int getRowCount() {
            return this.unidadeHospitalarList.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> unidadeHospitalarList.get(rowIndex).getIdUnidadeHospitalar();
                case 1 -> unidadeHospitalarList.get(rowIndex).getNomeUnidade();
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
