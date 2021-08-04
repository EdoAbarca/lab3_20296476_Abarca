package ClasesAbstraidas;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica.
 * Aca se encontraran los atributos basicos de una red social, como los metodos necesarios para poder interactuar en ella.
 * @version 1.1, 02/07/2021
 * @author Eduardo Abarca
 * DETALLE: EN EL ENUNCIADO SE ESPECIFICA QUE ESTA CLASE ES UNA INTERFAZ. INVESTIGAR Y MODIFICAR.
 */
public class RedSocial
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final String NombreRedSocial;
    private final String FechaRegistroRedSocial;
    private ArrayList<Usuario> ListaUsuarios;
    private String UsuarioLogueado;
    private boolean ProgramaEnUso;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public RedSocial(String Nombre, String Fecha)
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
    public void IniciarPrograma()
    {this.ProgramaEnUso = true;}
    
    public void FinalizarPrograma()
    {this.ProgramaEnUso = false;}
    
    public void AsignarUsuarioLogueado(String Usuario)
    {this.UsuarioLogueado = Usuario;}
    
    public void ExpulsarUsuarioLogueado()
    {this.UsuarioLogueado = null;}
    
    /* //////////////////////////////////////////////// METODOS DE APOYO //////////////////////////////////////////////// */
    
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
    
    public boolean ValidarDestinosUsuario(ArrayList<String> ListaUsuariosDestino)
    {
        return RetornarDatosUsuarioLogueado().EstanDestinosEnContactos(ListaUsuariosDestino);
    }
    
    
    
    /* /////////////////////////////////////////// REQUERIMIENTOS FUNCIONALES /////////////////////////////////////////// */
    
    
    public void Register(String UsuarioARegistrar, String ContraseniaARegistrar)
    {
        if(this.ValidarDatosRegistro(UsuarioARegistrar, ContraseniaARegistrar))
        {
            Usuario NuevoUsuario = new Usuario(UsuarioARegistrar, ContraseniaARegistrar);
            this.ListaUsuarios.add(NuevoUsuario);
        }
    }
    
    public void Login(String UsuarioLogin, String ContraseniaLogin)
    {
        if(this.ValidarCredenciales(UsuarioLogin, ContraseniaLogin))
        {this.AsignarUsuarioLogueado(UsuarioLogin);}
    }
    
    public void Logout()
    {ExpulsarUsuarioLogueado();}
    /*
    public void Post()
    {}
    
    public void Follow()
    {}
    
    public void Share()
    {}
    
    public void Visualize()
    {}
    
    public void Comment()
    {}
    
    public void Like()
    {}
    */
    
}
//La que tiene el rombo es la que contiene a la otra...
//Evitar relaciones bidireccionales

/*
EVALUAR:
 - SEPARAR ESTA CLASE
 - CONVERTIR MIEMBROS DE CLASE A MANTENER ACA EN STATIC
 - DE SER POSIBLE, DEJAR ACA SOLO LOS REQUERIMIENTOS FUNCIONALES
*/