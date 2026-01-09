package UserInterface.CEForm;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UserInterface.CEStyle;

public class CEMainForm extends JFrame {
    private CEMenuPanel cePnlMenu = new CEMenuPanel();
    private JPanel cePnlMain = new JPanel();

    public CEMainForm (String titleApp) {
        ceCustomizeComponent(titleApp);
        ceSetPanel(new CEMainPanel());

        cePnlMenu.btnHome.addActionListener(e -> ceSetPanel(new CEMainPanel()));
        cePnlMenu.btnLogin.addActionListener(e -> ceSetPanel(new JPanel()));
        cePnlMenu.btnSexo.addActionListener(e -> ceSetPanel(new JPanel()));
        cePnlMenu.btnLocalidad.addActionListener(e -> ceSetPanel(new JPanel()));

        cePnlMenu.btnTest.addActionListener(e -> CEStyle.ceShowMsgError("Panel en construcción"));

    }

    private void ceSetPanel (JPanel ceFormularioPanel){
        Container container = getContentPane();
        container.remove(cePnlMain);
        cePnlMain = ceFormularioPanel;
        container.add(cePnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void ceCustomizeComponent (String titleApp) {
        setTitle(titleApp);
        setSize(930, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(cePnlMenu, BorderLayout.WEST);
        container.add(cePnlMain, BorderLayout.CENTER);
        setVisible(true);
    }
}
