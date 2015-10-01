package mx.itesm.foquinrun;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;


public class EscenaJuego extends EscenaBase {

    // Regiones para imágenes
    private ITextureRegion regionFondo;
    // Sprite para el fondo
    private Sprite spriteFondo;

    private AnimatedSprite spriteFoquin;
    private TiledTextureRegion regionFoquin;

    @Override
    public void cargarRecursos() {
        regionFondo = cargarImagen("Prueba/Juego.png");

        //cargarImagenMosaico
    }

    @Override
    public void crearEscena() {
        spriteFondo = cargarSprite(ControlJuego.ANCHO_CAMARA/2, ControlJuego.ALTO_CAMARA/2, regionFondo);
        attachChild(spriteFondo);
        spriteFoquin = new AnimatedSprite(ControlJuego.ALTO_CAMARA/2,
                ControlJuego.ALTO_CAMARA/2,regionFoquin,
                actividadJuego.getVertexBufferObjectManager());


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

