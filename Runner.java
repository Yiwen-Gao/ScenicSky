import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;

/** This executes all of the code to display the flying hot air balloons and birds.
 * 
 *  OVERVIEW OF THE SYSTEM
 *  Balloon and FlyingObject3D implement FlyingObject to translate, and Bird and Flock 
 *  implement FlyingObject3D to translate and grow in size as they move. MyIcon implements 
 *  Icon and allows all the classes that inherit from FlyingObject to be drawn and redrawn. 
 *  BalloonCollection contains an ArrayList of Balloons, and Flock contains an ArrayList 
 *  of Birds. Runner executes all the code to create the flying graphics. 
 */

public class Runner {

	/** ICON_W and ICON_H are the width and height of the JFrame.
	 * myFrame has to be an instance variable, otherwise it can't be accessed by all 
	 * the classes.
	 */
	private static final int ICON_W = 600;
	private static final int ICON_H = 250;
	private static JFrame myFrame = new JFrame();
	
	/** This method calls all the code.
	 * 
	 * @param args: String[]
	 */
	public static void main(String[] args) {
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createBalloonCollection();
		createFlock();
	}
	
	/** This method creates a collection of balloons that take off at different points.
	 * It also allows the user to adjust the balloons' speed through a JSlider.
	 */
	public static void createBalloonCollection() {
		BalloonCollection balloonCollection = new BalloonCollection();
		balloonCollection.createCollection();
		
		JSlider balloonSlider = balloonCollection.createNewJSlider();
		myFrame.add(balloonSlider);
		myFrame.pack();

		for (FlyingObject balloon : balloonCollection.getBalloonCollection()) {
			Icon iconBalloon = new MyIcon(balloon, ICON_W, ICON_H);
			JLabel labelBalloon = new JLabel(iconBalloon);

			myFrame.add(labelBalloon);
			myFrame.pack();

			final int DELAY = 100;
			Timer myTimer = new Timer(DELAY, new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					int balloonSpeed = balloonCollection.getSpeed();
					balloon.translate(0, balloonSpeed);
					labelBalloon.repaint();
				}
			});
			myTimer.start();

			try {
				TimeUnit.SECONDS.sleep(3);
			}
			catch (InterruptedException e) {}
		}
	}
	
	/** This method creates a flock of birds that take off and travel together.
	 * As they move across the JFrame, they get bigger.
	 */
	public static void createFlock() {
		Flock flock = new Flock();
		flock.createCollection();
		Icon iconFlock = new MyIcon(flock, ICON_W, ICON_H);
		JLabel labelFlock = new JLabel(iconFlock);
		myFrame.add(labelFlock);
		myFrame.pack();													
	
		for (FlyingObject3D obj : flock.getCollection()) {
			final int DELAY = 100;	
			Timer myTimer = new Timer(DELAY, new ActionListener() {
				double time = 0;	
				public void actionPerformed(ActionEvent event) {
					time+=DELAY;
					obj.setUnit(time);
					obj.translate(10, -10);
					labelFlock.repaint();
				}
			});
			myTimer.start();
		}
	}
}
