package ClasesAbstraidas;

import ClasesAbstractas.Publicacion;
import java.util.ArrayList;

/**
 * Clase PubicacionCompartida. Esta clase tiene por objetivo representar el resultado de compartir una publicacion en una red social.
 * Clase hija de "Publicacion"
 * @version 1.3, 10/08/2021
 * @author Eduardo Abarca
 */
public class PublicacionCompartida extends Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final int IdPublicacionCompartida;
    private final String FechaComparte;
    private final String UsuarioQueComparte;
    private final String UsuarioDestinoComparte;
    final ArrayList<Like> LikesPublicacionComp;
    final ArrayList<Comentario> ComentariosPublicacionComp;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para PublicacionCompartida
     * @param P Publicacion original compartida
     * @param IdP ID publicacion compartida
     * @param FechaC Fecha en la que se compartio la publicacion
     * @param Comparte Usuario que comparte la publicacion
     * @param DestinoComparte Usuario al que se le compartio la publicacion
     */

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
    
    /**
     * Getter de indice comentario mediante ID reaccion
     * @param id ID comentario
     * @return Indice (posicion) comentario apuntado
     */
    @Override
    public int getComentarioViaIdReaccion(int id)
    {
        int IndiceComentario = -1;
        
        //Se revisa ArrayList de comentarios
        for(int i = 0; i < this.ComentariosPublicacionComp.size(); i++)
        {
            //Se encontro comentario con ID ingresado, se guarda indice y se corta ciclo for
            if(this.ComentariosPublicacionComp.get(i).getIdReaccion() == id)
            {
                IndiceComentario = i;
                break;
            }
        }
        
        //Se retorna resultado
        return IndiceComentario;
    }
    
    /* SETTERS */
    // Sin setters.
    
    /* METODOS ADICIONALES */

    /**
     * Metodo que transforma la lista de destinos a un string
     * @return String con los usuarios dirigidos (String)
     */
    @Override
    public String ListaDestinosAString()
    {
        //String salida
        String StringDestinos = "";
        
        //Si la lista esta vacia, se agrega mensaje por defecto
        if(this.UsuariosDirigidos.isEmpty())
        {StringDestinos += "SIN DESTINATARIOS.\n";}
        
        //Caso contrario, se procesa cada destino
        else
        {
            for(int i = 0; i < this.UsuariosDirigidos.size(); i++)
            {StringDestinos += this.UsuariosDirigidos.get(i)+"\n";}
        }
        
        //Se retorna string con la informacion
        return StringDestinos;
    }
       
    /**
     * Metodo que transforma el ArrayList de likes a un string
     * @return String con la informacion de los likes en publicacion compartida (String)
     */
    @Override
    public String LikesPublicacionAString()
    {
        //String salida
        String StringLikes = "";
        
        //Si no hay likes, se deja mensaje por defecto
        if(this.LikesPublicacionComp.isEmpty())
        {StringLikes += "SIN LIKES.\n";}
        
        //Caso contrario, se procesa cada like en la publicacion
        else
        {
            for(int i = 0; i < this.LikesPublicacionComp.size(); i++)
            {StringLikes += this.LikesPublicacionComp.get(i).ReaccionAString();}
        }
        
        //Se retorna string con la informacion
        return StringLikes;
    }

    /**
     * Metodo que transforma el ArrayList de comentarios a un string
     * @return String con la informacion de los comentarios en la publicacion (String)
     */
    @Override
    public String ComentariosPublicacionAString()
    {
        //String salida
        String StringComentarios = "";
        
        //Si no hay comentarios, se deja mensaje por defecto
        if(this.ComentariosPublicacionComp.isEmpty())
        {StringComentarios += "SIN COMENTARIOS.\n";}
        
        //Caso contrario, se procesa cada comentario en la publicacion
        else
        {
            for(int i = 0; i < this.ComentariosPublicacionComp.size(); i++)
            {StringComentarios += this.ComentariosPublicacionComp.get(i).ReaccionAString();}
        }
        
        //Se retorna string con la informacion
        return StringComentarios;
    }
    
    /**
     * Metodo que transforma toda la informacion de la publicacion a un string
     * @return String con la informacion de la publicacion compartida (String)
     */
    @Override
    public String PublicacionAString()
    {
        return "\n\nDatos publicacion compartida:\nId publicacion: "+Integer.toString(this.IdPublicacionCompartida)+" - Fecha de publicacion: "+this.FechaPublicacion+" - Tipo de publicacion: "+this.TipoPublicacion+"\nContenido publicacion:\n\n"+this.ContenidoPublicacion+"\n\nAutor: "+this.AutorPublicacion+" - Dirigido a: "+ListaDestinosAString()+"\n\nDatos generados a la hora de compartir:\n\nId publicacion: "+Integer.toString(this.IdPublicacion)+"\nUsuario que comparte: "+this.UsuarioQueComparte + "\nUsuario al que se compartio: "+ this.UsuarioDestinoComparte+ "\nFecha compartida: "+this.FechaComparte;
    }
}
