package com.management.Controller;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PacienteController extends Component {


    public void salvarDadosPaciente(
            String nome, int nextid, String telefone, int idade, double altura, double peso, String comorbidade,
            String diagnostico, boolean isolamento, String necessidade, String statusPaciente
    ) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");
            Statement stmt = conn.createStatement();

            System.out.println(new Object[]{nextid, nome, telefone, idade, altura, peso, diagnostico, isolamento, necessidade, statusPaciente, comorbidade});
            PreparedStatement ps = conn.prepareStatement(
                    "insert into paciente values (id, nome, telefone, idade, altura, peso, diagnostico, isolamento, necessidade, statusPaciente, comorbidade, funcionarioAntedimento) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)"
            );

//            PreparedStatement ps = conn.prepareStatement(
//                    "insert into paciente values (id, nome, telefone, altura, idade, peso, diagnostico, isolamento, necessidade, comorbidade, statusPaciente, funcionarioAntedimento); values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)"
//            );

//            PreparedStatement ps = conn.prepareStatement("insert into equipamento(idequipamento,nomeEquipamento,qntEquipamento) values (?, ?, ?)");

            ps.setInt(1, nextid);
            ps.setString(2, nome);
            ps.setString(3, telefone);
            ps.setInt(4, idade);
            ps.setDouble(5, altura);
            ps.setDouble(6, peso);
            ps.setString(7, diagnostico);
            ps.setBoolean(8, isolamento);
            ps.setString(9, necessidade);
            ps.setString(10, statusPaciente);
//            ps.setString(11, comorbidade);



            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Insert Sucessfully");

            ResultSet rs = stmt.executeQuery("select idequipamento, nomeEquipamento, qntEquipamento from equipamento;");
            System.out.println(rs);

        } catch (Exception e){
            System.out.println(e);
        }
    }


}
