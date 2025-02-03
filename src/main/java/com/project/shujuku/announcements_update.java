package com.project.shujuku;

import com.project.mapper.AnnouncementsMapper;
import com.project.pojo.AnnouncementsList;
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

public class announcements_update extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					announcements_update frame = new announcements_update();
					frame.setTitle("通知更新");
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
	public announcements_update() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		AnnouncementsMapper announcementsMapper = sqlSession.getMapper(AnnouncementsMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u67E5\u8BE2\u6240\u6709\u901A\u77E5\u516C\u544A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<AnnouncementsList> dormitoryadmins = announcementsMapper.selectAll();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (AnnouncementsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getAnnouncement_id(), dormitoryadmin.getTitle(), dormitoryadmin.getContent(), dormitoryadmin.getPublish_time(), dormitoryadmin.getEmployee_id()};  // 根据需要设置每一列的数据
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
				"\u901A\u77E5\u7F16\u53F7", "\u6807\u9898", "\u5185\u5BB9", "\u53D1\u5E03\u65F6\u95F4", "\u53D1\u5E03\u4EBA\u7F16\u53F7"
			}
		));
		
		JLabel label = new JLabel("\u60F3\u8981\u66F4\u65B0\u7684\u901A\u77E5\u7F16\u53F7\uFF1A");
		label.setBounds(35, 333, 217, 21);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(217, 330, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u66F4\u65B0\u540E\u7684\u6807\u9898\uFF1A");
		label_1.setBounds(35, 370, 177, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u66F4\u65B0\u540E\u7684\u5185\u5BB9\uFF1A");
		label_2.setBounds(35, 415, 216, 21);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 367, 96, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(217, 412, 96, 27);
		contentPane.add(textField_2);
		
		JButton button_1 = new JButton("\u66F4\u65B0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title =textField_1.getText();
				String id =textField.getText();
				announcementsMapper.updatetitleById(id,title);
				List<AnnouncementsList> dormitoryadmins = announcementsMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (AnnouncementsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getAnnouncement_id(), dormitoryadmin.getTitle(), dormitoryadmin.getContent(), dormitoryadmin.getPublish_time(), dormitoryadmin.getEmployee_id()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});
				
		button_1.setBounds(346, 366, 123, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u66F4\u65B0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String content =textField_2.getText();
				String id =textField.getText();
				announcementsMapper.updatecontentById(id,content);
				List<AnnouncementsList> dormitoryadmins = announcementsMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (AnnouncementsList dormitoryadmin : dormitoryadmins) {
					Object[] rowData = {dormitoryadmin.getAnnouncement_id(), dormitoryadmin.getTitle(), dormitoryadmin.getContent(), dormitoryadmin.getPublish_time(), dormitoryadmin.getEmployee_id()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
		});

		button_2.setBounds(346, 411, 123, 29);
		contentPane.add(button_2);
	}

}
