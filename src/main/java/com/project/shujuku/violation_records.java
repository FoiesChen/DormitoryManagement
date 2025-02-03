package com.project.shujuku;

import com.project.mapper.ViolationMapper;
import com.project.pojo.ViolationList;
import com.project.pojo.studentList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
import java.util.List;
import java.awt.event.ActionEvent;

public class violation_records extends JFrame {

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
					violation_records frame = new violation_records();
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
	public violation_records() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		ViolationMapper vio = sqlSession.getMapper(ViolationMapper.class);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8FDD\u89C4\u8BB0\u5F55\u7F16\u53F7\uFF1A");
		label.setBounds(14, 13, 127, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u53D1\u5E03\u5BDD\u5BA4\u7BA1\u7406\u5458\u53F7\uFF1A");
		label_1.setBounds(14, 44, 161, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8FDD\u89C4\u5BDD\u5BA4\u7F16\u53F7\uFF1A");
		label_2.setBounds(14, 75, 161, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8FDD\u89C4\u65F6\u95F4\uFF1A");
		label_3.setBounds(14, 106, 161, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u8FDD\u89C4\u5185\u5BB9\uFF1A");
		label_4.setBounds(14, 137, 161, 18);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(155, 10, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 41, 86, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 75, 86, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(155, 106, 86, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 137, 86, 24);
		contentPane.add(textField_4);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				//查询自违规编号
				List<ViolationList> violist = vio.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (ViolationList students :violist) {
					Object[] rowData = {students.getViolation_record_id(), students.getEmployee_id(), students.getDormitory_id(), students.getViolation_time(), students.getViolation_content()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button.setBounds(255, 9, 113, 27);
		contentPane.add(button);

		
		JButton button_5 = new JButton("\u8BB0\u5F55");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
			    String eid=textField_1.getText();
			    String did=textField_2.getText();
			    String time=textField_3.getText();
			    String content=textField_4.getText();
				//新建记录
				vio.newviolation(id,eid,did,time,content);
				List<ViolationList> violist = vio.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (ViolationList students :violist) {
					Object[] rowData = {students.getViolation_record_id(), students.getEmployee_id(), students.getDormitory_id(), students.getViolation_time(), students.getViolation_content()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_5.setBounds(255, 173, 113, 27);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u67E5\u8BE2\u6240\u6709");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//查询全部
				List<ViolationList> violist = vio.selectAll();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (ViolationList students :violist) {
					Object[] rowData = {students.getViolation_record_id(), students.getEmployee_id(), students.getDormitory_id(), students.getViolation_time(), students.getViolation_content()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_6.setBounds(255, 213, 113, 27);
		contentPane.add(button_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 251, 565, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u8FDD\u89C4\u8BB0\u5F55\u7F16\u53F7", "\u53D1\u5E03\u5BDD\u5BA4\u7BA1\u7406\u5458\u53F7", "\u8FDD\u89C4\u5BDD\u5BA4\u7F16\u53F7", "\u8FDD\u89C4\u65F6\u95F4", "\u8FDD\u89C4\u5185\u5BB9"
			}
		));
	}

}
