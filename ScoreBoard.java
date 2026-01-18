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
        GreenfootImage img = new GreenfootImage(300, 40);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.setFont(img.getFont().deriveFont(22f));
        img.drawString("Score: " + score, 10, 28);
        setImage(img);
    }
}
