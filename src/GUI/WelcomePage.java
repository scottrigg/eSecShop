package GUI;

//This file creates a menu for all the uses, and is also the launcher.
import javax.swing.JOptionPane;

//import productDetails.ProductMasterList;

public class WelcomePage
{
	public WelcomePage() 
	{
		String message = "Welcome to the Electronic Security Store." + "\n", response;

		message += "\n" + "Enter a number to choose an option. You are:";
		message += "\n" + "  1 Customer";
		message += "\n" + "  2 Administrator";
		message += "\n" + "  3 Neither (Exit)" + "\n" + " ";

		char answer = 'Y';

		//ProductMasterList pml = new ProductMasterList();
		//pml.fill();
		
		try {

			response = JOptionPane.showInputDialog(message);
			while (response == null || response.equals(""))
				response = JOptionPane.showInputDialog(message);

			// judge if input is string or number
			boolean isNumeric = true;

			for (int i = response.length(); --i >= 0;) 
			{
				if (!Character.isDigit(response.charAt(i))) 
				{
					isNumeric = false;
				}
			}

			if (isNumeric == false) 
			{
				JOptionPane.showMessageDialog(null,
						"Please enter 1-3 and try again", "Result",
						JOptionPane.PLAIN_MESSAGE);
				 new WelcomePage();

			} 
			else 
			{
				int choice = Integer.parseInt(response);

				switch (choice) {
				case 1:
					JOptionPane.showMessageDialog(null,
							"Notice: You can add items to your shopping cart and then checkout", "Notice",
							JOptionPane.PLAIN_MESSAGE);
					CustomerPage cp = new CustomerPage();
					answer = 'Y'; 
					break;
				case 2:
					AdminLogin li = new AdminLogin();
					answer = 'Y'; 
					break;
				case 3:
					answer = 'N'; 
					break;
				default: {
					answer = 'Y';
					choice = 0;
					JOptionPane.showMessageDialog(null,
							"Enter a number: 1 - 3");
					new WelcomePage();
				}
				}// end switch
			}
		}// end try
		catch (Exception e) 
		{
			System.out.println(e);
		}
		if (answer == 'N' || answer == 'n')
			JOptionPane.showMessageDialog(null, "Thank you, have a nice day!");
	}

	public static void main(String[] args) 
	{
		new WelcomePage();
	}// end main

}// end class