package com.management.Controller;

import com.management.Model.Classes.LeitoHospitalar;
import com.management.Model.Classes.QuartoHospitalar;

import java.sql.*;
import java.util.ArrayList;

public class LeitoController {

    public void salvarDadosLeito(LeitoHospitalar newLeito) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String id = newLeito.getIdLeito();
            boolean ocupado = newLeito.getOcupado();

            PreparedStatement ps = conn.prepareStatement(
                    "insert into leitos " +
                            "(idLeito, ocupado) values (?, ?)"
            );

            ps.setString(1, id);
            ps.setBoolean(2, ocupado);

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

    public ArrayList<LeitoHospitalar> getLeitos() throws ClassNotFoundException, SQLException {
        ArrayList<LeitoHospitalar> leitoHospitalarsList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from leitos");

        LeitoHospitalar leitoHospitalar;

        while(rs.next()){
            leitoHospitalar = new LeitoHospitalar(rs.getString("idLeito"), rs.getBoolean("ocupado"));

            leitoHospitalarsList.add(leitoHospitalar);
        }

        st.closeOnCompletion();
        return leitoHospitalarsList;
    }

    public void salvarDadosLeitoWithQuarto(LeitoHospitalar newLeito, String SelectedQuarto) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String id = newLeito.getIdLeito();
            boolean ocupado = newLeito.getOcupado();
            String quarto_leito = SelectedQuarto;

            PreparedStatement ps = conn.prepareStatement(
                    "insert into leitos " +
                            "(idLeito, ocupado, quarto_leito) values (?, ?, ?)"
            );

            ps.setString(1, id);
            ps.setBoolean(2, ocupado);
            ps.setString(3, quarto_leito);

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
}
