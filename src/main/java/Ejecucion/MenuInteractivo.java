/*
Laboratorio 3 Paradigmas de Programación
Objetivo: Implementar un programa que simule las funcionalidades de una red social, usando el Paradigma Orientado a Objetos
Nombre Alumno: Eduardo Abarca
Seccion: C-3
Profesor: Daniel Gacitua
Entrega: Original (??/??/2021)

LO PRESENTADO EN ESTE COMMIT ESTA SUJETO A CAMBIOS
*/
package Ejecucion;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Menu.
 * Esta clase tiene por objetivo mostrar los menus interactivos para ejecutar los metodos que respectan a los requerimientos funcionales exigidos por enunciado.
 * @version 1.2, 02/07/2021
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
        //Datos a usar
        int OpcionEntrada = 0;
        Scanner LecturaEntrada = new Scanner(System.in);
        boolean ValidezEntrada;
        //Cargar actividad previa
        do
        {
            try
            {
                System.out.println("¿Desea cargar la actividad pedida para este programa?\n- Sí (ingrese 1)\n- No (ingrese 0)\nOPCION: ");
                OpcionEntrada = LecturaEntrada.nextInt();
                while(OpcionEntrada < 0 || OpcionEntrada > 1)
                {       
                    System.out.println("Opción inválida.\n\n");
                    System.out.println("¿Desea cargar la actividad previa a esta ejecución?\n- Sí (ingrese 1)\n- No (ingrese 0)\nOPCIÓN: ");
                }
                ValidezEntrada = true;
            }
            catch(InputMismatchException ex)
            {
                System.out.println("Cadena de carácteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                LecturaEntrada.nextLine();
                ValidezEntrada = false;
            }
        }while(!ValidezEntrada);
        //Tomar decision de carga en base a opcion ingresada (En proceso...)
        
        //Mostrar menu sin login (Modificar esto mas tarde, debe tener como parametro una variable booleana de inicio red social por class)
        boolean RedSocialActiva = true, Login = false;
        while(RedSocialActiva)
        {
            //Muestra nombre red social
            System.out.println("RED SOCIAL: "+"\n");
            if(!Login)
            {
                do //Tratamiento de excepción mediante uso de bloque try-catch dentro de ciclo do-while
                {
                    try
                    {
                        System.out.println("Escoja su opción:\n1. Registrarse\n2. Iniciar sesion\n3. Visualizar red social\n4. Salir del programa\nINTRODUZCA SU OPCION: ");
                        OpcionEntrada = LecturaEntrada.nextInt();
                        ValidezEntrada = true;
                    }
                    catch(InputMismatchException ex)
                    {
                        System.out.println("Cadena de carácteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                        LecturaEntrada.nextLine();
                        ValidezEntrada = false;
                    }
                }while(!ValidezEntrada);
                //Revision de opcion ingresada
                switch(OpcionEntrada)
                {
                    case 1:
                        String UsuarioRegistro, ContraseniaRegistro;
                        System.out.println("Registro de usuario (En proceso...)");
                        System.out.print("Ingrese el nombre de usuario a registrar: ");
                        UsuarioRegistro = LecturaEntrada.nextLine();
                        System.out.println("Ingrese la contrasenia de usuario a registrar: ");
                        ContraseniaRegistro = LecturaEntrada.nextLine();
                        //Llamado a metodo
                        
                        break;
                    case 2:
                        String UsuarioLogin, ContraseniaLogin;
                        System.out.println("Inicio sesion de usuario (En proceso...)");
                        System.out.print("Usuario: ");
                        UsuarioLogin = LecturaEntrada.nextLine();
                        System.out.println("Contrasenia: ");
                        ContraseniaLogin = LecturaEntrada.nextLine();
                        //Llamado a metodo
                        
                    case 3: //Salir del programa
                        
                        break;
                    case 4: //Visualizar red social
                        
                        break;
                    default: //Opción fuera de las presentadas anteriormente
                        System.out.println("Opcion ingresada fuera del dominio presentado.\n");
                        break;      
                }
            }
            else
            {
                //Sesion iniciada, se muestra usuario logueado
                System.out.println("## Sesion iniciada como: "+" ##");
                //Muestra menu
                do
                {
                    //Tratamiento de excepción mediante uso de bloque try-catch dentro de ciclo do-while
                    try
                    {
                        System.out.println("Escoja su opción:\n1. Realizar publicacion\n2. Seguir usuario\n3. Compartir publicacion\n4. Visualizar red social\n5. Cerrar sesion\n6. Salir del programa\nINTRODUZCA SU OPCION: ");
                        OpcionEntrada = LecturaEntrada.nextInt();
                        ValidezEntrada = true;
                    }
                    //Excepción InputMismatchException, ocurre cuando se ingresa una cadena de carácteres imposible de convertir a numero entero
                    catch(InputMismatchException ex)
                    {
                        System.out.println("Cadena de carácteres no-convertible detectada. Es requerido el reingreso de datos.\n");
                        LecturaEntrada.nextLine();
                        ValidezEntrada = false;
                    }
                }while(!ValidezEntrada);
                
                switch(OpcionEntrada)
                {
                    case 1:
                        System.out.println("REALIZAR PUBLICACION (En proceso...).\n");
                        break;
                    case 2:
                        System.out.println("SEGUIR USUARIO (En proceso...).\n");
                        break;
                    case 3:
                        System.out.println("COMPARTIR PUBLICACION (En proceso...).\n");
                        break;
                    case 4:
                        System.out.println("VISUALIZAR RED SOCIAL (En proceso...).\n");
                        break;
                    case 5:
                        System.out.println("OPTATIVA: REALIZAR COMENTARIO (En proceso...).\n");
                        break;
                    case 6:
                        System.out.println("OPTATIVA: DAR LIKE (En proceso...).\n");
                        break;
                    case 7:
                        System.out.println("CERRAR SESION.\n");
                        break;
                    case 8:
                        System.out.println("FINALIZAR PROGRAMA.\n");
                        break;
                    default:
                        System.out.println("Opcion ingresada fuera del dominio presentado.\n");
                        break;
                }
            }
        }
    }
}
