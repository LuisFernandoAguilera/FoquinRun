package mx.itesm.foquinrun;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.util.GLState;
/**
 * Created by LuisFernandoAguileraCrivelli1 on 08/10/15.
 */
public class EscenaPausa extends EscenaBase{
    private ITextureRegion regionFondo;

    private ITextureRegion regionMenu;
    private ITextureRegion regionReanudar;

    private ITextureRegion regionSonido;
    private ITextureRegion regionMusica;

    private Sprite spriteFondo;
    private Sprite spriteMenu;
    private Sprite spriteRenudar;
    private Sprite spriteSonido;
    private Sprite spriteMusica;

    private MenuScene menu;

    private final int OPCION_MENU=0;
    private final int OPCION_RENUDAR=1;

    private final int OPCION_SONIDO=2;
    private final int OPCION_MUSICA=3;


    @Override
    public void cargarRecursos() {
        regionFondo=cargarImagen("EsenaPausa/fondo_pausa.png");

        regionMenu=cargarImagen("EsenaPausa/Menu.png");
        regionReanudar=cargarImagen("EsenaPausa/Reanudar.png");

        regionMusica=cargarImagen("EsenaPausa/MUSICA.png");
        regionSonido=cargarImagen("EsenaPausa/SONIDO.png");
    }

    @Override
    public void crearEscena() {
        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2, regionFondo);
        SpriteBackground fondo = new SpriteBackground(1,1,1,spriteFondo);
        setBackground(fondo);
        setBackgroundEnabled(true);

        agregarMenu();

    }

    private void agregarMenu() {
        menu = new MenuScene(actividadJuego.camara);
        menu.setPosition(ControlJuego.ANCHO_CAMARA/2,ControlJuego.ALTO_CAMARA/2);

        IMenuItem opcionMenu = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_MENU,
                regionMenu, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionReanudar = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_RENUDAR,
                regionReanudar, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);

        IMenuItem opcionMusica = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_MUSICA,
                regionMusica, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);
        IMenuItem opcionSonido = new ScaleMenuItemDecorator(new SpriteMenuItem(OPCION_SONIDO,
                regionSonido, actividadJuego.getVertexBufferObjectManager()), 1.5f, 1);

        menu.addMenuItem(opcionMenu);
        menu.addMenuItem(opcionReanudar);
        menu.addMenuItem(opcionMusica);
        menu.addMenuItem(opcionSonido);

        opcionMenu.setPosition(200, 0);
        opcionReanudar.setPosition(-100, 0);
        opcionMusica.setPosition(-200, -100);
        opcionSonido.setPosition(-200, 100);

        menu.setOnMenuItemClickListener(new MenuScene.IOnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
                                             float pMenuItemLocalX, float pMenuItemLocalY) {

                switch (pMenuItem.getID()) {
                    case OPCION_MENU:


                        break;

                    case OPCION_RENUDAR:


                        break;

                    case OPCION_MUSICA:


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

    }

    @Override
    public TipoEscena getTipoEscena() {
        return null;
    }

    @Override
    public void liberarEscena() {

    }

    @Override
    public void liberarRecursos() {

    }
}
