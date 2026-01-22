package CE_App.CE_DesktopApp.CE_CustomeControl;

import javax.swing.*;

import CE_Infrastructure.CEAppStyle;

import java.awt.*;

public class CE_LabelText extends JPanel{
    private CE_Label    lblEtiqueta = new CE_Label();
    private CE_TextBox  txtContenido= new CE_TextBox();

    public CE_LabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            CEAppStyle.FONT_SMALL, 
                                            CEAppStyle.COLOR_FONT_LIGHT, 
                                            CEAppStyle.ALIGNMENT_LEFT); 
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
