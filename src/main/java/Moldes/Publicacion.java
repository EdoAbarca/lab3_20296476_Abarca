package Moldes;

import ClasesAbstraidas.Comentario;
import ClasesAbstraidas.Like;
import java.util.ArrayList;

/**
 * Clase Pubicacion. Esta clase tiene por objetivo representar una publicacion en una red social.
 * Clase abstracta, contendra los atributos y metodos a heredar en las clases "PublicacionOriginal" y "PublicacionCompartida"
 * @version 1.3, 15/07/2021
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
    protected ArrayList<Comentario> Comentarios;
    protected ArrayList<Like> Likes;
    
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
        this.Likes = new ArrayList<>();
        this.Comentarios = new ArrayList<>();
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
    
}