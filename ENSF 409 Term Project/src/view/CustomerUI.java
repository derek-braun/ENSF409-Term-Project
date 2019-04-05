package view;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class CustomerUI extends JFrame{
	private CustomerClient customerClient;
	
	public CustomerUI(String serverName, int portNumber) {
		System.out.println("Test Push 1");
		customerClient = new CustomerClient(serverName, portNumber);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("Tool Shop Customer Menu");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(titleLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(Color.WHITE);
		panel.add(searchButton);
		
		JButton order = new JButton("Order");
		order.setBackground(Color.WHITE);
		panel.add(order);
		
		JButton addItem = new JButton("Add");
		addItem.setBackground(Color.WHITE);
		panel.add(addItem);
		
		JButton removeItem = new JButton("Remove");
		removeItem.setBackground(Color.WHITE);
		panel.add(removeItem);
		
		JButton viewOrder = new JButton("View");
		viewOrder.setBackground(Color.WHITE);
		panel.add(viewOrder);
		
		JList list = new JList();
		JScrollPane scrollPane = new JScrollPane(list);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(list);
	}
	
	private void searchItem(String name) {
		customerClient.requestSearch(name);
	}
	
	private void placeOrder(String id) {
		customerClient.requestPlaceOrder(id);
	}
	
	private void addToCart() {

	}
	
	private void removeFromCart() {
		
	}
	
	private void viewOrder() {
		
	}
	
	private void addListener(ActionListener al, Button b) {
		b.addActionListener(al);
	}
}
