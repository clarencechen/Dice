void setup()
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
void draw()
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
void mousePressed()
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
	void roll()
	{
	numDots = (int)((Math.random()*6)+1);
	}
	void show()
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
	void placeDot(int numDots)
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
	void drawOne ()
	{
		ellipse(0,0,20,20);
	}
	void drawTwoR()
	{
		ellipse(-20,-20,20,20);
		ellipse(20,20,20,20);
	}
	void drawTwoL()
	{
		ellipse(-20,20,20,20);
		ellipse(20,-20,20,20);
	}
	void drawThreeR()
	{
		ellipse(-20,-20,20,20);
		ellipse(0,0,20,20);
		ellipse(20,20,20,20);
	}
	void drawThreeL()
	{
		ellipse(-20,20,20,20);
		ellipse(0,0,20,20);
		ellipse(20,-20,20,20);
	}
	void drawFour()
	{
		ellipse(-20,-20,20,20);
		ellipse(-20,20,20,20);
		ellipse(20,-20,20,20);
		ellipse(20,20,20,20);
	}
	void drawFive()
	{
		ellipse(0,0,20,20);
		ellipse(-20,-20,20,20);
		ellipse(-20,20,20,20);
		ellipse(20,-20,20,20);
		ellipse(20,20,20,20);
	}
	void drawSix()
	{
		ellipse(-20,0,20,20);
		ellipse(20,0,20,20);
		ellipse(-20,20,20,20);
		ellipse(20,20,20,20);
		ellipse(-20,-20,20,20);
		ellipse(20,-20,20,20);
	}
	void drawSixH()
	{
		ellipse(-20,-20,20,20);
		ellipse(20,-20,20,20);
		ellipse(0,-20,20,20);
		ellipse(0,20,20,20);
		ellipse(-20,20,20,20);
		ellipse(20,20,20,20);
	}
}
