package com.management.DAO.LeitoDAO;

import com.management.DAO.ConnectionDB;
import com.management.Model.Classes.Equipamento;
import com.management.Model.Classes.LeitoHospitalar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeitoDAO {

    public static boolean saveLeitoDB (LeitoHospitalar newLeito){
        Connection connectionDB = ConnectionDB.getConnection();
        String sql = "insert into leitos (idLeito, nomeLeito, ocupado) values (?, ?, ?)";
        PreparedStatement ps;

        try {
            ps = connectionDB.prepareStatement(sql);
            ps.setString(1, newLeito.getIdLeito());
            ps.setString(2, newLeito.getNomeLeito());
            ps.setBoolean(3, newLeito.getOcupado());
            ps.executeUpdate();

            System.out.println("Leito cadastrado sucesso!");

            final ResultSet result = ps.getGeneratedKeys();
            if (result.next()) {
                String id = result.getString(1);
                newLeito.setidLeito(id);
            }
            return true;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean saveLeitoWithEquipmentDB (LeitoHospitalar newLeito, Equipamento equipamentoSelecionado, String SelectedQuarto){
        Connection connectionDB = ConnectionDB.getConnection();
        String firstSql = "insert into leitos (idLeito, nomeLeito, ocupado, quarto_leito) values (?, ?, ?, ?)";
        String secondSql = "update equipamentos SET leito_equipamento=? where idequipamento=?";
        PreparedStatement ps;
        PreparedStatement secondps;
        try {
            ps = connectionDB.prepareStatement(firstSql);
            ps.setString(1, newLeito.getIdLeito());
            ps.setString(2, newLeito.getNomeLeito());
            ps.setBoolean(3, newLeito.getOcupado());
            ps.setString(4, SelectedQuarto);
            ps.executeUpdate();

            secondps = connectionDB.prepareStatement(secondSql);
            secondps.setString(1, newLeito.getIdLeito());
            secondps.setString(2, equipamentoSelecionado.getIdEquipamento());

            secondps.executeUpdate();
            secondps.executeUpdate();

            System.out.println("Leito cadastrado sucesso!");

            return true;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
