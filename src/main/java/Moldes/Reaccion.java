package Moldes;

/**
 * Clase Reaccion. Esta clase tiene por objetivo representar una reaccion a una publicacion en una red social.
 * Clase abstracta, contendra los atributos y metodos a heredar en las clases "Like" y "Comentario"
 * @version 1.4, 07/08/2021
 * @author Eduardo Abarca
 */

public abstract class Reaccion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    protected static int IdCorrelativoReacciones = 1;
    protected final int IdReaccion;
    protected final int IdPublicacionSeleccionada;
    protected final int IdReaccionSeleccionada;
    protected final String TipoReaccion;
    protected final String FechaReaccion;
    protected final String AutorReaccion;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Reaccion(int IdPS, int IdRS, String Fecha, String Autor, String Tipo)
    {
        this.IdReaccion = IdCorrelativoReacciones;
        IdCorrelativoReacciones++;
        this.IdPublicacionSeleccionada = IdPS;
        this.IdReaccionSeleccionada = IdRS;
        this.FechaReaccion = Fecha;
        this.AutorReaccion = Autor;
        this.TipoReaccion = Tipo;
    }
    
    /* GETTERS */
    public int getIdReaccion()
    {return this.IdReaccion;}
    
    public int getIdPublicacionSeleccionada()
    {return this.IdPublicacionSeleccionada;}
    
    public int getIdReaccionSeleccionada()
    {return this.IdReaccionSeleccionada;}
    
    public String getFechaReaccion()
    {return this.FechaReaccion;}
    
    public String getAutorReaccion()
    {return this.AutorReaccion;}
    
    /* SETTERS */
    // Sin setters
    
    /* METODOS ADICIONALES */
    
    public abstract String ReaccionAString();
}
