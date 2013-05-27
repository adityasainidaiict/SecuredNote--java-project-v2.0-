/*
 * DesktopApplication1.java
 */

package desktopapplication1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import sun.net.www.content.text.plain;

/**
 * The main class of the application.
 */
public class DesktopApplication1 extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        File file = new File("C:/securednotes/config.config");
        JPasswordField pf = new JPasswordField();
        if (!file.exists()){
        
        JOptionPane.showConfirmDialog(null, pf, "Set Password(max 6 char)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    try {
 
			String content = new String(pf.getPassword());
                         BigInteger bigInt = new BigInteger(content.getBytes());

			if(content.equals("")){
                        JOptionPane.showMessageDialog(null, "Not a valid password", "Secure Note", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        }
 
			// if file doesnt exists, then create it

				file.createNewFile();
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(bigInt.toString());
			bw.close();
 
			
		} catch (IOException e) {
		}
        JOptionPane.showMessageDialog(null, "Now this password will be asked when you try to read a note", "Secure Note", JOptionPane.INFORMATION_MESSAGE);
        show(new Secured_Notes(this));}
        else{
        show(new Secured_Notes(this));}

        

        
            }


    
    
    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of DesktopApplication1
     */
    public static DesktopApplication1 getApplication() {
        return Application.getInstance(DesktopApplication1.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        File file = new File("C:\\securednotes");
	if (!file.exists()) {
		if (file.mkdir()) {
			//System.out.println("Directory is created!");
		} else {
			//System.out.println("Failed to create directory!");

                }
	}

        launch(DesktopApplication1.class, args);
    }
}
