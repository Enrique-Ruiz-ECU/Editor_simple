package mundo;

import java.io.IOException;

public class Editor {
	/**
	 * Representa el archivo que está cargado en el editor
	 */
	private Archivo archivo;
	/**
	 * Construye un objeto de la clase Editor
	 */
	public Editor() {
		archivo = null; 
	}  
	
	/**
	 * abrir un archivo de texto existente	
	 * 
	 * post: el atributo archivo debe tener un objeto creado.
	 * 
	 * @param nombreArchivo String que contiene la ruta completa del archivo
	 * @return	String que contiene el contenido del archivo
	 * @throws Exception cuando hay problemas abriendo el archivo
	 */
	public String abrirArchivo(String nombreArchivo) throws Exception { 
		String contenido ="";	
		archivo = new Archivo(nombreArchivo);
		 try {
			contenido = archivo.darContenido();	
		} catch (IOException e) {
			throw new Exception("Error leyendo el archivo",e);
		}
		 return contenido;
	}
	/**	
	 * Crear un nuevo de archivo de texto en el editor.
	 * 
	 * post: el archivo es igual a null
	 */
	public void crearArchivo() {
		archivo = null;
	}
	/**
	 * 
	 * Guarda el contenido de un archivo, sea nuevo o existente
	 * 
	 * @param contenido String que tiene el contenido que se va a guardar en el archivo
	 * @param rutaArchivo String que contiene la ruta del archivo (en caso de que sea un nuevo archivo)
	 * @throws Exception Cuando ocurre un error escribiendo el archivo
	 */
	public void guardarArchivo(String contenido, String rutaArchivo) throws Exception {
		if (archivo == null)
			archivo = new Archivo (rutaArchivo);
		
		try {
			archivo.guardar(contenido);
		} catch (IOException e) {
			throw new Exception("error guardando archivo",e);
		}
	}
	/**
	 * Indica si el archivo del editor es nuevo o no
	 * @return  True si archivo es nuevo, false en caso contrario
	 */
	public boolean esArchivoNuevo() {
		return archivo == null;
	}
}
