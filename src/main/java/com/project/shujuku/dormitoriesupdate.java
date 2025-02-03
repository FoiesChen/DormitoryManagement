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

public class dormitoriesupdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dormitoriesupdate frame = new dormitoriesupdate();
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
	public dormitoriesupdate() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u9700\u8981\u4FEE\u6539\u7684\u5B66\u751F\u5B66\u53F7\uFF1A");
		label.setBounds(14, 43, 199, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(227, 40, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id=textField.getText();
				List<studentList> student = studentMapper.findById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (studentList students : student) {
					Object[] rowData = {students.getStudentID(), students.getName(), students.getGender(), students.getEnrollment_date(), students.getMajor(), students.getDormitory_building(), students.getDormitory()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button.setBounds(361, 39, 113, 27);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u66F4\u65B0\u540E\u6240\u4F4F\u7684\u5BDD\u5BA4\u697C\uFF1A");
		label_1.setBounds(14, 74, 199, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u66F4\u65B0\u540E\u6240\u4F4F\u7684\u5BDD\u5BA4\u53F7\uFF1A");
		label_2.setBounds(14, 105, 199, 18);
		contentPane.add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 189, 506, 182);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5B66\u751F\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u5B66\u65F6\u95F4", "\u4E13\u4E1A", "\u5BDD\u5BA4\u697C", "\u5BDD\u5BA4\u53F7"
			}
		));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(227, 71, 86, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(227, 102, 86, 24);
		contentPane.add(textField_2);
		
		JButton button_1 = new JButton("\u66F4\u65B0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String dormitory_building=textField_1.getText();
				studentMapper.updateDormitoryBuildingById(id,dormitory_building);
				List<studentList> student = studentMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (studentList students : student) {
					Object[] rowData = {students.getStudentID(), students.getName(), students.getGender(), students.getEnrollment_date(), students.getMajor(), students.getDormitory_building(), students.getDormitory()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_1.setBounds(361, 70, 113, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u66F4\u65B0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String dormitory=textField_2.getText();
				studentMapper.updateDormitoryById(id,dormitory);
				List<studentList> student = studentMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (studentList students : student) {
					Object[] rowData = {students.getStudentID(), students.getName(), students.getGender(), students.getEnrollment_date(), students.getMajor(), students.getDormitory_building(), students.getDormitory()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_2.setBounds(361, 101, 113, 27);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u5220\u9664\u8BE5\u5B66\u751F\u5BDD\u5BA4\u4FE1\u606F");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				studentMapper.deleteById(id);
			}
		});
		button_3.setBounds(275, 141, 199, 27);
		contentPane.add(button_3);
	}

}
