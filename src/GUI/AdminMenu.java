package GUI;
//This file creates a menu for the administrator view

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminMenu
{
	public AdminMenu() 
	{
		String message = "Welcome to the admin menu." + "\n", response;

		message += "\n" + "Enter a number to choose an option:";
		message += "\n" + "  1 to view Products(s)";
		message += "\n" + "  2 to insert a Product";
		message += "\n" + "  3 to update a Product";
		message += "\n" + "  4 to delete a Product";
		message += "\n" + "  5 to exit" + "\n" + " ";

		char answer = 'Y';

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
						"Please enter 1-5 and try again", "Result",
						JOptionPane.PLAIN_MESSAGE);
				 new AdminMenu();
			} 
			else 
			{
				int choice = Integer.parseInt(response);

				switch (choice) 
				{
					case 1:
						PVChoice pvc = new PVChoice();
						answer = 'Y';  
						break;
					case 2:
						//InsertProduct Page not Complete
						answer = 'Y'; 
						break;
					case 3:
						//UpdateProduct Page not Complete
						answer = 'Y'; 
						break;
					case 4:
						DeleteChoice dc = new DeleteChoice();
						answer = 'Y'; 
						break;
					case 5:
						answer = 'N';
						break;
					default: {
						answer = 'Y';
						choice = 0;
						JOptionPane.showMessageDialog(null,
								"Enter a number: 1 - 5");
						new AdminMenu();
					}
				}// end switch
			}
		}// end try
		catch (Exception e) {
			System.out.println(e);
		}
			
		if (answer == 'N' || answer == 'n')
			JOptionPane.showMessageDialog(null, "Thank you, have a nice day!");
	}

	public static void main(String[] args) 
	{
		new AdminMenu();
	}// end main

}// end class