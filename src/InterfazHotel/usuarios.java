package InterfazHotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class usuarios {
	JFrame f1 = new JFrame();
	JPanel p1 = new JPanel();
	JButton bt1 =  new JButton();
	JButton bt2 =  new JButton();
	JButton bt3 =  new JButton();
	JButton bt4 =  new JButton();
	JLabel lb1 =  new JLabel();
	JLabel lb2 =  new JLabel();
	JScrollPane scroll;
	JTable tbl;
	int f = 0;
	
	//Variables
	private String nombre;
	
	eje_botones ejb = new eje_botones();
	
	public void botones(int id) {
		
		//Boton Agregar Usuario
		ActionListener agregar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ejb.funcion_bt(1,0,id);
			}
		};
		//Acion del evento
		bt1.addActionListener(agregar);
		//Boton salir
		ActionListener salir = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		//Acion del evento
		bt2.addActionListener(salir);
		//Boton modificar
		ActionListener modificar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f = tbl.getSelectedRow();
				ejb.funcion_bt(2,f,0);
			}
		};
		//Acion del evento
		bt3.addActionListener(modificar);
		//Boton eliminar
		ActionListener eliminar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f = tbl.getSelectedRow();
				ejb.funcion_bt(3,f,0);
			}
		};
		//Acion del evento
		bt4.addActionListener(eliminar);
	}
	
	private void cargar_tabla() {
		int contador = 0;
		ClientesDAO rp = new ClientesDAO();
		List<usu> lista = rp.listarUsuario();
		for(int i = 0; i < lista.size();i++) {
			//System.out.println(lista.get(i).getNombre());
			contador++;
		}
		Object [][] datos_tabla = new Object[contador][6];
		for(int i = 0; i<lista.size(); i++) {
			datos_tabla [i][0] = lista.get(i).getUsuario_id();
			datos_tabla [i][1] = lista.get(i).getNombre();
			datos_tabla [i][2] = lista.get(i).getApellido();
			datos_tabla [i][3] = lista.get(i).getRol();
			datos_tabla [i][4] = lista.get(i).getCorreo();
			datos_tabla [i][5] = lista.get(i).getTelefono();
			
		}
		String [] datos = {"No.", "Nombre", "Apellido","Rol","Correo"," Teléfono"};
		tbl = new JTable(datos_tabla,datos); 
		scroll = new JScrollPane(tbl);
		scroll.setBounds(10, 90, 765, 300);
		p1.add(scroll);
	}
	
	private void grafica() {
		//Iniciando el Frame
		f1.setTitle("Hoteles GT-Usuarios");
		f1.setBounds(250,250,800,600);
		f1.setLocationRelativeTo(null);
		f1.setResizable(false);
		f1.setVisible(true);
		f1.setLayout(null);
		//Darle color y tamaño al panel
		p1.setBackground(Color.red);
		p1.setBounds(0,40,800,560);
		p1.setLayout(null);
		f1.add(p1);
		
		//Etiquetas botones y textfields
		bt1.setText("Agregar Usuario");
		bt1.setBounds(20,8,150,25);
		bt2.setText("Salir");
		bt2.setBounds(180,8,150,25);
		bt3.setText("Modificar Usuario");
		bt3.setBounds(240,460,150,25);
		bt4.setText("Eliminar Usuraio");
		bt4.setBounds(400,460,150,25);
		
		lb1.setText("Usuario:");
		lb1.setBounds(600,30,75,25);
		lb1.setFont(new Font("Sergi", Font.BOLD, 15));
		lb1.setVisible(true);
		
		lb2.setText(nombre);
		lb2.setBounds(675,30,100,25);
		lb2.setFont(new Font("Sergi", Font.BOLD, 15));
		lb2.setVisible(true);
		
		//Agregar componentes al panel y al frame
		f1.add(bt1);
		f1.add(bt2);
		p1.add(lb1);
		p1.add(lb1);
		p1.add(lb2);
		p1.add(bt3);
		p1.add(bt4);
		
	}
	
	public void ej_usuarios(String n, int id) {
		nombre = n;
		grafica();
		cargar_tabla();
		botones(id);
	}
	
	/*public static void main(String[] args) {
		usuarios u = new usuarios();
		String n = "Junior";
		u.ej_usuarios(n);
		u.cargar_tabla();
		u.botones();
		
	}*/
}
