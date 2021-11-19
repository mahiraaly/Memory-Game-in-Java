import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class home 
{
	public static void main(String [] args)
	{
		new firstpage();
	}
}
class firstpage extends JFrame implements ActionListener
{
	JButton b;
	JLabel l;
	ImageIcon m;
	public firstpage() {
		b= new JButton();
		b.setBounds(350, 110, 100, 40);
		b.setText("PLAY");
		b.setFont(new Font("Arial", Font.BOLD, 14));
		b.setBackground(Color.cyan);
		b.addActionListener(this);
		m= new ImageIcon("src/imgs/background1.PNG");
		l=new JLabel(m);
		l.setBounds(0,0,600, 600);
		
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(400,70, 600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.add(l);
		l.add(b);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		new Game();
		dispose();
	}
	
}
