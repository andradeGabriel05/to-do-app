package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql.TaskScreenSql;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.CardLayout;


public class TaskScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfTaskName;
	private JTextField txfTaskDesctiption;
//	private JTextField txfTaskPeriod;
	private JTextField txfTaskPeriod;


	public TaskScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(30);
		contentPane.add(panel);
		
		JLabel lblNewTask = new JLabel("Add new task");
		lblNewTask.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewTask);
		
		JPanel pnlName = new JPanel();
		contentPane.add(pnlName);
		pnlName.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTaskName = new JLabel("Task name");
		lblTaskName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlName.add(lblTaskName);
		
		txfTaskName = new JTextField();
		txfTaskName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlName.add(txfTaskName);
		txfTaskName.setColumns(10);
		
		JPanel pnlDesc = new JPanel();
		contentPane.add(pnlDesc);
		pnlDesc.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTaskDesc = new JLabel("Task description");
		lblTaskDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlDesc.add(lblTaskDesc);
		
		txfTaskDesctiption = new JTextField();
		txfTaskDesctiption.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txfTaskDesctiption.setColumns(10);
		pnlDesc.add(txfTaskDesctiption);
		
		JPanel pnlPeriod = new JPanel();
		contentPane.add(pnlPeriod);
		pnlPeriod.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTaskPeriod = new JLabel("Period");
		lblTaskPeriod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlPeriod.add(lblTaskPeriod);
		
		txfTaskPeriod = new JTextField();
		pnlPeriod.add(txfTaskPeriod);
		txfTaskPeriod.setColumns(10);
		
		txfTaskPeriod = new JTextField();
		txfTaskPeriod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txfTaskPeriod.setColumns(10);
		
		JPanel pnlAddButton = new JPanel();
		contentPane.add(pnlAddButton);
		pnlAddButton.setLayout(new CardLayout(0, 30));
		
		JButton btnAddTask = new JButton("Add new task");
		pnlAddButton.add(btnAddTask);
		btnAddTask.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TaskScreenSql taskSql = new TaskScreenSql();
				taskSql.addTask(txfTaskName.getText(), txfTaskDesctiption.getText(), txfTaskPeriod.getText());
				
			}
		});
	}

}
