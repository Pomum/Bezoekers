import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Bezoeker 
{
	Point2D positie;
	double rotation;
	double speed;
	Point2D target;
	Shape s;
	Shape s1;
	
	Image image = new ImageIcon("visitor.png").getImage();

	public Bezoeker(Point2D positie, Shape s, Shape s1) 
	{
		super();
		this.positie = positie;
		this.rotation = Math.random()*360;
		this.speed = 5;
		denkNa();
		this.s = s;
		this.s1 = s1;
	}

	void update(ArrayList<Bezoeker> andereBezoekers)
	{
		rotations();
		
		Point2D oldPositie = positie;
		positie = new Point2D.Double(positie.getX() + speed * Math.cos(rotation), positie.getY() + speed * Math.sin(rotation));

		if(hasCollision(andereBezoekers))
		{
			positie = oldPositie;
			rotation += 0.2;
		}	
		newTarget();
	}
	
	public void newTarget()
	{
		if(s.contains(positie))
		{
			target = new Point2D.Double(400,50);
		}
		
		if(s1.contains(positie))
		{
			target = new Point2D.Double(400,700);
		}
	}
	
	
	void paint(Graphics2D g)
	{
		AffineTransform tx = new AffineTransform();
		tx.translate(positie.getX()-15/2, positie.getY()-15/2);
		tx.rotate(rotation, 8, 8);
		
		g.drawImage(image, tx ,null);
	}

	public boolean hasCollision(ArrayList<Bezoeker> bezoekers) 
	{
		for(Bezoeker b : bezoekers)
		{
			if(b == this)
				continue;
			if(b.positie.distance(positie) < 15)
				return true;
		}
		return false;
	}
	
	public void denkNa()
	{
		double random = Math.random() * 10;
		
		if(random >= 0 && random <= 4)
		{
			target = new Point2D.Double(400, 700);
		}
		else
		{
			target = new Point2D.Double(400,50);
		}
	}
	
	public void rotations()
	{
		rotation+=0.01;
		
		Point2D difference = new Point2D.Double(
				target.getX() - positie.getX(),
				target.getY() - positie.getY()
				);
		
		double newRotation = Math.atan2(difference.getY(), difference.getX());
		double rotDifference = rotation - newRotation;
		
		while(rotDifference > Math.PI)
		{
			rotDifference -= 2 * Math.PI;
		}
		while(rotDifference < -Math.PI)
		{
			rotDifference += 2 * Math.PI;
		}
		if(Math.abs(rotDifference) < 0.1)
		{
			rotation = newRotation;
		}
		else if(rotDifference < 0)
		{
			rotation += 0.1;
		}
		else if(rotDifference > 0)
		{
			rotation -= 0.1;
		}
	}
}
