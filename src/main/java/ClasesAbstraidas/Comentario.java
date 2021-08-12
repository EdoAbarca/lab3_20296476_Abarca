package ClasesAbstraidas;

import ClasesAbstractas.Reaccion;
import java.util.ArrayList;

/**
 * Clase Comentario. Esta clase tiene por objetivo representar un comentario en una red social.
 * Clase hija de "Reaccion", el comentario puede ser a una publicacion o como respuesta a otro comentario.
 * @version 1.3, 10/08/2021
 * @author Eduardo Abarca
 */
public class Comentario extends Reaccion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final String ContenidoComentario;
    final ArrayList<Like> LikesComentario;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para clase Comentario
     * @param IdPS ID publicacion seleccionada
     * @param IdRS ID reaccion seleccionada
     * @param Fecha Fecha comentario
     * @param Autor Autor (usuario) comentario
     * @param Tipo Tipo reaccion
     * @param Contenido Contenido comentario
     */
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

    /**
     * Metodo que transforma el ArrayList de likes a un string
     * @return String con informacion de ArrayList de likes (String)
     */
    public String LikesComentarioAString()
    {
        //String salida
        String StringLikesEnComentario = "";
        
        //Si el ArrayList de likes esta vacio, se agrega un mensaje por defecto en el string
        if(this.LikesComentario.isEmpty())
        {StringLikesEnComentario = "SIN LIKES EN COMENTARIO.\n\n";}
        
        //Caso contrario, se procesa cada like
        else
        {
           for(int i = 0; i < this.LikesComentario.size(); i++)
           {StringLikesEnComentario += this.LikesComentario.get(i).ReaccionAString();} 
        }
        
        //Se retorna string con la informacion
        return StringLikesEnComentario;
    }
    
    /**
     * Metodo que transforma este comentario a un string
     * @return String con informacion del comentario (String)
     */
    @Override
    public String ReaccionAString()
    {
        return "\n\nId comentario: "+ Integer.toString(this.IdReaccion) + " - Id pregunta seleccionada: "+ Integer.toString(this.IdPublicacionSeleccionada) + " - Id comentario respondido: "+Integer.toString(this.IdReaccionSeleccionada)+ "\nAutor comentario: "+ this.AutorReaccion + " - Fecha comentario: "+ this.FechaReaccion + "\nContenido comentario:\n\n"+this.ContenidoComentario+"\n\nLikes en comentario:\n"+LikesComentarioAString();
    }
}
