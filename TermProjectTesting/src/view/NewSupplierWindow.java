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

public class NewSupplierWindow extends JFrame{
	private JTextField nameField;
	private JTextField idField;
	private JTextField addressField;
	private JTextField contactField;
	private ManagerClient client;
	
	public NewSupplierWindow(ManagerClient client) {
		
		setBounds(100, 100, 457, 268);
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
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(206, 95, 147, 20);
		panel.add(addressField);
		
		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setBounds(206, 126, 147, 20);
		panel.add(contactField);
		
		JLabel lblSupplierName = new JLabel("Supplier Name:");
		lblSupplierName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupplierName.setBounds(71, 34, 125, 14);
		panel.add(lblSupplierName);
		
		JLabel lblSupplierID = new JLabel("Supplier ID:");
		lblSupplierID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupplierID.setBounds(71, 67, 106, 14);
		panel.add(lblSupplierID);
		
		JLabel lblSupplierAddress = new JLabel("Address:");
		lblSupplierAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupplierAddress.setBounds(71, 98, 106, 14);
		panel.add(lblSupplierAddress);
		
		JLabel lblSupplierContact = new JLabel("Contact");
		lblSupplierContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupplierContact.setBounds(71, 129, 106, 14);
		panel.add(lblSupplierContact);
		
		JButton btnCreateItem = new JButton("Create Supplier");
		btnCreateItem.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            client.createNewSupplier(idField.getText(), nameField.getText(), addressField.getText(), contactField.getText());
	            dispose();
	         }
	    });
		btnCreateItem.setBounds(206, 189, 147, 23);
		panel.add(btnCreateItem);
		
		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	         }
	    });
		btnCancel.setBounds(71, 189, 114, 23);
		panel.add(btnCancel);
		
		setVisible(true);
	}
}
