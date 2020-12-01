package lehigh;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;

import java. util.Random;

public class MovingBallsWeek10 extends PApplet{

    int score = 0;

    class Ball {
        int x;
        int y;
        float speedX;
        float speedY;
        int radius;

        Ball(){
            radius = (int) random(5,20);
            x = (int) random(500);
            y = (int) random(500);
            speedX = random(1.0f,2.0f);
            speedY = random(1.0f,2.0f);
        }

    }

    ArrayList<Ball> balls;

    public void settings() {
        size(500, 500);
        balls = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                balls.add(new Ball());
        }
    }


    public void draw(){
        background(0);
        fill(255);
        textSize(32);
        text("Score: " + score/7, 10, 30);

        for (Ball ball : balls) {
            ellipse(ball.x, ball.y, 20,20);
            if (ball.x >= 490 || ball.x <= 10) {
                ball.speedX = -ball.speedX;
            }
            ball.x += ball.speedX;
            if (ball.y >= 490 || ball.y <= 10) {
                ball.speedY = -ball.speedY;
            }
            ball.y += ball.speedY;
        }
    }

    public void mouseClicked() {
        for (Ball ball : balls)
            for (int i = 0; i < 7; i++) {
                float xDistance = mouseX - balls.get(i).x;
                float yDistance = mouseY - balls.get(i).y;
                float rr = xDistance * xDistance + yDistance * yDistance;
                if ( rr <= 400.0f ) {
                    balls.get(i).speedX += 0.1f;
                    balls.get(i).speedY += 0.1f;
                    score ++;
            }
        }
    }




    public static void main(String[] args) {
        String[] processingArgs = {"MovingBallsWeek10"};
        MovingBallsWeek10 movingBallsWeek10 = new MovingBallsWeek10();
        PApplet.runSketch(processingArgs, movingBallsWeek10);
    }
}