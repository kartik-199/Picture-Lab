import java.awt.Color;
import java.util.Scanner;

  
public class PhotoShop
{
  /** Method to show the original picture.**/
	public static void showOriginal(String picture)
	  {
	    Picture p = new Picture(picture);
	    p.explore();
	   
	  }
	
  /** Method to negate picture */
  public static void negate(String picture)
  {
    Picture p = new Picture(picture);
    p.negate();
    p.explore();
  }
  
  
  public static void borderPicture(String picture){
	  Picture p=new Picture(picture);
	  p.borderPicture(7, Color.BLACK);
	  p.explore();
  }
  
  public static void zeroBlue(String picture) {
	  Picture p = new Picture(picture);
	  p.zeroBlue();
	  p.explore();
  }
  public static void grayScale(String picture) {
	  Picture p = new Picture(picture);
	  p.grayScale();
	  p.explore();
  }
  public static void mirrorVertical(String picture) {
	  Picture p = new Picture(picture);
	  p.mirrorVertical();
	  p.explore();
  }
  public static void mirrorHorizontal(String picture) {
	  Picture p = new Picture(picture);
	  p.mirrorHorizontal();
	  p.explore();
  }
  public static void menu(Scanner kb, String fileName) {
	  System.out.println("Choose a number 1-6: \n\t1) ZeroBlue\n\t2) Negate\n\t3) GrayScale\n\t4) Border\n\t5) mirrorVertical\n\t6) mirrorHorizontal");
	  int menuNum = kb.nextInt();
	  if(menuNum==1)
		  zeroBlue(fileName);
	  else if(menuNum==2)
		  negate(fileName);
	  else if(menuNum==3)
		  grayScale(fileName);
	  else if(menuNum==4)
		  borderPicture(fileName);
	  else if(menuNum==5)
		  mirrorVertical(fileName);
	  else if(menuNum==6)
		  mirrorHorizontal(fileName);
	  menu(kb,fileName);
  }
  
  
//Make sure that you test all of the methods you wrote in the    //Picture class.  You'll need to write add more methods to this //class and to add code to the main. 
  
  public static void main(String[] args){ 
	  Scanner kb = new Scanner(System.in);
	  System.out.println("Enter file name");
	  String fileName = kb.nextLine();
	  menu(kb,fileName);
  }
}
