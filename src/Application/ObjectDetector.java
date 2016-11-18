package Application;
import SensorData.LSPoller;
import SensorData.USPoller;
import lejos.hardware.lcd.TextLCD;

/**
 * Class not implemented in the code, only used for testing
 * @author Alex
 *
 */
public class ObjectDetector extends Thread {

	private final double COLOR_SENSOR_THERSHOLD = 10; 
	private final double DISTANCE_THRESHOLD = 20; 
	private final double DISTANCE_THRESHOLD_2= 6; 

	private TextLCD t;
	private LSPoller lsPoller;
	private USPoller usPoller, usPoller2;

	// constructor
	public ObjectDetector(USPoller usPoller, USPoller usPoller2, TextLCD t) {
		this.usPoller = usPoller;
		this.usPoller2 = usPoller2;
		this.t = t;
	}

	//
	public void run() {
		while (true) {

			t.clear();

			if(usPoller.getDistance() < DISTANCE_THRESHOLD && usPoller2.getDistance() < DISTANCE_THRESHOLD_2){
				t.clear();
				System.out.println("Wooden");
			}

			if(usPoller.getDistance() < DISTANCE_THRESHOLD && usPoller2.getDistance() > DISTANCE_THRESHOLD_2) {
				t.clear();
				System.out.println("Styrofoam");
//				t.drawString("Styrofoam block", 0, 0);
			}
			t.clear();

			t.drawString("No Object", 0, 0);
		}
	}
}
