package mx.itesm.foquinrun;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;


public class Pantalla extends EscenaBase {


    private ITextureRegion regionFondo;
    private Sprite spriteFondo;

    private ITextureRegion regionBtnJugar;
    private ITextureRegion regionBtnSonido;
    private ITextureRegion reguionBtnMusica;

    private MenuScene menu;

    private final int OPCION_JUGAR = 0;
    private final int OPCION_SONIDO=1;
    private final int OCION_MUSICA=2;

    private ITextureRegion regionMundo;
    private Sprite spriteMundo;

    @Override
    public void cargarRecursos() {

        regionFondo= cargarImagen("MenuFondo.png");

        regionBtnJugar = cargarImagen("boton.png");

        regionBtnSonido=cargarImagen("Pantalla/Sonido.png");
        reguionBtnMusica=cargarImagen("Pantalla/Musica.png");

        regionMundo= cargarImagen("Pantalla/mundo.png");
    }


    @Override
    public void crearEscena() {
        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);
        attachChild(spriteFondo);

        spriteMundo=cargarSprite(ControlJuego.ALTO_CAMARA/2+600, ControlJuego.ALTO_CAMARA/2, regionMundo);
        attachChild(spriteMundo);
        spriteMundo.setScale(2);

        agregarMenu();
    }

    private void agregarMenu() {
        menu = new MenuScene(actividadJuego.camara);
        // Centrado en la pantalla
        menu.setPosition(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2);
        IMenuItem opcionJugar = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_JUGAR,
                regionBtnJugar, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionSonido = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_SONIDO,
                regionBtnSonido, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionMusica = new ScaleMenuItemDecorator(new SpriteMenuItem(OCION_MUSICA,
                reguionBtnMusica, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);

        menu.addMenuItem(opcionJugar);
        menu.addMenuItem(opcionMusica);
        menu.addMenuItem(opcionSonido);

        menu.buildAnimations();
        menu.setBackgroundEnabled(false);

        opcionJugar.setPosition(-300, -200);

        opcionSonido.setPosition(-550,360);
        opcionMusica.setPosition(-460,360);


        menu.setOnMenuItemClickListener(new MenuScene.IOnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
                                             float pMenuItemLocalX, float pMenuItemLocalY) {
                // El parámetro pMenuItem indica la opción oprimida
                switch (pMenuItem.getID()) {


                    case OPCION_JUGAR:

                        admEscenas.crearEscenaJuego();
                        admEscenas.setEscena(TipoEscena.ESCENA_JUEGO);
                        admEscenas.liberarEscenaPantalla();
                        break;
                    case OCION_MUSICA:


                        break;
                    case OPCION_SONIDO:


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
        admEscenas.liberarEscenaPantalla();
    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_PANTALLA;
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
