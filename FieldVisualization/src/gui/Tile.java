package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tile extends JPanel implements MouseListener{
	/**** Class Global Variables ****/
	private int ID = 0;
	private Dimension size = null;
	private Color color = Color.white;
	
	/**** Class Construction ****/
	public Tile(int ID, Dimension initial_size, Color initial_color){
		this.ID = ID;
		this.size = initial_size;
		this.setSize(size);
		this.setBounds(0,0,size.width, size.height);
		this.color = initial_color;
		this.setBackground(color);
		this.addMouseListener(this);
		
	}
	
	/***Dimensional Overrides***/
	@Override
	public Dimension getMinimumSize(){
		return size;
	}
	@Override 
	public Dimension getPreferredSize(){
		return size;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.setBackground(Color.RED);
		this.repaint();
		this.revalidate();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.setBackground(Color.BLACK);
		this.repaint();
		this.revalidate();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.setBackground(Color.WHITE);
		this.repaint();
		this.revalidate();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
