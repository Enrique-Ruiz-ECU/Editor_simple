package interfaz;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelEdicion extends JPanel {
	private JTextArea taEdicion;

	/**
	 * Create the panel.
	 */
	public PanelEdicion() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		taEdicion = new JTextArea();
		scrollPane.setViewportView(taEdicion);

	}
	
	public String darContenido() {
		return taEdicion.getText();
	}  

	public void refrescarContenido(String contenido) {
		taEdicion.setText(contenido);
	}

}
