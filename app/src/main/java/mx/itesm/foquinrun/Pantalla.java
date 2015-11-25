package mx.itesm.foquinrun;

import android.content.Context;
import android.content.SharedPreferences;
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
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;


import java.util.ArrayList;


public class Pantalla extends EscenaBase {


    private ITextureRegion regionFondo;
    private Sprite spriteFondo;
    private ITextureRegion regionFondoMedio;
    private Sprite spriteFondoMedio;
    private ITextureRegion regionFondoFrente;
    private Sprite spriteFondoFrente;

    private ITextureRegion regionLuzMedio;
    private Sprite spriteLuzMedio;
    private ITextureRegion regionLuzFrente;
    private Sprite spriteLuzFrente;

    private ITextureRegion regionPersonajes;
    private Sprite spritePersonajes;

    private AnimatedSprite spriteFoquin;
    private TiledTextureRegion regionFoquin;
    private AnimatedSprite spriteFoquinB;
    private TiledTextureRegion regionFoquinB;

    private ITextureRegion regionBtnJugar;
    private ITextureRegion regionBtnSonido;
    private ITextureRegion reguionBtnMusica;
    private ITextureRegion regionFlechaDerecha;
    private ITextureRegion regionFlechaIzquierda;

    private MenuScene menu;

    private final int OPCION_JUGAR = 0;
    private final int OPCION_SONIDO=1;
    private final int OCION_MUSICA=2;
    private final int OPCION_FLECHAD=3;
    private final int OPCION_FLECHAI=4;

    private ITextureRegion regionMundo;
    private Sprite spriteMundo;

    private ITextureRegion regionPuntosMax;
    private Sprite spritePuntosMax;

    private int imagen=1;

    private Text txtMarcador;
    private IFont fontMonster;



    @Override
    public void cargarRecursos() {

        regionFondo= cargarImagen("EscenaJuego/Fondos/cielo 3.png");
        regionFondoMedio= cargarImagen("EscenaJuego/Fondos/edificio_atras_1.png");
        regionFondoFrente= cargarImagen("EscenaJuego/Fondos/escenario_frente_1.png");

        regionLuzMedio=cargarImagen("EscenaAcercaDe/Luces/1escenarioAtras_11.png");
        regionLuzFrente=cargarImagen("EscenaAcercaDe/Luces/1escenariofrente_9.png");

        regionBtnJugar = cargarImagen("Menu/Play.png");

        regionBtnSonido=cargarImagen("Pantalla/Sonido.png");
        reguionBtnMusica=cargarImagen("Pantalla/Musica.png");

        regionMundo= cargarImagen("Pantalla/mundo gira sin transparencia.png");

        regionPuntosMax=cargarImagen("Pantalla/PuntosMax.png");

        regionFlechaDerecha= cargarImagen("Pantalla/flechaderecha.png");
        regionFlechaIzquierda= cargarImagen("Pantalla/flechaizquierda.png");

        regionPersonajes= cargarImagen("Pantalla/Personajes.png");

        regionFoquin= cargarImagenMosaico("EscenaJuego/FoquinAzul.png", 1000, 280, 1, 5);
        regionFoquinB= cargarImagenMosaico("Pantalla/FoquinBloqueado.png", 1000, 280, 1, 5);

        fontMonster = cargarFont("fonts/monster.ttf", 64, 0xFFFFFF00, "0123456789");

    }


    @Override
    public void crearEscena() {
        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);
        spriteFondoMedio = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2+100, regionFondoMedio);
        spriteFondoFrente = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2-70, regionFondoFrente);

        spriteLuzMedio=cargarSprite(ControlJuego.ALTO_CAMARA/2+240, ControlJuego.ALTO_CAMARA/2+100, regionLuzMedio);
        spriteLuzFrente=cargarSprite(ControlJuego.ALTO_CAMARA/2, ControlJuego.ALTO_CAMARA/2-70, regionLuzFrente);


        attachChild(spriteFondo);
        attachChild(spriteFondoMedio);
        attachChild(spriteLuzMedio);
        attachChild(spriteFondoFrente);


        spriteMundo=cargarSprite(ControlJuego.ALTO_CAMARA/2+600, ControlJuego.ALTO_CAMARA/2+100, regionMundo);
        attachChild(spriteMundo);

        spritePuntosMax=cargarSprite(ControlJuego.ALTO_CAMARA/2+600, ControlJuego.ALTO_CAMARA/2-250, regionPuntosMax);
        attachChild(spritePuntosMax);
        spritePuntosMax.setScale(1.3f);

        spritePersonajes=cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionPersonajes);
        attachChild(spritePersonajes);
        spritePersonajes.setPosition(340, 600);

        spriteFoquin = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionFoquin,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquin.animate(100);
        attachChild(spriteFoquin);
        spriteFoquin.setPosition(350, 300);
        spriteFoquinB = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionFoquinB,
                actividadJuego.getVertexBufferObjectManager());
        spriteFoquinB.animate(100);
        attachChild(spriteFoquinB);
        spriteFoquinB.setPosition(350, 300);
        spriteFoquinB.setAlpha(0);


        agregarMenu();
        agregarMarcadorAlto();
    }
    private void agregarMarcadorAlto() {
        // Obtener de las preferencias el marcador mayor
        SharedPreferences preferencias = actividadJuego.getSharedPreferences("marcadorAlto", Context.MODE_PRIVATE);
        int puntos = preferencias.getInt("puntos",0);

        txtMarcador = new Text(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA-80,
                fontMonster,""+puntos,actividadJuego.getVertexBufferObjectManager());
        attachChild(txtMarcador);
        txtMarcador.setPosition(925,105);
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
        IMenuItem opcionFlechaD = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_FLECHAD,
                regionFlechaDerecha, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionFlechaI = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_FLECHAI,
                regionFlechaIzquierda, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);

        menu.addMenuItem(opcionJugar);
        menu.addMenuItem(opcionMusica);
        menu.addMenuItem(opcionSonido);
        menu.addMenuItem(opcionFlechaD);
        menu.addMenuItem(opcionFlechaI);

        menu.buildAnimations();
        menu.setBackgroundEnabled(false);

        opcionJugar.setPosition(-300, -330);
        opcionSonido.setPosition(-550, 360);
        opcionMusica.setPosition(-460, 360);
        opcionSonido.setAlpha(0);
        opcionMusica.setAlpha(0);
        opcionFlechaD.setPosition(-100, -100);
        opcionFlechaI.setPosition(-500,-100);


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
            spriteFoquin.setAlpha(1);
            spriteFoquinB.setAlpha(0);
        }
        if(imagen==2){
            spriteFoquin.setAlpha(0);
            spriteFoquinB.setAlpha(1);
        }
        if(imagen<0){
            imagen=0;
        }
        if(imagen>2){
            imagen=2;
        }
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
