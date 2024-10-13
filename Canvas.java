import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	ArrayList<Double> cords;
	double min_latt;
	double max_latt;
	double min_lon;
	double max_lon;
	
	public Canvas(ArrayList<Double> cords) {
		this.cords = cords;

	}
	
	public double factorLat(ArrayList<Double> cords) {
		min_latt = Double.MAX_VALUE;
		max_latt = Double.MIN_VALUE;
		for (int i = 0; i < cords.size(); i+=2) {
			double ch = cords.get(i);
			if (ch < min_latt) min_latt = ch;
			if (ch > max_latt) max_latt = ch;
		}
		double diff = max_latt - min_latt;
		double factor = (1000)/diff;
		
		return factor;
	}
	public double factorLon(ArrayList<Double> cords) {
		min_lon = Double.MAX_VALUE;
		max_lon = -1*Double.MAX_VALUE;
		for (int i = 1; i < cords.size(); i+=2) {
			double ch = cords.get(i);
			if (ch < min_lon) min_lon = ch;
			if (ch > max_lon) max_lon = ch;
				
		}
		double diff = max_lon - min_lon;
		double factor = (1000)/diff;
		
		return factor;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		double factorLatt = factorLat(cords);
		System.out.println("factorLatt: " + factorLatt);
		double factorLon = factorLon(cords);
		System.out.println("factorLon: " + factorLon);
		
		for (int i = 0; i < cords.size(); i=i+4) {
			
			
			int x1 = (int) Math.round((cords.get(i) - min_latt)*factorLatt);
			int y1 = (int) Math.round((cords.get(i+1)-min_lon)*factorLon);
			int x2 = (int) Math.round((cords.get(i+2) - min_latt)*factorLatt);
			int y2 = (int) Math.round((cords.get(i+3)-min_lon)*factorLon);
			g.drawLine(x1, y1, x2, y2);

		}
		
	
	}

}
