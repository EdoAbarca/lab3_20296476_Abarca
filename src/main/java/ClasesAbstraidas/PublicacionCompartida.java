package ClasesAbstraidas;

import Moldes.Publicacion;

/**
 * Clase PubicacionCompartida. Esta clase tiene por objetivo representar el resultado de compartir una publicacion en una red social.
 * Clase hija de "Publicacion"
 * @version 1.0, 15/07/2021
 * @author Eduardo Abarca
 */
public class PublicacionCompartida extends Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final int IdPublicacionCompartida;
    private final String UsuarioQueComparte;
    private final String UsuarioDestinoComparte;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public PublicacionCompartida(Publicacion P, int IdP, String Comparte, String DestinoComparte)
    {
        super(P.getFechaPublicacion(), P.getAutorPublicacion(), P.getTipoPublicacion(), P.getContenidoPublicacion(), P.getCuentaDirigida());
        this.IdPublicacionCompartida = IdP;
        this.UsuarioQueComparte = Comparte;
        this.UsuarioDestinoComparte = DestinoComparte;
    }
    
    /* GETTERS */
    public int getIdPublicacionCompartida()
    {return this.IdPublicacionCompartida;}
    
    public String getUsuarioQueComparte()
    {return this.UsuarioQueComparte;}
    
    public String getUsuarioDestinoComparte()
    {return this.UsuarioDestinoComparte;}
    
    /* SETTERS */
    
    /* METODOS ADICIONALES */
    public String publicacionCompartidaAString()
    {
        return "\n\nId pregunta: "+Integer.toString(this.IdPublicacion)+" - Fecha de publicacion: "+this.FechaPublicacion+" - Tipo de publicacion: "+this.TipoPublicacion+"\nContenido publicacion:\n\n"+this.ContenidoPublicacion+"\n\nAutor: "+this.AutorPublicacion+" - Dirigido a: "+this.CuentaDirigida+"\n\n";
    }
}
