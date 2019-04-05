package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.ManagerUIController.OperationListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.Box;

public class SearchWindow extends JFrame{
	private JTextField idField;
	private ShopClient client;
	private JTextField nameField;
	
	public SearchWindow(ShopClient client) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 184);
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("Item ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(75, 62, 105, 14);
		panel_1.add(lblId);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setBounds(245, 93, 1, 1);
		panel_1.add(horizontalGlue);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(245, 62, 184, 20);
		panel_1.add(idField);
		
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblItemName.setBounds(75, 28, 105, 14);
		panel_1.add(lblItemName);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(245, 28, 184, 20);
		panel_1.add(nameField);
		
		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	         }
	    });
		
		JButton btnDone = new JButton("Done");
		panel.add(btnDone);
		btnDone.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 String send;
	        	 if(!nameField.getText().equals("")) {
	        		 send = nameField.getText();
	        	 }
	        	 else {
	        		 send = idField.getText();
	        	 }
	        	
	             client.requestSearch(send);
	             dispose();
	         }
	    });
		
		setVisible(true);
	}
}
