package com.management.UI;

import com.management.*;
import com.management.UI.Equipamento.EquipamentoFormUI;
import com.management.UI.Equipamento.EquipamentoListaUI;
import com.management.UI.Equipe.EquipeAddFuncionario;
import com.management.UI.Equipe.EquipeFormUI;
import com.management.UI.Equipe.EquipeListaUI;
import com.management.UI.Equipe.EquipePesquisaUI;
import com.management.UI.Especialidade.EspecialidadeFormUi;
import com.management.UI.Especialidade.EspecialidadeListaUI;
import com.management.UI.Funcionario.FuncionarioFormUI;
import com.management.UI.Funcionario.FuncionarioListaUI;
import com.management.UI.Funcionario.PesquisaNomeFuncionario;
import com.management.UI.LeitoHospitalar.LeitoAddQuarto;
import com.management.UI.LeitoHospitalar.LeitoFormUI;
import com.management.UI.LeitoHospitalar.LeitoListaUI;
import com.management.UI.Paciente.PacienteFormUI;
import com.management.UI.Paciente.PacienteListaUI;
import com.management.UI.QuartoHospitalar.QuartoFormUI;
import com.management.UI.QuartoHospitalar.QuartoListaUI;
import com.management.UI.UnidadeHospitalar.UnidadeEquipeFormUI;
import com.management.UI.UnidadeHospitalar.UnidadeFormularioUI;
import com.management.UI.UnidadeHospitalar.UnidadeListaUI;
import com.management.UI.UnidadeHospitalar.UnidadeQuartoFormUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrincipalUI extends JFrame {
    private JPanel mainPanel;
    private JMenuBar mbSistema;
    private JMenu mnFuncionarios;
    private JMenu mnEquipe;
    private JMenuItem miListarFuncionarios;
    private JMenuItem miCriarFuncinario;
    private JMenuItem miCriarEquipe;
    private JMenuItem miListarEquipe;
    private JMenuItem miAddFuncionario;
    private JMenu mnUnidadeHospitalar;
    private JMenuItem miCriarUnidade;
    private JMenuItem miListarUnidades;
    private JMenu mnQuarto;
    private JMenuItem miCriarQuarto;
    private JMenuItem miListarQuarto;
    private JMenu mnLeitos;
    private JMenuItem miListaLeitos;
    private JMenuItem miCriarLeito;
    private JMenu mnPacientes;
    private JMenuItem miCadastrarPaciente;
    private JMenuItem miListaPaciente;
    private JMenuItem miLeitoAddPaciente;
    private JMenuItem miListaEquipamentos;
    private JMenuItem miCadastrarEquipamento;
    private JMenuItem miListaEspecialidades;
    private JMenuItem miCriarEspecialidade;
    private JMenuItem miUnidadeEquipe;
    private JMenuItem miUnidadeAddQuarto;
    private JLabel labelInstrucao;
    private JMenuItem miQuartoAddLeito;
    private JPanel jpEquipe;
    private JPanel jpFuncionario;
    private JPanel jpUnidade;
    private JPanel jpEspecialidade;
    private JPanel jpQuarto;
    private JPanel jpLeito;
    private JPanel jpEquipamento;
    private JMenuItem miPesquisaFuncionario;
    private JMenuItem miPesquisaEquipe;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Equipe> equipes;
    private ArrayList<Especialidade> especialidades;
    private ArrayList<UnidadeHospitalar> unidadeHospitalares;
    private ArrayList<QuartoHospitalar> quartoHospitalars;
    private ArrayList<LeitoHospitalar> leitoHospitalares;
    private ArrayList<Equipamento> equipamentos;
    private ArrayList<Paciente>pacientes;
    private PrincipalUI principalUI;

    public PrincipalUI(){
        this.funcionarios = new ArrayList<Funcionario>();
        this.equipes = new ArrayList<Equipe>();
        this.unidadeHospitalares = new ArrayList<UnidadeHospitalar>();
        this.especialidades = new ArrayList<Especialidade>();
        this.quartoHospitalars = new ArrayList<QuartoHospitalar>();
        this.leitoHospitalares = new ArrayList<LeitoHospitalar>();
        this.equipamentos = new ArrayList<Equipamento>();
        this.pacientes = new ArrayList<Paciente>();

        criarEspecialidades();
        criarDadosTest();
        //DEFINE COMO A JANELA VAI SER FECHADA
        //EXIT_ON_CLOSE = FECHA A JANELA E O SISTEMA PARA DE FUNCIONAR
        //DISPOSE_ON_CLOSE = FECHA A JANELA E SISTEMA CONTINUA FUNCIONANDO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //VAI COLOCAR EM TELA TODOS OS COMPONENTES
        this.setContentPane(mainPanel);
        this.pack();

        //FUNCIONARIOS - CRIAR FUNCIONARIO
        miCriarFuncinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferToChieldFuncionarioFormUI();
            }
        });

        //FUNCIONARIOS - LISTA DE FUNCIONARIOS
        miListarFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferToChieldFuncionarioListaUI();
            }
        });

        //FUNCIONARIOS - PESQUISAR FUNCIONARIO POR NOME
        miPesquisaFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisaFuncionarioUI();
            }
        });

        //EQUIPE - CRIAR EQUIPE
        miCriarEquipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldEquipeFormUI();
            }
        });

        //EQUIPE - LISTAR EQUIPES
        miListarEquipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldEquipeListaUI();
            }
        });

        //EQUIPE - ADICIONAR FUNCIONARIO A UMA EQUIPE
        miAddFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldEquipeAddFuncionario();
            }
        });

        //EQUIPE - PESQUISAR EQUIPE POR NOME
        miPesquisaEquipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisaEquipeUI();
            }
        });

        //UNIDADE - CRIAR UNIDADE HOSPITALR
        miCriarUnidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unidadeFormUI();
            }
        });

        //UNIDADE - LISTA UNIDADES HOSPITALARES
        miListarUnidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldUnidadeListaUI();
            }
        });

        //UNIDADE - ADICIONAR EQUIPE A UMA UNIDADE HOSPITALAR
        miUnidadeEquipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unidadeAddequipeUI();
            }
        });

        //UNIDADE - ADICIONAR QUARTO A UMA UNIDADE HOSPITALAR
        miUnidadeAddQuarto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unidadeAddQuartoUI();
            }
        });

        //ESPECIALIDADES - LISTA ESPECIALIDADES
        miListaEspecialidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaEspecialidadeUI();
            }
        });

        //ESPECIALIDADES - CRIAR ESPECIALIDADE
        miCriarEspecialidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarEspecilidade();
            }
        });

        //QUARTO - CRIAR QUARTO
        miCriarQuarto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldQuartoCriarUI();
            }
        });

        //QUARTO - LISTAR QUARTOS
        miListarQuarto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldQuartoListaUI();
            }
        });

        //QUARTO - LISTAR QUARTOS
        miQuartoAddLeito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quartoAddLeito();
            }
        });

        //LEITO - CRIAR LEITO
        miCriarLeito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldLeitoFormUI();
            }
        });

        //LEITO - LISTAR LEITOS
        miListaLeitos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldLeitoListaUI();
            }
        });

        //PACIENTE - CRIAR PACIENTES
        miCadastrarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pacienteFormUI();
            }
        });

        //PACIENTE - LISTA PACIENTES
        miListaPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pacientelistaui();
            }
        });

        //EQUIPAMENTO - CRIAR EQUIPAMENTO
        miCadastrarEquipamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               equipamentoCadastrarUI();
            }
        });

        //EQUIPAMENTO - LISTA EQUIPAMENTO
        miListaEquipamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipamentoListaUI();
            }
        });

    }

    //FUNCIONARIO - CRIAR FUNCIONARIO
    private void transferToChieldFuncionarioFormUI(){
        FuncionarioFormUI funcionarioFormUI = new FuncionarioFormUI(this);
        funcionarioFormUI.setVisible(true);
    }

    //FUNCIONARIOS - LISTA DE FUNCIONARIOS
    private void transferToChieldFuncionarioListaUI(){
        FuncionarioListaUI funcionarioListaUI = new FuncionarioListaUI(this);
        funcionarioListaUI.setVisible(true);
    }

    //FUNCIONARIO - PESQUISAR FUNCIONARIO POR NOME
    private void pesquisaFuncionarioUI(){
        PesquisaNomeFuncionario pesquisaNomeFuncionario = new PesquisaNomeFuncionario(this);
        pesquisaNomeFuncionario.setVisible(true);
    }

    //EQUIPE - CRIAR EQUIPE
    private void chieldEquipeFormUI(){
        EquipeFormUI equipeFormUI = new EquipeFormUI(this);
        equipeFormUI.setVisible(true);
    }

    //EQUIPES - LISTA DE EQUIPES
    private void chieldEquipeListaUI(){
        EquipeListaUI equipeListaUI = new EquipeListaUI(this);
        equipeListaUI.setVisible(true);
    }

    //EQUIPES - ADICIONAR FUNCIONARIO A UMA EQUIPE
    private void chieldEquipeAddFuncionario(){
        EquipeAddFuncionario equipeAddFuncionario = new EquipeAddFuncionario(this);
        equipeAddFuncionario.setVisible(true);
    }

    //EQUIPES - PESQUISAR EQUIPE PELO NOME
    public void pesquisaEquipeUI(){
        EquipePesquisaUI equipePesquisaUI = new EquipePesquisaUI(this);
        equipePesquisaUI.setVisible(true);
    }

    //UNIDADES - CRIAR UNIDADE HOSPITALR
    private void unidadeFormUI(){
        UnidadeFormularioUI unidadeFormularioUI = new UnidadeFormularioUI(this);
        unidadeFormularioUI.setVisible(true);
    }

    //UNIDADES - LISTA UNIDADES HOSPITALARES
    public void chieldUnidadeListaUI(){
        UnidadeListaUI unidadeListaUI = new UnidadeListaUI(this);
        unidadeListaUI.setVisible(true);
    }

    //UNIDADE - ADICIONAR EQUIPE A UMA UNIDADE HOSPITALAR
    public void unidadeAddequipeUI(){
        UnidadeEquipeFormUI unidadeEquipeFormUI = new UnidadeEquipeFormUI(this);
        unidadeEquipeFormUI.setVisible(true);
    }

    //UNIDADE - ADICIONAR QUARTO A UMA UNIDADE HOSPITALAR
    public void unidadeAddQuartoUI(){
        UnidadeQuartoFormUI unidadeQuartoFormUI = new UnidadeQuartoFormUI(this);
        unidadeQuartoFormUI.setVisible(true);
    }


    //ESPECIALIDADES - LISTA ESPECIALIDADES
    public void listaEspecialidadeUI(){
        EspecialidadeListaUI especialidadeListaUI = new EspecialidadeListaUI(this);

        //TORNA PAGINA VISIVEL
        especialidadeListaUI.setVisible(true);
    }

    //ESPECIALIDADES - CRIAR ESPECIALIDADE
    public void criarEspecilidade(){
        EspecialidadeFormUi especialidadeFormUi = new EspecialidadeFormUi(this);
        especialidadeFormUi.setVisible(true);
    }

    //QUARTO - CRIAR QUARTO
    public void chieldQuartoCriarUI(){
        QuartoFormUI quartoFormUI = new QuartoFormUI(this);
        quartoFormUI.setVisible(true);
    }

    //QUARTO - LISTA DE QUARTOS
    public void chieldQuartoListaUI(){
        QuartoListaUI quartoListaUI = new QuartoListaUI(this);
        quartoListaUI.setVisible(true);
    }

    //QUARTO - ADICIONAR LEITO AO QUARTO
    public void quartoAddLeito(){
        LeitoAddQuarto leitoAddQuarto = new LeitoAddQuarto(this);
        leitoAddQuarto.setVisible(true);
    }

    //LEITO - CRIAR LEITO
    public void chieldLeitoFormUI(){
        LeitoFormUI leitoFormUI = new LeitoFormUI(this);
        leitoFormUI.setVisible(true);
    }

    //LEITO - LISTAR LEITOS
    public void chieldLeitoListaUI(){
        LeitoListaUI leitoListaUI = new LeitoListaUI(this);
        leitoListaUI.setVisible(true);
    }
    // PACIENTE - CRIAR PACIENTE
    public void pacienteFormUI(){
        PacienteFormUI pacienteFormUI = new PacienteFormUI(this);
        pacienteFormUI.setVisible(true);
    }
    //PACIENTE - LISTAR PACIENTE
    public void pacientelistaui(){
        PacienteListaUI pacienteListaUI = new PacienteListaUI(this);
        pacienteListaUI.setVisible(true);
    }
    //EQUIPAMENTO - CADASTRAR EQUIPAMENTO
    public void equipamentoCadastrarUI(){
        EquipamentoFormUI equipamentoFormUI = new EquipamentoFormUI(this);
        equipamentoFormUI.setVisible(true);
    }

    //EQUIPAMENTO - LISTAR EQUIPAMENTO
    public void equipamentoListaUI(){
       EquipamentoListaUI equipamentoListaUI = new EquipamentoListaUI(this);
        equipamentoListaUI.setVisible(true);
    }

    public void criarEspecialidades(){
        Especialidade especialidade1 = new Especialidade("Dermatologia", 1);
        Especialidade especialidade2 = new Especialidade("Cardiologia", 2);
        Especialidade especialidade3 = new Especialidade("Neurologia", 3);
        Especialidade especialidade4 = new Especialidade("Reumatologia", 4);
        Especialidade especialidade5 = new Especialidade("Cirurgia torácica", 5);
        Especialidade especialidade6 = new Especialidade("Outra", 6);
        this.especialidades.add(especialidade1);
        this.especialidades.add(especialidade2);
        this.especialidades.add(especialidade3);
        this.especialidades.add(especialidade4);
        this.especialidades.add(especialidade5);
        this.especialidades.add(especialidade6);
    }

    public void criarDadosTest(){
        Equipamento equipamento1 = new Equipamento("Eletrocardiógrafos", 1,1);
        Equipamento equipamento2 = new Equipamento("Ventilador pulmonar.", 2,2);
        Equipamento equipamento3 = new Equipamento("Oxímetro", 3,3);
        Equipamento equipamento4 = new Equipamento("Monitor multiparamétrico", 4,4);
        Equipamento equipamento5 = new Equipamento("Desfibrilador", 5,5);
        this.equipamentos.add(equipamento1);
        this.equipamentos.add(equipamento2);
        this.equipamentos.add(equipamento3);
        this.equipamentos.add(equipamento4);
        this.equipamentos.add(equipamento5);

        Funcionario funcionario1 = new Funcionario("Pedro Lopes", 1, "1234567890");
        funcionario1.setCargo("Medico Geral");
        Funcionario funcionario2 = new Funcionario("Alisson Gabriel", 2, "1234567890");
        funcionario2.setCargo("Medico Cirurgião");
        Funcionario funcionario3 = new Funcionario("Fernanda Alves", 3, "1234567890");
        funcionario3.setCargo("Enfermeiro");
        Funcionario funcionario4 = new Funcionario("Maria Silva", 4, "1234567890");
        funcionario4.setCargo("Limpeza");
        this.funcionarios.add(funcionario1);
        this.funcionarios.add(funcionario2);
        this.funcionarios.add(funcionario3);
        this.funcionarios.add(funcionario4);

        Equipe equipe1 = new Equipe("Equipe Delta", 1, "Pedro Lopes");
        Equipe equipe2 = new Equipe("Equipe Gama", 2, "lisson Gabriel");
        this.equipes.add(equipe1);
        this.equipes.add(equipe2);

        UnidadeHospitalar unidade1 = new UnidadeHospitalar("A", 1);
        unidade1.setEspecialidade("Dermatologia");
        UnidadeHospitalar unidade2 = new UnidadeHospitalar("B", 2);
        unidade2.setEspecialidade("Reumatologia");
        this.unidadeHospitalares.add(unidade1);
        this.unidadeHospitalares.add(unidade2);

        QuartoHospitalar quart1 = new QuartoHospitalar("Quarto 1A", 1, 10, 0);
        QuartoHospitalar quart2 = new QuartoHospitalar("Quarto 2A", 2, 10, 0);
        QuartoHospitalar quart3 = new QuartoHospitalar("Quarto 3A", 3, 10, 0);
        QuartoHospitalar quart4 = new QuartoHospitalar("Quarto 4A", 4, 10, 0);
        this.quartoHospitalars.add(quart1);
        this.quartoHospitalars.add(quart2);
        this.quartoHospitalars.add(quart3);
        this.quartoHospitalars.add(quart4);

        LeitoHospitalar leito1 = new LeitoHospitalar(false, 1);
        LeitoHospitalar leito2 = new LeitoHospitalar(false, 2);
        LeitoHospitalar leito3 = new LeitoHospitalar(false, 3);
        this.leitoHospitalares.add(leito1);
        this.leitoHospitalares.add(leito2);
        this.leitoHospitalares.add(leito3);
        leito1.addEquipamento(equipamento1);
        leito2.addEquipamento(equipamento2);

        Paciente paciente1 = new Paciente("Maria", 1, "(48) 99942-2614", 18, 1.77, 60.5, "Não possui", "COVID-19", true, "Isolamento imediato");
        Paciente paciente2 = new Paciente("João", 2, "(48) 9823-2019", 20, 1.80, 70.4, "Asmático", "COVID-19", true, "Isolamento Imediato");
        Paciente paciente3 = new Paciente("Paulo", 3, "(21) 99982-2093", 38, 1.85, 80.5, "Diabetes", "infecção", false, "Não possui");
        Paciente paciente4 = new Paciente("Gustavo", 4, "(11) 99523-3048", 28, 1.68, 60.5, "Não possui", "não concluído", false, "Não possui");
        this.pacientes.add(paciente1);
        this.pacientes.add(paciente2);
        this.pacientes.add(paciente3);
        this.pacientes.add(paciente4);

    }

    public ArrayList<Funcionario> getFuncionarios(){
        return this.funcionarios;
    }
    public ArrayList<Equipe> getEquipes(){
        return this.equipes;
    }
    public ArrayList<UnidadeHospitalar> getUnidadeHospitalares(){
        return this.unidadeHospitalares;
    }
    public ArrayList<Especialidade> getEspecialidades(){ return  this.especialidades; }
    public ArrayList<QuartoHospitalar> getQuartos(){ return  this.quartoHospitalars; }
    public ArrayList<LeitoHospitalar> getLeitos(){ return  this.leitoHospitalares; }
    public ArrayList<Equipamento> getEquipamentos(){ return  this.equipamentos; }
    public ArrayList<Paciente> getPacientes(){ return this.pacientes ;}


    public static void main(String[] args){
        JFrame frame = new PrincipalUI();
        frame.setVisible(true);
    }
}
