package TelasControle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import exerciciocontabancaria.Banco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.UserPosDAO;

/**
 *
 * @author marcelo
 */
public class TelaBanco implements ActionListener{
	UserPosDAO userPosDAO;
	
    Banco[] banco;
    int cont;
    
    
     List<Banco> listarBanco; 
      Banco b;
    
    JFrame tela = new JFrame("Cadastro de Banco");
    JPanel painel = new JPanel();
    
    
    JLabel lnome = new JLabel("Nome");
    JLabel lagencia = new JLabel("Agencia");
    
    JLabel linformacao = new JLabel("Informaçães");
    
    JTextField txtnome = new JTextField();
    JTextField txtagencia = new JTextField();
  
    
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
        
        
      
        
        lagencia.setBounds(10, 130, 100, 20);
        txtagencia.setBounds(10, 160, 100, 25);
        
       
        
        btsalvar.setBounds(10, 330, 90, 25);
        btsalvar.addActionListener(this);
        
        btlistar.setBounds(140,330,90,25);
        btlistar.addActionListener(this);
        
        btfechar.setBounds(280, 330, 90, 25);
        btfechar.addActionListener(this);
        
        
       
        painel.add(lnome);
        painel.add(txtnome);
      
        painel.add(lagencia);
        painel.add(txtagencia);
        painel.add(linformacao);
        painel.add(area);
        
        painel.add(btsalvar);
        painel.add(btlistar);
        painel.add(btfechar);
             
        
        tela.getContentPane().add(painel);
        tela.setVisible(true);
        
    }
     
       
      
        
        
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() ==btsalvar){
            
            inserir();
           
            JOptionPane.showMessageDialog(null, "dados salvo");
            
            txtnome.setText("");
            txtagencia.setText("");
            
            
            
            
            
        }else if (e.getSource() == btlistar){
           
           //listaBanco();
           listar();
           listaVetor();
           
        }else if(e.getSource() ==btfechar){
          tela.dispose();
        }
    }
    
    void criarLista(){
        banco = new Banco[5];
        listarBanco = new ArrayList<Banco>();
        
    }
     
      void inserir(){
        if (cont ==5){
            JOptionPane.showMessageDialog(null, "Lista cheia");
        }else{
        	userPosDAO = new UserPosDAO();
            banco[cont] = new Banco();
            
            banco[cont].setNome(txtnome.getText());
            banco[cont].setAgencia(txtagencia.getText());
            userPosDAO.salvar(banco[cont]);
            cont++;
        }
      }
      
       void listar(){
    	   UserPosDAO dao = new UserPosDAO();
    	   
      
        	List<Banco> list;
          
            
            
            try {
				list = dao.listar();
				for (Banco banco : list) {
					area.append("\n Nome: "+banco.getNome()+
							"\n Agencia: " +banco.getAgencia());
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
       }
    
        public Banco [] listaVetor(){
           
            if(cont == 5){
                JOptionPane.showMessageDialog(null, "Vazio");
            }else{
                
            
            for (int i = 0; i< cont;i++){
                banco[i].getNome();
                banco[i].getAgencia();
            }
            }
            return banco;
        }
}

