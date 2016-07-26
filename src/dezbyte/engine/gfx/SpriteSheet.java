package dezbyte.engine.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    protected BufferedImage sheet;
    protected int           spriteSize;
    protected int           spriteCount;
    protected int           spritesInWidth;
    protected int           spritesInHeight;

    public SpriteSheet(BufferedImage sheet, int spriteSize)
    {
        this.sheet = sheet;
        this.spriteSize = spriteSize;
        this.spritesInWidth = sheet.getWidth() / spriteSize;
        this.spritesInHeight = sheet.getHeight() / spriteSize;
        this.spriteCount = this.spritesInWidth * this.spritesInHeight;
    }

    public BufferedImage getSprite(int index)
    {
        index = index % this.spriteCount;

        int x = index % this.spritesInWidth * this.spriteSize;
        int y = index / this.spritesInWidth * this.spriteSize;

        return this.sheet.getSubimage(x, y, this.spriteSize, this.spriteSize);
    }

    public int inHeight()
    {
        return this.spritesInHeight;
    }

    public int inWidth()
    {
        return this.spritesInWidth;
    }

    public int count()
    {
        return this.spriteCount;
    }

    public int size()
    {
        return this.spriteSize;
    }

}
