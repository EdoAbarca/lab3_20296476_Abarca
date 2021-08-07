package Interfaz;

import ClasesAbstraidas.PublicacionOriginal;
import ClasesAbstraidas.Usuario;
import java.util.ArrayList;

/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica.
 * Aca se encontraran los atributos basicos de una red social, como los metodos necesarios para poder interactuar en ella.
 * @version 1.2, 19/07/2021
 * @author Eduardo Abarca
 */
public interface RedSocial
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    // Sin atributos.
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */

   /* //////////////////////////////////////////////// METODOS DE APOYO //////////////////////////////////////////////// */
    
    public void IniciarPrograma();
    
    public void FinalizarPrograma();
    
    public void AsignarUsuarioLogueado(String Usuario);
    
    public void ExpulsarUsuarioLogueado();
    
    public String FechaDeHoy();
    
    public boolean ValidarDatosRegistro(String Usuario, String Contrasenia);
    
    public boolean ValidarCredenciales(String Usuario, String Contrasenia);
    
    public Usuario getUsuarioViaUsername(String NombreUsuario);
    
    public boolean ValidarDestinos(ArrayList<String> ListaUsuariosDestino);
    //Metodos faltantes corresponden desde el requerimiento funcional Post.
    
    public boolean EstaUsuarioEnSeguidos(String UsuarioObjetivo);
    
    public PublicacionOriginal getPublicacionViaId(int IdPublicacion);
    
    public boolean ExisteComentario(int IdPublicacion, int IdComentario);
    
    public boolean ExisteLike(int IdPublicacion, int IdLike);
    
    public String SocialNetworkToString();
    
    public void PrintSocialNetwork(String StringConvertido);
    
    
    
    /* /////////////////////////////////////////// REQUERIMIENTOS FUNCIONALES /////////////////////////////////////////// */
    
    
    public void Register(String UsuarioARegistrar, String ContraseniaARegistrar);
    
    public void Login(String UsuarioLogin, String ContraseniaLogin);
    
    public void Logout();

    public void Post(String TipoPublicacion, String ContenidoPublicacion, ArrayList<String> UsuariosDestino);
    
    public void Follow(String UsuarioApuntado);
    
    public void Share(int IdPublicacion, ArrayList<String> UsuariosDestino);
    
    public void Visualize();
    
    public void Comment(int IdPublicacion, int IdReaccion, String ContenidoComentario);
    
    public void Like(int IdPublicacion, int IdReaccion);
}

//La que tiene el rombo es la que contiene a la otra...
//Evitar relaciones bidireccionales
