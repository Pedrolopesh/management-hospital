package com.management.Controller;

import com.management.DAO.LeitoDAO.LeitoDAO;
import com.management.Model.Classes.Equipamento;
import com.management.Model.Classes.LeitoHospitalar;
import com.management.Model.Classes.QuartoHospitalar;
import com.management.View.LeitoHospitalar.LeitoFormUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import com.management.DAO.LeitoDAO.LeitoDAO;

public class LeitoController {
    private LeitoFormUI leitoFormUI;
    private LeitoHospitalar leitoHospitalar;

    public LeitoController(LeitoFormUI leitoFormUI){
        this.leitoFormUI = leitoFormUI;
    }


    public void salvarLeito() {
        leitoHospitalar = new LeitoHospitalar(leitoFormUI.dadosNovoLeito().getNomeLeito(), leitoFormUI.dadosNovoLeito().getIdLeito(), leitoFormUI.dadosNovoLeito().getOcupado() );

//        if(validarPaciente()){
            if(LeitoDAO.saveLeitoDB(leitoHospitalar)){
                this.leitoFormUI.showAlert("Leito cadastrado com successo!");
            }else{
                this.leitoFormUI.showAlert("Erro ao cadastrar leito!");
            }
//        }else{
//            this.leitoFormUI.showAlert("Erro ao cadastrar leito!");
//        }
    }

//    public boolean validarPaciente(){
//        if (this.leitoHospitalar.getNomeLeito().equals(""))
//            return false;
//        if (this.leitoHospitalar.getIdLeito().equals(""))
//            return false;
//        return true;
//    }

    public void salvarDadosLeito(LeitoHospitalar newLeito) {

//        if(validarPaciente()){
            if(LeitoDAO.saveLeitoDB(newLeito)){
//                this.leitoFormUI.showAlert("Leito cadastrado com successo!");
            }else{
//                this.leitoFormUI.showAlert("Erro ao cadastrar leito!");
            }
//        }else{
//            this.leitoFormUI.showAlert("Erro ao cadastrar leito!");
//        }

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");
//
//            String id = newLeito.getIdLeito();
//            boolean ocupado = newLeito.getOcupado();
//            String NomeLeito = newLeito.getNomeLeito();
//
//            PreparedStatement ps = conn.prepareStatement(
//                    "insert into leitos (idLeito, nomeLeito, ocupado) values (?, ?, ?)"
//            );
//
//            ps.setString(1, id);
//            ps.setString(2, NomeLeito);
//            ps.setBoolean(3, ocupado);
//
//            ps.executeUpdate();
//            ps.closeOnCompletion();
//
//        } catch (SQLException throwables) {
//            System.out.println("SQLException");
//            throwables.printStackTrace();
//
//        } catch (ClassNotFoundException classNotFoundException) {
//            System.out.println("classNotFoundException");
//            classNotFoundException.printStackTrace();
//        }
    }

    public ArrayList<LeitoHospitalar> getLeitos() throws ClassNotFoundException, SQLException {
        ArrayList<LeitoHospitalar> leitoHospitalarsList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from leitos");

        LeitoHospitalar leitoHospitalar;

        while(rs.next()){
            leitoHospitalar = new LeitoHospitalar(rs.getString("nomeLeito"), rs.getString("idLeito"), rs.getBoolean("ocupado"));

            leitoHospitalarsList.add(leitoHospitalar);
        }

        st.closeOnCompletion();
        return leitoHospitalarsList;
    }

    public void salvarDadosLeitoWithQuartoEquipamento(LeitoHospitalar newLeito, Equipamento equipamentoSelecionado, String SelectedQuarto) {
        System.out.println("foi =>" + LeitoDAO.saveLeitoWithEquipmentDB(newLeito, equipamentoSelecionado, SelectedQuarto));

//        if(validarPaciente()){
            if(LeitoDAO.saveLeitoWithEquipmentDB(newLeito, equipamentoSelecionado, SelectedQuarto)){
                this.leitoFormUI.showAlert("Leito cadastrado com successo!");
            }else{
                this.leitoFormUI.showAlert("Erro ao cadastrar leito!");
            }
//        }else{
//            this.leitoFormUI.showAlert("Erro ao cadastrar leito!");
//        }
    }
}
