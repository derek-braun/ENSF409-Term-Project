package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NewItemWindow extends JFrame{
	private JTextField nameField;
	private JTextField idField;
	private JTextField priceField;
	private JTextField quantField;
	private JTextField supidField;
	private ManagerClient client;
	
	public NewItemWindow(ManagerClient client) {
		
		setBounds(100, 100, 457, 324);
		setResizable(false);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		this.client = client;
		
		nameField = new JTextField();
		nameField.setBounds(206, 33, 147, 20);
		panel.add(nameField);
		nameField.setColumns(10);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(206, 64, 147, 20);
		panel.add(idField);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(206, 95, 147, 20);
		panel.add(priceField);
		
		quantField = new JTextField();
		quantField.setColumns(10);
		quantField.setBounds(206, 126, 147, 20);
		panel.add(quantField);
		
		supidField = new JTextField();
		supidField.setColumns(10);
		supidField.setBounds(206, 157, 147, 20);
		panel.add(supidField);
		
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemName.setBounds(71, 34, 106, 14);
		panel.add(lblItemName);
		
		JLabel lblItemId = new JLabel("Item ID:");
		lblItemId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemId.setBounds(71, 67, 106, 14);
		panel.add(lblItemId);
		
		JLabel lblItemPrice = new JLabel("Item Price:");
		lblItemPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemPrice.setBounds(71, 98, 106, 14);
		panel.add(lblItemPrice);
		
		JLabel lblItemQuantitiy = new JLabel("Item Quantitiy");
		lblItemQuantitiy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemQuantitiy.setBounds(71, 129, 106, 14);
		panel.add(lblItemQuantitiy);
		
		JLabel lblSupplierId = new JLabel("Supplier ID:");
		lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupplierId.setBounds(71, 160, 106, 14);
		panel.add(lblSupplierId);
		
		JButton btnCreateItem = new JButton("Create Item");
		btnCreateItem.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            client.createNewItem(idField.getText(), nameField.getText(), quantField.getText(), priceField.getText(), supidField.getText());
	            dispose();
	         }
	    });
		btnCreateItem.setBounds(239, 216, 114, 23);
		panel.add(btnCreateItem);
		
		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	         }
	    });
		btnCancel.setBounds(71, 216, 114, 23);
		panel.add(btnCancel);
		
		setVisible(true);
	}
}
