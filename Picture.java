import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; 

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 * 
 * 
 * Before you begin working on this assignment, look at the Pixel class and SimplePicture class.
 * 
 * Your assignment is to complete (and test) the last 6 methods.
 * 
 * To get the most of this project, use your own pictures.  Have fun with
 * the methods you write and see what cool photshop pictures you can make.
 * 
 */


  
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   * 
   * Why does the class need to explicitly write the no argument (default) constructor?
   * 
   * This class has more than one constructor.  As soon as one constructor is written,
   * the no argument constructor isn't included in the class for free.
   */
  public Picture ()
  {
    /* REMEMBER YOU GET A FREE line of invisible code if the parent
     * constructor has a no agrument constuctor.
     * 
     * super();     IMPLICITYLY CALLED
     */
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
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
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
  
  /** Method to set the blue to 0 */
  /**A picture is made up of a 2-dimensional array of pixels.  
   * SimplePicture has a method that will return the 2D-array of Pixels.  A Picture can use that method because Picture is
   * a subclass of SimplePicture.
   * 
   * Save the 2-D array of Pixels in a variable.  Then, go through each row and column of the array and set the blue value of the Pixel there
   * to 0.  Look in the Pixel class to see how to set the blue value to 0.
   */
  public void zeroBlue(){
	  Pixel[][] pixels = getPixels2D();
	  for(int i = 0; i<pixels.length; i++) {
		  for(int j = 0; j<pixels[0].length; j++) {
			  pixels[i][j].setBlue(0);
		  }
	  }
  }
  
  /**Method to negate all the pixels in a picture.  To negate a pixel, 
    * set the red value to 255 minus the current red value, the green value to 255
    * minus the current green value, and the blue value to 255 minus the current value.
    *
 */ 
    public void negate(){	
    	Pixel[][] pixels = getPixels2D();
    	for(int i = 0; i<pixels.length; i++) {
    		for(int j = 0; j<pixels[0].length; j++) {
    			Pixel p = pixels[i][j];
    			p.setBlue(255-p.getBlue());
    			p.setRed(255-p.getRed());
    			p.setGreen(255-p.getGreen());
    		}
    	}
    }
    
    
    /**Method to turn the picture into shades of gray.  Set the red, green, and blue values
      * to the average of the current red, green, and blue values.  
      */
    public void grayScale(){
    	Pixel[][] pixels = getPixels2D();
    	for(int i = 0; i<pixels.length; i++) {
    		for(int j = 0; j<pixels[0].length; j++) {
    			Pixel p = pixels[i][j];
    			double avg = (p.getBlue()+p.getGreen()+p.getRed())/3.0;
    			p.setBlue((int)avg);
    			p.setRed((int)avg);
    			p.setGreen((int)avg);
    		}
    	}
    }
    
    
 
  /** Method that mirrors the picture around a vertical mirror in the center of the picture
    *from left to right.   For example, if the original image is &@++, the new image will be &@@&*/
  public void mirrorVertical() {
	  Pixel[][] pixels = getPixels2D();
	  int mid = pixels[0].length/2;
	  for(int i = mid; i<pixels[0].length; i++)
		  for(int j = 0; j<pixels.length; j++)
			  pixels[j][i].setColor(pixels[j][2*mid-i-1].getColor());
  }
  /** Method that mirrors the picture around a 
    * horizontal mirror in the center of the picture
    * from top to bottom*/
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = getPixels2D();
	  int mid = pixels.length/2;
	  for(int i = mid; i<pixels.length; i++)
		  for(int j = 0; j<pixels[0].length; j++)
			  pixels[i][j].setColor(pixels[2*mid-i-1][j].getColor());
  }
  
  
  /** Method that makes a border of w rows and columns around
   * the picture.  The border covers up parts of the picture. 
    * The color of the border is Color c.
    */
  
  public void borderPicture(int w, Color color){
	 Pixel[][] pixels = getPixels2D();
	 for(int r = 0; r<pixels.length; r++) {
		 for(int i = 0; i<w; i++)
			 pixels[r][i].setColor(color);
		 for(int i = pixels[0].length-w; i<pixels[0].length; i++)
			 pixels[r][i].setColor(color);
	 }
	 for(int c = 0; c<pixels[0].length; c++) {
		 for(int i = 0; i<w; i++)
			 pixels[i][c].setColor(color);
		 for(int i = pixels.length-w; i<pixels.length; i++)
			 pixels[i][c].setColor(color);
	 }
	 
  }
  

 
} 
// this } is the end of class Picture, put all new methods before this






























