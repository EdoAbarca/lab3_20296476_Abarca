package Moldes;

/**
 * Clase Publicacion. Esta clase tiene por objetivo representar una publicacion en una red social.
 * Clase abstracta, contendra los atributos y metodos a heredar en las clases "PublicacionOriginal" y "PublicacionCompartida"
 * @version 1.4, 16/07/2021
 * @author Eduardo Abarca
 */
public abstract class Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    protected static int IdCorrelativoPublicaciones = 1;
    protected final int IdPublicacion;
    protected final String FechaPublicacion;
    protected final String TipoPublicacion;
    protected final String ContenidoPublicacion;
    protected final String AutorPublicacion;
    protected final String CuentaDirigida;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Publicacion(String Fecha, String Usuario, String Tipo, String Contenido, String Destino)
    {
        this.IdPublicacion = IdCorrelativoPublicaciones;
        IdCorrelativoPublicaciones++;
        this.FechaPublicacion = Fecha;
        this.AutorPublicacion = Usuario;
        this.TipoPublicacion = Tipo;
        this.ContenidoPublicacion = Contenido;
        this.CuentaDirigida = Destino;
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
    
    public String getCuentaDirigida()
    {return this.CuentaDirigida;}
    
    /* SETTERS */
    // Sin setters de momento...
    
    /* METODOS ADICIONALES */
    // Sin metodos adicionales de momento...
    
    /*
    ¿Por que esta clase no tiene como atributos un contenedor (ArrayList) de likes y publicaciones?
    Las clases a heredar deben tener sus PROPIOS contenedores. (Consultar de todos modos por este conflicto)
    */
}