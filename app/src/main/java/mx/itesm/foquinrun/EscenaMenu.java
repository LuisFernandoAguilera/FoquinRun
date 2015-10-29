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

    private ITextureRegion regionFondo;


    private ITextureRegion regionBtnAcercaDe;
    private ITextureRegion regionBtnJugar;
    private ITextureRegion regionBtnBoton;


    private Sprite spriteFondo;


    private MenuScene menu;

    private final int OPCION_ACERCA_DE = 0;
    private final int OPCION_JUGAR = 1;
    private final int OPCION_BOTON=2;


    @Override
    public void cargarRecursos() {

        regionFondo = cargarImagen("Menu/Inicio_Neon_sin_botones.png");


        regionBtnAcercaDe = cargarImagen("Menu/Opciones.png");
        regionBtnJugar = cargarImagen("Menu/Play.png");
        regionBtnBoton= cargarImagen("Menu/Menu.png");


    }

    @Override
    public void crearEscena() {
        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);

        SpriteBackground fondo = new SpriteBackground(1,1,1,spriteFondo);
        setBackground(fondo);
        setBackgroundEnabled(true);

        agregarMenu();
    }


    private void agregarMenu() {

        menu = new MenuScene(actividadJuego.camara);
        menu.setPosition(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2);

        IMenuItem opcionAcercaDe = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_ACERCA_DE,
                regionBtnAcercaDe, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionJugar = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_JUGAR,
                regionBtnJugar, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);

        IMenuItem opcionBoton= new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_BOTON,
                regionBtnBoton,actividadJuego.getVertexBufferObjectManager()),1.5f,1);


        menu.addMenuItem(opcionAcercaDe);
        menu.addMenuItem(opcionJugar);
        menu.addMenuItem(opcionBoton);


        menu.buildAnimations();
        menu.setBackgroundEnabled(false);

        opcionJugar.setPosition(-150, -300);
        opcionBoton.setPosition(120,-300);
        opcionAcercaDe.setPosition(400, -300);



        menu.setOnMenuItemClickListener(new MenuScene.IOnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
                                             float pMenuItemLocalX, float pMenuItemLocalY) {

                switch(pMenuItem.getID()) {
                    case OPCION_ACERCA_DE:

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


        setChildScene(menu);
    }


    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);

    }


    @Override
    public void onBackKeyPressed() {
    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_MENU;
    }

    @Override
    public void liberarEscena() {
        this.detachSelf();
        this.dispose();
        liberarRecursos();
    }

    @Override
    public void liberarRecursos() {
        regionFondo.getTexture().unload();
        regionFondo = null;
    }
}
