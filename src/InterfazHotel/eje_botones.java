package InterfazHotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class eje_botones {
	
	JFrame agregar = new JFrame();
	JPanel panel1 = new JPanel();
	
	JFrame modif = new JFrame();
	JPanel panel2 = new JPanel();
	
	JFrame elimi = new JFrame();
	JPanel panel3 = new JPanel();
	//int x = tbl.getSelectedRow();
	
	//Etiquetas botones y textfields
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JTextField t5 = new JTextField();
	JTextField t6 = new JTextField();
	JTextField t7 = new JTextField();
	//Labels
	JLabel lb1 = new JLabel();
	JLabel lb2 = new JLabel();
	JLabel lb3 = new JLabel();
	JLabel lb4 = new JLabel();
	JLabel lb5 = new JLabel();
	JLabel lb6 = new JLabel();
	JLabel lb7 = new JLabel();
	JLabel lb8 = new JLabel();
	//botones
	JButton bt1 = new JButton();
	JButton bt2 = new JButton();
	
	JRadioButton rb1 = new JRadioButton();
	JRadioButton rb2 = new JRadioButton();
	ButtonGroup bg = new ButtonGroup();
	
	private void consultar(int f) {
		ClientesDAO rp = new ClientesDAO();
		List<usu> lista = rp.listarUsuario();
		lista.get(f).getUsuario_id();
		t1.setText(lista.get(f).getNombre()+"");
		t2.setText(lista.get(f).getApellido()+"");
		t3.setText(lista.get(f).getTelefono()+"");
		t4.setText(lista.get(f).getDireccion()+"");
		t5.setText(lista.get(f).getCorreo()+"");
		t6.setText(lista.get(f).getfecha()+"");
		t7.setText(lista.get(f).getContraseña()+"");
	}
	
	private void funcion_agregar(int id) {
		int contador = 0;
		int activo = 0;
		int ide = 0;
		
		/////////////////////////////////Debo validar tambien los radio buttoms
		if(t1.getText().isEmpty()|| t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty()||t6.getText().isEmpty()||t7.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		}else {
			
			if(rb1.isSelected()== true) {
				activo = 1;
			}else {
				activo = 0;
			}
			
			ClientesDAO p = new ClientesDAO();
			List<usu> lista = p.listarUsuario();
			for(int i = 0; i < lista.size();i++) {
				contador++;
			}
			contador++;
			if(id == 1) {
				p.agregar(contador, t1.getText(), t2.getText(), Integer.parseInt(t3.getText()), t4.getText(), t5.getText(), t6.getText(), 1, activo, t7.getText());
				JOptionPane.showMessageDialog(null, "Se agrego correctamente");
				agregar.setVisible(false);
			}else if(id == 2){
				p.agregar(contador, t1.getText(), t2.getText(), Integer.parseInt(t3.getText()), t4.getText(), t5.getText(), t6.getText(), 2, activo, t7.getText());
				JOptionPane.showMessageDialog(null, "Se agrego correctamente");
				agregar.setVisible(false);
			}
			
		}	
	}

	private void funcion_modificar(int f) {
		int id = 0;
		//No me funciona :)))))
		if(t1.getText().isEmpty()|| t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty()||t6.getText().isEmpty()||t7.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		}else {
			ClientesDAO p = new ClientesDAO();
			List<usu> lista = p.listarUsuario();
			id = lista.get(f).getUsuario_id();
			p.modificar(id,t1.getText(), t2.getText(), Integer.parseInt(t3.getText()), t4.getText(), t5.getText(), t6.getText(), 1, 1, t7.getText());
			JOptionPane.showMessageDialog(null, "Se modifico correctamente");
			modif.setVisible(false);
		}	
	}
	
	
	private void funcion_eliminar(int f) {
		int id = 0;
		ClientesDAO p = new ClientesDAO();
		List<usu> lista = p.listarUsuario();
		id = lista.get(f).getUsuario_id();
		p.delete(id);
		JOptionPane.showMessageDialog(null, "Se elimino correctamente");
		elimi.setVisible(false);
	}

	
	
	private void bt_agregar(int id) {
		//Crear la ventana agregar usuario
		agregar.setTitle("Hoteles GT-Administrador");
		agregar.setBounds(250,250,425,500);
		agregar.setLocationRelativeTo(null);
		agregar.setResizable(false);
		agregar.setVisible(true);
		panel1.setBackground(Color.cyan);
		panel1.setVisible(true);
		agregar.add(panel1);
		
		///////////////
		
		lb1.setText("Agregar Usuario");
		lb1.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb1.setBounds(150,20,150,25);
		lb1.setVisible(true);
	
		
		lb2.setText("Nombre:");
		lb2.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb2.setBounds(50,80,100,20);
		lb2.setVisible(true);
		t1.setBounds(125,80,200,20);
		t1.setVisible(true);
		
		lb3.setText("Apellido:");
		lb3.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb3.setBounds(50,110,100,20);
		lb3.setVisible(true);
		t2.setBounds(125,110,200,20);
		t2.setVisible(true);
		
		lb4.setText("Teléfono:");
		lb4.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb4.setBounds(50,140,100,20);
		lb4.setVisible(true);
		t3.setBounds(125,140,200,20);
		t3.setVisible(true);
		
		lb5.setText("Dirección:");
		lb5.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb5.setBounds(50,170,100,20);
		lb5.setVisible(true);
		t4.setBounds(125,170,200,20);
		t4.setVisible(true);
		
		lb6.setText("Correo:");
		lb6.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb6.setBounds(50,200,100,20);
		lb6.setVisible(true);
		t5.setBounds(125,200,200,20);
		t5.setVisible(true);
		
		lb7.setText("Fecha Nacimiento:");
		lb7.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb7.setBounds(50,230,150,20);
		lb7.setVisible(true);
		t6.setBounds(180,230,145,20);
		t6.setVisible(true);
		
		lb8.setText("Contraseña:");
		lb8.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb8.setBounds(50,260,100,20);
		lb8.setVisible(true);
		t7.setBounds(135,260,190,20);
		t7.setVisible(true);
		
		rb1.setText("Activo");
		rb1.setBounds(100,300,100,20);
		rb1.setBackground(Color.CYAN);
		bg.add(rb1);
		rb2.setText("Inactivo");
		rb2.setBounds(225,300,100,20);
		rb2.setBackground(Color.CYAN);
		bg.add(rb2);
		
		bt1.setText("Guardar");
		bt1.setFont(new Font("Sergi", Font.PLAIN, 15));
		bt1.setBounds(100,350,100,25);
		bt1.setVisible(true);
		
		bt2.setText("Cancelar");
		bt2.setFont(new Font("Sergi", Font.PLAIN, 15));
		bt2.setBounds(230,350,100,25);
		bt2.setVisible(true);
		
		panel1.setLayout(null);
		/////////Boton guardar
		//Agregar labels
		panel1.add(lb1);
		panel1.add(lb2);
		panel1.add(lb3);
		panel1.add(lb4);
		panel1.add(lb5);
		panel1.add(lb6);
		panel1.add(lb7);
		panel1.add(lb8);
		//Agregar text
		panel1.add(t1);
		panel1.add(t2);
		panel1.add(t3);
		panel1.add(t4);
		panel1.add(t5);
		panel1.add(t6);
		panel1.add(t7);
		//Agregar botones
		panel1.add(rb1);
		panel1.add(rb2);
		panel1.add(bt1);
		panel1.add(bt2);
		
		ActionListener cancelar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregar.setVisible(false);
			}
		};
		//Acion del evento
		bt2.addActionListener(cancelar);
		//Boton guardar
		ActionListener agregar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				funcion_agregar(id);
			}
		};
		//Acion del evento
		bt1.addActionListener(agregar);
		
	}
	
	private void bt_modificar(int f) {
		JFrame modif = new JFrame();
		JPanel panel1 = new JPanel();
		
		modif .setTitle("Hoteles GT-Administrador");
		modif .setBounds(250,250,425,500);
		modif .setLocationRelativeTo(null);
		modif .setResizable(false);
		modif .setVisible(true);
		panel2.setBackground(Color.cyan);
		panel2.setVisible(true);
		modif .add(panel2);
		//Etiquetas botones y textfields
		
		/////////////// Haciendo la ventana para agregar usuario, organizando la interfaz
		
		lb1.setText("Modificar Usuario");
		lb1.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb1.setBounds(150,20,150,25);
		lb1.setVisible(true);
	
		lb2.setText("Nombre:");
		lb2.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb2.setBounds(50,80,100,20);
		lb2.setVisible(true);
		t1.setBounds(125,80,200,20);
		t1.setVisible(true);
		
		lb3.setText("Apellido:");
		lb3.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb3.setBounds(50,110,100,20);
		lb3.setVisible(true);
		t2.setBounds(125,110,200,20);
		t2.setVisible(true);
		
		lb4.setText("Teléfono:");
		lb4.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb4.setBounds(50,140,100,20);
		lb4.setVisible(true);
		t3.setBounds(125,140,200,20);
		t3.setVisible(true);
		
		lb5.setText("Dirección:");
		lb5.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb5.setBounds(50,170,100,20);
		lb5.setVisible(true);
		t4.setBounds(125,170,200,20);
		t4.setVisible(true);
		
		lb6.setText("Correo:");
		lb6.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb6.setBounds(50,200,100,20);
		lb6.setVisible(true);
		t5.setBounds(125,200,200,20);
		t5.setVisible(true);
		
		lb7.setText("Fecha Nacimiento:");
		lb7.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb7.setBounds(50,230,150,20);
		lb7.setVisible(true);
		t6.setBounds(180,230,145,20);
		t6.setVisible(true);
		
		lb8.setText("Contraseña:");
		lb8.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb8.setBounds(50,260,100,20);
		lb8.setVisible(true);
		t7.setBounds(135,260,190,20);
		t7.setVisible(true);
		
		rb1.setText("Activo");
		rb1.setBounds(100,300,100,20);
		rb1.setBackground(Color.CYAN);
		bg.add(rb1);
		rb2.setText("Inactivo");
		rb2.setBounds(225,300,100,20);
		rb2.setBackground(Color.CYAN);
		bg.add(rb2);
		
		bt1.setText("Guardar");
		bt1.setFont(new Font("Sergi", Font.PLAIN, 15));
		bt1.setBounds(100,350,100,25);
		bt1.setVisible(true);
		
		bt2.setText("Cancelar");
		bt2.setFont(new Font("Sergi", Font.PLAIN, 15));
		bt2.setBounds(230,350,100,25);
		bt2.setVisible(true);
		
		
		panel2.setLayout(null);
		/////////Boton guardar
		//Agregar labels
		panel2.add(lb1);
		panel2.add(lb2);
		panel2.add(lb3);
		panel2.add(lb4);
		panel2.add(lb5);
		panel2.add(lb6);
		panel2.add(lb7);
		panel2.add(lb8);
		//Agregar text
		panel2.add(t1);
		panel2.add(t2);
		panel2.add(t3);
		panel2.add(t4);
		panel2.add(t5);
		panel2.add(t6);
		panel2.add(t7);
		//Agregar botones
		panel2.add(rb1);
		panel2.add(rb2);
		panel2.add(bt1);
		panel2.add(bt2);
		
		consultar(f);
		//Boton guardar
		ActionListener modificar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				funcion_modificar(f);
			}
		};
		//Acion del evento
		bt1.addActionListener(modificar);
		
		ActionListener cancelar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modif.setVisible(false);
			}
		};
		//Acion del evento
		bt2.addActionListener(cancelar);
	}
	
	
	private void bt_eliminar(int f) {
		JFrame elimi = new JFrame();
		JPanel panel3 = new JPanel();
		//int x = tbl.getSelectedRow();
		
		elimi.setTitle("Hoteles GT-Administrador");
		elimi.setBounds(250,250,425,500);
		elimi.setLocationRelativeTo(null);
		elimi.setResizable(false);
		elimi.setVisible(true);
		panel3.setBackground(Color.cyan);
		panel3.setVisible(true);
		elimi.add(panel3);
	
		
		/////////////// Haciendo la ventana para agregar usuario, organizando la interfaz
		
		lb1.setText("Eliminar Usuario");
		lb1.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb1.setBounds(150,20,150,25);
		lb1.setVisible(true);
	
		
		lb2.setText("Nombre:");
		lb2.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb2.setBounds(50,80,100,20);
		lb2.setVisible(true);
		t1.setBounds(125,80,200,20);
		t1.setVisible(true);
		t1.setEnabled(false);
		
		lb3.setText("Apellido:");
		lb3.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb3.setBounds(50,110,100,20);
		lb3.setVisible(true);
		t2.setBounds(125,110,200,20);
		t2.setVisible(true);
		t2.setEnabled(false);
		
		lb4.setText("Teléfono:");
		lb4.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb4.setBounds(50,140,100,20);
		lb4.setVisible(true);
		t3.setBounds(125,140,200,20);
		t3.setVisible(true);
		t3.setEnabled(false);
		
		lb5.setText("Dirección:");
		lb5.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb5.setBounds(50,170,100,20);
		lb5.setVisible(true);
		t4.setBounds(125,170,200,20);
		t4.setVisible(true);
		t4.setEnabled(false);
		
		lb6.setText("Correo:");
		lb6.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb6.setBounds(50,200,100,20);
		lb6.setVisible(true);
		t5.setBounds(125,200,200,20);
		t5.setVisible(true);
		t5.setEnabled(false);
		
		lb7.setText("Fecha Nacimiento:");
		lb7.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb7.setBounds(50,230,150,20);
		lb7.setVisible(true);
		t6.setBounds(180,230,145,20);
		t6.setVisible(true);
		t6.setEnabled(false);
		
		lb8.setText("Contraseña:");
		lb8.setFont(new Font("Sergi", Font.PLAIN, 15));
		lb8.setBounds(50,260,100,20);
		lb8.setVisible(true);
		t7.setBounds(135,260,190,20);
		t7.setVisible(true);
		t7.setEnabled(false);
		
		rb1.setText("Activo");
		rb1.setBounds(100,300,100,20);
		rb1.setBackground(Color.CYAN);
		bg.add(rb1);
		rb2.setText("Inactivo");
		rb2.setBounds(225,300,100,20);
		rb2.setBackground(Color.CYAN);
		bg.add(rb2);
		rb1.setEnabled(false);
		rb2.setEnabled(false);
		
		
		bt1.setText("Eliminar");
		bt1.setFont(new Font("Sergi", Font.PLAIN, 15));
		bt1.setBounds(100,350,100,25);
		bt1.setVisible(true);
		
		bt2.setText("Cancelar");
		bt2.setFont(new Font("Sergi", Font.PLAIN, 15));
		bt2.setBounds(230,350,100,25);
		bt2.setVisible(true);
		
		
		panel3.setLayout(null);
		/////////Boton guardar
		//Agregar labels
		panel3.add(lb1);
		panel3.add(lb2);
		panel3.add(lb3);
		panel3.add(lb4);
		panel3.add(lb5);
		panel3.add(lb6);
		panel3.add(lb7);
		panel3.add(lb8);
		//Agregar text
		panel3.add(t1);
		panel3.add(t2);
		panel3.add(t3);
		panel3.add(t4);
		panel3.add(t5);
		panel3.add(t6);
		panel3.add(t7);
		//Agregar botones
		panel3.add(rb1);
		panel3.add(rb2);
		panel3.add(bt1);
		panel3.add(bt2);
		consultar(f);
		
		ActionListener cancelar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				elimi.setVisible(false);
			}
		};
		//Acion del evento
		bt2.addActionListener(cancelar);
		
		ActionListener eliminar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				funcion_eliminar(f);
			}
		};
		//Acion del evento
		bt1.addActionListener(eliminar);
	}
	
	
	
	
	public void funcion_bt(int x, int f, int id) {
		switch(x) {
		case 1:
			bt_agregar(id);
			break;
		case 2:
			bt_modificar(f);
			break;
		case 3:
			bt_eliminar(f);
			break;
		default:
			break;
		}
		
	}
}
