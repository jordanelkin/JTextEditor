import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class TextEditor {

	public static void main(String[] args) {
		
		//set up and declare frame with layout
		JFrame jf = new JFrame("Java Text Editor");
		jf.setSize(600, 400);
		BorderLayout bl = new BorderLayout();
		jf.setLayout(bl);
		
		
		// create menu bar and menus 
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		
		// menu items for fileMenu
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		
		//menu items for editMenu
		
		JMenuItem cut = new JMenuItem("Cut");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");
		
		
		//add menu items to menu bars
		
		fileMenu.add(newFile);
		fileMenu.add(open);
		fileMenu.add(save);
		
		editMenu.add(cut);
		editMenu.add(copy);
		editMenu.add(paste);
		
		// add menus to menu bar
		mb.add(fileMenu);
		mb.add(editMenu);
		
		jf.add(mb,BorderLayout.PAGE_START);
		
		//setup text area and add to frame
		
		TextArea ta = new TextArea();
		ta.setEditable(true);
		ta.setBounds(0, 0, 600, 300);
		
		jf.add(ta);
		jf.setVisible(true);

	}

}
