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
public class Creditos extends EscenaBase {
    private ITextureRegion regionFondo;
    private Sprite spriteFondo;
    private MenuScene menu;


    @Override
    public void cargarRecursos() {
        regionFondo = cargarImagen("Creditos/CREDITOS.png");

    }

    @Override
    public void crearEscena() {
        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);
        attachChild(spriteFondo);
        agregarMenu();

    }

    private void agregarMenu() {
        menu = new MenuScene(actividadJuego.camara);
        menu.setPosition(ControlJuego.ANCHO_CAMARA / 2, ControlJuego.ALTO_CAMARA / 2);


        menu.buildAnimations();
        menu.setBackgroundEnabled(false);
        setChildScene(menu);
    }

    @Override
    public void onBackKeyPressed() {
        admEscenas.crearEscenaAcercaDe();
        admEscenas.setEscena(TipoEscena.ESCENA_ACERCA_DE);
        admEscenas.liberarEscenaCreditos();

    }

    @Override
    public TipoEscena getTipoEscena() {
        return TipoEscena.ESCENA_CREDITOS;
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
