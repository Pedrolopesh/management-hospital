package com.management.View.Especialidade;

import com.management.Controller.EspecialidadeController;
import com.management.Model.Classes.Equipe;
import com.management.Model.Classes.Especialidade;
import com.management.View.Equipe.EquipeListaUI;
import com.management.View.PrincipalUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeListaUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea txTextShow;
    private JTable JTable;
    private EspecialidadeController especialidadeController = new EspecialidadeController();
    //PrincipalUI = classe principal com todas as ligações entre outras telas
    //mainUI = nome do atributo que é do TIPO PrincipalUI
    private PrincipalUI mainUI;
    // Construtor
    public EspecialidadeListaUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(400, 200));
        this.setContentPane(mainPanel);
        this.pack();

        createTable();
    }

    public void createTable() throws SQLException, ClassNotFoundException {
        try{
            List<Especialidade> especialidadeList = new ArrayList<>();

            ArrayList<Especialidade> especialidadeArrayList;

            especialidadeArrayList = this.especialidadeController.getEspecialidades();

            for(Especialidade umaEspecialidade : especialidadeArrayList){
                especialidadeList.add(new Especialidade(umaEspecialidade.getIdEspecialidade(), umaEspecialidade.getNomeEspecialidade() ));
            }

            EspecialidadeModel especialidadeModel = new EspecialidadeModel(especialidadeList);
            JTable.setModel(especialidadeModel);
            JTable.setAutoCreateRowSorter(true);

        }catch (SQLException SQLException){
            System.out.println(SQLException);

        }catch (ClassNotFoundException ClassNotFoundException){
            System.out.println(ClassNotFoundException);
        }
    }


    public static class EspecialidadeModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Id especialidade", "nome especialidade"};
        private List<Especialidade> especialidadeList;

        public EspecialidadeModel(List<Especialidade> especialidades){
            this.especialidadeList = especialidades;
        }

        @Override
        public int getRowCount() {
            return this.especialidadeList.size();
        }

        @Override
        public int getColumnCount() {
            return this.COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> especialidadeList.get(rowIndex).getIdEspecialidade();
                case 1 -> especialidadeList.get(rowIndex).getNomeEspecialidade();
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
