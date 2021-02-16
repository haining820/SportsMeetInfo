package com.hn0820.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.hn0820.dao.AthleteDao;
import com.hn0820.dao.DivisionDao;
import com.hn0820.model.Athlete;
import com.hn0820.model.Division;
import com.hn0820.util.StringUtil;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;



public class AddAthleteFrm extends JInternalFrame {
	private JTextField athleteNameTextField;
	private JTextField athletePasswordRTextField;
	private JComboBox athleteDivisionComboBox;
	private ButtonGroup sexButtonGroup;
	private JRadioButton athleteSexMaleRadioButton;
	private JRadioButton athleteSexFemaleRadioButton;
	private JTextField athleteStudentnumberTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAthleteFrm frame = new AddAthleteFrm();
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
	public AddAthleteFrm() {
		
		setClosable(true);
		setIconifiable(true);//ø…“‘∑≈¥ÛÀı–°
		
		setTitle("\u8FD0\u52A8\u5458\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 451, 371);
		
		JLabel lblNewLabel = new JLabel("\u8FD0\u52A8\u5458\u59D3\u540D:");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u5B66\u9662:");
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u9646\u5BC6\u7801:");
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		athleteNameTextField = new JTextField();
		athleteNameTextField.setColumns(10);
		
		athleteDivisionComboBox = new JComboBox();
		athleteDivisionComboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		
		athletePasswordRTextField = new JTextField();
		athletePasswordRTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8FD0\u52A8\u5458\u6027\u522B:");
		lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		athleteSexMaleRadioButton = new JRadioButton("\u7537");
		athleteSexMaleRadioButton.setSelected(true);
		athleteSexMaleRadioButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		athleteSexMaleRadioButton.setToolTipText("");
		
		athleteSexFemaleRadioButton = new JRadioButton("\u5973");
		athleteSexFemaleRadioButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		sexButtonGroup = new ButtonGroup();//?
		sexButtonGroup.add(athleteSexMaleRadioButton);
		sexButtonGroup.add(athleteSexFemaleRadioButton);
		
		
		
		JButton submitButton = new JButton("\u786E\u5B9A");
		submitButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				athleteAddAct(ae);
			}
		});
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("\u8FD0\u52A8\u5458\u5B66\u53F7:");
		lblNewLabel_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		athleteStudentnumberTextField = new JTextField();
		athleteStudentnumberTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(108, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
												.addGap(5))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel_3)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addComponent(athleteSexMaleRadioButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(athleteSexFemaleRadioButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(athleteDivisionComboBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
												.addComponent(athletePasswordRTextField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
												.addComponent(athleteNameTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addGap(17)
									.addComponent(athleteStudentnumberTextField, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(lblNewLabel_4))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(athleteStudentnumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(athleteNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(athleteDivisionComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(athletePasswordRTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(15))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(18)))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(athleteSexMaleRadioButton)
						.addComponent(athleteSexFemaleRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(resetButton, Alignment.TRAILING)
						.addComponent(submitButton, Alignment.TRAILING))
					.addGap(28))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {athleteNameTextField, athleteDivisionComboBox, athletePasswordRTextField});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {athleteNameTextField, athleteDivisionComboBox, athletePasswordRTextField});
		getContentPane().setLayout(groupLayout);
		setAthleteDivisionNo();//?
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		athleteNameTextField.setText("");
		athletePasswordRTextField.setText("");
		athleteStudentnumberTextField.setText("");
		athleteDivisionComboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
		athleteSexMaleRadioButton.setSelected(true);
	}

	protected void athleteAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String athleteName = athleteNameTextField.getText().toString();
		String athletePassword = athletePasswordRTextField.getText().toString();
		String studentnumber = athleteStudentnumberTextField.getText().toString();
		if(StringUtil.isEmpty(studentnumber)){
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥‘À∂Ø‘±—ß∫≈!");
			return;
		}
		if(StringUtil.isEmpty(athleteName)){
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥‘À∂Ø‘±–’√˚!");
			return;
		}
		if(StringUtil.isEmpty(athletePassword)){
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥√‹¬Î!");
			return;
		}
		Division div = (Division)athleteDivisionComboBox.getSelectedItem();
		String sex = athleteSexMaleRadioButton.isSelected() ? athleteSexMaleRadioButton.getText() :  athleteSexFemaleRadioButton.getText();
		Athlete athlete = new Athlete();
		athlete.setStudentnumber(studentnumber);
		athlete.setName(athleteName);
		athlete.setDivisionId(div.getId());
		athlete.setPassword(athletePassword);
		athlete.setSex(sex);
		AthleteDao athletetDao = new AthleteDao();
		if(athletetDao.addAthlete(athlete)){
			JOptionPane.showMessageDialog(this, "ÃÌº”≥…π¶!");
		}else{
			JOptionPane.showMessageDialog(this, "ÃÌº” ß∞‹!");
		}
		resetValue(ae);
	}
	
	private void setAthleteDivisionNo(){
		DivisionDao divisionDao = new DivisionDao();
		List<Division> divisionList = divisionDao.getDivisionList(new Division());
		for (Division div : divisionList) {
			athleteDivisionComboBox.addItem(div);
		}
		divisionDao.closeDao();
	}
}
