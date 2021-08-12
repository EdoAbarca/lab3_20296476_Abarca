package ClasesAbstraidas;

import java.util.ArrayList;

/**
 * Clase Usuario. Esta clase tiene por objetivo representar un usuario en una red social.
 * 
 * @version 1.5, 10/08/2021
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
    final ArrayList<PublicacionOriginal> PublicacionesUsuario;
    final ArrayList<PublicacionCompartida> PublicacionesCompartidas;
    
    //GETTERS Y SETTERS PARA INTENTAR ACCEDER A ELEMENTOS DE ARRAYLIST
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para la clase Usuario
     * @param Usuario Usuario a registrar en la clase a instanciar
     * @param Contrasenia Contrasenia a registrar en la clase a instanciar
     */

    public Usuario(String Usuario, String Contrasenia)
    {
        this.IdUsuario = IdCorrelativoUsuarios;
        IdCorrelativoUsuarios++;
        this.NombreUsuario = Usuario;
        this.Contrasenia = Contrasenia;
        this.ListaSeguidos = new ArrayList<>();
        this.ListaSeguidores = new ArrayList<>();
        this.PublicacionesUsuario = new ArrayList<>();
        this.PublicacionesCompartidas = new ArrayList<>();
    }
    
    /* GETTERS */
    /*
    public ArrayList<PublicacionOriginal> getPublicacionesUsuario() {
        return PublicacionesUsuario;
    }
    
    public void setPublicacion()
    {
        this.PublicacionesUsuario.add(e);
    }*/
    
    /**
     * Getter para NombreUsuario
     * @return NombreUsuario (String)
     */
    public String getNombreUsuario()
    {return this.NombreUsuario;}
    
    /**
     * Getter para Contrasenia
     * @return Contrasenia (String)
     */
    public String getContrasenia()
    {return this.Contrasenia;}
    
    /**
     * Getter de indice de publicacion original mediante ID
     * @param id ID de la publicacion original buscada
     * @return Indice publicacion original apuntada (int)
     */
    public int getPublicacionOriginalPorId(int id)
    {
        int indicePublicacionRetorno = -1;
        
        //Se revisa lista publicaciones originales usuario
        for(int i = 0; i < this.PublicacionesUsuario.size(); i++)
        {
            //Se encontro publicacion con el ID ingresado, se guarda indice y se corta ciclo for
            if(this.PublicacionesUsuario.get(i).getIdPublicacion() == id)
            {
                indicePublicacionRetorno = i;
                break;
            }
        }
        
        //Se retorna indice
        return indicePublicacionRetorno;
    }
    
    /**
     * Getter de indice de publicacion compartida mediante ID
     * @param id ID de la publicacion compartida buscada
     * @return Indice publicacion compartida apuntada (int)
     */
    public int getPublicacionCompartidaPorId(int id)
    {
        int indicePublicacionRetorno = -1;
        
        //Se revisa lista publicaciones originales usuario
        for(int i = 0; i < this.PublicacionesCompartidas.size(); i++)
        {
            //Se encontro publicacion con el ID ingresado, se guarda indice y se corta ciclo for
            if(this.PublicacionesCompartidas.get(i).getIdPublicacion() == id)
            {
                indicePublicacionRetorno = i;
                break;
            }
        }
        
        //Se retorna indice
        return indicePublicacionRetorno;
    }
    
    
    /* SETTERS */
    //Sin setters
    
    
    /* METODOS ADICIONALES */

    
    /**
     * Metodo que revisa si el usuario ingresado por parametro se encuentra en la lista seguidos
     * @param Usuario Usuario a verificar
     * @return Booleano -> true: Usuario esta seguido / false caso contrario
     */
    public boolean EstaEnSeguidos(String Usuario)
    {
        boolean resultado = false;
        
        //Se revisa lista seguidos
        for(int i = 0; i < this.ListaSeguidos.size(); i++)
        {
            //Se encontro usuario en lista seguidos, se indica resultado en booleano y se corta ciclo for
            if(this.ListaSeguidos.get(i).equals(Usuario))
            {
                resultado = true;
                break;
            }
        }
        
        //Se retorna resultado
        return resultado;
    }
    
    /**
     * Metodo para agregar un nuevo seguimiento al usuario actual
     * @param Usuario Usuario a seguir
     */
    public void AgregarSeguimiento(String Usuario)
    {this.ListaSeguidos.add(Usuario);}
    
    /**
     * Metodo para agregar un nuevo seguidor al usuario actual
     * @param Usuario Usuario seguidor
     */
    public void AgregarSeguidor(String Usuario)
    {this.ListaSeguidores.add(Usuario);}
    
    /**
     * Metodo que verifica si los destinos ingresados por consola estan en los contactos de este usuario
     * @param ListaDestinos ArrayList con los usuarios destinados
     * @return Booleano -> true: Usuarios estan en contactos / false: Algun/ningun usuario esta en la lista de contactos
     */
    public boolean EstanDestinosEnContactos(ArrayList<String> ListaDestinos)
    {
        boolean EstanDestinos = true;
        
        //Si la lista no es vacia, se procesan los destinos
        if(!ListaDestinos.isEmpty())
        {
            //Se revisa cada destino
            for(int i = 0; i < ListaDestinos.size(); i++)
            {
                //Booleano para indicar si destino actual es contacto
                boolean EstaDestino = false;
                
                //Para cada destino se revisa la lista seguidos
                for(int j = 0; j < this.ListaSeguidos.size(); j++)
                {
                    //Si se encuentra destino en lista seguidos, se indica en booleano y se corta ciclo for
                    if(ListaDestinos.get(i).equals(this.ListaSeguidos.get(j)))
                    {
                        EstaDestino = true;
                        break;
                    }
                }
                
                //Si no se encontro destino, se muestra por consola/terminal y se indica que destinatarios no son validos
                if(!EstaDestino)
                {
                    System.out.print("El destino "+ListaDestinos.get(i)+" no esta en la lista de contactos.\n");
                    EstanDestinos = false;
                }
            }
        }
        
        //Se retorna resultado
        return EstanDestinos;
    }
    
    /**
     * Metodo que transforma la lista de seguidos a un string
     * @return String con la informacion de lista seguidos
     */
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
    
    /**
     * Metodo que transforma la lista de seguidores a un string
     * @return String con la informacion de lista seguidores
     */
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
    
    /**
     * Metodo que transforma la instancia de usuario a un string
     * @return String con la informacion del usuario
     */
    public String UsuarioAString()
    {
        String StringDatosUsuario, StringPublicacionesUsuario;
        
        //Se pasan credenciales de usuario a string
        StringDatosUsuario = "\nId usuario: "+ Integer.toString(this.IdUsuario) + " - Nombre usuario: "+ this.NombreUsuario+"\n\nSeguidos:\n\n"+ListaSeguidosAString()+"\n\nSeguidores:\n\n"+ListaSeguidoresAString();
        
        //Mensaje por defecto por parte de publicaciones originales usuario
        StringPublicacionesUsuario = "\n\nPUBLICACIONES USUARIO:\n\n";
        
        //Si no hay publicaciones originales para este usuario, se deja mensaje por defecto
        if(this.PublicacionesUsuario.isEmpty())
        {StringPublicacionesUsuario+= "SIN PUBLICACIONES CREADAS.\n\n";}
        
        //Caso contrario
        else
        {
            //Se pasa cada publicacion original a string
            for(int i = 0; i < this.PublicacionesUsuario.size(); i++)
            {StringPublicacionesUsuario += this.PublicacionesUsuario.get(i).PublicacionAString();}
        }
        
        //Mensaje por defecto por parte de publicaciones compartidas usuario
        StringPublicacionesUsuario += "\n\nPUBLICACIONES COMPARTIDAS POR OTROS USUARIOS:\n\n";
        
        //Si no hay publicaciones compartidas, se deja mensaje por defecto
        if(this.PublicacionesCompartidas.isEmpty())
        {StringPublicacionesUsuario+= "SIN PUBLICACIONES COMPARTIDAS POR PARTE DE OTROS USUARIOS.\n\n";}
        
        //Caso contrario
        else
        {
            //Se pasa cada publicacion compartida a string
            for(int i = 0; i < this.PublicacionesCompartidas.size(); i++)
            {StringPublicacionesUsuario += this.PublicacionesCompartidas.get(i).PublicacionAString();}
        }
        
        //Se retorna concatenacion de ambos strings generados
        return StringDatosUsuario + StringPublicacionesUsuario;
    }
}