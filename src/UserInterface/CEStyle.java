package UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class CEStyle {
    public static final Color COLOR_FONT = new Color(200, 100, 50);
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color COLOR_CURSOR = Color.black;
    public static final Color COLOR_BORDER = Color.lightGray;
    public static final Font FONT = new Font ("JetBrains Mono", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font ("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
    public static final Font FONT_SMALL = new Font ("JetBrains Mono", Font.PLAIN | Font.PLAIN, 10);

    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_SPLASH = CEStyle.class.getResource("/UserInterface/Resource/Img/Splah.jpg");
    public static final URL URL_LOGO = CEStyle.class.getResource("/UserInterface/Resource/Img/Icon.png");
    public static final URL URL_MAIN = CEStyle.class.getResource("/UserInterface/Resource/Img/Main.png");

    public static final CompoundBorder ceCreateBorderRect (){
        return BorderFactory.createCompoundBorder(new LineBorder(Color.lightGray), new EmptyBorder(5, 5, 5, 5));
    }

    // Para mensajes con info
    public static final void ceShowMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "CEBot", JOptionPane.INFORMATION_MESSAGE);
    }

    // Para errores
    public static final void ceShowMsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "CEBot - ERROR", JOptionPane.ERROR_MESSAGE);
    }

}
