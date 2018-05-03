package GUI;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Inbox {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inbox window = new Inbox("                       ");
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
	public Inbox(String path) {
		frame = new JFrame("Inbox");
		frame.setBounds(5, 30, 461, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String[] s = new File(path + "/Inbox").list();
		@SuppressWarnings({"unchecked", "rawtypes"})
		JList list = new JList(s);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setValueIsAdjusting(true);
		list.setSelectedIndex(0);
		list.setBounds(5, 30, 450, 300);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(5, 30, 450, 300);
		frame.getContentPane().add(scrollPane);

		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
	}

}
