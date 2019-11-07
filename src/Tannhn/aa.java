package Tannhn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JList;

public class aa {

	private JFrame frmSendmailApp;
	private JTextField txtReceiver;
	private JTextField txtTitle;
	private JLabel lblContent;
	private JLabel lblPicture;
	private JButton btnWrite;
	private JTextArea txtContent;
	private JTextField txtWrite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aa window = new aa();
					window.frmSendmailApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public aa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSendmailApp = new JFrame();
		frmSendmailApp.setTitle("SendMail App");
		frmSendmailApp.setBounds(100, 100, 571, 324);
		frmSendmailApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSendmailApp.getContentPane().setLayout(null);
		
		
		
		
		JLabel lblReceiver = new JLabel("Receiver");
		lblReceiver.setBounds(24, 39, 56, 23);
		frmSendmailApp.getContentPane().add(lblReceiver);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(24, 73, 56, 23);
		frmSendmailApp.getContentPane().add(lblTitle);
		
		txtReceiver = new JTextField();
		txtReceiver.setBounds(106, 40, 299, 20);
		frmSendmailApp.getContentPane().add(txtReceiver);
		txtReceiver.setColumns(10);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(106, 74, 299, 20);
		frmSendmailApp.getContentPane().add(txtTitle);
		
		lblContent = new JLabel("Content");
		lblContent.setBounds(24, 107, 56, 23);
		frmSendmailApp.getContentPane().add(lblContent);
		
		JButton btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Email email = new SimpleEmail();
					
					email.setHostName(MailConfig.HOST_NAME);
					email.setSmtpPort(MailConfig.SSL_PORT);
					email.setAuthenticator(new DefaultAuthenticator(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD));
					email.setSSLOnConnect(true);
				
					try {
						email.setFrom(MailConfig.APP_EMAIL);
						email.addTo(txtReceiver.getText());
						email.setSubject(txtTitle.getText());
						email.setMsg(txtContent.getText());
						email.send();
					} catch (EmailException e) {
						// TODO Auto-generated catch block
						System.out.print(e);
					}	
					System.out.print("gui mail thanh cong");
				}
			}
		);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSend.setBounds(316, 258, 89, 23);
		frmSendmailApp.getContentPane().add(btnSend);
		
		lblPicture = new JLabel("");
		lblPicture.setBackground(new Color(240, 240, 240));
		lblPicture.setBounds(415, 39, 117, 212);
		setPicture(lblPicture, "vo.jpg");
		
		frmSendmailApp.getContentPane().add(lblPicture);
		
		btnWrite = new JButton("Write");
		btnWrite.setBounds(23, 258, 89, 23);
		frmSendmailApp.getContentPane().add(btnWrite);
		
		txtContent = new JTextArea();
		txtContent.setBounds(24, 129, 383, 87);
		frmSendmailApp.getContentPane().add(txtContent);
		
		txtWrite = new JTextField();
		txtWrite.setBounds(24, 227, 381, 20);
		frmSendmailApp.getContentPane().add(txtWrite);
		txtWrite.setColumns(10);
		btnWrite.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtContent.append(txtWrite.getText()+ "\n");
				txtWrite.setText("");
			}
			
		});
	}
	
	public void setPicture(JLabel label, String pathPic)
	{
		try {
			BufferedImage image = ImageIO.read(new File("vo.jpg"));
			int labelX = label.getWidth();
			int labelY = label.getHeight();
			int picX = image.getWidth();
			int picY = image.getHeight();
			int iconX = 0;
			int iconY = 0;
			
			if( labelX / labelY > picX / picY)
			{
				iconY = labelY;
				iconX = iconY * picX / picY;
			}
			else
			{
				iconX = labelX;
				iconY = iconX * picY / picX;
			}
			ImageIcon icon = new ImageIcon(image.getScaledInstance(iconX, iconY, image.SCALE_SMOOTH));
			lblPicture.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
