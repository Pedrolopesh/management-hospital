package com.management;

import com.management.Controller.*;
import com.management.Model.Classes.*;
import com.management.View.PrincipalUI;
import com.management.utils.Uuid;

import javax.swing.*;
import java.sql.SQLException;


public class Main {
    private static Uuid generetedUidd;
//    private Uuid generetedUidd = new Uuid();

    private FuncionarioController funcionarioController = new FuncionarioController();
    private EquipeController equipeController = new EquipeController();
    private UnidadeHospitalarController unidadeHospitalarController = new UnidadeHospitalarController();
    private EspecialidadeController especialidadeController = new EspecialidadeController();
    private EquipamentoController equipamentoController = new EquipamentoController();
    private QuartoController quartoController = new QuartoController();
    private LeitoController leitoController = new LeitoController(null);
    private PacienteController pacienteController = new PacienteController();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        criarDadosTest();
    }


    public void criarDadosTest() throws SQLException, ClassNotFoundException {
        Especialidade especialidade1 = new Especialidade(generetedUidd.generateId(), "Clínico Geral");
        Especialidade especialidade2 = new Especialidade(generetedUidd.generateId(), "Cardiologia");
        Especialidade especialidade3 = new Especialidade(generetedUidd.generateId(), "Neurologia");
        Especialidade especialidade4 = new Especialidade(generetedUidd.generateId(), "Reumatologia");
        Especialidade especialidade5 = new Especialidade(generetedUidd.generateId(), "Cirurgia torácica");
        Especialidade especialidade6 = new Especialidade(generetedUidd.generateId(), "Outra");

        Equipamento equipamento1 = new Equipamento("Eletrocardiógrafos", 1, generetedUidd.generateId());
        Equipamento equipamento2 = new Equipamento("Ventilador pulmonar.", 2,generetedUidd.generateId());
        Equipamento equipamento3 = new Equipamento("Oxímetro", 3,generetedUidd.generateId());
        Equipamento equipamento4 = new Equipamento("Monitor multiparamétrico", 4,generetedUidd.generateId());
        Equipamento equipamento5 = new Equipamento("Desfibrilador", 5,generetedUidd.generateId());

        Funcionario funcionario1 = new Funcionario("Pedro Lopes", generetedUidd.generateId(),"1234567890", "pedrolopeshls@gmail.com", "Medico Geral", "ativo", "", "123123");
        Funcionario funcionario2 = new Funcionario("Alisson Gabriel", generetedUidd.generateId(),"1234567890", "pedrolopeshls@gmail.com", "Medico Geral", "ativo", "", "123123");
        Funcionario funcionario3 = new Funcionario("Fernanda Alves", generetedUidd.generateId(),"1234567890", "pedrolopeshls@gmail.com", "Medico Geral", "ativo", "", "123123");
        Funcionario funcionario4 = new Funcionario("Maria Silva", generetedUidd.generateId(),"1234567890", "pedrolopeshls@gmail.com", "Medico Geral", "ativo", "", "123123");

        Equipe equipe1 = new Equipe("Equipe 1", generetedUidd.generateId(), "ativa", funcionario1.getId());
        Equipe equipe2 = new Equipe("Equipe 2", generetedUidd.generateId(), "ativa", funcionario2.getId());

        UnidadeHospitalar unidade1 = new UnidadeHospitalar("A", generetedUidd.generateId());
        UnidadeHospitalar unidade2 = new UnidadeHospitalar("B", generetedUidd.generateId());

        QuartoHospitalar quart1 = new QuartoHospitalar("Quarto 1A", generetedUidd.generateId(), 10);
        QuartoHospitalar quart2 = new QuartoHospitalar("Quarto 1B", generetedUidd.generateId(), 10);
        QuartoHospitalar quart3 = new QuartoHospitalar("Quarto 1C", generetedUidd.generateId(), 10);
        QuartoHospitalar quart4 = new QuartoHospitalar("Quarto 1D", generetedUidd.generateId(), 10);

        LeitoHospitalar leito1 = new LeitoHospitalar("1A", generetedUidd.generateId(), false);
        LeitoHospitalar leito2 = new LeitoHospitalar("2A",generetedUidd.generateId(), false);
        LeitoHospitalar leito3 = new LeitoHospitalar("3A",generetedUidd.generateId(), false);
        LeitoHospitalar leito4 = new LeitoHospitalar("4A",generetedUidd.generateId(), false);
        LeitoHospitalar leito5 = new LeitoHospitalar("5A",generetedUidd.generateId(), false);
        LeitoHospitalar leito6 = new LeitoHospitalar("1B",generetedUidd.generateId(), false);
        LeitoHospitalar leito7 = new LeitoHospitalar("2B",generetedUidd.generateId(), false);
        LeitoHospitalar leito8 = new LeitoHospitalar("3B",generetedUidd.generateId(), false);
        LeitoHospitalar leito9 = new LeitoHospitalar("1C",generetedUidd.generateId(), false);
        LeitoHospitalar leito10 = new LeitoHospitalar("2C",generetedUidd.generateId(), false);
        LeitoHospitalar leito11 = new LeitoHospitalar("3C",generetedUidd.generateId(), false);
        LeitoHospitalar leito12 = new LeitoHospitalar("4C",generetedUidd.generateId(), false);

        Paciente paciente1 = new Paciente("Maria", generetedUidd.generateId(), "(48) 99942-2614", 18, 1.77, 60.5, "Não possui", "COVID-19", "true", "Isolamento imediato", "aguardando");
        Paciente paciente2 = new Paciente("João", generetedUidd.generateId(), "(48) 9823-2019", 20, 1.80, 70.4, "Asmático", "COVID-19", "true", "Isolamento Imediato", "aguardando");
        Paciente paciente3 = new Paciente("Paulo", generetedUidd.generateId(), "(21) 99982-2093", 38, 1.85, 80.5, "Diabetes", "infecção", "false", "Não possui", "aguardando");
        Paciente paciente4 = new Paciente("Gustavo", generetedUidd.generateId(), "(11) 99523-3048", 28, 1.68, 60.5, "Não possui", "não concluído", "false", "Não possui", "aguardando");

        if(this.especialidadeController.getEspecialidades().size() < 1){
            this.especialidadeController.salvarDadosEspecialidade(especialidade1);
            this.especialidadeController.salvarDadosEspecialidade(especialidade2);
            this.especialidadeController.salvarDadosEspecialidade(especialidade3);
            this.especialidadeController.salvarDadosEspecialidade(especialidade4);
            this.especialidadeController.salvarDadosEspecialidade(especialidade5);
            this.especialidadeController.salvarDadosEspecialidade(especialidade6);
        }

        if(this.equipamentoController.getEquipamentos().size() < 1){
            this.equipamentoController.salvarDadosEquipamento(equipamento1);
            this.equipamentoController.salvarDadosEquipamento(equipamento2);
            this.equipamentoController.salvarDadosEquipamento(equipamento3);
            this.equipamentoController.salvarDadosEquipamento(equipamento4);
            this.equipamentoController.salvarDadosEquipamento(equipamento5);
        }


        if(this.funcionarioController.getFuncionarios().size() < 1){
            this.funcionarioController.salvarDadosFuncionario(funcionario1);
            this.funcionarioController.salvarDadosFuncionario(funcionario2);
            this.funcionarioController.salvarDadosFuncionario(funcionario3);
            this.funcionarioController.salvarDadosFuncionario(funcionario4);
        }

        if(this.equipeController.getEquipes().size() < 1){
            this.equipeController.salvarDadosEquipe(equipe1);
            this.equipeController.salvarDadosEquipe(equipe2);
        }

        if(this.unidadeHospitalarController.getUnidades().size() < 1){
            this.unidadeHospitalarController.salvarDadosUnidade(unidade1);
            this.unidadeHospitalarController.salvarDadosUnidade(unidade2);
        }

        if(this.quartoController.getQuartos().size() < 1){
            this.quartoController.salvarDadosQuarto(quart1);
            this.quartoController.salvarDadosQuarto(quart2);
            this.quartoController.salvarDadosQuarto(quart3);
            this.quartoController.salvarDadosQuarto(quart4);
        }

        if(this.leitoController.getLeitos().size() < 1){
            this.leitoController.salvarDadosLeito(leito1);
            this.leitoController.salvarDadosLeito(leito2);
            this.leitoController.salvarDadosLeito(leito3);
            this.leitoController.salvarDadosLeito(leito4);
            this.leitoController.salvarDadosLeito(leito5);
            this.leitoController.salvarDadosLeito(leito6);
            this.leitoController.salvarDadosLeito(leito7);
            this.leitoController.salvarDadosLeito(leito8);
            this.leitoController.salvarDadosLeito(leito9);
            this.leitoController.salvarDadosLeito(leito10);
            this.leitoController.salvarDadosLeito(leito11);
            this.leitoController.salvarDadosLeito(leito12);
        }

        if(this.pacienteController.getPacientes().size() < 1){
            this.pacienteController.salvarDadosPaciente(paciente1);
            this.pacienteController.salvarDadosPaciente(paciente2);
            this.pacienteController.salvarDadosPaciente(paciente3);
            this.pacienteController.salvarDadosPaciente(paciente4);
        }
    }
}
