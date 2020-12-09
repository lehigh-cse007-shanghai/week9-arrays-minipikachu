package lehigh;

import processing.core.PApplet;

import java.util.Random;


public class BubbleSortTextProcessing extends PApplet
{
    int width = 30;
    int number = 10;
    int[] height  = new int[number];
    int[] x = new int[] {10, 60, 110, 160, 210, 260, 310, 360, 410, 460};
    int[] y = new int[number];
    int [][] color = new int [10] [3] ;
    int z, i = 0;
    int max = height.length - 1;

    public void settings()
    {
        size(500,600);
        Random random = new Random();
        for (int i = 0; i < x.length ; i++)
        {
            height[i] = (int) random(50,450);
            y[i] = 500 - height[i];
            color[i] = new int[] {255,255,255};
        }
    }

    public void draw()
    {
        delay(300);
        background(0);

        if (i >= max)
        {
            color[max][0] = 0;
            color[max][1] = 255;
            color[max][2] = 0;
            max--;
            i = 0;
        }


        color[Math.abs(i - 1)][0] = 255;
        color[Math.abs(i - 1)][1] = 255;
        color[Math.abs(i - 1)][2] = 255;

        if (i - 1 < 0 ){
            color[max][0] = 255;
            color[max][1] = 255;
            color[max][2] = 255;
        }

        color[i][0] = 255;
        color[i][1] = 100;
        color[i][2] = 100;
        color[i + 1][0] = 255;
        color[i + 1][1] = 100;
        color[i + 1][2] = 100;

        if(max - 1 < 0){
            color[0][0] = 0;
            color[0][1] = 250;
            color[0][2] = 0;
            color[1][0] = 0;
            color[1][1] = 250;
            color[1][2] = 0;
        }
        if (height[i] > height[i + 1])
        {
            z++;
            if (z == 2)
            {
                z = 0;
                color[i][0] = 0;
                color[i][1] = 100;
                color[i][2] = 255;
                color[i + 1][0] = 0;
                color[i + 1][1] = 100;
                color[i + 1][2] = 255;
                if (height[i] > height[i + 1])
                {
                    int a = height[i];
                    height[i] = height[i + 1];
                    height[i + 1] = a;
                    a = y[i];
                    y[i] = y[i + 1];
                    y[i+1] = a;
                }
                i++;
            }
        }
        else
            {
            i++;
        }


        for (int i = 0; i < height.length; i++){
            fill(color[i][0],color[i][1],color[i][2]);
            rect(x[i], y[i], width, height[i]);
        }

    }

    public static void main(String[] args) {
        String[] processingArgs = {"BubbleSortTextProcessing"};
        BubbleSortTextProcessing bubbleSort = new BubbleSortTextProcessing();
        PApplet.runSketch(processingArgs, bubbleSort);
    }

}