package gui;

import java.awt.Color;


public class Conversion {
	public static Color[][] convert_2D_int_to_color(int data[][]){
		Color[][] colors = new Color[data.length][data[0].length];
		for(int ii = 0; ii < data.length; ii++){
			for(int jj = 0; jj < data[ii].length; jj++){
				colors[ii][jj] = new Color(data[ii][jj],data[ii][jj],data[ii][jj]);
			}
		}
		return colors;
	}
}
