
public class NBody 
{
	public static final double G = 6.67 * Math.pow(10, -11);

	public static void main(String[] args) 
	{
		String algorithmType = args[0];					// Takes type of algorithm. Brute or Quad.
		double dt = Double.parseDouble(args[2]);		// Takes delta t.
		double T = Double.parseDouble(args[1]);			// Takes total T.
		int N = StdIn.readInt();						// Takes number of planets.
		double radius = StdIn.readDouble();				// Takes radius.

		StdDraw.setXscale(-radius, +radius);			// Set scale of space.
		StdDraw.setYscale(-radius, +radius);
		
		BruteForce brute = new BruteForce();
		QuadTree quad = new QuadTree();

		if(algorithmType.equals("brute"))				// Check whether our algorithm is Brute or Quad.
		{
			brute.start(T, dt, radius, N);
		}
		else if(algorithmType.equals("quad"))
		{
			quad.start(T, dt, radius, N);
		}
	}
	

	


}
