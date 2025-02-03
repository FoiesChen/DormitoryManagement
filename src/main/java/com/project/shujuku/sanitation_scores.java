package com.project.shujuku;

import com.project.mapper.SanitationMapper;
import com.project.pojo.SanitationList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class sanitation_scores extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sanitation_scores frame = new sanitation_scores();
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
	public sanitation_scores() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		SanitationMapper sanitationMapper = sqlSession.getMapper(SanitationMapper.class);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u536B\u751F\u8BC4\u5206\u8BB0\u5F55\u7F16\u53F7\uFF1A");
		label.setBounds(14, 13, 144, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(172, 10, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				//查询自记录编号
				List<SanitationList> student = sanitationMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (SanitationList students : student) {
					Object[] rowData = {students.getSanitation_scores_id(), students.getEmployee_id(), students.getDormitory_id(), students.getPublish_time(), students.getScore()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button.setBounds(272, 9, 113, 27);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u53D1\u5E03\u8BB0\u5F55\u7BA1\u7406\u5458\u7F16\u53F7\uFF1A");
		label_1.setBounds(14, 44, 178, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BDD\u5BA4\u7F16\u53F7\uFF1A");
		label_2.setBounds(14, 75, 178, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u53D1\u5E03\u65F6\u95F4\uFF1A");
		label_3.setBounds(14, 106, 178, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u8BC4\u5206\u5206\u6570\uFF1A");
		label_4.setBounds(14, 137, 178, 18);
		contentPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(172, 41, 86, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(172, 75, 86, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(172, 103, 86, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(172, 137, 86, 24);
		contentPane.add(textField_4);
		
		JButton button_5 = new JButton("\u53D1\u5E03");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
			    String eid=textField_1.getText();
			    String did=textField_2.getText();
			    String time=textField_3.getText();
			    String score=textField_4.getText();
				//新建记录
				sanitationMapper.newviolation(id,eid,did,time,score);
				List<SanitationList> student = sanitationMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (SanitationList students : student) {
					Object[] rowData = {students.getSanitation_scores_id(), students.getEmployee_id(), students.getDormitory_id(), students.getPublish_time(), students.getScore()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_5.setBounds(272, 177, 113, 27);
		contentPane.add(button_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 252, 607, 128);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u536B\u751F\u8BC4\u5206\u8BB0\u5F55\u7F16\u53F7", "\u53D1\u5E03\u8BB0\u5F55\u7BA1\u7406\u5458\u7F16\u53F7", "\u5BDD\u5BA4\u7F16\u53F7", "\u53D1\u5E03\u65F6\u95F4", "\u8BC4\u5206\u5206\u6570"
			}
		));
		
		JButton button_6 = new JButton("\u67E5\u8BE2\u6240\u6709");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//查询全部
				List<SanitationList> student = sanitationMapper.selectAll();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (SanitationList students : student) {
					Object[] rowData = {students.getSanitation_scores_id(), students.getEmployee_id(), students.getDormitory_id(), students.getPublish_time(), students.getScore()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_6.setBounds(272, 217, 113, 27);
		contentPane.add(button_6);
	}
}
