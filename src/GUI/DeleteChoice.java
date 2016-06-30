package GUI;
//This file creates a menu to see all the tickets or delete a ticket.
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.DeleteProduct;

public class DeleteChoice extends JFrame{
	private JPanel jp;
	private JButton button1, button2, button3, button4;
	
	public DeleteChoice()
	{
		
		
		jp = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		button1 = new JButton("View the Products in Store");
		jp.add(button1);
		button2 = new JButton("Delete Product(s)");
		jp.add(button2);
		button4 = new JButton("Back to menu");
		jp.add(button4);
		button3 = new JButton("Exit");
		jp.add(button3);
		
		button1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ok) 
			{
				ProductViewer pv = new ProductViewer();
				pv.setLocationRelativeTo(null);
			}
		});
		
		button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ok) 
			{
				DeleteProduct dp = new DeleteProduct();
				dp.setLocationRelativeTo(null);
			}
		});
		
		button4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ok) 
			{
				dispose();
				AdminMenu m = new AdminMenu();
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container frame = button2.getParent();
				do
					frame = frame.getParent();
				while (!(frame instanceof JFrame));
				((JFrame) frame).dispose();
			}
		});
		
		setTitle("Delete Product");
		setSize(500, 100);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(jp, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args)
	{
		new DeleteChoice();
	}// end main
}