package com.management.UI;

import com.management.*;
import com.management.UI.Equipe.EquipeAddFuncionario;
import com.management.UI.Equipe.EquipeFormUI;
import com.management.UI.Equipe.EquipeListaUI;
import com.management.UI.Especialidade.EspecialidadeFormUi;
import com.management.UI.Especialidade.EspecialidadeListaUI;
import com.management.UI.Funcionario.FuncionarioFormUI;
import com.management.UI.Funcionario.FuncionarioListaUI;
import com.management.UI.LeitoHospitalar.LeitoFormUI;
import com.management.UI.LeitoHospitalar.LeitoListaUI;
import com.management.UI.QuartoHospitalar.QuartoFormUI;
import com.management.UI.QuartoHospitalar.QuartoListaUI;
import com.management.UI.UnidadeHospitalar.UnidadeFormUI;
import com.management.UI.UnidadeHospitalar.UnidadeListaUI;

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
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Equipe> equipes;
    private ArrayList<Especialidade> especialidades;
    private ArrayList<UnidadeHospitalar> unidadeHospitalares;
    private ArrayList<QuartoHospitalar> quartoHospitalars;
    private ArrayList<LeitoHospitalar> leitoHospitalares;
    private ArrayList<Equipamento> equipamentos;
    private PrincipalUI principalUI;

    public PrincipalUI(){
        this.funcionarios = new ArrayList<Funcionario>();
        this.equipes = new ArrayList<Equipe>();
        this.unidadeHospitalares = new ArrayList<UnidadeHospitalar>();
        this.especialidades = new ArrayList<Especialidade>();
        this.quartoHospitalars = new ArrayList<QuartoHospitalar>();
        this.leitoHospitalares = new ArrayList<LeitoHospitalar>();
        this.equipamentos = new ArrayList<Equipamento>();

        criarEspecialidades();
        criarEquipoamentos();
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

        //UNIDADE - CRIAR UNIDADE HOSPITALR
        miCriarUnidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldUnidadeFormUI();
            }
        });

        //UNIDADE - LISTA UNIDADES HOSPITALARES
        miListarUnidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldUnidadeListaUI();
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

    //UNIDADES - CRIAR UNIDADE HOSPITALR
    private void chieldUnidadeFormUI(){
        UnidadeFormUI unidadeFormUI = new UnidadeFormUI(this);
        unidadeFormUI.setVisible(true);
    }

    //UNIDADES - LISTA UNIDADES HOSPITALARES
    public void chieldUnidadeListaUI(){
        UnidadeListaUI unidadeListaUI = new UnidadeListaUI(this);
        unidadeListaUI.setVisible(true);
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

    //QUARTO - LISTAR QUARTOS
    public void chieldLeitoFormUI(){
        LeitoFormUI leitoFormUI = new LeitoFormUI(this);
        leitoFormUI.setVisible(true);
    }

    //LEITO - LISTAR LEITOS
    public void chieldLeitoListaUI(){
        LeitoListaUI leitoListaUI = new LeitoListaUI(this);
        leitoListaUI.setVisible(true);
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

    public void criarEquipoamentos(){
        Equipamento equipamento1 = new Equipamento("Eletrocardiógrafos", 1);
        Equipamento equipamento2 = new Equipamento("Ventilador pulmonar.", 2);
        Equipamento equipamento3 = new Equipamento("Oxímetro", 3);
        Equipamento equipamento4 = new Equipamento("Monitor multiparamétrico", 4);
        Equipamento equipamento5 = new Equipamento("Desfibrilador", 5);
        this.equipamentos.add(equipamento1);
        this.equipamentos.add(equipamento2);
        this.equipamentos.add(equipamento3);
        this.equipamentos.add(equipamento4);
        this.equipamentos.add(equipamento5);
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


    public static void main(String[] args){
        JFrame frame = new PrincipalUI();
        frame.setVisible(true);
    }
}
