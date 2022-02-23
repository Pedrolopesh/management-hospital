package com.management.Model.Tables;

import com.management.Model.Classes.LeitoHospitalar;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LeitoTables extends AbstractTableModel {

    private final String[] COLUMNS = {"Id Leito", "nome leito", "ocupado?"};
    private List<LeitoHospitalar> leitoHospitalarList;

    public LeitoTables(List<LeitoHospitalar> leitoHospitalars) {
        this.leitoHospitalarList = leitoHospitalars;
    }

    @Override
    public int getRowCount() {
        return this.leitoHospitalarList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> leitoHospitalarList.get(rowIndex).getIdLeito();
            case 1 -> leitoHospitalarList.get(rowIndex).getNomeLeito();
            case 2 -> leitoHospitalarList.get(rowIndex).getOcupado();
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
