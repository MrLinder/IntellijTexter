import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Actions implements ActionListener{
	public static JLabel label;
	
	public Actions(JLabel label) {
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "test", "testwindow", JOptionPane.CANCEL_OPTION);
		label.setText("test111");
	}
	
	/*public static String getlabel() {
		return label.getText();
	}*/

}
