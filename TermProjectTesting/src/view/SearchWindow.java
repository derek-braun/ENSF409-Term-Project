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
	private JTextField textField_1;
	private ShopClient client;
	
	public SearchWindow(ShopClient client) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 150);
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("Item Name");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(75, 30, 105, 14);
		panel_1.add(lblId);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setBounds(245, 93, 1, 1);
		panel_1.add(horizontalGlue);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(239, 30, 184, 20);
		panel_1.add(textField_1);
		
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
	            client.requestSearch(textField_1.getText());
	            dispose();
	         }
	    });
		
		setVisible(true);
	}
}
