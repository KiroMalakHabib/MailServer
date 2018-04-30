package MainClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import DataStructures.SingleLinkedList;
import GUI.SignInForm;
import Interfaces.IApp;
import Interfaces.IContact;
import Interfaces.IFilter;
import Interfaces.IFolder;
import Interfaces.ILinkedList;
import Interfaces.IMail;
import Interfaces.ISort;

/**
 * @author Abanoub Ashraf
 * @author Amr
 * @author kiro
 */
public class MyApp implements IApp {

	/**
	 * Sign in to the application.
	 * 
	 * @param email
	 * @param password
	 * @return false if the email name not exist
	 */
	@Override
	public boolean signin(final String eMail, final String password) {
		// TODO Auto-generated method stub
		String email = eMail.toLowerCase();
		File f1 = new File("../Mail Server/Users/" + email);
		if (f1.exists()) {
			File f2 = new File("../Mail Server/Users/" + email + "/Info.txt");
			String read = new String();
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(f2));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				read = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				read = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (read.equals(password)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Create new account.
	 * 
	 * @param contact
	 * @return false if the email name already exist
	 */
	@Override
	public boolean signup(final IContact contact) {
		// TODO Auto-generated method stub
		File f0 = new File("../Mail Server");
		File f1 = new File("../Mail Server/Users");
		File f21 = new File("../Mail Server/Users/Index.txt");
		f0.mkdirs();
		f1.mkdirs();
		try {
			f21.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SingleLinkedList usernames = new SingleLinkedList();
		String user = new String();
		BufferedReader in = null;
		try {
			in = new BufferedReader(
					new FileReader("../Mail Server/Users/Index.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((user = in.readLine()) != null) {
				usernames.add(user);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyContact mycontact = (MyContact) (contact);
		if (usernames.contains(mycontact.username)
				|| mycontact.username.equals(null)
				|| mycontact.pass.equals(null)) {
			return false;
		}
		File f2 = new File("../Mail Server/Users/" + mycontact.username);
		File f3 = new File(
				"../Mail Server/Users/" + mycontact.username + "/Sent Mails");
		File f6 = new File(
				"../Mail Server/Users/" + mycontact.username + "/Drafts");
		File f7 = new File(
				"../Mail Server/Users/" + mycontact.username + "/Trash");
		File f4 = new File(
				"../Mail Server/Users/" + mycontact.username + "/Inbox");
		File f5 = new File(
				"../Mail Server/Users/" + mycontact.username + "/Starred");
		File f22 = new File(
				"../Mail Server/Users/" + mycontact.username + "/Info.txt");

		f2.mkdirs();
		f3.mkdirs();
		f4.mkdirs();
		f5.mkdirs();
		f6.mkdirs();
		f7.mkdirs();

		try {
			f22.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (f2.exists()) {
			FileWriter fw1 = null;
			try {
				fw1 = new FileWriter("../Mail Server/Users/Index.txt", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter pw1 = new PrintWriter(fw1);
			pw1.append(mycontact.username);
			pw1.println();
			pw1.close();
		} else {
			FileWriter fw1 = null;
			try {
				fw1 = new FileWriter("../Mail Server/Users/Index.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter pw1 = new PrintWriter(fw1);
			pw1.println(mycontact.username);
			pw1.close();
		}

		FileWriter fw2 = null;
		try {
			fw2 = new FileWriter(
					"../Mail Server/Users/" + mycontact.username + "/Info.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw2 = new PrintWriter(fw2);
		pw2.println(mycontact.username);
		pw2.println(mycontact.pass);
		pw2.close();
		return true;

	}

	/**
	 * This function should be called before reading from the index file and
	 * apply the sort and search parameters.
	 * 
	 * @param folder
	 *            currently shown, can be null.
	 * @param filter
	 *            to apply search, can be null.
	 * @param sort
	 *            to apply sort.
	 */
	@Override
	public void setViewingOptions(final IFolder folder, final IFilter filter,
			final ISort sort) {
		// TODO Auto-generated method stub
	}

	/**
	 * You should use setViewingOptions function first.
	 * 
	 * @param page
	 *            to handle paging.
	 * @return list of emails.
	 */
	@Override
	public IMail[] listEmails(final int page) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * You should use setViewingOptions function first.
	 * 
	 * @param mails
	 *            to be moved to trash.
	 */
	@Override
	public void deleteEmails(final ILinkedList mails) {
		// TODO Auto-generated method stub

	}

	/**
	 * You should use setViewingOptions function first.
	 * 
	 * @param mails
	 *            to be moved.
	 * @param des
	 *            the destination folder.
	 */
	@Override
	public void moveEmails(final ILinkedList mails, final IFolder des) {
		// TODO Auto-generated method stub
		MyFolder desfolder = (MyFolder) des;
		while (!mails.isEmpty()) {
			MyFolder moved = new MyFolder();
			moved.f1 = (File) (mails.get(0));
			moved.move(desfolder.path);
			mails.remove(0);
		}
	}

	/**
	 * Send a new email.
	 * 
	 * @param email
	 *            should contain all the information needed sender, list of.
	 *            receivers, list of attachments, email body, ...
	 * @return false if something wrong happened like sending to non-existing
	 *         user.
	 */
	@Override
	public boolean compose(final IMail email) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		new SignInForm();
	}
}