package ClasesAbstractas;

/**
 * Clase Reaccion. Esta clase tiene por objetivo representar una reaccion a una publicacion en una red social.
 * Clase abstracta, contendra los atributos y metodos a heredar en las clases "Like" y "Comentario"
 * @version 1.5, 10/08/2021
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

    /**
     * Constructor para la instancia de las clases que heredaran de esta
     * @param IdPS ID de publicacion reaccionada
     * @param IdRS ID de reaccion seleccionada
     * @param Fecha Fecha de instancia
     * @param Autor Autor (usuario) de la reaccion
     * @param Tipo Tipo de reaccion (No necesaria, pero exigida por enunciado)
     */
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

    /**
     * Getter para IdReaccion
     * @return IdReaccion (int)
     */

    public int getIdReaccion()
    {return this.IdReaccion;}
    
    /**
     * Getter para AutorReaccion
     * @return AutorReaccion (String)
     */
    public String getAutorReaccion()
    {return this.AutorReaccion;}
    
    /* SETTERS */
    // Sin setters
    
    /* METODOS ADICIONALES */

    /**
     * Metodo abstracto que, en las clases a heredar, transformara la instancia a un string
     * @return String a mostrar por consola/terminal
     */
    public abstract String ReaccionAString();
}
