package Interfaz;

import java.util.ArrayList;

/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica.
 * Aca se encontraran los atributos basicos de una red social, como los metodos necesarios para poder interactuar en ella.
 * @version 1.4, 07/08/2021
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
    
    public int getUsuarioViaUsername(String NombreUsuario);
    
    public boolean ValidarDestinos(ArrayList<String> ListaUsuariosDestino);
    
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
    
    /* /////////////////////////////////////////// METODO PARA ACTIVIDAD PREVIA /////////////////////////////////////////// */
    
    public void CargarActividadPrevia();
}