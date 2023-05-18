package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import friendsDao.FriendsDao;
import friendsDto.FriendsDto;

public class MyFrame extends JFrame{
	DefaultTableModel model;
	public MyFrame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JLabel label1=new JLabel("이름");
		JTextField inputName=new JTextField(10);
		
		JLabel label2=new JLabel("별명");
		JTextField inputNick=new JTextField(10);
		
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputNick);
		
		add(panel, BorderLayout.NORTH);
		
		panel.setBackground(Color.cyan);
		
		JTable table=new JTable();
		
		String[] colNames= {"번호", "이름", "주소"};
		model=new DefaultTableModel(colNames, 0);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		
		displayFriends();
	}
	
	public static void main(String[] args) {
		MyFrame f=new MyFrame("친구목록");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	
	public void displayFriends() {
		model.setRowCount(0);
		List<FriendsDto> list=new FriendsDao().getList();
		for(FriendsDto tmp:list) {
			Object[] row= {tmp.getNum(),tmp.getName(), tmp.getNick()};
			model.addRow(row);
		}
	}
}
