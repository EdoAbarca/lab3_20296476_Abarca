package ClasesAbstraidas;

import java.util.ArrayList;

/**
 * Clase Usuario. Esta clase tiene por objetivo representar un usuario en una red social.
 * 
 * @version 1.4, 07/08/2021
 * @author Eduardo Abarca
 */
public class Usuario
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private static int IdCorrelativoUsuarios = 1;
    private final int IdUsuario;
    private final String NombreUsuario;
    private final String Contrasenia;
    private final ArrayList<String> ListaSeguidos;
    private final ArrayList<String> ListaSeguidores;
    ArrayList<PublicacionOriginal> PublicacionesUsuario;
    ArrayList<PublicacionCompartida> PublicacionesCompartidas;
    
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
        this.PublicacionesUsuario = new ArrayList<>();
        this.PublicacionesCompartidas = new ArrayList<>();
    }
    
    /* GETTERS */
    public int getIdUsuario()
    {return this.IdUsuario;}
    
    public String getNombreUsuario()
    {return this.NombreUsuario;}
    
    public String getContrasenia()
    {return this.Contrasenia;}
    
    public ArrayList<String> getListaSeguidos()
    {return this.ListaSeguidos;}
    
    public ArrayList<String> getListaSeguidores()
    {return this.ListaSeguidores;}
    
    public ArrayList<PublicacionOriginal> getPublicaciones()
    {return this.PublicacionesUsuario;}
    
    public ArrayList<PublicacionCompartida> getPublicacionesCompartidas()
    {return this.PublicacionesCompartidas;}

    public int getPublicacionOriginalPorId(int id)
    {
        int indicePublicacionRetorno = -1;
        for(int i = 0; i < this.PublicacionesUsuario.size(); i++)
        {
            if(this.PublicacionesUsuario.get(i).getIdPublicacion() == id)
            {indicePublicacionRetorno = i;}
        }
        return indicePublicacionRetorno;
    }
    
    public int getPublicacionCompartidaPorId(int id)
    {
        int indicePublicacionRetorno = -1;
        for(int i = 0; i < this.PublicacionesCompartidas.size(); i++)
        {
            if(this.PublicacionesCompartidas.get(i).getIdPublicacion() == id)
            {indicePublicacionRetorno = i;}
        }
        return indicePublicacionRetorno;
    }
    
    
    /* SETTERS */
    //Sin setters
    
    /* METODOS ADICIONALES */
    
    public boolean EstaEnSeguidos(String Usuario)
    {
        boolean resultado = false;
        for(int i = 0; i < this.ListaSeguidos.size(); i++)
        {
            if(this.ListaSeguidos.get(i).equals(Usuario))
            {resultado = true;}
        }
        return resultado;
    }
    
    public void AgregarSeguimiento(String Usuario)
    {this.ListaSeguidos.add(Usuario);}
    
    
    public void AgregarSeguidor(String Usuario)
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
    
    
    public String ListaSeguidosAString()
    {
        String StringSeguidos = "";
        if(this.ListaSeguidos.isEmpty())
        {StringSeguidos += "SIN SEGUIDOS.\n\n";}
        else
        {
            for(int i = 0; i < this.ListaSeguidos.size(); i++)
            {StringSeguidos+=this.ListaSeguidos.get(i)+"\n";}
        }
        return StringSeguidos;
    }
    
    public String ListaSeguidoresAString()
    {
        String StringSeguidores = "";
        if(this.ListaSeguidores.isEmpty())
        {StringSeguidores += "SIN SEGUIDORES.\n\n";}
        else
        {
            for(int i = 0; i < this.ListaSeguidores.size(); i++)
            {StringSeguidores+=this.ListaSeguidores.get(i)+"\n";}
        }
        return StringSeguidores;
    }
    
    public String UsuarioAString()
    {
        String StringDatosUsuario, StringPublicacionesUsuario;
        StringDatosUsuario = "\nId usuario: "+ Integer.toString(this.IdUsuario) + " - Nombre usuario: "+ this.NombreUsuario+"\n\nSeguidos:\n\n"+ListaSeguidosAString()+"\n\nSeguidores:\n\n"+ListaSeguidoresAString();
        StringPublicacionesUsuario = "\n\nPUBLICACIONES USUARIO:\n\n";
        if(this.PublicacionesUsuario.isEmpty())
        {StringPublicacionesUsuario+= "SIN PUBLICACIONES CREADAS.\n\n";}
        else
        {
            for(int i = 0; i < this.PublicacionesUsuario.size(); i++)
            {StringPublicacionesUsuario += this.PublicacionesUsuario.get(i).PublicacionAString();}
        }
        StringPublicacionesUsuario += "\n\nPUBLICACIONES COMPARTIDAS POR OTROS USUARIOS:\n\n";
        if(this.PublicacionesCompartidas.isEmpty())
        {StringPublicacionesUsuario+= "SIN PUBLICACIONES COMPARTIDAS POR PARTE DE OTROS USUARIOS.\n\n";}
        else
        {
            for(int i = 0; i < this.PublicacionesCompartidas.size(); i++)
            {StringPublicacionesUsuario += this.PublicacionesCompartidas.get(i).PublicacionAString();}
        }
        return StringDatosUsuario + StringPublicacionesUsuario;
    }
}