/*
 * Secured_Notes.java
 */

package desktopapplication1;

import java.awt.Graphics;
import java.awt.Image;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class Secured_Notes extends FrameView {

    public Secured_Notes(SingleFrameApplication app) {

        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        
        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    }
            }
        });
    }



    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = DesktopApplication1.getApplication().getMainFrame();
            aboutBox = new DesktopApplication1AboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
       mainFrame.setResizable(false);
        }
        DesktopApplication1.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jSeparator1 = new javax.swing.JSeparator();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(desktopapplication1.DesktopApplication1.class).getContext().getResourceMap(Secured_Notes.class);
        mainPanel.setBackground(resourceMap.getColor("mainPanel.background")); // NOI18N
        mainPanel.setMaximumSize(new java.awt.Dimension(350, 250));
        mainPanel.setMinimumSize(new java.awt.Dimension(300, 200));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(450, 300));
        mainPanel.setLayout(null);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(desktopapplication1.DesktopApplication1.class).getContext().getActionMap(Secured_Notes.class, this);
        jButton1.setAction(actionMap.get("click")); // NOI18N
        jButton1.setBackground(resourceMap.getColor("jButton1.background")); // NOI18N
        jButton1.setForeground(resourceMap.getColor("jButton1.foreground")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setSelectedIcon(resourceMap.getIcon("jButton1.selectedIcon")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        try {
            Image img = ImageIO.read(getClass().getResource("resources/sa.jpg"));
            jButton1.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        mainPanel.add(jButton1);
        jButton1.setBounds(12, 261, 108, 27);

        jButton2.setAction(actionMap.get("reset")); // NOI18N
        jButton2.setBackground(resourceMap.getColor("jButton2.background")); // NOI18N
        jButton2.setForeground(resourceMap.getColor("jButton2.foreground")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setSelectedIcon(resourceMap.getIcon("jButton2.selectedIcon")); // NOI18N
        try {
            Image img = ImageIO.read(getClass().getResource("resources/re.jpg"));
            jButton2.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        mainPanel.add(jButton2);
        jButton2.setBounds(207, 260, 109, 29);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setBackground(resourceMap.getColor("jTextArea1.background")); // NOI18N
        jTextArea1.setColumns(5);
        jTextArea1.setFont(resourceMap.getFont("jTextArea1.font")); // NOI18N
        jTextArea1.setForeground(resourceMap.getColor("jTextArea1.foreground")); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextArea1.setName("jTextArea1"); // NOI18N
        jTextArea1.setPreferredSize(new java.awt.Dimension(200, 150));
        jScrollPane1.setViewportView(jTextArea1);

        mainPanel.add(jScrollPane1);
        jScrollPane1.setBounds(112, 13, 380, 220);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTextArea2.setBackground(resourceMap.getColor("jTextArea2.background")); // NOI18N
        jTextArea2.setColumns(10);
        jTextArea2.setRows(3);
        jTextArea2.setAlignmentY(0.1F);
        jTextArea2.setName("jTextArea2"); // NOI18N
        jScrollPane2.setViewportView(jTextArea2);

        mainPanel.add(jScrollPane2);
        jScrollPane2.setBounds(10, 38, 86, 60);

        jLabel2.setIcon(resourceMap.getIcon("jLabel2.icon")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        mainPanel.add(jLabel2);
        jLabel2.setBounds(10, 6, 90, 30);

        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        mainPanel.add(jLabel1);
        jLabel1.setBounds(0, -50, 760, 570);

        menuBar.setName("menuBar"); // NOI18N

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setForeground(resourceMap.getColor("aboutMenuItem.foreground")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        jDialog1.setName("jDialog1"); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jSeparator1.setName("jSeparator1"); // NOI18N

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
char os[] = new char[1000];
int ns[] = new int[1000];
int count = 0;
    @Action

    public void click() {

if(jTextArea1.getText().equals(""))
{

    JOptionPane.showMessageDialog(null, "Enter Text In Box", "Secure Note", JOptionPane.INFORMATION_MESSAGE);



}
        else if(jTextArea2.getText().equals(""))
{

    JOptionPane.showMessageDialog(null, "Enter Title In Box", "Secure Note", JOptionPane.INFORMATION_MESSAGE);



}

    else
 {
    
    try {
String m = jTextArea2.getText() + ".txt";
File file = new File("C:/securednotes/" +m);

    BufferedWriter fileOut = new BufferedWriter(new FileWriter(file));
    String myString1 =jTextArea1.getText();
    String myString2 = myString1.replace("\r", "\n");
    os = myString2.toCharArray();
                for(int i =0 ; i< os.length;i++){
ns[i] = os[i] ;

     //System.out.print(ns[i]);
fileOut.write(Integer.toString(ns[i]));
                }

     fileOut.close();



 jTextArea1.setText("");
 jTextArea2.setText("");



    
    } catch (IOException ioe) {
    System.out.print("error");
}

    JOptionPane.showMessageDialog(null, "Note Saved", "Secure Note", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Action
    public void reset() {
jTextArea1.setText(" ");
jTextArea2.setText(" ");
    }

    @Action
    public void newnote() {



    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
