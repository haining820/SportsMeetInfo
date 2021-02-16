package com.hn0820.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hn0820.dao.DivisionDao;
import com.hn0820.dao.EventDao;
import com.hn0820.model.Division;
import com.hn0820.model.Event;
import com.hn0820.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventManageFrm extends JInternalFrame {
	private JTextField searchEventNameTextField;
	private JTextField editEventNameTextField;
	private JTextField editEventJudgeTextField;
	private JTextField editAthleteMaxNumTextField;
	private JTable eventListTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventManageFrm frame = new EventManageFrm();
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
	public EventManageFrm() {
		setClosable(true);
		setIconifiable(true);//可以放大缩小
		
		setTitle("\u6BD4\u8D5B\u9879\u76EE\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 856, 617);
		
		JLabel lblNewLabel = new JLabel("\u6BD4\u8D5B\u9879\u76EE\u540D\u79F0:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchEventNameTextField = new JTextField();
		searchEventNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//searchEvent(ae);
				
				
				Event eve = new Event();
				eve.setName(searchEventNameTextField.getText().toString());
				setEventListTable(eve);	
				
				
			}
		});
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7F16\u8F91\u9879\u76EE\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchEventNameTextField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(102)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(117, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(searchEventNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(searchButton)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		
		eventListTable = new JTable();
		eventListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {

				selectedEvent(me);
			}
		});
		eventListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u6BD4\u8D5B\u9879\u76EE\u540D\u79F0", "\u88C1\u5224", "\u6700\u591A\u53C2\u52A0\u4EBA\u6570", "\u5DF2\u62A5\u540D\u4EBA\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(eventListTable);
		
		JLabel lblNewLabel_1 = new JLabel("\u6BD4\u8D5B\u9879\u76EE\u540D\u79F0:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editEventNameTextField = new JTextField();
		editEventNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u88C1\u5224:");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("\u6700\u591A\u53C2\u52A0\u4EBA\u6570:");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editEventJudgeTextField = new JTextField();
		editEventJudgeTextField.setColumns(10);
		
		editAthleteMaxNumTextField = new JTextField();
		editAthleteMaxNumTextField.setColumns(10);
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEventEditAct(ae);
			}
		});
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton deleteEventButton = new JButton("\u5220\u9664");
		deleteEventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				deleteEvent(ae);
			}
		});
		deleteEventButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(editAthleteMaxNumTextField, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(submitEditButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(deleteEventButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(editEventNameTextField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editEventJudgeTextField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(editEventJudgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(deleteEventButton, Alignment.TRAILING)
								.addComponent(submitEditButton, Alignment.TRAILING)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(editEventNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(editAthleteMaxNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(32))
		);
		gl_panel.linkSize(SwingConstants.VERTICAL, new Component[] {editEventNameTextField, editEventJudgeTextField, editAthleteMaxNumTextField});
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {editEventNameTextField, editEventJudgeTextField, editAthleteMaxNumTextField});
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		setEventListTable(new Event());
	}
	

protected void selectedEvent(MouseEvent me) {
		// TODO Auto-generated method stub
	int row = eventListTable.getSelectedRow();
	String eventName = eventListTable.getValueAt(row, 1).toString();
	String eventJudge = eventListTable.getValueAt(row,2).toString();
	int max_athlete_num = Integer.parseInt(eventListTable.getValueAt(row, 3).toString());
	editEventNameTextField.setText(eventName);
	editEventJudgeTextField.setText(eventJudge);
	editAthleteMaxNumTextField.setText(max_athlete_num+"");
	}

protected void submitEventEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
	int row = eventListTable.getSelectedRow();
	if(row == -1){
		JOptionPane.showMessageDialog(this, "请选中要修改的数据!");
		return;
	}
	int event_id = Integer.parseInt(eventListTable.getValueAt(row, 0).toString());
	String eventName = editEventNameTextField.getText().toString();
	if(StringUtil.isEmpty(eventName)){
		JOptionPane.showMessageDialog(this, "比赛项目名称不能为空!");
		return;
	}
	int max_student_num = 0;
	try {
		max_student_num = Integer.parseInt(editAthleteMaxNumTextField.getText().toString());
	} catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(this, "学生人数请输入大于0的整数！");
		return;
	}
	if(max_student_num <= 0){
		JOptionPane.showMessageDialog(this, "学生人数请输入大于0的整数！");
		return;
	}
	String eventJudge = editEventJudgeTextField.getText().toString();
	Event event = new Event();
	event.setId(event_id);
	event.setName(eventName);
	event.setMax_athlete_num(max_student_num);
	event.setJudge(eventJudge);
	EventDao eventDao = new EventDao();
	if(eventDao.update(event)){
		JOptionPane.showMessageDialog(this, "修改成功！");
	}else{
		JOptionPane.showMessageDialog(this, "修改失败！");
	}
	eventDao.closeDao();
	setEventListTable(new Event());
	
}



	protected void deleteEvent(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		int row = eventListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		int event_id = Integer.parseInt(eventListTable.getValueAt(row, 0).toString());
		EventDao eventDao = new EventDao();
		if(eventDao.delete(event_id)){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		eventDao.closeDao();
		setEventListTable(new Event());
		
	}

	private void setEventListTable(Event event) {
		EventDao eventDao = new EventDao();
		List<Event> eventList = eventDao.getEventList(event);
		DefaultTableModel dft = (DefaultTableModel) eventListTable.getModel();
		dft.setRowCount(0);//
		for (Event e : eventList) {
			Vector v = new Vector();
			v.add(e.getId());
			v.add(e.getName());
			v.add(e.getJudge());
			v.add(e.getMax_athlete_num());
			v.add(e.getSelected_num());
			dft.addRow(v);
		}
		eventDao.closeDao();
	}
	
	
}
