package com.management.Controller;

import com.management.Model.Classes.Equipe;
import com.management.Model.Classes.Funcionario;

import java.sql.*;
import java.util.ArrayList;

public class EquipeController {


    public void salvarDadosEquipe(Equipe newEquipe) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String id = newEquipe.getIdEquipe();
            String nome = newEquipe.getNomeEquipe();
            String status = newEquipe.getStatusEquipe();
            String liderEquipe = newEquipe.getLiderEquipe();


            PreparedStatement ps = conn.prepareStatement(
                    "insert into equipes " +
                            "(id, nomeEquipe, liderEquipe, statusEquipe ) values (?, ?, ?, ?)"
            );

            ps.setString(1, id);
            ps.setString(2, nome);
            ps.setString(3, liderEquipe);
            ps.setString(4, status);

            ps.executeUpdate();
            ps.closeOnCompletion();
//            JOptionPane.showMessageDialog(this, "Insert Sucessfully");

        } catch (SQLException throwables) {
            System.out.println("SQLException");
            throwables.printStackTrace();

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("classNotFoundException");
            classNotFoundException.printStackTrace();
        }
    }

    public ArrayList<Equipe> getEquipes() throws ClassNotFoundException, SQLException {
        ArrayList<Equipe> equipeList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from equipes");

        Equipe equipe;

        while(rs.next()){
            equipe = new Equipe(
                    rs.getString("nomeEquipe"), rs.getString("id"),
                    rs.getString("liderEquipe"), rs.getString("statusEquipe")
            );

            equipeList.add(equipe);
        }

        return equipeList;
    }
}
