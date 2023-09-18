import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

public class Move {
	int x,y,totalNum;
	int dx,dy;
	final int width,height;
	Image image;
	private final Rectangle boundingBox;
	public String imgLabel;
	public Image img;
	
	public Move(Image image, int x, int y, int width, int height, String imgLabel) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.imgLabel = imgLabel;
		
		Random random = new Random();
		dx = random.nextInt(5) + 1;
		dy = random.nextInt(5) + 1;
		boundingBox = new Rectangle(x, y, width, height);
	}
	public void move(int panelWidth, int panelHeight) {
		x += dx;
		y += dy;
		
		if(x <= 0 || x + width >= panelWidth)
			dx = -dx;
		else if (y <= 0 || y + height >= panelHeight)
			dy = -dy;
		
		boundingBox.setBounds(x, y, width, height);
	}
	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}
	public Rectangle getBoundingBox() {
        return boundingBox;
    }
	public void setImage(Image newImage) {
        this.img = newImage;
    }
}
