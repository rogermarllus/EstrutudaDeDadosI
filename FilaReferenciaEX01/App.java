import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        new GUI();
    }
}
