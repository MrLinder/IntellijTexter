import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import javax.swing.JScrollPane;

public class ViewPanel extends JFrame{

	private static final long serialVersionUID = 1L;
	private final Font Bold = new Font("Arial", Font.BOLD, 16);
	private final Font Midl = new Font("Arial", Font.BOLD, 14);
	private final Font Plan = new Font("Tahoma", Font.PLAIN, 15);
	
	private JLabel labelSource = new JLabel("Choose source file");
	private JLabel labelResult = new JLabel("Choose result file");
	
	private JTextField Sourcefield = new JTextField("Default Folder: " + Main.defaultFolder);
	private JTextField Resultfield = new JTextField("Default Folder: " + Main.defaultFolder);
	
	private String SourcePath = null;
	private String ResultPath = null;
	
	private JButton btnSourse = new JButton("Source file");
	private JButton btnResult = new JButton("Result file");
	private JButton btnAnalize = new JButton("Start Analize");
	private JButton btnSave = new JButton("Add data and Save file");
	
	private JFileChooser ChooseSource = new JFileChooser(Main.defaultFolder);
	private JFileChooser ChooseResult = new JFileChooser(Main.defaultFolder);
		
	private JTextArea area_one = new JTextArea(100,20);
	public static JTextArea area_two = new JTextArea(100,20);
	public static JTextArea area_sys = new JTextArea(0,40);
		
	public static StringBuilder SourceData = new StringBuilder("null");
	public static StringBuilder ResultsData = new StringBuilder();

	public int i;
	
	public ViewPanel(String str) {
		super(str);
		
		btnResult.setEnabled(false);
		
	Box mainbox = Box.createHorizontalBox();
	
		Box leftbox = Box.createVerticalBox();
			Box leftTopbox = Box.createHorizontalBox();
			Box leftMiddlebox = Box.createHorizontalBox();
			Box leftBottombox = Box.createHorizontalBox();
	
		Box rightbox = Box.createVerticalBox();
			Box rightTopbox = Box.createHorizontalBox();
			Box rightMiddlebox = Box.createHorizontalBox();
			Box rightBottombox = Box.createHorizontalBox();
		
		Box sysbox = Box.createVerticalBox();
			Box sysTopBox = Box.createHorizontalBox();
			Box sysMiddlebox = Box.createHorizontalBox();
						
		btnSourse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SourcePath = new Choosefile("Choose source file", ChooseSource, btnSourse, Sourcefield).getDir();
				SourceData = new StringBuilder(new ParserDics(area_one, SourcePath).getData());	
				
				btnResult.setEnabled(true);
				area_one.setVisible(true);
			}
		});	
		
		btnResult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultPath = new Choosefile("Choose Result file", ChooseResult, btnResult, Resultfield).getDir();				
							
				if(SourcePath != null)
				{
					char[] a = SourcePath.toCharArray();
					char[] b = ResultPath.toCharArray();

					for(int i = 0; i < a. length; i++ )
					{
						if(a[i] != b[i])
						{
							ResultsData = new StringBuilder(new ParserDics(area_two, ResultPath).getData());
							area_two.setVisible(true);
							break;
						}
					}
				}
			}
		});
		
		
		btnAnalize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Analyzing();
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SaveToFile(ResultsData, ResultPath);			
			}
		});
		
		
		area_one.setFont(Plan);
		area_one.setText("There will be source file");
		area_one.setVisible(false);
		
		area_two.setFont(Plan);
		area_two.setVisible(false);
		
		area_sys.setCaretPosition(area_sys.getDocument().getLength());
		area_sys.setFont(Plan);
		area_sys.setEditable(false);
		area_sys.setForeground(Color.BLACK);

		leftTopbox.add(labelSource).setFont(Bold);
		leftMiddlebox.add(btnSourse).setFont(Bold);
		leftMiddlebox.add(Sourcefield).setFont(Midl);
		leftMiddlebox.add(Box.createHorizontalGlue());
		leftBottombox.add(new JScrollPane(area_one));
		
			leftbox.add(leftTopbox);
			leftbox.add(leftMiddlebox);
			leftbox.add(leftBottombox);
			leftbox.setBorder(new LineBorder(Color.BLACK));
			leftbox.add(btnAnalize).setFont(Bold);
			
		rightTopbox.add(labelResult).setFont(Bold);;
		rightMiddlebox.add(btnResult).setFont(Bold);
		rightMiddlebox.add(Resultfield).setFont(Midl);
		rightBottombox.add(new JScrollPane(area_two));
		
			rightbox.add(rightTopbox);
			rightbox.add(rightMiddlebox);
			rightbox.add(rightBottombox);
			rightbox.add(btnSave).setFont(Bold);
			rightbox.setBorder(new LineBorder(Color.BLACK));
						
		sysTopBox.add(new JLabel("Report")).setFont(Bold);
			
		JScrollPane scrollpane = new JScrollPane(area_sys);
					scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sysMiddlebox.add(scrollpane);	
			
			sysbox.add(sysTopBox);
			sysbox.add(sysMiddlebox);
		
		mainbox.add(leftbox);
		mainbox.add(rightbox);
		mainbox.add(sysbox);
		setContentPane(mainbox);
	}

}
