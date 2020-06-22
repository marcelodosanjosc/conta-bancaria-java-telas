package TelasControle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import exerciciocontabancaria.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.ClientDao;

/**
 *
 * @author marcelo
 */
public class TelaCliente implements ActionListener{
			ClientDao clientDao;
			
	
        Cliente[] cliente;
        int cont;
        
    
    JFrame tela = new JFrame("Cadastro de Cliente");
    JPanel painel = new JPanel();
    
    
    JLabel lnome = new JLabel("Nome");
    JLabel lendereco = new JLabel("Endereço");
   
    JLabel linformacao = new JLabel("Informaçães");
    
    JTextField txtnome = new JTextField();
    JTextField txtendereco = new JTextField();
    
    
    JButton btsalvar = new JButton("Salvar");
    JButton btlistar = new JButton("Listar");
    JButton btfechar = new JButton("Fechar");
    
    JTextArea area = new JTextArea();
    
    void criarTela(){
        tela.setSize(400,400);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocation(250,250);
        painel.setLayout(null);
        
      
        
        lnome.setBounds(10, 10, 100, 20);
        txtnome.setBounds(10, 35, 100, 25);
        
        linformacao.setBounds(180, 10, 100, 20);
        area.setBounds(130, 40, 230, 230);
        
       
        
        lendereco.setBounds(10, 130, 100, 20);
        txtendereco.setBounds(10, 160, 100, 25);
        
       
        
        
        btsalvar.setBounds(10, 330, 90, 25);
        btsalvar.addActionListener(this);
        
        btlistar.setBounds(140,330,90,25);
        btlistar.addActionListener(this);
        
        btfechar.setBounds(280, 330, 90, 25);
        btfechar.addActionListener(this);
        
        
       
        painel.add(lnome);
        painel.add(txtnome);
       
        painel.add(lendereco);
        painel.add(txtendereco);
      
        painel.add(linformacao);
        painel.add(area);
        
        painel.add(btsalvar);
        painel.add(btlistar);
        painel.add(btfechar);
             
        
        tela.getContentPane().add(painel);
        tela.setVisible(true);
        
    }

    
     void criarLista(){
        cliente = new Cliente[5];
    }
     
      void inserir(){
    	 
        if (cont ==5){
            JOptionPane.showMessageDialog(null, "Lista cheia");
        }else{
        	 clientDao = new ClientDao();
            cliente[cont] = new Cliente();
            
            cliente[cont].setNome(txtnome.getText());
            cliente[cont].setEndereco(txtendereco.getText());
            clientDao.salvar(cliente[cont]);
            cont++;
        }
      }
      
       void listar(){
    	   clientDao = new ClientDao();
     
    	   List<Cliente> list;
           //area.setText("");
           
           
           try {
				list = clientDao.listar();
				for (Cliente cliente : list) {
					area.append("\n Nome: "+cliente.getNome()+
							"\n Agencia: " +cliente.getEndereco());
				}
				
			} catch (Exception e) {
		
				e.printStackTrace();
			}
            
       }
       

    public void actionPerformed(ActionEvent e) {
         if (e.getSource() ==btsalvar){
            
           inserir();
            JOptionPane.showMessageDialog(null, "dados salvo");
            
            txtnome.setText("");
           
            txtendereco.setText("");
           
            
            
            
            
        }else if (e.getSource() == btlistar){
           listar();
        }else if(e.getSource() ==btfechar){
          tela.dispose();
        }
        
    }
    
}
