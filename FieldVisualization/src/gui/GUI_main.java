package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

import control_structure.Defines;

public class GUI_main {
	JFrame main_frame = null;
	Tile[][] tiles = null;
	
	public GUI_main(){
		/**** JFrame main_frame setup ****/
		main_frame = new JFrame(Defines.JFRAME_NAME);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(Defines.JFRAME_INITIAL_SIZE);
		main_frame.setMinimumSize(Defines.JFRAME_INITIAL_SIZE);
		main_frame.setPreferredSize(Defines.JFRAME_INITIAL_SIZE);
		main_frame.setLocationRelativeTo(Defines.JFRAME_RELATIVE_COMPONENT_POSITION);
		main_frame.setLayout(new GridLayout(Defines.JFRAME_NUMBER_OF_ROWS, Defines.JFRAME_NUMBER_OF_COLS));
		tiles = new Tile[Defines.JFRAME_NUMBER_OF_ROWS][Defines.JFRAME_NUMBER_OF_COLS];
		populate_main_frame(Defines.JFRAME_NUMBER_OF_ROWS, Defines.JFRAME_NUMBER_OF_COLS, new Dimension(Defines.JFRAME_INITIAL_SIZE.width/Defines.JFRAME_NUMBER_OF_ROWS, Defines.JFRAME_INITIAL_SIZE.height/Defines.JFRAME_NUMBER_OF_COLS), Defines.TILE_INITIAL_COLOR);
	
		/**** Display GUI ****/
		main_frame.setVisible(true);
	}
	
	public void display_2D_array(int[][] data){
		int x = data.length, y = data[0].length;
		Color[][] color = Conversion.convert_2D_int_to_color(data);
		main_frame.getContentPane().removeAll();
		tiles = new Tile[x][y];
		main_frame.setLayout(new GridLayout(x, y));
		for(int ii = 0; ii < x; ii++){
			for(int jj = 0; jj < y; jj++){
				Tile t = new Tile(ii*x+jj, new Dimension(Defines.JFRAME_INITIAL_SIZE.width/x, Defines.JFRAME_INITIAL_SIZE.height/y), color[ii][jj], new Point(ii, jj), this);
				main_frame.add(t, ii, jj);
				tiles[ii][jj] = t;
			}
		}
		main_frame.repaint();
		main_frame.revalidate();
	}
	
	private void populate_main_frame(int n_rows, int n_cols, Dimension size, Color color){
		for (int ii = 0; ii < n_rows; ii++){
			for(int jj = 0; jj < n_cols; jj++){
				Tile t = new Tile(ii*n_cols+jj, size, color, new Point(ii,jj), this);
				main_frame.add(t, ii, jj);
				tiles[ii][jj] = t;
			}
		}
	}
	
	public void echo_mouse_position(Point locus){
		int max_iterations = 3, cur_iter = 1;
		Color base_color = new Color(0,0,0), change = new Color((255-base_color.getRed())/max_iterations,(255-base_color.getGreen())/max_iterations,(255-base_color.getBlue())/max_iterations);
		Color cur_color = new Color(change.getRed(), change.getGreen(), change.getBlue());
		
		ArrayList<Point> seen = new ArrayList<Point>();
		ArrayList<Point> pointStack = new ArrayList<Point>();
		ArrayList<Point> newPointStack = new ArrayList<Point>();
		seen.add(locus);
		pointStack.add(locus);
		while(pointStack.size() != 0){
			Point p = pointStack.get(0);
			pointStack.remove(0);
			for(int xx = -1; xx<2; xx++){
				for(int yy = -1; yy < 2; yy++){
					Point new_p = new Point(p.x+xx, p.y + yy);
					if(!seen.contains(new_p)){
						tiles[new_p.x][new_p.y].update_color(cur_color);
						seen.add(new_p);
						newPointStack.add(new_p);
					}
				}
			}
			if(pointStack.size() == 0){
				if(cur_iter < max_iterations){
					for(Point q : newPointStack){
						pointStack.add(q);
					}
					newPointStack.clear();
					cur_iter++;
					cur_color = new Color(cur_color.getRed()+change.getRed(), cur_color.getGreen()+change.getGreen(), cur_color.getBlue()+change.getBlue());
				}
			}
		}
	}
	
	public void echo_mouse_absense(Point locus){
		int max_iterations = 3, cur_iter = 1;
		Color base_color = new Color(0,0,0), change = new Color((255-base_color.getRed())/max_iterations,(255-base_color.getGreen())/max_iterations,(255-base_color.getBlue())/max_iterations);
		Color cur_color = new Color(255,255,255);
		
		ArrayList<Point> seen = new ArrayList<Point>();
		ArrayList<Point> pointStack = new ArrayList<Point>();
		ArrayList<Point> newPointStack = new ArrayList<Point>();
		seen.add(locus);
		pointStack.add(locus);
		while(pointStack.size() != 0){
			Point p = pointStack.get(0);
			pointStack.remove(0);
			for(int xx = -1; xx<2; xx++){
				for(int yy = -1; yy < 2; yy++){
					Point new_p = new Point(p.x+xx, p.y + yy);
					if(!seen.contains(new_p)){
						tiles[new_p.x][new_p.y].update_color(cur_color);
						seen.add(new_p);
						newPointStack.add(new_p);
					}
				}
			}
			if(pointStack.size() == 0){
				if(cur_iter < max_iterations){
					for(Point q : newPointStack){
						pointStack.add(q);
					}
					newPointStack.clear();
					cur_iter++;
				}
			}
		}
	}		
	
}
