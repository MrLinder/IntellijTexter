
public class DataStack {

	int idx;
	String data;
	
	
	public DataStack(StringBuilder data) {
		this.data = data.toString();
	}
	
	public String popSubString()
	{
		String s = new String();
		
		try {
			do {
				s += this.data.charAt(idx);
			} while (this.data.charAt(idx++) != '\n');
		} catch (Exception e) {
			return null;
		}
		return s;
	}

}
