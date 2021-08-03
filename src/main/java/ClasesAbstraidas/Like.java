package ClasesAbstraidas;

import Moldes.Reaccion;

/**
 * Clase Like. Esta clase tiene por objetivo representar un "Me gusta" a una publicacion en una red social.
 * Clase hija de "Reaccion"
 * @version 1.0, 15/07/2021
 * @author Eduardo Abarca
 */
public class Like extends Reaccion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Like(int IdPS, String Fecha, String Autor)
    {
        super(IdPS, Fecha, Autor);
    }
    
    /* GETTERS */
    
    /* SETTERS */
    
    /* METODOS ADICIONALES */
    public String LikeAString()
    {return "";}
}
