package TelasControle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import exerciciocontabancaria.Empregado;
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

import dao.EmpregadoDao;

/**
 *
 * @author marcelo
 */
public class TelaEmpregado implements ActionListener{
	EmpregadoDao empregadoDao;
	
    Empregado[] empregado;
    int cont;
    
    JFrame tela = new JFrame("Cadastro de Empregado");
    JPanel painel = new JPanel();
    
    
    JLabel lcodigo = new JLabel("Codigo");
    JLabel lnome = new JLabel("Nome");
    JLabel lfuncao = new JLabel("Função");
    
    JLabel linformacao = new JLabel("Informaçães");
    
    JTextField txtcodigo = new JTextField();
    JTextField txtnome = new JTextField();
    JTextField txtfuncao = new JTextField();
    
    
    JButton btsalvar = new JButton("Salvar");
    JButton btlistar = new JButton("Listar");
    JButton btfechar = new JButton("Fechar");
    
    JTextArea area = new JTextArea();
    
    void criarTela(){
        tela.setSize(400,400);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocation(250,250);
        painel.setLayout(null);
        
      
        
        lcodigo.setBounds(10, 10, 100, 20);
        txtcodigo.setBounds(10, 35, 100, 25);
        
        linformacao.setBounds(180, 10, 100, 20);
        area.setBounds(130, 40, 230, 230);
        
        
        lnome.setBounds(10, 70, 100, 20);
        txtnome.setBounds(10, 100, 100, 25);
        
        lfuncao.setBounds(10, 130, 100, 20);
        txtfuncao.setBounds(10, 160, 100, 25);
     
        
        btsalvar.setBounds(10, 330, 90, 25);
        btsalvar.addActionListener(this);
        
        btlistar.setBounds(140,330,90,25);
        btlistar.addActionListener(this);
        
        btfechar.setBounds(280, 330, 90, 25);
        btfechar.addActionListener(this);
        
        
       
        painel.add(lcodigo);
        painel.add(txtcodigo);
        painel.add(lnome);
        painel.add(txtnome);
        painel.add(lfuncao);
        painel.add(txtfuncao);
     
        painel.add(linformacao);
        painel.add(area);
        
        painel.add(btsalvar);
        painel.add(btlistar);
        painel.add(btfechar);
             
        
        tela.getContentPane().add(painel);
        tela.setVisible(true);
        
    }
     void criarLista(){
        empregado = new Empregado[5];
    }
     
      void inserir(){
        if (cont ==5){
            JOptionPane.showMessageDialog(null, "Lista cheia");
        }else{
        	empregadoDao = new EmpregadoDao();
            empregado[cont] = new Empregado();
            
            empregado[cont].setCodigo(Integer.parseInt(txtcodigo.getText()));
            empregado[cont].setNome(txtnome.getText());
            empregado[cont].setFuncao(txtfuncao.getText());
            empregadoDao.salvar(empregado[cont]);
            cont++;
        }
      }
      
       void listar(){
    	   empregadoDao = new EmpregadoDao();
    	   List<Empregado> list;
           //area.setText("");
           
           
           try {
				list = empregadoDao.listar();
				for (Empregado empregado : list) {
					area.append("\n Codigo: "+empregado.getCodigo()+
							"\n Nome: " +empregado.getNome()+
							"\n Função: "+empregado.getFuncao());
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
       
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==btsalvar){
            
            inserir();
            JOptionPane.showMessageDialog(null, "dados salvo");
            
            txtcodigo.setText("");
            txtnome.setText("");
            txtfuncao.setText("");
       
            
            
            
            
        }else if (e.getSource() == btlistar){
           listar();
        }else if(e.getSource() ==btfechar){
          tela.dispose();
        }
        
        
    }
    
}

