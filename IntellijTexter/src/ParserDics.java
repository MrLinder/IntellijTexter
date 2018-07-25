import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream; 
import java.io.Reader;
import java.util.Arrays;

import javax.swing.JTextArea;

public class ParserDics {

	private File file = null;
	private FileReader reader = null;
	private int CountStrings = 0;
	
	public ParserDics(JTextArea area,  String src, StringBuffer buffer) {
		
		int ch;
		buffer = new StringBuffer();
		try{
			file = new File(src);
			reader = new FileReader(file);
				while((ch = reader.read()) != -1)
				{
					buffer.append((char)ch);
					if(ch == '\n')
						CountStrings++;
				}
			
			area.setText("");
			area.append(buffer.toString());
			
			ViewPanel.area_sys.append("\n--------------------\n");
			ViewPanel.area_sys.append("Open file: " + src);
			ViewPanel.area_sys.append("\nStrings: " + Integer.toString(CountStrings));
			ViewPanel.area_sys.append("\nSymbols: " + buffer.length());
						
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		
	
		
		
			
		
		
	}

	
}
