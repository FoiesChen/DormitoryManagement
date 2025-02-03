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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTable table;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentpage frame = new studentpage();
					frame.setTitle("学生管理端");
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
	public studentpage() throws IOException {

		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u5B66\u53F7\uFF1A");
		label.setBounds(61, 36, 133, 15);
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
				List<studentList> student = studentMapper.selectById(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (studentList students : student) {
					Object[] rowData = {students.getStudentID(), students.getName(), students.getGender(), students.getEnrollment_date(), students.getMajor(), students.getDormitory_building(), students.getDormitory()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
				
			
		});
		button.setBounds(354, 32, 93, 23);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(107, 101, 54, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 101, 513, 69);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u5B66\u65F6\u95F4", "\u4E13\u4E1A", "\u5BDD\u5BA4\u697C", "\u5BDD\u5BA4\u53F7"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		button_1 = new JButton("\u66F4\u65B0\u6211\u7684\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                studentupdate updateFrame = null;
                try {
                    updateFrame = new studentupdate();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("学生信息更新");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    }
		});
		button_1.setBounds(40, 190, 154, 23);
		contentPane.add(button_1);
		
		button_2 = new JButton("\u67E5\u770B\u901A\u77E5");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                studentannouncements updateFrame = null;
                try {
                    updateFrame = new studentannouncements();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("查看学生通知");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_2.setBounds(211, 190, 154, 23);
		contentPane.add(button_2);
		
		button_3 = new JButton("\u67E5\u770B\u5BDD\u5BA4\u536B\u751F\u8BC4\u5206");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                studentsanitation updateFrame = null;
                try {
                    updateFrame = new studentsanitation();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("学生寝室卫生查询");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_3.setBounds(40, 235, 154, 23);
		contentPane.add(button_3);
		
		button_4 = new JButton("\u67E5\u770B\u5BDD\u5BA4\u8FDD\u89C4\u8BB0\u5F55");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                studentviolation updateFrame = null;
                try {
                    updateFrame = new studentviolation();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("学生寝室违规查询");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_4.setBounds(211, 235, 154, 23);
		contentPane.add(button_4);
		
		button_5 = new JButton("\u67E5\u8BE2\u5BDD\u5BA4\u7EF4\u4FEE\u4EBA\u5458");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                studentmaintenance updateFrame = null;
                try {
                    updateFrame = new studentmaintenance();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                updateFrame.setVisible(true);
		        updateFrame.setTitle("学生寝室维修查询");
		        updateFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		button_5.setBounds(385, 190, 154, 23);
		contentPane.add(button_5);
	}
}
