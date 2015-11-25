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



/**
 * Created by LuisFernandoAguileraCrivelli1 on 25/11/15.
 */
public class Espera extends EscenaBase {

    private ITextureRegion regionEspera;
    private Sprite spriteEspera;

    private ITextureRegion regionBlanco;
    private Sprite spriteBlanco;
    private int angulo=0;
    private int tiempo=0;


    @Override
    public void cargarRecursos() {
        regionEspera=cargarImagen("Menu/espera.png");
        regionBlanco=cargarImagen("Menu/blanco.png");
    }

    @Override
    public void crearEscena() {
        spriteBlanco=cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionBlanco);
        attachChild(spriteBlanco);
        spriteBlanco.setAlpha(1);
        spriteEspera=cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionEspera);
        attachChild(spriteEspera);
        spriteEspera.setAlpha(1);

    }

    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);
        tiempo++;
        spriteEspera.setRotation(angulo);
        angulo--;
        if(angulo==-360){
            angulo=0;
        }
        if(tiempo==100){
            admEscenas.crearEscenaJuego();
            admEscenas.setEscena(TipoEscena.ESCENA_JUEGO);
            admEscenas.liberarEscenaEspera();

        }


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
        this.detachSelf();
        this.dispose();
    }

    @Override
    public void liberarRecursos() {

    }
}

