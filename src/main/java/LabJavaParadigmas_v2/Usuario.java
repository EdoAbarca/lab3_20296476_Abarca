package LabJavaParadigmas_v2;

import java.util.ArrayList;

public class Usuario
{
    private static int IdCorrelativoUsuarios = 1;
    private int IdUsuario;
    private int NombreUsuario;
    private int Contrasenia;
    private ArrayList<Publicacion> ListaPublicacionesUsuario;
    private ArrayList<Reaccion> ListaReaccionesPublicaciones;
}
