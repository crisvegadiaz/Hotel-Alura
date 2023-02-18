package com.hotel.interfaz;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.hotel.logica.ConexionSql;

public class SistemaDeBusqueda extends Ventana implements ActionListener {
	private static final long serialVersionUID = 3373217845033001928L;
	private JButton bnt1, bnt2, bnt3, bnt4, bnt5;
	private ImageIcon img1, img2, img3;
	private JLabel titulo, logo;
	private JScrollPane scroll;
	private JTextField buscar;
	private ConexionSql sql;
	private JTable table;
	private boolean tipoTable;
	private JPanel panel;
	private int idFila;
	private ArrayList<String[]> matriz;

	@Override
	public void AgregarElem() {
		this.bnt1 = new JButton("BUSCAR");
		this.bnt2 = new JButton("EDITAR");
		this.bnt3 = new JButton("ELIMINAR");
		this.bnt4 = new JButton("Huéspedes");
		this.bnt5 = new JButton("Reservas");
		this.logo = new JLabel();
		this.titulo = new JLabel("SISTEMA DE BÚSQUEDA");
		this.buscar = new JTextField();
		this.panel = new JPanel();
		this.matriz = new ArrayList<String[]>();


		this.img1 = new ImageIcon(getClass().getResource("/img/Ha-100px.png"));
		this.img2 = new ImageIcon(getClass().getResource("/img/pessoas.png"));
		this.img3 = new ImageIcon(getClass().getResource("/img/reservado.png"));
		this.logo.setIcon(img1);
		this.bnt4.setIcon(img2);
		this.bnt5.setIcon(img3);

		this.bnt1.setBackground(super.colorBlue);
		this.bnt2.setBackground(super.colorBlue);
		this.bnt3.setBackground(super.colorBlue);
		this.bnt4.setBackground(super.colorBlue);
		this.bnt5.setBackground(super.colorBlue);

		this.bnt1.setForeground(super.colorWithe);
		this.bnt2.setForeground(super.colorWithe);
		this.bnt3.setForeground(super.colorWithe);
		this.titulo.setForeground(super.colorBlue);

		this.buscar.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
		this.panel.setBorder(new MatteBorder(3, 3, 3, 3, super.colorSkyBlue));
		this.bnt4.setBorder(null);
		this.bnt5.setBorder(null);
		
		this.bnt1.setFont(new Font("Arial", Font.PLAIN, 17));
		this.bnt2.setFont(new Font("Arial", Font.PLAIN, 19));
		this.bnt3.setFont(new Font("Arial", Font.PLAIN, 19));
		this.bnt4.setFont(new Font("Arial", Font.PLAIN, 17));
		this.bnt5.setFont(new Font("Arial", Font.PLAIN, 17));
		this.titulo.setFont(new Font("Arial", Font.BOLD, 25));
		this.buscar.setFont(new Font("Arial", Font.PLAIN, 15));

		this.logo.setBounds(50, 70, 100, 100);
		this.bnt1.setBounds(820, 133, 120, 35);
		this.bnt2.setBounds(700, 550, 120, 40);
		this.bnt3.setBounds(830, 550, 130, 40);
		this.bnt4.setBounds(10, 190, 160, 40);
		this.bnt5.setBounds(180, 190, 150, 40);
		this.panel.setBounds(10, 230, 940, 300);
		this.buscar.setBounds(600, 140, 200, 30);
		this.titulo.setBounds(300, 80, 300, 30);

		this.bnt1.addActionListener(this);
		this.bnt2.addActionListener(this);
		this.bnt3.addActionListener(this);
		this.bnt4.addActionListener(this);
		this.bnt5.addActionListener(this);

		this.add(this.logo);
		this.add(this.bnt1);
		this.add(this.bnt2);
		this.add(this.bnt3);
		this.add(this.bnt4);
		this.add(this.bnt5);
		this.add(this.panel);
		this.add(this.titulo);
		this.add(this.buscar);

	}

	@Override
	public void iniciar() {
		this.setBounds(10, 20, 1000, 700);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		this.sql= new ConexionSql();
		if (e.getSource() == this.bnt1) {
			String text = this.buscar.getText();
			if(this.tipoTable){
				this.table1Sql(text);	
			}else{
				this.table2Sql(text);	
			}
		}
		if (e.getSource() == this.bnt2) {
			this.sql.updateSql(this.tipoTable, matriz);
			if(this.tipoTable){
				this.table1Sql(null);
			}else{
				this.table2Sql(null);
			}
			this.matriz.clear();
		}
		if (e.getSource() == this.bnt3) {
			this.sql.eliminaDatosSql(this.tipoTable,this.idFila);
			if(this.tipoTable){
				this.table1Sql(null);
			}else{
				this.table2Sql(null);
			}
		}
		if (e.getSource() == this.bnt4) {
			this.bnt4.setBackground(super.colorSkyBlue);
			this.bnt5.setBackground(super.colorBlue);
			this.table1Sql(null);
			this.matriz.clear();
		}
		if (e.getSource() == this.bnt5) {
			this.bnt5.setBackground(super.colorSkyBlue);
			this.bnt4.setBackground(super.colorBlue);
			this.table2Sql(null);
			this.matriz.clear();
		}
	}
	private void table1Sql(String text) {
		this.tipoTable=true;
		this.sql = new ConexionSql();
		this.sql.datosHuespedesSql(text);
		String[] columnNames = { "Id", "Nombre", "Apellido", "FechaDeNacimiento", "Nacionalidad", "Telefono", "IdReserva" };
	
		List<Object[]> tempList = new ArrayList<>();
		this.sql.getListaH().forEach(dato -> {
			Object[] datos = {
					dato.getId(),
					dato.getNombre(),
					dato.getApellido(),
					dato.getFecha(),
					dato.getNacionalidad(),
					dato.getTelefono(),
					dato.getIdReserva()
			};
			tempList.add(datos);
		});
	
		Object[][] data = tempList.toArray(new Object[tempList.size()][]);
	
		this.table = new JTable(data, columnNames);
		this.scroll = new JScrollPane(this.table);
		this.scroll.setBounds(10, 230, 940, 300);
	
		removePreviousTable();
		this.table.setFont(new Font("Arial", Font.PLAIN, 15));
		this.scroll.setBorder(new MatteBorder(3, 3, 3, 3, super.colorSkyBlue));
		this.add(this.scroll);
		this.eventoTable();
		this.updateDato();
		
	}
	
	private void table2Sql(String text) {
		this.tipoTable=false;
		this.sql = new ConexionSql();
		this.sql.datosRseservasSql(text);
		String[] columnNames = { "Id", "FechaEntrada", "FechaSalida", "Valor", "FormaPago" };
	
		List<Object[]> tempList = new ArrayList<>();
		this.sql.getListaR().forEach(dato -> {
			Object[] datos = {
					dato.getId(),
					dato.getEntrada(),
					dato.getSalida(),
					dato.getValor(),
					dato.getPago()
			};
			tempList.add(datos);
		});
	
		Object[][] data = tempList.toArray(new Object[tempList.size()][]);
	
		this.table = new JTable(data, columnNames);
		this.scroll = new JScrollPane(this.table);
		this.scroll.setBounds(10, 230, 940, 300);
		
		this.table = new JTable(data, columnNames);
		this.scroll = new JScrollPane(this.table);
		this.scroll.setBounds(10, 230, 940, 300);

		
		removePreviousTable();
		this.table.setFont(new Font("Arial", Font.PLAIN, 15));
		this.scroll.setBorder(new MatteBorder(3, 3, 3, 3, super.colorSkyBlue));
		this.add(this.scroll);
		this.eventoTable();
		this.updateDato();
	}
	
	private void removePreviousTable() {
		this.remove(this.panel);
		Component result = this.getContentPane().findComponentAt(this.scroll.getLocation());
		if (result instanceof JScrollPane) {
			this.remove(result);
		}
	}

	public void eventoTable(){
		ListSelectionModel selectionModel = this.table.getSelectionModel(); 
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) {
		            int selectedRow = table.getSelectedRow();
		            if (selectedRow != -1) { 
		                int id = (int) table.getValueAt(selectedRow, 0);
						SistemaDeBusqueda.this.idFila=id;
		            }
		        }
		    }
		});
	}
	public void updateDato(){
		TableModel model = this.table.getModel();
		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int row = e.getFirstRow();
					int column = e.getColumn();
					String id = table.getValueAt(row, 0).toString();
					String columnName = model.getColumnName(column);
					String data = model.getValueAt(row, column).toString();
					String[] columns ={id,data,columnName};
					SistemaDeBusqueda.this.matriz.add(columns);
				}
			}
		});
	}
	
	public DefaultTableModel idNotUpdate(){
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Hacer que la columna 0 no sea editable
				return column != 0;
			}
		};
		return model;
	}
	public static void main(String[] args) {
		SistemaDeBusqueda n = new SistemaDeBusqueda();
		n.iniciar();
	}
}
