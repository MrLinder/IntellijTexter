import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class ParserDics {

	private File file = null;
	private FileReader reader = null;
	private int CountStrings = 0;
	private StringBuilder Data;
	
	public ParserDics(JTextArea area,  String src) {
		
		int ch;
		Data = new StringBuilder();
		try{
			file = new File(src);
			reader = new FileReader(file);
				
						//Data.append(Integer.toString(CountStrings) + "\t");
				
				while((ch = reader.read()) != -1)
				{
					Data.append((char)ch);
					if(ch == '\n')
					{
						CountStrings++;
						//Data.append(Integer.toString(CountStrings) + "\t");
						
					}
						
				}
				if( (!Data.toString().trim().isEmpty()) && (char)ch != '\n')
					Data.append('\n');
										
				
			area.setText("");
			area.append(Data.toString());
			
			
			ViewPanel.area_sys.append("\n--------------------\n");
			ViewPanel.area_sys.append("Open file: " + src);
			ViewPanel.area_sys.append("\nStrings: " + Integer.toString(CountStrings));
			ViewPanel.area_sys.append("\nSymbols: " + Data.length() + '\n');
						
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
			
	}
	
	public String getData() {
			return Data.toString(); 
	}
		
	
}
