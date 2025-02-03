package com.project.shujuku;

import com.project.mapper.DormitoryadminsMapper;
import com.project.mapper.System_adminMapper;
import com.project.pojo.DormitoryadminsList;
import com.project.pojo.System_adminList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class systemadmin_update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					systemadmin_update frame = new systemadmin_update();
					frame.setTitle("个人信息管理");
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
	public systemadmin_update() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		System_adminMapper system_adminMapper = sqlSession.getMapper(System_adminMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u66F4\u65B0\u540E\u7684\u7BA1\u7406\u5BDD\u5BA4\u7BA1\u7406\u5458\u7F16\u53F7\uFF1A");
		label.setBounds(29, 82, 259, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u5148\u8F93\u5165\u4F60\u7684\u7BA1\u7406\u5458\u7F16\u53F7\uFF1A");
		label_1.setBounds(29, 44, 216, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(290, 41, 121, 21);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(290, 79, 121, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(290, 110, 121, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(290, 141, 121, 21);
		contentPane.add(textField_3);
		
		JLabel label_2 = new JLabel("\u66F4\u65B0\u540E\u7684\u59D3\u540D\uFF1A");
		label_2.setBounds(29, 113, 216, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u66F4\u65B0\u540E\u7684\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_3.setBounds(29, 144, 216, 15);
		contentPane.add(label_3);
		
		JButton button = new JButton("\u66F4\u65B0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String newid =textField_1.getText();
				String id =textField.getText();
				//更新寝室楼管理员
				system_adminMapper.updateemployee_idById(id,newid);
				List<System_adminList> adminis = system_adminMapper.selectByid(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (System_adminList admini :adminis) {
					Object[] rowData = {admini.getAdmin_id(), admini.getEmployee_id(), admini.getName(), admini.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
				
			
		});
		button.setBounds(422, 78, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u66F4\u65B0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =textField_2.getText();
				String id =textField.getText();
				//更新名字
				system_adminMapper.updateNameById(id,name);
				List<System_adminList> adminis = system_adminMapper.selectByid(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (System_adminList admini :adminis) {
					Object[] rowData = {admini.getAdmin_id(), admini.getEmployee_id(), admini.getName(), admini.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
			
		button_1.setBounds(422, 109, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u66F4\u65B0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newtele =textField_3.getText();
				String id =textField.getText();
				//更新联系方式
				system_adminMapper.updatecontactById(id,newtele);
				List<System_adminList> adminis = system_adminMapper.selectByid(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (System_adminList admini :adminis) {
					Object[] rowData = {admini.getAdmin_id(), admini.getEmployee_id(), admini.getName(), admini.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
				
			
		});
		button_2.setBounds(422, 140, 93, 23);
		contentPane.add(button_2);
		
		JButton button_4 = new JButton("\u67E5\u8BE2");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String id =textField.getText();
			List<System_adminList> adminis = system_adminMapper.selectByid(id);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);  // 清空表格中的数据

				for (System_adminList admini :adminis) {
					Object[] rowData = {admini.getAdmin_id(), admini.getEmployee_id(), admini.getName(), admini.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
		}	
		});
		button_4.setBounds(422, 40, 93, 23);
		contentPane.add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 210, 497, 113);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7BA1\u7406\u5458\u7F16\u53F7", "\u7BA1\u7406\u5BDD\u5BA4\u7BA1\u7406\u5458\u7F16\u53F7", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F"
			}
		));
		scrollPane.setViewportView(table);
		
		
	}
}
