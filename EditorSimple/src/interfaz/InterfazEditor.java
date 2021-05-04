package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mundo.Editor;
import java.awt.Color;

public class InterfazEditor extends JFrame {

	private JPanel contentPane;
	private PanelAcciones panelAcciones;
	private PanelEdicion panelEdicion;
	
	private Editor editor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEditor frame = new InterfazEditor();
					frame.setVisible(true);
				} catch (Exception e) {  
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazEditor() {
		editor = new Editor();
		setTitle("Editor simple de archivo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);
		
		panelAcciones = new PanelAcciones(this);
		
		contentPane.add(panelAcciones, BorderLayout.NORTH);
		
		panelEdicion = new PanelEdicion();
		contentPane.add(panelEdicion, BorderLayout.CENTER);
	}
	
	public void abrirArchivo() {
		// JFileChooser provides a simple mechanism for the user to choose a file
		JFileChooser fc = new JFileChooser();
		//Aparece un cuadro de diálogo de selección de archivos "Abrir archivo".
		if(fc.showOpenDialog(this)== JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			String contenido="";
			try {
				contenido = editor.abrirArchivo(f.getAbsolutePath());
				panelEdicion.refrescarContenido(contenido);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"Editor simple de archivos",JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

	public void crearArchivo() {
		editor.crearArchivo();
		panelEdicion.refrescarContenido("");
	}

	public void guardarArchivo() {
		String contenido="";
		String rutaArchivo=""; 
		if(editor.esArchivoNuevo()) { 
			JFileChooser fc = new JFileChooser();
			if (fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
				rutaArchivo=fc.getSelectedFile().getAbsolutePath();
			} 
		}
			 contenido = panelEdicion.darContenido();
			try {
				editor.guardarArchivo(contenido, rutaArchivo); 
				JOptionPane.showMessageDialog(this, "Archivo guardado con éxito","Editor simple de archivos",JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(),"Editor simple de archivos",JOptionPane.ERROR_MESSAGE);
			}
		}
	

}


