package LabJavaParadigmas_v2;

/**
 * Clase Pubicacion. Esta clase tiene por objetivo representar una publicacion en una red social.
 * 
 * @version 1.0, 01/07/2021
 * @author Eduardo Abarca
 */
public class Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private static int IdCorrelativoPublicaciones = 1;
    private final int IdPublicacion;
    private final String FechaPublicacion;
    private final String AutorPublicacion;
    private final String TipoPublicacion;
    private final String ContenidoPublicacion;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Publicacion(String Fecha, String Usuario, String Tipo, String Contenido)
    {
        this.IdPublicacion = IdCorrelativoPublicaciones;
        IdCorrelativoPublicaciones++;
        this.FechaPublicacion = Fecha;
        this.AutorPublicacion = Usuario;
        this.TipoPublicacion = Tipo;
        this.ContenidoPublicacion = Contenido;
    }
    
    /* GETTERS */
    public int getIdPublicacion()
    {return this.IdPublicacion;}
    
    public String getFechaPublicacion()
    {return this.FechaPublicacion;}
    
    public String getAutorPublicacion()
    {return this.AutorPublicacion;}
    
    public String getTipoPublicacion()
    {return this.TipoPublicacion;}
    
    public String getContenidoPublicacion()
    {return this.ContenidoPublicacion;}
    
    /* SETTERS */
    // Sin setters de momento...
    
    /* METODOS ADICIONALES */
    public String publicacionAString()
    {
        return "Id pregunta: "+Integer.toString(this.IdPublicacion)+"\nFecha de publicacion: "+this.FechaPublicacion+"\nTipo de publicacion: "+this.TipoPublicacion+"\nContenido publicacion: "+this.ContenidoPublicacion+"\n\n";
    }
}

/*
EVALUAR:
 - Implementar clase PublicacionCompartida, que hara herencia a esta
*/