package mx.itesm.foquinrun;

import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

/**
 * Created by rmroman on 11/09/15.
 */
public class EscenaAcercaDe extends EscenaBase
{

    private ITextureRegion regionFondo;
    private ITextureRegion regionFondoMedio;
    private ITextureRegion regionFondoFrente;
    private ITextureRegion regionFondoMedioLuz;
    private ITextureRegion regionFondoFrenteLuz;

    private Sprite spriteFondo;
    private Sprite spriteFondoMedio;
    private Sprite spriteFondoFrente;
    private Sprite spriteFondoMedioLuz;
    private Sprite spriteFondoFrenteLuz;

    private MenuScene menu;

    private ITextureRegion regionHistoria;
    private ITextureRegion regionCreditos;

    private AnimatedSprite spriteHistoria;
    private AnimatedSprite spriteCreditos;

    private TiledTextureRegion regionBtnHistoria;
    private TiledTextureRegion regionBtnCreditos;

    private final int OPCION_HISTORIA = 0;
    private final int OPCION_CREDITOS=1;

    private ITextureRegion regionLuna;
    private Sprite spriteLuna;

    @Override
    public void cargarRecursos() {
        regionFondo = cargarImagen("EscenaJuego/Fondos/cielo 2.png");
        regionFondoMedio= cargarImagen("EscenaJuego/Fondos/edificio_atras_1.png");
        regionFondoFrente= cargarImagen("EscenaJuego/Fondos/escenario_frente_1.png");
        regionFondoMedioLuz=cargarImagen("EscenaAcercaDe/Luces/1escenarioAtras_11.png");
        regionFondoFrenteLuz=cargarImagen("EscenaAcercaDe/Luces/1escenariofrente_9.png");

        regionHistoria= cargarImagen("EscenaAcercaDe/boton.png");
        regionCreditos = cargarImagen("EscenaAcercaDe/boton.png");

        regionBtnCreditos= cargarImagenMosaico("EscenaAcercaDe/creditos.png", 934, 145, 1, 2);
        regionBtnHistoria= cargarImagenMosaico("EscenaAcercaDe/Historia.png", 934, 145, 1, 2);

        regionLuna=cargarImagen("boton.png");
    }

    @Override
    public void crearEscena() {


        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);
        spriteFondoMedio=cargarSprite(ControlJuego.ALTO_CAMARA/2,ControlJuego.ALTO_CAMARA/2,regionFondoMedio);
        spriteFondoMedioLuz=cargarSprite(ControlJuego.ALTO_CAMARA/2,ControlJuego.ALTO_CAMARA/2,regionFondoMedioLuz);
        spriteFondoFrente=cargarSprite(ControlJuego.ALTO_CAMARA/2,ControlJuego.ALTO_CAMARA/2-250,regionFondoFrente);
        spriteFondoFrenteLuz=cargarSprite(ControlJuego.ALTO_CAMARA/2,ControlJuego.ALTO_CAMARA/2-250,regionFondoFrenteLuz);

        AutoParallaxBackground fondoAnimado = new AutoParallaxBackground(1, 1, 1, 5);
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-2, spriteFondo));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3,spriteFondoMedio));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3,spriteFondoMedioLuz));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3,spriteFondoFrente));
        fondoAnimado.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3, spriteFondoFrenteLuz));
        setBackground(fondoAnimado);

        agregarMenu();

        spriteHistoria = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionBtnHistoria,
                actividadJuego.getVertexBufferObjectManager());
        spriteHistoria.animate(250);
        attachChild(spriteHistoria);
        spriteHistoria.setPosition(640, 450);

        spriteCreditos = new AnimatedSprite(ControlJuego.ALTO_CAMARA / 2,
                ControlJuego.ALTO_CAMARA / 2, regionBtnCreditos,
                actividadJuego.getVertexBufferObjectManager());
        spriteCreditos.animate(250);
        attachChild(spriteCreditos);
        spriteCreditos.setPosition(640, 100);


        spriteLuna=cargarSprite(ControlJuego.ANCHO_CAMARA/2+1200,ControlJuego.ALTO_CAMARA/2+300, regionLuna);
        attachChild(spriteLuna);


    }
    private void agregarMenu() {
        menu = new MenuScene(actividadJuego.camara);
        menu.setPosition(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2);

        IMenuItem opcionHistoria = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_HISTORIA,
                regionHistoria, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionCreditos = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_CREDITOS,
                regionCreditos, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        opcionCreditos.setAlpha(0);
        opcionHistoria.setAlpha(0);

        menu.addMenuItem(opcionHistoria);
        menu.addMenuItem(opcionCreditos);

        menu.buildAnimations();
        menu.setBackgroundEnabled(false);


        opcionHistoria.setPosition(0,50);
        opcionCreditos.setPosition(0,-300);


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
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);
            spriteLuna.setPosition(spriteLuna.getX() - 1, spriteLuna.getY());
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