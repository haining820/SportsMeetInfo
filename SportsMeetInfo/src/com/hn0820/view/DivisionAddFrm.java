package com.hn0820.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.hn0820.dao.DivisionDao;
import com.hn0820.model.Division;
import com.hn0820.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DivisionAddFrm extends JInternalFrame {
	private JTextField divisionNameTextField;
	private JTextField divisionNoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DivisionAddFrm frame = new DivisionAddFrm();
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
	public DivisionAddFrm() {
		setClosable(true);
		setIconifiable(true);//可以放大缩小
		
		setTitle("\u6DFB\u52A0\u5B66\u9662\u4FE1\u606F");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u9662\u540D\u79F0:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		divisionNameTextField = new JTextField();
		divisionNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u53F7\u7801\u5E03\u5206\u914D:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		divisionNoTextField = new JTextField();
		divisionNoTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitDivision(ae);
			}
		});
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(divisionNameTextField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(divisionNoTextField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel))
						.addComponent(divisionNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(divisionNoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(resetButton, Alignment.TRAILING)
						.addComponent(submitButton, Alignment.TRAILING))
					.addGap(43))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitDivision(ActionEvent ae) {
		// TODO Auto-generated method stub
		String divisionName = divisionNameTextField.getText().toString();
		String divisionNo = divisionNoTextField.getText().toString();
		if(StringUtil.isEmpty(divisionName)) {
			JOptionPane.showMessageDialog(this,"学院名称不能为空!");
			return;
		}
		Division divis = new Division();
		divis.setName(divisionName);
		divis.setNo(divisionNo);
		DivisionDao divisionDao = new DivisionDao();
		if(divisionDao.addDivision(divis)){
			JOptionPane.showMessageDialog(this, "学院添加成功！");
		}else{
			JOptionPane.showMessageDialog(this, "学院添加失败！");
		}
		divisionDao.closeDao();
		resetValue(ae);
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		divisionNameTextField.setText("");
		divisionNoTextField.setText("");
	}
}
