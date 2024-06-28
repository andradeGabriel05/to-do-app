package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;

public class mainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel MainScreen;

	public mainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		MainScreen = new JPanel();
		MainScreen.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(MainScreen);
		MainScreen.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel = new JPanel();
		MainScreen.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JPanel bottom = new JPanel();
		MainScreen.add(bottom);
		bottom.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel aside = new JPanel();
		bottom.add(aside);
		aside.setLayout(new GridLayout(0, 1, 30, 0));
		
		JPanel pnlButtonAside = new JPanel();
		aside.add(pnlButtonAside);
		pnlButtonAside.setLayout(new CardLayout(0, 0));
		
		JButton btnAddProject = new JButton("New project");
		pnlButtonAside.add(btnAddProject);
		btnAddProject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectScreen projectScreen = new ProjectScreen();
				projectScreen.setVisible(true);
				
			}
		});
		
		JPanel pnlProjects = new JPanel();
		aside.add(pnlProjects);
		
		JPanel pnlMain = new JPanel();
		bottom.add(pnlMain);
		pnlMain.setLayout(new GridLayout(2, 1, 30, 0));
		
		JPanel pnlButtonMain = new JPanel();
		pnlMain.add(pnlButtonMain);
		pnlButtonMain.setLayout(new CardLayout(0, 0));
		
		JButton btnAddTask = new JButton("New task");
		pnlButtonMain.add(btnAddTask);
		btnAddTask.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TaskScreen taskScreen = new TaskScreen();
				taskScreen.setVisible(true);
			}
		});
		
		JPanel pnlTasks = new JPanel();
		pnlMain.add(pnlTasks);
		
		JPanel pnlName = new JPanel();
		pnlTasks.add(pnlName);
		
		JLabel lblName = new JLabel("Name");
		pnlName.add(lblName);
		
		JPanel pnlDesc = new JPanel();
		pnlTasks.add(pnlDesc);
		
		JLabel lblDescription = new JLabel("Description");
		pnlDesc.add(lblDescription);
		
		JPanel pnlPeriod = new JPanel();
		pnlTasks.add(pnlPeriod);
		
		JLabel lblPeriod = new JLabel("Period");
		pnlPeriod.add(lblPeriod);
		
		JPanel pnlTaskCompleted = new JPanel();
		pnlTasks.add(pnlTaskCompleted);
		
		JLabel lblTaskCompleted = new JLabel("Task Completed");
		pnlTaskCompleted.add(lblTaskCompleted);
		
		JPanel pnlDelete = new JPanel();
		pnlTasks.add(pnlDelete);
		
		JLabel lblDelete = new JLabel("Delete");
		pnlDelete.add(lblDelete);
		
		
	}

}
