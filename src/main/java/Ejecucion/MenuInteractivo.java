package Ejecucion;

/*
Laboratorio 3 Paradigmas de Programacio1n
Objetivo: Implementar un programa que simule las funcionalidades de una red social, usando el Paradigma Orientado a Objetos
Nombre Alumno: Eduardo Abarca
Seccion: C-3
Profesor: Daniel Gacitua
Entrega: Original (12/08/2021)

ENTREGA FINAL
*/


import ClasesAbstraidas.ImplementacionRedSocial;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Menu.
 * Esta clase tiene por objetivo mostrar los menus interactivos para ejecutar los metodos que respectan a los requerimientos funcionales exigidos por enunciado.
 * @version 1.4, 10/08/2021
 * @author Eduardo Abarca
 */
public class MenuInteractivo
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
        ImplementacionRedSocial RedSocialEjecucion = new ImplementacionRedSocial(NombreRedSocial);
        
        //Se inicia programa
        RedSocialEjecucion.IniciarPrograma();
        
        //Datos a usar para opciones menu
        int OpcionMenu = 0;
        Scanner LecturaMenu = new Scanner(System.in);
        boolean ValidezEntradaMenu;
        
        //Menu de unica ejecucion para dar la posibilidad de cargar actividad previa
        do
        {
            //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
            try
            {
                System.out.println("Desea cargar la actividad pedida para este programa?\n- Si (ingrese 1)\n- No (ingrese 0)\nOPCION: ");
                OpcionMenu = LecturaMenu.nextInt();
                while(OpcionMenu < 0 || OpcionMenu > 1)
                {       
                    System.out.println("Opcion invalida.\n\n");
                    System.out.println("Desea cargar la actividad previa a esta ejecucion?\n- Si (ingrese 1)\n- No (ingrese 0)\nOPCION: ");
                }
                //Entrada es valida
                ValidezEntradaMenu = true;
            }
            //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
            catch(InputMismatchException ex)
            {
                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                LecturaMenu.nextLine();
                //Entrada no es valida
                ValidezEntradaMenu = false;
            }
        }while(!ValidezEntradaMenu);
        
        //Si se selecciono si, se carga actividad previa
        if(OpcionMenu == 1)
        {RedSocialEjecucion.CargarActividadPrevia();}
        
        //Mientras no se finalize la ejecucion del programa
        while(RedSocialEjecucion.getProgramaEnUso())
        {
            //Declaracion de scans a usar en lectura de datos por consola/terminal, evitando duplicados (maximo de datos a ingresar por consola en opciones a ejecutar: 3)
            Scanner dato1 = new Scanner(System.in);
            Scanner dato2 = new Scanner(System.in);
            Scanner dato3 = new Scanner(System.in);
            
            //Muestra nombre red social
            System.out.println("RED SOCIAL: "+RedSocialEjecucion.getNombreRedSocial()+"\n");
            
            //Si no hay usuario logueado, se muestra menu adaptado a este contexto (sin login)
            if(RedSocialEjecucion.getUsuarioLogueado() == null)
            {
                do //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
                {
                    try
                    {
                        //Muestra de menu y lectura de opcion a escoger
                        System.out.print("Escoja su opcion:\n1. Registrarse\n2. Iniciar sesion\n3. Visualizar red social\n4. Salir del programa\nINTRODUZCA SU OPCION: ");
                        OpcionMenu = LecturaMenu.nextInt();
                        ValidezEntradaMenu = true;
                    }
                    //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
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
                    case 1: //REGISTER
                        String UsuarioRegistro, ContraseniaRegistro;
                        System.out.println("\nREGISTRO DE CUENTA.\n");
                        System.out.println("Ingrese el nombre de usuario a registrar: ");
                        UsuarioRegistro = dato1.nextLine();
                        System.out.println("Ingrese la contrasenia de usuario a registrar: ");
                        ContraseniaRegistro = dato2.nextLine();
                        //Llamado a metodo
                        RedSocialEjecucion.Register(UsuarioRegistro, ContraseniaRegistro);
                        break;
                        
                    case 2: //LOGIN
                        String UsuarioLogin, ContraseniaLogin;
                        System.out.println("\nINICIO SESION.\n");
                        System.out.print("Usuario: ");
                        UsuarioLogin = dato1.nextLine();
                        System.out.print("Contrasenia: ");
                        ContraseniaLogin = dato2.nextLine();
                        //Llamado a metodo
                        RedSocialEjecucion.Login(UsuarioLogin, ContraseniaLogin);
                        break;
                        
                    case 3: //VISUALIZE
                        System.out.println("\nVISUALIZACION RED SOCIAL.\n");
                        //Llamado a metodo
                        RedSocialEjecucion.Visualize();
                        break;
                        
                    case 4: //Salir del programa
                        System.out.println("\nFINALIZAR PROGRAMA.");
                        RedSocialEjecucion.FinalizarPrograma();
                        break;
                        
                    default: //Opcion fuera de las presentadas anteriormente
                        System.out.println("\nOpcion ingresada fuera del dominio presentado.\n");
                        break;      
                }
            }
            //Existe usuario logueado, se muestra menu adaptado a este contexto
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
                        //Se muestran opciones a escoger para la red social
                        System.out.print("Escoja su opcion:\n1. Realizar publicacion\n2. Seguir usuario\n3. Compartir publicacion\n4. Visualizar red social\n5. Realizar comentario\n6. Dar like\n7. Cerrar sesion\n8. Salir del programa\nINTRODUZCA SU OPCION: ");
                        
                        //Se lee lo ingresado mediante consola/terminal
                        OpcionMenu = LecturaMenu.nextInt();
                        ValidezEntradaMenu = true;
                    }
                    //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
                    catch(InputMismatchException ex)
                    {
                        System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                        LecturaMenu.nextLine();
                        ValidezEntradaMenu = false;
                    }
                }while(!ValidezEntradaMenu);
                
                //Booleano para manejar asuntos de ingreso de numeros por consola/terminal
                boolean ValidezEntero;
                
                //Se revisa numero guardado en la variable OpcionMenu
                switch(OpcionMenu)
                {
                    case 1: //POST
                        System.out.println("\nREALIZAR PUBLICACION.\n");
                        ArrayList<String> DestinatariosPublicacion = new ArrayList<>();
                        int CantidadDestinatarios = 0;
                        String ContenidoPublicacion, DestinatarioTemp;
                        System.out.println("Ingrese el contenido de la publicacion: ");
                        ContenidoPublicacion = dato1.nextLine();
                        do
                        {
                            //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
                            try
                            {
                                //Ingreso de limite de destinatarios a asignar en publicacion
                                System.out.println("Ingrese la cantidad de destinatarios a asignar en la publicacion: ");
                                CantidadDestinatarios = dato2.nextInt();
                                while(CantidadDestinatarios < 0 || CantidadDestinatarios > RedSocialEjecucion.CantidadUsuariosRegistrados())
                                {       
                                    System.out.println("Dominio fuera del permitido (Destinatarios < 0). Ademas, al momento de ejecutar este requerimiento, hay "+ RedSocialEjecucion.CantidadUsuariosRegistrados()+" usuarios registrados.\n");
                                    System.out.println("Ingrese la cantidad de destinatarios a asignar en la publicacion: ");
                                    CantidadDestinatarios = dato2.nextInt();
                                }
                                //Entrada es valida
                                ValidezEntero = true;
                            }
                            //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato2.nextLine();
                                //Entrada no es valida
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        
                        //Ciclo for para ingresar todos los destinatarios
                        for(int i = 0; i < CantidadDestinatarios; i++)
                        {
                            System.out.println("Ingrese el destinatario nro "+i+1+": ");
                            DestinatarioTemp = dato3.nextLine();
                            DestinatariosPublicacion.add(DestinatarioTemp);
                        }
                        //Llamado a metodo
                        RedSocialEjecucion.Post("Texto", ContenidoPublicacion, DestinatariosPublicacion);
                        break;
                        
                    case 2://FOLLOW
                        System.out.println("\nSEGUIR USUARIO.\n");
                        String UsuarioASeguir;
                        
                        //Ingreso de usuario a seguir
                        System.out.println("Ingrese el nombre del usuario a seguir: ");
                        UsuarioASeguir = dato1.nextLine();
                        //Llamado a metodo
                        RedSocialEjecucion.Follow(UsuarioASeguir);
                        break;
                        
                    case 3://SHARE
                        System.out.println("\nCOMPARTIR PUBLICACION.\n");
                        int IdPublicacion = 0, CantDestinatarios = 0;
                        String DestinatarioActual;
                        ArrayList<String> ListaDestinatarios = new ArrayList<>();
                        
                        //Ingreso de ID publicacion a compartir
                        do
                        {
                            //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
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
                                //Entrada es valida
                                ValidezEntero = true;
                            }
                            //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato1.nextLine();
                                //Entrada no es valida
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        
                        //Ingreso de cantidad destinatarios a compartir
                        do
                        {
                            //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
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
                                //Entrada es valida
                                ValidezEntero = true;
                            }
                            //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato2.nextLine();
                                
                                //Entrada no es valida
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        
                        //Ciclo for para ingresar los usuarios a compartir la publicacion
                        for(int i = 0; i < CantDestinatarios; i++)
                        {
                            System.out.println("Ingrese el destinatario nro "+i+1+": ");
                            DestinatarioActual = dato3.nextLine();
                            ListaDestinatarios.add(DestinatarioActual);
                        }
                        //Llamado a metodo
                        RedSocialEjecucion.Share(IdPublicacion, ListaDestinatarios);
                        break;

                    case 4: //VISUALIZE
                        System.out.println("\nVISUALIZAR RED SOCIAL.\n\n");
                        //Llamado a metodo
                        RedSocialEjecucion.Visualize();
                        break;
                        
                    case 5: //COMMENT
                        System.out.println("\nOPTATIVA: REALIZAR COMENTARIO.\n");
                        int IdPublicacionAComentar = -1, IdComentarioAResponder = -1;
                        String ContenidoComentario;
                        
                        //ingreso de ID publicacion a comentar
                        do
                        {
                            //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
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
                                //Entrada es valida
                                ValidezEntero = true;
                            }
                            //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato1.nextLine();
                                //Entrada no es valida
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        
                        //Ingreso de ID comentario a responder (si se quiere comentar publicacion, ID comentario debe ser 0)
                        do
                        {
                            //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
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
                                //Entrada es valida
                                ValidezEntero = true;
                            }
                            //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato2.nextLine();
                                //Entrada no es valida
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        
                        //Ingreso contenido comentario
                        System.out.println("Ingresa el contenido del comentario: ");
                        ContenidoComentario = dato3.nextLine();
                        
                        //Llamado a metodo
                        RedSocialEjecucion.Comment(IdPublicacionAComentar, IdComentarioAResponder, ContenidoComentario);
                        break;
                        
                    case 6: //LIKE
                        System.out.println("\nOPTATIVA: DAR LIKE.\n");
                        int IdPublicacionADarLike = -1, IdComentarioADarLike = -1;
                        
                        //Ingreso ID publicacion a dar like
                        do
                        {
                            try
                            {
                                //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
                                System.out.println("Ingrese el ID de la publicacion donde desea realizar el like: ");
                                IdPublicacionADarLike = dato1.nextInt();
                                while(IdPublicacionADarLike < 0)
                                {       
                                    System.out.println("Dominio fuera del permitido (IdPublicacion < 0).\n");
                                    System.out.println("Ingrese el ID de la publicacion donde desea realizar el like: ");
                                    IdPublicacionADarLike = dato1.nextInt();
                                }
                                //Entrada es valida
                                ValidezEntero = true;
                            }
                            //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato1.nextLine();
                                //Entrada no es valida
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        
                        //Ingreso de ID comentario a dar like (si se da like a publicacion, ID comentario debe ser 0)
                        do
                        {
                            //Tratamiento de excepcion mediante uso de bloque try-catch dentro de ciclo do-while
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
                                //Entrada es valida
                                ValidezEntero = true;
                            }
                            //Excepcion InputMismatchException, ocurre cuando se ingresa una cadena de caracteres imposible de convertir a numero entero
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Cadena de caracteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                                dato2.nextLine();
                                //Entrada no es valida
                                ValidezEntero = false;
                            }
                        }while(!ValidezEntero);
                        //Llamado a metodo
                        RedSocialEjecucion.Like(IdPublicacionADarLike, IdComentarioADarLike);
                        break;
                        
                    case 7: //LOGOUT
                        System.out.println("\nCERRAR SESION.\n");
                        //Llamado a metodo
                        RedSocialEjecucion.Logout();
                        break;
                        
                    case 8: //Salir del programa
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
