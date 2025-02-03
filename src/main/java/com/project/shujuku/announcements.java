package com.project.shujuku;

import com.project.mapper.AnnouncementsMapper;
import com.project.mapper.DormitoryadminsMapper;
import com.project.pojo.AnnouncementsList;
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

public class announcements extends JFrame {

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
					announcements frame = new announcements();
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
	public announcements() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		AnnouncementsMapper announcementsMapper = sqlSession.getMapper(AnnouncementsMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u901A\u77E5\u7F16\u53F7\uFF1A");
		label.setBounds(14, 13, 137, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(165, 10, 155, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u6807\u9898\uFF1A");
		label_1.setBounds(14, 44, 137, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u5185\u5BB9\uFF1A");
		label_2.setBounds(14, 75, 137, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u53D1\u5E03\u65F6\u95F4\uFF1A");
		label_3.setBounds(14, 139, 137, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u53D1\u5E03\u4EBA\u7F16\u53F7\uFF1A");
		label_4.setBounds(14, 170, 137, 18);
		contentPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 41, 155, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 72, 155, 53);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 136, 155, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(165, 167, 155, 24);
		contentPane.add(textField_4);
		
		JButton button = new JButton("\u53D1\u5E03");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//发布
				String id=textField.getText();
			    String title=textField_1.getText();
			    String content=textField_2.getText();
			    String publish_time=textField_3.getText();
			    String employee_id=textField_4.getText();
				announcementsMapper.newannouncement(id,title,content,publish_time,employee_id);
				List<AnnouncementsList> dormitoryadmins = announcementsMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (AnnouncementsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getAnnouncement_id(), dormitoryadmin.getTitle(), dormitoryadmin.getContent(), dormitoryadmin.getPublish_time(), dormitoryadmin.getEmployee_id()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button.setBounds(369, 206, 113, 27);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 280, 484, 120);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u901A\u77E5\u7F16", "\u6807\u9898", "\u5185\u5BB9", "\u53D1\u5E03\u65F6\u95F4", "\u53D1\u5E03\u4EBA\u7F16\u53F7"
			}
		));
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//根据编号查询
				String id=textField.getText();
				announcementsMapper.selectById(id);
				List<AnnouncementsList> dormitoryadmins = announcementsMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (AnnouncementsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getAnnouncement_id(), dormitoryadmin.getTitle(), dormitoryadmin.getContent(), dormitoryadmin.getPublish_time(), dormitoryadmin.getEmployee_id()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_1.setBounds(369, 9, 113, 27);
		contentPane.add(button_1);

		JButton button_6 = new JButton("\u67E5\u8BE2\u6240\u6709");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<AnnouncementsList> dormitoryadmins = announcementsMapper.selectAll();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (AnnouncementsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getAnnouncement_id(), dormitoryadmin.getTitle(), dormitoryadmin.getContent(), dormitoryadmin.getPublish_time(), dormitoryadmin.getEmployee_id()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
		button_6.setBounds(369, 246, 113, 27);
		contentPane.add(button_6);
	}
}
