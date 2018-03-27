import java.awt.Graphics2D;
import java.util.ArrayList;

/** This class creates a flock of birds.
 */

public class Flock implements FlyingObject3D {
	
	/** SIZE defines the standard unit for a single graphic.
	 * ICON_W and ICON_H are the width and height of the JFrame.
	 */
	private static final double SIZE = 40.0;
	private static final int ICON_W = 600;
	private static final int ICON_H = 250;
	
	private ArrayList<FlyingObject3D> collection;
	
	public Flock() {
		collection = new ArrayList<FlyingObject3D>();
	}
	
	/** This creates a collection of three to seven birds with varying sizes and 
	 * take off locations.
	 */
	public void createCollection() {
		int objNum = (int) (4 * Math.random() + 3);
		int pivot = (int) (Math.random() * ICON_W/2);
		
		while (collection != null && collection.size() <= objNum) {
			int x = pivot + (int) (Math.random() * SIZE);
			int y = ICON_H + (int) (Math.random() * SIZE);
			collection.add(new Bird(x, y, SIZE));
		}
	}
	
	/** This translates the whole flock by changing the coordinates of each object
	 * in the ArrayList.
	 * 
	 * @param xChange: change in the x coordinate
	 * @param yChange: change in the y coordinate
	 */
	public void translate(int xChange, int yChange) {
		for (FlyingObject3D obj : collection) 
			obj.translate(xChange, yChange);
	}
	
	/** This draws the whole flock by traversing the collection and drawing each object.
	 * 
	 * @param g2D: Graphics2D needed to draw the flock
	 */
	public void draw(Graphics2D g2D) {								
		for (FlyingObject3D obj : collection) 
			obj.draw(g2D);
	}
	
	public ArrayList<FlyingObject3D> getCollection() {
		return collection;
	}
	
	/** This method allows the size of the flock to grow over time to simulate the 
	 * effect that the flock is flying closer to the user.
	 * 
	 * @param time: seconds after the flock has taken off
	 */
	public void setUnit(double time) {
		for (FlyingObject3D obj : collection) {
			obj.setUnit(time);
		}
	}
}
