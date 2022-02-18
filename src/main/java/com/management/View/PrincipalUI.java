package com.management.View;

import com.management.Controller.*;
import com.management.Model.Classes.*;
import com.management.Model.Repository.EquipamentoRepository;
import com.management.View.Equipamento.EquipamentoFormEditarUI;
import com.management.View.Equipamento.EquipamentoFormUI;
import com.management.View.Equipamento.EquipamentoListaUI;
import com.management.View.Equipe.*;
import com.management.View.Especialidade.EspecialidadeFormUi;
import com.management.View.Especialidade.EspecialidadeListaUI;
import com.management.View.Funcionario.FuncionarioFormUI;
import com.management.View.Funcionario.FuncionarioListaUI;
import com.management.View.Funcionario.PesquisaNomeFuncionario;
import com.management.View.LeitoHospitalar.LeitoAddPacienteUI;
import com.management.View.LeitoHospitalar.LeitoAddQuarto;
import com.management.View.LeitoHospitalar.LeitoFormUI;
import com.management.View.LeitoHospitalar.LeitoListaUI;
import com.management.View.Paciente.PacienteFormUI;
import com.management.View.Paciente.PacienteListaUI;
import com.management.View.QuartoHospitalar.QuartoFormUI;
import com.management.View.QuartoHospitalar.QuartoListaUI;
import com.management.View.UnidadeHospitalar.UnidadeEquipeFormUI;
import com.management.View.UnidadeHospitalar.UnidadeFormularioUI;
import com.management.View.UnidadeHospitalar.UnidadeListaUI;
import com.management.View.UnidadeHospitalar.UnidadeQuartoFormUI;
//import com.management.API.ApiApplication;
import com.management.utils.Uuid;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

@SpringBootApplication
@CrossOrigin
public class PrincipalUI extends JFrame {
    private EquipamentoRepository equipamentoRepo;
    private JPanel mainPanel;
    private JMenuBar mbSistema;
    private JMenu mnFuncionarios;
    private JMenu mnEquipe;
    private JMenuItem miListarFuncionarios;
    private JMenuItem miCriarFuncinario;
    private JMenuItem miCriarEquipe;
    private JMenuItem miListarEquipe;
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
    private JLabel labelInstrucao;
    private JMenuItem miQuartoAddLeito;
    private PrincipalUI principalUI;

    private JMenuItem miEquipamentoEditar;
    private JPanel jpPacientesAguardando;
    private JPanel jpPacientesInternados;
    private JPanel jpAcoes;
    private JButton PacienteNovoButton;
    private JButton listaPacientesButton;
    private JButton ListaLimpezaButton;
    private JLabel jlContPacientesAguardando;
    private JLabel jlContPacientesInternados;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Equipe> equipes;
    private ArrayList<Especialidade> especialidades;
    private ArrayList<QuartoHospitalar> quartoHospitalars;
    private ArrayList<LeitoHospitalar> leitoHospitalares;
    private ArrayList<Paciente>pacientes;
    List<Equipamento> equipamentos = new ArrayList<Equipamento>();
    Set<UnidadeHospitalar> unidadeHospitalares = new HashSet<UnidadeHospitalar>();
    Map<String, Equipe> mapaEquipe = new HashMap();
    private Uuid generetedUidd = new Uuid();
    private FuncionarioController funcionarioController = new FuncionarioController();
    private EquipeController equipeController = new EquipeController();
    private UnidadeHospitalarController unidadeHospitalarController = new UnidadeHospitalarController();
    private EspecialidadeController especialidadeController = new EspecialidadeController();
    private EquipamentoController equipamentoController = new EquipamentoController();
    private QuartoController quartoController = new QuartoController();
    private LeitoController leitoController = new LeitoController();
    private PacienteController pacienteController = new PacienteController();

    public PrincipalUI() throws SQLException, ClassNotFoundException {
        this.funcionarios = new ArrayList<Funcionario>();
        this.equipes = new ArrayList<Equipe>();
        this.especialidades = new ArrayList<Especialidade>();
        this.quartoHospitalars = new ArrayList<QuartoHospitalar>();
        this.leitoHospitalares = new ArrayList<LeitoHospitalar>();

        this.pacientes = new ArrayList<Paciente>();

        criarDadosTest();
        checkLogClasses();
        MapearEquipes();
        calcPacientesInternados();
        calcPacientesAguardando();

        //DEFINE COMO A JANELA VAI SER FECHADA
        //EXIT_ON_CLOSE = FECHA A JANELA E O SISTEMA PARA DE FUNCIONAR
        //DISPOSE_ON_CLOSE = FECHA A JANELA E SISTEMA CONTINUA FUNCIONANDO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //VAI COLOCAR EM TELA TODOS OS COMPONENTES
        this.setContentPane(mainPanel);
        this.pack();

        //FUNCIONARIOS - CRIAR FUNCIONARIO
        miCriarFuncinario.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                transferToChieldFuncionarioFormUI();
            }
        });

        //FUNCIONARIOS - LISTA DE FUNCIONARIOS
        miListarFuncionarios.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                transferToChieldFuncionarioListaUI();
            }
        });

        //EQUIPE - CRIAR EQUIPE
        miCriarEquipe.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldEquipeFormUI();
            }
        });

        //EQUIPE - LISTAR EQUIPES
        miListarEquipe.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldEquipeListaUI();
            }
        });

        //UNIDADE - CRIAR UNIDADE HOSPITALR
        miCriarUnidade.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                unidadeFormUI();
            }
        });

        //UNIDADE - LISTA UNIDADES HOSPITALARES
        miListarUnidades.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldUnidadeListaUI();
            }
        });

        //ESPECIALIDADES - LISTA ESPECIALIDADES
        miListaEspecialidades.addActionListener(new ActionListener() {
            @SneakyThrows
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
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldQuartoCriarUI();
            }
        });

        //QUARTO - LISTAR QUARTOS
        miListarQuarto.addActionListener(new ActionListener() {
            @SneakyThrows
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
            @SneakyThrows
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

        //PACIENTE - ADICIONAR PACIENTE EM LEITO
        miLeitoAddPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leitoAddPacienteUI();
            }
        });

        //PACIENTE - LISTA PACIENTES
        miListaPaciente.addActionListener(new ActionListener() {
            @SneakyThrows
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

        //EQUIPAMENTO - EDITAR EQUIPAMENTO
        miEquipamentoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipamentoEditarUI();
            }
        });

    }

    //FUNCIONARIO - CRIAR FUNCIONARIO
    private void transferToChieldFuncionarioFormUI() throws SQLException, ClassNotFoundException {
        FuncionarioFormUI funcionarioFormUI = new FuncionarioFormUI(this);
        funcionarioFormUI.setVisible(true);
    }

    //FUNCIONARIOS - LISTA DE FUNCIONARIOS
    private void transferToChieldFuncionarioListaUI() throws SQLException, ClassNotFoundException {
        FuncionarioListaUI funcionarioListaUI = new FuncionarioListaUI(this);
        funcionarioListaUI.setVisible(true);
    }

    //FUNCIONARIO - PESQUISAR FUNCIONARIO POR NOME
    private void pesquisaFuncionarioUI(){
        PesquisaNomeFuncionario pesquisaNomeFuncionario = new PesquisaNomeFuncionario(this);
        pesquisaNomeFuncionario.setVisible(true);
    }

    //EQUIPE - CRIAR EQUIPE
    private void chieldEquipeFormUI() throws SQLException, ClassNotFoundException {
        EquipeFormUI equipeFormUI = new EquipeFormUI(this);
        equipeFormUI.setVisible(true);
    }

    //EQUIPES - LISTA DE EQUIPES
    private void chieldEquipeListaUI() throws SQLException, ClassNotFoundException {
        EquipeListaUI equipeListaUI = new EquipeListaUI(this);
        equipeListaUI.setVisible(true);
    }

    //UNIDADES - CRIAR UNIDADE HOSPITALR
    private void unidadeFormUI() throws SQLException, ClassNotFoundException {
        UnidadeFormularioUI unidadeFormularioUI = new UnidadeFormularioUI(this);
        unidadeFormularioUI.setVisible(true);
    }

    //UNIDADES - LISTA UNIDADES HOSPITALARES
    public void chieldUnidadeListaUI() throws SQLException, ClassNotFoundException {
        UnidadeListaUI unidadeListaUI = new UnidadeListaUI(this);
        unidadeListaUI.setVisible(true);
    }

    //ESPECIALIDADES - LISTA ESPECIALIDADES
    public void listaEspecialidadeUI() throws SQLException, ClassNotFoundException {
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
    public void chieldQuartoCriarUI() throws SQLException, ClassNotFoundException {
        QuartoFormUI quartoFormUI = new QuartoFormUI(this);
        quartoFormUI.setVisible(true);
    }

    //QUARTO - LISTA DE QUARTOS
    public void chieldQuartoListaUI() throws SQLException, ClassNotFoundException {
        QuartoListaUI quartoListaUI = new QuartoListaUI(this);
        quartoListaUI.setVisible(true);
    }

    //QUARTO - ADICIONAR LEITO AO QUARTO
    public void quartoAddLeito(){
        LeitoAddQuarto leitoAddQuarto = new LeitoAddQuarto(this);
        leitoAddQuarto.setVisible(true);
    }

    //LEITO - CRIAR LEITO
    public void chieldLeitoFormUI() throws SQLException, ClassNotFoundException {
        LeitoFormUI leitoFormUI = new LeitoFormUI(this);
        leitoFormUI.setVisible(true);
    }

    //LEITO - LISTAR LEITOS
    public void chieldLeitoListaUI(){
        LeitoListaUI leitoListaUI = new LeitoListaUI(this);
        leitoListaUI.setVisible(true);
    }

    //LEITO - ALOCAR PACIENTE EM LEITO
    public void leitoAddPacienteUI(){
        LeitoAddPacienteUI leitoAddPacienteUI = new LeitoAddPacienteUI(this);
        leitoAddPacienteUI.setVisible(true);
    }

    // PACIENTE - CRIAR PACIENTE
    public void pacienteFormUI(){
        PacienteFormUI pacienteFormUI = new PacienteFormUI(this);
        pacienteFormUI.setVisible(true);
    }
    //PACIENTE - LISTAR PACIENTE
    public void pacientelistaui() throws SQLException, ClassNotFoundException {
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

    public void equipamentoEditarUI(){
        EquipamentoFormEditarUI editarNewEquipamentoFormUI = new EquipamentoFormEditarUI(this);
        editarNewEquipamentoFormUI.setVisible(true);
    }


    public void criarDadosTest() throws SQLException, ClassNotFoundException {
        Especialidade especialidade1 = new Especialidade(generetedUidd.generateId(), "Clínico Geral");
        Especialidade especialidade2 = new Especialidade(generetedUidd.generateId(), "Cardiologia");
        Especialidade especialidade3 = new Especialidade(generetedUidd.generateId(), "Neurologia");
        Especialidade especialidade4 = new Especialidade(generetedUidd.generateId(), "Reumatologia");
        Especialidade especialidade5 = new Especialidade(generetedUidd.generateId(), "Cirurgia torácica");
        Especialidade especialidade6 = new Especialidade(generetedUidd.generateId(), "Outra");

        Equipamento equipamento1 = new Equipamento("Eletrocardiógrafos", 1,generetedUidd.generateId());
        Equipamento equipamento2 = new Equipamento("Ventilador pulmonar.", 2,generetedUidd.generateId());
        Equipamento equipamento3 = new Equipamento("Oxímetro", 3,generetedUidd.generateId());
        Equipamento equipamento4 = new Equipamento("Monitor multiparamétrico", 4,generetedUidd.generateId());
        Equipamento equipamento5 = new Equipamento("Desfibrilador", 5,generetedUidd.generateId());

        Funcionario funcionario1 = new Funcionario("Pedro Lopes", "pedrolopeshls@gmail.com", generetedUidd.generateId(), "admin", "Medico Geral", "ativo", "", "123123");
        Funcionario funcionario2 = new Funcionario("Alisson Gabriel", "email@email.com", generetedUidd.generateId(), "1234567890", "admin", "ativo", "", "123123");
        Funcionario funcionario3 = new Funcionario("Fernanda Alves", "email@email.com", generetedUidd.generateId(), "1234567890", "Medica residente", "ativo", "", "123123");
        Funcionario funcionario4 = new Funcionario("Maria Silva", "email@email.com", generetedUidd.generateId(), "1234567890", "Enfermeira", "ativo", "", "123123");

        Equipe equipe1 = new Equipe("Equipe 1", generetedUidd.generateId(), "ativa", funcionario1.getId());
        Equipe equipe2 = new Equipe("Equipe 2", generetedUidd.generateId(), "ativa", funcionario2.getId());

        UnidadeHospitalar unidade1 = new UnidadeHospitalar("A", generetedUidd.generateId());
        UnidadeHospitalar unidade2 = new UnidadeHospitalar("B", generetedUidd.generateId());

        QuartoHospitalar quart1 = new QuartoHospitalar("Quarto 1A", generetedUidd.generateId(), 10);
        QuartoHospitalar quart2 = new QuartoHospitalar("Quarto 1B", generetedUidd.generateId(), 10);
        QuartoHospitalar quart3 = new QuartoHospitalar("Quarto 1C", generetedUidd.generateId(), 10);
        QuartoHospitalar quart4 = new QuartoHospitalar("Quarto 1D", generetedUidd.generateId(), 10);

        LeitoHospitalar leito1 = new LeitoHospitalar(generetedUidd.generateId(), false);
        LeitoHospitalar leito2 = new LeitoHospitalar(generetedUidd.generateId(), false);
        LeitoHospitalar leito3 = new LeitoHospitalar(generetedUidd.generateId(), false);

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
        }

        if(this.pacienteController.getPacientes().size() < 1){
            this.pacienteController.salvarDadosPaciente(paciente1);
            this.pacienteController.salvarDadosPaciente(paciente2);
            this.pacienteController.salvarDadosPaciente(paciente3);
            this.pacienteController.salvarDadosPaciente(paciente4);
        }

//        leito1.addEquipamento(equipamento1);
//        leito2.addEquipamento(equipamento2);

//        quart1.addLeitoHospitalar(leito1);
//        quart1.addLeitoHospitalar(leito2);

        leito1.setPaciente(paciente1);
        leito1.setOcupado(true);
        paciente1.setStatusPaciente("emLeito");
    }

    public void checkLogClasses() {
        SobrescrevertoString texto = new SobrescrevertoString() {
            @Override
            public void SobrescrevertoString() {
                System.out.println("\n ========= DADOS PARA EQUIPAMENTOS: =========");
                System.out.println( equipamentos.toString() );

                System.out.println("\n ========= DADOS PARA ESPECIALIDADE: =========");
                System.out.println( especialidades.toString() );

                System.out.println("\n ========= DADOS PARA FUNCIONARIOS: =========");
                System.out.println(funcionarios.toString());

                System.out.println("\n ========= DADOS PARA LEITO: =========");
                System.out.println(leitoHospitalares.toString());

                System.out.println("\n ========= DADOS PARA PACIENTES: =========");
                System.out.println(pacientes.toString());

                System.out.println("\n ========= DADOS PARA QUARTO: =========");
                System.out.println(quartoHospitalars.toString());
            }
        };

        texto.SobrescrevertoString();
    }

    //TODO TESTE DE IMPLEMENTAÇÃO DO MAP PARA APLICAR EM CLASSE DE LIMPEZA (RELEASE 3.3)
    public void MapearEquipes() {
        Equipe equipe1 = new Equipe("Equipe Delta", generetedUidd.generateId(), "vazio", "");
        Equipe equipe2 = new Equipe("Equipe Gama", generetedUidd.generateId(), "vazio", "");

        mapaEquipe.put("Lider Equipe", equipe1);
        mapaEquipe.put("Vice lider", equipe2);

        Equipe equipe = mapaEquipe.get("Lider Equipe");
        System.out.println("====== MAP PARA ENCONTRAR LIMPEZA =======");
        System.out.println(equipe.toString());

    }

    public void calcPacientesAguardando(){
        int totalPacientesAguardando = this.pacientes.size();

//        Paciente paciente =

        jlContPacientesAguardando.setText(String.valueOf(totalPacientesAguardando));

    }

    public void calcPacientesInternados() {

    }

    public ArrayList<Funcionario> getFuncionarios(){
        return this.funcionarios;
    }
    public ArrayList<Equipe> getEquipes(){
        return this.equipes;
    }
    public Set<UnidadeHospitalar> getUnidadeHospitalares(){ return this.unidadeHospitalares; }
    public ArrayList<Especialidade> getEspecialidades(){ return  this.especialidades; }
    public ArrayList<QuartoHospitalar> getQuartos(){ return  this.quartoHospitalars; }
    public ArrayList<LeitoHospitalar> getLeitos(){ return  this.leitoHospitalares; }
    public List<Equipamento> getEquipamentos(){ return equipamentos; }
    public ArrayList<Paciente> getPacientes(){ return this.pacientes ;}

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JFrame frame = new PrincipalUI();
        frame.setVisible(true);

//        SpringApplication.run(PrincipalUI.class, args);
//        SpringApplication app = new SpringApplication(PrincipalUI.class);
//        app.setDefaultProperties(Collections.singletonMap("server.port", "3333"));
//        app.run(args);
    }
}
