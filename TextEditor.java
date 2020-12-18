import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor {

	public static void main(String[] args) {

		// set up and declare frame with layout

		JFrame jf = new JFrame("Java Text Editor");
		jf.setSize(600, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		// menu items for editMenu

		JMenuItem cut = new JMenuItem("Cut");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");

		// add menu items to menu bars

		fileMenu.add(newFile);
		fileMenu.add(open);
		fileMenu.add(save);

		editMenu.add(cut);
		editMenu.add(copy);
		editMenu.add(paste);

		// add menus to menu bar
		mb.add(fileMenu);
		mb.add(editMenu);

		jf.add(mb, BorderLayout.PAGE_START);

		// setup text area and add to frame
		TextArea ta = new TextArea();
		ta.setEditable(true);
		ta.setBounds(0, 0, 600, 300);
		jf.add(ta);

		// set frame visibility after everything is setup in background

		jf.setVisible(true);

		// create JFileChooser

		JFileChooser fc = new JFileChooser();

		// set mouse event listeners for components
		newFile.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int input;

				input = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to create a new file without saving?", null,
						JOptionPane.OK_CANCEL_OPTION);

				if (input == 0) {
					ta.setText(" ");
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		open.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

				fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Documents", "txt"));
				fc.addChoosableFileFilter(new FileNameExtensionFilter("Shell Script", "sh"));

				int input = fc.showOpenDialog(null);
				
				

				if (input == JFileChooser.APPROVE_OPTION) {

					File file = fc.getSelectedFile();

					try {
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);

						int i = 0;
						String in;
						ta.setText(" ");
						while (i < file.length()) {

							in = br.readLine();
							if (in != null) {
								ta.append(in + "\n");
							}
							i++;
						}
						br.close();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Something went wrong..");

					}

				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		save.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					

					int usrSelection = fc.showSaveDialog(null);

					if (usrSelection == JFileChooser.APPROVE_OPTION) {
						
						File saveFile = fc.getSelectedFile();
						
						FileWriter wr = new FileWriter(saveFile);
						BufferedWriter bw = new BufferedWriter(wr);
						
						
						
						wr.write(ta.getText());
						bw.close();

					}
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Something went wrong..");


				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

}
