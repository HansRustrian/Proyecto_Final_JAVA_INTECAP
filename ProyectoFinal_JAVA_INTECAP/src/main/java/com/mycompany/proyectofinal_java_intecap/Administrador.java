package com.mycompany.proyectofinal_java_intecap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Administrador {

    private JTable tabla = new JTable();
    private JFrame admin = new JFrame();
    JScrollPane sp = new JScrollPane();
    private JLabel usuario_inicio = new JLabel();
    private JPanel p1 = new JPanel();
    private Object usuarios[][] = new Object[50][9];

    private void crear(String usuario) {
        admin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        admin.setSize(900, 650);
        admin.setLocationRelativeTo(null);
        admin.setMaximumSize(new Dimension(1000, 1000));
        admin.setVisible(true);
        p1.setBackground(Color.black);
        p1.setLayout(null);
        admin.add(p1);

        //etiqueta usuario
        usuario_inicio.setText("USUARIO " + usuario);
        usuario_inicio.setBackground(Color.white);
        usuario_inicio.setForeground(Color.white);
        usuario_inicio.setBounds(700, 10, 300, 40);
        p1.add(usuario_inicio);

        JButton crear = new JButton("AGREGAR USUARIO");
        crear.setBounds(70, 550, 200, 30);
        p1.add(crear);
        //AGREGAR FUNCIONALIDAD
        ActionListener accion_crear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                form_usuario s = new form_usuario();
                try {
                    s.agregar_usuario(usuario);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                admin.dispose();
//                sp.setVisible(false);
//                try {
//                    tabla();
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
//                }

            }
        };

        crear.addActionListener(accion_crear);

        JButton modificar = new JButton("MODIFICAR USUARIO");
        modificar.setBounds(300, 550, 200, 30);
        p1.add(modificar);

        ActionListener accion_modificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    Modificar m = new Modificar();
                    try {
                        m.modificar_usuario(fila);
                    } catch (Exception e) {

                    }
                } else {
                    try {
                        tabla();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA PARA MODIFICAR");
                }
            }
        };
        //ACCION DEL EVENTO
        modificar.addActionListener(accion_modificar);

        JButton eliminar = new JButton("ELIMINAR");
        eliminar.setBounds(530, 550, 200, 30);
        p1.add(eliminar);

        ActionListener accion_eliminar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    eliminar el = new eliminar();

                    try {
                        el.eliminar_usuario(fila);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        tabla();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA PARA ELIMINAR");
                }

            }
        };

        eliminar.addActionListener(accion_eliminar);

        JButton salir = new JButton("SALIR");
        salir.setBounds(0, 0, 100, 30);
        salir.setBackground(Color.red);

        ActionListener accion_salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                login l = new login();
                try {
                    l.ejecutar();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                admin.dispose();

            }
        };
        salir.addActionListener(accion_salir);
        p1.add(salir);

    }

    public void tabla() throws ClassNotFoundException {

        load();
        String columnas[] = {"No.", "Nombre", "Apellido", "Rol", "Correo", "Telefono"};
        tabla = new JTable(usuarios, columnas);
        sp = new JScrollPane(tabla);
        sp.setSize(860, 480);
        sp.setLocation(20, 40);
        //sp.setBounds(10, 20, 500, 300);
        sp.setVisible(true);
        p1.add(sp);

    }

    private void load() throws ClassNotFoundException {

        try {

            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("usuarios.dat"));

            usuarios = (Object[][]) recuperar.readObject();
            recuperar.close();

        } catch (IOException e) {
        }

    }

    public void ejecutar(String usuario) throws ClassNotFoundException {
        crear(usuario);
        tabla();

    }

}
