import greenfoot.*;

public class ScoreBoard extends Actor {
    private int score = 0;

    public ScoreBoard() {
        updateImage();
    }

    public void addScore(int value) {
        score += value;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(300, 50);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.setFont(img.getFont().deriveFont(24f));
        img.drawString("Score: " + score, 20, 35);
        setImage(img);
    }
}
