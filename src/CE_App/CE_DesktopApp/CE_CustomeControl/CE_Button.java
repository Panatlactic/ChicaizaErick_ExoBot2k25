package CE_App.CE_DesktopApp.CE_CustomeControl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import CE_Infrastructure.CEAppStyle;

import javax.swing.ImageIcon;

public class CE_Button extends JButton implements MouseListener {
    public CE_Button(String text){
        customizeComponent(text);
    }
    public CE_Button(String text, String iconPath){
        customizeComponent(text, iconPath);
    }

    public void customizeComponent(String text, String iconPath){ 
        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 90, 20); 
        setIcon(new ImageIcon(iconPath));
        setFont(CEAppStyle.FONT);
    }
    public void customizeComponent(String text) {
        setText(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(CEAppStyle.COLOR_FONT);
        setHorizontalAlignment(CEAppStyle.ALIGNMENT_LEFT);
        setFont(CEAppStyle.FONT);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(CEAppStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(CEAppStyle.CURSOR_DEFAULT);
    }
}
