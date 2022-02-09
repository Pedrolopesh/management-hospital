package com.management.Controller;

import com.management.Model.Classes.Paciente;
import com.management.Model.Entities.PacienteEntitie;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PacienteController extends Component {


    public void salvarDadosPaciente(Paciente paciente) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            PreparedStatement ps = conn.prepareStatement(
                    "insert into paciente " +
                            "(id, nome, telefone, idade, altura, peso, diagnostico, isolamento, necessidade, statusPaciente, comorbidade, funcionarioAntedimento) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, paciente.getId());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getTelefone());
            ps.setInt(4, paciente.getIdade());
            ps.setDouble(5, paciente.getAltura());
            ps.setDouble(6, paciente.getPeso());
            ps.setString(7, paciente.getDiagnostico());
            ps.setString(8, paciente.getIsolamento());
            ps.setString(9, paciente.getNecessidade());
            ps.setString(10,paciente.getStatusPaciente());
            ps.setString(11,paciente.getComorbidade());
            ps.setString(12,paciente.getFuncionarioAtendimento());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Insert Sucessfully");

//            ResultSet rs = stmt.executeQuery("select idequipamento, nomeEquipamento, qntEquipamento from equipamento;");
//            System.out.println(rs);

        } catch (Exception e){
            System.out.println(e);
        }
    }


}
