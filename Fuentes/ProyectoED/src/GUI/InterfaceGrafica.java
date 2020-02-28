package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import L�gica.MiL�gica;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


/**
 * Clase InterfaceGr�fica.
 * 
 * @author Mayko Rodr�guez.
 *
 */
public class InterfaceGrafica {

	private JFrame frame;
	private MiL�gica log;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGrafica window = new InterfaceGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Crear un grafo");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log = new MiL�gica();
				log.cargarGrafo();
				JOptionPane.showMessageDialog(null,"Grafo creado exit�samente");
			}
		});
		btnNewButton.setBounds(10, 24, 200, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar v\u00E9rtice");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(log == null){
					JOptionPane.showMessageDialog(null,"Primero debe crear un grafo");
				}
				else{
					try{
						String str = JOptionPane.showInputDialog(null, "Ingrese un r�tulo para un nuevo v�rtice: ");
						int n = Integer.parseInt(str);
						log.agregarVertice(n);
						JOptionPane.showMessageDialog(null, "El v�rtice con r�tulo " + n + " fue agregado correctamente");
					} catch (NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "R�tulo ingresado no v�lido");
					}
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(10, 85, 200, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Agregar arco");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(log == null)
					JOptionPane.showMessageDialog(null, "Primero debe crear un grafo");
				else{
					try{
						String str = JOptionPane.showInputDialog("Ingrese el r�tulo del v�rtice predecesor: ");
						int pre = Integer.parseInt(str);
						String str2 = JOptionPane.showInputDialog("Ingrese el r�tulo del v�rtice sucesor: ");
						int su = Integer.parseInt(str2);
						boolean existe = log.agregarArco(pre, su);
						if(existe)
							JOptionPane.showMessageDialog(null, "El arco fue agregado exit�samente");
						else
							JOptionPane.showMessageDialog(null, "Algunos de los r�tulos ingresados no se encuentra en ning�n v�rtice del grafo");
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "Alguno de los r�tulos ingresados no es v�lido");
					}
				}
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setBounds(10, 147, 200, 40);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar v\u00E9rtice");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( log == null)
					JOptionPane.showMessageDialog(null, "Primero debe crear un grafo");
				else{
					try{
						String str = JOptionPane.showInputDialog("Ingrese el r�tulo del v�rtice que desea eliminar: ");
						int n = Integer.parseInt(str);
						boolean existe = log.eliminarVertice(n);
						if(existe)
							JOptionPane.showMessageDialog(null, "El v�rtice fue eliminado exitosamente");
						else
							JOptionPane.showMessageDialog(null, "El r�tulo ingresado no se encuentra en ning�n v�rtice del grafo");
					} catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "R�tulo ingresado no v�lido");
					}
				}
			}
		});
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setBounds(10, 208, 200, 40);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Recorrido en profundidad");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(log == null)
					JOptionPane.showMessageDialog(null, "Primero debe crear un grafo");
				else{
					textArea.setText("El recorrido en profundidad es: \n" + log.DFSShell());
					
				}
			}
		});
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setBounds(10, 269, 200, 42);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Recorrido en anchura");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(log == null)
					JOptionPane.showMessageDialog(null, "Primero debe crear un grafo");
				else{
					textArea.setText("El recorrido en anchura es: \n" + log.BFSShell());
				}
			}
		});
		btnNewButton_5.setForeground(Color.BLUE);
		btnNewButton_5.setBounds(10, 334, 200, 40);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Camino m\u00E1s corto");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( log == null)
					JOptionPane.showMessageDialog(null, "Primero debe crear un grafo");
				else{
					try{
						String str = JOptionPane.showInputDialog("Ingrese el r�tulo del v�rtice origen");
						int n = Integer.parseInt(str);
						String str2 = JOptionPane.showInputDialog("Ingrese el r�tulo del v�rtice destino");
						int m = Integer.parseInt(str2);
						
						String camino = log.caminoMasCorto(n, m);
						if( camino != "")
							textArea.setText("El camino m�s corto de " +n+" a "+m+" es: \n" + camino);
						else
							JOptionPane.showMessageDialog(null, "No existe ning�n camino entre los v�rtices ingresados");
					} catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "Algunos de los r�tulos ingresados no es v�lido");
					}
				}
			}
		});
		btnNewButton_6.setForeground(Color.BLUE);
		btnNewButton_6.setBounds(10, 398, 200, 40);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Todos los caminos");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(log == null)
					JOptionPane.showMessageDialog(null, "Primero debe crear un grafo");
				else{
					try{
						String str = JOptionPane.showInputDialog("Ingrese el r�tulo del v�rtice origen");
						int n = Integer.parseInt(str);
						String str2 = JOptionPane.showInputDialog("Ingrese el r�tulo del v�rtice destino");
						int m = Integer.parseInt(str2);
						
						String caminos = log.todosLosCaminos(n, m);
						if(caminos != "")
							textArea.setText("Todos los caminos de " +n+" a "+m+" son: \n" + caminos);
						else
							JOptionPane.showMessageDialog(null, "No existe ning�n camino entre los v�rtices ingresados");
					} catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "Algunos de los r�tulos ingresados no es v�lido");
					}
				}
			}
		});
		btnNewButton_7.setForeground(Color.BLUE);
		btnNewButton_7.setBounds(10, 461, 200, 40);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Elimina el camino corto");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(log == null)
					JOptionPane.showMessageDialog(null, "Primero debe crear un grafo");
				else{
					try{
						String str = JOptionPane.showInputDialog("Ingrese el r�tulo del v�rtice origen");
						int n = Integer.parseInt(str);
						String str2 = JOptionPane.showInputDialog("Ingrese el r�tulo del v�rtice destino");
						int m = Integer.parseInt(str2);
						
						boolean existe = log.eliminarVertices(n, m);
						if(existe)
							JOptionPane.showMessageDialog(null, "El camino m�s corto entre los v�rtices dados fue eliminado exit�samente");
						else
							JOptionPane.showMessageDialog(null, "No existe ning�n camino entre los v�rtices ingresados");
					} catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "Algunos de los r�tulos ingresados no es v�lido");
					}
				}
			}
		});
		btnNewButton_8.setForeground(Color.BLUE);
		btnNewButton_8.setBounds(10, 521, 200, 40);
		frame.getContentPane().add(btnNewButton_8);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 13));
		textArea.setBackground(Color.GREEN);
		textArea.setForeground(new Color(220, 20, 60));
		textArea.setEditable(false);
		textArea.setBounds(311, 147, 262, 156);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		frame.getContentPane().add(textArea);
		textArea.setColumns(10);
	}
}
