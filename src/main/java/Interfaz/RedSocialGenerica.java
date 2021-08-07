/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import ClasesAbstraidas.PublicacionOriginal;
import ClasesAbstraidas.Usuario;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica dentro del programa.
 * Aca se encontraran los atributos basicos de una red social y los metodos necesarios para poder interactuar en ella.
 * Requerimientos funcionales cubiertos en este archivo.
 * @version 1.1, 19/07/2021
 * @author Eduardo Abarca
 */
public class RedSocialGenerica implements RedSocial
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final String NombreRedSocial;
    private final String FechaRegistroRedSocial;
    private ArrayList<Usuario> ListaUsuarios;
    private String UsuarioLogueado;
    private boolean ProgramaEnUso;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public RedSocialGenerica(String Nombre, String Fecha)
    {
        this.NombreRedSocial = Nombre;
        this.FechaRegistroRedSocial = Fecha;
        this.ListaUsuarios = new ArrayList<>();
        this.UsuarioLogueado = null;
        this.ProgramaEnUso = false;
    }
    
    /* GETTERS */
    public String getNombreRedSocial()
    {return this.NombreRedSocial;}
    
    public String getFechaRegistroRedSocial()
    {return this.FechaRegistroRedSocial;}
    
    public String getUsuarioLogueado()
    {return this.UsuarioLogueado;}
    
    public boolean getProgramaEnUso()
    {return this.ProgramaEnUso;}
    
    /* SETTERS */
    @Override
    public void IniciarPrograma()
    {this.ProgramaEnUso = true;}
    
    @Override
    public void FinalizarPrograma()
    {this.ProgramaEnUso = false;}
    
    @Override
    public void AsignarUsuarioLogueado(String Usuario)
    {this.UsuarioLogueado = Usuario;}
    
    @Override
    public void ExpulsarUsuarioLogueado()
    {this.UsuarioLogueado = null;}
    
    /* //////////////////////////////////////////////// METODOS DE APOYO //////////////////////////////////////////////// */
    
    @Override
    public String FechaDeHoy()
    {
        Calendar calendario = Calendar.getInstance();
        String anio = Integer.toString(calendario.get(Calendar.YEAR));
        String mes = Integer.toString(calendario.get(Calendar.MONTH)+1);
        String dia = Integer.toString(calendario.get(Calendar.DATE));
        return dia+"/"+mes+"/"+anio;
    }
    

    public String Fecha(int Dia, int Mes, int Anio)
    {
        //Aca poner metodo que verificara dominios de la fecha ingresada
        return Integer.toString(Dia)+"/"+Integer.toString(Mes)+"/"+Integer.toString(Anio);
    }
    
    @Override
    public boolean ValidarDatosRegistro(String Usuario, String Contrasenia)
    {
        System.out.println("Verificando datos a registrar...");
        boolean UsuarioEnUso = false, ContraseniaEnUso = false, EsPosibleRegistro;
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(Usuario))
            {
                System.out.println("Usuario en uso! Registro denegado.");
                UsuarioEnUso = true;
                break;
            }
            else if (this.ListaUsuarios.get(i).getContrasenia().equals(Contrasenia))
            {
                System.out.println("Contrasenia en uso! Registro denegado.");
                ContraseniaEnUso = true;
                break;
            }
        }
        EsPosibleRegistro = !(UsuarioEnUso) && !(ContraseniaEnUso);
        if(EsPosibleRegistro)
        {System.out.println("Datos disponibles! Registro autorizado.");}
        return EsPosibleRegistro;
    }
    
    @Override
    public boolean ValidarCredenciales(String Usuario, String Contrasenia)
    {
        System.out.println("Verificando datos de inicio sesion...");
        boolean ExisteUsuario = false, ContraseniaCoincide = false;
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(Usuario))
            {
                System.out.println("Se ha encontrado usuario! Verificando contrasenia...");
                ExisteUsuario = true;
                if(this.ListaUsuarios.get(i).getContrasenia().equals(Contrasenia))
                {
                    System.out.println("Coincide contrasenia! Acceso autorizado.");
                    ContraseniaCoincide = true;
                }
                else
                {System.out.println("No coincide contrasenia! Acceso denegado.");}
                break;
            }
        }
        if(!ExisteUsuario)
        {System.out.println("No se encontro usuario ingresado! Acceso denegado.");}
        return ExisteUsuario && ContraseniaCoincide;
    }
    
    @Override
    public Usuario getUsuarioViaUsername(String NombreUsuario)
    {
        Usuario DatosUL = null;
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(NombreUsuario))
            {DatosUL = this.ListaUsuarios.get(i);}
        }
        return DatosUL;
    }
    
    @Override
    public boolean ValidarDestinos(ArrayList<String> ListaUsuariosDestino)
    {
        return getUsuarioViaUsername(this.UsuarioLogueado).EstanDestinosEnContactos(ListaUsuariosDestino);
    }
    
    @Override
    public boolean EstaUsuarioEnSeguidos(String UsuarioApuntado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PublicacionOriginal getPublicacionViaId(int IdPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ExisteComentario(int IdPublicacion, int IdComentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ExisteLike(int IdPublicacion, int IdLike) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String SocialNetworkToString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PrintSocialNetwork(String StringConvertido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /* /////////////////////////////////////////// REQUERIMIENTOS FUNCIONALES /////////////////////////////////////////// */
    
    @Override
    public void Register(String UsuarioARegistrar, String ContraseniaARegistrar)
    {
        if(this.ValidarDatosRegistro(UsuarioARegistrar, ContraseniaARegistrar))
        {
            Usuario NuevoUsuario = new Usuario(UsuarioARegistrar, ContraseniaARegistrar);
            this.ListaUsuarios.add(NuevoUsuario);
        }
    }
    
    @Override
    public void Login(String UsuarioLogin, String ContraseniaLogin)
    {
        if(this.ValidarCredenciales(UsuarioLogin, ContraseniaLogin))
        {this.AsignarUsuarioLogueado(UsuarioLogin);}
    }
    
    @Override
    public void Logout()
    {ExpulsarUsuarioLogueado();}
    
    @Override
    public void Post(String TipoPublicacion, String ContenidoPublicacion, ArrayList<String> UsuariosDestino)
    {
        if(UsuariosDestino.isEmpty()) //No hay usuarios a dirigir publicacion, va para usuario propio
        {
            
        }
        else
        {
            if(ValidarDestinos(UsuariosDestino)) //Destinos estan en contactos de usuario logueado, se destina a crear una publicacion por cada destino
            {
                
            }
            else //Si no, se muestra mensaje con error
            {
                
            }
        }
    }
    
    @Override
    public void Follow(String UsuarioApuntado)
    {
        if(getUsuarioViaUsername(UsuarioApuntado) == null)
        {}
        else
        {
            if(EstaUsuarioEnSeguidos(UsuarioApuntado))
            {}
            else
            {}
        }
    }
    
    //De momento, solo se podran compartir publicaciones originales (sin compartir).
    //Puede que este criterio cambie en siguientes commits
    @Override
    public void Share(int IdPublicacion, ArrayList<String> UsuariosDestino)
    {
        PublicacionOriginal PublicacionApuntada = getPublicacionViaId(IdPublicacion);
        if(PublicacionApuntada == null)
        {}
        else
        {
            if(ValidarDestinos(UsuariosDestino))
            {}
            else
            {}
        }
    }
    
    @Override
    public void Visualize()
    {PrintSocialNetwork(SocialNetworkToString());}
    
    //De momento, solo se podran comentar publicaciones originales (sin compartir).
    //Puede que este criterio cambie en siguientes commits
    @Override
    public void Comment(int IdPublicacion, int IdComentario, String ContenidoComentario)
    {
        if(IdComentario > 0) //Buscar comentario
        {}
        else if(IdComentario == 0) //Buscar publicacion
        {}
        else
        {}
    }
    
    @Override
    public void Like(int IdPublicacion, int IdComentario)
    {
        if(IdComentario > 0) //Buscar comentario
        {}
        else if(IdComentario == 0) //Buscar publicacion
        {}
        else
        {}
    }

}
