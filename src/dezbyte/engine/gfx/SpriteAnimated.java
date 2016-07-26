package dezbyte.engine.gfx;

import dezbyte.engine.helpers.Time;

import java.awt.*;

public class SpriteAnimated {

    protected Sprite[]    sprites;
    protected SpriteSheet sheet;
    protected int         scale;
    protected int         lastIndex;
    protected int         speedAnimation;
    protected long        lastTimeUpdate;

    public SpriteAnimated(SpriteSheet sheet, int speedAnimation, int scale)
    {
        this(sheet, speedAnimation, scale, 0, sheet.size());
    }

    public SpriteAnimated(SpriteSheet sheet, int speedAnimation, int scale, int startIndex, int lastIndex)
    {
        this.sheet = sheet;
        this.scale = scale;
        this.lastTimeUpdate = Time.nano();
        this.lastIndex = 0;
        this.speedAnimation = speedAnimation;
        this.sprites = new Sprite[lastIndex - startIndex];
        this.loadSprites(startIndex, lastIndex);
    }

    protected void loadSprites(int startIndex, int lastIndex)
    {
        int count = 0;
        for (int i = startIndex; i < lastIndex; i++) {
            this.sprites[count++] = new Sprite(this.sheet, this.scale, i);
        }
    }

    public void nextIndex()
    {
        long elapsedTime = Time.nano() - this.lastTimeUpdate;

        if ((elapsedTime / (Time.ONE_NANO_SECOND / speedAnimation)) >= 1) {
            this.lastTimeUpdate = Time.nano();
            this.lastIndex = (this.lastIndex + 1) % this.sprites.length;
        }
    }

    public Sprite getSprite()
    {
        this.nextIndex();
        return this.sprites[this.lastIndex];
    }

    public void draw(Graphics graphics, int x, int y)
    {
        this.getSprite().draw(graphics, x, y);
    }

}
