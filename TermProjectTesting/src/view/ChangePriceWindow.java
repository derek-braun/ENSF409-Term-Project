package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class ChangePriceWindow extends JFrame{
	protected JLabel lblItem;
	protected JTextField newPriceField;
	private ManagerClient client;
	
	public ChangePriceWindow(ManagerClient client, String item) {
		getContentPane().setLayout(null);
		this.client = client;
		
		setBounds(100, 100, 565, 219);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 551, 182);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		newPriceField = new JTextField();
		newPriceField.setBounds(266, 93, 117, 20);
		panel.add(newPriceField);
		newPriceField.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a1) {
				String[] splitString = item.split(" ");
				int index = 0;
				while(!splitString[index].equals("ID:")) {
					index++;
				}
				client.changeItemPrice(splitString[index + 1], newPriceField.getText());
				dispose();
			}
		});
		
		btnDone.setBounds(294, 134, 89, 23);
		panel.add(btnDone);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(153, 134, 89, 23);
		panel.add(btnCancel);
		
		JLabel lblNewPrice = new JLabel("New Price:");
		lblNewPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewPrice.setBounds(153, 93, 103, 14);
		panel.add(lblNewPrice);
		
		lblItem = new JLabel("Item");
		lblItem.setBounds(23, 39, 503, 14);
		panel.add(lblItem);
		
		lblItem.setText(item);
		
		setVisible(true);
	}

}
