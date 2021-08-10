/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesAbstraidas;

import Interfaz.RedSocial;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica dentro del programa.
 * Aca se encontraran los atributos basicos de una red social y los metodos necesarios para poder interactuar en ella.
 * Requerimientos funcionales cubiertos en este archivo.
 * @version 1.3, 07/08/2021
 * @author Eduardo Abarca
 */
public class RedSocialGenerica implements RedSocial
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final String NombreRedSocial;
    private final String FechaRegistroRedSocial;
    private final ArrayList<Usuario> ListaUsuarios;
    private String UsuarioLogueado;
    private boolean ProgramaEnUso;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */
    public RedSocialGenerica(String NombreAsignado)
    {
        this.NombreRedSocial = NombreAsignado;
        this.FechaRegistroRedSocial = FechaDeHoy();
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
    
    public ArrayList<Usuario> getUsuarios()
    {return this.ListaUsuarios;}
    
    /* SETTERS */
    @Override 
    public void IniciarPrograma()
    {this.ProgramaEnUso = true;}
    
    @Override
    public void FinalizarPrograma()
    {
        System.out.println("\nSee ya soon!");
        this.ProgramaEnUso = false;
    }
    
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
    /*
    public String Fecha(int Dia, int Mes, int Anio)
    {
        //String a retornar
        String FechaRetorno;
        
        //Boolean para controlar retorno
        boolean PruebasPasadas = true;
        
        //Serie de pruebas:
        //Dominio dias: Entre 1 y 31 (Varia entre mes, a verificar mas adelante)
        if(Dia < 1 || Dia > 31)
        {PruebasPasadas = false;}
        
        //Dominio meses: Entre 1 y 12
        if(Mes < 1 || Mes > 12)
        {PruebasPasadas = false;}
        
        //Dominio anios: Entre 1995 y 2021
        if(Anio < 1995 || Anio > 2021)
        {PruebasPasadas = false;}
        
        //Dominio febrero: 28 dias (anio normal) / 29 dias (anio bisiesto)
        if((Mes == 2 && Anio%4 != 0 && !(Dia <= 28)) || (Mes == 2 && Anio%4 == 0 && !(Dia <= 29)))
        {PruebasPasadas = false;}
        
        //Dominio meses 4, 6, 7, 9 y 11: 30 dias
        if(Mes == 4 || Mes == 6 || Mes == 7 || Mes == 9 || Mes == 11 && !(Dia <= 30))
        {PruebasPasadas = false;}
        
        //Dominio resto meses: 31 dias -> cubierto por primera prueba
        //Fin pruebas, verificar retorno:
        
        //Pruebas pasadas, se retorna los parametros de entrada convertidos y formateados
        if(PruebasPasadas)
        {FechaRetorno = Integer.toString(Dia)+"/"+Integer.toString(Mes)+"/"+Integer.toString(Anio);}
        
        //Caso contrario, se llama a metodo que genera la fecha de ejecucion del programa por defecto
        else
        {FechaRetorno = FechaDeHoy();}
        
        //Retorno string
        return FechaRetorno;
    }*/
    
    @Override
    public boolean ValidarDatosRegistro(String Usuario, String Contrasenia)
    {
        System.out.println("\nVerificando datos a registrar...");
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
                    break;
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
    public int getUsuarioViaUsername(String NombreUsuario)
    {
        int IndiceUsuarioRetorno = -1;
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(NombreUsuario))
            {
                IndiceUsuarioRetorno = i;
                break;
            }
        }
        return IndiceUsuarioRetorno;
    }
    
    public int ReferenciarUsuarioPublicacionOr(int id)
    {
        int IndiceUsuario = -1;
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            if(this.ListaUsuarios.get(i).getPublicacionOriginalPorId(id) != -1)
            {
                IndiceUsuario = i;
                break;
            }
        }
        return IndiceUsuario;
    }
    
    public int ReferenciarUsuarioPublicacionComp(int id)
    {
        int IndiceUsuario = -1;
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            if(this.ListaUsuarios.get(i).getPublicacionCompartidaPorId(id) != -1)
            {
                IndiceUsuario = i;
                break;
            }
        }
        return IndiceUsuario;
    }
    
    public int CantidadUsuariosRegistrados()
    {return this.ListaUsuarios.size();}
    
    @Override
    public boolean ValidarDestinos(ArrayList<String> ListaUsuariosDestino)
    {
        return this.ListaUsuarios.get(getUsuarioViaUsername(this.UsuarioLogueado)).EstanDestinosEnContactos(ListaUsuariosDestino);
    }
    

    @Override
    public String SocialNetworkToString()
    {
        String StringRedSocial = "INFORMACION RED SOCIAL:\n\nNombre red social: "+this.getNombreRedSocial()+"\nFecha registro red social: "+this.getFechaRegistroRedSocial()+"\n\n";
        if(this.UsuarioLogueado == null)
        {
            StringRedSocial += "INFORMACION USUARIOS REGISTRADOS:\n\n";
            if(this.ListaUsuarios.isEmpty())
            {StringRedSocial += "SIN USUARIO REGISTRADOS.\n\n";}
            else
            {
                for(int i = 0; i < this.ListaUsuarios.size(); i++)
                {StringRedSocial += this.ListaUsuarios.get(i).UsuarioAString();}
            }
        }
        else
        {
            int IndiceUsuarioLogueado = this.getUsuarioViaUsername(this.UsuarioLogueado);
            StringRedSocial += "INFORMACION USUARIO LOGUEADO:\n\n"+this.ListaUsuarios.get(IndiceUsuarioLogueado).UsuarioAString();
        }
        
        return StringRedSocial;
    }

    @Override
    public void PrintSocialNetwork(String StringConvertido)
    {
        System.out.println(StringConvertido+"\nFIN DATOS RED SOCIAL.\n\n");
    }
    
    /* /////////////////////////////////////////// REQUERIMIENTOS FUNCIONALES /////////////////////////////////////////// */
    
    @Override
    public void Register(String UsuarioARegistrar, String ContraseniaARegistrar)
    {
        if(ValidarDatosRegistro(UsuarioARegistrar, ContraseniaARegistrar))
        {
            Usuario NuevoUsuario = new Usuario(UsuarioARegistrar, ContraseniaARegistrar);
            this.ListaUsuarios.add(NuevoUsuario);
            System.out.println("Usuario registrado exitosamente!\nInformacion usuario registrado: "+NuevoUsuario.UsuarioAString());
        }
        else
        {System.out.println("Error: Nombre de usuario ya esta en uso.\n");}
    }
    
    @Override
    public void Login(String UsuarioLogin, String ContraseniaLogin)
    {
        if(ValidarCredenciales(UsuarioLogin, ContraseniaLogin))
        {
            AsignarUsuarioLogueado(UsuarioLogin);
            System.out.println("Sesion iniciada exitosamente!\n");
        }
        else
        {System.out.println("Error de credenciales.\n");}
    }
    
    @Override
    public void Logout()
    {ExpulsarUsuarioLogueado();}
    
    @Override
    public void Post(String TipoPublicacion, String ContenidoPublicacion, ArrayList<String> UsuariosDestino)
    {
        if(UsuariosDestino.isEmpty())
        {
            System.out.println("Post no tendra destinos.\n");
            
            //Crear publicacion
            PublicacionOriginal NuevaPublicacion = new PublicacionOriginal(FechaDeHoy(), this.UsuarioLogueado, TipoPublicacion, ContenidoPublicacion, UsuariosDestino);
            
            //Referenciar indice usuario logueado 
            int IndiceUsuarioLogueado = getUsuarioViaUsername(this.UsuarioLogueado);
            
            //Agregar publicacion a espacio usuario logueado
            this.ListaUsuarios.get(IndiceUsuarioLogueado).PublicacionesUsuario.add(NuevaPublicacion);
                
            //Muestra de la nueva publicacion por consola
            System.out.println("Post creado exitosamente!\nInformacion del post: "+NuevaPublicacion.PublicacionAString());
        }
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
            else
            {System.out.println("Error: Usuario(s) ingresado(s) en destinatarios no es(son) contactos del usuario logueado.\n");}
        }
    }
    
    @Override
    public void Follow(String UsuarioApuntado)
    {
        int IndiceUsuarioApuntado = getUsuarioViaUsername(UsuarioApuntado);
        int IndiceUsuarioLogueado = getUsuarioViaUsername(this.UsuarioLogueado); //Al llegar a este metodo, si o si hay usuario logueado, por lo que su indice de retorno jamas sera -1
        if(IndiceUsuarioApuntado == -1) //Error
        {System.out.println("Error: Usuario a seguir no existe.\n");}
        else
        {
            if(this.ListaUsuarios.get(IndiceUsuarioLogueado).EstaEnSeguidos(UsuarioApuntado)) //Error
            {System.out.println("Error: Usuario a seguir ya esta seguido.\n");}
            else if (IndiceUsuarioApuntado == IndiceUsuarioLogueado) //Error
            {System.out.println("Error: Usuario ingresado es usuario logueado.\n");}
            else //Se cumplen condiciones, se sigue usuario apuntado
            {
                this.ListaUsuarios.get(IndiceUsuarioApuntado).AgregarSeguidor(this.UsuarioLogueado);
                this.ListaUsuarios.get(IndiceUsuarioLogueado).AgregarSeguimiento(UsuarioApuntado);
                System.out.println("Usuario seguido exitosamente!\nInformacion usuario logueado: "+this.ListaUsuarios.get(IndiceUsuarioLogueado).UsuarioAString()+"\nInformacion usuario seguido: "+this.ListaUsuarios.get(IndiceUsuarioApuntado).UsuarioAString());
            }
        }
    }
    
    //Se puede compartir solo publicaciones originales
    @Override
    public void Share(int IdPublicacion, ArrayList<String> UsuariosDestino)
    {
        int IndiceUsuarioPublicacion = this.ReferenciarUsuarioPublicacionOr(IdPublicacion);
        int IndicePublicacion;
        if(IndiceUsuarioPublicacion > -1)
        {
            if(ValidarDestinos(UsuariosDestino))
            {
                System.out.println("Destinos son validos, se procede a compartir el post...\n");
                
                //Se recupera indice publicacion a compartir
                IndicePublicacion = this.ListaUsuarios.get(IndiceUsuarioPublicacion).getPublicacionOriginalPorId(IdPublicacion);
                
                //Se crea ciclo para crear pregunta a todos los destinos
                if(UsuariosDestino.isEmpty())
                {
                    System.out.println("Sin destinos asignados, se comparte en espacio de usuario logueado.\n");
                    int IndiceUsuarioLogueado = this.getUsuarioViaUsername(this.UsuarioLogueado);
                    
                    PublicacionCompartida CompartidoLogueado = new PublicacionCompartida(this.ListaUsuarios.get(IndiceUsuarioPublicacion).getPublicaciones().get(IndicePublicacion), IdPublicacion, FechaDeHoy(), this.UsuarioLogueado, this.UsuarioLogueado);
                    
                    //Se agrega publicacion compartida a espacio usuario destino actual
                    this.ListaUsuarios.get(IndiceUsuarioLogueado).PublicacionesCompartidas.add(CompartidoLogueado);
                    
                    //Muestra de resultado
                    System.out.println("Post compartido en espacio propio exitosamente!\nInformacion de la publicacion compartida: "+CompartidoLogueado.PublicacionAString());
                }
                else
                {
                    UsuariosDestino.stream().map(UsuariosDestinoActual -> {
                        System.out.println("Usuario actual: "+UsuariosDestinoActual+"...\n");
                        return UsuariosDestinoActual;                        
                        }).forEachOrdered(UsuariosDestinoActual -> {
                        
                        //Se recupera indice usuario destino actual
                        int IndiceUsuarioActual = this.getUsuarioViaUsername(UsuariosDestinoActual);
                        
                        //Se instancia publicacion compartida
                        PublicacionCompartida CompartidaUsuarioActual = new PublicacionCompartida(this.ListaUsuarios.get(IndiceUsuarioPublicacion).getPublicaciones().get(IndicePublicacion), IdPublicacion, FechaDeHoy(), this.UsuarioLogueado, UsuariosDestinoActual);
                        
                        //Se agrega publicacion compartida a espacio usuario destino actual
                        this.ListaUsuarios.get(IndiceUsuarioActual).PublicacionesCompartidas.add(CompartidaUsuarioActual);
                        
                        //Mensaje de publicacion compartida de forma exitosa
                        System.out.println("Post compartido a "+UsuariosDestinoActual+" Exitosamente!\nInformacion de la publicacion compartida: "+ CompartidaUsuarioActual.PublicacionAString());
                    });
                }
            }
            else
            {System.out.println("Error: Usuario(s) ingresado(s) en destinatarios no es(son) contactos del usuario logueado.\n");}
        }
        else //No se encontro usuario que creo publicacion con ese ID
        {System.out.println("Error: Publicacion con ese ID no existe.\n");}
    }
    
    @Override
    public void Visualize()
    {PrintSocialNetwork(SocialNetworkToString());}
    

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
    
    //METODO PARA AGREGAR ACTIVIDAD PREVIA EXIGIDA POR ENUNCIADO

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
        
        /*
        System.out.println("Se genera actividad previa: \n");
        
        Register("a","b");
        Register("c","d");
        Register("e","f");
        Register("g","h");
        Register("i","j");
        
        Login("a","b");
        Post();
        Follow();
        Follow();
        Post();
        Logout();
        
        Login("c","d");
        Follow("a");
        Logout();
        
        Login("e","f");
        
        Logout();
        
        Login("g","h");
        
        Logout();
        
        Login("i", "j");
        Follow("a");
        Logout();
        
        */
    }
}
