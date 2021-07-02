package LabJavaParadigmas_v2;

import java.util.ArrayList;

/**
 * Clase Usuario. Esta clase tiene por objetivo representar un usuario en una red social.
 * 
 * @version 1.2, 02/07/2021
 * @author Eduardo Abarca
 */
public class Usuario
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private static int IdCorrelativoUsuarios = 1;
    private final int IdUsuario;
    private final String NombreUsuario;
    private final String Contrasenia;
    private ArrayList<String> ListaSeguidos;
    private ArrayList<String> ListaSeguidores;
    private ArrayList<Publicacion> ListaPublicacionesUsuario;
    private ArrayList<Reaccion> ListaReaccionesPublicaciones; //Evaluar ingreso de este arreglo como miembro de clase de publicacion
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public Usuario(String UsuarioARegistrar, String ContraseniaARegistrar)
    {
        this.IdUsuario = IdCorrelativoUsuarios;
        IdCorrelativoUsuarios++;
        this.NombreUsuario = UsuarioARegistrar;
        this.Contrasenia = ContraseniaARegistrar;
        this.ListaSeguidos = new ArrayList<>();
        this.ListaSeguidores = new ArrayList<>();
        this.ListaPublicacionesUsuario = new ArrayList<>();
        this.ListaReaccionesPublicaciones = new ArrayList<>();
    }
    
    /* GETTERS */
    public int getIdUsuario()
    {return this.IdUsuario;}
    
    public String getNombreUsuario()
    {return this.NombreUsuario;}
    
    public String getContrasenia()
    {return this.Contrasenia;}
    
    /*
    public Publicacion getPublicacionViaId(int id)
    {
        Publicacion PublicacionRetorno;
        for(int i = 0; i < this.ListaPublicacionesUsuario.size(); i++)
        {
            if(this.ListaPublicacionesUsuario.get(i).getIdP() == id)
            {}
        }
    }*/
    
    /* SETTERS */
    
    /* METODOS ADICIONALES */
    
    public boolean estaSeguido(String Usuario)
    {
        boolean resultado = false;
        for(int i = 0; i < this.ListaSeguidos.size(); i++)
        {
            if(this.ListaSeguidos.get(i).equals(Usuario))
            {resultado = true;}
        }
        return resultado;
    }
    
    public void agregarSeguimiento(String Usuario)
    {this.ListaSeguidos.add(Usuario);}
    
    public boolean estaSeguidor(String Usuario)
    {
        boolean resultado = false;
        for(int i = 0; i < this.ListaSeguidores.size(); i++)
        {
            if(this.ListaSeguidos.get(i).equals(Usuario))
            {resultado = true;}
        }
        return resultado;
    }
    
    public void agregarSeguidor(String Usuario)
    {this.ListaSeguidores.add(Usuario);}
    
    public boolean EstanDestinosEnContactos(ArrayList<String> ListaUsuariosDestino)
    {
        boolean EstanDestinos = true;
        if(!ListaUsuariosDestino.isEmpty())
        {
            for(int i = 0; i < ListaUsuariosDestino.size(); i++)
            {
                boolean EstaDestino = false;
                for(int j = 0; j < this.ListaSeguidos.size(); j++)
                {
                    if(ListaUsuariosDestino.get(i).equals(this.ListaSeguidos.get(j)))
                    {EstaDestino = true;}
                }
                if(!EstaDestino)
                {
                    System.out.print("El destino "+ListaUsuariosDestino.get(i)+" no esta en la lista de contactos.\n");
                    EstanDestinos = false;
                }
            }
        }
        return EstanDestinos;
    }
    
    public String UsuarioAString()
    {
        String StringDatosUsuario, StringPublicacionesUsuario;
        StringDatosUsuario = "Id usuario: "+ Integer.toString(this.IdUsuario) + "\nUsuario: "+ this.NombreUsuario;
        StringPublicacionesUsuario = "\n\nPUBLICACIONES USUARIO:\n";
        if(this.ListaPublicacionesUsuario.isEmpty())
        {StringPublicacionesUsuario+= "Sin publicaciones.\n\n";}
        else
        {
            for(int i = 0; i < this.ListaPublicacionesUsuario.size(); i++)
            {StringPublicacionesUsuario += this.ListaPublicacionesUsuario.get(i).publicacionAString();}
        }
        return StringDatosUsuario + StringPublicacionesUsuario;
    }
}
