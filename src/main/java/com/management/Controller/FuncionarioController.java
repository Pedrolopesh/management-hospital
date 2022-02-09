package com.management.Controller;

import com.management.Model.Classes.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class FuncionarioController extends Component {



    public void salvarDadosFuncionario(Funcionario newFuncionario) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String id = newFuncionario.getId();
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

            ps.setString(1, id);
            ps.setString(2, nome);
            ps.setString(3, telefone);
            ps.setString(4, email);
            ps.setString(5, cargo);
            ps.setString(6, statusFuncionario);
            ps.setString(7, pacientesAtendidos);
            ps.setString(8, password);

            ps.executeUpdate();
//            JOptionPane.showMessageDialog(this, "Insert Sucessfully");

        } catch (SQLException throwables) {
            System.out.println("SQLException");
            throwables.printStackTrace();

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("classNotFoundException");
            classNotFoundException.printStackTrace();
        }
    }

    public ArrayList<Funcionario> getFuncionarios() throws ClassNotFoundException, SQLException {
        ArrayList<Funcionario> funcionarioList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

        PreparedStatement ps = conn.prepareStatement("select * from funcionarios");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from funcionarios");

        Funcionario funcionario;

        while(rs.next()){
            funcionario = new Funcionario(
                    rs.getString("id"), rs.getString("nome"),
                    rs.getString("telefone"), rs.getString("email"),
                    rs.getString("cargo"), rs.getString("statusFuncionario"),
                    rs.getString("pacientesAtendidos"), rs.getString("password")
            );

            funcionarioList.add(funcionario);
        }

        return funcionarioList;
    }

    public void addFuncionarioEquipe(String idFuncioarioParam, String idEquipeParam) throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String idFuncioario = idFuncioarioParam;
            String idEquipe = idEquipeParam;

            PreparedStatement ps = conn.prepareStatement("update funcionarios SET funcionarios_equipes= ? where id= ?");

            ps.setString(1, idEquipe);
            ps.setString(2, idFuncioario);

            ps.executeUpdate();

        } catch (SQLException throwables) {
            System.out.println("SQLException");
            throwables.printStackTrace();

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("classNotFoundException");
            classNotFoundException.printStackTrace();
        }
    }
}
