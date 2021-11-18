import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainOne {
	public static void main(String[] args) {
		Game g1= new Game();
	}
}
class Game extends JFrame implements ActionListener
{
	JLabel l;
	ImageIcon bg,defaultimg;
	JPanel p1,p2,p3;
	JLabel header, turnlabel,totalturn;
	JButton b[] = new JButton[12];
	JButton restart,home;
	int turns,counter=0,btncheck=0,score;
	String imgclick1,imgclick2;
	JButton btn1,btn2;
	public Game(){
		bg= new ImageIcon("src/imgs/b2.PNG");
		l= new JLabel(bg);
		l.setBounds(0,0,600, 600);

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p1.setBounds(0, 0, 600, 80);
		p1.setOpaque(false);
		p2.setBounds(0, 80, 584, 400);
		p2.setOpaque(false);
		p3.setBounds(0, 480, 584, 80);
		p3.setOpaque(false);

		p1.setLayout(null);
		header= new JLabel("Match the Emojis",JLabel.LEFT);
		header.setFont(new Font("Forte", Font.BOLD, 30));
		header.setForeground(Color.white);
		header.setBounds(20, 20,250 ,50 );
		turnlabel= new JLabel("Turns: "+turns);
		
		turnlabel.setFont(new Font("Forte", Font.BOLD, 30));
		turnlabel.setForeground(Color.white);
		turnlabel.setBounds(400, 20,250 ,50 );
		
		

		setbuttons();
		
		p3.setLayout(null);
		restart= new JButton("Restart");
		restart.setBounds(100, 20,100 ,40 );
		home = new JButton("Home");
		home.setBounds(390, 20,100 ,40 );
		restart.addActionListener(this);
		home.addActionListener(this);

		this.add(l);
		this.setBounds(400,70, 600, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		l.add(p1);
		l.add(p2);
		l.add(p3);
		p1.add(header);
		p1.add(turnlabel);
		p3.add(restart);
		p3.add(home);

	}
	public void setbuttons()
	{
		p2.setLayout(new GridLayout(3,3));
		defaultimg= new ImageIcon("src/imgs/markk.jpg");
		for(int i= 0; i<12;i++)
		{
			b[i]= new JButton();
			b[i].setBackground(Color.WHITE);
			p2.add(b[i]);
			b[i].setIcon(defaultimg);
			b[i].addActionListener(this);
		}

	}
	public void changeimage( JButton j)
	{

		if(j.equals(b[0]))
			b[0].setIcon(new ImageIcon("src/imgs/img1.png"));
		else if(j.equals(b[1]))
			b[1].setIcon(new ImageIcon("src/imgs/img2.png"));
		else if(j.equals(b[2]))
			b[2].setIcon(new ImageIcon("src/imgs/img6.png"));
		else if(j.equals(b[3]))
			b[3].setIcon(new ImageIcon("src/imgs/img7.png"));
		else if(j.equals(b[4]))
			b[4].setIcon(new ImageIcon("src/imgs/img4.png"));
		else if(j.equals(b[5]))
			b[5].setIcon(new ImageIcon("src/imgs/img8.png"));
		else if(j.equals(b[6]))
			b[6].setIcon(new ImageIcon("src/imgs/img7.png"));
		else if(j.equals(b[7]))
			b[7].setIcon(new ImageIcon("src/imgs/img8.png"));
		else if(j.equals(b[8]))
			b[8].setIcon(new ImageIcon("src/imgs/img2.png"));
		else if(j.equals(b[9]))
			b[9].setIcon(new ImageIcon("src/imgs/img4.png"));
		else if(j.equals(b[10]))
			b[10].setIcon(new ImageIcon("src/imgs/img1.png"));
		else if(j.equals(b[11]))
			b[11].setIcon(new ImageIcon("src/imgs/img6.png"));


	}
	
	
	public void restartButton(JButton jb)
	{
		if(restart.equals(jb))
		{
			new Game();
			dispose();
		}

	}
	public void homeButton(JButton jb)
	{
		if (home.equals(jb))
		{
			new firstpage();
			dispose();
		}

	}
	
	public void actionPerformed(ActionEvent e)
	{	

		JButton buttonClicked= (JButton) e.getSource();
		restartButton(buttonClicked);
		homeButton(buttonClicked);
		if(home!= buttonClicked && restart!= buttonClicked)
		{
			changeimage(buttonClicked);
			turns++;
			turnlabel.setText("Turns: "+turns);
			counter++;
			if (counter==1)
			{

				btn1 = buttonClicked ;
				this.imgclick1 = btn1.getIcon().toString();

			}
			if (counter == 2)
			{

				btn2 = buttonClicked ;
				this.imgclick2 = btn2.getIcon().toString();
			}	
			if (counter==2)
			{
				if(btn1==btn2)
				{
					JOptionPane.showMessageDialog(null, "Can't match the button with itself");
					btn1.setIcon(defaultimg);
				}
				else
				{
					if (imgclick1==imgclick2)
					{
						btn1.setEnabled(false);
						btn2.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Matched");
						score++;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Not Matched");
						btn1.setIcon(defaultimg);
						btn2.setIcon(defaultimg);
					}
				}	
				
				counter = 0;
				btn1 = null;
				btn2 = null; 

			}
			if(score==6)
				JOptionPane.showMessageDialog(null,"Congrats! You completed the game in "+turns+" turns");	
		}
		
		
	}

}

