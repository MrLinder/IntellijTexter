
public class Analyzing {

		DataStack Data = null;
		ResultData Result = null;
		
		public Analyzing()
		{
			Data = new DataStack(ViewPanel.SourceData);
			Result = new ResultData(ViewPanel.ResultsData);
	
			String d = new String();
			do {
					if(d != null){
						d = Data.popSubString();
						if(d == null)
							break;
					}
											
					// TODO Доделать сортировку двух списков строк.
					
					// ---------проход посимвольно
					String a = new String();
						int i = 0;
					do			//по подслову проходит индекксом 
					{
						//тут строго проходит слово посимвольно
						
						a += d.charAt(i);
						
						System.out.println(a);
					
						
					}while(++i < d.indexOf('='));			//по подслову проходит индекксом
					System.out.println();
					//---------------------------
					
					
			} while (d != null );		// 1 итерация выкидывает 1 строку референсарирррро
        }
		

		
		
		
}


/*
 import javax.swing.JTextArea;

public class Analyzing {

		DataStack Data = null;
		String Result = null;
		
		public Analyzing()
		{
			Data = new DataStack(ViewPanel.SourceData);
			
			if(ViewPanel.ResultsData.length() == 0)
				Result = new String();
			else
				Result = ViewPanel.ResultsData.toString();
			
			
			String currentString = new String();
	        String currentWord = new String();
	        String currentMeaning = new String();
	        
            do{
                if((currentString = Data.popSubString()) != null)
                {
                    currentWord = currentString.substring(0, currentString.indexOf('='));
                    currentMeaning = currentString.substring(currentString.indexOf('=')+1, currentString.indexOf('\n'));

                    
                    if( Result.trim().length() == 0 )
                    {
                    	
                    	Result += currentString;
                    	ViewPanel.area_two.append(Result);
                    	ViewPanel.area_sys.append(Result);
                    }
                    else
                    {
                    	int ch=0;
                    	boolean insertCorret = false;
                    	
                    	do{
                    		String currentResultStr = new String();
                    		String currenResultWord = new String();
                	        String currenResultMeaning = new String();                 		
                    		do{
                    			currentResultStr += Result.charAt(ch++);
							}while (Result.charAt(ch) != '\n');
                    		
                    		currenResultWord = currentResultStr.substring(0, currentResultStr.indexOf('='));
                    		currenResultMeaning = currentResultStr.substring(currentResultStr.indexOf('='));
                    		                    		
                    		int compare = currentWord.compareTo(currenResultWord);
                    		
                    		if(compare == 0)
                    		{
                    			ViewPanel.area_two.append("-> del\t" +currentWord + " = " + currenResultWord + '\n');
                    		}
                    		if(compare > 0)
                    		{
                    			System.out.println(currentWord + " > " + currenResultWord + "\t" + compare);
                    		}
                    		
                    		
                    		
                       	}while(ch++ != Result.lastIndexOf('\n') );
                    }
                }
            }while(currentString != null);
			
            ViewPanel.ResultsData.append(Result);
         }
		
		
}


 * */
