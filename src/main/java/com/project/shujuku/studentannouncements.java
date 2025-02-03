package com.project.shujuku;

import com.project.mapper.AnnouncementsMapper;
import com.project.pojo.AnnouncementsList;
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

public class studentannouncements extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentannouncements frame = new studentannouncements();
					frame.setTitle("学生通知查看");
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
	public studentannouncements() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		AnnouncementsMapper announcementsMapper = sqlSession.getMapper(AnnouncementsMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u67E5\u770B\u901A\u77E5");
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
		button.setBounds(10, 10, 140, 30);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 641, 365);
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
	}
}
