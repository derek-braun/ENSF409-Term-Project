
package view;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Font;

public class CustomerUI extends JFrame{
	
	protected DefaultListModel itemList;
	protected DefaultListModel cartList;
	protected JButton searchButton;
	protected JButton listAllButton;
	protected JButton addItem;
	protected JButton removeItem;
	protected JButton order;
	protected JList list;
	
	public CustomerUI() {
		System.out.println("Test Push 1");
		itemList = new DefaultListModel();
		cartList = new DefaultListModel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Tool Shop Customer Menu");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titleLabel.setBounds(5, 5, 776, 14);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(titleLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 225, 776, 33);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		
		searchButton = new JButton("Search");
		searchButton.setBackground(Color.WHITE);
		panel.add(searchButton);
		
		order = new JButton("Order");
		order.setBackground(Color.WHITE);
		panel.add(order);
		
		addItem = new JButton("Add");
		addItem.setBackground(Color.WHITE);
		panel.add(addItem);
		
		removeItem = new JButton("Remove");
		removeItem.setBackground(Color.WHITE);
		panel.add(removeItem);
		
		listAllButton = new JButton("List Items");
		listAllButton.setBackground(Color.WHITE);
		panel.add(listAllButton);
		
		list = new JList(itemList);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(15, 52, 422, 165);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(447, 52, 318, 165);
		contentPane.add(scrollPane_1);
		
		JList list_1 = new JList(cartList);
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblInventoryView = new JLabel("Inventory View");
		lblInventoryView.setForeground(Color.WHITE);
		lblInventoryView.setBounds(15, 30, 114, 14);
		contentPane.add(lblInventoryView);
		
		JLabel lblCartView = new JLabel("Cart View");
		lblCartView.setForeground(Color.WHITE);
		lblCartView.setBounds(447, 30, 114, 14);
		contentPane.add(lblCartView);
		
		setVisible(true);
	}
	
	protected void addListener(ActionListener al, JButton b) {
		b.addActionListener(al);
	}
}
