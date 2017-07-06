package GUI;
//Create frame

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import static java.awt.event.InputEvent.*;

public class ActionObjects_Sample {

	private JFrame jFrame;
	private JMenuBar jMenuBar;
	private JMenu fileMenu;
	private FileMenuAction openFile, quit, recentFiles; // Menu items will be created using this type

	public void createGUI() {
		jFrame = createJFrame();
		setJMenuBar();
		createActionObjects();
		setFileMenu();
		jFrame.setVisible(true);
	}

	public void setJMenuBar() {
		jMenuBar = new JMenuBar();
		jFrame.setJMenuBar(jMenuBar);
	}

	public void createActionObjects() {
		openFile = new FileMenuAction("Open", 'O', ALT_DOWN_MASK);
		recentFiles = new FileMenuAction("Recent", 'R', ALT_DOWN_MASK);
		quit = new FileMenuAction("Quit");
	}

	public void setFileMenu() {
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		jMenuBar.add(fileMenu);
		setFileMenuItems();

	}

	public void setFileMenuItems() {
		fileMenu.add(openFile);
		fileMenu.add(recentFiles);
		fileMenu.add(quit);
	}

	public JFrame createJFrame() {
		jFrame = new JFrame("Action Objects Sample");
		Toolkit theKit = jFrame.getToolkit();                             // Get the window toolkit
		Dimension wndSize = theKit.getScreenSize();                       // Get screen size
		jFrame.setSize(wndSize.width / 2, wndSize.height / 2);   	      // Set window size
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}

	public static void main(String[] args) {
		ActionObjects_Sample appInstance = new ActionObjects_Sample();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				appInstance.createGUI();
			}
		});
	}

	// Inner class for FileMenu Actions
	class FileMenuAction extends AbstractAction {

		// Constructor to create object with name - Which is to IDENTIFY the object 
		public FileMenuAction(String objectName) {
			super(objectName);
		}

		// Constructor to Create action with a name and accelerator key
		FileMenuAction(String name, char ch, int modifiers) {
			super(name);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(ch, modifiers)); //Set property by key:value

			// Now find the character to underline
			int index = name.toUpperCase().indexOf(ch);
			if (index != -1) {
				putValue(DISPLAYED_MNEMONIC_INDEX_KEY, index); //Set property by key:value
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (getValue(NAME).equals("Open")){
				System.out.println("Open file pressed");
			}
			if (getValue(NAME).equals("Recent")){
				System.out.println("Recent files pressed");
			}
			if (getValue(NAME).equals("Quit")){
				System.out.println("Quiting...");
				System.exit(0);
			}
		}

	}
}
