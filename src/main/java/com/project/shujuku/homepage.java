package com.project.shujuku;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class homepage extends JFrame {

	private JPanel contentPane;
	private studentpage studentFrame;
	private systemadmin systemadminFrame;
	private dormitory_admins dormitory_adminsFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
					frame.setTitle("首页");
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5B66\u751F\u5BDD\u5BA4\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("等线", Font.PLAIN, 24));
		label.setBounds(159, 85, 359, 58);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\u5B66\u751F\u7AEF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                try {
                    studentFrame = new studentpage();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                studentFrame.setTitle("学生管理端");
	             studentFrame.setVisible(true);
	             setVisible(false);
			}
		});
		btnNewButton.setBounds(25, 213, 174, 66);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u5BDD\u5BA4\u697C\u7BA1\u7406\u7AEF");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                try {
                    dormitory_adminsFrame = new dormitory_admins();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                dormitory_adminsFrame.setTitle("寝室楼管理端");
				 dormitory_adminsFrame.setVisible(true);
	             setVisible(false);
			}
		});
		button.setBounds(227, 213, 174, 66);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u7CFB\u7EDF\u7BA1\u7406\u7AEF");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                    systemadminFrame = new systemadmin();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                systemadminFrame.setTitle("系统管理端");
				 systemadminFrame.setVisible(true);
	             setVisible(false);
			}
		});
		button_1.setBounds(431, 213, 174, 66);
		contentPane.add(button_1);
	}
}
