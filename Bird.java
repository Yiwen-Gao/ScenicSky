import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

/** This class creates a bird graphic that can move.
 */

public class Bird implements FlyingObject3D {
	private int x;
	private int y;
	private double size;
	private double unit;
	
	/** This constructor allows the x, y coordinates and the base unit of the
	 * graphic to be initialized.
	 * 
	 * @param x: the leftmost coordinate of the graphic
	 * @param y: the topmost coordinate of the graphic
	 * @param size: the standard unit of the graphic
	 */
	public Bird(int x, int y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	/** This method changes the coordinates of the bird so that when it's
	 * redrawn, it simulates animation.
	 * 
	 * @param xChange: change in the x coordinate
	 * @param yChange: change in the y coordinate
	 */
	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;
	}
	
	/** This creates two lines that make a V shape to simulate the appearance of a bird.
	 * 
	 * @param g2D: Graphics2D needed to draw the object
	 */
	public void draw(Graphics2D g2D) {
		Line2D.Double leftLine = new Line2D.Double(x, y, x + unit/4, y + unit/2);
		Line2D.Double rightLine = new Line2D.Double(x + unit/2, y, x + unit/4, y + unit/2);
		
		GeneralPath bird = new GeneralPath();
		bird.append(leftLine, false);
		bird.append(rightLine, false);
		g2D.draw(bird);
	}
	
	/** This method allows the size of the bird to grow over time to simulate the 
	 * effect that the bird is flying closer to the user. The constant .000195 is 
	 * used because it creates the most realistic imitation of an object growing in size.
	 * 
	 * @param time: seconds after the bird has taken off
	 */
	public void setUnit(double time) {
		unit = size * (1 / (1 - .000195 * time));
	}
}
