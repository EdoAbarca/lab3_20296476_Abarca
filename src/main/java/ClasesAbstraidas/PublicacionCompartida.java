package ClasesAbstraidas;

import Moldes.Publicacion;
import java.util.ArrayList;

/**
 * Clase PubicacionCompartida. Esta clase tiene por objetivo representar el resultado de compartir una publicacion en una red social.
 * Clase hija de "Publicacion"
 * @version 1.2, 07/08/2021
 * @author Eduardo Abarca
 */
public class PublicacionCompartida extends Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final int IdPublicacionCompartida;
    private final String FechaComparte;
    private final String UsuarioQueComparte;
    private final String UsuarioDestinoComparte;
    ArrayList<Like> LikesPublicacionComp;
    ArrayList<Comentario> ComentariosPublicacionComp;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public PublicacionCompartida(PublicacionOriginal P, int IdP, String FechaC, String Comparte, String DestinoComparte)
    {
        super(P.getFechaPublicacion(), P.getAutorPublicacion(), P.getTipoPublicacion(), P.getContenidoPublicacion(), P.getUsuariosDirigidos());
        this.IdPublicacionCompartida = IdP;
        this.UsuarioQueComparte = Comparte;
        this.UsuarioDestinoComparte = DestinoComparte;
        this.FechaComparte = FechaC;
        this.LikesPublicacionComp = new ArrayList<>();
        this.ComentariosPublicacionComp = new ArrayList<>();
    }
    
    /* GETTERS */
    public int getIdPublicacionCompartida()
    {return this.IdPublicacionCompartida;}
    
    public String getFechaComparte()
    {return this.FechaComparte;}
    
    public String getUsuarioQueComparte()
    {return this.UsuarioQueComparte;}
    
    public String getUsuarioDestinoComparte()
    {return this.UsuarioDestinoComparte;}
    
    @Override
    public int getComentarioViaIdReaccion(int id)
    {
        int IndiceComentario = -1;
        for(int i = 0; i < this.ComentariosPublicacionComp.size(); i++)
        {
            if(this.ComentariosPublicacionComp.get(i).getIdReaccion() == id)
            {
                IndiceComentario = i;
                break;
            }
        }
        return IndiceComentario;
    }
    
    /* SETTERS */
    // Sin setters.
    
    /* METODOS ADICIONALES */
 
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
        if(this.LikesPublicacionComp.isEmpty())
        {StringLikes += "SIN LIKES.\n";}
        else
        {
            for(int i = 0; i < this.LikesPublicacionComp.size(); i++)
            {StringLikes += this.LikesPublicacionComp.get(i).ReaccionAString();}
        }
        return StringLikes;
    }

    @Override
    public String ComentariosPublicacionAString()
    {
        String StringComentarios = "";
        if(this.ComentariosPublicacionComp.isEmpty())
        {StringComentarios += "SIN COMENTARIOS.\n";}
        else
        {
            for(int i = 0; i < this.ComentariosPublicacionComp.size(); i++)
            {StringComentarios += this.ComentariosPublicacionComp.get(i).ReaccionAString();}
        }
        return StringComentarios;
    }
    
    @Override
    public String PublicacionAString()
    {
        return "\n\nDatos publicacion compartida:\nId publicacion: "+Integer.toString(this.IdPublicacionCompartida)+" - Fecha de publicacion: "+this.FechaPublicacion+" - Tipo de publicacion: "+this.TipoPublicacion+"\nContenido publicacion:\n\n"+this.ContenidoPublicacion+"\n\nAutor: "+this.AutorPublicacion+" - Dirigido a: "+ListaDestinosAString()+"\n\nDatos generados a la hora de compartir:\n\nId publicacion: "+Integer.toString(this.IdPublicacion)+"\nUsuario que comparte: "+this.UsuarioQueComparte + "\nUsuario al que se compartio: "+ this.UsuarioDestinoComparte+ "\nFecha compartida: "+this.FechaComparte;
    }
}
