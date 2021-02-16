package com.hn0820.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hn0820.model.UserType;


public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JMenu eventMenu;
	private JMenu manageDivisionMenu;
	private JMenuItem addAthleteMenuItem;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm(null,null);
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
	public MainFrm(UserType userType,Object userObject) {
		this.userType = userType;
		this.userObject = userObject;
		setTitle("\u8FD0\u52A8\u4F1A\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 749);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editpassword(ae);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出吗？") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u8FD0\u52A8\u5458\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		addAthleteMenuItem = new JMenuItem("\u8FD0\u52A8\u5458\u6DFB\u52A0");
		addAthleteMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddAthleteFrm addAthleteFrm = new AddAthleteFrm();
				addAthleteFrm.setVisible(true);
				desktopPane.add(addAthleteFrm);
				
				
				///////
			}
		});
		mnNewMenu_1.add(addAthleteMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u8FD0\u52A8\u5458\u7BA1\u7406");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AthleteManageFrm athleteManageFrm = new AthleteManageFrm();
				athleteManageFrm.setVisible(true);
				desktopPane.add(athleteManageFrm);//将菜单栏选项与修改界面关联
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		manageDivisionMenu = new JMenu("\u5B66\u9662\u4EE3\u8868\u961F\u7BA1\u7406");
		menuBar.add(manageDivisionMenu);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5B66\u9662\u6DFB\u52A0");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addDivision(ae);
			}
		});
		manageDivisionMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5B66\u9662\u7BA1\u7406");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DivisionManageFrm divisionManageFrm = new DivisionManageFrm();
				divisionManageFrm.setVisible(true);
				desktopPane.add(divisionManageFrm);
			}
		});
		manageDivisionMenu.add(mntmNewMenuItem_5);
		
		eventMenu = new JMenu("\u8FD0\u52A8\u4F1A\u9879\u76EE\u7BA1\u7406");
		menuBar.add(eventMenu);
		
		JMenuItem addEventMenuItem = new JMenuItem("\u6DFB\u52A0\u6BD4\u8D5B\u9879\u76EE");
		addEventMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				AddEventFrm addEventFrm = new AddEventFrm();
				addEventFrm.setVisible(true);
				desktopPane.add(addEventFrm);
			}
		});
		eventMenu.add(addEventMenuItem);
		
		JMenuItem eventListMenuItem = new JMenuItem("\u6BD4\u8D5B\u9879\u76EE\u5217\u8868");
		eventListMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventManageFrm eventManageFrm = new EventManageFrm();
				eventManageFrm.setVisible(true);
				desktopPane.add(eventManageFrm);
				
			}
		});
		eventMenu.add(eventListMenuItem);
		
		JMenu mnNewMenu_5 = new JMenu("\u62A5\u540D\u7BA1\u7406");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u62A5\u540D\u7BA1\u7406");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageSelectedEventFrm manageSelectedEventFrm = new ManageSelectedEventFrm();
				manageSelectedEventFrm.setVisible(true);
				desktopPane.add(manageSelectedEventFrm);
				
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				AboutUs(ae);
			}
			
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);//居中显示
		setAuthority();
	}

	protected void addDivision(ActionEvent ae) {
		// TODO Auto-generated method stub
		DivisionAddFrm daf = new DivisionAddFrm();
		daf.setVisible(true);
		desktopPane.add(daf);
	}

	protected void editpassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}

	protected void AboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		String info = "数据库课程设计-运动会管理系统\n";
		info+="20181001235-191184-于海宁\n";
		JOptionPane.showMessageDialog(this, info);
	}
	
	protected void setAuthority() {
		if("运动员".equals(userType.getName())) {
			addAthleteMenuItem.setEnabled(false);
			manageDivisionMenu.setEnabled(false);
			eventMenu.setEnabled(false);
		}
	}
}
