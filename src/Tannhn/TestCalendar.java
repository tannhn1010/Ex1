package Tannhn;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarNameProvider;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import com.toedter.calendar.JDateChooser;

public class TestCalendar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCalendar window = new TestCalendar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestCalendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(254, 107, 91, 20);
		frame.getContentPane().add(dateChooser);
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		Date date = new Date();
		System.out.println(date);
		//dateChooser.setDate();
		
		String date1 = "13 Oct 2016";
		java.util.Date date2;
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			dateChooser.setDate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
