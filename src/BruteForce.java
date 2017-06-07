import java.awt.Color;
import java.util.ArrayList;

public class BruteForce 
{
	public static final double G = 6.67 * Math.pow(10, -11);
	
	public void start(double T, double dt, double radius, int N)
	{	
		ArrayList<Point> planets = new ArrayList<>();
		readInput(planets, N);										// Reading planets' properties from text
				
		for(double k = 0; k < T ; k = k + dt)
		{
			for(int i = 0 ; i < planets.size(); i ++)
			{
				for (int j = 0 ; j < planets.size(); j++)
				{
					if( i != j)										// Do not calculate itselves.
					{
						calculateFxFy(planets, i, j);				// Calculate total force x and force y.
					}
				}
			}
			for(int i = 0 ; i < planets.size() ; i++)
			{
				update(planets, i, dt);								// Update planets' positions and velocities.
			}
			drawSpace(planets, N);									// Draw by their current positions.
		}
		printUniverse(planets);
	}
	
	private double calculateR(double Px1, double Py1, double Px2, double Py2)		// Calculate distance between planets.
	{
		double deltaX = Px2 - Px1;
		double deltaY = Py2 - Py1;
		double r = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));
		return r;
	}
	
	private double calculateF(double m1, double m2, double r)				// Calculate Force
	{
		double F = (G * m1 * m2)/Math.pow(r, 2);
		return F;
	}
	
	private double calculateFx(double F, double Px1, double Px2, double r)		// Calculate Force x.
	{
		double Fx = (F * (Px2 - Px1))/r;
		return Fx;
	}

	private double calculateFy(double F, double Py1, double Py2, double r)		// Calculate Force y.
	{
		double Fy = (F * (Py2 - Py1))/r;;
		return Fy;
	}

	private void calculateFxFy(ArrayList<Point> planets, int i, int j)		// Calculate Force x and Force y and set them
	{
		double r, F;

		r = calculateR(planets.get(i).getPx(), planets.get(i).getPy(), planets.get(j).getPx(), planets.get(j).getPy());
		F = calculateF(planets.get(i).getMass(), planets.get(j).getMass(), r);
		planets.get(i).setFx(planets.get(i).getFx() + calculateFx(F, planets.get(i).getPx(), planets.get(j).getPx(), r));
		planets.get(i).setFy(planets.get(i).getFy() + calculateFy(F, planets.get(i).getPy(), planets.get(j).getPy(), r));
	}
	
	private void update(ArrayList<Point> planets, int i, double dt)			// Update planets' positions and velocities.
	{
		double Ax, Ay, newVx, newVy, newPx, newPy;

		Ax = planets.get(i).getFx() / planets.get(i).getMass();				// Calculate acceleration of x
		Ay = planets.get(i).getFy() / planets.get(i).getMass();				// Calculate acceleration of y
		newVx = (planets.get(i).getVx() + dt * Ax);							// Calculate new velocity of x
		newVy = (planets.get(i).getVy() + dt * Ay);							// Calculate new velocity of y

		planets.get(i).setVx(newVx);										// Set them.
		planets.get(i).setVy(newVy);

		newPx = planets.get(i).getPx() + dt * planets.get(i).getVx();		// Calculate new position of x
		newPy = planets.get(i).getPy() + dt * planets.get(i).getVy();		// Calculate new position of y

		planets.get(i).setPx(newPx);										// Set them
		planets.get(i).setPy(newPy);
		
		planets.get(i).setFx(0.0);											// Set Fx and Fy zero because after delta t time their Forces must be zero.
		planets.get(i).setFy(0.0);

	}
	
	private void readInput(ArrayList<Point> arrayList, int N)				// Reading planets' properties from text
	{
		double px, py, vx, vy, mass;
		String image, temp;
		int red, green, blue;
			for(int i = 0 ; i < N ; i ++)
			{
				px = StdIn.readDouble();
				py = StdIn.readDouble();
				vx = StdIn.readDouble();
				vy = StdIn.readDouble();
				mass = StdIn.readDouble();
				temp = StdIn.readString();
				if(temp.contains("."))									// Check whether our input file planets.txt, pluto.txt etc. or input1.txt, input2.txt etc.
				{
					image = temp;
					Point abc = new Point(px, py, vx, vy, mass, image, 0.0, 0.0);
					arrayList.add(abc);

				}
				else
				{
					red = Integer.parseInt(temp);
					green = StdIn.readInt();
					blue = StdIn.readInt();
					Point abc = new Point(px, py, vx, vy, mass, red, green, blue, 0.0, 0.0);
					arrayList.add(abc);
				}
			}	
		
	}
	
	private void printUniverse(ArrayList<Point> arrayList)				// Print properties of planets.
	{
		if(arrayList.get(0).getFile() != null)							// If it is planet.txt, pluto.txt etc.
		{
			for(int i = 0 ; i < arrayList.size() ; i ++)
			{
				StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %s\n", arrayList.get(i).getPx(), arrayList.get(i).getPy(), arrayList.get(i).getVx(), arrayList.get(i).getVy(), arrayList.get(i).getMass(), arrayList.get(i).getFile());
			}		
		}
		else															// If it is input1.txt, input2.txt etc.
		{
			for(int i = 0 ; i < arrayList.size() ; i ++)
			{
				StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %d %d %d\n", arrayList.get(i).getPx(), arrayList.get(i).getPy(), arrayList.get(i).getVx(), 
				arrayList.get(i).getVy(), arrayList.get(i).getMass(), arrayList.get(i).getRed(), arrayList.get(i).getGreen(), arrayList.get(i).getBlue());	
			}	
		}



	}

	private void drawSpace(ArrayList<Point> planets, int N)				// Creating simulation.
	{
		if(planets.get(0).getFile() != null)							// If it is planet.txt, pluto.txt etc.
		{
			StdDraw.picture(0, 0,  "images/starfield.jpg");

			for(int i = 0 ; i < planets.size() ; i ++)
			{
				StdDraw.picture( planets.get(i).getPx(),  planets.get(i).getPy(), "images/" + planets.get(i).getFile());
			}
			StdDraw.show(3);
		}
		
		else															// If it is input1.txt, input2.txt etc.
		{
            StdDraw.clear(StdDraw.BLACK);
			for(int i = 0 ; i < N ; i++)
			{
	            Color color = new Color(planets.get(i).getRed(), planets.get(i).getGreen(), planets.get(i).getBlue());

	            StdDraw.setPenColor(color);
	            StdDraw.point(planets.get(i).getPx(), planets.get(i).getPy());
			}
			StdDraw.show(1);
		}
	}
}
