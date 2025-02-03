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
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class dormitory_admins extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dormitory_admins frame = new dormitory_admins();
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
	public dormitory_admins() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		DormitoryadminsMapper dormitoryadminsmapper = sqlSession.getMapper(DormitoryadminsMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u7BA1\u7406\u5458\u5DE5\u53F7\uFF1A");
		label.setBounds(27, 39, 201, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(231, 36, 148, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button.setBounds(414, 35, 113, 27);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 84, 608, 74);
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
		
		JButton button_1 = new JButton("\u66F4\u65B0\u6211\u7684\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dormitory_adminsupdate updateFrame = null;
                try {
                    updateFrame = new dormitory_adminsupdate();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("寝室楼管理员信息更新");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_1.setBounds(14, 171, 154, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u7BA1\u7406\u5BDD\u5BA4\u4FE1\u606F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dormitoriesupdate updateFrame = null;
                try {
                    updateFrame = new dormitoriesupdate();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("寝室信息更新");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_2.setBounds(195, 171, 154, 27);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u53D1\u5E03\u901A\u77E5\u516C\u544A");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                announcements updateFrame = null;
                try {
                    updateFrame = new announcements();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("通知公告");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_3.setBounds(378, 171, 154, 27);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u53D1\u5E03\u536B\u751F\u8BC4\u5206");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                sanitation_scores updateFrame = null;
                try {
                    updateFrame = new sanitation_scores();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("卫生评分");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_4.setBounds(14, 225, 154, 27);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("\u8BB0\u5F55\u8FDD\u89C4\u8BB0\u5F55");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                violation_records updateFrame = null;
                try {
                    updateFrame = new violation_records();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("违规记录");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_5.setBounds(195, 225, 154, 27);
		contentPane.add(button_5);
	}
}
