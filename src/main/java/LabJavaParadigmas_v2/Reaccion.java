package LabJavaParadigmas_v2;

/**
 * Clase Reaccion. Esta clase tiene por objetivo representar una reaccion a una publicacion en una red social.
 * 
 * @version 1.0, 01/07/2021
 * @author Eduardo Abarca
 */
public class Reaccion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private static int IdCorrelativoReacciones = 1;
    private final int IdReaccion;
    private final int IdPublicacionSeleccionada;
    private final int IdReaccionSeleccionada;
    private final String FechaReaccion;
    private final String TipoReaccion;
    private final String ContenidoReaccion;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Reaccion(int IdPS, int IdRS, String Fecha, String Tipo, String Contenido)
    {
        this.IdReaccion = IdCorrelativoReacciones;
        IdCorrelativoReacciones++;
        this.IdPublicacionSeleccionada = IdPS;
        this.IdReaccionSeleccionada = IdRS;
        this.FechaReaccion = Fecha;
        this.TipoReaccion = Tipo;
        this.ContenidoReaccion = Contenido;
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
    
    public String getTipoReaccion()
    {return this.TipoReaccion;}
    
    public String getContenidoReaccion()
    {return this.ContenidoReaccion;}
    
    /* SETTERS */
    // Sin setters de momento...
    
    /* METODOS ADICIONALES */
    /*
    public String reaccionAString()
    {return "";}*/
}

/*
EVALUAR:
 - Hacer de esta una clase abstracta
 - Basar esta clase para las clases Comentario y Like
*/
