
import java.awt.Graphics2D;

/** This is the interface for all objects that fly.
 * This class is based on Professor Kender's MovingObject class.
 */

public interface FlyingObject {
	
	/** All flying objects should be able to fly, or translate, up and down.
	 * 
	 * @param xChange: change in the x coordinate
	 * @param yChange: change in the y coordinate
	 */
	void translate(int xChange, int yChange);
	
	/** All flying objects should have a visual representation.
	 * 
	 * @param g2D: Graphics2D needed to draw the object
	 */
	void draw(Graphics2D g2D);
}
