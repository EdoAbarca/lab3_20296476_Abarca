package ClasesAbstraidas;

import Moldes.Publicacion;
import java.util.ArrayList;

/**
 * Clase PubicacionOriginal. Esta clase tiene por objetivo representar una publicacion original (no compartida) en una red social.
 * Clase hija de "Publicacion"
 * @version 1.3, 07/08/2021
 * @author Eduardo Abarca
 */
public class PublicacionOriginal extends Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    ArrayList<Like> LikesPublicacionOr;
    ArrayList<Comentario> ComentariosPublicacionOr;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public PublicacionOriginal(String Fecha, String Usuario, String Tipo, String Contenido, ArrayList<String> Destinos)
    {
        super(Fecha, Usuario, Tipo, Contenido, Destinos);
        this.LikesPublicacionOr = new ArrayList<>();
        this.ComentariosPublicacionOr = new ArrayList<>();
    }
    
    /* GETTERS */
    //Sin getters adicionales.
    
    /* SETTERS */
    //Sin setters.
    
    /* METODOS ADICIONALES */
    @Override
    public int getComentarioViaIdReaccion(int id)
    {
        int IndiceComentario = -1;
        for(int i = 0; i < this.ComentariosPublicacionOr.size(); i++)
        {
            if(this.ComentariosPublicacionOr.get(i).getIdReaccion() == id)
            {
                IndiceComentario = i;
                break;
            }
        }
        return IndiceComentario;
    }
    
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
    
    @Override
    public String PublicacionAString()
    {
        return "\n\nId publicacion: "+Integer.toString(this.IdPublicacion)+" - Fecha de publicacion: "+this.FechaPublicacion+" - Tipo de publicacion: "+this.TipoPublicacion+"\nContenido publicacion:\n\n"+this.ContenidoPublicacion+"\n\nAutor: "+this.AutorPublicacion+" - Dirigido a:\n"+ListaDestinosAString()+"\n\nLikes publicacion:\n\n"+LikesPublicacionAString()+"\nComentarios publicacion:\n\n"+ComentariosPublicacionAString();
    }
}
