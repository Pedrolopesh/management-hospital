package com.management.Controller;

import com.management.Model.Entities.PacienteEntitie;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PacienteController extends Component {


    public void salvarDadosPaciente(PacienteEntitie pacienteEntitie) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");



            PreparedStatement ps = conn.prepareStatement(
                    "insert into paciente values " +
                            "(id, nome, telefone, idade, altura, peso, diagnostico, isolamento, necessidade, statusPaciente, comorbidade, funcionarioAntedimento) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

//            ps.setInt(1, nextid);
//            ps.setString(2, nome);
//            ps.setString(3, telefone);
//            ps.setInt(4, idade);
//            ps.setDouble(5, altura);
//            ps.setDouble(6, peso);
//            ps.setString(7, diagnostico);
//            ps.setString(8, isolamento);
//            ps.setString(9, necessidade);
//            ps.setString(10, statusPaciente);
//            ps.setString(11, comorbidade);
//            ps.setString(12, funcionarioAntedimento);



            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Insert Sucessfully");

//            ResultSet rs = stmt.executeQuery("select idequipamento, nomeEquipamento, qntEquipamento from equipamento;");
//            System.out.println(rs);

        } catch (Exception e){
            System.out.println(e);
        }
    }


}
