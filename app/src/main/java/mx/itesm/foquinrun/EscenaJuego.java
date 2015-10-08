package mx.itesm.foquinrun;

import android.view.Menu;
import android.widget.Switch;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.JumpModifier;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;


import java.util.ArrayList;


public class EscenaJuego extends EscenaBase {


    private ITextureRegion regionFondo;
    private Sprite spriteFondo;

    private TiledTextureRegion regionBtnRojo;
    private TiledTextureRegion regionBtnVerde;
    private TiledTextureRegion regionBtnAzul;


    private AnimatedSprite spriteFoquin;
    private TiledTextureRegion regionFoquin;

    private AnimatedSprite spriteFoquinRojo;
    private TiledTextureRegion regionFoquinRojo;

    private AnimatedSprite spriteFoquinVerde;
    private TiledTextureRegion regionFoquinVerde;

    private AnimatedSprite spriteFoquinAzul;
    private TiledTextureRegion regionFoquinAzul;

    private ITextureRegion regionBtnPausa;
    private final int OPCION_BTN_PAUSA=0;
    private MenuScene menu2;

    private ArrayList <Plataforma> listaPlataformas;
    private ITextureRegion regionPlataforma;

    private float tiempoplataformas = 0;
    private float LIMITE_TIEMPO = 2.5f;







    private boolean foquinSalta=false;


    @Override
    public void cargarRecursos() {
        regionFondo = cargarImagen("Prueba/Juego.png");

        regionFoquin= cargarImagenMosaico("EscenaJuego/foquin.png", 500, 140, 1, 5);
        regionFoquinRojo= cargarImagenMosaico("EscenaJuego/FoquinRojo2.png", 500, 140, 1, 5);
        regionFoquinVerde=cargarImagenMosaico("EscenaJuego/foquinVerde2.png", 500, 140, 1, 5);
        regionFoquinAzul=cargarImagenMosaico("EscenaJuego/foquinAzul2.png", 500, 140, 1, 5);

        regionBtnRojo= cargarImagenMosaico("EscenaJuego/Botones/botonRojo2.png",240,120,1,2);
        regionBtnVerde= cargarImagenMosaico("EscenaJuego/Botones/botonVerde2.png",240,120,1,2);
        regionBtnAzul= cargarImagenMosaico("EscenaJuego/Botones/botonAzul2.png",240,120,1,2);



        regionPlataforma= cargarImagen("Prueba/plataforma.png");

        regionBtnPausa= cargarImagen("EscenaJuego/Botones/BotonPausa.png");


    }

    @Override
    public void crearEscena() {


        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionFondo);
        attachChild(spriteFondo);

        ButtonSprite btnRojo = new ButtonSprite(0,0,regionBtnRojo,actividadJuego.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(TouchEvent event, float x, float y) {
                JumpModifier salto = new JumpModifier(1,spriteFoquin.getX(),spriteFoquin.getX(),
                        spriteFoquin.getY(),spriteFoquin.getY(),-200);
                spriteFoquin.registerEntityModifier(salto);
                return super.onAreaTouched(event, x, y);

            }
        };
        ButtonSprite btnVerde = new ButtonSprite(0,0,regionBtnVerde,actividadJuego.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(TouchEvent event, float x, float y) {
                return super.onAreaTouched(event, x, y);

            }
        };
        ButtonSprite btnAzul = new ButtonSprite(0,0,regionBtnAzul,actividadJuego.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(TouchEvent event, float x, float y) {
                return super.onAreaTouched(event, x, y);

            }
        };


        registerTouchArea(btnRojo);
        attachChild(btnRojo);
        btnRojo.setPosition(1000, 100);

        registerTouchArea(btnVerde);
        attachChild(btnVerde);
        btnVerde.setPosition(1100, 200);

        registerTouchArea(btnAzul);
        attachChild(btnAzul);
        btnAzul.setPosition(1200, 300);




        spriteFoquin = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                    ControlJuego.ALTO_CAMARA / 2, regionFoquin,
                    actividadJuego.getVertexBufferObjectManager());
        spriteFoquin.animate(100);
        attachChild(spriteFoquin);
        spriteFoquin.setPosition(250, 300);
        spriteFoquin.setScale(2);


        listaPlataformas= new ArrayList<Plataforma>();




    }



    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);



        tiempoplataformas += pSecondsElapsed;
        if (tiempoplataformas>LIMITE_TIEMPO) {
            tiempoplataformas = 0;

            Sprite spritePlataforma = cargarSprite(ControlJuego.ANCHO_CAMARA/2+regionPlataforma.getWidth(),
                    (float)(Math.random()*ControlJuego.ALTO_CAMARA-regionPlataforma.getHeight()) +
                            regionPlataforma.getHeight(),regionPlataforma);
            Plataforma nuevoPlataforma = new Plataforma();
            nuevoPlataforma.setSprite(spritePlataforma);
            listaPlataformas.add(nuevoPlataforma);
            attachChild(nuevoPlataforma.getSpritePlataforma());
        }
        


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

