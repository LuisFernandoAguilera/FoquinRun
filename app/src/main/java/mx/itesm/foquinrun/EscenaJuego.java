package mx.itesm.foquinrun;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;


public class EscenaJuego extends EscenaBase {

    // Regiones para imágenes
    private ITextureRegion regionFondo;
    // Sprite para el fondo
    private Sprite spriteFondo;

    private AnimatedSprite spriteFoquin;
    private TiledTextureRegion regionFoquin;


    private MenuScene menu;
    private ITextureRegion getRegionBotonRojo;
    private ITextureRegion getGetRegionBotonVerde;
    private ITextureRegion getGetRegionBotonAzul;

    private final int ROJO=0;
    private final int VERDE=1;
    private final int AZUL=2;


    private boolean foquinSalta=false;


    @Override
    public void cargarRecursos() {
        regionFondo = cargarImagen("Prueba/Juego.png");

        regionFoquin= cargarImagenMosaico("EscenaJuego/Foquin.png", 1000, 277, 1, 5);

        getRegionBotonRojo= cargarImagen("boton.png");
        getGetRegionBotonAzul= cargarImagen("boton.png");
        getGetRegionBotonVerde= cargarImagen("boton.png");
    }

    @Override
    public void crearEscena() {


        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);
        attachChild(spriteFondo);

        spriteFoquin = new AnimatedSprite(ControlJuego.ALTO_CAMARA/2,
                ControlJuego.ALTO_CAMARA/2,regionFoquin,
                actividadJuego.getVertexBufferObjectManager());

        spriteFoquin.animate(100);
        attachChild(spriteFoquin);

        agregarBotonesDeJuego();


    }

    private void agregarBotonesDeJuego() {
        menu = new MenuScene(actividadJuego.camara);
        menu.setPosition(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2);

        final IMenuItem BotonRojo = new ScaleMenuItemDecorator(new SpriteMenuItem(ROJO,
                getRegionBotonRojo, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        final IMenuItem BotonVerde = new ScaleMenuItemDecorator(new SpriteMenuItem(VERDE,
                getGetRegionBotonVerde, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem BotonAzul = new ScaleMenuItemDecorator(new SpriteMenuItem(AZUL,
                getRegionBotonRojo, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);

        menu.addMenuItem(BotonRojo);
        menu.addMenuItem(BotonVerde);
        menu.addMenuItem(BotonAzul);

        menu.buildAnimations();
        menu.setBackgroundEnabled(false);

        BotonRojo.setPosition(300, -300);
        BotonVerde.setPosition(390,-220);
        BotonAzul.setPosition(420,-80);

        menu.setOnMenuItemClickListener(new MenuScene.IOnMenuItemClickListener() {
            public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
                                             float pMenuItemLocalX, float pMenuItemLocalY) {
                // El parámetro pMenuItem indica la opción oprimida
                switch (pMenuItem.getID()) {
                    case ROJO:


                    case VERDE:


                    case AZUL:


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
        admEscenas.liberarEscenaJuego();
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

