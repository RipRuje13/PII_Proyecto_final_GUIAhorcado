package guijuegoahorcado;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Controlador {

    VistaAhorcado va;
    Juego j = new Juego();
    public int err;
    String res[];

    public Controlador() {
        va = new VistaAhorcado();
        va.Jugar.addActionListener(new ObjetoEscuchaJugar());
        va.Resolver.addActionListener(new ObjetoEscuchaResolver());
        va.Salir.addActionListener(new ObjetoEscuchaSalir());
        for (int i = 0; i < 26; i++) {
            va.botones[i].addActionListener(new ObjetoEscuchaLetras());
        }

    }

    public class ObjetoEscuchaJugar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            start();

        }
    }

    public class ObjetoEscuchaResolver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de rendirte ?", "Resolver", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                va.pantalla.setText(j.palabra());
            }

        }
    }

    public class ObjetoEscuchaSalir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e2) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas salir ?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                System.exit(0);
            }
        }
    }

    public class ObjetoEscuchaLetras implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e1) {
//           for(int i = 0 ; i<26; i++){
//                va.botones[i].addActionListener(this);
            revisarLetras(e1);
//            }   
        }
    }

    public void start() {
        err = 0;
        j.posicion();
        va.muñeco.setIcon(va.imagen[0]);
        va.pantalla.setText("");
        for (int i = 1; i < 26; i++) {
            va.botones[i].setEnabled(true);
        }
        res = new String[j.palabra().length() + 1];
        int k = 0;
        for (String pal1 : j.silabas()) {
            for (int i = 0; i < pal1.length(); i++) {
                va.pantalla.setText(va.pantalla.getText() + " _ ");
                res[k++] = "_";
            }
            va.pantalla.setText(va.pantalla.getText() + "\n");
            res[k++] = " ";
        }

    }

    public void revisarLetras(ActionEvent e1) {

        JButton bt = (JButton) e1.getSource();
        char c[];
        for (int i = 0; i < 26; i++) {
            if (bt == va.botones[i]) {
                String s = va.botones[i].getText();
                c = Character.toChars(65 + i);
                boolean esta = false;

                for (int k = 0; k < j.palabra().length(); k++) {
                    if (c[0] == j.palabra().charAt(k)) {
                        res[k] = c[0] + "";
                        esta = true;
                    }

                }

                if (esta) {
                    va.pantalla.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                            va.pantalla.setText(va.pantalla.getText() + "\n");
                        } else {
                            va.pantalla.setText(va.pantalla.getText() + re + " ");
                        }
                    }

                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }
                    }

                    if (gano) {
                        JOptionPane.showMessageDialog(va, "Ganaste :D");
                        start();
                        return;
                    } else {

                    }
                    bt.setEnabled(false);
                    break;
                } else {
                    err++;
                    va.muñeco.setIcon(va.imagen[err]);
                }

                if (err == 4) {
                    JOptionPane.showMessageDialog(va, "Intenta con otra palabra la respuesta es: \n" + j.palabra());
                    start();
                    return;
                }

                bt.setEnabled(false);
                
            }
        }
    }

}
