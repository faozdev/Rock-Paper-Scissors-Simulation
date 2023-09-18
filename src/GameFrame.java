import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class GameFrame extends JPanel {
	private List<Move> movingImages = new ArrayList<>();
	private Timer timer;
	MainFrame frame;
	final int elemanSayisi = 5;
	int adim = 5;
	
	private int rockNumber;
	private int paperNumber;
	private int scissorsNumber;
	
	int x,y;
	int dx,dy;
	int width,height;
	Image image;
	private Rectangle boundingBox;

	public GameFrame(int rockNumber,int paperNumber,int scissorsNumber ) {

		this.rockNumber = rockNumber;
	    this.paperNumber = paperNumber;
	    this.scissorsNumber = scissorsNumber;
	    
	    ImageIcon paper = new ImageIcon("img/Paper.png");
		Image imgPaper = paper.getImage();
		String paperLabel = "paper";
		
		ImageIcon rock = new ImageIcon("img/rock.png");
		Image imgRock = rock.getImage();
		String rockLabel = "rock";
		
		ImageIcon scissors = new ImageIcon("img/scissors.png");
		Image imgScissors = scissors.getImage();
		String scissorsLabel = "scissors";
		
		createImg(rockNumber, imgRock, rockLabel);
		createImg(paperNumber, imgPaper, paperLabel);
		createImg(scissorsNumber, imgScissors, scissorsLabel);	
	}
	
	public void createImg(int objNum, Image image, String imgLabel) {
			
		for(int i = 0; i < objNum; i++) {
			int width = image.getWidth(null);
			int height = image.getHeight(null);
            boolean overlap;
            do {
                overlap = false;
                int x = (int) (Math.random() * (800 - width)); // Adjust to panel width
                int y = (int) (Math.random() * (600 - height)); // Adjust to panel height
                for (Move otherImage : movingImages) {
                    if (otherImage.getBoundingBox().intersects(new Rectangle(x, y, width, height))) {
                        overlap = true;
                        break;
                    }
                }
                if (!overlap) {
                    movingImages.add(new Move(image, x, y, width, height, imgLabel));
                }
            } while (overlap);
        }
		timer = new Timer(60, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Move movingImage : movingImages) {
					movingImage.move(getWidth(),getHeight());
					for (Move otherImage : movingImages) {
                        if (movingImage != otherImage && movingImage.getBoundingBox().intersects(otherImage.getBoundingBox())) {
                            if(movingImage.imgLabel.equals("paper") && otherImage.imgLabel.equals("rock")) {
                            	otherImage.image = movingImage.image;
                            	otherImage.imgLabel = "paper";
                            	//movingImages.add(new Move(movingImage.image, otherImage.x, otherImage.y, otherImage.width, otherImage.height, movingImage.imgLabel));
                            	//movingImages.remove(otherImage);
                            }else if(movingImage.imgLabel.equals("rock") && otherImage.imgLabel.equals("scissors")) {
                            	otherImage.image = movingImage.image;
                            	otherImage.imgLabel = "rock";
                            	//movingImages.add(new Move(movingImage.image, otherImage.x, otherImage.y, otherImage.width, otherImage.height, movingImage.imgLabel));
                            	//movingImages.remove(otherImage);
                            }else if(movingImage.imgLabel.equals("scissors") && otherImage.imgLabel.equals("paper")) {
                            	otherImage.image = movingImage.image;
                            	otherImage.imgLabel = "scissors";
                            	//movingImages.add(new Move(movingImage.image, otherImage.x, otherImage.y, otherImage.width, otherImage.height, movingImage.imgLabel));
                            	//movingImages.remove(otherImage);
                            }
                            movingImage.dx = -movingImage.dx;
                            movingImage.dy = -movingImage.dy;
                        }
                        
                    }
                }
				repaint();
			}
		});
		timer.start();
	}
	
	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Move movingImage : movingImages) {
			movingImage.draw(g);	
		}
	}
	
	
	public void display() {
        SwingUtilities.invokeLater(() -> {
			 JFrame frame = new JFrame("Rock Paper Scissors Simulation");
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            GameFrame panel = new GameFrame(rockNumber,paperNumber,scissorsNumber);
            frame.add(panel);
            frame.setVisible(true);
		 });
	  }
}
