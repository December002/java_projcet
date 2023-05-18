package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import friendsDao.FriendsDao;
import friendsDto.FriendsDto;

public class MyFrame extends JFrame implements ActionListener{
	DefaultTableModel model;
	JTextField inputName, inputNick;
	JTable table;
	public MyFrame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JLabel label1=new JLabel("이름");
		inputName=new JTextField(10);
		
		JLabel label2=new JLabel("별명");
		inputNick=new JTextField(10);
		
		JButton addBtn=new JButton("추가");
		addBtn.setActionCommand("add");
		addBtn.addActionListener(this);
		
		JButton delBtn=new JButton("삭제");
		delBtn.setActionCommand("delete");
		delBtn.addActionListener(this);
		
		JButton upBtn=new JButton("수정");
		upBtn.setActionCommand("update");
		upBtn.addActionListener(this);
		
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputNick);
		panel.add(addBtn);
		panel.add(delBtn);
		panel.add(upBtn);
		
		add(panel, BorderLayout.NORTH);
		
		panel.setBackground(Color.cyan);
		
		table=new JTable();
		
		String[] colNames= {"번호", "이름", "다른 이름"};
		model=new DefaultTableModel(colNames, 0);
		table.setModel(model);
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


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();
		if(cmd.equals("add")) {
			String name=inputName.getText();
			String Nick=inputNick.getText();
			FriendsDto dto=new FriendsDto();
			dto.setName(name);
			dto.setNick(Nick);
			boolean isAdd=new FriendsDao().insert(dto);
			if(isAdd) {
				JOptionPane.showMessageDialog(this, "추가했습니다");
				displayFriends();
			}
		}else if(cmd.equals("delete")) {
			int selectedRow=table.getSelectedRow();
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요");
				return;
			}
			int result=JOptionPane.showConfirmDialog(this, "삭제하시겠습니까?");
			if(result==JOptionPane.YES_OPTION) {
				int num=(int)model.getValueAt(selectedRow, 0);
				new FriendsDao().delete(num);
				displayFriends();
			}
		}
		else if(cmd.equals("update"));
		int selectedRow=table.getSelectedRow();
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요");
			return;
		}
		int result=JOptionPane.showConfirmDialog(this, "수정하시겠습니까?");
		if(result==JOptionPane.YES_OPTION) {
			FriendsDto dto=new FriendsDto();
			int num=(int)model.getValueAt(selectedRow, 0);		
			String name=inputName.getText();
			String nick=inputName.getText();
			dto.setName(name);
			dto.setNick(nick);
			dto.setNum(num);
			new FriendsDao().update(dto);
			displayFriends();
		}	
	}
}
