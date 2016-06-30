package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import productData.ProductCatalog;

public class DeleteProduct extends JFrame 
{

	private String id;
	private String number = "";
	
	
	public DeleteProduct() 
	{
		int repeat = 0;
		String answer;
		try 
		{
			Select();

			answer = JOptionPane.showInputDialog("Are you sure you want to delete Product#"
						+ id
						+ "?\n"
						+ "enter 1: YES \n"
						+ "enter other number: NO");
			repeat = Integer.parseInt(answer);
			if (repeat == 1)
				Delete();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Warning: Product not found!");
		}
	}// end of UpdateProduct()

	public void Select() 
	{
		try 
		{

			number = JOptionPane
					.showInputDialog("Please input the product ID which you would like to delete");
			//id = Integer.parseInt(number);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Delete() throws Exception 
	{

			//id = Integer.parseInt(number);
			ProductCatalog pc = new ProductCatalog();
				pc.rmProduct(id);
				pc.save();
				JOptionPane.showMessageDialog(null,
						"Deleted ticket#" + id+ " successfully! ");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new DeleteProduct();
	}// end main
}