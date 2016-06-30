package GUI;
import javax.swing.JOptionPane;
import java.lang.String; 

public class AdminLogin 
{
	public AdminLogin()
	{
		result();
	}
	
	public static boolean accessname(String name) 
	{
		String message, password = "";
		boolean access = false;
		if (name.equals("ADMIN")) 
		{
			JOptionPane.showMessageDialog(null, "Hello: " + name);
			message = "Please enter your password:";
			message += "\n" + " ";

			for (int i = 1; i <= 3; i++) 
			{
				password = JOptionPane.showInputDialog(message);
				if (accpassword(password)) 
				{
					access = true;
					break;
				}

				else 
				{
					if (i == 3) 
					{
						JOptionPane.showMessageDialog(null, "Login failed");
						System.exit(1);
					} 
					else
					{
						JOptionPane.showMessageDialog(null,
								"Incorrect password, you can try " + (3 - i)
										+ " more times.");
					}
				}
			}
		}

		return access;
	}

	public static boolean accpassword(String password) 
	{
		boolean access = false;
		password = password.trim();
		password = password.toUpperCase();

		if (password.equals("FINAL")) 
		{
			access = true;
		}
		return access;
	}
	
	static void result() 
	{
		boolean access = false;
		String message = "Welcome:" + "\n", response;
		String name = "";
		message += "Please enter admin name:";
		message += "\n" + " ";
		for (int i = 1; i <= 3; i++) 
		{
			name = JOptionPane.showInputDialog(message);
			name = name.trim();
			name = name.toUpperCase();
			if (accessname(name)) 
			{
				access = true;
				break;
			} 
			else 
			{
				if (i == 3) 
				{
					JOptionPane.showMessageDialog(null, "login failed");
					System.exit(1);
				} 
				else
					JOptionPane.showMessageDialog(null,
							"incorrect login, you can try " + (3 - i)
									+ " more times");
			}

		}
		if (access == true) 
		{
			try 
			{
				AdminMenu m = new AdminMenu();
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
	}
	
	public static void main(String[] args)
	{
		 new AdminLogin();
	}
}// end class