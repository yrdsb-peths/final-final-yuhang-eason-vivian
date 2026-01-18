import greenfoot.*;

public class TitleWorld extends World {

    public TitleWorld() {
        super(600, 600, 1);
        drawScreen();
    }

    public void act() {
        if (Greenfoot.isKeyDown("left") ||
            Greenfoot.isKeyDown("right") ||
            Greenfoot.isKeyDown("up") ||
            Greenfoot.isKeyDown("down")) {

            Greenfoot.setWorld(new GameWorld());
        }
    }

    private void drawScreen() {
        GreenfootImage img = new GreenfootImage(600, 600);
        img.setColor(new Color(250, 248, 239));
        img.fill();

        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", true, false, 72));
        img.drawString("2048", 200, 220);

        img.setFont(new Font("Arial", false, false, 28));
        img.drawString("Press an arrow key to start", 140, 320);

        setBackground(img);
    }
}
