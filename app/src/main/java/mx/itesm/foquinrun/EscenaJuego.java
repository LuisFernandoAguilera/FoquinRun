package mx.itesm.foquinrun;

import android.view.Menu;
import android.widget.Switch;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.JumpModifier;
import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;


import java.util.ArrayList;


public class EscenaJuego extends EscenaBase {


    private ITextureRegion regionFondo;
    private Sprite spriteFondo;
    private ITextureRegion regionFondoMedio;
    private Sprite spriteFondoMedio;
    private ITextureRegion regionFonodFrente;
    private Sprite spriteFondoFrente;

    private TiledTextureRegion regionBtnRojo;
    private TiledTextureRegion regionBtnVerde;
    private TiledTextureRegion regionBtnAzul;

    private ITextureRegion regionPantallaPerdiste;
    private Sprite spritePantallaPerdiste;

    private AnimatedSprite spriteFoquin;
    private TiledTextureRegion regionFoquin;

    private AnimatedSprite spriteFoquinRojo;
    private TiledTextureRegion regionFoquinRojo;

    private AnimatedSprite spriteFoquinVerde;
    private TiledTextureRegion regionFoquinVerde;

    private AnimatedSprite spriteFoquinAzul;
    private TiledTextureRegion regionFoquinAzul;


    private ITextureRegion regionPlataformaEntrada;
    private Sprite spritePlataformaEntrada;


    private ITextureRegion regionBtnPausa;
    private final int OPCION_BTN_PAUSA=0;
    private MenuScene menu2;

    private ArrayList <Plataforma> listaPlataformas;
    private ArrayList <Plataforma> listaColorPlataformas;

    private ITextureRegion regionPlataformaRoja;
    private ITextureRegion regionPlataformaVerde;
    private ITextureRegion regionPlataformaAzul;

    private float tiempoplataformas = 0;
    private float LIMITE_TIEMPO = 1.3f;

    private boolean foquinSalta=false;

    private boolean foquinCae2=true;
    private boolean foquinCae3=true;
    private int contadorcolision=0;
    private int color=0;
    private int vidaFoquin=1;

    private boolean collionMonoPla=false;
    private boolean plataformaSale=false;






    @Override
    public void cargarRecursos() {
        regionFondo = cargarImagen("EscenaJuego/Fondos/cielo1.png");
        regionFondoMedio= cargarImagen("EscenaJuego/Fondos/edificio_atras_1.png");
        regionFonodFrente=cargarImagen("EscenaJuego/Fondos/escenario_frente_1.png");

        regionPantallaPerdiste=cargarImagen("EscenaJuego/perdiste.png");

        regionFoquin= cargarImagenMosaico("EscenaJuego/foquin.png", 1000, 280, 1, 5);
        regionFoquinRojo= cargarImagenMosaico("EscenaJuego/FoquinRojo.png", 1000, 280, 1, 5);
        regionFoquinVerde=cargarImagenMosaico("EscenaJuego/FoquinVerde.png", 1000, 280, 1, 5);
        regionFoquinAzul=cargarImagenMosaico("EscenaJuego/FoquinAzul.png", 1000, 280, 1, 5);


        regionBtnRojo= cargarImagenMosaico("EscenaJuego/Botones/botonRojo.png", 240, 120, 1, 2);
        regionBtnVerde= cargarImagenMosaico("EscenaJuego/Botones/botonVerde.png", 240, 120, 1, 2);
        regionBtnAzul= cargarImagenMosaico("EscenaJuego/Botones/botonAzul.png", 240, 120, 1, 2);



        regionPlataformaRoja= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaRojaPrendida.png");
        regionPlataformaVerde= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaVerdePrendida.png");
        regionPlataformaAzul= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaAzulPrendida.png");

        regionPlataformaEntrada=cargarImagen("EscenaJuego/Botones/Plataformas/plataformaEntrada.png");

        regionBtnPausa= cargarImagen("EscenaJuego/Botones/BotonPausa.png");


    }

    @Override
    public void crearEscena() {


        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionFondo);
        spriteFondoMedio=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA -250, regionFondoMedio);
        spriteFondoFrente=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionFonodFrente);

        spritePantallaPerdiste=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionPantallaPerdiste);
        attachChild(spritePantallaPerdiste);
        spritePantallaPerdiste.setAlpha(0);

        AutoParallaxBackground fondoAnimado = new AutoParallaxBackground(1, 1, 1, 5);
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-2, spriteFondo));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3,spriteFondoMedio));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteFondoFrente));
        setBackground(fondoAnimado);

        spritePlataformaEntrada=cargarSprite(ControlJuego.ANCHO_CAMARA/2-250,ControlJuego.ALTO_CAMARA/2-410, regionPlataformaEntrada);
        attachChild(spritePlataformaEntrada);
        spritePlataformaEntrada.setScale(2);



        ButtonSprite btnRojo = new ButtonSprite(0,0,regionBtnRojo,actividadJuego.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(TouchEvent event, float x, float y) {
                if(spriteFoquin.getY()==350 ) {
                    spriteFoquin.setAlpha(0);
                    spriteFoquinRojo.setAlpha(1);
                    spriteFoquinVerde.setAlpha(0);
                    spriteFoquinAzul.setAlpha(0);


                    JumpModifier salto = new JumpModifier(1, spriteFoquin.getX(), spriteFoquin.getX(),
                            spriteFoquin.getY(), spriteFoquin.getY(), -150);
                    spriteFoquin.registerEntityModifier(salto);
                    JumpModifier saltoRojo = new JumpModifier(1, spriteFoquinRojo.getX(), spriteFoquinRojo.getX(),
                            spriteFoquinRojo.getY(), spriteFoquinRojo.getY(), -150);
                    spriteFoquinRojo.registerEntityModifier(saltoRojo);
                    JumpModifier saltoVerde = new JumpModifier(1, spriteFoquinVerde.getX(), spriteFoquinVerde.getX(),
                            spriteFoquinVerde.getY(), spriteFoquinVerde.getY(), -150);
                    spriteFoquinVerde.registerEntityModifier(saltoVerde);
                    JumpModifier saltoAzul = new JumpModifier(1, spriteFoquinAzul.getX(), spriteFoquinAzul.getX(),
                            spriteFoquinAzul.getY(), spriteFoquinAzul.getY(), -150);
                    spriteFoquinAzul.registerEntityModifier(saltoAzul);
                }

                if(spriteFoquinRojo.getAlpha()==0){//permite que foquin cambie de color en el aire
                    spriteFoquin.setAlpha(0);
                    spriteFoquinRojo.setAlpha(1);
                    spriteFoquinVerde.setAlpha(0);
                    spriteFoquinAzul.setAlpha(0);
                }
                return super.onAreaTouched(event, x, y);
            }
        };
        ButtonSprite btnVerde = new ButtonSprite(0,0,regionBtnVerde,actividadJuego.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(TouchEvent event, float x, float y) {
                if(spriteFoquin.getY()==350 ) {
                    spriteFoquin.setAlpha(0);
                    spriteFoquinRojo.setAlpha(0);
                    spriteFoquinVerde.setAlpha(1);
                    spriteFoquinAzul.setAlpha(0);
                    JumpModifier salto = new JumpModifier(1, spriteFoquin.getX(), spriteFoquin.getX(),
                            spriteFoquin.getY(), spriteFoquin.getY(), -150);
                    spriteFoquin.registerEntityModifier(salto);
                    JumpModifier saltoRojo = new JumpModifier(1, spriteFoquinRojo.getX(), spriteFoquinRojo.getX(),
                            spriteFoquinRojo.getY(), spriteFoquinRojo.getY(), -150);
                    spriteFoquinRojo.registerEntityModifier(saltoRojo);
                    JumpModifier saltoVerde = new JumpModifier(1, spriteFoquinVerde.getX(), spriteFoquinVerde.getX(),
                            spriteFoquinVerde.getY(), spriteFoquinVerde.getY(), -150);
                    spriteFoquinVerde.registerEntityModifier(saltoVerde);
                    JumpModifier saltoAzul = new JumpModifier(1, spriteFoquinAzul.getX(), spriteFoquinAzul.getX(),
                            spriteFoquinAzul.getY(), spriteFoquinAzul.getY(), -150);
                    spriteFoquinAzul.registerEntityModifier(saltoAzul);
                }
                if(spriteFoquinVerde.getAlpha()==0){
                    spriteFoquin.setAlpha(0);
                    spriteFoquinRojo.setAlpha(0);
                    spriteFoquinVerde.setAlpha(1);
                    spriteFoquinAzul.setAlpha(0);
                }
                return super.onAreaTouched(event, x, y);

            }
        };
        ButtonSprite btnAzul = new ButtonSprite(0,0,regionBtnAzul,actividadJuego.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(TouchEvent event, float x, float y) {
                if(spriteFoquin.getY()==350) {
                    spriteFoquin.setAlpha(0);
                    spriteFoquinRojo.setAlpha(0);
                    spriteFoquinVerde.setAlpha(0);
                    spriteFoquinAzul.setAlpha(1);
                    JumpModifier salto = new JumpModifier(1, spriteFoquin.getX(), spriteFoquin.getX(),
                            spriteFoquin.getY(), spriteFoquin.getY(), -150);
                    spriteFoquin.registerEntityModifier(salto);
                    JumpModifier saltoRojo = new JumpModifier(1, spriteFoquinRojo.getX(), spriteFoquinRojo.getX(),
                            spriteFoquinRojo.getY(), spriteFoquinRojo.getY(), -150);
                    spriteFoquinRojo.registerEntityModifier(saltoRojo);
                    JumpModifier saltoVerde = new JumpModifier(1, spriteFoquinVerde.getX(), spriteFoquinVerde.getX(),
                            spriteFoquinVerde.getY(), spriteFoquinVerde.getY(), -150);
                    spriteFoquinVerde.registerEntityModifier(saltoVerde);
                    JumpModifier saltoAzul = new JumpModifier(1, spriteFoquinAzul.getX(), spriteFoquinAzul.getX(),
                            spriteFoquinAzul.getY(), spriteFoquinAzul.getY(), -150);
                    spriteFoquinAzul.registerEntityModifier(saltoAzul);
                }
                if(spriteFoquinAzul.getAlpha()==0){
                    spriteFoquin.setAlpha(0);
                    spriteFoquinRojo.setAlpha(0);
                    spriteFoquinVerde.setAlpha(0);
                    spriteFoquinAzul.setAlpha(1);
                }
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

        listaPlataformas= new ArrayList<Plataforma>();

        spriteFoquin = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                    ControlJuego.ALTO_CAMARA / 2, regionFoquin,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquin.animate(100);
        attachChild(spriteFoquin);
        spriteFoquin.setPosition(250, 350);


        spriteFoquinRojo = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionFoquinRojo,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquinRojo.animate(100);
        attachChild(spriteFoquinRojo);
        spriteFoquinRojo.setPosition(250, 350);
        spriteFoquinRojo.setAlpha(0);


        spriteFoquinVerde = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionFoquinVerde,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquinVerde.animate(100);
        attachChild(spriteFoquinVerde);
        spriteFoquinVerde.setPosition(250, 350);
        spriteFoquinVerde.setAlpha(0);


        spriteFoquinAzul = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionFoquinAzul,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquinAzul.animate(100);
        attachChild(spriteFoquinAzul);
        spriteFoquinAzul.setPosition(250, 350);
        spriteFoquinAzul.setAlpha(0);


    }



    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);

        spritePlataformaEntrada.setPosition(spritePlataformaEntrada.getX()-5,spritePlataformaEntrada.getY());

        if(spriteFoquin.collidesWith(spritePlataformaEntrada)){
            foquinCae2=false;
        }
        else{
            foquinCae2 =true;
        }
        if(foquinCae2==true&& foquinCae3==true){
            spriteFoquin.setPosition(spriteFoquin.getX(),spriteFoquin.getY()-12);
            spriteFoquinRojo.setPosition(spriteFoquinRojo.getX(),spriteFoquinRojo.getY()-12);
            spriteFoquinVerde.setPosition(spriteFoquinVerde.getX(),spriteFoquinVerde.getY()-12);
            spriteFoquinAzul.setPosition(spriteFoquinAzul.getX(),spriteFoquinAzul.getY()-12);
        }

        int colorplataforma= (int) (Math.floor(Math.random() * (3 - 1 + 1)) + 1);

        tiempoplataformas += pSecondsElapsed;
        if (tiempoplataformas>LIMITE_TIEMPO) {
            tiempoplataformas = 0;
            if(colorplataforma==1) {
                Sprite spritePlataformaRoja = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaRoja.getWidth(),
                        (ControlJuego.ALTO_CAMARA - regionPlataformaRoja.getHeight()) +
                                regionPlataformaRoja.getHeight()-600, regionPlataformaRoja);
                Plataforma nuevoPlataformaRoja = new Plataforma();
                nuevoPlataformaRoja.setSprite(spritePlataformaRoja);
                nuevoPlataformaRoja.setColor(1);
                listaPlataformas.add(nuevoPlataformaRoja);
                attachChild(nuevoPlataformaRoja.getSpritePlataforma());

            }
            if(colorplataforma==2) {
                Sprite spritePlataformaVerde = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaVerde.getWidth(),
                        (ControlJuego.ALTO_CAMARA - regionPlataformaVerde.getHeight()) +
                                regionPlataformaVerde.getHeight()-600, regionPlataformaVerde);
                Plataforma nuevoPlataformaVerde = new Plataforma();
                nuevoPlataformaVerde.setSprite(spritePlataformaVerde);
                nuevoPlataformaVerde.setColor(2);
                listaPlataformas.add(nuevoPlataformaVerde);
                attachChild(nuevoPlataformaVerde.getSpritePlataforma());

            }
            if(colorplataforma==3) {
                Sprite spritePlataformaAzul = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaAzul.getWidth(),
                        (ControlJuego.ALTO_CAMARA - regionPlataformaAzul.getHeight()) +
                                regionPlataformaAzul.getHeight()-600, regionPlataformaAzul);
                Plataforma nuevoPlataformaAzul = new Plataforma();
                nuevoPlataformaAzul.setSprite(spritePlataformaAzul);
                nuevoPlataformaAzul.setColor(3);
                listaPlataformas.add(nuevoPlataformaAzul);
                attachChild(nuevoPlataformaAzul.getSpritePlataforma());

            }
        }

        if(spritePlataformaEntrada.getX()+spritePlataformaEntrada.getWidth()+80<0){
            foquinCae3=false;
        }

        for (int i= listaPlataformas.size()-1; i>=0; i--) {
            Plataforma plataforma = listaPlataformas.get(i);
            plataforma.mover(-8, 0);
            //agregar condicion para que foquin salte en las plataformas

            if(spriteFoquin.collidesWith(plataforma.getSpritePlataforma())) {
                contadorcolision=1;

                if(spriteFoquin.getY()<350 && spriteFoquin.getY()>330){
                    spriteFoquin.setPosition(spriteFoquin.getX(),350);
                    spriteFoquinRojo.setPosition(spriteFoquinRojo.getX(),350);
                    spriteFoquinVerde.setPosition(spriteFoquinVerde.getX(),350);
                    spriteFoquinAzul.setPosition(spriteFoquinAzul.getX(),350);
                }

            }
            else{
                contadorcolision=0;
            }

            if(spriteFoquin.collidesWith(plataforma.getSpritePlataforma())&&
                    spriteFoquinRojo.getAlpha()==1 && plataforma.getColor()==2 ){
                color=1;
            }
            if(spriteFoquin.collidesWith(plataforma.getSpritePlataforma())&&
                    spriteFoquinRojo.getAlpha()==1 && plataforma.getColor()==3 ){
                color=1;
            }


            if(spriteFoquin.collidesWith(plataforma.getSpritePlataforma())&&
                    spriteFoquinVerde.getAlpha()==1&& plataforma.getColor()==1) {
                color = 2;
            }
            if(spriteFoquin.collidesWith(plataforma.getSpritePlataforma())&&
                    spriteFoquinVerde.getAlpha()==1&& plataforma.getColor()==3) {
                color = 2;
            }


            if(spriteFoquin.collidesWith(plataforma.getSpritePlataforma())&&
                    spriteFoquinAzul.getAlpha()==1&& plataforma.getColor()==1){
                color=3;
            }
            if(spriteFoquin.collidesWith(plataforma.getSpritePlataforma())&&
                    spriteFoquinAzul.getAlpha()==1&& plataforma.getColor()==2){
                color=3;
            }

            if (plataforma.getSpritePlataforma().getX() < -plataforma.getSpritePlataforma().getWidth()) {
                detachChild(plataforma.getSpritePlataforma());
                listaPlataformas.remove(plataforma);
            }
        }


        if(contadorcolision==0 && foquinCae3==false){
            spriteFoquin.setPosition(spriteFoquin.getX(),spriteFoquin.getY()-12);
            spriteFoquinRojo.setPosition(spriteFoquinRojo.getX(),spriteFoquinRojo.getY()-12);
            spriteFoquinVerde.setPosition(spriteFoquinVerde.getX(),spriteFoquinVerde.getY()-12);
            spriteFoquinAzul.setPosition(spriteFoquinAzul.getX(),spriteFoquinAzul.getY()-12);
        }
        if(color==1 ){
            vidaFoquin--;

        }
        if(color==2){
            vidaFoquin--;
        }
        if(color==3){
            vidaFoquin--;
        }

        //si la vida de foquin es 0 pierdes
        if(vidaFoquin==0){
            spritePantallaPerdiste.setAlpha(1);

            spriteFoquin.setAlpha(0);
            spriteFoquinRojo.setAlpha(0);
            spriteFoquinVerde.setAlpha(0);
            spriteFoquinAzul.setAlpha(0);
        }
        if(spriteFoquin.getY()<50){
            spritePantallaPerdiste.setAlpha(1);

            spriteFoquin.setAlpha(0);
            spriteFoquinRojo.setAlpha(0);
            spriteFoquinVerde.setAlpha(0);
            spriteFoquinAzul.setAlpha(0);
        }

    }



    @Override
    public void onBackKeyPressed() {

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

