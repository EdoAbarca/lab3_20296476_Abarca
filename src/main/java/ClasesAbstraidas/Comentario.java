package ClasesAbstraidas;

import Moldes.Reaccion;
import java.util.ArrayList;

/**
 * Clase Comentario. Esta clase tiene por objetivo representar un comentario en una red social.
 * Clase hija de "Reaccion", el comentario puede ser a una publicacion o como respuesta a otro comentario.
 * @version 1.1, 16/07/2021
 * @author Eduardo Abarca
 */
public class Comentario extends Reaccion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final String ContenidoComentario;
    private ArrayList<Like> LikesComentario;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Comentario(int IdPS, int IdRS, String Fecha, String Autor, String Contenido)
    {
        super(IdPS, IdRS, Fecha, Autor);
        this.ContenidoComentario = Contenido;
        this.LikesComentario = new ArrayList<>();
    }
    
    /* GETTERS */
    
    public String getContenidoComentario()
    {return this.ContenidoComentario;}
    
    /* SETTERS */
    
    /* METODOS ADICIONALES */
    
    public String ComentarioAString()
    {return "\n\nId comentario: "+ Integer.toString(this.IdReaccion) + " - Id pregunta seleccionada: "+ Integer.toString(this.IdPublicacionSeleccionada) + " - Id comentario respondido: "+Integer.toString(this.IdReaccionSeleccionada)+ "\nAutor comentario: "+ this.AutorReaccion + "Fecha comentario: "+ this.FechaReaccion + "\nContenido comentario: "+this.ContenidoComentario;}
}
