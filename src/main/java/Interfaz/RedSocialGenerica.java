/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import ClasesAbstraidas.Usuario;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Esta clase es la que implementa la interface RedSocial. Traspasar metodos.
 * @author eduardo
 * Lo que se vera a continuacion seran los atributos y metodos que en un principio estaban implementados en la clase RedSocial.
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
    public Usuario RetornarDatosUsuarioLogueado()
    {
        Usuario DatosUL = null;
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(this.UsuarioLogueado))
            {DatosUL = this.ListaUsuarios.get(i);}
        }
        return DatosUL;
    }
    
    @Override
    public boolean ValidarDestinosUsuario(ArrayList<String> ListaUsuariosDestino)
    {
        return RetornarDatosUsuarioLogueado().EstanDestinosEnContactos(ListaUsuariosDestino);
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
    public void Post()
    {}
    
    @Override
    public void Follow()
    {}
    
    @Override
    public void Share()
    {}
    
    @Override
    public void Visualize()
    {}
    
    @Override
    public void Comment()
    {}
    
    @Override
    public void Like()
    {}

}
