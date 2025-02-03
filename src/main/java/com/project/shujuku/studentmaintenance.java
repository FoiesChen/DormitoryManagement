package com.project.shujuku;

import com.project.mapper.DormitoryadminsMapper;
import com.project.mapper.MaintenanceMapper;
import com.project.pojo.DormitoryadminsList;
import com.project.pojo.MaintenanceList;
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

public class studentmaintenance extends JFrame {

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
					studentmaintenance frame = new studentmaintenance();
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
	public studentmaintenance() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3.获取mapper
		MaintenanceMapper maintenancemapper = sqlSession.getMapper(MaintenanceMapper.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u5BDD\u5BA4\u697C\u53F7\uFF1A");
		label.setBounds(10, 20, 176, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(152, 17, 109, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id =textField.getText();
				List<MaintenanceList> maintenance = maintenancemapper.selectBydormitory_building(id);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);  // 清空表格中的数据

				for (MaintenanceList maintenances : maintenance) {
					Object[] rowData = {maintenances.getMaintenance_man_id(), maintenances.getDormitory_building(), maintenances.getName(), maintenances.getContact_info()};  // 根据需要设置每一列的数据
					model.addRow(rowData);
				}
			}
				
			
		});
		button.setBounds(331, 16, 93, 23);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 414, 87);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7EF4\u4FEE\u4EBA\u5458\u7F16\u53F7", "\u6240\u7EF4\u4FEE\u5BDD\u5BA4\u697C\u53F7", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F"
			}
		));
	}
}
