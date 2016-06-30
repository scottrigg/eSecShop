package GUI;
//This file creates a menu to select and view all tickets, or tickets that match the customer name
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomerPage extends JFrame 
{
	private JPanel jp4;
	private JButton button1, button2, button3, button4,button5;

	public CustomerPage() 
	{
		jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		button1 = new JButton("View all Products");
		jp4.add(button1);
		
		button2 = new JButton("Order a Product");
		jp4.add(button2);
		button3 = new JButton("View shopping cart");
		jp4.add(button3);
		button4 = new JButton("Checkout");
		jp4.add(button4);
		button5 = new JButton("Exit");
		jp4.add(button5);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ok) {
				ProductViewer pv = new ProductViewer();
				pv.setLocationRelativeTo(null);
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ok) {
			AddToCart a = new AddToCart();
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ok) {
				CartViewer cv = new CartViewer();
				cv.setLocationRelativeTo(null);
			}
		});
		
//		button4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ok) {
//				//Put the Checkout Menu here, incomplete
//				cv.setLocationRelativeTo(null);
//			}
//		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container frame = button4.getParent();
				do
					frame = frame.getParent();
				while (!(frame instanceof JFrame));
				((JFrame) frame).dispose();
			}
		});
		add(jp4, BorderLayout.CENTER);
		setTitle("Type in the ticket number you want to see");
		setSize(380, 80);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new CustomerPage();
	}// end main
}