import javax.swing.JFrame;
public class calendarRunner{
    public static void main(String[]args){

        JFrame app = new calendarGUI();
        app.setTitle("BLUEJOB SPA");
        app.setSize(1920, 1080);
        app.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //app.setUndecorated(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}