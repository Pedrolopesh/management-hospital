package com.management.UI;

import com.management.Equipe;
import com.management.Funcionario;
import com.management.UI.Equipe.EquipeAddFuncionario;
import com.management.UI.Equipe.EquipeFormUI;
import com.management.UI.Equipe.EquipeListaUI;
import com.management.UI.Funcionario.FuncionarioFormUI;
import com.management.UI.Funcionario.FuncionarioListaUI;
import com.management.UI.UnidadeHospitalar.UnidadeFormUI;
import com.management.UnidadeHospitalar;

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
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Equipe> equipes;
    private ArrayList<UnidadeHospitalar> unidadeHospitalares;
    private PrincipalUI principalUI;

    public PrincipalUI(){
        this.funcionarios = new ArrayList<Funcionario>();
        this.equipes = new ArrayList<Equipe>();

        //DEFINE COMO A JANELA VAI SER FECHADA
        //EXIT_ON_CLOSE = FECHA A JANELA E O SISTEMA PARA DE FUNCIONAR
        //DISPOSE_ON_CLOSE = FECHA A JANELA E SISTEMA CONTINUA FUNCIONANDO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //VAI COLOCAR EM TELA TODOS OS COMPONENTES
        this.setContentPane(mainPanel);
        this.pack();

        //CRIAR FUNCIONARIO
        miCriarFuncinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferToChieldFuncionarioFormUI();
            }
        });

        //LISTA DE FUNCIONARIOS
        miListarFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferToChieldFuncionarioListaUI();
            }
        });

        //CRIAR EQUIPE
        miCriarEquipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldEquipeFormUI();
            }
        });

        //LISTAR Equipes
        miListarEquipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldEquipeListaUI();
            }
        });

        //ADICIONAR FUNCIONARIO A UMA EQUIPE
        miAddFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldEquipeAddFuncionario();
            }
        });

        //CRIAR UNIDADE HOSPITALR
        miCriarUnidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chieldUnidadeFormUI();
            }
        });
    }

    //CRIAR FUNCIONARIO
    private void transferToChieldFuncionarioFormUI(){
        FuncionarioFormUI funcionarioFormUI = new FuncionarioFormUI(this);
        funcionarioFormUI.setVisible(true);
    }

    //LISTA DE FUNCIONARIOS
    private void transferToChieldFuncionarioListaUI(){
        FuncionarioListaUI funcionarioListaUI = new FuncionarioListaUI(this);
        funcionarioListaUI.setVisible(true);
    }

    //CRIAR EQUIPE
    private void chieldEquipeFormUI(){
        EquipeFormUI equipeFormUI = new EquipeFormUI(this);
        equipeFormUI.setVisible(true);
    }

    //LISTA DE EQUIPES
    private void chieldEquipeListaUI(){
        EquipeListaUI equipeListaUI = new EquipeListaUI(this);
        equipeListaUI.setVisible(true);
    }

    //ADICIONAR FUNCIONARIO A UMA EQUIPE
    private void chieldEquipeAddFuncionario(){
        EquipeAddFuncionario equipeAddFuncionario = new EquipeAddFuncionario(this);
        equipeAddFuncionario.setVisible(true);
    }

    //CRIAR UNIDADE HOSPITALR
    private void chieldUnidadeFormUI(){
        UnidadeFormUI unidadeFormUI = new UnidadeFormUI(this);
        unidadeFormUI.setVisible(true);
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

    public static void main(String[] args){
        JFrame frame = new PrincipalUI();
        frame.setVisible(true);
    }
}
