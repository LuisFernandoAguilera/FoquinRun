package mx.itesm.foquinrun;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Administra la escena que se verá en la pantalla
 */
public class AdministradorEscenas
{
    // Instancia única
    private static final AdministradorEscenas INSTANCE =
            new AdministradorEscenas();
    protected ControlJuego actividadJuego;

    // Declara las distintas escenas que forman el juego
    private EscenaBase escenaSplash;
    private EscenaBase escenaMenu;
    private EscenaBase escenaAcercaDe;

    private EscenaBase escenaPantalla;

    private EscenaBase escenaJuego;
    private EscenaBase escenaAnimacionHistoria;
    private EscenaBase escenaCreditos;
    private EscenaBase escenaEspera;

    // El tipo de escena que se está mostrando
    private TipoEscena tipoEscenaActual = TipoEscena.ESCENA_SPLASH;
    // La escena que se está mostrando
    private EscenaBase escenaActual;
    // El engine para hacer el cambio de escenas
    private Engine engine;

    // Asigna valores iniciales del administrador
    public static void inicializarAdministrador(ControlJuego actividadJuego, Engine engine) {
        getInstance().actividadJuego = actividadJuego;
        getInstance().engine = engine;
    }

    // Regresa la instancia del administrador de escenas
    public static AdministradorEscenas getInstance() {
        return INSTANCE;
    }

    // Regresa el tipo de la escena actual
    public TipoEscena getTipoEscenaActual() {
        return tipoEscenaActual;
    }

    // Regresa la escena actual
    public EscenaBase getEscenaActual() {
        return escenaActual;
    }

    /*
     * Pone en la pantalla la escena que llega como parámetro y guarda el nuevo estado
     */
    private void setEscenaBase(EscenaBase nueva) {
        engine.setScene(nueva);
        escenaActual = nueva;
        tipoEscenaActual = nueva.getTipoEscena();
    }

    /**
     * Cambia a la escena especificada en el parámetro
     * @param nuevoTipo la nueva escena que se quiere mostrar
     */
    public void setEscena(TipoEscena nuevoTipo) {
        switch (nuevoTipo) {
            case ESCENA_SPLASH:
                setEscenaBase(escenaSplash);
                break;
            case ESCENA_MENU:
                setEscenaBase(escenaMenu);
                break;
            case ESCENA_ACERCA_DE:
                setEscenaBase(escenaAcercaDe);
                break;

            case ESCENA_PANTALLA:
                setEscenaBase(escenaPantalla);
                break;

            case ESCENA_JUEGO:
                setEscenaBase(escenaJuego);
                break;
            case ESCENA_ANIMACIONHISTORIA:
                setEscenaBase(escenaAnimacionHistoria);
                break;
            case ESCENA_CREDITOS:
                setEscenaBase(escenaCreditos);
                break;
            case ESCENA_ESPERA:
            setEscenaBase(escenaEspera);

        }
    }

    //*** Crea la escena de Splash
    public void crearEscenaSplash() {
        // Carga los recursos
        escenaSplash = new EscenaSplash();
    }

    //*** Libera la escena de Splash
    public void liberarEscenaSplash() {
        escenaSplash.liberarEscena();
        escenaSplash = null;
    }

    // ** MENU
    //*** Crea la escena de MENU
    public void crearEscenaMenu() {
        // Carga los recursos
        escenaMenu = new EscenaMenu();
    }

    //*** Libera la escena de MENU
    public void liberarEscenaMenu() {
        escenaMenu.liberarEscena();
        escenaMenu = null;
    }

    //*** Crea la escena de Acerca De
    public void crearEscenaAcercaDe() {
        // Carga los recursos
        escenaAcercaDe = new EscenaAcercaDe();
    }

    //*** Libera la escena de AcercDe
    public void liberarEscenaAcercaDe() {
        escenaAcercaDe.liberarEscena();
        escenaAcercaDe = null;
    }



    public void crearEscenaPantalla(){
        escenaPantalla= new Pantalla();
    }


    public void liberarEscenaPantalla(){
        escenaPantalla.liberarEscena();
        escenaPantalla=null;
    }

    public void crearEscenaJuego(){
        escenaJuego=new EscenaJuego();
    }

    public void liberarEscenaJuego(){
        escenaJuego.liberarEscena();
        escenaJuego=null;
    }

    public void crearEscenaAnimacionHistoria(){
        escenaAnimacionHistoria=new AnimacionHistoria();
    }
    public void liberarEscenaAnimacionHistoria(){
        escenaAnimacionHistoria.liberarEscena();
        escenaAnimacionHistoria=null;
    }

    public void crearEscenaCreditos(){
        escenaCreditos = new Creditos();
    }
    public void liberarEscenaCreditos(){
        escenaCreditos.liberarEscena();
        escenaCreditos=null;
    }

    public void crearEscenaEspera(){
        escenaEspera = new Espera();
    }
    public void liberarEscenaEspera(){
        escenaEspera.liberarEscena();
        escenaEspera=null;
    }
/*
    //*** Crea la escena de JUEGO
    public void crearEscenaJuego() {
        // Carga los recursos
        admRecursos.cargarRecursosJuego();
        //escenaJuego = new EscenaJuego();
    }

    //*** Libera la escena de JUEGO
    public void liberarEscenaJuego() {
        admRecursos.liberarRecursosJuego();
        escenaJuego.liberarEscena();
        escenaJuego = null;
    }

    //*** Crea la escena de Juego Dos
    public void crearEscenaJuegoDos() {
        // Carga los recursos
        admRecursos.cargarRecursosJuegoDos();
        //escenaJuegoDos = new EscenaJuegoDos();
    }

    //*** Libera la escena de Juego Dos
    public void liberarEscenaJuegoDos() {
        admRecursos.liberarRecursosJuegoDos();
        escenaJuegoDos.liberarEscena();
        escenaJuegoDos = null;
    }
*/
}
