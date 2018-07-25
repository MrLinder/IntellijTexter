import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.WindowConstants;

/* Сделать кнопки не активными при выборе файлов
 * сделать фильтр только по тхт файлам.
 * */


public class Main {
		public static String defaultFolder = "E:\\Directory";
	
		public static int UserWidth = 1024;
		public static int UserHeight = 720;
				
		public static Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		public static int ScreenHeight = ScreenSize.height;
		public static int ScreenWidth = ScreenSize.width;
				
	public static void main(String[] args) {
		ViewPanel myPanel = new ViewPanel("Main Window");
				myPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				myPanel.setSize(UserWidth, UserHeight);
				myPanel.setBounds((ScreenWidth/2)-UserWidth/2, (ScreenHeight/2)-UserHeight/2, UserWidth, UserHeight);
				myPanel.setVisible(true);
	}
	
}


/*--------------------задача-------------
 * 1.  Понять что файл файл именно файл словаря
 * синтаксис  "слово= значение \n"
 * 
 * 
 * 
 * 
 * */





