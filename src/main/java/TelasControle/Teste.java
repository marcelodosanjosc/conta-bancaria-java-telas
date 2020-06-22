package TelasControle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author marcelo
 */
public class Teste {
    public static void main(String[] args) {
        TelaBanco tb = new TelaBanco();
        tb.criarTela();
        
      
       // tb.listaBanco();
        System.out.println(tb.area.getText());
        tb.criarLista();
     
        System.out.println( "Aqui finalisacoma lista:"+tb.listaVetor().toString());
      
    }
}
