package ClasesAbstraidas;

import Moldes.Reaccion;

/**
 * Clase Comentario. Esta clase tiene por objetivo representar un comentario a una publicacion en una red social.
 * Clase hija de "Reaccion"
 * @version 1.0, 15/07/2021
 * @author Eduardo Abarca
 */
public class Comentario extends Reaccion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final int IdReaccionSeleccionada;
    private final String ContenidoComentario;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Comentario(int IdPS, int IdRS, String Fecha, String Autor, String Contenido) {
        super(IdPS, Fecha, Autor);
        this.IdReaccionSeleccionada = IdRS;
        this.ContenidoComentario = Contenido;
    }
    
    /* GETTERS */
    public int getReaccionSeleccionada()
    {return this.IdReaccionSeleccionada;}
    
    public String getContenidoComentario()
    {return this.ContenidoComentario;}
    
    /* SETTERS */
    
    /* METODOS ADICIONALES */
    public String ComentarioAString()
    {return "";}
}
