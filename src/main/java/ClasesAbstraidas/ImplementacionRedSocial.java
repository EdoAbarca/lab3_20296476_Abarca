package ClasesAbstraidas;

import Interfaz.RedSocial;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica dentro del programa.
 * Aca se encontraran los atributos basicos de una red social y los metodos necesarios para poder interactuar en ella.
 * Requerimientos funcionales cubiertos en este archivo.
 * @version 1.4, 11/08/2021
 * @author Eduardo Abarca
 */
public class ImplementacionRedSocial implements RedSocial
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final String NombreRedSocial;
    private final String FechaRegistroRedSocial;
    private final ArrayList<Usuario> ListaUsuarios;
    private String UsuarioLogueado;
    private boolean ProgramaEnUso;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para ImplementacionRedSocial
     * @param NombreAsignado Nombre para red social
     */

    public ImplementacionRedSocial(String NombreAsignado)
    {
        this.NombreRedSocial = NombreAsignado;
        this.FechaRegistroRedSocial = FechaDeHoy();
        this.ListaUsuarios = new ArrayList<>();
        this.UsuarioLogueado = null;
        this.ProgramaEnUso = false;
    }
    
    /* GETTERS */

    /**
     * Getter para NombreRedSocial
     * @return NombreRedSocial (String)
     */
    public String getNombreRedSocial()
    {return this.NombreRedSocial;}
    
    /**
     * Getter para UsuarioLogueado
     * @return UsuarioLogueado (String)
     */
    public String getUsuarioLogueado()
    {return this.UsuarioLogueado;}
    
    /**
     * Getter para ProgramaEnUso
     * @return ProgramaEnUso (String)
     */
    public boolean getProgramaEnUso()
    {return this.ProgramaEnUso;}
    
    
    /* SETTERS */

    /**
     * Primer setter para ProgramaEnUso.
     */

    @Override 
    public void IniciarPrograma()
    {this.ProgramaEnUso = true;}
    
    /**
     * Segundo setter para ProgramaEnUso.
     */
    @Override
    public void FinalizarPrograma()
    {
        System.out.println("\nSee ya soon!");
        this.ProgramaEnUso = false;
    }
    
    /**
     * Primer setter para UsuarioLogueado
     * @param Usuario Usuario registrado que inicio sesion
     */
    @Override
    public void AsignarUsuarioLogueado(String Usuario)
    {this.UsuarioLogueado = Usuario;}
    
    /**
     * Segundo setter para UsuarioLogueado.
     */
    @Override
    public void ExpulsarUsuarioLogueado()
    {this.UsuarioLogueado = null;}
    
    /* //////////////////////////////////////////////// METODOS DE APOYO //////////////////////////////////////////////// */

    /**
     * Metodo que genera la fecha de la ejecucion de este programa, a registrar en las clases a instanciar
     * @return Fecha en formato String dd/mm/yyyy 
     */
    @Override
    public String FechaDeHoy()
    {
        //Instancia de Calendar, para poder obtener la fecha de hoy
        Calendar calendario = Calendar.getInstance();
        
        //Se obtiene cada parte de la fecha, convirtiendo de int a string
        String anio = Integer.toString(calendario.get(Calendar.YEAR));
        String mes = Integer.toString(calendario.get(Calendar.MONTH)+1);
        String dia = Integer.toString(calendario.get(Calendar.DATE));
        
        //Se retorna un string con la fecha en formato dd/mm/yyyy
        return dia+"/"+mes+"/"+anio;
    }
        
    /**
     * Metodo que verifica si el usuario a registrar no esta en uso
     * @param Usuario Usuario a registrar
     * @param Contrasenia Contrasenia a registrar
     * @return Booleano -> false: Usuario esta en uso / true: Usuario esta disponible para ser registrado
     */
    @Override
    public boolean ValidarDatosRegistro(String Usuario, String Contrasenia)
    {
        System.out.println("\nVerificando datos a registrar...");
        boolean UsuarioEnUso = false, ContraseniaEnUso = false, EsPosibleRegistro;
        
        //Se revisa lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Se encontro usuario, no es posible registro
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(Usuario))
            {
                System.out.println("Usuario en uso! Registro denegado.");
                UsuarioEnUso = true;
                break;
            }
            // Se encontro contrasenia, se definio que no se pueden repetir entre usuarios
            else if (this.ListaUsuarios.get(i).getContrasenia().equals(Contrasenia))
            {
                System.out.println("Contrasenia en uso! Registro denegado.");
                ContraseniaEnUso = true;
                break;
            }
        }
        
        //Se almacena resultado bajo el siguiente criterio: Se puede registrar si el usuario no esta en uso y la contrasenia no esta en uso
        EsPosibleRegistro = !(UsuarioEnUso) && !(ContraseniaEnUso);
        
        //Si el resultado es true, se habilita registro
        if(EsPosibleRegistro)
        {System.out.println("Datos disponibles! Registro autorizado.");}
        
        //Se retorna resultado
        return EsPosibleRegistro;
    }
    
    /**
     * Metodo que verifica la validez de las credenciales ingresadas (i.e., que existe un usuario con esos datos)
     * @param Usuario Usuario que quiere iniciar sesion
     * @param Contrasenia Contrasenio de usuario que quiere iniciar sesion
     * @return Booleano -> false: Datos de usuario y contrasenia no coinciden con ningun usuario / true: Ambos parametros coinciden con un solo usuario
     */
    @Override
    public boolean ValidarCredenciales(String Usuario, String Contrasenia)
    {
        System.out.println("Verificando datos de inicio sesion...");
        boolean ExisteUsuario = false, ContraseniaCoincide = false;
        
        //Se revisa lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Se encontro usuario, se guarda registro de esto en su variable respectiva
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(Usuario))
            {
                System.out.println("Se ha encontrado usuario! Verificando contrasenia...");
                ExisteUsuario = true;
                
                //Si la contrasenia tambien coincide, se almacena registro de esto
                if(this.ListaUsuarios.get(i).getContrasenia().equals(Contrasenia))
                {
                    System.out.println("Coincide contrasenia! Acceso autorizado.");
                    ContraseniaCoincide = true;
                    break;
                }
                
                //Si no coincide contrasenia, se advierte de esto por consola/terminal
                else
                {System.out.println("No coincide contrasenia! Acceso denegado.");}
                break;
            }
        }
        
        //Si no se encontro usuario, se advierte de esto por consola/terminal
        if(!ExisteUsuario)
        {System.out.println("No se encontro usuario ingresado! Acceso denegado.");}
        
        //Se retorna resultado
        return ExisteUsuario && ContraseniaCoincide;
    }
    
    /**
     * Metodo que retorna la posicion en el ArrayList del usuario apuntado por parametro
     * @param Usuario Usuario al que se busca obtener su ubicacion (indice)
     * @return Entero, valor de su posicion (indice) en su coleccion (ArrayList)
     */
    @Override
    public int getUsuarioViaUsername(String Usuario)
    {
        //Variable a retornar (por defecto -1 por si no se encuentra usuario)
        int IndiceUsuarioRetorno = -1;
        
        //Se recorre lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Se encontro usuario apuntado, se guarda indice y se corta ciclo for
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(Usuario))
            {
                IndiceUsuarioRetorno = i;
                break;
            }
        }
        
        //Se retorna resultado
        return IndiceUsuarioRetorno;
    }
    
    /**
     * Metodo que, en base al ID de una publicacion original, retorna la posicion del usuario duenio de tal publicacion
     * @param id ID publicacion original apuntada
     * @return Posicion (indice) en el ArrayList del usuario duenio de la publicacion
     */
    @Override
    public int ReferenciarUsuarioPublicacionOr(int id)
    {
        //Variable a retornar (por defecto -1 por si no se encuentra publicacion original con ese id)
        int IndiceUsuario = -1;
        
        //Se recorre lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Si el usuario actual tiene una publicacion original con ese id, se guarda indice y se corta ciclo for
            if(this.ListaUsuarios.get(i).getPublicacionOriginalPorId(id) != -1)
            {
                IndiceUsuario = i;
                break;
            }
        }
        
        //retorno de indice
        return IndiceUsuario;
    }
    
    /**
     * Metodo que, en base al ID de una publicacion compartida, retorna la posicion del usuario duenio de tal publicacion 
     * @param id ID publicacion compartida apuntada
     * @return Posicion (indice) en el ArrayList del usuario duenio de la publicacion
     */
    @Override
    public int ReferenciarUsuarioPublicacionComp(int id)
    {
        //Variable a retornar (por defecto -1 por si no se encuentra publicacion compartida con ese id)
        int IndiceUsuario = -1;
        
        //Se recorre lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Si el usuario actual tiene una publicacion compartida con ese id, se guarda indice y se corta ciclo for
            if(this.ListaUsuarios.get(i).getPublicacionCompartidaPorId(id) != -1)
            {
                IndiceUsuario = i;
                break;
            }
        }
        
        //retorno de indice
        return IndiceUsuario;
    }
    
    /**
     * Metodo que retorna la cantidad de usuarios registrados
     * @return Entero
     */
    @Override
    public int CantidadUsuariosRegistrados()
    {return this.ListaUsuarios.size();}
    
    /**
     * Metodo que busca al usuario logueado en el ArrayList de usuarios y revisa si los destinos ingresados por parametros estan en sus contactos
     * @param ListaDestinos Destinos ingresados por consola/terminal
     * @return Boolean -> true: Todos los destinos estan en contactos / false: Algun/ningun destino no esta en contactos
     */
    @Override
    public boolean ValidarDestinos(ArrayList<String> ListaDestinos)
    {
        return this.ListaUsuarios.get(getUsuarioViaUsername(this.UsuarioLogueado)).EstanDestinosEnContactos(ListaDestinos);
    }
    
    /**
     * Metodo que transforma la informacion contenida en la red social a un gran string. Parte de Visualize.
     * @return String con toda la informacion convertida
     */
    @Override
    public String SocialNetworkToString()
    {
        //Parte del string que guardara los datos de registro de la red social
        String StringRedSocial = "INFORMACION RED SOCIAL:\n\nNombre red social: "+this.NombreRedSocial+"\nFecha registro red social: "+this.FechaRegistroRedSocial+"\n\n";
        
        //Si no hay usuario logueado, se guarda toda la informacion de la red social
        if(this.UsuarioLogueado == null)
        {
            StringRedSocial += "INFORMACION USUARIOS REGISTRADOS:\n\n";
            
            //Si no hay usuarios registrados, se agrega string con mensaje por defecto
            if(this.ListaUsuarios.isEmpty())
            {StringRedSocial += "SIN USUARIO REGISTRADOS.\n\n";}
            
            //Caso contrario, se guarda toda la informacion de los usuarios registrados
            else
            {
                for(int i = 0; i < this.ListaUsuarios.size(); i++)
                {StringRedSocial += this.ListaUsuarios.get(i).UsuarioAString();}
            }
        }
        
        //Caso contrario, se filtra la informacion, guardando solo la informacion del usuario logueado
        else
        {
            //Indice usuario logueado
            int IndiceUsuarioLogueado = this.getUsuarioViaUsername(this.UsuarioLogueado);
            
            //Guardado informacion de usuario
            StringRedSocial += "INFORMACION USUARIO LOGUEADO:\n\n"+this.ListaUsuarios.get(IndiceUsuarioLogueado).UsuarioAString();
        }
        
        //Luego de todo el procesamiento presentado, se retorna string con la informacion
        return StringRedSocial;
    }

    /**
     * Metodo que muestra por la consola/terminal la red social convertida a un gran string. Parte de Visualize
     * @param StringConvertido String con la informacion de la red social
     */
    @Override
    public void PrintSocialNetwork(String StringConvertido)
    {System.out.println(StringConvertido+"\nFIN DATOS RED SOCIAL.\n\n");}
    
    /* /////////////////////////////////////////// REQUERIMIENTOS FUNCIONALES /////////////////////////////////////////// */

    /**
     * Requerimiento funcional Register, parte de Authentication, registra un usuario en la red social
     * @param UsuarioARegistrar Usuario que se busca registrar
     * @param ContraseniaARegistrar Contrasenia a ligar al usuario
     */

    
    @Override
    public void Register(String UsuarioARegistrar, String ContraseniaARegistrar)
    {
        //Si los datos estan disponibles, se registra nuevo usuario
        if(ValidarDatosRegistro(UsuarioARegistrar, ContraseniaARegistrar))
        {
            Usuario NuevoUsuario = new Usuario(UsuarioARegistrar, ContraseniaARegistrar);
            this.ListaUsuarios.add(NuevoUsuario);
            
            //Muestra informacion nuevo usuario por consola/terminal
            System.out.println("Usuario registrado exitosamente!\nInformacion usuario registrado: "+NuevoUsuario.UsuarioAString());
        }
        
        //Caso contrario, no es posible registrar nuevo usuario, advertencia de esto por consola/terminal
        else
        {System.out.println("Error: Nombre de usuario ya esta en uso.\n");}
    }
    
    /**
     * Requermiento funcional Login, parte de Authentication, inicia sesion con un usuario registrado
     * @param UsuarioLogin
     * @param ContraseniaLogin
     */
    @Override
    public void Login(String UsuarioLogin, String ContraseniaLogin)
    {
        //Si se encontro un usuario que coincida con las credenciales ingresadas, se inicia sesion con ese usuario
        if(ValidarCredenciales(UsuarioLogin, ContraseniaLogin))
        {
            AsignarUsuarioLogueado(UsuarioLogin);
            System.out.println("Sesion iniciada exitosamente!\n");
        }
        
        //Caso contrario, se adiverte del fallo por consola/terminal
        else
        {System.out.println("Error de credenciales.\n");}
    }
    
    /**
     * Requerimiento funcional Logout, parte de Authentication, finaliza la sesion del usuario logueado
     */
    @Override
    public void Logout()
    {ExpulsarUsuarioLogueado();}
    
    /**
     * Requerimiento funcional Post, el usuario con sesion iniciada realiza una publicacion en la red social, teniendo la posibilidad de asignar destinatarios a esta.
     * @param TipoPublicacion Tipo de la publicacion creada
     * @param ContenidoPublicacion Contenido (Cuerpo) de la publicacion
     * @param UsuariosDestino Lista de contactos a los cuales se les destina la publicacion
     */
    @Override
    public void Post(String TipoPublicacion, String ContenidoPublicacion, ArrayList<String> UsuariosDestino)
    {
        //Si no hay destinos para la publicacion, se procede a crear post directamente
        if(UsuariosDestino.isEmpty())
        {
            System.out.println("Post no tendra destinos.\n");
            
            //Crear publicacion
            PublicacionOriginal NuevaPublicacion = new PublicacionOriginal(FechaDeHoy(), this.UsuarioLogueado, TipoPublicacion, ContenidoPublicacion, UsuariosDestino);
            
            //Referenciar indice usuario logueado 
            int IndiceUsuarioLogueado = getUsuarioViaUsername(this.UsuarioLogueado);
            
            //Agregar publicacion a espacio usuario logueado
            this.ListaUsuarios.get(IndiceUsuarioLogueado).PublicacionesUsuario.add(NuevaPublicacion);
            this.ListaUsuarios.get(IndiceUsuarioLogueado);
            //Muestra de la nueva publicacion por consola
            System.out.println("Post creado exitosamente!\nInformacion del post: "+NuevaPublicacion.PublicacionAString());
        }
        
        //Caso contrario, se verifican los destinos ingresados
        else
        {
            if(ValidarDestinos(UsuariosDestino)) //Si los destinos son validos, se procede a crear y guardar publicacion
            {
                System.out.println("Destinos son validos, se procede a crear el post...");
                
                //Crear publicacion
                PublicacionOriginal NuevaPublicacion = new PublicacionOriginal(FechaDeHoy(), this.UsuarioLogueado, TipoPublicacion, ContenidoPublicacion, UsuariosDestino);
            
                //Referenciar indice usuario logueado 
                int IndiceUsuarioLogueado = getUsuarioViaUsername(this.UsuarioLogueado);
            
                //Agregar publicacion a espacio usuario logueado
                
                this.ListaUsuarios.get(IndiceUsuarioLogueado).PublicacionesUsuario.add(NuevaPublicacion);
                
                //Muestra de la nueva publicacion por consola
                System.out.println("Post creado exitosamente!\nInformacion del post: "+NuevaPublicacion.PublicacionAString());
            }
            
            //Caso contrario, no es posible crear el post, se adiverte de esto por consola/terminal
            else
            {System.out.println("Error: Usuario(s) ingresado(s) en destinatarios no es(son) contactos del usuario logueado.\n");}
        }
    }
    
    /**
     * Requerimiento funcional Follow, el usuario con sesion iniciada sigue a otro usuario registrado en la red social 
     * @param UsuarioApuntado
     */
    @Override
    public void Follow(String UsuarioApuntado)
    {
        //Indices de usuario ingresado por parametro y usuario logueado
        int IndiceUsuarioApuntado = getUsuarioViaUsername(UsuarioApuntado);
        int IndiceUsuarioLogueado = getUsuarioViaUsername(this.UsuarioLogueado);
        
        //Si no se encontro usuario con ese username, se advierte de esto por consola/terminal
        if(IndiceUsuarioApuntado == -1)
        {System.out.println("Error: Usuario a seguir no existe.\n");}
        
        //Caso contrario, se revisan los otros casos posibles de error
        else
        {
            // Si el usuario ya se siguio previamente, no se puede seguir de nuevo, advertencia de esto por consola/terminal
            if(this.ListaUsuarios.get(IndiceUsuarioLogueado).EstaEnSeguidos(UsuarioApuntado)) 
            {System.out.println("Error: Usuario a seguir ya esta seguido.\n");}
            
            // Usuario a seguir es el mismo con el que se inicio sesion, advertencia de esto por consola/terminal
            else if (IndiceUsuarioApuntado == IndiceUsuarioLogueado)
            {System.out.println("Error: Usuario ingresado es usuario logueado.\n");}
            else //Se cumplen condiciones, se sigue usuario apuntado
            {
                this.ListaUsuarios.get(IndiceUsuarioApuntado).AgregarSeguidor(this.UsuarioLogueado);
                this.ListaUsuarios.get(IndiceUsuarioLogueado).AgregarSeguimiento(UsuarioApuntado);
                System.out.println("Usuario seguido exitosamente!\nInformacion usuario logueado: "+this.ListaUsuarios.get(IndiceUsuarioLogueado).UsuarioAString()+"\nInformacion usuario seguido: "+this.ListaUsuarios.get(IndiceUsuarioApuntado).UsuarioAString());
            }
        }
    }

    /**
     * Requerimiento funcional Share, el usuario con sesion iniciada compartira una publicacion ya creada, ya sea a los destinos asignados o en su propio espacio (sin destinos).
     * @param IdPublicacion ID de la publicacion a compartir
     * @param UsuariosDestino Lista de destinos (contactos) a compartir la publicacion
     */
    @Override
    public void Share(int IdPublicacion, ArrayList<String> UsuariosDestino)
    {
        //Se obtiene indice usuario al que le pertenece la publicacion original con ese ID
        int IndiceUsuarioPublicacion = this.ReferenciarUsuarioPublicacionOr(IdPublicacion);
        int IndicePublicacion;
        
        //Si el valor del indice de usuario no es el valor por defecto, se encontro publicacion original con ese ID
        if(IndiceUsuarioPublicacion > -1)
        {
            //Si los destinos ingresados pertenecen a los contactos del usuario logueado (o no hay destinos), es posible compartir la publicacion
            if(ValidarDestinos(UsuariosDestino))
            {
                System.out.println("Destinos son validos, se procede a compartir el post...\n");
                
                //Se recupera indice publicacion a compartir
                IndicePublicacion = this.ListaUsuarios.get(IndiceUsuarioPublicacion).getPublicacionOriginalPorId(IdPublicacion);
                
                //Si no hay destinos, se comparte en espacio de usuario logueado
                if(UsuariosDestino.isEmpty())
                {
                    System.out.println("Sin destinos asignados, se comparte en espacio de usuario logueado.\n");
                    int IndiceUsuarioLogueado = this.getUsuarioViaUsername(this.UsuarioLogueado);
                    
                    //Se instancia publicacion compartida
                    PublicacionCompartida CompartidoLogueado = new PublicacionCompartida(this.ListaUsuarios.get(IndiceUsuarioPublicacion).PublicacionesUsuario.get(IndicePublicacion), IdPublicacion, FechaDeHoy(), this.UsuarioLogueado, this.UsuarioLogueado);
                    
                    //Se agrega publicacion compartida a espacio usuario destino actual
                    this.ListaUsuarios.get(IndiceUsuarioLogueado).PublicacionesCompartidas.add(CompartidoLogueado);
                    
                    //Muestra de resultado
                    System.out.println("Post compartido en espacio propio exitosamente!\nInformacion de la publicacion compartida: "+CompartidoLogueado.PublicacionAString());
                }
                
                //Caso contrario, se crea ciclo para compartir post a todos los destinos
                else
                {
                    UsuariosDestino.stream().map(UsuariosDestinoActual -> {
                        System.out.println("Usuario actual: "+UsuariosDestinoActual+"...\n");
                        return UsuariosDestinoActual;                        
                        }).forEachOrdered(UsuariosDestinoActual -> {
                        
                        //Se recupera indice usuario destino actual
                        int IndiceUsuarioActual = this.getUsuarioViaUsername(UsuariosDestinoActual);
                        
                        //Se instancia publicacion compartida
                        PublicacionCompartida CompartidaUsuarioActual = new PublicacionCompartida(this.ListaUsuarios.get(IndiceUsuarioPublicacion).PublicacionesUsuario.get(IndicePublicacion), IdPublicacion, FechaDeHoy(), this.UsuarioLogueado, UsuariosDestinoActual);
                        
                        //Se agrega publicacion compartida a espacio usuario destino actual
                        this.ListaUsuarios.get(IndiceUsuarioActual).PublicacionesCompartidas.add(CompartidaUsuarioActual);
                        
                        //Mensaje de publicacion compartida de forma exitosa
                        System.out.println("Post compartido a "+UsuariosDestinoActual+" Exitosamente!\nInformacion de la publicacion compartida: "+ CompartidaUsuarioActual.PublicacionAString());
                    });
                }
            }
            
            //Caso contrario, no es posible compartir, se advierte de esto por consola/terminal
            else
            {System.out.println("Error: Usuario(s) ingresado(s) en destinatarios no es(son) contactos del usuario logueado.\n");}
        }
        else //No se encontro usuario que creo publicacion con ese ID
        {System.out.println("Error: Publicacion con ese ID no existe.\n");}
    }
    
    /**
     * Requerimiento funcional Visualize, transforma el contenido de la red social a un gran string, para luego mostrarlo por consola/terminal.
     * El contenido presentado se filtrara en caso de haber usuario con sesion iniciada, mostrando solo la actividad relacionada a este.
     */
    @Override
    public void Visualize()
    {PrintSocialNetwork(SocialNetworkToString());}
    
    /**
     * Requerimiento funcional optativo Comment, el usuario con sesion iniciada realiza un comentario en la red social, y este puede ser dirigido a una publicacion o como respuesta a otro comentario.
     * @param IdPublicacion ID publicacion a comentar
     * @param IdComentario ID comentario a responder dentro de la publicacion apuntada (0 si se desea comentar la publicacion)
     * @param ContenidoComentario Contenido (cuerpo) del comentario
     */
    @Override
    public void Comment(int IdPublicacion, int IdComentario, String ContenidoComentario)
    {
        //Revisar si el comentario va hacia una publicacion compartida o una publicacion original (referenciar indice)
        int IndiceUsuarioPublicacionOr = ReferenciarUsuarioPublicacionOr(IdPublicacion);
        int IndiceUsuarioPublicacionComp = ReferenciarUsuarioPublicacionComp(IdPublicacion);
        
        // Resultado distinto de -1, el ID pertenece a una publicacion original
        if(IndiceUsuarioPublicacionOr > -1)
        {
            //Se recupera posicion de la publicacion a agregar comentario
            int IndicePublicacionApuntada = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).getPublicacionOriginalPorId(IdPublicacion);
            
            //Revisar caso si es comentario a publicacion o a otro comentario
            if(IdComentario == 0) //Se comenta publicacion
            {
                //Se crea comentario
                Comentario NuevoComentario = new Comentario(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Comentario", ContenidoComentario);
                
                //Se agrega comentario al espacio de comentarios de la publicacion
                this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.add(NuevoComentario);
                
                //Se muestra resultado por consola
                System.out.println("Comentario realizado exitosamente!\nInformacion del comentario: "+NuevoComentario.ReaccionAString());
                
            }
            else //Buscar comentario a responder
            {
                //Verificar si existe comentario en publicacion
                int IndiceComentario = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).getComentarioViaIdReaccion(IdComentario);
                if(IndiceComentario > -1)
                {
                    //Obtener usuario que realizo comentario para mencionar en comentario a crear
                    String UsuarioAMencionar = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.get(IndiceComentario).getAutorReaccion();
                    
                    //Instanciar comentario
                    Comentario NuevoComentario = new Comentario(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Comentario", "@"+UsuarioAMencionar+ " "+ContenidoComentario);
                    
                    //Agregar comentario en espacio respectivo
                    this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.add(NuevoComentario);
                    
                    //Se muestra resultado por consola
                    System.out.println("Comentario realizado exitosamente!\nInformacion del comentario: "+NuevoComentario.ReaccionAString());
                    
                }
                else //No existe comentario con ese ID en la publicacion, se muestra mensaje por consola
                {
                    System.out.println("Error: No existe comentario con ese ID dentro de la publicacion seleccionada.\n");
                }
            }
        }
        
        // Resultado distinto de -1, el ID pertenece a una publicacion compartida
        else if(IndiceUsuarioPublicacionComp > -1)
        {
            //Se recupera posicion de la publicacion a agregar comentario
            int IndicePublicacionApuntada = this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).getPublicacionCompartidaPorId(IdPublicacion);
            
            //Revisar caso si es comentario a publicacion o a otro comentario
            if(IdComentario == 0) //Se comenta publicacion
            {
                //Se crea comentario
                Comentario NuevoComentario = new Comentario(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Comentario", ContenidoComentario);
                
                //Se agrega comentario al espacio de comentarios de la publicacion compartida
                this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).ComentariosPublicacionComp.add(NuevoComentario);
                
                //Se muestra resultado por consola
                System.out.println("Comentario realizado exitosamente!\nInformacion del comentario: "+NuevoComentario.ReaccionAString()); 
                
            }
            else //Buscar comentario a responder
            {
                //Verificar si existe comentario en publicacion
                int IndiceComentario = this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).getComentarioViaIdReaccion(IdComentario);
                if(IndiceComentario > -1)
                {
                    //Obtener usuario que realizo comentario para mencionar en comentario a crear como respuesta
                    String UsuarioAMencionar = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.get(IndiceComentario).getAutorReaccion();
                    
                    //Instanciar comentario
                    Comentario NuevoComentario = new Comentario(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Comentario", "@"+UsuarioAMencionar+ " "+ContenidoComentario);
                    
                    //Agregar comentario en espacio respectivo
                    this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).ComentariosPublicacionComp.add(NuevoComentario);
                    
                    //Se muestra resultado por consola
                    System.out.println("Comentario realizado exitosamente!\nInformacion del comentario: "+NuevoComentario.ReaccionAString());
                    
                }
                else //No existe comentario con ese ID en la publicacion, se muestra mensaje por consola
                {
                    System.out.println("Error: No existe comentario con ese ID dentro de la publicacion seleccionada.\n");
                }
            }
        }
        // No existe publicacion con ese ID
        else
        {System.out.println("Error: No existe publicacion con ese ID.\n");}
    }
    
    /**
     *  Requerimiento funcional optativo Like, el usuario con sesion iniciada realiza un "Me gusta", ya sea a una publicacion o un comentario.
     * @param IdPublicacion ID publicacion a dar like
     * @param IdComentario ID comentario a dar like (0 para dar like a publicacion)
     */
    @Override
    public void Like(int IdPublicacion, int IdComentario)
    {
        //Revisar si el like va hacia una publicacion compartida o una publicacion original (referenciar indice)
        int IndiceUsuarioPublicacionOr = ReferenciarUsuarioPublicacionOr(IdPublicacion);
        int IndiceUsuarioPublicacionComp = ReferenciarUsuarioPublicacionComp(IdPublicacion);
        
        // Resultado distinto de -1, el ID pertenece a una publicacion original
        if(IndiceUsuarioPublicacionOr > -1)
        {
            //Se recupera posicion de la publicacion a agregar like
            int IndicePublicacionApuntada = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).getPublicacionOriginalPorId(IdPublicacion);
            
            //Revisar caso si es like a publicacion o a otro comentario (y que el like en tal instancia no exista por parte del usuario)
            if(IdComentario == 0) //Se comenta publicacion
            {
                //Se instancia like
                Like NuevoLike = new Like(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Like");
                
                //Se agrega comentario al espacio de comentarios de la publicacion
                this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).LikesPublicacionOr.add(NuevoLike);
                
                //Se muestra resultado por consola
                System.out.println("Like realizado exitosamente!\nInformacion del like: "+NuevoLike.ReaccionAString());
                
            }
            else //Buscar comentario a responder
            {
                //Verificar si existe comentario en publicacion
                int IndiceComentario = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).getComentarioViaIdReaccion(IdComentario);
                if(IndiceComentario > -1)
                {
                    
                    //Se instancia like
                    Like NuevoLike = new Like(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Like");
                    
                    //Se agregaa like en espacio de likes del comentario
                    this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.get(IndiceComentario).LikesComentario.add(NuevoLike);
                    
                    //Se muestra resultado por consola
                    System.out.println("Like realizado exitosamente!\nInformacion del like: "+NuevoLike.ReaccionAString());
                    
                }
                else //No existe comentario con ese ID en la publicacion, se muestra mensaje por consola
                {
                    System.out.println("Error: No existe comentario con ese ID dentro de la publicacion seleccionada.\n");
                }
            }
        }
        
        // Resultado distinto de -1, el ID pertenece a una publicacion compartida
        else if(IndiceUsuarioPublicacionComp > -1)
        {
            //Se recupera posicion de la publicacion a agregar comentario
            int IndicePublicacionApuntada = this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).getPublicacionCompartidaPorId(IdPublicacion);
            
            //Revisar caso si es comentario a publicacion o a otro comentario (y que el like en tal instancia no exista por parte del usuario)
            if(IdComentario == 0) //Se comenta publicacion
            {
                //Se instancia like
                Like NuevoLike = new Like(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Like");
                
                //Se agrega comentario al espacio de comentarios de la publicacion
                this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).LikesPublicacionComp.add(NuevoLike);
                
                //Se muestra resultado por consola
                System.out.println("Like realizado exitosamente!\nInformacion del like: "+NuevoLike.ReaccionAString());
                   
            }
            else //Buscar comentario a responder
            {
                //Verificar si existe comentario en publicacion
                int IndiceComentario = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).getComentarioViaIdReaccion(IdComentario);
                if(IndiceComentario > -1)
                {
                    
                    //Se instancia like
                    Like NuevoLike = new Like(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Like");
                    
                    
                    //Agregar comentario en espacio respectivo
                    this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).ComentariosPublicacionComp.get(IndiceComentario).LikesComentario.add(NuevoLike);
                    
                    //Se muestra resultado por consola
                    System.out.println("Like realizado exitosamente!\nInformacion del like: "+NuevoLike.ReaccionAString());
                    
                }
                else //No existe comentario con ese ID en la publicacion, se muestra mensaje por consola
                {
                    System.out.println("Error: No existe comentario con ese ID dentro de la publicacion seleccionada.\n");
                }
            }
        }
        // No existe publicacion con ese ID
        else
        {System.out.println("Error: No existe publicacion con ese ID.\n");}
    }
    

    /**
     * Metodo que cargara actividad previa a la ejecucion, para cubrir exigencia de menu interactivo.
     */

    @Override
    public void CargarActividadPrevia()
    {
        /*
        ACTIVIDAD MINIMA EXIGIDA:
        - 5 USUARIOS REGISTRADOS
        - 10 PUBLICACIONES
        - 3 FOLLOW
        - 1 FOLLOW MUTUO
        */
        
        System.out.println("Se genera actividad previa: \n");
        
        ArrayList<String> ListaVacia = new ArrayList<>();
        ArrayList<String> ListaDestinos1 = new ArrayList<>();
        ArrayList<String> ListaDestinos2 = new ArrayList<>();
        ArrayList<String> ListaDestinos3 = new ArrayList<>();
        
        Register("a","b");
        Register("c","d");
        Register("e","f");
        Register("g","h");
        Register("i","j");
        
        Login("a","b");
        Post("Texto", "Post de prueba", ListaVacia);
        Follow("c");
        ListaDestinos1.add("c");
        Post("Texto", "Post para mi amigo c.", ListaDestinos1);
        Follow("e");
        ListaDestinos1.add("e");
        Post("Texto", "Post para mis panas c y e.", ListaDestinos1);
        Follow("g");
        ListaDestinos2.add("g");
        Follow("i");
        ListaDestinos2.add("i");
        Post("Texto", "Post para los nuevos usuarios: g i.", ListaDestinos2);
        Logout();
        
        Login("c","d");
        Follow("a");
        ListaDestinos3.add("a");
        Post("Texto", "Solo vine por mi pana a.", ListaDestinos3);
        Post("Texto", "Aun asi, me quedare un tiempo aca...", ListaVacia);
        Logout();
        
        Login("e","f");
        Post("Texto", "Mmm...", ListaVacia);
        Logout();
        
        Login("g","h");
        Post("Texto", "No estoy convencido, esto necesita mejoras urgentes...", ListaVacia);
        Logout();
        
        Login("i", "j");
        Post("Texto", "A veces un companiero al lado aporta ideas que en el momento uno no ve, sumado a la obra de mano, donde faltan manos para cubrir todas las obligaciones...", ListaVacia);
        Follow("a");
        Post("Texto", "Compa a, Puedes echarme una mano con esto? pls", ListaDestinos3);
        Logout();
    }
}
