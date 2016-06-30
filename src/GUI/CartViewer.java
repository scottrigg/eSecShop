package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import order.ShoppingCart;
import productData.Product;
import java.util.ArrayList;

public class CartViewer extends JFrame 
{
	
	private JTable table;
	
	ArrayList<Product> plist = new ArrayList<Product>();
	public CartViewer() 
	{
		
		
		
		String[] columnNames = { "Product ID.", "Product Name","Product Type", "Description", "Price"}; // column name
		Object[][] rowData = new Object[50][14]; // column and array number
		ShoppingCart sc = new ShoppingCart();
		plist = ShoppingCart.getCart();
		
		try {
				int count = 0;
				// STEP 5: Extract data from result set
				for (Product p :plist) 
				{
					rowData[count][0] = p.getProductID();
					rowData[count][1] = p.getName();
					rowData[count][2] = p.getType();
					rowData[count][3] = p.getStatement();
					rowData[count][4] = p.getPrice();
					count++;
				}

		}
		catch (Exception ex) 
		{
			ex.printStackTrace(); 
		} 
		finally 
		{
			Container container = getContentPane(); 
			table = new JTable(rowData, columnNames); 
			container.add(new JScrollPane(table), BorderLayout.CENTER); 
			setSize(1200, 400); 
			setVisible(true); 
			this.setTitle("All product information");
			this.setLocationRelativeTo(null);
			
		}
	}// end ViewTable

} // end class