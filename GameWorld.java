import greenfoot.*;

public class GameWorld extends World {
    private static final int SIZE = 4;
    private static final int TILE_SIZE = 100;
    private Tile[][] grid = new Tile[SIZE][SIZE];

    public GameWorld() {
        super(SIZE * TILE_SIZE, SIZE * TILE_SIZE, 1);
        spawnRandomTile();
        spawnRandomTile();
    }

    public void act() {
        if (Greenfoot.isKeyDown("left")) {
            moveLeft();
            afterMove();
        } else if (Greenfoot.isKeyDown("right")) {
            moveRight();
            afterMove();
        } else if (Greenfoot.isKeyDown("up")) {
            moveUp();
            afterMove();
        } else if (Greenfoot.isKeyDown("down")) {
            moveDown();
            afterMove();
        }
    }

    private void afterMove() {
        spawnRandomTile();
        drawGrid();
        Greenfoot.delay(10);
    }

    private void drawGrid() {
        getObjects(Tile.class).forEach(this::removeObject);
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (grid[y][x] != null)
                    addObject(grid[y][x], x * TILE_SIZE + TILE_SIZE/2, y * TILE_SIZE + TILE_SIZE/2);
            }
        }
    }

    private void moveLeft() {
        for (int y = 0; y < SIZE; y++) {
            Tile[] row = grid[y];
            row = squeeze(row);
            row = merge(row);
            row = squeeze(row);
            grid[y] = row;
        }
    }

    private void moveRight() {
        for (int y = 0; y < SIZE; y++) {
            Tile[] row = reverse(grid[y]);
            row = squeeze(row);
            row = merge(row);
            row = squeeze(row);
            grid[y] = reverse(row);
        }
    }

    private void moveUp() {
        for (int x = 0; x < SIZE; x++) {
            Tile[] col = getColumn(x);
            col = squeeze(col);
            col = merge(col);
            col = squeeze(col);
            setColumn(x, col);
        }
    }

    private void moveDown() {
        for (int x = 0; x < SIZE; x++) {
            Tile[] col = reverse(getColumn(x));
            col = squeeze(col);
            col = merge(col);
            col = squeeze(col);
            setColumn(x, reverse(col));
        }
    }

    private Tile[] squeeze(Tile[] line) {
        Tile[] result = new Tile[SIZE];
        int index = 0;
        for (Tile t : line)
            if (t != null) result[index++] = t;
        return result;
    }

    private Tile[] merge(Tile[] line) {
        for (int i = 0; i < SIZE - 1; i++) {
            if (line[i] != null && line[i + 1] != null &&
                line[i].value == line[i + 1].value) {
                line[i].value *= 2;
                line[i + 1] = null;
            }
        }
        return line;
    }

    private Tile[] reverse(Tile[] line) {
        Tile[] result = new Tile[SIZE];
        for (int i = 0; i < SIZE; i++)
            result[i] = line[SIZE - 1 - i];
        return result;
    }

    private Tile[] getColumn(int x) {
        Tile[] col = new Tile[SIZE];
        for (int y = 0; y < SIZE; y++)
            col[y] = grid[y][x];
        return col;
    }

    private void setColumn(int x, Tile[] col) {
        for (int y = 0; y < SIZE; y++)
            grid[y][x] = col[y];
    }

    private void spawnRandomTile() {
        int freeCount = 0;
        for (int y = 0; y < SIZE; y++)
            for (int x = 0; x < SIZE; x++)
                if (grid[y][x] == null) freeCount++;

        if (freeCount == 0) return;

        int pick = Greenfoot.getRandomNumber(freeCount);
        int index = 0;
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (grid[y][x] == null) {
                    if (index == pick) {
                        grid[y][x] = new Tile(Greenfoot.getRandomNumber(10) < 9 ? 2 : 4);
                        return;
                    }
                    index++;
                }
            }
        }
    }
}