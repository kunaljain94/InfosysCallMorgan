import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class Utilities extends JFrame{	
	JPanel panel;
	JButton button,pracButton,show;
	JTextField txtField1,txtField2,nam;
	JLabel label1,label2,link;
	public Utilities(){
		super("Call");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1500, 300));
		setVisible(true);
		setLayout(new BorderLayout());
		panel=new JPanel();
		
		label1=new JLabel("Enter Your Number: ");
		txtField1=new JTextField(15);
		label2=new JLabel("Enter number you want to call");
		txtField2=new JTextField(15);
		
		panel.add(label1);
		panel.add(txtField1);
		panel.add(label2);
		panel.add(txtField2);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		button=new JButton("Generate Link");
		panel.add(button);
		pracButton=new JButton("Add");
		panel.add(pracButton);
		show=new JButton("show Contact");
		nam=new JTextField(20);
		panel.add(nam);
		panel.add(show);
//		button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		show.addActionListener(new ButtonListener());
		button.addActionListener(new ButtonListener());
		pracButton.addActionListener(new ButtonListener());
		add(panel, BorderLayout.NORTH);
//		add(button, BorderLayout.CENTER);
	}
private class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button){
			link=new JLabel();
			String lin="from"+txtField1.getText()+"too"+txtField2.getText();
			link.setText(lin);
			add(link);
			link.setVisible(true);
			revalidate();
			
		}
		else if (e.getSource()==pracButton) {
			Preferences userPrefs = Preferences.userNodeForPackage(Utilities.class);
			
			try {
				String name=nam.getText();
				String phone=txtField2.getText();
				userPrefs.put(name, phone);	
			} catch (Exception e2) {
				// TODO: handle exception
				System.err.print(e2);
			}
		}
		else if(e.getSource()==show){
			Preferences userPrefs = Preferences.userNodeForPackage(Utilities.class);
			try {
				String[] keys=userPrefs.keys();
//				System.out.println(keys[0]);
				link=new JLabel();
				String lin=keys[0];
				link.setText(lin);
				add(link);
				link.setVisible(true);
				revalidate();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}
	
}
