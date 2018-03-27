/** This class extends the FlyingObject class so that FlyingObject3D objects
 * grow in size to simulate them flying closer towards the user.
 */

public interface FlyingObject3D extends FlyingObject {
	void setUnit(double time);
}
