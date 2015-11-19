package mx.itesm.foquinrun;

import android.view.Menu;
import android.widget.Switch;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.JumpModifier;
import org.andengine.entity.modifier.ParallelEntityModifier;
import org.andengine.entity.scene.CameraScene;
import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;


import java.util.ArrayList;


public class EscenaJuego extends EscenaBase {
    private ITextureRegion regionAngelOff;
    private Sprite spriteAngelOff;
    private ITextureRegion regionBigBenOff;
    private Sprite spriteBigBenOff;
    private ITextureRegion regionEiffelOff;
    private Sprite spriteEiffelOff;
    private ITextureRegion regionLibertadOff;
    private Sprite spriteLibertadOff;
    private ITextureRegion regionRendentorOff;
    private Sprite spriteRendentorOff;

    private ITextureRegion regionAngelOn;
    private Sprite spriteAngelOn;
    private ITextureRegion regionBigBenOn;
    private Sprite spriteBigBenOn;
    private ITextureRegion regionEiffelOn;
    private Sprite spriteEiffelOn;
    private ITextureRegion regionLibertadOn;
    private Sprite spriteLibertadOn;
    private ITextureRegion regionRendentorOn;
    private Sprite spriteRendentorOn;

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

    private ITextureRegion regionLuzA1;
    private Sprite spriteLuzA1;
    private ITextureRegion regionLuzA2;
    private Sprite spriteLuzA2;
    private ITextureRegion regionLuzA3;
    private Sprite spriteLuzA3;
    private ITextureRegion regionLuzA4;
    private Sprite spriteLuzA4;
    private ITextureRegion regionLuzA5;
    private Sprite spriteLuzA5;
    private ITextureRegion regionLuzA6;
    private Sprite spriteLuzA6;
    private ITextureRegion regionLuzA7;
    private Sprite spriteLuzA7;
    private ITextureRegion regionLuzA8;
    private Sprite spriteLuzA8;

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
    private TiledTextureRegion regionBtnSaltar;

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
    private ITextureRegion regionPlataformaRojaChica;
    private ITextureRegion regionPlataformaVerdeChica;
    private ITextureRegion regionPlataformaAzulChica;
    private float tiempoplataformas = 0;
    private float LIMITE_TIEMPO = 1.6f;

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

    private int sumaplataforma=0;

    private CameraScene escenaPausa;
    private ITextureRegion regionPausa;
    private ITextureRegion getRegionBtnPausa;

    private boolean juegoCorriendo=true;
    private int altura=0;

    private Text txtPuntos;
    private IFont fontMonster;
    private int puntos = 0;
    private int monumento=0;
    private boolean monumentoluz=false;

    @Override
    public void cargarRecursos() {
        regionAngelOff=cargarImagen("EscenaJuego/Monumentos/angel off.png");
        regionBigBenOff=cargarImagen("EscenaJuego/Monumentos/big ben off.png");
        regionEiffelOff=cargarImagen("EscenaJuego/Monumentos/eiffel off.png");
        regionLibertadOff=cargarImagen("EscenaJuego/Monumentos/libertad off.png");
        regionRendentorOff=cargarImagen("EscenaJuego/Monumentos/redentor off.png");
        regionAngelOn=cargarImagen("EscenaJuego/Monumentos/angel on.png");
        regionBigBenOn=cargarImagen("EscenaJuego/Monumentos/big ben on.png");
        regionEiffelOn=cargarImagen("EscenaJuego/Monumentos/eiffel on.png");
        regionLibertadOn=cargarImagen("EscenaJuego/Monumentos/libertad on.png");
        regionRendentorOn=cargarImagen("EscenaJuego/Monumentos/redentor on.png");

        regionLuzF1= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente1.png");
        regionLuzF2= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente2.png");
        regionLuzF3= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente3.png");
        regionLuzF4= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente4.png");
        regionLuzF5= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente5.png");
        regionLuzF6= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente6.png");
        regionLuzF7= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente7.png");
        regionLuzF8= cargarImagen("EscenaJuego/Fondos/Luces/Frente/frente8.png");

        regionLuzA1= cargarImagen("EscenaJuego/Fondos/Luces/Atras/1.png");
        regionLuzA2= cargarImagen("EscenaJuego/Fondos/Luces/Atras/2.png");
        regionLuzA3= cargarImagen("EscenaJuego/Fondos/Luces/Atras/3.png");
        regionLuzA4= cargarImagen("EscenaJuego/Fondos/Luces/Atras/4.png");
        regionLuzA5= cargarImagen("EscenaJuego/Fondos/Luces/Atras/5.png");
        regionLuzA6= cargarImagen("EscenaJuego/Fondos/Luces/Atras/6.png");
        regionLuzA7= cargarImagen("EscenaJuego/Fondos/Luces/Atras/7.png");
        regionLuzA8= cargarImagen("EscenaJuego/Fondos/Luces/Atras/8.png");


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


        regionFoquin= cargarImagenMosaico("EscenaJuego/Foquin.png", 1000, 280, 1, 5);
        regionFoquinRojo= cargarImagenMosaico("EscenaJuego/FoquinRojo.png", 1000, 280, 1, 5);
        regionFoquinVerde=cargarImagenMosaico("EscenaJuego/FoquinVerde.png", 1000, 280, 1, 5);
        regionFoquinAzul=cargarImagenMosaico("EscenaJuego/FoquinAzul.png", 1000, 280, 1, 5);

        regionFoquinCaeRojo=cargarImagen("EscenaJuego/Perdiste/FoquinCaeRojo.png");
        regionFoquinCaeVerde=cargarImagen("EscenaJuego/Perdiste/FoquinCaeVerde.png");
        regionFoquinCaeAzul=cargarImagen("EscenaJuego/Perdiste/FoquinCaeAzul.png");

        regionBtnRojo= cargarImagenMosaico("EscenaJuego/Botones/botonRojo.png", 240, 120, 1, 2);
        regionBtnVerde= cargarImagenMosaico("EscenaJuego/Botones/botonVerde.png", 240, 120, 1, 2);
        regionBtnAzul= cargarImagenMosaico("EscenaJuego/Botones/botonAzul.png", 240, 120, 1, 2);
        regionBtnSaltar=cargarImagenMosaico("EscenaJuego/Botones/botonSaltar.png", 240, 120, 1, 2);



        regionPlataformaRoja= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaRojaPrendida.png");
        regionPlataformaVerde= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaVerdePrendida.png");
        regionPlataformaAzul= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaAzulPrendida.png");
        regionPlataformaRojaChica= cargarImagen("EscenaJuego/Botones/Plataformas/plataformarojachica.png");
        regionPlataformaVerdeChica= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaverdechica.png");
        regionPlataformaAzulChica= cargarImagen("EscenaJuego/Botones/Plataformas/plataformaroazulchica.png");

        regionPlataformaEntrada=cargarImagen("EscenaJuego/Botones/Plataformas/plataformaEntrada.png");

        regionBtnPausa= cargarImagen("EscenaJuego/Botones/BotonPausa.png");
        regionBtnMenu= cargarImagen("EscenaJuego/Perdiste/Menu_neon.png");
        regionBtnVolveraJugar= cargarImagen("EscenaJuego/Perdiste/Volver_A_Jugar_neon.png");


        regionPantallaPausa= cargarImagen("EsenaPausa/fondo_pausa.png");

        regionPausa= cargarImagen("EsenaPausa/fondo_pausa.png");

        fontMonster = cargarFont("fonts/monster.ttf", 64, 0xFFFFFF00, "0123456789");



    }

    @Override
    public void crearEscena() {


        Sprite btnPausa = new Sprite(regionBtnPausa.getWidth(), ControlJuego.ALTO_CAMARA - regionBtnPausa.getHeight(),
                regionBtnPausa, actividadJuego.getVertexBufferObjectManager()) {
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    pausarJuego();
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        attachChild(btnPausa);
        registerTouchArea(btnPausa);

        spriteLuzF1=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF1);
        spriteLuzF2=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF2);
        spriteLuzF3=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF3);
        spriteLuzF4=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF4);
        spriteLuzF5=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF5);
        spriteLuzF6=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF6);
        spriteLuzF7=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF7);
        spriteLuzF8=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLuzF8);

        spriteLuzA1=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA/ 2+150, regionLuzA1);
        spriteLuzA2=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA/ 2+150, regionLuzA2);
        spriteLuzA3=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA/ 2+150, regionLuzA3);
        spriteLuzA4=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA/ 2+150, regionLuzA4);
        spriteLuzA5=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA/ 2+150, regionLuzA5);
        spriteLuzA6=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA/ 2+150, regionLuzA6);
        spriteLuzA7=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA/ 2+150, regionLuzA7);
        spriteLuzA8=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA/ 2+150, regionLuzA8);

        spriteAngelOff=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionAngelOff);
        spriteAngelOn=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionAngelOn);
        spriteBigBenOff=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionBigBenOff);
        spriteBigBenOn=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionBigBenOn);
        spriteEiffelOff=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionEiffelOff);
        spriteEiffelOn=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionEiffelOn);
        spriteLibertadOff=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLibertadOff);
        spriteLibertadOn=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionLibertadOn);
        spriteRendentorOff=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionRendentorOff);
        spriteRendentorOn=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionRendentorOn);

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


        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteLuzA1));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteLuzA2));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteLuzA3));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteLuzA4));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteLuzA5));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteLuzA6));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteLuzA7));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteLuzA8));

        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10, spriteAngelOff));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10, spriteAngelOn));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10, spriteBigBenOff));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10, spriteBigBenOn));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10, spriteEiffelOff));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10, spriteEiffelOn));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10, spriteRendentorOff));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10, spriteRendentorOn));


        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteFondoFrente));

        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF1));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF2));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF3));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF4));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF5));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF6));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF7));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-5, spriteLuzF8));

        spriteAngelOff.setAlpha(1);
        spriteAngelOn.setAlpha(0);
        spriteBigBenOff.setAlpha(0);
        spriteBigBenOn.setAlpha(0);
        spriteEiffelOff.setAlpha(0);
        spriteEiffelOn.setAlpha(0);
        spriteRendentorOff.setAlpha(0);
        spriteRendentorOn.setAlpha(0);

        spriteLuzF1.setAlpha(0);
        spriteLuzF2.setAlpha(0);
        spriteLuzF3.setAlpha(0);
        spriteLuzF4.setAlpha(0);
        spriteLuzF5.setAlpha(0);
        spriteLuzF6.setAlpha(0);
        spriteLuzF7.setAlpha(0);
        spriteLuzF8.setAlpha(0);
        spriteLuzA1.setAlpha(0);
        spriteLuzA2.setAlpha(0);
        spriteLuzA3.setAlpha(0);
        spriteLuzA4.setAlpha(0);
        spriteLuzA5.setAlpha(0);
        spriteLuzA6.setAlpha(0);
        spriteLuzA7.setAlpha(0);
        spriteLuzA8.setAlpha(0);

        //CUENTA REGRESIVA
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

        ButtonSprite btnSaltar = new ButtonSprite(0, 0, regionBtnSaltar, actividadJuego.getVertexBufferObjectManager()) {
            @Override
            public boolean onAreaTouched(TouchEvent event, float x, float y) {
                if (spriteFoquin.getY()==350 +altura) {
                    foquinSalta=true;

                    JumpModifier salto = new JumpModifier(1, spriteFoquin.getX(), spriteFoquin.getX(),
                            spriteFoquin.getY(), spriteFoquin.getY(), -250);
                    spriteFoquin.registerEntityModifier(salto);
                    JumpModifier saltoRojo = new JumpModifier(1, spriteFoquinRojo.getX(), spriteFoquinRojo.getX(),
                            spriteFoquinRojo.getY(), spriteFoquinRojo.getY(), -250);
                    spriteFoquinRojo.registerEntityModifier(saltoRojo);
                    JumpModifier saltoVerde = new JumpModifier(1, spriteFoquinVerde.getX(), spriteFoquinVerde.getX(),
                            spriteFoquinVerde.getY(), spriteFoquinVerde.getY(), -250);
                    spriteFoquinVerde.registerEntityModifier(saltoVerde);
                    JumpModifier saltoAzul = new JumpModifier(1, spriteFoquinAzul.getX(), spriteFoquinAzul.getX(),
                            spriteFoquinAzul.getY(), spriteFoquinAzul.getY(), -250);
                    spriteFoquinAzul.registerEntityModifier(saltoAzul);
                }
                return super.onAreaTouched(event, x, y);
            }
        };

            ButtonSprite btnRojo = new ButtonSprite(0, 0, regionBtnRojo, actividadJuego.getVertexBufferObjectManager()) {
                @Override
                public boolean onAreaTouched(TouchEvent event, float x, float y) {
                    if (spriteFoquin.getY()==350 +altura) {
                        foquinSalta=true;
                        spriteFoquin.setAlpha(0);
                        spriteFoquinRojo.setAlpha(1);
                        spriteFoquinVerde.setAlpha(0);
                        spriteFoquinAzul.setAlpha(0);
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
                    if (spriteFoquin.getY() == 350 +altura) {
                        spriteFoquin.setAlpha(0);
                        spriteFoquinRojo.setAlpha(0);
                        spriteFoquinVerde.setAlpha(1);
                        spriteFoquinAzul.setAlpha(0);
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
                    if (spriteFoquin.getY() == 350 +altura) {//usar variable extra para compensar altruas de foquin
                        spriteFoquin.setAlpha(0);
                        spriteFoquinRojo.setAlpha(0);
                        spriteFoquinVerde.setAlpha(0);
                        spriteFoquinAzul.setAlpha(1);
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

            registerTouchArea(btnSaltar);
            attachChild(btnSaltar);
            btnSaltar.setPosition(130,130);
            btnSaltar.setScale(2);



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
        agregarTextoPuntos();
    }

    private void agregarTextoPuntos() {
        txtPuntos=new Text(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2,
                fontMonster,"0          ",actividadJuego.getVertexBufferObjectManager());
        attachChild(txtPuntos);
        txtPuntos.setAlpha(0);
        txtPuntos.setPosition(740,275);

    }

    private void pausarJuego() {
        if (juegoCorriendo) {
            setChildScene(escenaPausa,false,true,false);
            juegoCorriendo = false;
        } else {
            clearChildScene();
            juegoCorriendo = true;
        }
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
        actulizarPuntos();
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

                int colorplataforma =(int) (Math.floor(Math.random() * (6 - 1 + 1)) + 1);

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
                    if (colorplataforma == 4) {
                        Sprite spritePlataformaRoja = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaRoja.getWidth(),
                                (ControlJuego.ALTO_CAMARA - regionPlataformaRoja.getHeight()) +
                                        regionPlataformaRoja.getHeight() -400, regionPlataformaRoja);
                        Plataforma nuevoPlataformaRoja = new Plataforma();
                        nuevoPlataformaRoja.setSprite(spritePlataformaRoja);
                        nuevoPlataformaRoja.setColor(1);
                        nuevoPlataformaRoja.setAltura(1);
                        nuevoPlataformaRoja.getSpritePlataforma().setColor(0.4f, 0f, 0f);
                        listaPlataformas.add(nuevoPlataformaRoja);
                        attachChild(nuevoPlataformaRoja.getSpritePlataforma());

                    }
                    if (colorplataforma == 5) {
                        Sprite spritePlataformaVerde = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaVerde.getWidth(),
                                (ControlJuego.ALTO_CAMARA - regionPlataformaVerde.getHeight()) +
                                        regionPlataformaVerde.getHeight() - 400, regionPlataformaVerde);
                        Plataforma nuevoPlataformaVerde = new Plataforma();
                        nuevoPlataformaVerde.setSprite(spritePlataformaVerde);
                        nuevoPlataformaVerde.setColor(2);
                        nuevoPlataformaVerde.setAltura(1);
                        nuevoPlataformaVerde.getSpritePlataforma().setColor(0f, 0.4f, 0f);
                        listaPlataformas.add(nuevoPlataformaVerde);
                        attachChild(nuevoPlataformaVerde.getSpritePlataforma());

                    }
                    if (colorplataforma == 6) {
                        Sprite spritePlataformaAzul = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaAzul.getWidth(),
                                (ControlJuego.ALTO_CAMARA - regionPlataformaAzul.getHeight()) +
                                        regionPlataformaAzul.getHeight() - 400, regionPlataformaAzul);
                        Plataforma nuevoPlataformaAzul = new Plataforma();
                        nuevoPlataformaAzul.setSprite(spritePlataformaAzul);
                        nuevoPlataformaAzul.setColor(3);
                        nuevoPlataformaAzul.setAltura(1);
                        nuevoPlataformaAzul.getSpritePlataforma().setColor(0f, 0f, 0.4f);
                        listaPlataformas.add(nuevoPlataformaAzul);
                        attachChild(nuevoPlataformaAzul.getSpritePlataforma());

                    }
                    if (colorplataforma == 7) {
                        Sprite spritePlataformaRojaChica = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaRojaChica.getWidth(),
                                (ControlJuego.ALTO_CAMARA - regionPlataformaRojaChica.getHeight()) +
                                        regionPlataformaRojaChica.getHeight() - 600, regionPlataformaRojaChica);
                        Plataforma nuevoPlataformaRojaChica = new Plataforma();
                        nuevoPlataformaRojaChica.setSprite(spritePlataformaRojaChica);
                        nuevoPlataformaRojaChica.setColor(1);
                        nuevoPlataformaRojaChica.getSpritePlataforma().setColor(0.4f, 0f, 0f);
                        listaPlataformas.add(nuevoPlataformaRojaChica);
                        attachChild(nuevoPlataformaRojaChica.getSpritePlataforma());

                    }
                    if (colorplataforma == 8) {
                        Sprite spritePlataformaVerdeChica = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaVerdeChica.getWidth(),
                                (ControlJuego.ALTO_CAMARA - regionPlataformaVerdeChica.getHeight()) +
                                        regionPlataformaVerdeChica.getHeight() - 600, regionPlataformaVerdeChica);
                        Plataforma nuevoPlataformaVerdeChica = new Plataforma();
                        nuevoPlataformaVerdeChica.setSprite(spritePlataformaVerdeChica);
                        nuevoPlataformaVerdeChica.setColor(2);
                        nuevoPlataformaVerdeChica.getSpritePlataforma().setColor(0f, 0.4f, 0f);
                        listaPlataformas.add(nuevoPlataformaVerdeChica);
                        attachChild(nuevoPlataformaVerdeChica.getSpritePlataforma());

                    }
                    if (colorplataforma == 9) {
                        Sprite spritePlataformaAzulChica = cargarSprite(ControlJuego.ANCHO_CAMARA + regionPlataformaAzulChica.getWidth(),
                                (ControlJuego.ALTO_CAMARA - regionPlataformaAzulChica.getHeight()) +
                                        regionPlataformaAzulChica.getHeight() - 600, regionPlataformaAzulChica);
                        Plataforma nuevoPlataformaAzulChica = new Plataforma();
                        nuevoPlataformaAzulChica.setSprite(spritePlataformaAzulChica);
                        nuevoPlataformaAzulChica.setColor(3);
                        nuevoPlataformaAzulChica.getSpritePlataforma().setColor(0f, 0f, 0.4f);
                        listaPlataformas.add(nuevoPlataformaAzulChica);
                        attachChild(nuevoPlataformaAzulChica.getSpritePlataforma());

                    }
                }

                if (spritePlataformaEntrada.getX() + spritePlataformaEntrada.getWidth() + 80 < 0) {
                    foquinCae3 = false;
                }

                for (int i = listaPlataformas.size() - 1; i >= 0; i--) {
                    Plataforma plataforma = listaPlataformas.get(i);
                    if (perdiste == false) {
                        plataforma.mover(-9, 0);
                    }
                    if (perdiste == true) {
                        detachChild(plataforma.getSpritePlataforma());
                        listaPlataformas.remove(plataforma);
                    }
                    //agregar condicion para que foquin salte en las plataformas

                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma())) {
                        contadorcolision = 1;
                        if(spriteFoquin.collidesWith(plataforma.getSpritePlataforma())&&
                                plataforma.getAltura()==0 &&spriteFoquin.getY()>330) {

                            spriteFoquin.setPosition(spriteFoquin.getX(), 350);
                            spriteFoquinRojo.setPosition(spriteFoquinRojo.getX(), 350);
                            spriteFoquinVerde.setPosition(spriteFoquinVerde.getX(), 350);
                            spriteFoquinAzul.setPosition(spriteFoquinAzul.getX(), 350);
                            altura=0;
                        }
                        //arreglar para que foquin caiga de las  plataforma de arriba !!
                        if(spriteFoquin.collidesWith(plataforma.getSpritePlataforma())&&
                                plataforma.getAltura()==1 && spriteFoquin.getY()>330) {

                            spriteFoquin.setPosition(spriteFoquin.getX(), 550);
                            spriteFoquinRojo.setPosition(spriteFoquinRojo.getX(), 550);
                            spriteFoquinVerde.setPosition(spriteFoquinVerde.getX(), 550);
                            spriteFoquinAzul.setPosition(spriteFoquinAzul.getX(), 550);
                            altura=200;
                        }
                    }
                    else {
                        contadorcolision = 0;
                    }


                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinRojo.getAlpha() == 1 && plataforma.getColor() == 2 && foquinColor==0) {
                        vidaFoquin = 0;
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinRojo.getAlpha() == 1 && plataforma.getColor() == 3 && foquinColor==0) {
                        vidaFoquin = 0;
                    }

                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinVerde.getAlpha() == 1 && plataforma.getColor() == 1&& foquinColor==0) {
                        vidaFoquin = 0;
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinVerde.getAlpha() == 1 && plataforma.getColor() == 3&& foquinColor==0) {
                        vidaFoquin = 0;
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinAzul.getAlpha() == 1 && plataforma.getColor() == 1&& foquinColor==0) {
                        vidaFoquin = 0;
                    }
                    if (spriteFoquin.collidesWith(plataforma.getSpritePlataforma()) &&
                            spriteFoquinAzul.getAlpha() == 1 && plataforma.getColor() == 2&& foquinColor==0) {
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

        if (contadorTiempo>350 && perdiste==false){
            puntos=puntos+1;
        }
        if(perdiste==true){
            txtPuntos.setAlpha(1);
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
        if(contadorLuz==450){
            spriteLuzA1.setAlpha(1);
        }
        if(contadorLuz==500){
            spriteLuzA2.setAlpha(1);
        }
        if(contadorLuz==550){
            spriteLuzA3.setAlpha(1);
        }
        if(contadorLuz==600){
            spriteLuzA4.setAlpha(1);
        }
        if(contadorLuz==650){
            spriteLuzA5.setAlpha(1);
        }
        if(contadorLuz==700){
            spriteLuzA6.setAlpha(1);
        }
        if(contadorLuz==750){
            spriteLuzA7.setAlpha(1);
        }
        if(contadorLuz==800){
            spriteLuzA8.setAlpha(1);
            monumento++;
        }

        //monumentos

        if(contadorLuz==900){
            monumento++;
            contadorLuz=0;
            spriteLuzF1.setAlpha(0);
            spriteLuzF2.setAlpha(0);
            spriteLuzF3.setAlpha(0);
            spriteLuzF4.setAlpha(0);
            spriteLuzF5.setAlpha(0);
            spriteLuzF6.setAlpha(0);
            spriteLuzF7.setAlpha(0);
            spriteLuzF8.setAlpha(0);
            spriteLuzA1.setAlpha(0);
            spriteLuzA2.setAlpha(0);
            spriteLuzA3.setAlpha(0);
            spriteLuzA4.setAlpha(0);
            spriteLuzA5.setAlpha(0);
            spriteLuzA6.setAlpha(0);
            spriteLuzA7.setAlpha(0);
            spriteLuzA8.setAlpha(0);
        }
        if(monumento==1){
            spriteAngelOn.setAlpha(1);
            spriteAngelOff.setAlpha(0);
        }
        if(monumento==2){
            spriteAngelOn.setAlpha(0);
            spriteBigBenOff.setAlpha(1);
        }
        if(monumento==3){
            spriteBigBenOff.setAlpha(0);
            spriteBigBenOn.setAlpha(1);
        }
        if(monumento==4){
            spriteBigBenOn.setAlpha(0);
            spriteEiffelOff.setAlpha(1);
        }
        if(monumento==5){
            spriteEiffelOff.setAlpha(0);
            spriteEiffelOn.setAlpha(1);
        }
        if(monumento==6){
            spriteEiffelOn.setAlpha(0);
            spriteLibertadOff.setAlpha(1);
        }
        if(monumento==7){
            spriteLibertadOff.setAlpha(0);
            spriteLibertadOn.setAlpha(1);
        }
        if(monumento==8){
            spriteLibertadOn.setAlpha(0);
            spriteRendentorOff.setAlpha(1);
        }
        if(monumento==9){
            spriteRendentorOff.setAlpha(0);
            spriteRendentorOn.setAlpha(1);
        }
        if(monumento==10){
            monumento=0;
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
            spriteFoquinRojo.setPosition(-300, -300);
            spriteFoquinVerde.setPosition(-300, -300);
            spriteFoquinAzul.setPosition(-300, -300);
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
            spriteFoquinRojo.setPosition(-300, -300);
            spriteFoquinVerde.setPosition(-300, -300);
            spriteFoquinAzul.setPosition(-300, -300);
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
            spriteFoquinRojo.setPosition(-300, -300);
            spriteFoquinVerde.setPosition(-300, -300);
            spriteFoquinAzul.setPosition(-300, -300);
        }
        //animacion de Foquin cayendo
        if(perdiste == true && spriteFoquinCaeRojo.getAlpha() == 1) {
            spriteFoquinCaeRojo.setPosition(spriteFoquinCaeRojo.getX(), spriteFoquinCaeRojo.getY() - 8);
            spriteFoquinCaeVerde.setPosition(spriteFoquinCaeVerde.getX(), spriteFoquinCaeVerde.getY() - 8);
            spriteFoquinCaeAzul.setPosition(spriteFoquinCaeAzul.getX(), spriteFoquinCaeAzul.getY() - 8);
        }
        if(perdiste==true &&spriteFoquinCaeVerde.getAlpha()==1){
            spriteFoquinCaeRojo.setPosition(spriteFoquinCaeRojo.getX(), spriteFoquinCaeRojo.getY() - 8);
            spriteFoquinCaeVerde.setPosition(spriteFoquinCaeVerde.getX(), spriteFoquinCaeVerde.getY() - 8);
            spriteFoquinCaeAzul.setPosition(spriteFoquinCaeAzul.getX(), spriteFoquinCaeAzul.getY() - 8);
        }
        if(perdiste==true &&spriteFoquinCaeAzul.getAlpha()==1){
            spriteFoquinCaeRojo.setPosition(spriteFoquinCaeRojo.getX(), spriteFoquinCaeRojo.getY() - 8);
            spriteFoquinCaeVerde.setPosition(spriteFoquinCaeVerde.getX(), spriteFoquinCaeVerde.getY() - 8);
            spriteFoquinCaeAzul.setPosition(spriteFoquinCaeAzul.getX(), spriteFoquinCaeAzul.getY() - 8);
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

    private void actulizarPuntos() {
        txtPuntos.setText(""+puntos);
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
        regionPlataformaRojaChica.getTexture().unload();
        regionPlataformaRojaChica= null;
        regionPlataformaVerdeChica.getTexture().unload();
        regionPlataformaVerdeChica= null;
        regionPlataformaAzulChica.getTexture().unload();
        regionPlataformaAzulChica=null;

        regionBtnPausa.getTexture().unload();
        regionBtnPausa=null;
        regionPantallaPausa.getTexture().unload();
        regionPantallaPausa=null;

        regionLuzA1.getTexture().unload();
        regionLuzA1=null;
        regionLuzA2.getTexture().unload();
        regionLuzA2=null;
        regionLuzA3.getTexture().unload();
        regionLuzA3=null;
        regionLuzA4.getTexture().unload();
        regionLuzA4=null;
        regionLuzA5.getTexture().unload();
        regionLuzA5=null;
        regionLuzA6.getTexture().unload();
        regionLuzA6=null;
        regionLuzA7.getTexture().unload();
        regionLuzA7=null;
        regionLuzA8.getTexture().unload();
        regionLuzA8=null;
        regionLuzF1.getTexture().unload();
        regionLuzF1=null;
        regionLuzF2.getTexture().unload();
        regionLuzF2=null;
        regionLuzF3.getTexture().unload();
        regionLuzF3=null;
        regionLuzF4.getTexture().unload();
        regionLuzF4=null;
        regionLuzF5.getTexture().unload();
        regionLuzF5=null;
        regionLuzF6.getTexture().unload();
        regionLuzF6=null;
        regionLuzF7.getTexture().unload();
        regionLuzF7=null;
        regionLuzF8.getTexture().unload();
        regionLuzF8=null;
        regionAngelOff.getTexture().unload();
        regionAngelOff=null;
        regionAngelOn.getTexture().unload();
        regionAngelOn=null;
        regionBigBenOff.getTexture().unload();
        regionBigBenOff=null;
        regionBigBenOn.getTexture().unload();
        regionBigBenOn=null;
        regionEiffelOff.getTexture().unload();
        regionEiffelOff=null;
        regionEiffelOn.getTexture().unload();
        regionEiffelOn=null;
        regionLibertadOff.getTexture().unload();
        regionLibertadOff=null;
        regionLibertadOn.getTexture().unload();
        regionLibertadOn=null;
        regionRendentorOff.getTexture().unload();
        regionRendentorOff=null;
        regionRendentorOn.getTexture().unload();
        regionRendentorOn=null;

    }
}

