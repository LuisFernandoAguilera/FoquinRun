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

    @Override
    public void cargarRecursos() {

    }

    @Override
    public void crearEscena() {

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
