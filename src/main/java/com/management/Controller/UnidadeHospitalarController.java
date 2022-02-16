package com.management.Controller;

import com.management.Model.Classes.Equipe;
import com.management.Model.Classes.UnidadeHospitalar;

import java.sql.*;
import java.util.ArrayList;

public class UnidadeHospitalarController {

    public void salvarDadosUnidade(UnidadeHospitalar newUnidadeHospitalar) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String id = newUnidadeHospitalar.getIdUnidadeHospitalar();
            String nome = newUnidadeHospitalar.getNomeUnidade();
            String especialidade = newUnidadeHospitalar.getEspecialidade();

            PreparedStatement ps = conn.prepareStatement(
                    "insert into unidades " +
                            "(id, especialidade, nome ) values (?, ?, ?)"
            );

            ps.setString(1, id);
            ps.setString(2, especialidade);
            ps.setString(3, nome);

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

    public ArrayList<UnidadeHospitalar> getUnidades() throws ClassNotFoundException, SQLException {
        ArrayList<UnidadeHospitalar> unidadeHospitalarList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from unidades");

        UnidadeHospitalar unidadeHospitalar;

        while(rs.next()){
            unidadeHospitalar = new UnidadeHospitalar(rs.getString("nome"), rs.getString("id"));

            unidadeHospitalarList.add(unidadeHospitalar);
        }

        return unidadeHospitalarList;

    }
}
