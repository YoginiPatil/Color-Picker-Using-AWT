import java.awt.*;
import java.awt.event.*;
class ColorPicker
{
	public static void main(String args[])
	{
		ScrollBarFrame f1 = new ScrollBarFrame();
		f1.show();
	}
}
class ScrollBarFrame extends Frame implements AdjustmentListener
{
	Label red,blue,green;
	Label redTextLabel,blueTextLabel,greenTextLabel;
	Scrollbar redsc,greensc,bluesc;

	int r,g,b;
	ScrollBarFrame()
	{
		setSize(800,500);
		setLocation(100,70);
		setTitle("Scroll Bar Frame");
		setVisible(true);

		setLayout(null);

		red = new Label("RED");
		green = new Label("GREEN");
		blue = new Label("BLUE");

		redTextLabel = new Label("0");
		greenTextLabel = new Label("0");
		blueTextLabel = new Label("0");

		/*Scrollbar(orientation , init_val , bubble_size , min ,max)
		orientation - Scrollbar.VERTICAL /Scrollbar.HORIZONTAL		*/
		redsc = new Scrollbar(Scrollbar.VERTICAL,0,1,0,256);
		greensc = new Scrollbar(Scrollbar.VERTICAL,0,1,0,256);
		bluesc = new Scrollbar(Scrollbar.VERTICAL,0,1,0,256);

		red.setBounds(50,30,50,15);
		green.setBounds(120,30,50,15);
		blue.setBounds(200,30,50,15);

		redsc.setBounds(55,50,20,200);
		greensc.setBounds(130,50,20,200);
		bluesc.setBounds(210,50,20,200);

		redTextLabel.setBounds(55,270,50,15);
		greenTextLabel.setBounds(130,270,50,15);
		blueTextLabel.setBounds(210,270,50,15);

		add(red);
		add(green);
		add(blue);

		add(redsc);
		add(greensc);
		add(bluesc);

		add(redTextLabel);
		add(greenTextLabel);
		add(blueTextLabel);

		redsc.addAdjustmentListener(this);
		greensc.addAdjustmentListener(this);
		bluesc.addAdjustmentListener(this);
	}
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		r = redsc.getValue();
		g = greensc.getValue();
		b = bluesc.getValue();

		redTextLabel.setText(""+r);
		greenTextLabel.setText(""+g);
		blueTextLabel.setText(""+b);

		setBackground(new Color(r,g,b));
	}
}