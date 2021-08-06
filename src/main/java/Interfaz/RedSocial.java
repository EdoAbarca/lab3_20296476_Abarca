package Interfaz;

import ClasesAbstraidas.Usuario;
import java.util.ArrayList;

/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica.
 * Aca se encontraran los atributos basicos de una red social, como los metodos necesarios para poder interactuar en ella.
 * @version 1.1, 02/07/2021
 * @author Eduardo Abarca
 * DETALLE: EN EL ENUNCIADO SE ESPECIFICA QUE ESTA CLASE ES UNA INTERFAZ. INVESTIGAR Y MODIFICAR.
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
    
    public Usuario RetornarDatosUsuarioLogueado();
    
    public boolean ValidarDestinosUsuario(ArrayList<String> ListaUsuariosDestino);
    //Metodos faltantes corresponden desde el requerimiento funcional Post.
    
    
    /* /////////////////////////////////////////// REQUERIMIENTOS FUNCIONALES /////////////////////////////////////////// */
    
    
    public void Register(String UsuarioARegistrar, String ContraseniaARegistrar);
    
    public void Login(String UsuarioLogin, String ContraseniaLogin);
    
    public void Logout();

    public void Post();
    
    public void Follow();
    
    public void Share();
    
    public void Visualize();
    
    public void Comment();
    
    public void Like();
}

//La que tiene el rombo es la que contiene a la otra...
//Evitar relaciones bidireccionales
