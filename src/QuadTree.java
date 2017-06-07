import java.util.ArrayList;

public class QuadTree 
{
	
	public void start(double T, double dt, double Px, int N)
	{
		ArrayList<Point> planets = new ArrayList<>();

		readInput(planets, N);

		
	}

    public void insert(double Px, double Px2, double mass, Node root) 
    {
        root = insert(root, Px, Px2, mass);
    }

    private Node insert(Node h, double Px, double Px2, double mass) 
    {
        if (h == null) 
        	return new Node(Px, Px2, mass);
        else if ( Px < h.Px &&  Px2 < h.Py) 
        	h.SW = insert(h.SW, Px, Px2, mass);
        else if ( Px< h.Px && Px2 > h.Py) 
        	h.NW = insert(h.NW, Px, Px2, mass);
        else if (Px > h.Px &&  Px2 < h.Py) 
        	h.SE = insert(h.SE, Px, Px2, mass);
        else if (Px > h.Px && Px2 > h.Py) 
        	h.NE = insert(h.NE, Px, Px2, mass);
        return h;
    }
    
    private void readInput(ArrayList<Point> arrayList, int N)				// Reading input from text.
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
	
}
