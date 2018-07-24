import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Choosefile
{
	public String dir = null;
	
	public Choosefile(String title, JFileChooser choose, JButton button, JTextField field) {
		choose.setDialogTitle(title);
		choose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int choice = choose.showOpenDialog(button);
			
		
			if(choice == JFileChooser.APPROVE_OPTION)
			{
				File file = choose.getSelectedFile();
							
				this.dir = new String(file.getAbsolutePath());
				button.setText(file.getName() + " (" + file.length() + " b) ");
				field.setText(file.getParent() + '\\' + '\n');
				field.setEditable(false);
			}
			if(choice == JFileChooser.CANCEL_OPTION)
			{
				JOptionPane.showMessageDialog(null, "chose", "chois", JOptionPane.ERROR_MESSAGE);
				this.dir = Main.defaultFolder;
			}
	}
	
	
	public String getDir(){
		return this.dir;
	}
}