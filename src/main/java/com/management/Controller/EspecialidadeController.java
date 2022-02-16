package com.management.Controller;

import com.management.Model.Classes.Equipe;
import com.management.Model.Classes.Especialidade;
import com.management.Model.Classes.UnidadeHospitalar;

import java.sql.*;
import java.util.ArrayList;

public class EspecialidadeController {

    public void salvarDadosEspecialidade(Especialidade newEspecialidade) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String id = newEspecialidade.getIdEspecialidade();
            String nomeEspecialidade = newEspecialidade.getNomeEspecialidade();

            PreparedStatement ps = conn.prepareStatement(
                    "insert into especialidades " +
                            "(idEspecialidade, nomeEspecialidade ) values (?, ?)"
            );

            ps.setString(1, id);
            ps.setString(2, nomeEspecialidade);

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

    public ArrayList<Especialidade> getEspecialidades() throws ClassNotFoundException, SQLException {
        ArrayList<Especialidade> especialidadesList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from especialidades");

        Especialidade especialidade;

        while(rs.next()){
            especialidade = new Especialidade(rs.getString("idEspecialidade"), rs.getString("nomeEspecialidade"));

            especialidadesList.add(especialidade);
        }

        return especialidadesList;
    }
}
