package TelasControle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaMenu implements ActionListener {
	TelaBanco telaBanco = new TelaBanco();
	TelaCliente telaCliente = new TelaCliente();
	TelaEmpregado telaEmpregado = new TelaEmpregado();
	TelaConta telaConta = new TelaConta();

	JMenuBar barraMenu = new JMenuBar();
	JFrame tela = new JFrame("Tela com MENU");
	JMenu menu = new JMenu("CADASTRO");
	JMenu menuAjuda = new JMenu("AJUDA");
	JMenu menuPesquisar = new JMenu("PESQUISAR");
	JMenuItem itemBanco = new JMenuItem("Cadastro de Banco");
	JMenuItem itemCliente = new JMenuItem("Cadastro de Cliente");
	JMenuItem itemEmpregado = new JMenuItem("Cadastro de Empregado");
	JMenuItem itemConta = new JMenuItem("Cadastro de Conta");
	JMenuItem itemSair = new JMenuItem("Sair");
	JPanel painel = new JPanel();
	JLabel Imagem = new JLabel();

	public void criarTela() {
		tela.setSize(800, 480);
		tela.setLocation(50, 50);
		tela.setVisible(true);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);

		barraMenu.setBounds(0, 0, 400, 30);

		Imagem.setBounds(80, 1, 500, 500);

		Imagem.setIcon(new ImageIcon("/home/marcelo/eclipse-workspace/CaelumLivro/src/Imagens/banco24.png"));

		painel.add(barraMenu);
		barraMenu.add(menu);
		barraMenu.add(menuPesquisar);
		barraMenu.add(menuAjuda);

		painel.add(Imagem);
		menu.add(itemConta);
		menu.add(itemEmpregado);
		menu.add(itemCliente);
		menu.add(itemBanco);
		menu.add(itemSair);
		itemConta.addActionListener(this);
		itemEmpregado.addActionListener(this);
		itemCliente.addActionListener(this);
		itemBanco.addActionListener(this);
		itemSair.addActionListener(this);

		tela.getContentPane().add(painel);

	}

	public static void main(String[] args) {
		TelaMenu obj = new TelaMenu();

		obj.criarTela();
	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == itemBanco) {
			// telaBanco.listaBanco();
			telaBanco.criarLista();
			telaBanco.criarTela();

		}
		if (evento.getSource() == itemCliente) {
			telaCliente.criarLista();
			telaCliente.criarTela();
		}

		if (evento.getSource() == itemEmpregado) {
			telaEmpregado.criarLista();
			telaEmpregado.criarTela();
		}
		if (evento.getSource() == itemConta) {
			telaConta.criarTela();
			telaConta.criarLista();
		}
		if (evento.getSource() == itemSair) {
			tela.dispose();
		}

	}
}
