package com.management.Controller;


import com.management.Model.Classes.Funcionario;
import com.management.Model.Classes.LeitoHospitalar;
import com.management.Model.Classes.Paciente;
import com.management.Model.Classes.QuartoHospitalar;
import com.management.utils.Uuid;

import java.sql.*;
import java.util.ArrayList;

public class PacienteController{
    private Uuid uuid = new Uuid();

    public void salvarDadosPaciente(Paciente newPaciente) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String id = newPaciente.getId();
            String nome = newPaciente.getNome();
            String telefone = newPaciente.getTelefone();
            double idade = newPaciente.getIdade();
            double altura = newPaciente.getAltura();
            double peso = newPaciente.getPeso();
            String diagnostico = newPaciente.getDiagnostico();
            String isolamento = newPaciente.getIsolamento();
            String necessidade = newPaciente.getNecessidade();
            String statusPaciente = newPaciente.getStatusPaciente();
            String comorbidade = newPaciente.getComorbidade();
            String funcionarioAntedimento = newPaciente.getFuncionarioAtendimento();

            PreparedStatement ps = conn.prepareStatement(
                    "insert into pacientes " +
                            "(id, nome, telefone, idade, altura, peso, diagnostico, isolamento, necessidade, statusPaciente, comorbidade, funcionarioAntedimento) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, id);
            ps.setString(2, nome);
            ps.setString(3, telefone);
            ps.setDouble(4, idade);
            ps.setDouble(5, altura);
            ps.setDouble(6, peso);
            ps.setString(7, diagnostico);
            ps.setString(8, isolamento);
            ps.setString(9, necessidade);
            ps.setString(10, statusPaciente);
            ps.setString(11, comorbidade);
            ps.setString(12, funcionarioAntedimento);

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


    public ArrayList<Paciente> getPacientes() throws ClassNotFoundException, SQLException {
        ArrayList<Paciente> pacientesList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from pacientes");

        Paciente paciente;

        while(rs.next()){
            paciente = new Paciente( rs.getString("nome"), rs.getString("id"), rs.getString("telefone"), rs.getInt("idade"), rs.getDouble("altura"), rs.getDouble("peso"), rs.getString("comorbidade"), rs.getString("diagnostico"), rs.getString("isolamento"),  rs.getString("necessidade"), rs.getString("statusPaciente"));

            pacientesList.add(paciente);
        }

        st.closeOnCompletion();
        return pacientesList;
    }


    public void internarPacienteLeito(LeitoHospitalar leitoSelecionado, Paciente pacienteSelecionado, Funcionario funcionarioSelecionado) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            String leito = leitoSelecionado.getIdLeito();
            String paciente = pacienteSelecionado.getId();
            String funcionario = funcionarioSelecionado.getNome();

            System.out.println(leito);
            System.out.println(paciente);
            System.out.println(funcionario);

            PreparedStatement ps1 = conn.prepareStatement("update pacientes SET leito=? , statusPaciente='internado' , funcionarioAntedimento=? where id=? ");
            ps1.setString(1, leito);
            ps1.setString(2, funcionario);
            ps1.setString(3, paciente);
            ps1.executeUpdate();
            ps1.closeOnCompletion();

            PreparedStatement ps2 = conn.prepareStatement("update leitos SET ocupado=true where idLeito=?");
            ps2.setString(1, leito);
            ps2.executeUpdate();
            ps2.closeOnCompletion();

        } catch (SQLException throwables) {
            System.out.println("SQLException");
            throwables.printStackTrace();

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("classNotFoundException");
            classNotFoundException.printStackTrace();
        }
    }

    public int pacientesInternados() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select COUNT(leito) from pacientes where statusPaciente = 'internado';");

            int total = 0;
            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println(total);
            return total;

        }catch (SQLException throwables) {
            System.out.println("SQLException");
            throwables.printStackTrace();

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("classNotFoundException");
            classNotFoundException.printStackTrace();
        }
        return 0;
    }

    public int pacientesAguardando() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s03_prog02_database","root", "root");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select COUNT(ocupado) from leitos where ocupado= false;");

            int total = 0;
            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println(total);
            return total;

        }catch (SQLException throwables) {
            System.out.println("SQLException");
            throwables.printStackTrace();

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("classNotFoundException");
            classNotFoundException.printStackTrace();
        }
        return 0;
    }

}
