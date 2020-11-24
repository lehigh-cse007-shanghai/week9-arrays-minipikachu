package lehigh;

import processing.core.PApplet;

import java.util.Arrays;

import java. util.Random;

public class MovingBalls extends PApplet{

    int x [] = new int[7];
    int y [] = new int[7];
    int speedX [] = new int[7];
    int speedY [] = new int[7];
    int color [] []= new int[7] [3];



    public void settings(){
        size(500, 500);

        Random random = new Random();
        for(int i = 0; i < 7; i++){
            x[i] = random.nextInt(500);
            y[i] = random.nextInt(500);
            speedX[i] = random.nextInt(3) + 1;
            speedY[i] = random.nextInt(3) + 1;
            color[i] = new int[] {random.nextInt(255),random.nextInt(255),random.nextInt(255)};
        }
    }

    public int positionX (int n){
        x[n] += speedX[n];
        return x[n];
    }

    public int positionY (int n){
        y[n] += speedY[n];
        return y[n];
    }

    public int changeSpeedX (int n){
        if(x[n] >= 500){
            speedX[n] = -speedX[n];
        }
        if(x[n] <= 0){
            speedX[n] = -speedX[n];
        }
        return speedX[n];
    }

    public int changeSpeedY (int n){
        if(y[n] >= 500){
            speedY[n] = -speedY[n];
        }
        if(y[n] <= 0) {
            speedY[n] = -speedY[n];
        }
        return speedY[n];
    }

    public void draw(){
        background(255,255,255);

        int xDistance, yDistance;

        for (int i = 0; i < x.length; i++){
            fill(color[i][0],color[i][1],color[i][2]);
            ellipse(x[i], y[i], 50, 50);
            x[i] = positionX(i);
            y[i] = positionY(i);
            speedX[i] = changeSpeedX(i);
            speedY[i] = changeSpeedY(i);

            if (i != x.length - 1) {
                for(int TestLine = i; TestLine < x.length; TestLine++){
                    xDistance= x[TestLine] - x[i];
                    yDistance = y[TestLine] - y[i];
                    if(Math.abs(xDistance) <= 100 && Math.abs(yDistance) <= 100){
                        line(x[TestLine], y[TestLine], x[i], y[i]);
                    }
                }

            }

        }

    }




    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);
    }
}