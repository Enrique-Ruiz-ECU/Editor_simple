package interfaz;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PanelAcciones extends JPanel implements ActionListener{
	public static final String CREAR ="CREAR";
	public static final String ABRIR ="ABRIR";
	public static final String GUARDAR ="GUARDAR";
	private JButton btnAbrir;
	private JButton btnCrear;
	private JButton btnGuardar;
	
	private InterfazEditor principal;
	
	public PanelAcciones(InterfazEditor principal) {
		this();
		this.principal=principal;
	}
	

	/**  
	 * Create the panel.
	 */
	public PanelAcciones() {
		setLayout(new GridLayout(1, 0, 5, 0));
		
		btnAbrir = new JButton("Abrir archivo");
		btnAbrir.setToolTipText("abrir archivo");
		btnAbrir.setActionCommand(ABRIR);
		btnAbrir.addActionListener(this);
		add(btnAbrir);
		
		btnCrear = new JButton("Nuevo archivo");
		btnCrear.setToolTipText("crear archivo");
		btnCrear.setActionCommand(CREAR);
		btnCrear.addActionListener(this); 
		add(btnCrear);
		
		btnGuardar = new JButton("Guardar archivo");
		btnGuardar.setToolTipText("guardar archivo");
		btnGuardar.setActionCommand(GUARDAR);
		btnGuardar.addActionListener(this); 
		add(btnGuardar);

	}


	@Override
	public void actionPerformed(ActionEvent evento) {
				if(evento.getActionCommand().equals(ABRIR)) {
					principal.abrirArchivo();
				}else if(evento.getActionCommand().equals(CREAR)) {
					principal.crearArchivo();					
				}else if(evento.getActionCommand().equals(GUARDAR)) {
					principal.guardarArchivo();
				}
	}


}
