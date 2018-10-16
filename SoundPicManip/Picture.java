//Hoang Nguyen
//Cisc 190

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
 
  public static void main(String[] args) 
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }
  public void setColor(){
  Pixel[] pixelArray = this.getPixels();
Pixel p  = null, q = null;
for(int index = 0; index < pixelArray.length-1; index++)
{
  p = pixelArray[index + 1];
  q = pixelArray[index];
  p.setRed(q.getRed());
  p.setBlue(q.getBlue());
  p.setGreen(q.getGreen());
}   
  }
  
  //This method changes a picture so the background is one
  //solid color
  public void createSolid(int red, int green, int blue)
  {
    //initialize the pixel array and pixel object
    Pixel[] pixelArray=this.getPixels();
  
    
    //For loop to change each pixel component 
    //For loop reads:
    //for every Pixel pixel in pixel Array, execute this method
    for(Pixel pixel: pixelArray)
    {
      //Set each pixel to the values specified in the parameters
     pixel.setRed(red);
     pixel.setGreen(green);
     pixel.setBlue(blue);
    }
    
  }
  
  
  //This method makes every even pixel black, and every odd pixel 
  //whatever is input into the parameters
  public void createPattern(int red, int green, int blue)
  {
    //Initialize every variable used
    Pixel[] pixelArray=this.getPixels();
    Pixel pixel = null;
    int i = 0;
    
    //First sets every even pixel to black, starting at
    //the number 0
    while(i < pixelArray.length)
    {
      pixel = pixelArray[i];
      pixel.setColor(Color.black);
      i = i + 2;
    }
    //Reset the value of i to 1 to get all odd integers
     i = 1;
     
     //Sets all odd pixels to parameter values
    while (i < pixelArray.length)
    {
      pixel = pixelArray[i];
      pixel.setRed(red);
      pixel.setGreen(green);
      pixel.setBlue(blue);
      i = i + 2;
    }
  }
  
  
  //Subtracts color from an picture by 
  //the amounts specified in the parameters
public void subtractColor(int red, int green, int blue)
{
  //initilization 
  Pixel[] pixelArray = this.getPixels();
  Pixel p = null;
  int c = 0;
  
  //Loop subtracts the colors from the parameters from the picture
  for(int i = 0; i<pixelArray.length; i++)
  {
    //Set p to the ith pixel starting from 0
    p = pixelArray[i];
    
    //Make c the red value of the pixel
    c = p.getRed();
    
    //Set the color of the pixel to c - parameter value
    p.setRed(c-red);
    
    //Re-set c to the green value of the pixel
    c = p.getGreen();
    
    //Set the green value of the pixel to c - second parameter value
    p.setGreen(c-green);
    
    //Re-set c to the blue value
    c = p.getBlue();
    
    //Set blue value to c - 3rd parameter value
    p.setBlue(c-blue);
    
    
  }
}

//Method sets picture to negative colors
public void negative(int start, int end)
{
  //initialize all variables
  Pixel[] pixelArray = this.getPixels();
  Pixel p = null;
  
  int i = start;
  int c = 0;
  
  //loop makes the colors set to negative counterpart
  while(i <= end)
  {
    //Define pixel p to be the ith pixel of the array of pixels
   p = pixelArray[i];
   
   //Set c to the red value
   c = p.getRed();
   
   //Set the pixel value to 255-c
   p.setRed(255-c);
   
   //Reset pixel value to green value
   c = p.getGreen();
   
   //Set the green value to 255 - c
   p.setGreen(255-c);
   
   //Reset c to the blue value 
   c = p.getBlue();
   
   //Set blue value to 255-c
   p.setBlue(255-c);
   
   //next recursive step
   i++;
  
  
  }
}

public void grayscale(int start, int finish)
{
  //initilization
  Pixel[] pixelArray = this.getPixels();
  Pixel p = null;
  int i = start;
  int c = 0;
  
  //While loop makes the pixels grayscale
  while(i <= finish)
  {
    //Set p to the ith pixel of the pixel array
    p = pixelArray[i];
    
    //Set c to the average value of the 3 color values of the pixel
    c = ((p.getRed() + p.getGreen() + p.getBlue())/3);
    
    //Set each color element to the new value of c
    p.setColor(new Color(c,c,c));
    
    //Next recursive step
    i++;
    
  }
}

public void myFilter(int start, int finish)
{
  //Initilization
  Pixel[] pixelArray = this.getPixels();
  Pixel p = null;
  int i = start;
  int c = 0;
  
  //Loop sets each pixel to 2/3 of its value
  while(i <= finish)
  {
    //Set p to the ith pixel in the pixel array
    p = pixelArray[i];
    
    //Set c to the red value of the pixel
    c = p.getRed();
    
    //Set the red value of the pixel to 2/3 of c
    p.setRed(c*2/3);
    
    //Re-set c to the green value of the pixel
    c = p.getGreen();
    
    //Set the green value of the pixel to 2/3 of c
    p.setGreen(c*2/3);
    
    //Re-set c to the blue value of the pixel
    c = p.getBlue();
    
    //Set the blue value of the pixel to 2/3 of c
    p.setBlue(c*2/3);
    
    //Next recursive step
    i++;
  }
  
}

public void collage(Picture p1, Picture p2, Picture p3)
{
  int sourceX, sourceY, targetX, targetY;
  Pixel pix1 = null, pix2 = null;
  
  
  for(sourceX = 0, targetX = 0; sourceX<p1.getWidth(); sourceX++, targetX++)
  {
    for(sourceY = 0, targetY = 0; sourceY<p1.getHeight(); sourceY++, targetY++)
    {
      pix1 = p1.getPixel(sourceX, sourceY);
      pix2 = this.getPixel(targetX, targetY);
      pix2.setColor(pix1.getColor());
    }
  }
  for(sourceX = 0, targetX = p1.getWidth(); sourceX < p2.getWidth(); sourceX++, targetX++)
  {
    for(sourceY = 0, targetY = 0; sourceY<p2.getHeight(); sourceY++, targetY++)
    {
      pix1 = p2.getPixel(sourceX, sourceY);
      pix2 = this.getPixel(targetX, targetY);
      pix2.setColor(pix1.getColor());
    }
  }
  for(sourceX = 0, targetX = 2*p1.getWidth(); sourceX<p1.getWidth(); sourceX++, targetX++)
  {
    for(sourceY = 0, targetY = 0; sourceY<p3.getHeight(); sourceY++, targetY++)
    {
      pix1 = p3.getPixel(sourceX, sourceY);
      pix2 = this.getPixel(targetX, targetY);
      pix2.setColor(pix1.getColor());
    }
  }
  
}

public void vertMirror()
{
  Pixel highPix = null, lowPix = null;
  for(int x = 0; x<this.getWidth(); x++)
  {
    for(int y = 0; y<this.getHeight()/2; y++)
        {
           highPix = this.getPixel(x, y);
           lowPix = this.getPixel(x, this.getHeight()-1-y);
           lowPix.setColor(highPix.getColor());
        }
  }  
}

public void grayscale2()
{
  Pixel p = null;
  int c;
  for(int x = 0; x<this.getWidth(); x++)
  {
    for(int y = 0; y<this.getHeight(); y++)
    {
      p = this.getPixel(x,y);
      c = ((p.getRed() + p.getGreen() + p.getBlue())/3);
      p.setColor(new Color(c,c,c));
    }
  }
}

public void negative2()
{
 Pixel p = null;
 int c;
 for(int x = 0; x<this.getWidth(); x++)
 {
   for(int y = 0; y<this.getHeight(); y++)
   {
     p = this.getPixel(x,y);
     p.setRed(255-p.getRed());
     p.setGreen(255-p.getGreen());
     p.setBlue(255-p.getBlue());
   }
 }
}
/*
// Flipes picture vertical
public void flipVertical(int Midx, int Midy, int size)
{
  // Initialize
  Pixel p1 = null, p2 = null;
  Color c;
  
  // y used to add each iteration to the upper pixel p1
  // and subtract an iteration from the lower pixel p2
  for(int y = 0; y<size/2; y++)
  {
    // x starts the middle - half the size
    // and ends at middle + half the size
    for(int x = Midx-(size/2); x<Midx+(size/2); x++)
    {
      // Set p1 to the the upper part of the flip
      // Set p2 to the lower part of the flip
      p1 = this.getPixel(x, Midy-(size/2) +y);
      p2 = this.getPixel(x, Midy+(size/2) -y);
      
      // Swap colors with color c as the placeholder
      c = p1.getColor();
      p1.setColor(p2.getColor());
      p2.setColor(c);
    }
  }
} 
*/
/*
public void flipHorizontal(int Midx, int Midy, int size)
{
  // Initialize variables to be used
  Pixel p1 = null, p2 = null;
  Color c;
  
  // Use x to add an iteration to the left pixel (p1)
  // and subtract from the right pixel (p2)
  for(int x = 0; x<(size/2); x++)
  {
    // y starts at Midy (input) - size/2 (upper column)
    // and ends at Midy + size/2 (lowest column)
    for(int y = Midy - (size/2); y<Midy+(size/2); y++)
    {
      // Set p1 to left side and p2 to right side
      // y starts from bottom to top
      p1 = this.getPixel(Midx - (size/2) +x, y);
      p2 = this.getPixel(Midx + (size/2) -x, y);
      
      // Swap colors, using c as a temporary place to hold p1 color
      c = p1.getColor();
      p1.setColor(p2.getColor());
      p2.setColor(c);
    }
  }
}
*/
// If red value>blue value, red value turns into green value, green to blue, blue to red
// If statement based on color of the pixel
public void swapRGB()
{
  //Initialize
  Pixel[] pixArray = this.getPixels();
  int c = 0;
  
  //For every pixel p in pixArray
  for(Pixel p: pixArray)
  {
    //If red value>blue value
    if(p.getRed()>p.getBlue())
    {
      //Red value changes to green value, green to blue, blue to old red
      c = p.getRed();
      p.setRed(p.getGreen());
      p.setGreen(p.getBlue());
      p.setBlue(c);
    }
  }
}

// Flips quadrants that are diagonal to each other
// If statement based on pixel location
public void diagflipQuadrants()
{
  //Initialize
  Pixel p1 = null, p2 = null;
  Color c;
  
  //Go through all columns
  for(int col = 0; col<this.getWidth(); col++)
  {
    //Go through top half of the height
    for(int row = 0; row<this.getHeight()/2; row++)
    {
      // Set base color and pixel
      p1 = this.getPixel(col, row);
      c = p1.getColor();
      
      //If the column value is less than half the width
      if(col<this.getWidth()/2)
      {
        //set p2 to the corresponding position in the 4th quadrant
        p2 = this.getPixel(this.getWidth()/2+col, this.getHeight()/2+row);
      }
      else
      {
        //else set p2 to corresponding position in 3rd quadrant
        p2 = this.getPixel(col-this.getWidth()/2, this.getHeight()/2+row);
      }
      //swap colors of p1 and p2
      p1.setColor(p2.getColor());
      p2.setColor(c);
    }
  }
}

// Lowers red value by half if it's over 127
// If statement based on pixel color
public void lowRed()
{
// Initialize
Pixel[] pixArray = this.getPixels();
Pixel p = null;

// Goes through the entire pixel array
  for(Pixel pix : pixArray)
  {
    // if redvalue is above 127, divide it by 2
    if(pix.getRed()>255/2)
      pix.setRed(pix.getRed()/2);
  }
  
  
}

  //Creates a collage based on 3 images with specific dimensions
  //p1 = p2 = 252 x 342 
  //p3 = 504 x 342
  public Picture createCollage(Picture p1, Picture p2, Picture p3)
  {
   //Create a new picture the same size as the canvas
   Picture collage = new Picture(this.getWidth(), this.getHeight());
   //Initialize pixels
   Pixel sourcePixel = null, targetPixel = null;
   //For loops put the first picture in top left quadrant
   for(int x = 0; x<p1.getWidth(); x++)
   {
     for(int y = 0; y<p1.getHeight(); y++)
     {
       //Set source pixel to p1 pixel and target corresponds to canvas position
       sourcePixel = p1.getPixel(x, y);
       targetPixel = collage.getPixel(x, y);
       targetPixel.setGreen(sourcePixel.getGreen());
       targetPixel.setBlue(sourcePixel.getBlue());
       targetPixel.setRed(sourcePixel.getRed());
     }
   };
   // puts p2 in second quadrant
   for(int x = p1.getWidth(); x<p1.getWidth()+p2.getWidth()-2; x++)
   {
     for(int y = 0; y<p2.getHeight(); y++)
     {
       //Set source pixel to p2 pixel and target corresponds to the second quadrant in the canvas
       sourcePixel = p2.getPixel(x-p2.getWidth(), y);
       targetPixel = collage.getPixel(x, y);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
   //Third picture takes up bottom half of the canvas
   for(int x =0; x<this.getWidth(); x++)
     for(int y = this.getHeight()/2; y< this.getHeight(); y++)
   {
       //Set source pixel to p3 and target corresponds to quadrants 3 and 4 of the canvas
       sourcePixel = p3.getPixel(x, y-this.getHeight()/2);
       targetPixel = collage.getPixel(x, y);
       targetPixel.setColor(sourcePixel.getColor());
   }
   //return collage picture
   return collage;
  }
  
  // Greenscreen change
  public void chromakeyGreen(int thresholdGreen, Picture source)
  {
    //Initialize values
    Pixel p1 = null, p2 = null;
    // Go through entire picture
    for(int x = 0; x<this.getWidth(); x++)
      for(int y = 0; y<this.getHeight(); y++)
    {
      p1 = this.getPixel(x, y);
      p2 = source.getPixel(x, y);
      //If the distance of colors is less than the threshold
      if(p1.colorDistance(Color.GREEN)<thresholdGreen)
      {
        //Set the color to the new picture
        p1.setColor(p2.getColor());
      }
    }
  }
  
  // Bluescreen change
  public void chromakeyBlue(int thresholdBlue, Picture source)
  {
    // Color of the shirt in this specific picture
    Color shirt = new Color(59, 74, 105);
    // Initialize pixels
    Pixel p1 = null, p2 = null;
    
    //Goes through all the pixels of the Base Picture
    for(int x = 0; x<this.getWidth(); x++)
      for(int y = 0; y<this.getHeight(); y++)
    {
      p1 = this.getPixel(x, y);
      p2 = source.getPixel(x, y);
      // If the distance between colors is less than the threshold
      if(p1.colorDistance(shirt)<thresholdBlue)
      {
        // change the color to the new picture
        p1.setColor(p2.getColor());
      }
    }
  }
  
  public void flipVertical(int x, int y, int size)
{
  Pixel leftPixel = null;
  Pixel rightPixel = null;
  int leftMostX, topMostY, rightMostX, bottomMostY =0;

  leftMostX = x - size/2;
  rightMostX = x+ size/2;
  topMostY = y-size/2;
  bottomMostY = y+size/2;
  for(int j=topMostY; j<=bottomMostY; j++)
  {
    for(int i=leftMostX; i<x; i++)
    {
      leftPixel = this.getPixel(i,j);
      rightPixel = this.getPixel(rightMostX-i+leftMostX,j);

      Color tempColor = leftPixel.getColor();
      leftPixel.setColor(rightPixel.getColor());
      rightPixel.setColor(tempColor);
    }
  }
}


public void flipHorizontal(int x, int y, int size)
{
  Pixel topPixel = null;
  Pixel bottomPixel = null;
  int leftMostX, topMostY, rightMostX, bottomMostY =0;

  leftMostX = x-size/2;
  rightMostX = x+ size/2;
  topMostY = y-size/2;
  bottomMostY = y+size/2;
  for(int j=topMostY; j<=y; j++)
  {
    for(int i=leftMostX; i<=rightMostX; i++)
    {
      topPixel = this.getPixel(i,j);
      bottomPixel = this.getPixel(i,bottomMostY-j+topMostY);

      Color tempColor = topPixel.getColor();
      topPixel.setColor(bottomPixel.getColor());
      bottomPixel.setColor(tempColor);
    }
  }
}
  
  
} // this } is the end of class Picture, put all new methods before this
 