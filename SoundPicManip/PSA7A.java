/*
 * PSA7A.java
 *
 * Created by: Partner Name 1, CSID1, Email1
 *        and: Partner Name 2, CSID2, Email2
 *
 * Date:
 *
 * Description: This method...
 *
 */

import java.util.Scanner;

public class PSA7A
{
    public static void main(String[] args)
    {
        /* Connecting a Scanner object to the keyboard */
        Scanner keyboard = new Scanner(System.in);

        /* Choosing a picture and initializing variables. */
        Picture pic = new Picture(FileChooser.pickAFile());
        Pixel p = null;
        int x, y, size;
        pic.show();
        int width = pic.getWidth();
        int height = pic.getHeight();
        System.out.println("Picture loaded - width: " + pic.getWidth()+" height: "+ pic.getHeight());

        // Attempt to do 3 horizontal flips
        int flips = 0;
        while (flips < 3)
        {
            /* Prompting the user for coordinates. */
            String prompt = "Please enter a position (first x, then y) in the ";
            String prompt2 = "picture to flip horizontally.";
            System.out.println(prompt + prompt2);


            /* Converting coordinates to ints. */
            x = keyboard.nextInt();
            y = keyboard.nextInt();


            /* Prompting the user for size. */
            System.out.println("Please enter the size of the box to flip.");
            size = keyboard.nextInt();
            
            while(x+size/2>=pic.getWidth() ||
                  x-size/2<0 ||
                  y+size/2>= pic.getHeight() ||
                  y-size/2<0)
            {
              System.out.format("Please enter an x and y coordinate between (0,0) and (%d,%d).", pic.getWidth(),
            pic.getHeight());
              x = keyboard.nextInt();
              y = keyboard.nextInt();
              size = keyboard.nextInt();
            }


            
            pic.flipHorizontal(x, y, size);
            /* Repainting the picture with the horizontal flips completed. */
            pic.repaint();

            flips++;
        }


        // Attempt to do 3 vertical flips
        flips = 0;
        while (flips < 3)
        {
            /* Prompting the user for coordinates. */
            String prompt = "Please enter a position (first x, then y) in the ";
            String prompt2 = "picture to flip vertically.";
            System.out.println(prompt + prompt2);


            /* Converting coordinates to ints. */
            x = keyboard.nextInt();
            y = keyboard.nextInt();


            /* Prompting the user for size. */
            System.out.println("Please enter the size of the box to flip.");
            size = keyboard.nextInt();


            pic.flipVertical(x, y, size);
            /* Repainting the picture with the horizontal flips completed. */
            pic.repaint();

            flips++;
        }
    }
}