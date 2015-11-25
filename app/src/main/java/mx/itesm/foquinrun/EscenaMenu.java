package mx.itesm.foquinrun;

import android.content.Context;
import android.content.SharedPreferences;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
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

    private ITextureRegion regionMundo;
    private Sprite spriteMundo;

    private ITextureRegion regionEspera;
    private Sprite spriteEspera;

    private ITextureRegion regionBlanco;
    private Sprite spriteBlanco;

    private AnimatedSprite spriteFoquin;
    private TiledTextureRegion regionFoquin;
    private AnimatedSprite spriteFoquinRojo;
    private TiledTextureRegion regionFoquinRojo;
    private AnimatedSprite spriteFoquinVerde;
    private TiledTextureRegion regionFoquinVerde;
    private AnimatedSprite spriteFoquinAzul;
    private TiledTextureRegion regionFoquinAzul;


    private Sprite spriteFondo;


    private MenuScene menu;

    private final int OPCION_ACERCA_DE = 0;
    private final int OPCION_JUGAR = 1;
    private final int OPCION_BOTON=2;

    private int angulo=0;
    private int contador=0;
    private int tiempo=0;




    @Override
    public void cargarRecursos() {

        regionFondo = cargarImagen("Menu/Inicio_Neon.png");


        regionBtnAcercaDe = cargarImagen("Menu/Opciones.png");
        regionBtnJugar = cargarImagen("Menu/Play.png");
        regionBtnBoton= cargarImagen("Menu/Menu.png");

        regionMundo= cargarImagen("Pantalla/mundo gira sin transparencia.png");


        regionFoquin= cargarImagenMosaico("EscenaJuego/Foquin.png", 1000, 280, 1, 5);
        regionFoquinRojo= cargarImagenMosaico("EscenaJuego/FoquinRojo.png", 1000, 280, 1, 5);
        regionFoquinVerde= cargarImagenMosaico("EscenaJuego/FoquinVerde.png", 1000, 280, 1, 5);
        regionFoquinAzul= cargarImagenMosaico("EscenaJuego/FoquinAzul.png", 1000, 280, 1, 5);

        regionEspera=cargarImagen("Menu/espera.png");
        regionBlanco=cargarImagen("Menu/blanco.png");

    }

    @Override
    public void crearEscena() {
        actividadJuego.reproducirMusica("Audio/Digital Native.mp3",true);


        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);

        SpriteBackground fondo = new SpriteBackground(1,1,1,spriteFondo);
        setBackground(fondo);
        setBackgroundEnabled(true);

        spriteMundo=cargarSprite(ControlJuego.ALTO_CAMARA/2-250, ControlJuego.ALTO_CAMARA/2-300, regionMundo);
        attachChild(spriteMundo);



        spriteFoquin = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionFoquin,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquin.animate(100);
        attachChild(spriteFoquin);
        spriteFoquin.setPosition(170, 410);

        spriteFoquinRojo = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionFoquinRojo,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquinRojo.animate(100);
        attachChild(spriteFoquinRojo);
        spriteFoquinRojo.setPosition(170, 410);
        spriteFoquinRojo.setAlpha(0);

        spriteFoquinVerde = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionFoquinVerde,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquinVerde.animate(100);
        attachChild(spriteFoquinVerde);
        spriteFoquinVerde.setPosition(170, 410);
        spriteFoquinVerde.setAlpha(0);

        spriteFoquinAzul = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionFoquinAzul,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquinAzul.animate(100);
        attachChild(spriteFoquinAzul);
        spriteFoquinAzul.setPosition(170, 410);
        spriteFoquinAzul.setAlpha(0);

        agregarMenu();
        spriteBlanco=cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionBlanco);
        attachChild(spriteBlanco);
        spriteBlanco.setAlpha(0);
        spriteEspera=cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionEspera);
        attachChild(spriteEspera);
        spriteEspera.setAlpha(0);
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
                        spriteBlanco.setAlpha(1);
                        spriteEspera.setAlpha(1);

                            admEscenas.crearEscenaAcercaDe();
                            admEscenas.setEscena(TipoEscena.ESCENA_ACERCA_DE);
                            admEscenas.liberarEscenaMenu();

                        break;

                    case OPCION_JUGAR:
                        spriteBlanco.setAlpha(1);
                        spriteEspera.setAlpha(1);

                            admEscenas.crearEscenaJuego();
                            admEscenas.setEscena(TipoEscena.ESCENA_JUEGO);
                            admEscenas.liberarEscenaMenu();

                        break;

                    case OPCION_BOTON:
                        spriteBlanco.setAlpha(1);
                        spriteEspera.setAlpha(1);

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
        if(spriteEspera.getAlpha()==1){
            tiempo++;
        }
        spriteMundo.setRotation(angulo);
        spriteEspera.setRotation(angulo);
        angulo--;
        if(angulo==-360){
            angulo=0;
        }

        contador++;
        if(contador>0&& contador<180){
            spriteFoquin.setAlpha(1);
            spriteFoquinRojo.setAlpha(0);
            spriteFoquinVerde.setAlpha(0);
            spriteFoquinAzul.setAlpha(0);
        }
        if(contador>180&& contador<360){
            spriteFoquin.setAlpha(0);
            spriteFoquinRojo.setAlpha(1);
            spriteFoquinVerde.setAlpha(0);
            spriteFoquinAzul.setAlpha(0);
        }
        if(contador>360&& contador<540){
            spriteFoquin.setAlpha(0);
            spriteFoquinRojo.setAlpha(0);
            spriteFoquinVerde.setAlpha(1);
            spriteFoquinAzul.setAlpha(0);
        }
        if(contador>540&& contador<720){
            spriteFoquin.setAlpha(0);
            spriteFoquinRojo.setAlpha(0);
            spriteFoquinVerde.setAlpha(0);
            spriteFoquinAzul.setAlpha(1);
        }
        if(contador==720){
            contador=0;
        }

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
