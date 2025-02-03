package com.project.shujuku;

import com.project.mapper.DormitoryadminsMapper;
import com.project.mapper.StudentMapper;
import com.project.pojo.DormitoryadminsList;
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

public class dormitory_adminsupdate extends JFrame {

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
					dormitory_adminsupdate frame = new dormitory_adminsupdate();
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
	public dormitory_adminsupdate() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		DormitoryadminsMapper dormitoryadminsmapper = sqlSession.getMapper(DormitoryadminsMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u7BA1\u7406\u5458\u5DE5\u53F7\uFF1A");
		label.setBounds(27, 43, 179, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(315, 40, 111, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id=textField.getText();
				dormitoryadminsmapper.selectById(id);
				List<DormitoryadminsList> dormitoryadmins = dormitoryadminsmapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (DormitoryadminsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getEmployee_id(), dormitoryadmin.getDormitory_building(), dormitoryadmin.getFloors(), dormitoryadmin.getName(), dormitoryadmin.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button.setBounds(464, 39, 113, 27);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u66F4\u65B0\u540E\u7684\u7BA1\u7406\u5BDD\u5BA4\u697C\u7F16\u53F7\uFF1A");
		label_1.setBounds(27, 87, 236, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u66F4\u65B0\u540E\u7684\u7BA1\u7406\u7BA1\u7406\u5BDD\u5BA4\u697C\u5C42\u6570\u7F16\u53F7\uFF1A");
		label_2.setBounds(27, 118, 285, 33);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u66F4\u65B0\u540E\u7684\u59D3\u540D\uFF1A");
		label_3.setBounds(24, 164, 166, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u66F4\u65B0\u540E\u7684\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_4.setBounds(24, 203, 190, 18);
		contentPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(315, 84, 111, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(315, 122, 111, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(315, 161, 111, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(315, 200, 111, 24);
		contentPane.add(textField_4);
		
		JButton button_1 = new JButton("\u66F4\u65B0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String building=textField_1.getText();
				dormitoryadminsmapper.updateDormitoryBuildingById(id,building);
				List<DormitoryadminsList> dormitoryadmins = dormitoryadminsmapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (DormitoryadminsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getEmployee_id(), dormitoryadmin.getDormitory_building(), dormitoryadmin.getFloors(), dormitoryadmin.getName(), dormitoryadmin.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_1.setBounds(464, 83, 113, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u66F4\u65B0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String floors=textField_2.getText();
				dormitoryadminsmapper.updatefloorsById(id,floors);
				List<DormitoryadminsList> dormitoryadmins = dormitoryadminsmapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (DormitoryadminsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getEmployee_id(), dormitoryadmin.getDormitory_building(), dormitoryadmin.getFloors(), dormitoryadmin.getName(), dormitoryadmin.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});

		button_2.setBounds(464, 121, 113, 27);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u66F4\u65B0");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String name=textField_3.getText();
				dormitoryadminsmapper.updateNameById(id,name);
				List<DormitoryadminsList> dormitoryadmins = dormitoryadminsmapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (DormitoryadminsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getEmployee_id(), dormitoryadmin.getDormitory_building(), dormitoryadmin.getFloors(), dormitoryadmin.getName(), dormitoryadmin.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_3.setBounds(464, 160, 113, 27);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u66F4\u65B0");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String info=textField_4.getText();
				dormitoryadminsmapper.updatecontact_infoById(id,info);
				List<DormitoryadminsList> dormitoryadmins = dormitoryadminsmapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (DormitoryadminsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getEmployee_id(), dormitoryadmin.getDormitory_building(), dormitoryadmin.getFloors(), dormitoryadmin.getName(), dormitoryadmin.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}

			}
		});

		button_4.setBounds(464, 199, 113, 27);
		contentPane.add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 252, 550, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u7BA1\u7406\u5458\u5DE5\u53F7", "\u7BA1\u7406\u5BDD\u5BA4\u697C\u7F16\u53F7", "\u7BA1\u7406\u5BDD\u5BA4\u697C\u5C42\u6570", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F"
			}
		));
	}
}
