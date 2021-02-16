package com.hn0820.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hn0820.dao.AthleteDao;
import com.hn0820.dao.DivisionDao;
import com.hn0820.model.Athlete;
import com.hn0820.model.Division;
import com.hn0820.util.StringUtil;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AthleteManageFrm extends JInternalFrame {
	private JTextField searchAthleteNameTextField;
	private JTable athleteListTable;
	private JTextField editAthleteNameTextField;
	private JTextField editAthleteStudentnumberTextField;
	private JTextField editAthletePasswordTextField;
	
	private JComboBox searchDivisionComboBox;
	private List<Division> divisionList;
	private JComboBox editAthleteDivisionComboBox;
	private ButtonGroup editSexButtonGroup;
	private JRadioButton editAthleteSexFemaleRadioButton; 
	
	private JRadioButton editAthleteSexMaleRadioButton; 
	private JButton deleteAthleteButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AthleteManageFrm frame = new AthleteManageFrm();
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
	public AthleteManageFrm() {
		
		setClosable(true);
		setIconifiable(true);//可以放大缩小
		
		setTitle("\u8FD0\u52A8\u5458\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 830, 575);
		
		JLabel lblNewLabel = new JLabel("\u8FD0\u52A8\u5458\u59D3\u540D:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchAthleteNameTextField = new JTextField();
		searchAthleteNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u5B66\u9662:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchDivisionComboBox = new JComboBox();
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchAthlete(ae);
				
			}
		});
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("\u8FD0\u52A8\u5458\u59D3\u540D:");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editAthleteNameTextField = new JTextField();
		editAthleteNameTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u5B66\u9662:");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editAthleteDivisionComboBox = new JComboBox();
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B:");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_5 = new JLabel("\u8FD0\u52A8\u5458\u5B66\u53F7:");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editAthleteStudentnumberTextField = new JTextField();
		editAthleteStudentnumberTextField.setColumns(10);
		
		
		editSexButtonGroup = new ButtonGroup();
		
		editAthleteSexMaleRadioButton = new JRadioButton("\u7537");
		editAthleteSexMaleRadioButton.setSelected(true);
		
		editAthleteSexFemaleRadioButton = new JRadioButton("\u5973");
		editSexButtonGroup.add(editAthleteSexMaleRadioButton);
		editSexButtonGroup.add(editAthleteSexFemaleRadioButton);
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
				
			}
		});
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		deleteAthleteButton = new JButton("\u5220\u9664");
		deleteAthleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				deleteAthlete(ae);
			}
		});
		deleteAthleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_6 = new JLabel("\u767B\u5F55\u5BC6\u7801:");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editAthletePasswordTextField = new JTextField();
		editAthletePasswordTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchAthleteNameTextField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(searchDivisionComboBox, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(editAthleteNameTextField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
										.addComponent(editAthleteDivisionComboBox, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6))
									.addGap(2)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(editAthletePasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(editAthleteStudentnumberTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(14)
											.addComponent(lblNewLabel_4)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(editAthleteSexMaleRadioButton)
											.addGap(4)
											.addComponent(editAthleteSexFemaleRadioButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(submitEditButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(deleteAthleteButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
									.addGap(32))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE))))
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.TRAILING)
						.addComponent(searchAthleteNameTextField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, Alignment.TRAILING)
						.addComponent(searchDivisionComboBox, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton, Alignment.TRAILING))
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(editAthleteNameTextField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, Alignment.TRAILING)
								.addComponent(lblNewLabel_5, Alignment.TRAILING)
								.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(editAthleteStudentnumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(editAthleteSexFemaleRadioButton)
									.addComponent(editAthleteSexMaleRadioButton)
									.addComponent(lblNewLabel_4)))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(editAthletePasswordTextField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, Alignment.TRAILING)
								.addComponent(editAthleteDivisionComboBox, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6, Alignment.TRAILING)))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(submitEditButton)
							.addComponent(deleteAthleteButton)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {searchAthleteNameTextField, searchDivisionComboBox});
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {editAthleteNameTextField, editAthleteDivisionComboBox, editAthleteStudentnumberTextField, editAthletePasswordTextField});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {searchAthleteNameTextField, searchDivisionComboBox});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {editAthleteNameTextField, editAthleteDivisionComboBox, editAthleteStudentnumberTextField, editAthletePasswordTextField});
		
		athleteListTable = new JTable();
		athleteListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				
					selectedTableRow(me);

			}
		});
		athleteListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5B66\u53F7", "\u8FD0\u52A8\u5458\u59D3\u540D", "\u6240\u5C5E\u5B66\u9662", "\u6027\u522B", "\u767B\u5F55\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(athleteListTable);
		getContentPane().setLayout(groupLayout);

		setDivisionNo();
		setTable(new Athlete());
		
		setAuthority();
	}
	
	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = athleteListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String athleteStudentnumber = editAthleteStudentnumberTextField.getText().toString();
		String athleteName = editAthleteNameTextField.getText().toString();
		String athletePassword = editAthletePasswordTextField.getText().toString();
		if(StringUtil.isEmpty(athleteStudentnumber)){
			JOptionPane.showMessageDialog(this, "请填写运动员学号！");
			return;
		}
		if(StringUtil.isEmpty(athleteName)){
			JOptionPane.showMessageDialog(this, "请填写运动员姓名！");
			return;
		}
		if(StringUtil.isEmpty(athletePassword)){
			JOptionPane.showMessageDialog(this, "请填写登录密码！");
			return;
		}
		
		Athlete athlete = new Athlete();
		athlete.setStudentnumber(athleteStudentnumber);
		athlete.setName(athleteName);
		athlete.setPassword(athletePassword);
		Division div = (Division)editAthleteDivisionComboBox.getSelectedItem();
		athlete.setDivisionId(div.getId());
		athlete.setId(Integer.parseInt(athleteListTable.getValueAt(row, 0).toString()));
		if(editAthleteSexMaleRadioButton.isSelected())athlete.setSex(editAthleteSexMaleRadioButton.getText().toString());
		if(editAthleteSexFemaleRadioButton.isSelected())athlete.setSex(editAthleteSexFemaleRadioButton.getText().toString());
		AthleteDao athleteDao = new AthleteDao();
		if(athleteDao.update(athlete)){
			JOptionPane.showMessageDialog(this, "修改成功！");
		}else{
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		athleteDao.closeDao();
		setTable(new Athlete());
	}

	protected void deleteAthlete(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = athleteListTable.getSelectedRow();
		if(row==-1) {//没有选中
			JOptionPane.showMessageDialog(this, "请选中要删除的数据!");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确定删除?") != JOptionPane.OK_OPTION) {
			return;
		};
		AthleteDao athletetDao = new AthleteDao();
		if(athletetDao.delete(Integer.parseInt(athleteListTable.getValueAt(row,0).toString()))) {
			JOptionPane.showMessageDialog(this, "删除成功!");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败!");
		}
		
		athletetDao.closeDao();
		setTable(new Athlete());
	}

	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) athleteListTable.getModel();
		editAthleteStudentnumberTextField.setText(dft.getValueAt(athleteListTable.getSelectedRow(), 1).toString());
		editAthleteNameTextField.setText(dft.getValueAt(athleteListTable.getSelectedRow(), 2).toString());
		editAthletePasswordTextField.setText(dft.getValueAt(athleteListTable.getSelectedRow(), 5).toString());
		String divisionName = dft.getValueAt(athleteListTable.getSelectedRow(),3).toString();
		for(int i=0;i<editAthleteDivisionComboBox.getItemCount();i++) {
			Division div = (Division)editAthleteDivisionComboBox.getItemAt(i);
			if(divisionName.equals(div.getName())) {
				editAthleteDivisionComboBox.setSelectedIndex(i);
			}
		}
		String sex = dft.getValueAt(athleteListTable.getSelectedRow(), 4).toString();
		editSexButtonGroup.clearSelection();
		if(sex.equals(editAthleteSexMaleRadioButton.getText()))editAthleteSexMaleRadioButton.setSelected(true);
		if(sex.equals(editAthleteSexFemaleRadioButton.getText()))editAthleteSexFemaleRadioButton.setSelected(true);
	};
	
	protected void searchAthlete(ActionEvent ae) {
		// TODO Auto-generated method stub
		Athlete athlete = new Athlete();
		athlete.setName(searchAthleteNameTextField.getText().toString());
		Division div = (Division)searchDivisionComboBox.getSelectedItem();
		athlete.setDivisionId(div.getId());
		setTable(athlete);
	}

	
	
	private void setTable(Athlete athlete){
		if("运动员".equals(MainFrm.userType.getName())){
			Athlete a = (Athlete)MainFrm.userObject;//??
			athlete.setName(a.getName());
			}//设置权限
		DefaultTableModel dft = (DefaultTableModel) athleteListTable.getModel();
		dft.setRowCount(0);
		AthleteDao athleteDao = new AthleteDao();
		List<Athlete> athleteList = athleteDao.getAthleteList(athlete);
		for (Athlete a : athleteList) {
			Vector v = new Vector();
			v.add(a.getId());
			v.add(a.getStudentnumber());
			v.add(a.getName());
			v.add(getDivisionNameById(a.getDivisionId()));
			v.add(a.getSex());
			v.add(a.getPassword());
			dft.addRow(v);
		}
		athleteDao.closeDao();
	}
	
	private void setDivisionNo(){
		DivisionDao divisionDao = new DivisionDao();
		divisionList = divisionDao.getDivisionList(new Division());
		for (Division div : divisionList) {
			searchDivisionComboBox.addItem(div);
			editAthleteDivisionComboBox.addItem(div);//将学院信息添加到修改界面下拉框中
		}
		divisionDao.closeDao();
	}
	
	private String getDivisionNameById(int id) {
		for (Division div : divisionList) {
			if(div.getId() == id) return div.getName();
		}
		return "";//将学院id号转化为学院名称
	}
	
	private void setAuthority(){
		if("运动员".equals(MainFrm.userType.getName())){
			Athlete a = (Athlete)MainFrm.userObject;
			searchAthleteNameTextField.setText(a.getName());
			searchAthleteNameTextField.setEnabled(false);
			deleteAthleteButton.setEnabled(false);
			for(int i=0;i<searchDivisionComboBox.getItemCount();i++){
				Division div = (Division) searchDivisionComboBox.getItemAt(i);
				if(div.getId() == a.getDivisionId()){
					searchDivisionComboBox.setSelectedIndex(i);
					break;
				}
			}
			searchDivisionComboBox.setEnabled(false);
			for(int i=0;i<editAthleteDivisionComboBox.getItemCount();i++){
				Division div = (Division) editAthleteDivisionComboBox.getItemAt(i);
				if(div.getId() == a.getDivisionId()){
					editAthleteDivisionComboBox.setSelectedIndex(i);
					break;
				}
			}
			editAthleteDivisionComboBox.setEnabled(false);
		}
	}
	
	
}
