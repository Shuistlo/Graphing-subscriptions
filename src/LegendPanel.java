import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import javax.swing.JPanel;

public class LegendPanel extends JPanel {
	private int width;
	private int height;  //the width and height of the JPanel.
	private LinkedList <Country> countries;
	private Font font;
	private Color [] colors;
	private final int HEIGHT_OF_ONE = 30;
	private final int MARGIN = 20;
	
	/**
	 * set the color palette of 252 random color to plot the legend
	 */
	public void setColors(Color [] newColors) {
		this.colors = newColors;
	}
	
	/**
	 * constructor which takes in width and height and data LinkedList of Country
	 */
	public LegendPanel (int newWidth, int newHeight, LinkedList <Country> countries) {
		this.width = newWidth - MARGIN;
		this.height = HEIGHT_OF_ONE;
	    this.setPreferredSize(new Dimension(width, height));
	    this.countries = countries;
		this.font = new Font("San Serif", Font.PLAIN, 12);
	}
	
	/**
	 * draws legend for LinkedList of Country using the eight named colors from Color class
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Iterator<Country> itr = countries.iterator();
		int counter = 1;
		this.height = 30;
		while (itr.hasNext()) {
			Country currentCountry = itr.next();
			g2d.setColor(colors[(counter-1)]);
	        g2d.fillRect(15, counter*HEIGHT_OF_ONE, 20, 10);
			g2d.setColor(Color.BLACK);
			g2d.setFont(font);
			g2d.drawString(currentCountry.getName(), 50, counter * HEIGHT_OF_ONE + 10);
			counter += 1;
			this.height += HEIGHT_OF_ONE;
		    this.setPreferredSize(new Dimension(width, height));
		}
	}
}
