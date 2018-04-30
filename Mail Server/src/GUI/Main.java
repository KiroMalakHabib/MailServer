package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main("                 ");
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
	public Main(String path) {
		initialize(path);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String path) {
		frame = new JFrame();
		frame.setBounds(10, 10, 350, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		JButton btnDrafts = new JButton("Drafts");
		btnDrafts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDrafts.setBounds(6, 69, 117, 29);
		panel.add(btnDrafts);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(149, 16, 56, 16);
		panel.add(lblWelcome);

		JButton btnInbox = new JButton("Inbox");
		btnInbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Inbox(path);
			}
		});
		btnInbox.setBounds(6, 34, 117, 29);
		panel.add(btnInbox);

		JButton btnSentMails = new JButton("Sent Mails");
		btnSentMails.setBounds(229, 34, 117, 29);
		panel.add(btnSentMails);

		JButton btnStarred = new JButton("Starred");
		btnStarred.setBounds(119, 69, 117, 29);
		panel.add(btnStarred);

		JButton btnTrash = new JButton("Trash");
		btnTrash.setBounds(229, 69, 117, 29);
		panel.add(btnTrash);

		JLabel lblNewLabel = new JLabel(path.substring(21, path.length() - 1));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(144, 39, 61, 16);
		panel.add(lblNewLabel);
	}
}
