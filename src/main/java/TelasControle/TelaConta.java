package TelasControle;

import dao.ClientDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import dao.ContaDao;
import dao.UserPosDAO;
import exerciciocontabancaria.Banco;
import exerciciocontabancaria.Cliente;
import exerciciocontabancaria.Conta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author marcelo
 */
public class TelaConta implements ActionListener{
		ContaDao contaDao;
		ClientDao clientDao;
		UserPosDAO posDAO;
	
        Conta[] conta;
        int cont;
      List<TelaBanco> listabanco;
      List<TelaCliente> listacliente;
     
      Banco b = new Banco();
      Cliente c = new Cliente();
        
        
    JFrame tela = new JFrame("Cadastro de Conta");
    JPanel painel = new JPanel();
    
    
    JLabel lcliente= new JLabel("Escolha Cliente");// deixa troca nome
    JLabel lnumero = new JLabel("Numero");
    JLabel lbanco = new JLabel("Escolha Banco");
    JLabel lsaldo = new JLabel("Saldo");
    JLabel ldata = new JLabel("Data de abertura");
    JLabel linformacao = new JLabel("Informaçães");
    JLabel ltransacoes = new JLabel(" Transaçoes");
    
    JComboBox<String>  cbCliente = new JComboBox<String>();
    JTextField txtcliente = new JTextField();
    JTextField txtnumero = new JTextField();
    JComboBox<String> cbBanco = new JComboBox<String>();
    JTextField txtbanco = new JTextField();
    JTextField txtsaldo = new JTextField();
    JTextField txtdata = new JTextField();
    JTextField txttransacoes = new JTextField();
    
    JButton btsalvar = new JButton("Salvar");
    JButton btlistar = new JButton("Listar");
    JButton btfechar = new JButton("Fechar");
    JButton btsaque = new JButton("Sacar");
    JButton btdepositar = new JButton("Depositar");
    
    JTextArea area = new JTextArea();
    
    void criarTela(){
        tela.setSize(500,500);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocation(250,250);
        painel.setLayout(null);
        
      
        
        lcliente.setBounds(10, 10, 150, 20);
        cbCliente.setBounds(10, 30, 150, 25);
        txtcliente.setBounds(10, 60, 100, 25);
        
        linformacao.setBounds(290, 10, 100, 20);
        area.setBounds(230, 40, 230, 230);
        
        
        lnumero.setBounds(10, 90, 100, 20);
        txtnumero.setBounds(10, 120, 100, 25);
        
        lbanco.setBounds(10, 150, 150, 20);
        cbBanco.setBounds(10, 180, 150, 25);
        txtbanco.setBounds(10, 210, 100, 25);
        
        lsaldo.setBounds(10, 240, 100, 20);
        txtsaldo.setBounds(10, 280, 100, 25);
        
        ldata.setBounds(10, 310, 150, 20);
        txtdata.setBounds(10, 340, 100, 25);
        
        ltransacoes.setBounds(250, 310, 100, 20);
        txttransacoes.setBounds(250,340,150,25);
        btsaque.setBounds(250, 380, 90, 25);
        btdepositar.setBounds(350, 380, 150, 25);
        
        
        btsalvar.setBounds(10, 440, 90, 25);
        btsalvar.addActionListener(this);
        
        btlistar.setBounds(140,440,90,25);
        btlistar.addActionListener(this);
        
        btfechar.setBounds(280, 440, 90, 25);
        btfechar.addActionListener(this);
        
        
        painel.add(ltransacoes);
        painel.add(txttransacoes);
        painel.add(lcliente);
        painel.add(cbCliente);
        painel.add(txtcliente);
        painel.add(lnumero);
        painel.add(txtnumero);
        painel.add(lbanco);
        painel.add(cbBanco);
        painel.add(txtbanco);
        painel.add(lsaldo);
        painel.add(txtsaldo);
        painel.add(ldata);
        painel.add(txtdata);
        painel.add(linformacao);
        painel.add(area);
        
        painel.add(btsaque);
        painel.add(btdepositar);
        painel.add(btsalvar);
        painel.add(btlistar);
        painel.add(btfechar);
             
        
        tela.getContentPane().add(painel);
        tela.setVisible(true);
        
    }
     void criarLista(){
    	conta = new Conta[5];

     	contaDao = new ContaDao();
     	clientDao = new ClientDao();
     	posDAO = new UserPosDAO();
    	 
     	cbCliente.addItem("");
     	cbBanco.addItem("");
       
        List<Cliente> listCliente;
        
        try {
        	listCliente = clientDao.listar();
			for (Cliente cliente : listCliente) {
				cbCliente.addItem(cliente.getNome());
			}
			
		} catch (Exception e) {
		

		}
        
        List<Banco> listBanco;
        
        try {
			listBanco = posDAO.listar();
			for (Banco banco : listBanco) {
			  cbBanco.addItem(banco.getNome());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

        
    }
     
      void inserir(){
        if (cont ==5){
            JOptionPane.showMessageDialog(null, "Lista cheia");
        }else{
        	
        	contaDao = new ContaDao();
        	clientDao = new ClientDao();
        	posDAO = new UserPosDAO();

        	txtcliente.setText(cbCliente.getSelectedItem().toString());
        	txtbanco.setText(cbBanco.getSelectedItem().toString());
            
         
            c.setNome(txtcliente.getText());
            b.setNome(txtbanco.getText());;
       
            
            
            conta[cont].setTitular(c);
            conta[cont].setNumero(Integer.parseInt(txtnumero.getText()));
            conta[cont].setAgencia(b);
            conta[cont].setSaldo(Double.parseDouble(txtsaldo.getText()));
            conta[cont].setDataDeAbertura(txtdata.getText());
            contaDao.salvar(conta[cont]);
            cont++;
        }
      }
      
       void listar(){
        contaDao = new ContaDao();
               List<Conta> list;
               
               try {
				list = contaDao.listar();
				  for (Conta conta : list) {
	            	   area.append("\nTitula: " +conta.getTitular()+
	            			   "\n Numero: " +conta.getNumero()+
	            			   "\n Banco: " +conta.getAgencia()+
	            			   "\n Saldo: "+conta.getSaldo()+
	            			   "\n Data: "+conta.getDataDeAbertura());
	               }
			} catch (Exception e) {
			
				e.printStackTrace();
			}
               
             
           
                    
                    
            
       }
       
    
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() ==btsalvar){
            
            inserir();
            JOptionPane.showMessageDialog(null, "dados salvo");
            
            txtcliente.setText("");
            txtnumero.setText("");
            txtbanco.setText("");
            txtsaldo.setText("");
            txtdata.setText("");
            
            
            
            
        }else if (e.getSource() == btlistar){
           listar();
        }else if(e.getSource() ==btfechar){
          tela.dispose();
        }

    }
    
}

