package CE_App.CE_DesktopApp.CE_CustomeControl;

import javax.swing.ImageIcon;

import CE_Infrastructure.CEAppStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CE_LabelLink extends CE_Label implements MouseListener {

    CE_LabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    CE_LabelLink(String text, String iconPath){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(CEAppStyle.COLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // code
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // code
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // code
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(CEAppStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(CEAppStyle.CURSOR_DEFAULT);
    }
}
