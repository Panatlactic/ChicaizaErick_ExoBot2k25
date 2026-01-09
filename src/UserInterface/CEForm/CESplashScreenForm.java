package UserInterface.CEForm;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import UserInterface.CEStyle;

public abstract class CESplashScreenForm {

    private static JFrame ceFrmSplash;
    private static JProgressBar cePrbLoading;
    private static ImageIcon ceIcoImagen;
    private static JLabel ceLblSplash;

    public static void show () {
        ceIcoImagen = new ImageIcon(CEStyle.URL_SPLASH);
        ceLblSplash = new JLabel(ceIcoImagen);
        cePrbLoading = new JProgressBar(0, 100);

        cePrbLoading.setStringPainted(true);

        ceFrmSplash = new JFrame();
        ceFrmSplash.setUndecorated(true);
        ceFrmSplash.getContentPane().add(ceLblSplash, BorderLayout.CENTER);
        ceFrmSplash.add(cePrbLoading, BorderLayout.SOUTH);
        ceFrmSplash.setSize(ceIcoImagen.getIconWidth(), ceIcoImagen.getIconHeight());
        ceFrmSplash.setLocationRelativeTo(null);

        ceFrmSplash.setVisible(true);
        for (int i = 0; i <= 100; i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cePrbLoading.setValue(i);
        }
        ceFrmSplash.setVisible(false);
    }


}
