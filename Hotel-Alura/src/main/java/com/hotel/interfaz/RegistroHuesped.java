package com.hotel.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.hotel.logica.ConexionSql;
import com.toedter.calendar.JDateChooser;

public class RegistroHuesped extends Ventana implements ActionListener {
    private static final long serialVersionUID = 3646290493767729980L;
    private JLabel text1, text2, text3, text4, text5, text6, text7, img1, img2;
    private JTextField dato1, dato2, dato3, dato4;
    private JComboBox<String> paises;
    private ImageIcon im1, im2, im3;
    private JDateChooser calendario;
    private JButton guardar;
    private JPanel panel;

    @Override
    public void AgregarElem() {
        this.img1 = new JLabel();
        this.img2 = new JLabel();
        this.panel = new JPanel();
        this.dato1 = new JTextField();
        this.dato2 = new JTextField();
        this.dato3 = new JTextField();
        this.dato4 = new JTextField();
        this.text1 = new JLabel("REGISTRO HUÉSPED");
        this.text2 = new JLabel("NOMBRE");
        this.text3 = new JLabel("APELLIDO");
        this.text4 = new JLabel("FECHA DE NACIMIENTO");
        this.text5 = new JLabel("NACIONALIDAD");
        this.text6 = new JLabel("TELEFONO");
        this.text7 = new JLabel("NUMERO DE RESERVA");
        this.paises = new JComboBox<String>();
        this.guardar = new JButton("GUARDAR");
        this.calendario = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');

        this.paises.addItem("Argentina");
        this.paises.addItem("Chile");
        this.paises.addItem("Comlonbia");
        this.paises.addItem("Bolivia");
        this.paises.addItem("Peru");
        this.paises.addItem("Brasil");

        this.im1 = new ImageIcon(getClass().getResource("/img/Ha-100px.png"));
        this.im2 = new ImageIcon(getClass().getResource("/img/registro.png"));
        this.im3 = new ImageIcon(getClass().getResource("/img/reservado.png"));
        this.img1.setIcon(im1);
        this.img2.setIcon(im2);
        this.calendario.setIcon(im3);

        this.panel.setBackground(super.colorBlue);
        this.paises.setBackground(super.colorWithe);
        this.guardar.setBackground(super.colorBlue);

        this.text1.setForeground(super.colorBlue);
        this.text2.setForeground(super.colorGray);
        this.text3.setForeground(super.colorGray);
        this.text4.setForeground(super.colorGray);
        this.text5.setForeground(super.colorGray);
        this.text6.setForeground(super.colorGray);
        this.text7.setForeground(super.colorGray);
        this.guardar.setForeground(super.colorWithe);

        this.text1.setFont(new Font("Arial", Font.BOLD, 24));
        this.text2.setFont(new Font("Arial", Font.BOLD, 19));
        this.text3.setFont(new Font("Arial", Font.BOLD, 19));
        this.text4.setFont(new Font("Arial", Font.BOLD, 19));
        this.text5.setFont(new Font("Arial", Font.BOLD, 19));
        this.text6.setFont(new Font("Arial", Font.BOLD, 19));
        this.text7.setFont(new Font("Arial", Font.BOLD, 19));
        this.dato1.setFont(new Font("Arial", Font.PLAIN, 15));
        this.dato2.setFont(new Font("Arial", Font.PLAIN, 15));
        this.dato3.setFont(new Font("Arial", Font.PLAIN, 15));
        this.dato4.setFont(new Font("Arial", Font.PLAIN, 15));
        this.paises.setFont(new Font("Arial", Font.PLAIN, 15));
        this.guardar.setFont(new Font("Arial", Font.PLAIN, 18));

        this.dato1.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
        this.dato2.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
        this.dato3.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
        this.dato4.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
        this.paises.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
        this.calendario.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));

        GroupLayout elementosPanel = new GroupLayout(this.panel);
        this.panel.setLayout(elementosPanel);
        elementosPanel.setHorizontalGroup(elementosPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(elementosPanel.createSequentialGroup()
                        .addGroup(elementosPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(elementosPanel.createSequentialGroup()
                                        .addGap(210, 210, 210)
                                        .addComponent(this.img1))
                                .addGroup(elementosPanel.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(this.img2)))
                        .addContainerGap(391, Short.MAX_VALUE)));

        elementosPanel.setVerticalGroup(elementosPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(elementosPanel.createSequentialGroup()
                        .addGroup(elementosPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(elementosPanel.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(this.img1))
                                .addGroup(elementosPanel.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(this.img2)))
                        .addContainerGap(40, Short.MAX_VALUE)));

        this.panel.setBounds(0, 0, 500, 700);
        this.text1.setBounds(645, 70, 300, 30);
        this.text2.setBounds(600, 130, 300, 30);
        this.text3.setBounds(600, 200, 300, 30);
        this.text4.setBounds(600, 275, 300, 30);
        this.text5.setBounds(600, 340, 300, 30);
        this.text6.setBounds(600, 415, 300, 30);
        this.text7.setBounds(600, 480, 300, 30);
        this.dato1.setBounds(600, 160, 320, 30);
        this.dato2.setBounds(600, 230, 320, 30);
        this.dato3.setBounds(600, 445, 320, 30);
        this.dato4.setBounds(600, 510, 320, 30);
        this.paises.setBounds(600, 370, 320, 40);
        this.guardar.setBounds(782, 570, 140, 40);
        this.calendario.setBounds(600, 305, 320, 30);

        this.guardar.addActionListener(this);

        this.add(this.panel);
        this.add(this.text1);
        this.add(this.text2);
        this.add(this.text3);
        this.add(this.text4);
        this.add(this.text5);
        this.add(this.text6);
        this.add(this.text7);
        this.add(this.dato1);
        this.add(this.dato2);
        this.add(this.dato3);
        this.add(this.dato4);
        this.add(this.paises);
        this.add(this.guardar);
        this.add(this.calendario);
    }

    public void actionPerformed(ActionEvent e) {
        String nombre = this.dato1.getText();
        String apellido = this.dato2.getText();
        String pais = this.paises.getSelectedItem().toString();
        String telefono = this.dato3.getText();
        String numero = this.dato4.getText();
        String fecha = "";

        if (e.getSource() == this.guardar) {
            ArrayList<String> name = new ArrayList<String>(List.of(
                    nombre,
                    "Ingrese un Nombre",
                    "NOMBRE",
                    "Solo se premite letras",
                    "^[a-zA-Z]+$"));

            ArrayList<String> lastName = new ArrayList<String>(List.of(
                    apellido,
                    "Ingrese un Apellido",
                    "APELLIDO",
                    "Solo se premite letras",
                    "^[a-zA-Z]+$"));

            ArrayList<String> phone = new ArrayList<String>(List.of(
                    telefono,
                    "Ingrese un Telefono",
                    "TELEFONO",
                    "Solo se premite numero",
                    "^[0-9]+$"));

            ArrayList<String> numbre = new ArrayList<String>(List.of(
                    numero,
                    "Ingrese un Numero de Reserva",
                    "NUMERO DE RESERVA",
                    "Solo se premite numero",
                    "^[0-9]+$"));

            if (this.revisar(this.text2, name) || this.revisarRegular(this.text2, name)) {
                return;
            }

            if (this.revisar(this.text3, lastName) || this.revisarRegular(this.text3, lastName)) {
                return;
            }

            if (this.revisarCaledario()) {
                return;
            }

            int year = this.calendario.getCalendar().get(Calendar.YEAR);
            int month = this.calendario.getCalendar().get(Calendar.MONTH);
            int day = this.calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
            fecha = year + "-" + (month + 1) + "-" + day;

            if (this.revisar(this.text6, phone) || this.revisarRegular(this.text6, phone)) {
                return;
            }

            if (this.revisar(this.text7, numbre) || this.revisarRegular(this.text7, numbre)) {
                return;
            }

            Integer.parseInt(numero);
            ConexionSql sql = new ConexionSql();
            sql.huespedSql(nombre, apellido, fecha, pais, telefono, Integer.parseInt(numero));

            ConfirmarDatos datos = new ConfirmarDatos();
            datos.iniciar();
            this.setVisible(false);
        }
    }

    private boolean revisar(JLabel mesaje, ArrayList<String> datos) {
        if (datos.get(0).equals("")) {
            mesaje.setText(datos.get(1).toString());
            mesaje.setForeground(super.colorRed);
            return true;
        } else {
            mesaje.setText(datos.get(2).toString());
            mesaje.setForeground(super.colorGray);
            return false;
        }
    }

    private boolean revisarCaledario() {
        if (this.calendario.getCalendar() == null) {
            this.text4.setText("Ingrese una Fecha");
            this.text4.setForeground(super.colorRed);
            return true;
        } else {
            this.text4.setText("FECHA DE NACIMIENTO");
            this.text4.setForeground(super.colorGray);
            return false;
        }
    }

    private boolean revisarRegular(JLabel mesaje, ArrayList<String> datos) {
        Pattern regular = Pattern.compile(datos.get(4));
        Matcher matcher = regular.matcher(datos.get(0));
        if (!matcher.matches()) {
            mesaje.setText(datos.get(3).toString());
            mesaje.setForeground(super.colorRed);
            return true;
        } else {
            mesaje.setText(datos.get(2).toString());
            mesaje.setForeground(super.colorGray);
            return false;
        }
    }

    @Override
    public void iniciar() {
        super.setBounds(500, 200, 1000, 700);
        super.setResizable(false);
        super.setVisible(true);
        super.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
    }
}
