import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Call {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//JFrame frame=new JFrame("Call");
//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//frame.setSize(new Dimension(400, 300));
//frame.setVisible(true);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Utilities();
			}
		});

	}

}
