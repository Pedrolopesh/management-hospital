package com.management.View.Equipe;

import com.management.Controller.EquipeController;
import com.management.Controller.FuncionarioController;
import com.management.Model.Classes.Equipe;
import com.management.Model.Classes.Funcionario;
import com.management.View.Funcionario.FuncionarioListaUI;
import com.management.View.PrincipalUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeListaUI extends JFrame {
    private JPanel mainPanel;
    private PrincipalUI mainUI;
    private JTextArea txTextShow;
    private JTable JTable;
    private FuncionarioController funcionarioController;
    private EquipeController equipeController = new EquipeController();

    public EquipeListaUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        createTable();
//        for(Equipe umaEquipe: this.mainUI.getEquipes()){
//            txTextShow.append(umaEquipe.imprimeFuncionarios());
//            txTextShow.append("\n");
//        }
    }

    public void createTable() throws SQLException, ClassNotFoundException {
        try{
            List<Equipe> equipeList = new ArrayList<>();

            ArrayList<Equipe> equipeArrayList;

            equipeArrayList = this.equipeController.getEquipes();

            for(Equipe umEquipe : equipeArrayList){
                equipeList.add(new Equipe(umEquipe.getNomeEquipe(), umEquipe.getIdEquipe(), umEquipe.getStatusEquipe(), umEquipe.getLiderEquipe()));
            }

            EquipeModel equipeModel = new EquipeModel(equipeList);
            JTable.setModel(equipeModel);
            JTable.setAutoCreateRowSorter(true);

        }catch (SQLException SQLException){
            System.out.println(SQLException);

        }catch (ClassNotFoundException ClassNotFoundException){
            System.out.println(ClassNotFoundException);
        }
    }

    public static class EquipeModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Id equipe", "nome equipe", "status Equipe", "lider equipe" };
        private List<Equipe> equipeList;

        public EquipeModel(List<Equipe> equipes){
            this.equipeList = equipes;
        }

        @Override
        public int getRowCount() {
            return this.equipeList.size();
        }

        @Override
        public int getColumnCount() {
            return this.COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> equipeList.get(rowIndex).getIdEquipe();
                case 1 -> equipeList.get(rowIndex).getNomeEquipe();
                case 2 -> equipeList.get(rowIndex).getLiderEquipe();
                case 3 -> equipeList.get(rowIndex).getStatusEquipe();
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
