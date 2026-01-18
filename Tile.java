import greenfoot.*;

public class Tile extends Actor {
    public int value;

    public Tile(int value) {
        this.value = value;
        updateImage();
    }

    public void act() {
        updateImage();
    }

    public void setValue(int v) {
        value = v;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(100, 100);
        img.setColor(getColor());
        img.fill();
        img.setColor(Color.BLACK);
        img.setFont(img.getFont().deriveFont(24F));
        img.drawString("" + value, 35, 55);
        setImage(img);
    }

    private Color getColor() {
        if (value == 2) return new Color(238, 228, 218);
        if (value == 4) return new Color(237, 224, 200);
        if (value == 8) return new Color(242, 177, 121);
        if (value == 16) return new Color(245, 149, 99);
        if (value == 32) return new Color(246, 124, 95);
        if (value == 64) return new Color(246, 94, 59);
        if (value == 128) return new Color(237, 207, 114);
        if (value == 256) return new Color(237, 204, 97);
        if (value == 512) return new Color(237, 200, 80);
        if (value == 1024) return new Color(237, 197, 63);
        if (value == 2048) return new Color(237, 194, 46);
        return new Color(200, 200, 200);
    }
}
