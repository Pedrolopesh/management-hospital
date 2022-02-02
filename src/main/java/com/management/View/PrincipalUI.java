package com.management.View;

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
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private PrincipalUI principalUI;
    private JMenuItem miPesquisaFuncionario;
    private JMenuItem miPesquisaEquipe;
    private JMenuItem miEditarFuncionario;
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

    public PrincipalUI(){
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

        //EQUIPES - TROCAR FUNCIONARIO DE EQUIPE
        miEditarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarEquipesFuncionarioUI();
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

        //PACIENTE - ADICIONAR PACIENTE EM LEITO
        miLeitoAddPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leitoAddPacienteUI();
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

        //EQUIPAMENTO - EDITAR EQUIPAMENTO
        miEquipamentoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipamentoEditarUI();
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

    //EQUIPES - TROCAR FUNCIONARIO DE EQUIPE
    public void editarEquipesFuncionarioUI(){
        EquipeEditaFuncionarioFormUI equipeEditaFuncionarioFormUI = new EquipeEditaFuncionarioFormUI(this);
        equipeEditaFuncionarioFormUI.setVisible(true);
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

    public void equipamentoEditarUI(){
        EquipamentoFormEditarUI editarNewEquipamentoFormUI = new EquipamentoFormEditarUI(this);
        editarNewEquipamentoFormUI.setVisible(true);
    }


    public void criarDadosTest(){
        Especialidade especialidade1 = new Especialidade(1);
        Especialidade especialidade2 = new Especialidade("Cardiologia", 2);
        Especialidade especialidade3 = new Especialidade("Neurologia", 3);
        Especialidade especialidade4 = new Especialidade("Reumatologia", 4);
        Especialidade especialidade5 = new Especialidade("Cirurgia torácica", 5);
        Especialidade especialidade6 = new Especialidade("Outra", 6);
        especialidade1.setNomeEspecialidade("Dermatologia");
        this.especialidades.add(especialidade1);
        this.especialidades.add(especialidade2);
        this.especialidades.add(especialidade3);
        this.especialidades.add(especialidade4);
        this.especialidades.add(especialidade5);
        this.especialidades.add(especialidade6);

        Equipamento equipamento1 = new Equipamento("Eletrocardiógrafos", 1,1);
        Equipamento equipamento2 = new Equipamento("Ventilador pulmonar.", 2,2);
        Equipamento equipamento3 = new Equipamento("Oxímetro", 3,3);
        Equipamento equipamento4 = new Equipamento("Monitor multiparamétrico", 4,4);
        Equipamento equipamento5 = new Equipamento("Desfibrilador", 5,5);
        equipamentos.add(equipamento1);
        equipamentos.add(equipamento2);
        equipamentos.add(equipamento3);
        equipamentos.add(equipamento4);
        equipamentos.add(equipamento5);

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

        Equipe equipe1 = new Equipe("Equipe Delta", 1, "vazio");
        Equipe equipe2 = new Equipe("Equipe Gama", 2, "vazio");
        this.equipes.add(equipe1);
        this.equipes.add(equipe2);

        equipe1.addFuncionario(funcionario1);
        equipe1.setLiderEquipe(funcionario1.getNome());
        funcionario1.setStatusFuncionario("emEquipe");

        equipe1.addFuncionario(funcionario2);
        funcionario2.setStatusFuncionario("emEquipe");

        equipe1.setStatusEquipe("funcionarios");

        UnidadeHospitalar unidade1 = new UnidadeHospitalar("A", 1);
        unidade1.setEspecialidade("Dermatologia");
        UnidadeHospitalar unidade2 = new UnidadeHospitalar("B", 2);
        unidade2.setEspecialidade("Reumatologia");
        this.unidadeHospitalares.add(unidade1);
        this.unidadeHospitalares.add(unidade2);

        QuartoHospitalar quart1 = new QuartoHospitalar("Quarto 1A", 1, 10);
        QuartoHospitalar quart2 = new QuartoHospitalar("Quarto 2A", 2, 10);
        QuartoHospitalar quart3 = new QuartoHospitalar("Quarto 3A", 3, 10);
        QuartoHospitalar quart4 = new QuartoHospitalar("Quarto 4A", 4, 10);
        this.quartoHospitalars.add(quart1);
        this.quartoHospitalars.add(quart2);
        this.quartoHospitalars.add(quart3);
        this.quartoHospitalars.add(quart4);

        LeitoHospitalar leito1 = new LeitoHospitalar(1);
        LeitoHospitalar leito2 = new LeitoHospitalar(2);
        LeitoHospitalar leito3 = new LeitoHospitalar(3);
        this.leitoHospitalares.add(leito1);
        this.leitoHospitalares.add(leito2);
        this.leitoHospitalares.add(leito3);
        leito1.addEquipamento(equipamento1);
        leito2.addEquipamento(equipamento2);

        quart1.addLeitoHospitalar(leito1);
        quart1.addLeitoHospitalar(leito2);


        Paciente paciente1 = new Paciente("Maria", 1, "(48) 99942-2614", 18, 1.77, 60.5, "Não possui", "COVID-19", true, "Isolamento imediato", "aguardando");
        Paciente paciente2 = new Paciente("João", 2, "(48) 9823-2019", 20, 1.80, 70.4, "Asmático", "COVID-19", true, "Isolamento Imediato", "aguardando");
        Paciente paciente3 = new Paciente("Paulo", 3, "(21) 99982-2093", 38, 1.85, 80.5, "Diabetes", "infecção", false, "Não possui", "aguardando");
        Paciente paciente4 = new Paciente("Gustavo", 4, "(11) 99523-3048", 28, 1.68, 60.5, "Não possui", "não concluído", false, "Não possui", "aguardando");
        this.pacientes.add(paciente1);
        this.pacientes.add(paciente2);
        this.pacientes.add(paciente3);
        this.pacientes.add(paciente4);

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
        Equipe equipe1 = new Equipe("Equipe Delta", 1, "vazio");
        Equipe equipe2 = new Equipe("Equipe Gama", 2, "vazio");

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

    public static void main(String[] args){
        JFrame frame = new PrincipalUI();
        frame.setVisible(true);

//        SpringApplication.run(PrincipalUI.class, args);
//        SpringApplication app = new SpringApplication(PrincipalUI.class);
//        app.setDefaultProperties(Collections.singletonMap("server.port", "3333"));
//        app.run(args);
    }
}
