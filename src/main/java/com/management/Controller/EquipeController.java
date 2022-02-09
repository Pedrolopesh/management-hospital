package com.management.Controller;

import com.management.Model.Classes.Equipe;
import com.management.Model.Classes.Funcionario;

import java.sql.*;
import java.util.ArrayList;

public class EquipeController {

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
