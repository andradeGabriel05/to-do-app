package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql.ProjectScreenSql;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class ProjectScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField projectName;
	private JTextField projectDesc;


	public ProjectScreen() {
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
		
		JLabel lblNewProject = new JLabel("Add new project");
		lblNewProject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewProject);
		
		JPanel pnlName = new JPanel();
		contentPane.add(pnlName);
		pnlName.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTaskName = new JLabel("Task name");
		lblTaskName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlName.add(lblTaskName);
		
		projectName = new JTextField();
		projectName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		projectName.setColumns(10);
		pnlName.add(projectName);
		
		JPanel pnlDesc = new JPanel();
		contentPane.add(pnlDesc);
		pnlDesc.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTaskDesc = new JLabel("Task description");
		lblTaskDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnlDesc.add(lblTaskDesc);
		
		projectDesc = new JTextField();
		projectDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		projectDesc.setColumns(10);
		pnlDesc.add(projectDesc);
		
		JPanel pnlAddButton = new JPanel();
		contentPane.add(pnlAddButton);
		pnlAddButton.setLayout(new CardLayout(0, 30));
		
		JButton btnAddNewProject = new JButton("Add new project");
		pnlAddButton.add(btnAddNewProject);
		
		btnAddNewProject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectScreenSql projectScreenSql = new ProjectScreenSql();
				projectScreenSql.addProject(projectName.getText(), projectDesc.getText());
			}
		});
	}

}
