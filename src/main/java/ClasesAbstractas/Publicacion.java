package ClasesAbstractas;

import java.util.ArrayList;

/**
 * Clase Publicacion. Esta clase tiene por objetivo representar una publicacion en una red social.
 * Clase abstracta, contendra los atributos y metodos a heredar en las clases "PublicacionOriginal" y "PublicacionCompartida"
 * @version 1.6, 10/08/2021
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
    protected final ArrayList<String> UsuariosDirigidos;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para la instancia de las clases que heredaran de esta
     * @param Fecha Fecha publicacion
     * @param Usuario Autor publicacion
     * @param Tipo Tipo publicacion
     * @param Contenido Contenido publicacion
     * @param Destinos Destinos publicacion
     */

    public Publicacion(String Fecha, String Usuario, String Tipo, String Contenido, ArrayList<String> Destinos)
    {
        this.IdPublicacion = IdCorrelativoPublicaciones;
        IdCorrelativoPublicaciones++;
        this.FechaPublicacion = Fecha;
        this.AutorPublicacion = Usuario;
        this.TipoPublicacion = Tipo;
        this.ContenidoPublicacion = Contenido;
        this.UsuariosDirigidos = Destinos;
    }
    
    /* GETTERS */

    /**
     * Getter para IdPublicacion
     * @return IdPublicacion (int)
     */
    public int getIdPublicacion()
    {return this.IdPublicacion;}
    
    /**
     * Getter para FechaPublicacion
     * @return FechaPublicacion (String)
     */
    public String getFechaPublicacion()
    {return this.FechaPublicacion;}
    
    /**
     * Getter para AutorPublicacion
     * @return AutorPublicacion (String)
     */
    public String getAutorPublicacion()
    {return this.AutorPublicacion;}
    
    /**
     * Getter para TipoPublicacion
     * @return TipoPublicacion (String)
     */
    public String getTipoPublicacion()
    {return this.TipoPublicacion;}
    
    /**
     * Getter para ContenidoPublicacion
     * @return ContenidoPublicacion (String)
     */
    public String getContenidoPublicacion()
    {return this.ContenidoPublicacion;}
    
    /**
     * Getter para UsuariosDirigidos
     * @return UsuariosDirigidos (ArrayList< String >)
     */
    public ArrayList<String> getUsuariosDirigidos()
    {return this.UsuariosDirigidos;}
    
    //METODOS ABSTRACTOS SE COMENTARAN EN SUBCLASES
    
    public abstract int getComentarioViaIdReaccion(int id);
    
    /* SETTERS */
    // Sin setters.
    
    /* METODOS ADICIONALES */
    
    public abstract String ListaDestinosAString();
    
    public abstract String LikesPublicacionAString();
    
    public abstract String ComentariosPublicacionAString();
    
    public abstract String PublicacionAString();
    
    /*
    Por que esta clase no tiene como atributo un contenedor (ArrayList) de likes y publicaciones?
    Las clases a heredar deben tener sus PROPIOS contenedores. (Consultar de todos modos por este conflicto)
    */
    
}
