package view;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ShopUI extends JFrame{
	
	protected JButton viewOrder;
	protected JButton searchButton;
	
	public ShopUI() {
		System.out.println("Test Push");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("Tool Shop Owner Menu");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(titleLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		searchButton = new JButton("Search");
		searchButton.setBackground(Color.WHITE);
		panel.add(searchButton);
		
		JButton order = new JButton("Order");
		order.setBackground(Color.WHITE);
		panel.add(order);
		
		JButton addItem = new JButton("Add Item");
		addItem.setBackground(Color.WHITE);
		panel.add(addItem);
		
		JButton addSupplier = new JButton("Add Supplier");
		addSupplier.setBackground(Color.WHITE);
		panel.add(addSupplier);
		
		JButton changePrice = new JButton("Change Price");
		changePrice.setBackground(Color.WHITE);
		panel.add(changePrice);
		
		viewOrder = new JButton("View");
		viewOrder.setBackground(Color.WHITE);
		panel.add(viewOrder);
		
		JList list = new JList();
		JScrollPane scrollPane = new JScrollPane(list);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(list);
		
		setVisible(true);
	}
	
	public void addListener(ActionListener al, JButton b) {
		b.addActionListener(al);
	}
}
