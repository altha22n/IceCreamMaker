import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

/**
 * This class acts as the model and view for our ice cream application It
 * extends JComponent
 * 
 * @author Nada-Al-Thawr
 *
 */
public class IceCreamCone extends JComponent {
	/**
	 * @param iceCreameCone
	 *            , which is our original stack
	 * @param tempStack
	 *            , which is our temp stack
	 * @param yCoord
	 *            , which is the y coordinates of the scoop and cone
	 * @param xCoord
	 *            , which is the x coordinates of the scoop and cone
	 * @param diamScoop
	 *            , which is the size of the scoop
	 * @param overlapScoop
	 *            , which is the overlap size of our scoops
	 * @param brown
	 *            , which is a color
	 */
	public StackLL<String> iceCreamCone;
	public StackLL<String> tempStack;
	private static int yCoord = 300;
	private static final int xCoord = 240;
	private static final int diamScoop = 120;
	private static final int overlapScoop = 10;
	private Color brown = new Color(156, 93, 82);

	/**
	 * Constructor
	 */
	public IceCreamCone() {
		// create the original and temporary stacks
		iceCreamCone = new StackLL<String>();
		tempStack = new StackLL<String>();

	}

	/**
	 * paint method
	 * 
	 * @param g
	 *            , Graphics object
	 */
	public void paint(Graphics g) {
		// call paint cone and paint scoop
		paintCone(g);
		paintScoop(g);

	}

	/**
	 * paint cone method
	 * 
	 * @param g
	 *            , Graphics object
	 */
	public void paintCone(Graphics g) {
		// set the color to brown
		g.setColor(brown);
		// draw the cone using a polygon object
		// using our x and y coords and 3 corners
		g.fillPolygon(new int[] { xCoord + 10, yCoord, 350 }, new int[] { 420,
				620, 420 }, 3);
	}

	/**
	 * paint scoop method
	 * 
	 * @param g
	 *            , Graphics object
	 */
	public void paintScoop(Graphics g) {
		// set the number of scoops to 0 initially
		int scoopNum = 0;
		// while the original stack is not empty
		while (!iceCreamCone.isEmpty()) {
			// pop the original and push on the temp stack
			tempStack.push(iceCreamCone.pop());

		}
		// while the temp stack is not empty
		while (!tempStack.isEmpty()) {
			// our flavor is what's popped from temp stack
			String flavor = tempStack.pop();
			// if the flavor is vanilla
			if (flavor.equals("vanilla")) {
				// set the scoop color to white
				g.setColor(Color.white);
				// draw the scoop with x and y coords, while decrementing y
				// depending on the scoop number
				// and add the overlapscoop
				g.fillOval(xCoord, yCoord - (scoopNum * diamScoop)
						+ (scoopNum * overlapScoop), diamScoop, diamScoop);

			}
			// if the flavor is chocolate
			if (flavor.equals("chocolate")) {
				// set the color to brown
				g.setColor(new Color(51, 32, 13));
				// draw the scoop with x and y coords, while decrementing y
				// depending on the scoop number
				// and add the overlapscoop
				g.fillOval(xCoord, yCoord - (scoopNum * diamScoop)
						+ (scoopNum * overlapScoop), diamScoop, diamScoop);
			}
			// if the flavor is tea
			if (flavor.equals("tea")) {
				// set the color to green
				g.setColor(Color.green);
				// draw the scoop with x and y coords, while decrementing y
				// depending on the scoop number
				// and add the overlapscoop
				g.fillOval(xCoord, yCoord - (scoopNum * diamScoop)
						+ (scoopNum * overlapScoop), diamScoop, diamScoop);
			}
			// if the flavor is strawberry
			if (flavor.equals("strawberry")) {
				// set the color to red
				g.setColor(Color.pink);
				// draw the scoop with x and y coords, while decrementing y
				// depending on the scoop number
				// and add the overlapscoop
				g.fillOval(xCoord, yCoord - (scoopNum * diamScoop)
						+ (scoopNum * overlapScoop), diamScoop, diamScoop);
			}
			// push the flavor on the original stack
			iceCreamCone.push(flavor);
			// increment the number of scoops based on how many we add
			scoopNum++;
		}

	}

	/**
	 * add flavor method pushes the flavors depending on the string
	 * 
	 * @param flavor
	 *            , of string type
	 */
	public void addFlavor(String flavor) {
		// if the string is vanilla, then push vanilla on the stack
		if (flavor.equals("vanilla")) {
			iceCreamCone.push("vanilla");
		}
		// if the string is strawberry, then push strawberry on the stack
		if (flavor.equals("strawberry")) {
			iceCreamCone.push("strawberry");
		}
		// if the string is chocoalte, then push chocolate on the stack
		if (flavor.equals("chocolate")) {
			iceCreamCone.push("chocolate");
		}
		// if the string is tea, then push tea on the stack
		if (flavor.equals("tea")) {
			iceCreamCone.push("tea");
		}
		// repaint
		repaint();

	}

	/**
	 * add a random scoop method
	 */
	public void addRandomScoop() {
		// create random num generator
		Random numGenerator = new Random();
		int num = numGenerator.nextInt(4);
		String flavor;
		// if num = 0, push vanilla
		if (num == 0) {
			flavor = "vanilla";
			iceCreamCone.push("vanilla");
		}
		// if num is 1, push strawberry
		if (num == 1) {
			flavor = "strawberry";
			iceCreamCone.push("strawberry");
		}
		// if num is 2, push chocolate
		if (num == 2) {
			flavor = "chocolate";
			iceCreamCone.push("chocolate");
		}
		// if num is 3, push tea
		if (num == 3) {
			flavor = "tea";
			iceCreamCone.push("tea");
		}
		// repaint
		repaint();
	}

	/**
	 * delete scoop method removes scoop on top of the stack First in last out
	 */
	public void deleteScoop() {
		// if ice cream cone is not empty
		if (!iceCreamCone.isEmpty()) {
			// pop
			iceCreamCone.pop();
		}
		// repaint
		repaint();
	}

}
