package mx.itesm.foquinrun;

import android.view.Menu;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by rmroman on 11/09/15.
 */
public class EscenaAcercaDe extends EscenaBase
{
    // Regiones para imágenes
    private ITextureRegion regionFondo;
    // Sprite para el fondo
    private Sprite spriteFondo;
    private MenuScene menu;

    private ITextureRegion regionHistoria;
    private ITextureRegion regionCreditos;

    private final int OPCION_HISTORIA = 0;
    private final int OPCION_CREDITOS=1;

    @Override
    public void cargarRecursos() {
        regionFondo = cargarImagen("Prueba/Opciones.png");

        regionHistoria= cargarImagen("boton.png");
        regionCreditos = cargarImagen("boton.png");
    }

    @Override
    public void crearEscena() {
        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);
        attachChild(spriteFondo);
        agregarMenu();
    }
    private void agregarMenu() {
        menu = new MenuScene(actividadJuego.camara);
        menu.setPosition(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2);

        IMenuItem opcionHistoria = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_HISTORIA,
                regionHistoria, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionCreditos = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_CREDITOS,
                regionCreditos, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        menu.addMenuItem(opcionHistoria);
        menu.addMenuItem(opcionCreditos);

        menu.buildAnimations();
        menu.setBackgroundEnabled(false);


        opcionHistoria.setPosition(0,50);
        opcionCreditos.setPosition(0, -300);


        menu.setOnMenuItemClickListener(new MenuScene.IOnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
                                             float pMenuItemLocalX, float pMenuItemLocalY) {
                // El parámetro pMenuItem indica la opción oprimida
                switch (pMenuItem.getID()) {


                    case OPCION_HISTORIA:
                        admEscenas.crearEscenaAnimacionHistoria();
                        admEscenas.setEscena(TipoEscena.ESCENA_ANIMACIONHISTORIA);
                        admEscenas.liberarEscenaAcercaDe();
                        break;

                    case OPCION_CREDITOS:
                        //terminar ventanas para agregar
                        admEscenas.crearEscenaCreditos();
                        admEscenas.setEscena(TipoEscena.ESCENA_CREDITOS);
                        admEscenas.liberarEscenaAcercaDe();
                        break;

                }
                return true;
            }
        });
        setChildScene(menu);


    }

    @Override
    public void onBackKeyPressed() {
        // Regresar al menú principal
        admEscenas.crearEscenaMenu();
        admEscenas.setEscena(TipoEscena.ESCENA_MENU);
        admEscenas.liberarEscenaAcercaDe();
    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_ACERCA_DE;
    }

    @Override
    public void liberarEscena() {
        this.detachSelf();
        this.dispose();
    }

    @Override
    public void liberarRecursos() {
        regionFondo.getTexture().unload();
        regionFondo = null;
    }
}
