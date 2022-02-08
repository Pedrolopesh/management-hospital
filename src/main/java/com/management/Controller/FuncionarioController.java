package com.management.Controller;

import com.management.Model.Classes.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FuncionarioController extends Component {

    public void salvarDadosFuncionario(Funcionario newFuncionario) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");


            int id = newFuncionario.getId();
            String nome = newFuncionario.getNome();
            String telefone = newFuncionario.getTelefone();
            String cargo = newFuncionario.getCargo();
            String email = newFuncionario.getEmail();
            String password = newFuncionario.getPassword();
            String statusFuncionario = newFuncionario.getStatusFuncionario();
            String pacientesAtendidos = newFuncionario.getPacientesAtendidos();

            PreparedStatement ps = conn.prepareStatement(
                    "insert into funcionarios " +
                            "(id, nome, telefone, email, cargo, statusFuncionario, pacientesAtendidos, password) values (?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, telefone);
            ps.setString(4, email);
            ps.setString(5, cargo);
            ps.setString(6, statusFuncionario);
            ps.setString(7, pacientesAtendidos);
            ps.setString(8, password);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Insert Sucessfully");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    public int checkIdBeforeAdd(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id FROM funcionarios ORDER BY ID DESC LIMIT 1;");

            System.out.println("SELECT RESULT:");
            System.out.println(rs);
            return 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;

        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
            return 0;
        }
    }
}
