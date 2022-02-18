package com.management.View.Paciente;
import com.management.Controller.PacienteController;
import com.management.Model.Classes.Paciente;
import com.management.Model.Classes.QuartoHospitalar;
import com.management.View.PrincipalUI;
import com.management.View.QuartoHospitalar.QuartoListaUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteListaUI extends JFrame{
    private JPanel mainPanel;
    private JTable JTable;
    private PrincipalUI mainUI;
    private PacienteController pacienteController = new PacienteController();

    public PacienteListaUI(PrincipalUI principalUI) throws SQLException, ClassNotFoundException {
        this.mainUI = principalUI;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(750, 250));
        this.setContentPane(mainPanel);
        this.pack();
        createTable();
    }

    public void createTable() {
        try {
            List<Paciente> pacienteList = new ArrayList<>();

            ArrayList<Paciente> pacienteArrayList;

            pacienteArrayList = this.pacienteController.getPacientes();

            for (Paciente umPaciente : pacienteArrayList) {
                pacienteList.add( new Paciente( umPaciente.getNome(), umPaciente.getId(), umPaciente.getTelefone(), umPaciente.getIdade(), umPaciente.getAltura(), umPaciente.getPeso(), umPaciente.getComorbidade(), umPaciente.getDiagnostico(), umPaciente.getIsolamento(), umPaciente.getNecessidade(), umPaciente.getStatusPaciente()) );
            }

            PacienteModel pacienteModel = new PacienteModel(pacienteList);
            JTable.setModel(pacienteModel);
            JTable.setAutoCreateRowSorter(true);

        } catch (SQLException SQLException) {
            System.out.println(SQLException);

        } catch (ClassNotFoundException ClassNotFoundException) {
            System.out.println(ClassNotFoundException);
        }
    }

    public static class PacienteModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Id Paciente", "nome", "telefone", "idade", "altura", "peso", "comorbidade", "Diagnóstico", "Isolamento", "Necessidade", "Status paciente"};
        private List<Paciente> pacienteList;

        public PacienteModel(List<Paciente> pacientes) {
            this.pacienteList = pacientes;
        }

        @Override
        public int getRowCount() {
            return this.pacienteList.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> pacienteList.get(rowIndex).getId();
                case 1 -> pacienteList.get(rowIndex).getNome();
                case 2 -> pacienteList.get(rowIndex).getTelefone();
                case 3 -> pacienteList.get(rowIndex).getIdade();
                case 4 -> pacienteList.get(rowIndex).getAltura();
                case 5 -> pacienteList.get(rowIndex).getPeso();
                case 6 -> pacienteList.get(rowIndex).getComorbidade();
                case 7 -> pacienteList.get(rowIndex).getDiagnostico();
                case 8 -> pacienteList.get(rowIndex).getIsolamento();
                case 9 -> pacienteList.get(rowIndex).getNecessidade();
                case 10 -> pacienteList.get(rowIndex).getStatusPaciente();
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
