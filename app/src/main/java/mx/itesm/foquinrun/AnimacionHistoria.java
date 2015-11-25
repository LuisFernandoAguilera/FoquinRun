package mx.itesm.foquinrun;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by LuisFernandoAguileraCrivelli1 on 29/09/15.
 */
public class AnimacionHistoria extends EscenaBase{
    private ITextureRegion regionFondo;

    private ITextureRegion regionPantalla1;
    private Sprite spritePantalla1;
    private ITextureRegion regionPantalla2;
    private Sprite spritePantalla2;
    private ITextureRegion regionPantalla3;
    private Sprite spritePantalla3;
    private ITextureRegion regionPantalla4;
    private Sprite spritePantalla4;

    private MenuScene menu;
    private final int OPCION_FLECHAD=0;
    private final int OPCION_FLECHAI=1;

    private ITextureRegion regionFlechaDerecha;
    private ITextureRegion regionFlechaIzquierda;

    private int imagen=1;

    @Override
    public void cargarRecursos() {
        regionPantalla1=cargarImagen("Historia/1.jpg");
        regionPantalla2=cargarImagen("Historia/2.jpg");
        regionPantalla3=cargarImagen("Historia/3.jpg");
        regionPantalla4=cargarImagen("Historia/4.jpg");

        regionFlechaDerecha= cargarImagen("Pantalla/flechaderecha.png");
        regionFlechaIzquierda= cargarImagen("Pantalla/flechaizquierda.png");


    }

    @Override
    public void crearEscena() {
        spritePantalla1=cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionPantalla1);
        attachChild(spritePantalla1);
        spritePantalla1.setAlpha(0);

        spritePantalla2=cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionPantalla2);
        attachChild(spritePantalla2);
        spritePantalla2.setAlpha(0);

        spritePantalla3=cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionPantalla3);
        attachChild(spritePantalla3);
        spritePantalla3.setAlpha(0);

        spritePantalla4=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionPantalla4);
        attachChild(spritePantalla4);
        spritePantalla4.setAlpha(0);

        agregarMenu();
    }

    private void agregarMenu() {
        menu = new MenuScene(actividadJuego.camara);
        // Centrado en la pantalla
        menu.setPosition(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2);
        IMenuItem opcionFlechaDer = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_FLECHAD,
                regionFlechaDerecha, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionFlechaIzq = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_FLECHAI,
                regionFlechaIzquierda, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);

        menu.addMenuItem(opcionFlechaDer);
        menu.addMenuItem(opcionFlechaIzq);

        menu.buildAnimations();
        menu.setBackgroundEnabled(false);

        opcionFlechaDer.setPosition(550, -300);
        opcionFlechaIzq.setPosition(-550, -300);
        menu.setOnMenuItemClickListener(new MenuScene.IOnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
                                             float pMenuItemLocalX, float pMenuItemLocalY) {
                // El parámetro pMenuItem indica la opción oprimida
                switch (pMenuItem.getID()) {

                    case OPCION_FLECHAD:
                        imagen++;

                        break;
                    case OPCION_FLECHAI:
                        imagen--;

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
        if(imagen==1){
            spritePantalla1.setAlpha(1);
            spritePantalla2.setAlpha(0);
            spritePantalla3.setAlpha(0);
            spritePantalla4.setAlpha(0);
        }
        if(imagen==2){
            spritePantalla1.setAlpha(0);
            spritePantalla2.setAlpha(1);
            spritePantalla3.setAlpha(0);
            spritePantalla4.setAlpha(0);
        }
        if(imagen==3){
            spritePantalla1.setAlpha(0);
            spritePantalla2.setAlpha(0);
            spritePantalla3.setAlpha(1);
            spritePantalla4.setAlpha(0);
        }
        if(imagen==4){
            spritePantalla1.setAlpha(0);
            spritePantalla2.setAlpha(0);
            spritePantalla3.setAlpha(0);
            spritePantalla4.setAlpha(1);
        }
        if(imagen<0){
            imagen=0;
        }
        if(imagen>4){
            imagen=4;
        }

    }

    @Override
    public void onBackKeyPressed() {
        admEscenas.crearEscenaAcercaDe();
        admEscenas.setEscena(TipoEscena.ESCENA_ACERCA_DE);
        admEscenas.liberarEscenaAnimacionHistoria();
    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_ANIMACIONHISTORIA;
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
