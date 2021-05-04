package mundo;

import java.io.*;

public class Archivo {
	/**
	 * Objeto de la clase File que representa de forma abstracta a un archivo físico en disco
	 */
	private File archivo;
	
	/**
	 * Construye un objeto de la clase Archivo
	 * @param nombreArchivo la ruta completa del archivo que se va a crear
	 */
	public Archivo(String nombreArchivo) {
		archivo = new File(nombreArchivo);
	}  
	/**
	 * Retorna el contenido del archivo
	 * @return String que tiene el contenido
	 * @throws IOException cuando hay problemas o leyendo el archivo
	 */	
	public String darContenido() throws IOException{	
		String contenido = "";
		// Creates a new FileReader, given the File to read from.
		FileReader fr = new FileReader(archivo);	
		//Creates a buffering character-input stream that uses a default-sized input buffer.
		BufferedReader lector = new BufferedReader(fr);
		// Reads a line of text
		String linea =lector.readLine();
		while( linea != null){
			contenido += linea +"\n";
			linea = lector.readLine();
		}
		// Closes the stream and releases any system resources associated with it.
		lector.close();
		fr.close();
		return contenido;
	}
	// remplaza lo que hay en el archivo
	/**
	 * Guarda el contenido en un archivo nuevo o existente 
	 * @param contenido String que tiene el contenido que se va a guardar en el archivo
	 * @throws IOException cuando hay problemas tratando de escribir en el archivo
	 */
	public void guardar( String contenido) throws IOException{
		PrintWriter escritor = new PrintWriter(archivo);
		escritor.write(contenido);
		escritor.close();
	}
}
