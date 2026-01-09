package UserInterface.CEForm;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.CEStyle;

public class CEMainPanel extends JPanel {
    
    public CEMainPanel (){
        setLayout(new BorderLayout());
        JLabel lblImagen = new JLabel(new ImageIcon(CEStyle.class.getResource("/UserInterface/Resource/Img/Main.png")));
        add(lblImagen, BorderLayout.CENTER);
    }

}
