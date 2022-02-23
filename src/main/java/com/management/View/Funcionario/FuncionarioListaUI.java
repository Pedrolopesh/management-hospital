package com.management.View.Funcionario;

import com.management.Controller.FuncionarioController;
import com.management.Model.Classes.Equipamento;
import com.management.Model.Classes.Funcionario;
import com.management.Model.Classes.FuncionarioComparator;
import com.management.View.Equipamento.EquipamentoListaUI;
import com.management.View.PrincipalUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuncionarioListaUI extends JFrame {
    private JPanel mainPanel;
    private JTable JTable;
    private PrincipalUI mainUI;
    private FuncionarioController funcionarioController;

    public FuncionarioListaUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;
        FuncionarioController funcionarioController = new FuncionarioController();
        this.funcionarioController = funcionarioController;
        FuncionarioComparator comparator = new FuncionarioComparator();
        Collections.sort(this.mainUI.getFuncionarios(), comparator);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setContentPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(600, 200));
        this.pack();

        createTable();

    }

    public void createTable() throws SQLException, ClassNotFoundException {
        try{
            List<Funcionario> funcionarioList = new ArrayList<>();

            ArrayList<Funcionario> funcionarioArrayList;

            funcionarioArrayList = this.funcionarioController.getFuncionarios();

            for(Funcionario umfuncionario : funcionarioArrayList){
                funcionarioList.add(new Funcionario(umfuncionario.getId(), umfuncionario.getNome(), umfuncionario.getTelefone(), umfuncionario.getEmail(), umfuncionario.getCargo(), umfuncionario.getStatusFuncionario(), umfuncionario.getPacientesAtendidos(), ""));
            }

            FuncionarioModel funcionarioModel = new FuncionarioModel(funcionarioList);
            JTable.setModel(funcionarioModel);
            JTable.setAutoCreateRowSorter(true);

        }catch (SQLException SQLException){
            System.out.println(SQLException);

        }catch (ClassNotFoundException ClassNotFoundException){
            System.out.println(ClassNotFoundException);
        }
    }

    public static class FuncionarioModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Id Funcionario", "nome", "telefone", "Cargo", "Status", "Pacientes Atendidos"};
        private List<Funcionario> funcionarioList;


        public FuncionarioModel(List<Funcionario> funcionarios) {
            this.funcionarioList = funcionarios;
        }

        @Override
        public int getRowCount() {
            return this.funcionarioList.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> funcionarioList.get(rowIndex).getNome();
                case 1 -> funcionarioList.get(rowIndex).getId();
                case 2 -> funcionarioList.get(rowIndex).getTelefone();
                case 3 -> funcionarioList.get(rowIndex).getCargo();
                case 4 -> funcionarioList.get(rowIndex).getStatusFuncionario();
                case 5 -> funcionarioList.get(rowIndex).getPacientesAtendidos();
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
