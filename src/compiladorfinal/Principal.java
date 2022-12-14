/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorfinal;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.Token;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java_cup.runtime.Scanner;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MrCante
 */
public class Principal extends javax.swing.JFrame {

    private String title;

    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
  
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
    /**
     * Creates new form Principal
     */
    
    String Entrada="";
    String If="";
    String While="";
    int conta=0;
    String [][]ts =new String [100][7]; //Array en donde se almacena en forma temporal todos los ID encontrados
    
    public Principal() {
        initComponents();
        init();
    }

    private void init() {
        title = "Compilador";
        setLocationRelativeTo(null);
        setTitle(title);
      
       
       
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
         
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
    
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        BtnAnalziar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtErrores = new javax.swing.JTextArea();
        LblResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Instrucciones");

        jtpCode.setColumns(20);
        jtpCode.setRows(5);
        jtpCode.setText("Mensaje.texto(\"Hola\");\n\n");
        jScrollPane1.setViewportView(jtpCode);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setText("Compilador");

        BtnAnalziar.setBackground(new java.awt.Color(0, 51, 255));
        BtnAnalziar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnAnalziar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAnalziar.setText("Compilar");
        BtnAnalziar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnalziarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Errores  Detectados:");

        TxtErrores.setColumns(20);
        TxtErrores.setRows(5);
        jScrollPane2.setViewportView(TxtErrores);

        LblResultado.setBackground(new java.awt.Color(255, 204, 153));
        LblResultado.setText("RESULTADO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(LblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(BtnAnalziar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(LblResultado)
                .addGap(42, 42, 42)
                .addComponent(BtnAnalziar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAnalziarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnalziarActionPerformed
        
        Entrada = jtpCode.getText(); //CARGAR TEXTO EN VARIABBLE
        
        //REVISAR GRAMATICA
        try {
            new parser(new Lexico(new BufferedReader(new StringReader(Entrada)))).parse();
            mostrarListas();//MOSTRAR EL VALOR DE LAS LINKEDLIST DE CADA           
            LblResultado.setText("RESULTADO: COMPILADO CON ??XITO");
        }
        catch (Exception ex) {
            System.out.println("RESULTADO: NO SE HA PODIDO COMPILAR");
            LblResultado.setText("RESULTADO: NO SE HA PODIDO COMPILAR");
            
           
            TxtErrores.setText("" + parser.Errores);
        }

    }//GEN-LAST:event_BtnAnalziarActionPerformed
    
    //LISTAS PARA GENERAR TABLA DE SIMBOLOS
    public void mostrarListas(){

        //ELIMINAR DUPLICADOS CON HasSet, se le pasa la lista, se limpia la lista antigua y luego se recarga la nueva lista
        // TOKEN - PR - IDENTIFICADOR - CADENA - NUMERO - SIMBOLO - TIPO
        //PALABRAS RESERVADAS
        HashSet<String> hashSet = new HashSet<String>(parser.PalabraReservada);
	parser.PalabraReservada.clear();
	parser.PalabraReservada.addAll(hashSet);
		
        for(String cadena : parser.PalabraReservada){
            System.out.println(conta + " Palabra Reservada: " + cadena);
            ts[conta][0] = conta+ ". " + cadena; ts[conta][1] = "x"; 
            ts[conta][2] = ""; ts[conta][3] = ""; ts[conta][4] = ""; ts[conta][5] = ""; ts[conta][6] = "";
            conta++;
        }
        
        //VALORES VARIABLES
        HashSet<String> hashSet5 = new HashSet<String>(parser.Variables);
	parser.Variables.clear();
	parser.Variables.addAll(hashSet5);
		
        for(String cadena : parser.Variables){
            System.out.println(conta + " Variables: " + cadena);
            ts[conta][0] = conta+ ". " + cadena; ts[conta][2] = "x"; ts[conta][6] = "";
            ts[conta][1] = ""; ts[conta][3] = ""; ts[conta][4] = ""; ts[conta][5] = ""; ts[conta][6] = "";
            conta++;
        }
        
        // TOKEN - PR - IDENTIFICADOR - CADENA - NUMERO - SIMBOLO - TIPO
        //CADENAS
        HashSet<String> hashSet3 = new HashSet<String>(parser.Cadenas);
	parser.Cadenas.clear();
	parser.Cadenas.addAll(hashSet3);
		
        for(String cadena : parser.Cadenas){
            System.out.println(conta + " Cadena: " + cadena);
            ts[conta][0] = conta+ ". " + cadena; ts[conta][3] = "x"; ts[conta][6] = "String";
            ts[conta][2] = ""; ts[conta][1] = ""; ts[conta][4] = ""; ts[conta][5] = ""; 
            conta++;
        }
        
        
        //VALORES NUM??RICOS
        HashSet<String> hashSet4 = new HashSet<String>(parser.ValoresNumericos);
	parser.ValoresNumericos.clear();
	parser.ValoresNumericos.addAll(hashSet4);
		
        for(String cadena : parser.ValoresNumericos){
            System.out.println(conta + " Valores num??ricos: " + cadena);
            ts[conta][0] = conta+ ". " + cadena; ts[conta][4] = "x"; ts[conta][6] = "Float";
            ts[conta][2] = ""; ts[conta][3] = ""; ts[conta][1] = ""; ts[conta][5] = "";
            conta++;
        }

        //SIMBOLOS
        HashSet<String> hashSet2 = new HashSet<String>(parser.Simbolo);
	parser.Simbolo.clear();
	parser.Simbolo.addAll(hashSet2);
		
        for(String cadena : parser.Simbolo){
            System.out.println(conta + " Simbolo: " + cadena);
            ts[conta][0] = conta+ ". " + cadena; ts[conta][5] = "x";
            ts[conta][2] = ""; ts[conta][3] = ""; ts[conta][4] = ""; ts[conta][1] = ""; ts[conta][6] = "";
            conta++;
        }
        
        // TOKEN - PR - IDENTIFICADOR - CADENA - NUMERO - SIMBOLO - TIPO
        for (int i = 0; i < conta-1; i++) {
            System.out.println("Token: " + ts[i][0] + " TR: " + ts[i][1] + " IDENT: " + ts[i][2] + " CADENA: " + ts[i][3] + " NUMERO: " + ts[i][4] + " SIMBOLO: " + ts[i][5] + " TIPO: " + ts[i][6]);
        }
        
       
    }
    
   
    
    //RECORRER ARBOL
    public static String recorrido(Nodo raiz){
        String cuerpo="";
        for (Nodo hijos : raiz.getHijos()) {
            
            cuerpo += "\"" + raiz.getIdNod() + "." + raiz.getEtiqueta() + "=" + raiz.getValor() + "\"->\"" + hijos.getIdNod() + "." + hijos.getEtiqueta() + "=" + hijos.getValor() + "\"";
            //System.out.println("Cuerpo: " + cuerpo);
            cuerpo += recorrido(hijos);            
        }
        return cuerpo;
    }
    
    //TRADUCIR A GRAPHVIZ
    public void graficar(Nodo raiz){
        FileWriter archivo = null;
        PrintWriter pw = null;
        String cadena = recorrido(raiz);
        
        try{
            archivo = new FileWriter("src/Salida/arbol.dot");
            pw = new PrintWriter(archivo);
            pw.println("digraph G {node[shape=octagon, style=filled, color=blanchedalmond]; edge[color=chocolate3];rankdir=UD \n");
            pw.println(cadena);
            pw.println("\n}");
            archivo.close();
            System.out.println("Arbol Generado con exito");
        }catch (Exception e) {
            System.out.println(e +" 1");
        }
        
        try {
            String dotPath = "c:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe"; //RUTA DE GRAPHVIZ
            String cmd = dotPath + " -Tpng src/Salida/arbol.dot -o src/Salida/arbol.png";
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe +" 2");
        }
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnalziar;
    private javax.swing.JLabel LblResultado;
    private javax.swing.JTextArea TxtErrores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtpCode;
    // End of variables declaration//GEN-END:variables

}
