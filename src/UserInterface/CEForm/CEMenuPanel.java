package UserInterface.CEForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.CEStyle;

public class CEMenuPanel extends JPanel{
    
    public JButton
        btnHome = new JButton("Home"),
        btnLogin = new JButton("Login"),
        btnSexo = new JButton("Sexo"),
        btnLocalidad = new JButton("Localidad"),
        btnTest = new JButton("btnTest");

    public CEMenuPanel (){
        ceCustomizeComponent();
    }

    private void ceCustomizeComponent(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight()));
        setBackground(Color.WHITE);

        try {
            Image logo = ImageIO.read(CEStyle.URL_LOGO);
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(btnHome);
        add(btnLogin);
        add(btnSexo);
        add(btnLocalidad);
        add(btnTest);
    }


}
