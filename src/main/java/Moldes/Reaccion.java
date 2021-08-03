package Moldes;

/**
 * Clase Reaccion. Esta clase tiene por objetivo representar una reaccion a una publicacion en una red social.
 * Clase abstracta, contendra los atributos y metodos a heredar en las clases "Like" y "Comentario"
 * @version 1.3, 15/07/2021
 * @author Eduardo Abarca
 */
public class Reaccion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    protected static int IdCorrelativoReacciones = 1;
    protected final int IdReaccion;
    protected final int IdPublicacionSeleccionada;
    protected final String FechaReaccion;
    protected final String AutorReaccion;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Reaccion(int IdPS, String Fecha, String Autor)
    {
        this.IdReaccion = IdCorrelativoReacciones;
        IdCorrelativoReacciones++;
        this.IdPublicacionSeleccionada = IdPS;
        this.FechaReaccion = Fecha;
        this.AutorReaccion = Autor;
    }
    
    /* GETTERS */
    public int getIdReaccion()
    {return this.IdReaccion;}
    
    public int getIdPublicacionSeleccionada()
    {return this.IdPublicacionSeleccionada;}
    
    public String getFechaReaccion()
    {return this.FechaReaccion;}
    
    public String getAutorReaccion()
    {return this.AutorReaccion;}
    
    /* SETTERS */
    // Sin setters
    
    /* METODOS ADICIONALES */
    // Sin metodos adicionales
}

/*
EVALUAR:
 - Hacer de esta una clase abstracta
 - Basar esta clase para las clases Comentario y Like
*/