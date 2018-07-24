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



public class ViewPanel extends JFrame  {
	
	private final Font Bold = new Font("Arial", Font.BOLD, 16);
	private final Font Midl = new Font("Arial", Font.BOLD, 14);
	
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
	private JTextArea area_two = new JTextArea("There will be results file ");
	
	public static StringBuffer SourceData = new StringBuffer();
	public static StringBuffer ResultsData = new StringBuffer();

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
			
		btnSourse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SourcePath = new Choosefile("Choose source file", ChooseSource, btnSourse, Sourcefield).getDir();
				
					new ParserDics(area_one, SourcePath, SourceData);
					btnResult.setEnabled(true);
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
							new ParserDics(area_two, ResultPath, ResultsData);
							break;
						}
					}
				}
			}
		});
		
		area_one.setText("There will be source file");
		area_two.setPreferredSize(area_one.getPreferredSize());	
		area_two.setName("theResulttsFile");

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
			
		mainbox.add(leftbox);
		mainbox.add(rightbox);
		setContentPane(mainbox);
	}

}
