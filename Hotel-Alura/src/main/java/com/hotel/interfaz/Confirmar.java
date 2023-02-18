package com.hotel.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Confirmar extends Ventana implements ActionListener{
	private static final long serialVersionUID = -5778844704155790388L;
	protected JLabel texto, logo;
	protected JButton bnt1,bnt2;


	
	public Confirmar(String text) {
		this.logo = new JLabel();
		this.bnt1 = new JButton("Si");
		this.bnt2 = new JButton("No");
		this.texto = new JLabel(text);
		
		this.logo.setIcon(new ImageIcon(getClass().getResource("/img/Ha-100px.png")));
		
		this.texto.setFont(new Font("Arial", Font.BOLD, 19));
		this.bnt1.setFont(new Font("Arial", Font.BOLD, 15));
		this.bnt2.setFont(new Font("Arial", Font.BOLD, 15));
		
		this.bnt1.setBackground(colorBlue);
		this.bnt2.setBackground(colorRed);

		this.bnt1.setForeground(super.colorWithe);
		this.bnt2.setForeground(super.colorWithe);
		this.texto.setForeground(super.colorBlue);
		
		this.logo.setBounds(250, 10, 100, 100);
		this.bnt1.setBounds(150, 200, 100, 30);
		this.bnt2.setBounds(340, 200, 100, 30);
		this.texto.setBounds(130, 120, 400, 30);
		
		this.bnt1.addActionListener(this);
		this.bnt2.addActionListener(this);

		this.add(this.logo);
		this.add(this.bnt1);
		this.add(this.bnt2);
		this.add(this.texto);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.bnt1) {
		}
		if(e.getSource()==this.bnt2) {
		}
	}

	@Override
	public void iniciar() {
        this.setBounds(700,400,600,300);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
