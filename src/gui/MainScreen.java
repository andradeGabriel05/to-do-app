package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import sql.ProjectScreenSql;
import sql.TaskScreenSql;
import javax.swing.JTabbedPane;
import java.awt.Canvas;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel MainScreen;

	public MainScreen() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		MainScreen = new JPanel();
		MainScreen.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(MainScreen);
		MainScreen.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel bottom = new JPanel();
		MainScreen.add(bottom);
		bottom.setLayout(new GridLayout(0, 2, 30, 0));

		JPanel aside = new JPanel();
		bottom.add(aside);
		aside.setLayout(new GridLayout(0, 1, 30, 0));

		JPanel pnlButtonAside = new JPanel();
		aside.add(pnlButtonAside);
		pnlButtonAside.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		pnlButtonAside.add(panel, "name_1022515449200");
		panel.setLayout(new BorderLayout(0, 0));

		JButton btnAddProject = new JButton("New project");
		panel.add(btnAddProject, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel.add(panel_1, BorderLayout.CENTER);

		JPanel pnlContainerProject = new JPanel();
		panel_1.add(pnlContainerProject);
		
		JPanel pnlProjectName = new JPanel();
		pnlContainerProject.add(pnlProjectName);
		pnlProjectName.setLayout(new GridLayout(0, 1, 0, 0));


		try {
			ProjectScreenSql executeProjectSql = new ProjectScreenSql();
			
			executeProjectSql.openConnection();
			
			System.out.println("[MainScreen] Reading all projects...");
			String readProject = "SELECT * FROM project";
			Statement stmt = executeProjectSql.getConnection().createStatement();
			
			
			ResultSet rs = stmt.executeQuery(readProject);
			
			while(rs.next()) {
				String projectNumber = rs.getString(1);
				String projectName = rs.getString(2);
				String projectDescription = rs.getString(3);


				JLabel lblNewLabel = new JLabel(projectName);
				pnlProjectName.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				

			
				
			}			
			
			System.out.println("[MainScreen] All projects readed!");

		} catch (SQLException e3) {
			System.out.println("[MainScreen e3] Something went wrong... " + e3.getMessage());
		}

		btnAddProject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectScreen ps = new ProjectScreen();
				ps.setVisible(true);
			}
		});

		JPanel pnlMain = new JPanel();
		bottom.add(pnlMain);
		pnlMain.setLayout(new GridLayout(1, 1, 30, 0));

		JPanel pnlTasks = new JPanel();
		pnlMain.add(pnlTasks);
		pnlTasks.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_2 = new JPanel();
		pnlTasks.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JButton btnAddTask = new JButton("New task");
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaskScreen taskScreen = new TaskScreen();
				taskScreen.setVisible(true);
			}
		});
		panel_2.add(btnAddTask, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);

		JPanel pnlContainerName = new JPanel();
		panel_3.add(pnlContainerName);
		pnlContainerName.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnlName = new JPanel();
		pnlContainerName.add(pnlName);

		JLabel lblName = new JLabel("Name");
		pnlName.add(lblName);

		JPanel pnlContainerDesc = new JPanel();
		panel_3.add(pnlContainerDesc);
		pnlContainerDesc.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnlDesc = new JPanel();
		pnlContainerDesc.add(pnlDesc);

		JLabel lblDescription = new JLabel("Description");
		pnlDesc.add(lblDescription);

		JPanel pnlContainerPeriod = new JPanel();
		panel_3.add(pnlContainerPeriod);
		pnlContainerPeriod.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnlPeriod = new JPanel();
		pnlContainerPeriod.add(pnlPeriod);
		

		JLabel lblPeriod = new JLabel("Period");
		pnlPeriod.add(lblPeriod);

		JPanel pnlContainerTaskComp = new JPanel();
		panel_3.add(pnlContainerTaskComp);
		pnlContainerTaskComp.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnlTaskCompleted = new JPanel();
		pnlContainerTaskComp.add(pnlTaskCompleted);

		JLabel lblTaskCompleted = new JLabel("Task Completed");
		pnlTaskCompleted.add(lblTaskCompleted);

		JPanel pnlContainerDelete = new JPanel();
		panel_3.add(pnlContainerDelete);
		pnlContainerDelete.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnlDelete = new JPanel();
		pnlContainerDelete.add(pnlDelete);

		JLabel lblDelete = new JLabel("Delete");
		pnlDelete.add(lblDelete);

		try {
		    TaskScreenSql executeTaskSql = new TaskScreenSql();

		    executeTaskSql.openConnection();

		    System.out.println("[mainScreen] Reading all tasks...");

		    String readTable = "SELECT * FROM task";
		    Statement stmt = executeTaskSql.getConnection().createStatement();

		    ResultSet rs = stmt.executeQuery(readTable);

		    while (rs.next()) {
		        String taskNumber = rs.getString(1);
		        String name = rs.getString(2);
		        String description = rs.getString(3);
		        String period = rs.getString(4);
		        Byte task_completed = rs.getByte(5);


		                JLabel lblNameSql = new JLabel(name);
		                lblNameSql.setHorizontalAlignment(SwingConstants.CENTER);
		                pnlContainerName.add(lblNameSql);

		                JLabel lblDescriptionSql = new JLabel(description);
		                lblDescriptionSql.setHorizontalAlignment(SwingConstants.CENTER);
		                pnlContainerDesc.add(lblDescriptionSql);

		                JLabel lblPeriodSql = new JLabel(period);
		                lblPeriodSql.setHorizontalAlignment(SwingConstants.CENTER);
		                pnlContainerPeriod.add(lblPeriodSql);

		                JCheckBox chckbxTaskCompleted = new JCheckBox("");
		                chckbxTaskCompleted.setHorizontalAlignment(SwingConstants.CENTER);
		                pnlContainerTaskComp.add(chckbxTaskCompleted);

		                if (task_completed == 1) {
		                    chckbxTaskCompleted.setSelected(true);
		                }

		                chckbxTaskCompleted.addActionListener(new ActionListener() {
		                    @Override
		                    public void actionPerformed(ActionEvent e) {
		                        if (chckbxTaskCompleted.isSelected()) {
		                            try {
		                                System.out.println("[mainScreen] Completing task...");
		                                String sqlDelete = "UPDATE `task` SET task_completed = 1 WHERE idTask =" + taskNumber;
		                                stmt.executeUpdate(sqlDelete);
		                                System.out.println("[mainScreen] Task completed!");
		                                JOptionPane.showMessageDialog(null, "Task completed!");
		                            } catch (SQLException e2) {
		                                System.out.println("[MainScreen e2] Something went wrong... " + e2.getMessage());
		                            }
		                        } else {
		                            try {
		                                System.out.println("[mainScreen] Unmarking a completed task...");
		                                String sqlDelete = "UPDATE `task` SET task_completed = 0 WHERE idTask =" + taskNumber;
		                                stmt.executeUpdate(sqlDelete);
		                                System.out.println("[mainScreen] Task not completed!");
		                                JOptionPane.showMessageDialog(null, "Task not completed!");
		                            } catch (SQLException e2) {
		                                System.out.println("[MainScreen e2] Something went wrong... " + e2.getMessage());
		                            }
		                        }
		                    }
		                });

		                JButton btnDelete = new JButton("Delete Task");
		                btnDelete.setHorizontalAlignment(SwingConstants.CENTER);
		                pnlContainerDelete.add(btnDelete);

		                btnDelete.addActionListener(new ActionListener() {
		                    @Override
		                    public void actionPerformed(ActionEvent e) {
		                        System.out.println("[mainScreen] Deleting task... ");
		                        try {

		                            String sqlDelete = "DELETE FROM task WHERE idTask =" + taskNumber;
		                            stmt.executeUpdate(sqlDelete);
		                            System.out.println("[mainScreen] Task deleted!");
		                            JOptionPane.showMessageDialog(null, "Task deleted!");

		                            System.out.println("[mainScreen] Closing connection... ");

		                            executeTaskSql.closeConnection();

		                            
		                            dispose();
		                            setVisible(false);

		                            MainScreen reloadScreen = new MainScreen();
		                            reloadScreen.setVisible(true);
		                            
		                            
	

		                        } catch (SQLException e4) {
		                            System.out.println("[MainScreen e4] Something went wrong... " + e4.getMessage());
		                        }
		                    }
		                });


		    }

		    System.out.println("[mainScreen] All tasks read!");

		} catch (SQLException e1) {
		    e1.printStackTrace();
		}
	}
}
