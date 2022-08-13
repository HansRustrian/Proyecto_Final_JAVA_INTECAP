package com.mycompany.proyectofinal_java_intecap;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class login extends JFrame {

    JPanel p1 = new JPanel();
    JTextField t1 = new JTextField();
    JPasswordField t2 = new JPasswordField();
    Object usuarios[][] = new Object[50][9];
    int oportunidades = 3;

    //metodos
    private void inicio() throws ClassNotFoundException {

        load();

        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(50, 175, 400, 400);
        setVisible(true);
        p1.setLayout(null);
        p1.setBackground(Color.black);
        add(p1);

        JLabel l1 = new JLabel("Nombre:");
        l1.setBounds(50, 75, 100, 40);
        l1.setBackground(Color.white);
        l1.setForeground(Color.white);
        p1.add(l1);

        t1.setBounds(180, 79, 100, 30);
        p1.add(t1);

        JLabel l2 = new JLabel("Contraseña:");
        l2.setBounds(50, 175, 100, 40);
        l2.setBackground(Color.white);
        l2.setForeground(Color.white);
        p1.add(l2);

        t2.setBounds(180, 179, 100, 30);
        p1.add(t2);
        
        JLabel l3 = new JLabel("INGRESE SUS CREDENCIALES");
        l3.setBounds(20, 30, 400, 20);
        l3.setBackground(Color.white);
        l3.setForeground(Color.white);
        l3.setFont(new java.awt.Font("Courier",2,24) {
        });
        p1.add(l3);
        

        JButton b1 = new JButton("Ingresar");
        b1.setBounds(140, 250, 100, 50);
        p1.add(b1);

        ActionListener verificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    user();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };

        b1.addActionListener(verificar);

    }

    private void load() throws ClassNotFoundException {
        //CON ESTE CODIGO SE RECUPERA LA INFORMACION QUE SE ALMACENO CON EL CODIGO ANTERIOR
        try {
            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("usuarios.dat"));
            usuarios = (Object[][]) recuperar.readObject();
            recuperar.close();
        } catch (Exception e) {
        }

    }

    private void user() throws ClassNotFoundException {
        load();
        Administrador ad = new Administrador();
        if (t1.getText().equals("Admin") && t2.getText().equals("Admin")) {
            ad.ejecutar("Admin");
            JOptionPane.showMessageDialog(null, "BIENVENID@ "+t1.getText());
            setVisible(false);
        } else {
            boolean var = false;
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i][1] .equals(t1.getText()) && usuarios[i][7] .equals(t2.getText())) {
                    var = true;
                    JOptionPane.showMessageDialog(null, "BIENVENID@ "+t1.getText());
                    ad.ejecutar(usuarios[i][1].toString());
                    dispose();
                    break;
                }

            }
            if (var == false) {
                oportunidades--;
                if (oportunidades == 0) {
                    JOptionPane.showMessageDialog(null, "SE ACABARON LAS OPORTUNIDADES");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS, LE QUEDAN " + oportunidades + " OPORTUNIDADES");
                }
            }

        }

    }

    public void ejecutar() throws ClassNotFoundException {
        inicio();

    }

    public static void main(String[] args) throws ClassNotFoundException {
        login l = new login();
        l.ejecutar();
    }

}
