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
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.ScrollPane;

import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hn0820.dao.DivisionDao;
import com.hn0820.model.Division;
import com.hn0820.util.StringUtil;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DivisionManageFrm extends JInternalFrame {
	private JTextField searchDivisionNameTextField;
	private JTable divisionListTable;
	private JTextField editDivisionNameTextField;
	private JTextField editDivisionNoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DivisionManageFrm frame = new DivisionManageFrm();
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
	public DivisionManageFrm() {
		
		setClosable(true);
		setIconifiable(true);//可以放大缩小
		
		setTitle("\u5B66\u9662\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 790, 538);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u9662\u540D\u79F0:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchDivisionNameTextField = new JTextField();
		searchDivisionNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Division div = new Division();
				div.setName(searchDivisionNameTextField.getText().toString());
				setTable(div);			
				}
		});
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u9662\u540D\u79F0:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("\u53F7\u7801\u5E03\u5206\u914D:");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editDivisionNameTextField = new JTextField();
		editDivisionNameTextField.setColumns(10);
		
		editDivisionNoTextField = new JTextField();
		editDivisionNoTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton submitDeleteButton = new JButton("\u5220\u9664");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteDivisionAct(ae);
			}
		});
		submitDeleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(72, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(8)))
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(editDivisionNoTextField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addGap(121)
									.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(submitDeleteButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addComponent(editDivisionNameTextField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addGap(48))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(152)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchDivisionNameTextField, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(searchButton, Alignment.TRAILING)
								.addComponent(searchDivisionNameTextField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(lblNewLabel)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(16)
										.addComponent(lblNewLabel_1))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(11)
										.addComponent(editDivisionNameTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
								.addGap(15)
								.addComponent(editDivisionNoTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(19, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(submitDeleteButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGap(28)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(28))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(458, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addGap(32))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {submitButton, submitDeleteButton});
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {searchDivisionNameTextField, searchButton});
		
		divisionListTable = new JTable();
		divisionListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		divisionListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u9662\u7F16\u53F7", "\u5B66\u9662\u540D\u79F0", "\u53F7\u7801\u5E03\u5206\u914D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		divisionListTable.getColumnModel().getColumn(2).setPreferredWidth(129);
		divisionListTable.setBackground(Color.WHITE);
		scrollPane.setViewportView(divisionListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Division());
	}
	
	
	protected void deleteDivisionAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "确定删除?") != JOptionPane.OK_OPTION) {
			return;
		};
		int index = divisionListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) divisionListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(divisionListTable.getSelectedRow(),0).toString());
		DivisionDao divisionDao = new DivisionDao();
		if(divisionDao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功!");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败!");
		}
		setTable(new Division());
	}

	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		DivisionDao divisionDao = new DivisionDao();
		int index = divisionListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) divisionListTable.getModel();
		String divisionName = dft.getValueAt(divisionListTable.getSelectedRow(), 1).toString();
		String divisionNo = dft.getValueAt(divisionListTable.getSelectedRow(), 2).toString();
		String editDivisionName = editDivisionNameTextField.getText().toString();
		String editDivisionNo = editDivisionNoTextField.getText().toString();
		if(StringUtil.isEmpty(editDivisionName)){
			JOptionPane.showMessageDialog(this, "请填写要修改的名称!");
			return;
		}
		if(divisionName.equals(editDivisionName) && divisionNo.equals(editDivisionNo)){
			JOptionPane.showMessageDialog(this, "您还没有做任何修改!");
			return;
		}
		int id = Integer.parseInt(dft.getValueAt(divisionListTable.getSelectedRow(), 0).toString());
		Division div = new Division();
		div.setId(id);
		div.setName(editDivisionName);
		div.setNo(editDivisionNo);
		if(divisionDao.update(div)){
			JOptionPane.showMessageDialog(this, "修改成功!");
		}else{
			JOptionPane.showMessageDialog(this, "修改失败!");
		}
		divisionDao.closeDao();
		setTable(new Division());
	}

	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) divisionListTable.getModel();
		editDivisionNameTextField.setText(dft.getValueAt(divisionListTable.getSelectedRow(), 1).toString());
		editDivisionNoTextField.setText(dft.getValueAt(divisionListTable.getSelectedRow(), 2).toString());
	};

	private void setTable(Division division){
		DefaultTableModel dft = (DefaultTableModel) divisionListTable.getModel();
		dft.setRowCount(0);
		DivisionDao divisionDao = new DivisionDao();
		List<Division> divisionList = divisionDao.getDivisionList(division);
		for (Division sc : divisionList) {
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getNo());
			dft.addRow(v);
		}
		divisionDao.closeDao();
	}
	
	
	
}
