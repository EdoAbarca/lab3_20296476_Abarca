package ClasesAbstraidas;

import ClasesAbstractas.Publicacion;
import java.util.ArrayList;

/**
 * Clase PubicacionOriginal. Esta clase tiene por objetivo representar una publicacion original (no compartida) en una red social.
 * Clase hija de "Publicacion"
 * @version 1.4, 10/08/2021
 * @author Eduardo Abarca
 */
public class PublicacionOriginal extends Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    final ArrayList<Like> LikesPublicacionOr;
    final ArrayList<Comentario> ComentariosPublicacionOr;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para PublicacionOriginal
     * @param Fecha Fecha de publicacion
     * @param Usuario Usuario que creo publicacion
     * @param Tipo Tipo publicacion
     * @param Contenido Contenido publicacion
     * @param Destinos Lista de destinos publicacion
     */
    public PublicacionOriginal(String Fecha, String Usuario, String Tipo, String Contenido, ArrayList<String> Destinos)
    {
        super(Fecha, Usuario, Tipo, Contenido, Destinos);
        this.LikesPublicacionOr = new ArrayList<>();
        this.ComentariosPublicacionOr = new ArrayList<>();
    }
    
    /* GETTERS */
    /**
     * Getter de comentario via ID reaccion
     * @param id ID comentario
     * @return Indice (posicion) de comentario apuntado
     */

    @Override
    public int getComentarioViaIdReaccion(int id)
    {
        int IndiceComentario = -1;
        
        //Se revisa ArrayList de comentarios
        for(int i = 0; i < this.ComentariosPublicacionOr.size(); i++)
        {
            //Si se encontro el ID del comentario, se retorna indice y se corta ciclo for
            if(this.ComentariosPublicacionOr.get(i).getIdReaccion() == id)
            {
                IndiceComentario = i;
                break;
            }
        }
        
        //Se retorna indice
        return IndiceComentario;
    }
    
    public ArrayList<Comentario> getComentariosPublicacion()
    {return this.ComentariosPublicacionOr;}
    
    /* SETTERS */
    //Sin setters.
    
    /* METODOS ADICIONALES */

    /**
     * Metodo que transforma la lista de destinos a un string
     * @return String con los usuarios dirigidos (String)
     */
    @Override
    public String ListaDestinosAString()
    {
        String StringDestinos = "";
        if(this.UsuariosDirigidos.isEmpty())
        {
            StringDestinos += "SIN DESTINATARIOS.\n";
        }
        else
        {
            for(int i = 0; i < this.UsuariosDirigidos.size(); i++)
            {StringDestinos += this.UsuariosDirigidos.get(i)+"\n";}
        }
        return StringDestinos;
    }
    
    /**
     * Metodo que transforma el ArrayList de likes a un string
     * @return String con la informacion de los likes en publicacion compartida (String)
     */
    @Override
    public String LikesPublicacionAString()
    {
        String StringLikes = "";
        if(this.LikesPublicacionOr.isEmpty())
        {StringLikes += "SIN LIKES.\n";}
        else
        {
            for(int i = 0; i < this.LikesPublicacionOr.size(); i++)
            {StringLikes += this.LikesPublicacionOr.get(i).ReaccionAString();}
        }
        return StringLikes;
    }
    
    /**
     * Metodo que transforma el ArrayList de comentarios a un string
     * @return String con la informacion de los comentarios en la publicacion (String)
     */
    @Override
    public String ComentariosPublicacionAString()
    {
        String StringComentarios = "";
        if(this.ComentariosPublicacionOr.isEmpty())
        {StringComentarios += "SIN COMENTARIOS.\n";}
        else
        {
            for(int i = 0; i < this.ComentariosPublicacionOr.size(); i++)
            {StringComentarios += this.ComentariosPublicacionOr.get(i).ReaccionAString();}
        }
        return StringComentarios;
    }
    
    /**
     * Metodo que transforma toda la informacion de la publicacion a un string
     * @return String con la informacion de la publicacion compartida (String)
     */
    @Override
    public String PublicacionAString()
    {
        return "\n\nId publicacion: "+Integer.toString(this.IdPublicacion)+" - Fecha de publicacion: "+this.FechaPublicacion+" - Tipo de publicacion: "+this.TipoPublicacion+"\nContenido publicacion:\n\n"+this.ContenidoPublicacion+"\n\nAutor: "+this.AutorPublicacion+" - Dirigido a:\n"+ListaDestinosAString()+"\n\nLikes publicacion:\n\n"+LikesPublicacionAString()+"\nComentarios publicacion:\n\n"+ComentariosPublicacionAString();
    }
}
