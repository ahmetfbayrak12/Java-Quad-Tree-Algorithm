package fouryy3;

public class Point 
{
	private double Px, Py, Vx, Vy, mass, Fx, Fy;
	private String file;
	private int Red, Green, Blue;
	
	public double getPx() {
		return Px;
	}
	public void setPx(double px) {
		Px = px;
	}
	public double getPy() {
		return Py;
	}
	public void setPy(double py) {
		Py = py;
	}
	public double getVx() {
		return Vx;
	}
	public void setVx(double vx) {
		Vx = vx;
	}
	public double getVy() {
		return Vy;
	}
	public void setVy(double vy) {
		Vy = vy;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getFx() {
		return Fx;
	}
	public void setFx(double fx) {
		Fx = fx;
	}
	public double getFy() {
		return Fy;
	}
	public void setFy(double fy) {
		Fy = fy;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Point(double px, double py, double vx, double vy, double mass, String file, double fx, double fy) {
		super();
		Px = px;
		Py = py;
		Vx = vx;
		Vy = vy;
		this.mass = mass;
		Fx = fx;
		Fy = fy;
		this.file = file;
	}
	
	public Point(double px, double py, double vx, double vy, double mass, int red, int green, int blue, double fx, double fy) {
		super();
		Px = px;
		Py = py;
		Vx = vx;
		Vy = vy;
		this.mass = mass;
		Fx = fx;
		Fy = fy;
		Red = red;
		Green = green;
		Blue = blue;
	}
	public int getRed() {
		return Red;
	}
	public void setRed(int red) {
		Red = red;
	}
	public int getGreen() {
		return Green;
	}
	public void setGreen(int green) {
		Green = green;
	}
	public int getBlue() {
		return Blue;
	}
	public void setBlue(int blue) {
		Blue = blue;
	}



}
