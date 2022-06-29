package InterfazHotel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class login {
	JFrame inicio = new JFrame();
	JPanel p1 = new JPanel();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JTextField t1 = new JTextField();
	JPasswordField t2 = new JPasswordField();
	JButton b1 = new JButton();
	
	private int contador = 3;
	
	private void validar() {
		int filas = 0;
		int id = 0;
		String n = t1.getText();
		boolean val = false;
		//Validar si los textfields tienen contenido
		if(t1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe colocar su usuario");
		}else if(t2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe colocar su contraseña");
		}
		//Codigo para cargar los datos de la base a nuestro object
		ClientesDAO rp = new ClientesDAO();
		List<usu> lista = rp.listarUsuario();
		//for para saber el tamaño
		for(int i = 0; i < lista.size();i++) {
			//System.out.println(lista.get(i).getNombre());
			filas++;
		}
		Object [][] datos_tabla = new Object[filas][3];
		//for para llenar el object
		for(int i = 0; i<lista.size(); i++) {
			datos_tabla [i][0] = lista.get(i).getNombre();
			datos_tabla [i][1] = lista.get(i).getCorreo();
			datos_tabla [i][2] = lista.get(i).getContraseña();
		}
		//for para validar el login
		for(int i = 0; i < datos_tabla.length;i++) {
			if(datos_tabla [i][1].equals(t1.getText()) && datos_tabla [i][2].equals(t2.getText())) {
				//System.out.println("Hola " + datos_tabla[i][0]);
				n = datos_tabla[i][0] +" "+lista.get(i).getApellido();
				id = lista.get(i).getRol();
				
				contador = 3;
				val = false;
				usuarios u = new usuarios();
				inicio.setVisible(false);
				u.ej_usuarios(n,id);
				break;
			}else {
				val = true;
			}
		}
		if(val == true) {
			contador--;
			JOptionPane.showMessageDialog(null, "Datos Incorrectos, te quedan " + contador + " oportunidades");
			if(contador == 0) {
				JOptionPane.showMessageDialog(null, "El programa se cerrara");
				System.exit(0);
			}
		}
		
		
	}

	private void botones() {
		//Boton iniciar sesion
		ActionListener iniciar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//boton_validar();
				validar();
		}
	};
		//Acion del evento
		b1.addActionListener(iniciar);
	}
	
	private void grafica() {
		//Iniciando el Frame
		inicio.setTitle("Iniciar Sesión");
		inicio.setBounds(250,250,370,400);
		inicio.setLocationRelativeTo(null);
		inicio.setResizable(false);
		inicio.setVisible(true);
		//Darle color y tamaño al panel
		p1.setBackground(Color.red);
		p1.setBounds(250,250,400,400);
		p1.setLayout(null);
		inicio.add(p1);
		
		//etiquetas, textfield y botones
		l1.setText("Usuarios:");
		l1.setBounds(50,120,100,25);
		l1.setFont(new Font("Sergi", Font.BOLD, 15));
		l1.setVisible(true);
		t1.setBounds(50,150,250,20);
		t1.setVisible(true);
		
		l2.setText("Contraseña:");
		l2.setBounds(50,175,100,25);
		l2.setFont(new Font("Sergi", Font.BOLD, 15));
		l2.setVisible(true);
		t2.setBounds(50,200,250,20);
		t2.setVisible(true);
		
		b1.setText("Iniciar Sesión");
		b1.setBounds(50,240,250,25);
		
		//Agregando todo al panel
		p1.add(l1);
		p1.add(l2);
		p1.add(t1);
		p1.add(t2);
		p1.add(b1);
	}
	
	private void ejecutar() {
		grafica();
		botones();
	}
	public static void main(String[] args) {
		login log = new login();
		log.ejecutar();
	}
}
