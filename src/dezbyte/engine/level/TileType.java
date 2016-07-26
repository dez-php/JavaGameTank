package dezbyte.engine.level;

public enum TileType {

    SAND(1),
    TREE(2),
    WATER(3),
    METAL(4),
    TITAN(5),
    ICE(6),
    BRICK_BROWN_X(7),
    BRICK_BROWN_Y(8),
    BRICK_BLUE_X(9),
    BRICK_BLUE_Y(10),
    EAGLE(50);

    int type;

    TileType(int type)
    {
        this.type = type;
    }

    public int type()
    {
        return this.type;
    }

    public static TileType fromType(int type)
    {
        for(TileType tileType : TileType.values()) {
            if(tileType.type() == type) {
                return tileType;
            }
        }

        return TileType.SAND;
    }

}
