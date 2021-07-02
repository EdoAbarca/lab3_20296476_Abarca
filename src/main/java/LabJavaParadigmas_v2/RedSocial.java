package LabJavaParadigmas_v2;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica.
 * Aca se encontraran los atributos basicos de una red social, como los metodos necesarios para poder interactuar en ella.
 * @version 1.0, 01/07/2021
 * @author Eduardo Abarca
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
    
    /* /////////////////////////////////////////// REQUERIMIENTOS FUNCIONALES /////////////////////////////////////////// */
    /*
    
    public void Register()
    {}
    
    public void Login()
    {}
    
    public void Logout()
    {ExpulsarUsuarioLogueado();}
    
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
 - CONVERTIR MIEMBROS DE CLASE EN STATIC
 - DEJAR ACA SOLO LOS REQUERIMIENTOS FUNCIONALES
*/