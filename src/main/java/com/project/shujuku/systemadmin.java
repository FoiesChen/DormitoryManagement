package com.project.shujuku;

import com.project.mapper.System_adminMapper;
import com.project.pojo.System_adminList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class systemadmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton button_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					systemadmin frame = new systemadmin();
					frame.setTitle("系统管理端");
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
	public systemadmin() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		System_adminMapper system_adminMapper = sqlSession.getMapper(System_adminMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u7F16\u53F7\uFF1A");
		label.setBounds(40, 36, 154, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(211, 33, 133, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
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
		button.setBounds(354, 32, 93, 23);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(107, 101, 54, 15);
		contentPane.add(lblNewLabel);
		
		button_1 = new JButton("\u66F4\u65B0\u672C\u4EBA\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                systemadmin_update updateFrame = null;
                try {
                    updateFrame = new systemadmin_update();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("个人信息更新");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    }
		});
		button_1.setBounds(40, 190, 232, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 67, 648, 113);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7BA1\u7406\u5458\u7F16\u53F7", "\u7BA1\u7406\u5BDD\u5BA4\u7BA1\u7406\u5458\u7F16\u53F7", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F"
			}
		));
		
		JButton button_2 = new JButton("\u66F4\u65B0\u5BDD\u5BA4\u7BA1\u7406\u4FE1\u606F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                sysdadmins updateFrame = null;
                try {
                    updateFrame = new sysdadmins();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("管理寝室管理员");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_2.setBounds(40, 228, 232, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u66F4\u65B0\u901A\u77E5\u4FE1\u606F");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                announcements_update updateFrame = null;
                try {
                    updateFrame = new announcements_update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("通知更新");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}

		});
		button_3.setBounds(40, 266, 232, 23);
		contentPane.add(button_3);
	}
}
