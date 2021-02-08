
package guijuegoahorcado;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Juego {
    
    private String[] palabras = { "hola".toUpperCase(),"mundo".toUpperCase(),"oracle".toUpperCase() ,"programacion".toUpperCase() };
    
    private int posicionAl;
    private String palabra;
    private String palabraGuion;
    private char [] letras;
    private String res[];
    private String pal[];

    public Juego() {
        this.posicionAl = posicionAl;
        this.palabra = palabra;
        this.letras = letras;
        this.palabraGuion=palabraGuion;
    }

      
    
    public int posicion(){
        posicionAl= (int) Math.floor(Math.random() * palabras.length);
        return posicionAl;
    }
    public String palabra(){
        palabra = palabras[posicionAl];
        
        return palabra;
    }
    
    public String palabraGuion(){
        letras= palabra.toCharArray();
        char letrasguion[] = new char[letras.length];
        for(int i=0;i<palabra.length();i++){
        letrasguion[i] = '_';
        }
        palabraGuion=String.valueOf(letrasguion);
    
        return palabraGuion;
        }
        
     public String[] cosa(){
        res  = new String[palabras[posicionAl].length() + 1];
        return res;
     }
      public String[] silabas(){
       return this.pal = palabras[posicionAl].split(" ");
       
    }
}
   
            
            
