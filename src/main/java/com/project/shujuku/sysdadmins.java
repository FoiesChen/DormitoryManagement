package com.project.shujuku;

import com.project.mapper.DormitoryadminsMapper;
import com.project.pojo.DormitoryadminsList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JLabel;
import javax.swing.JTextField;

public class sysdadmins extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sysdadmins frame = new sysdadmins();
					frame.setTitle("管理寝室管理员");
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
	public sysdadmins() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		DormitoryadminsMapper dormitoryadminsmapper = sqlSession.getMapper(DormitoryadminsMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u67E5\u8BE2\u6240\u6709\u5BDD\u5BA4\u697C\u7BA1\u7406\u8005\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dormitoryadminsmapper.selectAll();
				List<DormitoryadminsList> dormitoryadmins = dormitoryadminsmapper.selectAll();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (DormitoryadminsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getEmployee_id(), dormitoryadmin.getDormitory_building(), dormitoryadmin.getFloors(), dormitoryadmin.getName(), dormitoryadmin.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});

		button.setBounds(15, 15, 388, 29);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 59, 767, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5458\u5DE5\u53F7", "\u7BA1\u7406\u5BDD\u5BA4\u697C", "\u7BA1\u7406\u5BDD\u5BA4\u697C\u5C42\u6570", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F"
			}
		));
		
		JLabel label = new JLabel("\u60F3\u8981\u66F4\u65B0\u7684\u5458\u5DE5\u53F7\uFF1A");
		label.setBounds(25, 333, 217, 21);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(217, 330, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u66F4\u65B0\u540E\u7684\u59D3\u540D\uFF1A");
		label_1.setBounds(26, 370, 177, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u66F4\u65B0\u540E\u7684\u7BA1\u7406\u5BDD\u5BA4\u697C\uFF1A");
		label_2.setBounds(26, 415, 216, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u66F4\u65B0\u540E\u7684\u7BA1\u7406\u5BDD\u5BA4\u5C42\u6570\uFF1A");
		label_3.setBounds(25, 454, 216, 21);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 370, 96, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(220, 414, 96, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(221, 453, 96, 27);
		contentPane.add(textField_3);
		
		JButton button_1 = new JButton("\u66F4\u65B0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name =textField_1.getText();
				String id =textField.getText();
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
				
		button_1.setBounds(346, 370, 123, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u66F4\u65B0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String building =textField_2.getText();
				String id =textField.getText();
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

		button_2.setBounds(346, 411, 123, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u66F4\u65B0");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String floors =textField_3.getText();
				String id =textField.getText();
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
		button_3.setBounds(347, 449, 123, 29);
		contentPane.add(button_3);
	}
}
