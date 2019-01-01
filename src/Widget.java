import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class Widget {

	public static void main(String[] args) throws Exception {
		
		File f = new File("./Proverbs/ZenProverbs");
		System.out.println(f.getAbsolutePath());
		BufferedReader br = new BufferedReader(new FileReader(f));
		while(br.readLine() != null) {
			widgetCall(br.readLine());
		}
	}
	
	public static void widgetCall(String arg0) throws Exception {
		JWindow w = new JWindow(); 
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - w.getWidth();
        w.setLocation(x,0);
        w.setOpacity(0.3f);
		JTextField tf=new JTextField();
	    tf.setText(arg0);
	    tf.setFont(new Font("Courier New", Font.ITALIC, 12));
	    tf.setForeground(Color.blue);
        w.add(tf);
        w.pack();
        w.setVisible(true); 
		Thread.sleep(10000);
		w.dispose();
	}
}
