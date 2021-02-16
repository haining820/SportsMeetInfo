package com.hn0820.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.hn0820.dao.EventDao;
import com.hn0820.model.Event;
import com.hn0820.util.StringUtil;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEventFrm extends JInternalFrame {
	private JTextField eventNameTextField;
	private JTextField eventJudgeTextField;
	private JTextField athleteMaxNumTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEventFrm frame = new AddEventFrm();
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
	public AddEventFrm() {
		setClosable(true);
		setIconifiable(true);
		
		setTitle("\u6DFB\u52A0\u8FD0\u52A8\u4F1A\u9879\u76EE");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u6BD4\u8D5B\u9879\u76EE\u540D\u79F0:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u9879\u76EE\u88C1\u5224:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		eventNameTextField = new JTextField();
		eventNameTextField.setColumns(10);
		
		eventJudgeTextField = new JTextField();
		eventJudgeTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u53C2\u52A0\u4EBA\u6570:");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		athleteMaxNumTextField = new JTextField();
		athleteMaxNumTextField.setColumns(10);
		
		JButton addEventButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		addEventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				addEventAct(ae);
			}
		});
		addEventButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(70, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(12))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(13))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(11)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(eventNameTextField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(eventJudgeTextField, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(athleteMaxNumTextField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(addEventButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(lblNewLabel)
							.addGap(28)
							.addComponent(lblNewLabel_1)
							.addGap(34)
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(53)
									.addComponent(eventNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(101)
									.addComponent(eventJudgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(32)
							.addComponent(athleteMaxNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(addEventButton, Alignment.TRAILING)
						.addComponent(resetButton, Alignment.TRAILING))
					.addGap(31))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {eventNameTextField, eventJudgeTextField, athleteMaxNumTextField});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {eventNameTextField, eventJudgeTextField, athleteMaxNumTextField});
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		eventNameTextField.setText("");
		eventJudgeTextField.setText("");
		athleteMaxNumTextField.setText("");
		//teacherListComboBox.setSelectedIndex(0);
	}

	protected void addEventAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String eventName = eventNameTextField.getText().toString();
		String eventJudge = eventJudgeTextField.getText().toString();
		//Teacher selectedTeacher = (Teacher)teacherListComboBox.getSelectedItem();
		int athleteMaxNum = 0;
		try {
			athleteMaxNum = Integer.parseInt(athleteMaxNumTextField.getText());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "运动员人数只能输入数字!");
			return;
		}
		if(StringUtil.isEmpty(eventName)){
			JOptionPane.showMessageDialog(this, "请输入比赛项目名称!");
			return;
		}
		if(athleteMaxNum <= 0){
			JOptionPane.showMessageDialog(this, "运动员人数只能输入大于0的数字!");
			return;
		}
		Event event = new Event();
		event.setName(eventName);
		event.setJudge(eventJudge);
		event.setMax_athlete_num(athleteMaxNum);
		//event.setTeacher_id(selectedTeacher.getId());
		EventDao eventDao = new EventDao();
		if(eventDao.addEvent(event)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		eventDao.closeDao();
		resetValue(ae);
	}
}
