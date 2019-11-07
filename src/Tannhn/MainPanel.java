package Tannhn;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel {
	private JTextField textField;
	private JFrame frame;
	Model model = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		model = new Model();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 535, 457);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Send Data");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 33));
		lblNewLabel.setBounds(186, 34, 180, 63);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(41, 163, 213, 145);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Send");
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 27));
		btnNewButton.setBounds(302, 163, 170, 145);
		frame.getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("do");
				model.setData("data Send!!");
				new SubPanel(model);
			}
		});
	}
}