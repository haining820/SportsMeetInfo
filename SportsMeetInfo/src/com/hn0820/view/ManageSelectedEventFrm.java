package com.hn0820.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hn0820.dao.AthleteDao;
import com.hn0820.dao.EventDao;
import com.hn0820.dao.SelectedEventDao;
import com.hn0820.model.Athlete;
import com.hn0820.model.Event;
import com.hn0820.model.SelectedEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageSelectedEventFrm extends JInternalFrame {
	private JTable selectedEventListTable;
	private List<Athlete> athleteList = new ArrayList<Athlete>();
	private List<Event> eventList = new ArrayList<Event>();
	private JComboBox editAthleteComboBox;
	private JComboBox editEventComboBox;
	private JComboBox searchAthleteComboBox;
	private JComboBox searchEventComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSelectedEventFrm frame = new ManageSelectedEventFrm();
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
	public ManageSelectedEventFrm() {
		setClosable(true);
		setIconifiable(true);//可以放大缩小
		
		setTitle("\u62A5\u540D\u7BA1\u7406");
		setBounds(100, 100, 787, 571);
		
		JLabel lblNewLabel = new JLabel("\u8FD0\u52A8\u5458\u59D3\u540D:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u6BD4\u8D5B\u9879\u76EE:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchAthleteComboBox = new JComboBox();
		searchAthleteComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				
				athleteChangeAct(ie);
				
			}
		});
		
		searchEventComboBox = new JComboBox();
		
		JButton confirmSelectedButton = new JButton("\u62A5\u540D");
		confirmSelectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmSelectedEvent(ae);
			}
		});
		confirmSelectedButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u62A5\u540D\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(88)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(searchAthleteComboBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchEventComboBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(confirmSelectedButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(searchEventComboBox, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchAthleteComboBox, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmSelectedButton, Alignment.TRAILING)
						.addComponent(lblNewLabel_1, Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.TRAILING))
					.addGap(33)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {searchAthleteComboBox, searchEventComboBox});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {searchAthleteComboBox, searchEventComboBox});
		
		selectedEventListTable = new JTable();
		selectedEventListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				
				selectedEvent(me);
			}
		});
		selectedEventListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9009\u8BFE\u7F16\u53F7", "\u8FD0\u52A8\u5458\u59D3\u540D", "\u6BD4\u8D5B\u9879\u76EE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(selectedEventListTable);
		
		JLabel lblNewLabel_2 = new JLabel("\u8FD0\u52A8\u5458\u59D3\u540D:");
		lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 14));
		
		editAthleteComboBox = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("\u6BD4\u8D5B\u9879\u76EE:");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editEventComboBox = new JComboBox();
		
		JButton confirmEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		confirmEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editSelectedEventAct(ae);
			}
		});
		confirmEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton deleteSelectedButton = new JButton("\u53D6\u6D88\u62A5\u540D");
		deleteSelectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				deleteSelectedEvent(ae);
			}
		});
		deleteSelectedButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(editAthleteComboBox, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(editEventComboBox, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(299, Short.MAX_VALUE)
					.addComponent(confirmEditButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(deleteSelectedButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(editAthleteComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(editEventComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(deleteSelectedButton)
						.addComponent(confirmEditButton))
					.addGap(6))
		);
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {editAthleteComboBox, editEventComboBox});
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		setAthleteCombox();
		setEventCombox();
		initTable();
		setAuthority();
	}
	
	protected void deleteSelectedEvent(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = selectedEventListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要修改的报名信息!");
			return;
		}
		int selected_id = Integer.parseInt(selectedEventListTable.getValueAt(row, 0).toString());
		String courseName = selectedEventListTable.getValueAt(row, 2).toString();
		SelectedEvent sc = new SelectedEvent();
		sc.setId(selected_id);
		SelectedEventDao scDao = new SelectedEventDao();
		EventDao eventDao = new EventDao();
		if(scDao.delete(selected_id)){
			if(eventDao.updateSelectedNum(getEventIdByName(courseName), -1)){
				JOptionPane.showMessageDialog(this, "取消报名成功!");
			}else{
				JOptionPane.showMessageDialog(this, "取消报名成功，报名信息更新失败!");
			}
		}else{
			JOptionPane.showMessageDialog(this, "取消报名失败!");
		}
		scDao.closeDao();
		eventDao.closeDao();
		initTable();
	}

	protected void editSelectedEventAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		
		int row = selectedEventListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要修改的报名信息！");
			return;
		}
		int selected_id = Integer.parseInt(selectedEventListTable.getValueAt(row, 0).toString());
		String studentName = selectedEventListTable.getValueAt(row, 1).toString();
		String courseName = selectedEventListTable.getValueAt(row, 2).toString();
		Athlete athlete = (Athlete) editAthleteComboBox.getSelectedItem();
		Event event = (Event) editEventComboBox.getSelectedItem();
		if(studentName.equals(athlete.getName())&&courseName.equals(event.getName())){
			JOptionPane.showMessageDialog(this, "还未修改报名信息!");
			return;
		}
		EventDao eventDao = new EventDao();
		if(!eventDao.selectedEnable(event.getId())){//判断是否选满
			JOptionPane.showMessageDialog(this, "该比赛项目报名人数已满,不能再报名!");
			return;
		}
		
		SelectedEvent se = new SelectedEvent();
		se.setId(selected_id);
		se.setAthlete_id(athlete.getId());
		se.setEvent_id(event.getId());
		SelectedEventDao scDao = new SelectedEventDao();
		if(scDao.isSelected(se)){
			JOptionPane.showMessageDialog(this, "该比赛项目报名人数已满，不能再报名!");
			return;
		}
		if(scDao.updateSelectedCourse(se)){
			if(eventDao.updateSelectedNum(se.getEvent_id(),1)){
				if(eventDao.updateSelectedNum(getEventIdByName(courseName), -1)){
					JOptionPane.showMessageDialog(this, "报名成功!");
				}
			}else{
				JOptionPane.showMessageDialog(this, "报名成功，报名信息更新失败!");
			}
		}
		
		
		eventDao.closeDao();
		scDao.closeDao();
		initTable();
		//
		
	}

	protected void athleteChangeAct(ItemEvent ie) {//先触发取消选择,再触发已经选择
		// TODO Auto-generated method stub
		if(ie.getStateChange() == ItemEvent.SELECTED) {
			initTable();
		}
		//JOptionPane.showMessageDialog(this, ie.getStateChange());
	}

	protected void confirmSelectedEvent(ActionEvent ae) {
		// TODO Auto-generated method stub
		Athlete sathlete = (Athlete) searchAthleteComboBox.getSelectedItem();
		Event sevent = (Event) searchEventComboBox.getSelectedItem();
		SelectedEvent se = new SelectedEvent();
		se.setAthlete_id(sathlete.getId());
		se.setEvent_id(sevent.getId());
		EventDao eventDao = new EventDao();
		if(!eventDao.selectedEnable(sevent.getId())){
			JOptionPane.showMessageDialog(this, "该比赛项目报名人数已满，不能再报名!");
			return;
		}
		SelectedEventDao seDao = new SelectedEventDao();
		if(seDao.isSelected(se)){
			JOptionPane.showMessageDialog(this, "已经报名过这个项目了，不能再报名!");
			return;
		}
		if(seDao.addSelectedEvent(se)){
			if(eventDao.updateSelectedNum(se.getEvent_id(),1)){
				JOptionPane.showMessageDialog(this, "报名成功!");
			}else{
				JOptionPane.showMessageDialog(this, "报名成功，报名信息更新失败!");
			}
		}else{
			JOptionPane.showMessageDialog(this, "报名失败!");
		}
		eventDao.closeDao();
		seDao.closeDao();
		initTable();//刷新面板
	}

	private void setAthleteCombox(){
		AthleteDao athleteDao = new AthleteDao();
		athleteList = athleteDao.getAthleteList(new Athlete());
		athleteDao.closeDao();
		for (Athlete athlete : athleteList) {
			searchAthleteComboBox.addItem(athlete);
			editAthleteComboBox.addItem(athlete);
		}
		if("运动员".equals(MainFrm.userType.getName())){//使运动员不能修改其他人信息
			Athlete user = (Athlete) MainFrm.userObject;
			for(int i = 0; i < searchAthleteComboBox.getItemCount();i++){
				Athlete athlete = (Athlete) searchAthleteComboBox.getItemAt(i);
				if(athlete.getId() == user.getId()){
					searchAthleteComboBox.setSelectedIndex(i);
					editAthleteComboBox.setSelectedIndex(i);
					break;
				}
			}
		}
	}
	private void setEventCombox(){
		EventDao eventDao = new EventDao();
		eventList = eventDao.getEventList(new Event());
		eventDao.closeDao();
		for (Event event : eventList) {
			searchEventComboBox.addItem(event);
			editEventComboBox.addItem(event);
		}
	}
	

	protected void selectedEvent(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = selectedEventListTable.getSelectedRow();//获取选中的行号
		String studentName = selectedEventListTable.getValueAt(row, 1).toString();
		String eventName = selectedEventListTable.getValueAt(row, 2).toString();
		for (int i = 0; i < editAthleteComboBox.getItemCount();i++) {
			Athlete athlete = (Athlete) editAthleteComboBox.getItemAt(i);
			if(studentName.equals(athlete.getName())){
				editAthleteComboBox.setSelectedIndex(i);
				break;
			}
		}
		for (int i = 0; i < editEventComboBox.getItemCount();i++) {
			Event event = (Event) editEventComboBox.getItemAt(i);
			if(eventName.equals(event.getName())){
				editEventComboBox.setSelectedIndex(i);
				break;
			}
		}
	}
	
	private void getSelectedEvent(SelectedEvent selectedEvent){
		SelectedEventDao selectedEventDao = new SelectedEventDao();
		List<SelectedEvent> selectedEventList = selectedEventDao.getSelectedEventList(selectedEvent);
		DefaultTableModel dft = (DefaultTableModel) selectedEventListTable.getModel();
		dft.setRowCount(0);
		for (SelectedEvent se : selectedEventList) {
			Vector v = new Vector();
			v.add(se.getId());
			v.add(getAthleteNameById(se.getAthlete_id()));
			v.add(getEventNameById(se.getEvent_id()));
			dft.addRow(v);
		}
		selectedEventDao.closeDao();
	}
	
	private String getAthleteNameById(int id){
		for (int i = 0; i < athleteList.size(); i++) {
			if(athleteList.get(i).getId() == id)  return athleteList.get(i).getName();
		}
		return "";
	}
	private String getEventNameById(int id){
		for (int i = 0; i < eventList.size(); i++) {
			if(id == eventList.get(i).getId())  return eventList.get(i).getName();
		}
		return "";
	}
	private int getEventIdByName(String name){
		for (int i = 0; i < eventList.size(); i++) {
			if(name.equals(eventList.get(i).getName()))  return eventList.get(i).getId();
		}
		return 0;
	}
	
	private void initTable(){
		Athlete athlete = (Athlete) searchAthleteComboBox.getSelectedItem();
		SelectedEvent se = new  SelectedEvent();
		se.setAthlete_id(athlete.getId());
		getSelectedEvent(se);
	}
	
	protected void setAuthority() {
		if("运动员".equals(MainFrm.userType.getName())) {
			searchAthleteComboBox.setEnabled(false);
			editAthleteComboBox.setEnabled(false);
		}
	}
	
	
}
