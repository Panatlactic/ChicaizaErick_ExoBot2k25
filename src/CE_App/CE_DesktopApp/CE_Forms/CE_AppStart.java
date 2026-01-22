package CE_App.CE_DesktopApp.CE_Forms;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import CE_App.CE_DesktopApp.CE_CustomeControl.CE_Button;
import CE_Infrastructure.CEAppMSG;;

public class CE_AppStart extends JFrame {
    CE_AppMenu   pnlMenu = new CE_AppMenu();
    JPanel    pnlMain = new CE_Home();

    public CE_AppStart(String tilteApp) {
        initComponents(tilteApp);
 
        CE_Button btnHome   = new CE_Button("🐜 Home");
        CE_Button btnSexo   = new CE_Button("🐜 Sexo");
        CE_Button btnHormiga= new CE_Button("🐜 Tipo de Hormiga");
        CE_Button btnTest   = new CE_Button("🐜 validar");

        btnHome   .addActionListener(e -> setPanel(new CE_Home()));
        btnSexo   .addActionListener(e -> setPanel(new CE_Sexo()));
        btnHormiga.addActionListener(e -> setPanel(new CE_Home()));
        btnTest   .addActionListener(e -> CEAppMSG.showError("mensaje de error"));

        pnlMenu.addMenuItem(btnHome   );
        pnlMenu.addMenuItem(btnSexo   );    
        pnlMenu.addMenuItem(btnHormiga);
        pnlMenu.addMenuItem(btnTest   );

    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void initComponents(String tilteApp) {
        setTitle(tilteApp);
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }
}