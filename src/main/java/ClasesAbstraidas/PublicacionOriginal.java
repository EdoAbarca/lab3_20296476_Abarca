package ClasesAbstraidas;

import Moldes.Publicacion;

/**
 * Clase PubicacionOriginal. Esta clase tiene por objetivo representar una publicacion original (no compartida) en una red social.
 * Clase hija de "Publicacion"
 * @version 1.0, 15/07/2021
 * @author Eduardo Abarca
 */
public class PublicacionOriginal extends Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public PublicacionOriginal(String Fecha, String Usuario, String Tipo, String Contenido, String Destino) {
        super(Fecha, Usuario, Tipo, Contenido, Destino);
    }
    
    /* GETTERS */
    
    /* SETTERS */
    
    /* METODOS ADICIONALES */
    public String publicacionOriginalAString()
    {
        return "\n\nId pregunta: "+Integer.toString(this.IdPublicacion)+" - Fecha de publicacion: "+this.FechaPublicacion+" - Tipo de publicacion: "+this.TipoPublicacion+"\nContenido publicacion:\n\n"+this.ContenidoPublicacion+"\n\nAutor: "+this.AutorPublicacion+" - Dirigido a: "+this.CuentaDirigida+"\n\n";
    }
}
