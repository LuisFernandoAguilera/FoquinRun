package mx.itesm.foquinrun;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.util.GLState;

/**
 * Representa la escena del MENU PRINCIPAL
 *
 * @author Roberto Martínez Román
 */
public class EscenaMenu extends EscenaBase
{
    // Regiones para las imágenes de la escena
    private ITextureRegion regionFondo;
    private ITextureRegion regionFondoLuz;

    private ITextureRegion regionBtnAcercaDe;
    private ITextureRegion regionBtnJugar;
    private ITextureRegion regionBtnBoton;

    private ITextureRegion regionBtnAcercaDeLuz;
    private ITextureRegion regionBtnJugarLuz;
    private ITextureRegion regionBtnBotonLuz;

    private Sprite spriteBtnAcercaDeLuz;
    private Sprite spriteBtnJugareLuz;
    private Sprite spriteBtnBotonLuz;

    private Sprite spriteFondo;
    private Sprite spriteFondoLuz;


    private MenuScene menu;

    private final int OPCION_ACERCA_DE = 0;
    private final int OPCION_JUGAR = 1;
    private final int OPCION_BOTON=2;


    private ButtonSprite btnAcercaDe;
    private ButtonSprite btnJugar;
    private ButtonSprite btnBoton;

    @Override
    public void cargarRecursos() {

        regionFondo = cargarImagen("Menu/fondo objeto.png");
        regionFondoLuz= cargarImagen("Menu/luz letras y cable.png");


        regionBtnAcercaDe = cargarImagen("Menu/opciones boton.png");
        regionBtnJugar = cargarImagen("Menu/play boton.png");
        regionBtnBoton= cargarImagen("Menu/mapa boton.png");

        regionBtnAcercaDeLuz= cargarImagen("Menu/luz opciones boton.png");
        regionBtnJugarLuz= cargarImagen("Menu/luz play boton.png");
        regionBtnBotonLuz= cargarImagen("Menu/luz mapa boton.png");

    }

    @Override
    public void crearEscena() {
        spriteFondoLuz=cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondoLuz);
        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);

        attachChild(spriteFondoLuz);

        SpriteBackground fondo = new SpriteBackground(1,1,1,spriteFondo);
        setBackground(fondo);
        setBackgroundEnabled(true);

        spriteBtnJugareLuz=cargarSprite(ControlJuego.ANCHO_CAMARA/2-400,ControlJuego.ALTO_CAMARA/2-300,regionBtnJugarLuz);
        attachChild(spriteBtnJugareLuz);
        spriteBtnBotonLuz=cargarSprite(ControlJuego.ANCHO_CAMARA/2+0,ControlJuego.ALTO_CAMARA/2-300,regionBtnBotonLuz);
        attachChild(spriteBtnBotonLuz);
        spriteBtnAcercaDeLuz=cargarSprite(ControlJuego.ANCHO_CAMARA/2+300,ControlJuego.ALTO_CAMARA/2-300,regionBtnAcercaDeLuz);
        attachChild(spriteBtnAcercaDeLuz);

        agregarMenu();
    }


    private void agregarMenu() {
        // Crea el objeto que representa el menú
        menu = new MenuScene(actividadJuego.camara);
        // Centrado en la pantalla
        menu.setPosition(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2);
        // Crea las opciones (por ahora, acerca de y jugar)
        IMenuItem opcionAcercaDe = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_ACERCA_DE,
                regionBtnAcercaDe, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionJugar = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_JUGAR,
                regionBtnJugar, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);

        IMenuItem opcionBoton= new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_BOTON,
                regionBtnBoton,actividadJuego.getVertexBufferObjectManager()),1.5f,1);


        // Agrega las opciones al menú
        menu.addMenuItem(opcionAcercaDe);
        menu.addMenuItem(opcionJugar);

        menu.addMenuItem(opcionBoton);

        // Termina la configuración
        menu.buildAnimations();
        menu.setBackgroundEnabled(false);   // Completamente transparente

        opcionJugar.setPosition(-400, -300);
        opcionBoton.setPosition(0,-300);
        opcionAcercaDe.setPosition(300, -300);


        // Registra el Listener para atender las opciones
        menu.setOnMenuItemClickListener(new MenuScene.IOnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
                                             float pMenuItemLocalX, float pMenuItemLocalY) {
                // El parámetro pMenuItem indica la opción oprimida
                switch(pMenuItem.getID()) {
                    case OPCION_ACERCA_DE:
                        // Mostrar la escena de AcercaDe
                        admEscenas.crearEscenaAcercaDe();
                        admEscenas.setEscena(TipoEscena.ESCENA_ACERCA_DE);
                        admEscenas.liberarEscenaMenu();
                        break;

                    case OPCION_JUGAR:

                        admEscenas.crearEscenaJuego();
                        admEscenas.setEscena(TipoEscena.ESCENA_JUEGO);
                        admEscenas.liberarEscenaMenu();
                        break;

                    case OPCION_BOTON:
                        admEscenas.crearEscenaPantalla();
                        admEscenas.setEscena(TipoEscena.ESCENA_PANTALLA);
                        admEscenas.liberarEscenaMenu();
                        break;

                }
                return true;
            }
        });

        // Asigna este menú a la escena
        setChildScene(menu);
    }

    // La escena se debe actualizar en este método que se repite "varias" veces por segundo
    // Aquí es donde programan TODA la acción de la escena (movimientos, choques, disparos, etc.)
    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);

    }


    @Override
    public void onBackKeyPressed() {
        // Salir del juego, no hacemos nada
    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_MENU;
    }

    @Override
    public void liberarEscena() {
        this.detachSelf();      // La escena se deconecta del engine
        this.dispose();         // Libera la memoria
        liberarRecursos();
    }

    @Override
    public void liberarRecursos() {
        regionFondo.getTexture().unload();
        regionFondo = null;
    }
}
