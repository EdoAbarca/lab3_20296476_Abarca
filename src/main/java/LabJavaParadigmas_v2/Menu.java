package LabJavaParadigmas_v2;

/*
Laboratorio 3 Paradigmas de Programacio1n
Objetivo: Implementar un programa que simule las funcionalidades de una red social, usando el Paradigma Orientado a Objetos
Nombre Alumno: Eduardo Abarca
Seccion: C-3
Profesor: Daniel Gacitua
Entrega: Original (12/08/2021)

ENTREGA FINAL BETA
*/

import ClasesAbstraidas.RedSocialGenerica;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Menu.
 * Esta clase tiene por objetivo mostrar los menus interactivos para ejecutar los metodos que respectan a los requerimientos funcionales exigidos por enunciado.
 * @version 1.3, 07/08/2021
 * @author Eduardo Abarca
 */
public class Menu
{
    
    /** Metodo main
     * Aca se inicia la ejecucion del programa, mostrando los menus interactivos y ejecutando los requerimientos funcionales en base a la opcion escogida.
     * @param args los argumentos ingresados por linea de comandos
     */
    public static void main(String[] args)
    {
        //Campo permitido para ser modificado: Nombre red social
        //////////////////////////////////////////////////////////
        String NombreRedSocial = "InstaBook";
        //////////////////////////////////////////////////////////
        
        //Instancia de red social
        RedSocialGenerica RedSocialEjecucion = new RedSocialGenerica(NombreRedSocial);
        RedSocialEjecucion.IniciarPrograma();
        
        //Datos a usar
        int OpcionMenu = 0;
        Scanner LecturaMenu = new Scanner(System.in);
        boolean ValidezEntradaMenu;
        
        //Cargar actividad previa
        /*
        do
        {
            try
            {
                System.out.println("¿Desea cargar la actividad pedida para este programa?\n- Si­ (ingrese 1)\n- No (ingrese 0)\nOPCION: ");
                OpcionEntrada = LecturaEntrada.nextInt();
                while(OpcionEntrada < 0 || OpcionEntrada > 1)
                {       
                    System.out.println("Opcion invalida.\n\n");
                    System.out.println("¿Desea cargar la actividad previa a esta ejecucion?\n- Si­ (ingrese 1)\n- No (ingrese 0)\nOPCION: ");
                }
                ValidezEntrada = true;
            }
            catch(InputMismatchException ex)
            {
                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                LecturaEntrada.nextLine();
                ValidezEntrada = false;
            }
        }while(!ValidezEntrada);
        //Tomar decision de carga en base a opcion ingresada (En proceso...)
        if(OpcionEntrada == 1)
        {RedSocialEjecucion.CargarActividadPrevia();}
        */
        //Mostrar menu sin login 
        while(RedSocialEjecucion.getProgramaEnUso())
        {
            //Declaracion de scans a usar en lectura de datos por consola/terminal, evitando duplicados (maximo de datos a ingresar por consola en opciones a ejecutar: 3)
            Scanner dato1 = new Scanner(System.in);
            Scanner dato2 = new Scanner(System.in);
            Scanner dato3 = new Scanner(System.in);
            
            //Muestra nombre red social
            System.out.println("RED SOCIAL: "+RedSocialEjecucion.getNombreRedSocial()+"\n");
            if(RedSocialEjecucion.getUsuarioLogueado() == null)
            {
                do //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
                {
                    try
                    {
                        System.out.print("Escoja su opcion:\n1. Registrarse\n2. Iniciar sesion\n3. Visualizar red social\n4. Salir del programa\nINTRODUZCA SU OPCION: ");
                        OpcionMenu = LecturaMenu.nextInt();
                        ValidezEntradaMenu = true;
                    }
                    catch(InputMismatchException ex)
                    {
                        System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                        LecturaMenu.nextLine();
                        ValidezEntradaMenu = false;
                    }
                }while(!ValidezEntradaMenu);
                
                //Revision de opcion ingresada
                switch(OpcionMenu)
                {
                    case 1:
                        String UsuarioRegistro, ContraseniaRegistro;
                        System.out.println("\nREGISTRO DE CUENTA.\n");
                        System.out.println("Ingrese el nombre de usuario a registrar: ");
                        UsuarioRegistro = dato1.nextLine();
                        System.out.println("Ingrese la contrasenia de usuario a registrar: ");
                        ContraseniaRegistro = dato2.nextLine();
                        //Llamado a metodo
                        RedSocialEjecucion.Register(UsuarioRegistro, ContraseniaRegistro);
                        break;
                        
                    case 2:
                        String UsuarioLogin, ContraseniaLogin;
                        System.out.println("\nINICIO SESION.\n");
                        System.out.print("Usuario: ");
                        UsuarioLogin = dato1.nextLine();
                        System.out.print("Contrasenia: ");
                        ContraseniaLogin = dato2.nextLine();
                        //Llamado a metodo
                        RedSocialEjecucion.Login(UsuarioLogin, ContraseniaLogin);
                        break;
                        
                    case 3: //Visualizar red social
                        System.out.println("\nVISUALIZACION RED SOCIAL (En proceso...).\n");
                        //Llamado a metodo
                        RedSocialEjecucion.Visualize();
                        break;
                        
                    case 4: //Salir del programa
                        System.out.println("\nFINALIZAR PROGRAMA.\n");
                        RedSocialEjecucion.FinalizarPrograma();
                        break;
                        
                    default: //Opcion fuera de las presentadas anteriormente
                        System.out.println("\nOpcion ingresada fuera del dominio presentado.\n");
                        break;      
                }
            }
            else
            {
                //Sesion iniciada, se muestra usuario logueado
                System.out.println("## Sesion iniciada como: "+ RedSocialEjecucion.getUsuarioLogueado()+" ##");
                //Muestra menu
                do
                {
                    //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
                    try
                    {
                        System.out.print("Escoja su opcion:\n1. Realizar publicacion\n2. Seguir usuario\n3. Compartir publicacion\n4. Visualizar red social\n5. Realizar comentario\n6. Dar like\n7. Cerrar sesion\n8. Salir del programa\nINTRODUZCA SU OPCION: ");
                        OpcionMenu = LecturaMenu.nextInt();
                        ValidezEntradaMenu = true;
                    }
                    //ExcepciÃ³n InputMismatchException, ocurre cuando se ingresa una cadena de carÃ¡cteres imposible de convertir a numero entero
                    catch(InputMismatchException ex)
                    {
                        System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                        LecturaMenu.nextLine();
                        ValidezEntradaMenu = false;
                    }
                }while(!ValidezEntradaMenu);
                
                boolean ValidezEntero;
                switch(OpcionMenu)
                {
                    case 1:
                        System.out.println("\nREALIZAR PUBLICACION.\n");
                        ArrayList<String> DestinatariosPublicacion = new ArrayList<>();
                        int CantidadDestinatarios = 0;
                        String ContenidoPublicacion, DestinatarioTemp;
                        System.out.println("Ingrese el contenido de la publicacion: ");
                        ContenidoPublicacion = dato1.nextLine();
                        do
                        {
                            try
                            {
                                System.out.println("Ingrese la cantidad de destinatarios a asignar en la publicacion: ");
                                CantidadDestinatarios = dato2.nextInt();
                                while(CantidadDestinatarios < 0 || CantidadDestinatarios > RedSocialEjecucion.CantidadUsuariosRegistrados())
                                {       
                                    System.out.println("Dominio fuera del permitido (Destinatarios < 0). Ademas, al momento de ejecutar este requerimiento, hay "+ RedSocialEjecucion.CantidadUsuariosRegistrados()+" usuarios registrados.\n");
                                    System.out.println("Ingrese la cantidad de destinatarios a asignar en la publicacion: ");
                                    CantidadDestinatarios = dato2.nextInt();
                                }
                                ValidezEntero = true;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato2.nextLine();
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        
                        for(int i = 0; i < CantidadDestinatarios; i++)
                        {
                            System.out.println("Ingrese el destinatario nro "+i+1+": ");
                            DestinatarioTemp = dato3.nextLine();
                            DestinatariosPublicacion.add(DestinatarioTemp);
                        }
                        //Llamado a metodo
                        RedSocialEjecucion.Post("Texto", ContenidoPublicacion, DestinatariosPublicacion);
                        break;
                        
                    case 2:
                        System.out.println("\nSEGUIR USUARIO.\n");
                        String UsuarioASeguir;
                        System.out.println("Ingrese el nombre del usuario a seguir: ");
                        UsuarioASeguir = dato1.nextLine();
                        //Llamado a metodo
                        RedSocialEjecucion.Follow(UsuarioASeguir);
                        break;
                        
                    case 3:
                        System.out.println("\nCOMPARTIR PUBLICACION.\n");
                        int IdPublicacion = 0, CantDestinatarios = 0;
                        String DestinatarioActual;
                        ArrayList<String> ListaDestinatarios = new ArrayList<>();
                        do
                        {
                            try
                            {
                                System.out.println("Ingrese el ID de la publicacion a compartir: ");
                                IdPublicacion = dato1.nextInt();
                                while(IdPublicacion < 0)
                                {       
                                    System.out.println("Dominio fuera del permitido (IdPublicacion < 0).\n");
                                    System.out.println("Ingrese el ID de la publicacion a compartir: ");
                                    IdPublicacion = dato1.nextInt();
                                }
                                ValidezEntero = true;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato1.nextLine();
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        do
                        {
                            try
                            {
                                System.out.println("Ingrese la cantidad de destinatarios a asignar en la publicacion: ");
                                CantDestinatarios = dato2.nextInt();
                                while(CantDestinatarios < 0)
                                {       
                                    System.out.println("Dominio fuera del permitido (Destinatarios < 0).\n");
                                    System.out.println("Ingrese la cantidad de destinatarios a asignar en la publicacion: ");
                                    CantDestinatarios = dato2.nextInt();
                                }
                                ValidezEntero = true;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato2.nextLine();
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        
                        for(int i = 0; i < CantDestinatarios; i++)
                        {
                            System.out.println("Ingrese el destinatario nro "+i+1+": ");
                            DestinatarioActual = dato3.nextLine();
                            ListaDestinatarios.add(DestinatarioActual);
                        }
                        //Llamado a metodo
                        RedSocialEjecucion.Share(IdPublicacion, ListaDestinatarios);
                        break;

                    case 4:
                        System.out.println("\nVISUALIZAR RED SOCIAL (En proceso...).\n\n");
                        //Llamado a metodo
                        RedSocialEjecucion.Visualize();
                        break;
                        
                    case 5:
                        System.out.println("\nOPTATIVA: REALIZAR COMENTARIO (En proceso...).\n");
                        int IdPublicacionAComentar = -1, IdComentarioAResponder = -1;
                        String ContenidoComentario;
                        do
                        {
                            try
                            {
                                System.out.println("Ingrese el ID de la publicacion a comentar: ");
                                IdPublicacionAComentar = dato1.nextInt();
                                while(IdPublicacionAComentar < 0)
                                {       
                                    System.out.println("Dominio fuera del permitido (IdPublicacion < 0).\n");
                                    System.out.println("Ingrese el ID de la publicacion a compartir: ");
                                    IdPublicacionAComentar = dato1.nextInt();
                                }
                                ValidezEntero = true;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato1.nextLine();
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        do
                        {
                            try
                            {
                                System.out.println("Ingrese el ID del comentario a responder (0 si desea comentar la publicacion directamente): ");
                                IdComentarioAResponder = dato2.nextInt();
                                while(IdComentarioAResponder < 0)
                                {       
                                    System.out.println("Dominio fuera del permitido (IdComentario < 0).\n");
                                    System.out.println("Ingrese el comentario a responder (de la publicacion): ");
                                    IdComentarioAResponder = dato2.nextInt();
                                }
                                ValidezEntero = true;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato2.nextLine();
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        System.out.println("Ingresa el contenido del comentario: ");
                        ContenidoComentario = dato3.nextLine();
                        //Llamado a metodo
                        RedSocialEjecucion.Comment(IdPublicacionAComentar, IdComentarioAResponder, ContenidoComentario);
                        break;
                        
                    case 6:
                        System.out.println("\nOPTATIVA: DAR LIKE (En proceso...).\n");
                        int IdPublicacionADarLike = -1, IdComentarioADarLike = -1;
                        do
                        {
                            try
                            {
                                System.out.println("Ingrese el ID de la publicacion donde desea realizar el like: ");
                                IdPublicacionADarLike = dato1.nextInt();
                                while(IdPublicacionADarLike < 0)
                                {       
                                    System.out.println("Dominio fuera del permitido (IdPublicacion < 0).\n");
                                    System.out.println("Ingrese el ID de la publicacion donde desea realizar el like: ");
                                    IdPublicacionADarLike = dato1.nextInt();
                                }
                                ValidezEntero = true;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato1.nextLine();
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        do
                        {
                            try
                            {
                                System.out.println("Ingrese el comentario a dar like (0 si desea dar like a la publicacion anteriormente escogida): ");
                                IdComentarioADarLike = dato2.nextInt();
                                while(IdComentarioADarLike < 0)
                                {       
                                    System.out.println("Dominio fuera del permitido (IdComentario < 0).\n");
                                    System.out.println("Ingrese el comentario a dar like (0 si desea dar like a la publicacion anteriormente escogida): ");
                                    IdComentarioADarLike = dato2.nextInt();
                                }
                                ValidezEntero = true;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato2.nextLine();
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        //Llamado a metodo
                        RedSocialEjecucion.Like(IdPublicacionADarLike, IdComentarioADarLike);
                        break;
                        
                    case 7:
                        System.out.println("\nCERRAR SESION.\n");
                        //Llamado a metodo
                        RedSocialEjecucion.Logout();
                        break;
                        
                    case 8:
                        System.out.println("\nFINALIZAR PROGRAMA.\n");
                        //Llamado a metodo
                        RedSocialEjecucion.FinalizarPrograma();
                        break;
                        
                    default:
                        System.out.println("\nOpcion ingresada fuera del dominio presentado.\n");
                        break;
                }
            }
        }
    }
}
