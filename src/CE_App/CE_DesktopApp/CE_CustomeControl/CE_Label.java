package CE_App.CE_DesktopApp.CE_CustomeControl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import CE_Infrastructure.CEAppStyle;


public class CE_Label extends JLabel{
    public CE_Label(){
        customizeComponent();
    }
    public CE_Label(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), CEAppStyle.FONT, CEAppStyle.COLOR_FONT_LIGHT, CEAppStyle.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
        //setIcon(new ImageIcon(iconPath));
    }
}