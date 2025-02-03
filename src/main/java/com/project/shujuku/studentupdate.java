package com.project.shujuku;

import com.project.mapper.StudentMapper;
import com.project.pojo.studentList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class studentupdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentupdate frame = new studentupdate();
					frame.setTitle("学生信息更新");
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
	public studentupdate() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u66F4\u65B0\u540E\u7684\u59D3\u540D\uFF1A");
		label.setBounds(47, 82, 114, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u5148\u8F93\u5165\u4F60\u7684\u5B66\u53F7\uFF1A");
		label_1.setBounds(47, 44, 133, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 41, 133, 21);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(202, 79, 121, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(202, 110, 121, 21);
		contentPane.add(textField_2);
		
		JLabel label_2 = new JLabel("\u66F4\u65B0\u540E\u7684\u4E13\u4E1A\uFF1A");
		label_2.setBounds(47, 113, 114, 15);
		contentPane.add(label_2);
		
		JButton button = new JButton("\u66F4\u65B0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id =textField.getText();
				String name =textField_1.getText();
				studentMapper.updateNameById(id,name);
				List<studentList> student = studentMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (studentList students : student) {
					Object[] rowData = {students.getStudentID(), students.getName(), students.getGender(), students.getEnrollment_date(), students.getMajor(), students.getDormitory_building(), students.getDormitory()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button.setBounds(331, 78, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u66F4\u65B0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String major =textField_2.getText();
				String id =textField.getText();
				studentMapper.updateMajorById(id,major);
				List<studentList> student = studentMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (studentList students : student) {
					Object[] rowData = {students.getStudentID(), students.getName(), students.getGender(), students.getEnrollment_date(), students.getMajor(), students.getDormitory_building(), students.getDormitory()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
			
		button_1.setBounds(331, 109, 93, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 159, 468, 78);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u5B66\u65F6\u95F4", "\u4E13\u4E1A", "\u5BDD\u5BA4\u697C", "\u5BDD\u5BA4\u53F7"
			}
		));
		
		JButton button_4 = new JButton("\u67E5\u8BE2");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String id =textField.getText();
				List<studentList> student = studentMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (studentList students : student) {
					Object[] rowData = {students.getStudentID(), students.getName(), students.getGender(), students.getEnrollment_date(), students.getMajor(), students.getDormitory_building(), students.getDormitory()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}

		}
		});
		button_4.setBounds(331, 40, 93, 23);
		contentPane.add(button_4);
	}
}
