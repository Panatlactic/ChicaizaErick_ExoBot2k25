package CE_App.CE_DesktopApp.CE_Forms;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import CE_Infrastructure.CEAppConfig;
import CE_Infrastructure.CEAppException;
import CE_Infrastructure.CEAppMSG;

public class CE_Home extends JPanel {

    private ImageIcon originalIcon;

    public CE_Home() {
        originalIcon = new ImageIcon(CEAppConfig.getImgMain());
        setLayout(new BorderLayout());

        // Escalado dinámico cuando el componente se redimensiona
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateImage();
            }
        });
    }

    private void updateImage() {
        try {
            int width = getWidth();
            int height = getHeight();

            if (width > 0 && height > 0) {
                Image originalImage = originalIcon.getImage();
                Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                removeAll(); // Limpiar contenido anterior
                JLabel imageLabel = new JLabel(scaledIcon);
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                imageLabel.setVerticalAlignment(SwingConstants.CENTER);
                add(imageLabel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        } catch (Exception e) {
            CEAppException er = new CEAppException("Ups..! Error en la imagen de inicio", e, getClass(), "initComponents()");
            CEAppMSG.showError(er.getMessage());
        }
    }
}
