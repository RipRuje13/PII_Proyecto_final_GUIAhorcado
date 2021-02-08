
package guijuegoahorcado;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

public class VistaAhorcado extends JFrame {
       
    JButton botones[] = new JButton[26];
    JButton Jugar;
    JButton Resolver;
    JButton Salir;
    JTextField pantalla;
    JLabel muñeco;
    JPanel letras;
    JPanel texto;
    JPanel menu;
    JPanel superior;
    JPanel superior1;
    
    ImageIcon imagen[];
    
    
    public  VistaAhorcado(){
        pantalla = new JTextField("",30);
        Jugar = new JButton ("Jugar");
        Resolver = new JButton ("Resolver");
        Salir = new JButton ("Salir");
        imagen = new ImageIcon[5];
        imagen[0] = new ImageIcon(("1.jpg"));
        imagen[1] = new ImageIcon (("2.jpg"));
        imagen[2] = new ImageIcon(("3.jpg"));
        imagen[3] = new ImageIcon(("4.jpg")); 
        imagen[4] = new ImageIcon(("5.jpg")); 
        muñeco= new JLabel("");
//        muñeco.setIcon(imagen [0]);
                
        superior= new JPanel();
        superior1= new JPanel();
        letras = new JPanel();
        texto = new JPanel();
        menu = new JPanel();
        
        setDiseño();
        addComponentes();
        setComponentes();
        setVentana();
    }
    
    public void setDiseño(){ 
      letras.setLayout(new GridLayout(4,7) );
      letras.setBorder(BorderFactory.createTitledBorder("Teclado"));
      muñeco.setBorder(BorderFactory.createTitledBorder("Ahorcado"));
      muñeco.setLayout(new GridLayout() );
      menu.setBorder(BorderFactory.createTitledBorder("Menu"));
      texto.setBorder(BorderFactory.createTitledBorder("Palabra por Adivinar"));
      superior1.setLayout(new GridLayout(2,1) );

      
      this.setLayout(new BorderLayout ());
  }
    
    public void setComponentes(){
      pantalla.setEditable(false);
    }

    public void addComponentes(){
        for(int i=0;i<26;i++){
            char letra = (char)('a'+i);
            botones[i] = new JButton(letra+"");
        }
        for(int i=0;i<26;i++){           
            letras.add(botones[i]);
         
        }

        texto.add(pantalla);
        menu.add(Jugar);
        menu.add(Resolver);
        menu.add(Salir);
        superior1.add(menu);
        superior1.add(texto);
        superior.add(muñeco);
        this.add(superior1, BorderLayout.WEST);        
        this.add(superior, BorderLayout.EAST);        
        this.add(letras, BorderLayout.SOUTH);
      
    }
    
    public void setVentana(){
      this.setVisible(true);
      this.setTitle("Ahorcado");
      this.setSize(650,600);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setResizable(false);
      
  }

  
    
}
