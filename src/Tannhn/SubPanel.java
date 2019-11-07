package Tannhn;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class SubPanel extends JFrame {
	private JTable table;
	Object columnNames[] = {"name","size","¼¦","temp","price"};
	public SubPanel(Model model) {
			System.out.println("do!!@");
			System.out.println("data = "+ model.getData());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(550, 700);
			setVisible(true);
			setLocation(900, 100);
			getContentPane().setLayout(null);
			JPanel panel = new JPanel();
			
			panel.setBounds(25, 41, 500, 215);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			Object [][]  array6  = {{1,"asd",123,"asdasd","adssdas"}
			                       , {2,3,123,"asdasd","adssdas"}
			                        , {4,5,6,"asdasd","adssdas"}};
			
			table = new JTable(  array6 ,columnNames);
			table.setBounds(1, 27, 450, 288);
			panel.add(table);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(13, 5, 469, 200);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			panel.add(scrollPane);
			
			JButton btnNewButton = new JButton("POS");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {//Ã¢´Ý±â
					setVisible(false);
				}
			});
			
			JLabel lblNewLabel = new JLabel("\uBA54\uB274\uBCC4 \uD310\uB9E4\uB7C9");
			lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
			lblNewLabel.setBounds(25, 275, 100, 20);
			lblNewLabel.setText(model.getData());
			getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("\uC624\uB298 \uD310\uB9E4\uB9AC\uC2A4\uD2B8");
			lblNewLabel_2.setFont(new Font("±¼¸²", Font.BOLD, 12));
			lblNewLabel_2.setBounds(25, 16, 100, 20);
			lblNewLabel_2.setText(model.getData());
			getContentPane().add(lblNewLabel_2);
			
		}
	}
