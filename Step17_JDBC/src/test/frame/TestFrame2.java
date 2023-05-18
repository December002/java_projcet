package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.memberDao.MemberDao;
import test.memberDto.MemberDto;
import test.mypac.Member;

public class TestFrame2  extends JFrame implements ActionListener{
	JTextField inputName, inputAddr;
	DefaultTableModel model;
	
	
	public TestFrame2(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		JLabel label3=new JLabel("번호");
		JTextField inputNum=new JTextField(10);
		
		JLabel label1=new JLabel("이름");
		inputName=new JTextField(10);
		
		JLabel label2=new JLabel("주소");
		inputAddr=new JTextField(10);
		
		JButton addBtn=new JButton("추가");
		addBtn.addActionListener(this);
		addBtn.setActionCommand("add");
		
		JButton delBtn=new JButton("삭제");
		
		JPanel panel=new JPanel();
		panel.add(label3);
		panel.add(inputNum);
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(delBtn);
		
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.yellow);
		
		JTable table=new JTable();
		
		String[] colNames= {"번호", "이름", "주소"};
		model = new DefaultTableModel(colNames, 0);
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		
		//Sample 데이터
//		Object[] row1= {1, "김구라", "노량진"};
//		Object[] row2= {2, "해골", "행신동"};
//		Object[] row3= {3, "원숭이", "상도동"};
//		
//		model.addRow(row1);
//		model.addRow(row2);
//		model.addRow(row3);
		
		List<MemberDto> list=new MemberDao().getList();
		for(MemberDto tmp:list) {
			Object[] row= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			model.addRow(row);
		}
		
		delBtn.addActionListener((e)->{
			int num=Integer.parseInt(inputNum.getText());
			MemberDto dto=new MemberDto();
			dto.setNum(num);
			boolean isSuccess=new MemberDao().delete(num);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, "삭제했습니다.");
				List<MemberDto> list2=new ArrayList<>();
				for(MemberDto tmp:list2) {
					Object[] row= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
					model.addRow(row);
				}
			}
		});	
	}
	
	public static void main(String[] args) {
		TestFrame2 f=new TestFrame2("테스트");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();
		if(cmd.equals("add")) {
			String name=inputName.getText();
			String addr=inputAddr.getText();
			MemberDto dto=new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			boolean isSuccess=new MemberDao().insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, "추가했습니다");
				model.setRowCount(0);
				List<MemberDto> list=new ArrayList<>();
				for(MemberDto tmp:list) {
					Object[] row= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
					model.addRow(row);
				}
			}
		}
	}
}
