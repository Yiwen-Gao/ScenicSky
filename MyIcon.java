import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

/** This class allows FlyingObjects to be repainted to simulate flying.
 * This class is based on Professor Kender's MyIcon class.
 */

public class MyIcon implements Icon {
	
	private FlyingObject flyingObject;
	private int w;
	private int h;
	
	/** This constructor initializes the FlyingObject, width, and height.
	 * 
	 * @param flyingObject: the graphic being drawn
	 * @param w: the width of the Icon
	 * @param h: the height of the Icon
	 */
	public MyIcon(FlyingObject flyingObject, int w, int h) {
		this.flyingObject = flyingObject;
		this.w = w;
		this.h = h;
	}

	public int getIconWidth() {
		return w;
	}

	public int getIconHeight() {
		return h;
	}

	/** This method draws the Icon to the JFrame.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		flyingObject.draw(g2D);
	}
}
