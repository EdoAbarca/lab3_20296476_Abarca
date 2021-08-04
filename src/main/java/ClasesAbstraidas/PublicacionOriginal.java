package ClasesAbstraidas;

import Moldes.Publicacion;
import java.util.ArrayList;

/**
 * Clase PubicacionOriginal. Esta clase tiene por objetivo representar una publicacion original (no compartida) en una red social.
 * Clase hija de "Publicacion"
 * @version 1.1, 16/07/2021
 * @author Eduardo Abarca
 */
public class PublicacionOriginal extends Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private ArrayList<Like> LikesPublicacionOriginal;
    private ArrayList<Comentario> ComentariosPublicacionOriginal;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public PublicacionOriginal(String Fecha, String Usuario, String Tipo, String Contenido, String Destino) {
        super(Fecha, Usuario, Tipo, Contenido, Destino);
        this.LikesPublicacionOriginal = new ArrayList<>();
        this.ComentariosPublicacionOriginal = new ArrayList<>();
    }
    
    /* GETTERS */
    //Sin getters.
    
    /* SETTERS */
    //Sin setters.
    
    /* METODOS ADICIONALES */
    public String publicacionOriginalAString()
    {
        return "\n\nId pregunta: "+Integer.toString(this.IdPublicacion)+" - Fecha de publicacion: "+this.FechaPublicacion+" - Tipo de publicacion: "+this.TipoPublicacion+"\nContenido publicacion:\n\n"+this.ContenidoPublicacion+"\n\nAutor: "+this.AutorPublicacion+" - Dirigido a: "+this.CuentaDirigida+"\n\n";
    }
}
