package com.mycompany.proyectofinal_java_intecap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Modificar extends JFrame {
    
        Object usuarios[][] = new Object[50][9];
        JPanel panel2 = new JPanel();
        JButton b1;
        JButton b2;

        public void modificar_usuario(int id) throws ClassNotFoundException {

            load();
            setSize(900, 650);
            setLocationRelativeTo(null);
            setMaximumSize(new Dimension(1000, 1000));
            setVisible(true);
            panel2.setBackground(Color.lightGray);
            panel2.setLayout(null);
            add(panel2);

            JLabel titulo = new JLabel("Modificar Usuario");
            titulo.setFont(new Font("Serig", Font.PLAIN, 25));
            titulo.setBounds(350, 20, 400, 50);

            JLabel label = new JLabel("Nombre: ");
            label.setBounds(30, 85, 500, 50);
            label.setFont(new Font("Serig", Font.PLAIN, 20));
            JTextField text = new JTextField(15);
            text.setText(usuarios[id][1].toString());
            text.setBounds(150, 100, 250, 20);

            JLabel label1 = new JLabel("Apellido: ");
            label1.setBounds(450, 85, 500, 50);
            label1.setFont(new Font("Serig", Font.PLAIN, 20));
            JTextField text1 = new JTextField(15);
            text1.setText(usuarios[id][2]+"");
            text1.setBounds(560, 100, 250, 20);

            JLabel label2 = new JLabel("Teléfono: ");
            label2.setBounds(30, 200, 500, 50);
            label2.setFont(new Font("Serig", Font.PLAIN, 20));
            JTextField text2 = new JTextField(15);
            text2.setText(usuarios[id][3]+"");
            text2.setBounds(150, 215, 250, 20);

            JLabel label3 = new JLabel("Dirección: ");
            label3.setBounds(450, 200, 500, 50);
            label3.setFont(new Font("Serig", Font.PLAIN, 20));
            JTextField text3 = new JTextField(15);
            text3.setText(usuarios[id][4]+"");
            text3.setBounds(560, 215, 250, 20);

            JLabel label4 = new JLabel("Correo: ");
            label4.setBounds(30, 315, 500, 50);
            label4.setFont(new Font("Serig", Font.PLAIN, 20));
            JTextField text4 = new JTextField(15);
            text4.setText(usuarios[id][5]+"");
            text4.setBounds(150, 330, 250, 20);

            JLabel label5 = new JLabel("Fecha de Nacimiento: ");
            label5.setBounds(450, 315, 500, 50);
            label5.setFont(new Font("Serig", Font.PLAIN, 20));
            JTextField text5 = new JTextField(15);
            text5.setText(usuarios[id][6].toString());
            text5.setBounds(680, 330, 200, 20);

            JLabel label6 = new JLabel("Contraseña: ");
            label6.setBounds(30, 430, 500, 50);
            label6.setFont(new Font("Serig", Font.PLAIN, 20));
            JTextField text6 = new JTextField(15);
            text6.setText(usuarios[id][7].toString());
            text6.setBounds(150, 445, 250, 20);

            ButtonGroup bg = new ButtonGroup();

            JRadioButton c1 = new JRadioButton("Activo", true);
            c1.setBackground(Color.lightGray);
            c1.setFont(new Font("Serig", Font.PLAIN, 20));
            c1.setBounds(480, 430, 150, 50);
            bg.add(c1);
            JRadioButton c2 = new JRadioButton("Inactivo", false);
            c2.setBackground(Color.lightGray);
            c2.setFont(new Font("Serig", Font.PLAIN, 20));
            c2.setBounds(700, 430, 250, 50);
            bg.add(c2);

            if (c1.equals(true)) {
                //usuarios.setActivo(1);

            } else {
                //usuarios.setActivo(0);

            }

            panel2.add(c1);
            panel2.add(c2);

            panel2.add(titulo);

            panel2.add(label);
            panel2.add(text);

            panel2.add(label1);
            panel2.add(text1);

            panel2.add(label2);
            panel2.add(text2);

            panel2.add(label3);
            panel2.add(text3);

            panel2.add(label4);
            panel2.add(text4);

            panel2.add(label5);
            panel2.add(text5);

            panel2.add(label6);
            panel2.add(text6);

            b1 = new JButton();
            b2 = new JButton();

            b1.setText("Guardar");
            b1.setBounds(150, 500, 200, 40);
            panel2.add(b1);

            b2.setText("Cancelar");
            b2.setBounds(500, 500, 200, 40);
            panel2.add(b2);

            ActionListener cancelar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text.setText("");
                    text1.setText("");
                    text2.setText("");
                    text3.setText("");
                    text4.setText("");
                    text5.setText("");
                    text6.setText("");
                    dispose();
                }
            };

            //Acción del evento
            b2.addActionListener(cancelar);

            ActionListener guardar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (!("".equals(text.getText())) && !("".equals(text1.getText())) && !("".equals(text2.getText())) && !("".equals(text3.getText())) && !("".equals(text4.getText())) && !("".equals(text5.getText())) && !("".equals(text6.getText()))) {
                        usuarios[id][1] = text.getText();
                        usuarios[id][2] = text1.getText();
                        usuarios[id][3] = text2.getText();
                        usuarios[id][4] = text3.getText();
                        usuarios[id][5] = text4.getText();
                        usuarios[id][6] = text5.getText();
                        usuarios[id][7] = text6.getText();

                        if (c1.equals(true)) {
                            usuarios[id][8] = 1;

                        } else {
                            usuarios[id][8] = 0;

                        }
                        
                        JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO EXITOSAMENTE");
                        
                        save();
                        setVisible(false);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    }

                }
            };

            //Acción del evento
            b1.addActionListener(guardar);

        }

        public void save() {

            try {
                ObjectOutputStream tabla = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
                tabla.writeObject(usuarios);
                tabla.close();
            } catch (IOException s) {
            }

        }

        public void load() throws ClassNotFoundException {

            try {

                ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("usuarios.dat"));

                usuarios = (Object[][]) recuperar.readObject();
                recuperar.close();

            } catch (IOException e) {
            }

        }

    }


