import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

public void setup()
{
	size(1120,320,P3D);
	noLoop();
	background(0);
	lights();
	ortho();
	ellipseMode(CENTER);
	textSize(30);
	textAlign(CENTER);
}
public void draw()
{
	Die[] bob = new Die[6];
	background(0);
	for(int i=0;i<6;i++)
	{
		bob[i] = new Die(160*(i+1),160,0); 
		bob[i].roll();
		bob[i].show();
		stroke(255, 0, 0);
	}
	int sum = 0;
	fill(255);
	for (int i=0;i<6;i++)
	{
		sum += bob[i].numDots;
	}
	text("Sum of front faces: "+sum,560,280,0);
}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
	//variable declarations here
	int numDots;
	int x;
	int y;
	int z;
	Die(int x, int y, int z) //constructor
	{
	 this.x = x;
	 this.y = y;
	 this.z = z;
	}
	public void roll()
	{
	numDots = (int)((Math.random()*6)+1);
	}
	public void show()
	{
		translate(x, y, z);
		rotateX(-PI/6); 
		rotateY(PI/3);
		fill(0);
		stroke(255);
		box(80);
		placeDot(numDots);
		rotateY(-PI/3);
		rotateX(PI/6);
		translate(-x, -y, -z);
	}
	public void placeDot(int numDots)
	{
		switch (numDots) {
			case 1 :
			{
				translate(0,0,-40);
				drawFive();
				translate(0,0,80);
				drawTwoL();
				translate(0,0,-40);
				rotateY(PI/2);
				translate(0,0,-40);
				drawOne();
				translate(0,0,80);
				drawSix();
				translate(0,0,-40);
				rotateX(PI/2);
				translate(0,0,-40);
				drawFour();
				translate(0,0,80);
				drawThreeR();
				translate(0, 0, -40);
				rotateX(-PI/2);
				rotateY(-PI/2);
				break;
			}
			case 2 :
			{
				translate(0,0,-40);
				drawFour();
				translate(0,0,80);
				drawThreeL();
				translate(0,0,-40);
				rotateY(PI/2);
				translate(0,0,-40);
				drawTwoR();
				translate(0,0,80);
				drawFive();
				translate(0,0,-40);
				rotateX(PI/2);
				translate(0,0,-40);
				drawSixH();
				translate(0,0,80);
				drawOne();
				translate(0, 0, -40);
				rotateX(-PI/2);
				rotateY(-PI/2);
				break;
			}
			case 3 :
			{
				translate(0,0,-40);
				drawSixH();
				translate(0,0,80);
				drawOne();
				translate(0,0,-40);
				rotateY(PI/2);
				translate(0,0,-40);
				drawThreeL();
				translate(0,0,80);
				drawFour();
				translate(0,0,-40);
				rotateX(PI/2);
				translate(0,0,-40);
				drawFive();
				translate(0,0,80);
				drawTwoR();
				translate(0, 0, -40);
				rotateX(-PI/2);
				rotateY(-PI/2);
				break;
			}
			case 4 :
			{
				translate(0,0,-40);
				drawOne();
				translate(0,0,80);
				drawSixH();
				translate(0,0,-40);
				rotateY(PI/2);
				translate(0,0,-40);
				drawFour();
				translate(0,0,80);
				drawThreeR();
				translate(0,0,-40);
				rotateX(PI/2);
				translate(0,0,-40);
				drawTwoL();
				translate(0,0,80);
				drawFive();
				translate(0, 0, -40);
				rotateX(-PI/2);
				rotateY(-PI/2);
				break;
			}
			case 5 :
			{
				translate(0,0,-40);
				drawFour();
				translate(0,0,80);
				drawThreeR();
				translate(0,0,-40);
				rotateY(PI/2);
				translate(0,0,-40);
				drawFive();
				translate(0,0,80);
				drawTwoR();
				translate(0,0,-40);
				rotateX(PI/2);
				translate(0,0,-40);
				drawOne();
				translate(0,0,80);
				drawSixH();
				translate(0, 0, -40);
				rotateX(-PI/2);
				rotateY(-PI/2);
				break;
			}
			case 6 :
			{
				translate(0,0,-40);
				drawTwoR();
				translate(0,0,80);
				drawFive();
				translate(0,0,-40);
				rotateY(PI/2);
				translate(0,0,-40);
				drawSix();
				translate(0,0,80);
				drawOne();
				translate(0,0,-40);
				rotateX(PI/2);
				translate(0,0,-40);
				drawFour();
				translate(0,0,80);
				drawThreeL();
				translate(0, 0, -40);
				rotateX(-PI/2);
				rotateY(-PI/2);
				break;
			}
		}
	}
	public void drawOne ()
	{
		ellipse(0,0,20,20);
	}
	public void drawTwoR()
	{
		ellipse(-20,-20,20,20);
		ellipse(20,20,20,20);
	}
	public void drawTwoL()
	{
		ellipse(-20,20,20,20);
		ellipse(20,-20,20,20);
	}
	public void drawThreeR()
	{
		ellipse(-20,-20,20,20);
		ellipse(0,0,20,20);
		ellipse(20,20,20,20);
	}
	public void drawThreeL()
	{
		ellipse(-20,20,20,20);
		ellipse(0,0,20,20);
		ellipse(20,-20,20,20);
	}
	public void drawFour()
	{
		ellipse(-20,-20,20,20);
		ellipse(-20,20,20,20);
		ellipse(20,-20,20,20);
		ellipse(20,20,20,20);
	}
	public void drawFive()
	{
		ellipse(0,0,20,20);
		ellipse(-20,-20,20,20);
		ellipse(-20,20,20,20);
		ellipse(20,-20,20,20);
		ellipse(20,20,20,20);
	}
	public void drawSix()
	{
		ellipse(-20,0,20,20);
		ellipse(20,0,20,20);
		ellipse(-20,20,20,20);
		ellipse(20,20,20,20);
		ellipse(-20,-20,20,20);
		ellipse(20,-20,20,20);
	}
	public void drawSixH()
	{
		ellipse(-20,-20,20,20);
		ellipse(20,-20,20,20);
		ellipse(0,-20,20,20);
		ellipse(0,20,20,20);
		ellipse(-20,20,20,20);
		ellipse(20,20,20,20);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
