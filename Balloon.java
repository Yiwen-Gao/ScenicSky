import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/** This class creates a hot air balloon graphic that can move.
 */

public class Balloon implements FlyingObject {

	private double x;
	private double y;
	private double unit;
	private double boxwidth;
	private double boxheight;
	
	/** The box is the rectangle representing the basket at the bottom of a hot air balloon.
	 * 
	 * @param x: the leftmost coordinate of the graphic
	 * @param y: the topmost coordinate of the graphic
	 * @param unit: used to measure the sizes of the different parts
	 */
	public Balloon(int x, int y, double unit) {
		this.x = x;
		this.y = y;
		this.unit = unit;
		boxwidth = unit/2;
		boxheight = unit/2;
	}

	/** This method changes the coordinates of the hot air balloon so that when it's
	 * redrawn, it simulates animation.
	 * 
	 * @param xChange: change in the x coordinate
	 * @param yChange: change in the y coordinate
	 */
	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;
	}

	/** This method creates the circle, lines, and rectangle that make up a hot air
	 * balloon graphic.
	 * 
	 * @param g2D: Graphics2D needed to draw the object
	 */
	public void draw(Graphics2D g2D) {
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, unit, unit);
		Line2D.Double leftLine = new Line2D.Double(x, y + unit/2, x + unit/2, y + 2*unit);
		Line2D.Double rightLine = new Line2D.Double(x + unit, y + unit/2, x + unit/2, y + 2*unit);
		Rectangle2D.Double box = new Rectangle2D.Double(x + unit/4, y + 2*unit, boxwidth, boxheight);
		
		GeneralPath balloon = new GeneralPath();
		balloon.append(leftLine, false);
		balloon.append(rightLine, false);
		
		g2D.fill(circle);
		g2D.fill(box);
		g2D.draw(balloon);
	}
}
