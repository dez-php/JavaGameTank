package dezbyte.tanks;

import dezbyte.engine.gfx.Sprite;
import dezbyte.engine.gfx.SpriteAnimated;
import dezbyte.engine.gfx.SpriteSheet;
import dezbyte.engine.gui.MainWindow;
import dezbyte.engine.helpers.ImageLoader;
import dezbyte.engine.level.TileType;
import dezbyte.engine.loop.Loop;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.EnumMap;
import java.util.Map;

public class GameLoop extends Loop {

    SpriteSheet    sheet;
    SpriteAnimated animated;
    SpriteAnimated animated2;
    SpriteAnimated animated3;

    SpriteAnimated explosion;

    Map<TileType, Sprite> sprites;

    int[][] map;

    public GameLoop() throws IOException, ClassNotFoundException
    {
        super("Tanks2D_Loop", new MainWindow(640, 480, "Tanks 2D"));

        BufferedImage image = new ImageLoader("resources/tileset1.png").load();
        this.sheet = new SpriteSheet(image, 32);

        this.sprites = new EnumMap<>(TileType.class);

        this.sprites.put(TileType.SAND, new Sprite(this.sheet, 1, 9));
        this.sprites.put(TileType.TREE, new Sprite(this.sheet, 1, 10));
        this.sprites.put(TileType.WATER, new Sprite(this.sheet, 1, 11));
        this.sprites.put(TileType.METAL, new Sprite(this.sheet, 1, 12));
        this.sprites.put(TileType.TITAN, new Sprite(this.sheet, 1, 28));
        this.sprites.put(TileType.ICE, new Sprite(this.sheet, 1, 8));
        this.sprites.put(TileType.BRICK_BLUE_X, new Sprite(this.sheet, 1, 20));
        this.sprites.put(TileType.BRICK_BLUE_Y, new Sprite(this.sheet, 1, 16));
        this.sprites.put(TileType.BRICK_BROWN_X, new Sprite(this.sheet, 1, 4));
        this.sprites.put(TileType.BRICK_BROWN_Y, new Sprite(this.sheet, 1, 0));
        this.sprites.put(TileType.EAGLE, new Sprite(this.sheet, 1, 24));

        this.animated = new SpriteAnimated(new SpriteSheet(new ImageLoader("resources/redtank.png").load(), 32), 10, 1, 0, 7);
        this.animated2 = new SpriteAnimated(new SpriteSheet(new ImageLoader("resources/playertank.png").load(), 32), 12, 1, 14, 21);
        this.animated3 = new SpriteAnimated(new SpriteSheet(new ImageLoader("resources/aitank.png").load(), 32), 15, 1, 21, 28);

        this.explosion = new SpriteAnimated(new SpriteSheet(new ImageLoader("resources/explosion6.png").load(), 256), 50, 1);

        File               file               = new File("resources/maps/level1.txt");
        FileOutputStream   outputStream       = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        this.map = new int[][]{
                {1, 1, 1, 1, 1, 8, 3, 3, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1,},
                {2, 1, 1, 1, 1, 8, 1, 1, 1, 2, 1, 1, 1, 1, 8, 1, 1, 1, 1, 2,},
                {2, 2, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1, 2, 2,},
                {2, 2, 1, 1, 1, 8, 1, 1, 8, 8, 8, 8, 1, 1, 8, 1, 1, 1, 2, 2,},
                {2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2,},
                {2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2,},
                {2, 2, 2, 2, 2, 1, 1, 4, 1, 1, 1, 1, 4, 1, 1, 2, 2, 2, 2, 4,},
                {2, 2, 2, 2, 2, 1, 1, 4, 1, 10, 1, 1, 4, 1, 1, 2, 2, 2, 2, 2,},
                {2, 2, 2, 2, 2, 1, 1, 4, 1, 1, 1, 1, 4, 1, 1, 2, 2, 2, 2, 2,},
                {2, 2, 2, 2, 1, 1, 1, 4, 4, 6, 6, 4, 4, 1, 1, 2, 2, 2, 2, 2,},
                {2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2,},
                {2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2,},
                {2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2,},
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 1, 1, 1, 1, 1, 1, 1, 2,},
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 10, 50, 10, 1, 1, 1, 1, 1, 1, 1, 2,},
        };

//        for (int[] rows : map) {
//            objectOutputStream.writeObject(rows);
//        }
//
//        objectOutputStream.close();
//        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));


    }

    public GameLoop(String threadName)
    {
        super(threadName);
    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void update(float elapsedTime)
    {

    }

    @Override
    protected void render()
    {
        this.mainFrame.clearFrame();

        Graphics2D g2d = this.mainFrame.getGraphics2D();

        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                Sprite tile = this.sprites.get(TileType.fromType(this.map[i][j]));
                tile.draw(g2d, j * 32, i * 32);
            }
        }

        this.animated.draw(g2d, 10, 10);
        this.animated2.draw(g2d, 600, 50);
        this.animated3.draw(g2d, 413, 232);

        this.explosion.draw(g2d, 400, 200);

        this.mainFrame.swapBuffer();
    }
}
