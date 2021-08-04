package ClasesAbstraidas;

import Moldes.Reaccion;

/**
 * Clase Like. Esta clase tiene por objetivo representar un "Me gusta" a una publicacion en una red social.
 * Clase hija de "Reaccion", el Me gusta puede ser dirigido a una publicacion o un comentario.
 * @version 1.1, 16/07/2021
 * @author Eduardo Abarca
 */
public class Like extends Reaccion
{
    
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    //Sin atributos adicionales.
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Like(int IdPS, int IdRS, String Fecha, String Autor)
    {
        super(IdPS, IdRS, Fecha, Autor);
    }
    
    /* GETTERS */
    // Sin getters.
    
    /* SETTERS */
    // Sin setters.
    
    /* METODOS ADICIONALES */
    public String LikeAString()
    {return "\n\nId: "+Integer.toString(this.IdReaccion)+" - Id pregunta seleccionada: "+Integer.toString(this.IdPublicacionSeleccionada) + " - Id reaccion seleccionada: " + Integer.toString(this.IdReaccionSeleccionada) + "\nAutor like: "+this.AutorReaccion + " - Fecha like: "+ this.FechaReaccion + "\n";}
}
