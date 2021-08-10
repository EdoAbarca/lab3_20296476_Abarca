package ClasesAbstraidas;

import Moldes.Reaccion;
import java.util.ArrayList;

/**
 * Clase Comentario. Esta clase tiene por objetivo representar un comentario en una red social.
 * Clase hija de "Reaccion", el comentario puede ser a una publicacion o como respuesta a otro comentario.
 * @version 1.3, 07/08/2021
 * @author Eduardo Abarca
 */
public class Comentario extends Reaccion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final String ContenidoComentario;
    ArrayList<Like> LikesComentario;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Comentario(int IdPS, int IdRS, String Fecha, String Autor, String Tipo, String Contenido)
    {
        super(IdPS, IdRS, Fecha, Autor, Tipo);
        this.ContenidoComentario = Contenido;
        this.LikesComentario = new ArrayList<>();
    }
    
    /* GETTERS */
    //Sin getters adicionales.
    
    /* SETTERS */
    //Sin setters adicionales.
    
    /* METODOS ADICIONALES */
    
    public String LikesComentarioAString()
    {
        String StringLikesEnComentario = "";
        if(this.LikesComentario.isEmpty())
        {StringLikesEnComentario = "SIN LIKES EN COMENTARIO.\n\n";}
        else
        {
           for(int i = 0; i < this.LikesComentario.size(); i++)
           {StringLikesEnComentario += this.LikesComentario.get(i).ReaccionAString();} 
        }
        return StringLikesEnComentario;
    }
    
    @Override
    public String ReaccionAString()
    {
        return "\n\nId comentario: "+ Integer.toString(this.IdReaccion) + " - Id pregunta seleccionada: "+ Integer.toString(this.IdPublicacionSeleccionada) + " - Id comentario respondido: "+Integer.toString(this.IdReaccionSeleccionada)+ "\nAutor comentario: "+ this.AutorReaccion + " - Fecha comentario: "+ this.FechaReaccion + "\nContenido comentario:\n\n"+this.ContenidoComentario+"\n\nLikes en comentario:\n"+LikesComentarioAString();
    }
}
