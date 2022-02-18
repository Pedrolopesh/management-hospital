package com.management.View.Equipamento;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import com.management.Controller.EquipamentoController;
import com.management.Model.Classes.Equipamento;
import com.management.View.PrincipalUI;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoListaUI extends JFrame  {
    private JPanel mainPainel;
    private JTextArea txTextShow;
    private JTable JTable;
    private PrincipalUI mainUI;
    private EquipamentoController equipamentoController = new EquipamentoController();
    // Contrutor
    public EquipamentoListaUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPainel.setPreferredSize(new Dimension(300, 200));
        this.setContentPane(mainPainel);
        this.pack();

        createTable();

        for(Equipamento umEquipamento : this.mainUI.getEquipamentos()){
            //append = atribui item

            txTextShow.append(umEquipamento.toString());
            txTextShow.append("\n");
        }
    }

    public void createTable() throws SQLException, ClassNotFoundException {
        List<Equipamento> equipamentos = new ArrayList<>();
//        equipamentos.add(new Equipamento("item 1", 1, 1));
//        equipamentos.add(new Equipamento("item 2", 2, 2));
//        equipamentos.add(new Equipamento("item 3", 2, 3));
//        equipamentos.add(new Equipamento("item 4", 2, 4));

        for(Equipamento umEquipamento : this.equipamentoController.getEquipamentos()){
            equipamentos.add(new Equipamento(umEquipamento.getNomeEquipamento(), umEquipamento.getQntEquipamento(), umEquipamento.getIdEquipamento()));
        }


        EquipamentoModel equipamentoModel = new EquipamentoModel(equipamentos);
        JTable.setModel(equipamentoModel);
        JTable.setAutoCreateRowSorter(true);
    };

    public static class EquipamentoModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Id equipamento", "nome", "quantidade"};
        private List<Equipamento> equipamentoList;

        public EquipamentoModel(List<Equipamento> equipamentos) {
            this.equipamentoList = equipamentos;
        }

        @Override
        public int getRowCount() {
            return equipamentoList.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> equipamentoList.get(rowIndex).getIdEquipamento();
                case 1 -> equipamentoList.get(rowIndex).getNomeEquipamento();
                case 2 -> equipamentoList.get(rowIndex).getQntEquipamento();
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
