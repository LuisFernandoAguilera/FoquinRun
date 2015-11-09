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
    private ITextureRegion regionLuzF1;
    private Sprite spriteLuzF1;
    private ITextureRegion regionLuzF2;
    private Sprite spriteLuzF2;
    private ITextureRegion regionLuzF3;
    private Sprite spriteLuzF3;
    private ITextureRegion regionLuzF4;
    private Sprite spriteLuzF4;
    private ITextureRegion regionLuzF5;
    private Sprite spriteLuzF5;
    private ITextureRegion regionLuzF6;
    private Sprite spriteLuzF6;
    private ITextureRegion regionLuzF7;
    private Sprite spriteLuzF7;
    private ITextureRegion regionLuzF8;
    private Sprite spriteLuzF8;

    private ITextureRegion region3p;
    private ITextureRegion region2p;
    private ITextureRegion region1p;
    private Sprite sprite3p;
    private Sprite sprite2p;
    private Sprite sprite1p;
    private ITextureRegion region3a;
    private ITextureRegion region2a;
    private ITextureRegion region1a;
    private Sprite sprite3a;
    private Sprite sprite2a;
    private Sprite sprite1a;


    private ITextureRegion regionFondo;
    private Sprite spriteFondo;
    private ITextureRegion regionFondoMedio;
    private Sprite spriteFondoMedio;
    private ITextureRegion regionFondoFrente;
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

    private ITextureRegion regionFoquinCaeRojo;
    private Sprite spriteFoquinCaeRojo;

    private ITextureRegion regionFoquinCaeVerde;
    private Sprite spriteFoquinCaeVerde;

    private ITextureRegion regionFoquinCaeAzul;
    private Sprite spriteFoquinCaeAzul;



    private ITextureRegion regionPlataformaEntrada;
    private Sprite spritePlataformaEntrada;



    private ITextureRegion regionBtnPausa;
    private final int OPCION_BTN_PAUSA=0;
    private ITextureRegion regionBtnMenu;
    private final int OPCION_BTN_MENU=1;
    private ITextureRegion regionBtnVolveraJugar;
    private final int OPCION_BTN_VOLVEAJUGAR=2;


    private MenuScene menu;
    private ITextureRegion regionPantallaPausa;
    private Sprite spritePantalllaPausa;

    private ArrayList <Plataforma> listaPlataformas;


    private ITextureRegion regionPlataformaRoja;
    private ITextureRegion regionPlataformaVerde;
    private ITextureRegion regionPlataformaAzul;

    private float tiempoplataformas = 0;
    private float LIMITE_TIEMPO = 1.3f;

    private boolean foquinSalta=false;

    private boolean foquinCae2=true;
    private boolean foquinCae3=true;
    private int contadorcolision=0;
    private int vidaFoquin=1;
    private boolean pausa=false;
    private boolean perdiste=false;
    private boolean quitarBoton=false;

    private int foquinColor=0;

    private int contadorTiempo=0;
    private int contadorLuz=0;
    private int cuentaRegresiva=200;


    @Override
    public void cargarRecursos() {
        regionLuzF1= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente1.png");
        regionLuzF2= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente2.png");
        regionLuzF3= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente3.png");
        regionLuzF4= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente4.png");
        regionLuzF5= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente5.png");
        regionLuzF6= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente6.png");
        regionLuzF7= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente7.png");
        regionLuzF8= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente8.png");

        region3p=cargarImagen("EscenaJuego/3,2,1/3prendido.png");
        region2p=cargarImagen("EscenaJuego/3,2,1/2prendido.png");
        region1p=cargarImagen("EscenaJuego/3,2,1/1prendido.png");
        region1a=cargarImagen("EscenaJuego/3,2,1/1apagado.png");
        region2a=cargarImagen("EscenaJuego/3,2,1/2apagado.png");
        region3a=cargarImagen("EscenaJuego/3,2,1/3apagado.png");

        regionFondo = cargarImagen("EscenaJuego/Fondos/cielo1.png");
        regionFondoMedio= cargarImagen("EscenaJuego/Fondos/edificio_atras_1.png");
        regionFondoFrente=cargarImagen("EscenaJuego/Fondos/escenario_frente_1.png");

        regionPantallaPerdiste=cargarImagen("EscenaJuego/Perdiste/Perdida_neon.png");


        regionFoquin= cargarImagenMosaico("EscenaJuego/foquin.png", 1000, 280, 1, 5);
        regionFoquinRojo= cargarImagenMosaico("EscenaJuego/FoquinRojo.png", 1000, 280, 1, 5);
        regionFoquinVerde=cargarImagenMosaico("EscenaJuego/FoquinVerde.png", 1000, 280, 1, 5);
        regionFoquinAzul=cargarImagenMosaico("EscenaJuego/FoquinAzul.png", 1000, 280, 1, 5);

        regionFoquinCaeRojo=cargarImagen("EscenaJuego/Perdiste/FoquinCaeRojo.png");
        regionFoquinCaeVerde=cargarImagen("EscenaJuego/Perdiste/FoquinCaeVerde.png");
        regionFoquinCaeAzul=cargarImagen("EscenaJuego/Perdiste/FoquinCaeAzul.png");

        regionBtnRojo= cargarImagenMosaico("EscenaJuego/Botones/botonRojo.png", 240, 120, 1, 2);
        regionBtnVerde= cargarImagenMosaico("EscenaJuego/Botones/botonVerde.png", 240, 120, 1, 2);
        regionBtnAzul= cargarImagenMosaico("EscenaJuego/Botones/botonAzul.png", 240, 120, 1, 2);



        regionPlataformaRoja= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaRojaPrendida.png");
        regionPlataformaVerde= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaVerdePrendida.png");
        regionPlataformaAzul= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaAzulPrendida.png");

        regionPlataformaEntrada=cargarImagen("EscenaJuego/Botones/Plataformas/plataformaEntrada.png");

        regionBtnPausa= cargarImagen("EscenaJuego/Botones/BotonPausa.png");
        regionBtnMenu= cargarImagen("EscenaJuego/Perdiste/Menu_neon.png");
        regionBtnVolveraJugar= cargarImagen("EscenaJuego/Perdiste/Volver_A_Jugar_neon.png");


        regionPantallaPausa= cargarImagen("EsenaPausa/fondo_pausa.png");




    }

    @Override
    public void crearEscena() {
        spriteLuzF1=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF1);
        spriteLuzF2=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF2);
        spriteLuzF3=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF3);
        spriteLuzF4=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF4);
        spriteLuzF5=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF5);
        spriteLuzF6=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF6);
        spriteLuzF7=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF7);
        spriteLuzF8=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF8);


        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionFondo);
        spriteFondoMedio=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA -250, regionFondoMedio);
        spriteFondoFrente=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionFondoFrente);

        spritePantallaPerdiste=cargarSprite(ControlJuego.ANCHO_CAMARA / 2-50, ControlJuego.ALTO_CAMARA / 2, regionPantallaPerdiste);
        attachChild(spritePantallaPerdiste);
        spritePantallaPerdiste.setAlpha(0);

        agregarMenu();

        AutoParallaxBackground fondoAnimado = new AutoParallaxBackground(1, 1, 1, 5);
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-2, spriteFondo));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteFondoMedio));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteFondoFrente));

        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF1));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF2));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF3));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF4));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF5));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF6));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF7));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF8));
        spriteLuzF1.setAlpha(0);
        spriteLuzF2.setAlpha(0);
        spriteLuzF3.setAlpha(0);
        spriteLuzF4.setAlpha(0);
        spriteLuzF5.setAlpha(0);
        spriteLuzF6.setAlpha(0);
        spriteLuzF7.setAlpha(0);
        spriteLuzF8.setAlpha(0);
        spriteLuzF1.setColor(0.8f, 0.8f, 0f);
        spriteLuzF2.setColor(0.8f, 0.8f, 0f);
        spriteLuzF3.setColor(0.8f, 0.8f, 0f);
        spriteLuzF4.setColor(0.8f, 0.8f, 0f);
        spriteLuzF5.setColor(0.8f, 0.8f, 0f);
        spriteLuzF6.setColor(0.8f, 0.8f, 0f);
        spriteLuzF7.setColor(0.8f, 0.8f, 0f);
        spriteLuzF8.setColor(0.8f, 0.8f, 0f);

        sprite1p=cargarSprite(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2, region1p);
        sprite2p=cargarSprite(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2, region2p);
        sprite3p=cargarSprite(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2, region3p);
        sprite3a=cargarSprite(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2, region3a);
        sprite2a=cargarSprite(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2, region2a);
        sprite1a=cargarSprite(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2, region1a);

        attachChild(sprite1p);
        attachChild(sprite2p);
        attachChild(sprite3p);
        attachChild(sprite1a);
        attachChild(sprite2a);
        attachChild(sprite3a);
        sprite1p.setAlpha(0);
        sprite2p.setAlpha(0);
        sprite3p.setAlpha(0);
        sprite1a.setAlpha(0);
        sprite2a.setAlpha(0);
        sprite3a.setAlpha(0);

        setBackground(fondoAnimado);

        spritePlataformaEntrada=cargarSprite(ControlJuego.ANCHO_CAMARA/2-250,ControlJuego.ALTO_CAMARA/2-410, regionPlataformaEntrada);
        attachChild(spritePlataformaEntrada);
        spritePlataformaEntrada.setScale(2);

        spriteFoquinCaeRojo=cargarSprite(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2,regionFoquinCaeRojo);
        spriteFoquinCaeVerde=cargarSprite(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2,regionFoquinCaeVerde);
        spriteFoquinCaeAzul=cargarSprite(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2,regionFoquinCaeAzul);

        attachChild(spriteFoquinCaeRojo);
        attachChild(spriteFoquinCaeVerde);
        attachChild(spriteFoquinCaeAzul);

        spriteFoquinCaeRojo.setPosition(250, 350);
        spriteFoquinCaeVerde.setPosition(250, 350);
        spriteFoquinCaeAzul.setPosition(250, 350);
        spriteFoquinCaeRojo.setAlpha(0);
        spriteFoquinCaeVerde.setAlpha(0);
        spriteFoquinCaeAzul.setAlpha(0);


            ButtonSprite btnRojo = new ButtonSprite(0, 0, regionBtnRojo, actividadJuego.getVertexBufferObjectManager()) {
                @Override
                public boolean onAreaTouched(TouchEvent event, float x, float y) {
                    if (spriteFoquin.getY() == 350) {
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

                    if (spriteFoquinRojo.getAlpha() == 0) {//permite que foquin cambie de color en el aire
                        spriteFoquin.setAlpha(0);
                        spriteFoquinRojo.setAlpha(1);
                        spriteFoquinVerde.setAlpha(0);
                        spriteFoquinAzul.setAlpha(0);
                    }
                    return super.onAreaTouched(event, x, y);
                }
            };
            ButtonSprite btnVerde = new ButtonSprite(0, 0, regionBtnVerde, actividadJuego.getVertexBufferObjectManager()) {
                @Override
                public boolean onAreaTouched(TouchEvent event, float x, float y) {
                    if (spriteFoquin.getY() == 350) {
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
                    if (spriteFoquinVerde.getAlpha() == 0) {
                        spriteFoquin.setAlpha(0);
                        spriteFoquinRojo.setAlpha(0);
                        spriteFoquinVerde.setAlpha(1);
                        spriteFoquinAzul.setAlpha(0);
                    }
                    return super.onAreaTouched(event, x, y);

                }
            };
            ButtonSprite btnAzul = new ButtonSprite(0, 0, regionBtnAzul, actividadJuego.getVertexBufferObjectManager()) {
                @Override
                public boolean onAreaTouched(TouchEvent event, float x, float y) {
                    if (spriteFoquin.getY() == 350) {//usar variable extra para compensar altruas de foquin
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
                    if (spriteFoquinAzul.getAlpha() == 0) {
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



            listaPlataformas = new ArrayList<Plataforma>();

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


        spritePantalllaPausa=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionPantallaPausa);
        attachChild(spritePantalllaPausa);
        spritePantalllaPausa.setAlpha(0);
    }

    private void agregarMenu() {
        menu = new MenuScene(actividadJuego.camara);
        menu.setPosition(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2);

        IMenuItem opcionPausa = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_BTN_PAUSA,
                regionBtnPausa, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionBtnMenu= new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_BTN_MENU,
                regionBtnMenu, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionBtnVolveraJugar= new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_BTN_VOLVEAJUGAR,
                regionBtnVolveraJugar, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);

        menu.addMenuItem(opcionPausa);
        menu.addMenuItem(opcionBtnMenu);
        menu.addMenuItem(opcionBtnVolveraJugar);
        menu.buildAnimations();
        menu.setBackgroundEnabled(false);

        opcionPausa.setPosition(-600, 350);

        opcionBtnMenu.setPosition(-50, -300);
        opcionBtnVolveraJugar.setPosition(-50, -230);
        opcionBtnMenu.setAlpha(0);
        opcionBtnVolveraJugar.setAlpha(0);
        menu.setOnMenuItemClickListener(new MenuScene.IOnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
                                             float pMenuItemLocalX, float pMenuItemLocalY) {

                switch (pMenuItem.getID()) {


                    case OPCION_BTN_PAUSA:
                        spritePantalllaPausa.setAlpha(1);
                        pausa=true;

                        break;
                    case OPCION_BTN_MENU:

                        admEscenas.crearEscenaMenu();
                        admEscenas.setEscena(TipoEscena.ESCENA_MENU);
                        admEscenas.liberarEscenaJuego();

                        break;
                    case OPCION_BTN_VOLVEAJUGAR:
                        if(perdiste==true){
                        admEscenas.liberarEscenaJuego();
                        admEscenas.crearEscenaJuego();
                        admEscenas.setEscena(TipoEscena.ESCENA_JUEGO);
                            }
                        else


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

        contadorTiempo=contadorTiempo+1;
        cuentaRegresiva--;

        if(pausa==false) {
            if (cuentaRegresiva > 170) {
                sprite3a.setAlpha(1);
            }
            if (cuentaRegresiva < 140) {
                sprite3a.setAlpha(0);
                sprite3p.setAlpha(1);
            }
            if (cuentaRegresiva < 110) {
                sprite3p.setAlpha(0);
                sprite2a.setAlpha(1);
            }
            if (cuentaRegresiva < 80) {
                sprite2a.setAlpha(0);
                sprite2p.setAlpha(1);
            }
            if (cuentaRegresiva < 50) {
                sprite2p.setAlpha(0);
                sprite1a.setAlpha(1);
            }
            if (cuentaRegresiva < 20) {
                sprite1a.setAlpha(0);
                sprite1p.setAlpha(1);
            }
            if (cuentaRegresiva < 0) {
                sprite1p.setAlpha(0);
            }
        }
        if (pausa==false) {
            if (cuentaRegresiva < 0) {
                spritePlataformaEntrada.setPosition(spritePlataformaEntrada.getX() - 4, spritePlataformaEntrada.getY());
            }
        }

        if (spriteFoquin.collidesWith(spritePlataformaEntrada)) {
            foquinCae2 = false;
        } else {
            foquinCae2 = true;
        }
        if (foquinCae2 == true && foquinCae3 == true) {
            spriteFoquin.setPosition(spriteFoquin.getX(), spriteFoquin.getY() - 12);
            spriteFoquinRojo.setPosition(spriteFoquinRojo.getX(), spriteFoquinRojo.getY() - 12);
            spriteFoquinVerde.setPosition(spriteFoquinVerde.getX(), spriteFoquinVerde.getY() - 12);
            spriteFoquinAzul.setPosition(spriteFoquinAzul.getX(), spriteFoquinAzul.getY() - 12);
        }
        if(pausa==false) {
            if (cuentaRegresiva < 0) {
                int colorplataforma = (int) (Math.floor(Math.random() * (3 - 1 + 1)) + 1);

                tiempoplataformas += pSecondsElapsed;//tiempo velocidad constante
                if (tiempoplataformas > LIMITE_TIEMPO) {
                    tiempoplataformas = 0;
                    if (colorplataforma == 1) {
                        Sprite spritePlataformaRoja = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaRoja.getWidth(),
                                (ControlJuego.ALTO_CAMARA - regionPlataformaRoja.getHeight()) +
                                        regionPlataformaRoja.getHeight() - 600, regionPlataformaRoja);
                        Plataforma nuevoPlataformaRoja = new Plataforma();
                        nuevoPlataformaRoja.setSprite(spritePlataformaRoja);
                        nuevoPlataformaRoja.setColor(1);
                        nuevoPlataformaRoja.getSpritePlataforma().setColor(0.4f, 0f, 0f);
                        listaPlataformas.add(nuevoPlataformaRoja);
                        attachChild(nuevoPlataformaRoja.getSpritePlataforma());

                    }
                    if (colorplataforma == 2) {
                        Sprite spritePlataformaVerde = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaVerde.getWidth(),
                                (ControlJuego.ALTO_CAMARA - regionPlataformaVerde.getHeight()) +
                                        regionPlataformaVerde.getHeight() - 600, regionPlataformaVerde);
                        Plataforma nuevoPlataformaVerde = new Plataforma();
                        nuevoPlataformaVerde.setSprite(spritePlataformaVerde);
                        nuevoPlataformaVerde.setColor(2);
                        nuevoPlataformaVerde.getSpritePlataforma().setColor(0f, 0.4f, 0f);
                        listaPlataformas.add(nuevoPlataformaVerde);
                        attachChild(nuevoPlataformaVerde.getSpritePlataforma());

                    }
                    if (colorplataforma == 3) {
                        Sprite spritePlataformaAzul = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaAzul.getWidth(),
                                (ControlJuego.ALTO_CAMARA - regionPlataformaAzul.getHeight()) +
                                        regionPlataformaAzul.getHeight() - 600, regionPlataformaAzul);
                        Plataforma nuevoPlataformaAzul = new Plataforma();
                        nuevoPlataformaAzul.setSprite(spritePlataformaAzul);
                        nuevoPlataformaAzul.setColor(3);
                        nuevoPlataformaAzul.getSpritePlataforma().setColor(0f, 0f, 0.4f);
                        listaPlataformas.add(nuevoPlataformaAzul);
                        attachChild(nuevoPlataformaAzul.getSpritePlataforma());

                    }
                }

                if (spritePlataformaEntrada.getX() + spritePlataformaEntrada.getWidth() + 80 < 0) {
                    foquinCae3 = false;
                }

                for (int i = listaPlataformas.size() - 1; i >= 0; i--) {
                    Plataforma plataforma = listaPlataformas.get(i);
                    if (perdiste == false) {
                        plataforma.mover(-8, 0);
                    }
                    if (perdiste == true) {
                        detachChild(plataforma.getSpritePlataforma());
                        listaPlataformas.remove(plataforma);
                    }
                    //agregar condicion para que foquin salte en las plataformas

                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma())) {
                        contadorcolision = 1;

                        if (spriteFoquin.getY() < 350 && spriteFoquin.getY() > 330) {
                            spriteFoquin.setPosition(spriteFoquin.getX(), 350);
                            spriteFoquinRojo.setPosition(spriteFoquinRojo.getX(), 350);
                            spriteFoquinVerde.setPosition(spriteFoquinVerde.getX(), 350);
                            spriteFoquinAzul.setPosition(spriteFoquinAzul.getX(), 350);
                        }

                    } else {
                        contadorcolision = 0;
                    }

                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinRojo.getAlpha() == 1 && plataforma.getColor() == 2) {
                        vidaFoquin = 0;
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinRojo.getAlpha() == 1 && plataforma.getColor() == 3) {
                        vidaFoquin = 0;
                    }

                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinVerde.getAlpha() == 1 && plataforma.getColor() == 1) {
                        vidaFoquin = 0;
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinVerde.getAlpha() == 1 && plataforma.getColor() == 3) {
                        vidaFoquin = 0;
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinAzul.getAlpha() == 1 && plataforma.getColor() == 1) {
                        vidaFoquin = 0;
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinAzul.getAlpha() == 1 && plataforma.getColor() == 2) {
                        vidaFoquin = 0;
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma())) {
                        plataforma.getSpritePlataforma().setColor(1f, 1f, 1f);
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma())) {
                        contadorLuz++;
                    }


                    if (plataforma.getSpritePlataforma().getX() < -plataforma.getSpritePlataforma().getWidth()) {
                        detachChild(plataforma.getSpritePlataforma());
                        listaPlataformas.remove(plataforma);
                    }
                }
            }
        }


        if (contadorcolision == 0 && foquinCae3 == false) {
            spriteFoquin.setPosition(spriteFoquin.getX(), spriteFoquin.getY() - 12);
            spriteFoquinRojo.setPosition(spriteFoquinRojo.getX(), spriteFoquinRojo.getY() - 12);
            spriteFoquinVerde.setPosition(spriteFoquinVerde.getX(), spriteFoquinVerde.getY() - 12);
            spriteFoquinAzul.setPosition(spriteFoquinAzul.getX(), spriteFoquinAzul.getY() - 12);
        }
        //luces
        if(contadorLuz==50){
            spriteLuzF1.setAlpha(1);
        }
        if(contadorLuz==100){
            spriteLuzF2.setAlpha(1);
        }
        if(contadorLuz==150){
            spriteLuzF3.setAlpha(1);
        }
        if(contadorLuz==200){
            spriteLuzF4.setAlpha(1);
        }
        if(contadorLuz==250){
            spriteLuzF5.setAlpha(1);
        }
        if(contadorLuz==300){
            spriteLuzF6.setAlpha(1);
        }
        if(contadorLuz==350){
            spriteLuzF7.setAlpha(1);
        }
        if(contadorLuz==400){
            spriteLuzF8.setAlpha(1);
        }

        //si la vida de foquin es 0 pierdes
        if (vidaFoquin == 0 && spriteFoquinRojo.getAlpha()==1) {
            spriteFoquinCaeRojo.setAlpha(1);
            perdiste=true;
            spritePantallaPerdiste.setAlpha(1);
            spriteFoquin.setAlpha(0);
            spriteFoquinRojo.setAlpha(0);
            spriteFoquinVerde.setAlpha(0);
            spriteFoquinAzul.setAlpha(0);
            spriteFoquin.setPosition(-300, -300);
            spriteFoquinRojo.setPosition(-300,-300);
            spriteFoquinVerde.setPosition(-300,-300);
            spriteFoquinAzul.setPosition(-300,-300);
        }
        if (vidaFoquin == 0 && spriteFoquinVerde.getAlpha()==1) {
            spriteFoquinCaeVerde.setAlpha(1);
            perdiste=true;
            spritePantallaPerdiste.setAlpha(1);
            spriteFoquin.setAlpha(0);
            spriteFoquinRojo.setAlpha(0);
            spriteFoquinVerde.setAlpha(0);
            spriteFoquinAzul.setAlpha(0);
            spriteFoquin.setPosition(-300, -300);
            spriteFoquinRojo.setPosition(-300,-300);
            spriteFoquinVerde.setPosition(-300,-300);
            spriteFoquinAzul.setPosition(-300,-300);
        }
        if (vidaFoquin == 0 && spriteFoquinAzul.getAlpha()==1) {
            spriteFoquinCaeAzul.setAlpha(1);
            perdiste=true;
            spritePantallaPerdiste.setAlpha(1);
            spriteFoquin.setAlpha(0);
            spriteFoquinRojo.setAlpha(0);
            spriteFoquinVerde.setAlpha(0);
            spriteFoquinAzul.setAlpha(0);
            spriteFoquin.setPosition(-300, -300);
            spriteFoquinRojo.setPosition(-300,-300);
            spriteFoquinVerde.setPosition(-300,-300);
            spriteFoquinAzul.setPosition(-300,-300);
        }
        if(perdiste==true &&spriteFoquinCaeRojo.getAlpha()==1){
            spriteFoquinCaeRojo.setPosition(spriteFoquinCaeRojo.getX(), spriteFoquinCaeRojo.getY() -8);
            spriteFoquinCaeVerde.setPosition(spriteFoquinCaeVerde.getX(), spriteFoquinCaeVerde.getY() -8);
            spriteFoquinCaeAzul.setPosition(spriteFoquinCaeAzul.getX(), spriteFoquinCaeAzul.getY() -8);
        }
        if(perdiste==true &&spriteFoquinCaeVerde.getAlpha()==1){
            spriteFoquinCaeRojo.setPosition(spriteFoquinCaeRojo.getX(), spriteFoquinCaeRojo.getY() -8);
            spriteFoquinCaeVerde.setPosition(spriteFoquinCaeVerde.getX(), spriteFoquinCaeVerde.getY() -8);
            spriteFoquinCaeAzul.setPosition(spriteFoquinCaeAzul.getX(), spriteFoquinCaeAzul.getY() -8);
        }
        if(perdiste==true &&spriteFoquinCaeAzul.getAlpha()==1){
            spriteFoquinCaeRojo.setPosition(spriteFoquinCaeRojo.getX(), spriteFoquinCaeRojo.getY() -8);
            spriteFoquinCaeVerde.setPosition(spriteFoquinCaeVerde.getX(), spriteFoquinCaeVerde.getY() -8);
            spriteFoquinCaeAzul.setPosition(spriteFoquinCaeAzul.getX(), spriteFoquinCaeAzul.getY() -8);
        }

        if (spriteFoquin.getY() < 50) {
            spritePantallaPerdiste.setAlpha(1);
            perdiste=true;
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
        regionFondoMedio.getTexture().unload();
        regionFondoMedio=null;
        regionFondoFrente.getTexture().unload();
        regionFondoFrente=null;

        regionFoquin.getTexture().unload();
        regionFoquin=null;
        regionFoquinRojo.getTexture().unload();
        regionFoquinRojo=null;
        regionFoquinVerde.getTexture().unload();
        regionFoquinVerde=null;
        regionFoquinAzul.getTexture().unload();
        regionFoquinAzul=null;

        regionPlataformaEntrada.getTexture().unload();
        regionPlataformaEntrada=null;

        regionPantallaPerdiste.getTexture().unload();
        regionPantallaPerdiste=null;

        regionBtnRojo.getTexture().unload();
        regionBtnRojo=null;
        regionBtnVerde.getTexture().unload();
        regionBtnVerde= null;
        regionBtnAzul.getTexture().unload();
        regionBtnAzul=null;

        regionPlataformaRoja.getTexture().unload();
        regionPlataformaRoja= null;
        regionPlataformaVerde.getTexture().unload();
        regionPlataformaVerde= null;
        regionPlataformaAzul.getTexture().unload();
        regionPlataformaAzul=null;

        regionBtnPausa.getTexture().unload();
        regionBtnPausa=null;
        regionPantallaPausa.getTexture().unload();
        regionPantallaPausa=null;



    }
}

