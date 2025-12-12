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

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(100, 100);
        img.setColor(getColor());
        img.fill();
        img.setColor(new Color(0, 0, 0));
        img.setFont(img.getFont().deriveFont(24F));
        img.drawString("" + value, 40, 55);
        setImage(img);
    }

    private Color getColor() {
        if (value == 2) return new Color(0xEE, 0xE4, 0xDA);
        if (value == 4) return new Color(0xED, 0xE0, 0xC8);
        if (value == 8) return new Color(0xF2, 0xB1, 0x79);
        if (value == 16) return new Color(0xF5, 0x95, 0x63);
        if (value == 32) return new Color(0xF6, 0x7C, 0x5F);
        if (value == 64) return new Color(0xF6, 0x5E, 0x3B);
        if (value == 128) return new Color(0xED, 0xCF, 0x72);
        if (value == 256) return new Color(0xED, 0xCC, 0x61);
        if (value == 512) return new Color(0xED, 0xC8, 0x50);
        if (value == 1024) return new Color(0xED, 0xC5, 0x3F);
        if (value == 2048) return new Color(0xED, 0xC2, 0x2E);
        return new Color(200, 200, 200);
    }
}