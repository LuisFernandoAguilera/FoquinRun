package mx.itesm.foquinrun;

import org.andengine.entity.sprite.Sprite;

/**
 * Created by LuisFernandoAguileraCrivelli1 on 06/10/15.
 */
public class Plataforma {

    private Sprite sprite;
    private int color;


    public Sprite getSpritePlataforma() {
        return sprite;
    }

    public void setSprite(Sprite spritePlataforma) {
        this.sprite = spritePlataforma;
    }

    public void mover(int dx, int dy) {
        sprite.setPosition( sprite.getX()+dx, sprite.getY()+dy );
    }

    public int getColor(){
        return color;
    }
    public void setColor(int colorPlataforma){
        this.color= colorPlataforma;
    }

}
