package com.management.Controller;

import com.management.Model.Classes.Especialidade;
import com.management.Model.Classes.QuartoHospitalar;

import java.sql.*;
import java.util.ArrayList;

public class QuartoController {

    public void salvarDadosQuarto(QuartoHospitalar newQuarto) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String id = newQuarto.getIdQuarto();
            String nomeQuarto = newQuarto.getNomeQuarto();
            int quantLeitos = newQuarto.getNumLeitos();

            PreparedStatement ps = conn.prepareStatement(
                    "insert into quartos " +
                            "(idQuarto, nome, quantLeitos) values (?, ?, ?)"
            );

            ps.setString(1, id);
            ps.setString(2, nomeQuarto);
            ps.setInt(3, quantLeitos);

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            System.out.println("SQLException");
            throwables.printStackTrace();

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("classNotFoundException");
            classNotFoundException.printStackTrace();
        }
    }

    public ArrayList<QuartoHospitalar> getQuartos() throws ClassNotFoundException, SQLException {
        ArrayList<QuartoHospitalar> quartosList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from quartos");

        QuartoHospitalar quartoHospitalar;

        while(rs.next()){
            quartoHospitalar = new QuartoHospitalar(rs.getString("nome"), rs.getString("idQuarto"), rs.getInt("quantLeitos"));

            quartosList.add(quartoHospitalar);
        }

        st.closeOnCompletion();
        return quartosList;
    }
}
