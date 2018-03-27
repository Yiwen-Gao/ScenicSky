import java.util.ArrayList;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** This class creates an ArrayList of Balloon objects for mass ascension. 
 */

public class BalloonCollection {
	
	/** The SIZE is used as the standard unit for creating Balloon objects. 
	 * ICON_W and ICON_H are the width and height of the JFrame.
	 */
	private static final double SIZE = 40.0;
	private static final int ICON_W = 600;
	private static final int ICON_H = 250;
	
	/** MIN_SPEED and MAX_SPEED define the minimum and maximum speeds that are
	 * allowed for the hot air balloons. 
	 */
	private static final int MIN_SPEED = 0;
	private static final int MAX_SPEED = 30;
	
	private ArrayList<Balloon> balloonCollection;
	private int speed;
	
	/** The speed variable is initialized to "-1" because the hot air balloons rise up,
	 * so the y coordinate is decreasing by one.
	 */
	public BalloonCollection() {
		speed = -1;
		balloonCollection = new ArrayList<Balloon>();
	}
	
	/** This uses the createNewFlyingObject() method to create a random number 
	 * of Balloon objects between three and seven.
	 */
	public void createCollection() {
		int balloonNumber = (int) (4 * Math.random() + 3);
		for (int i = 0; i < balloonNumber; i++) 
			balloonCollection.add(createNewFlyingObject());
	}
	
	/** This creates Balloon objects with differing sizes and take off locations.
	 * 
	 * @return Balloon: new Balloon object
	 */
	public Balloon createNewFlyingObject() {
		int x = (int) (ICON_W * Math.random());
		double unit = (1.5 * Math.random() + 0.5) * SIZE;
		return new Balloon(x, ICON_H, unit);
	}
	
	/** This creates a vertical JSlider that allows the user to change the speed of all
	 * the hot air balloons. 
	 * 
	 * @return balloonSpeed: new JSlider object
	 */
	public JSlider createNewJSlider() {
		JSlider balloonSpeed = new JSlider(JSlider.VERTICAL, MIN_SPEED, MAX_SPEED, -speed);
		balloonSpeed.setMajorTickSpacing(10);
		balloonSpeed.setPaintTicks(true);
		balloonSpeed.setPaintLabels(true);
		
		balloonSpeed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				JSlider source = (JSlider) event.getSource();
				if (!source.getValueIsAdjusting()) {
					int tempSpeed = (int) source.getValue();
					speed = -tempSpeed;
				}
			}
		});
		
		return balloonSpeed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public ArrayList<Balloon> getBalloonCollection() {
		return balloonCollection;
	}
}
