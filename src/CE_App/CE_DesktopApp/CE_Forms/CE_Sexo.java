package CE_App.CE_DesktopApp.CE_Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import CE_App.CE_DesktopApp.CE_CustomeControl.CE_Button;
import CE_App.CE_DesktopApp.CE_CustomeControl.*;
import CE_Bussiness.CE_Factory;
import CE_DataAccess.CE_DAO.CESexoDAO;
import CE_DataAccess.CE_DTO.CESexoDTO;
import CE_Infrastructure.CEAppMSG;
import CE_Infrastructure.CEAppStyle;
import CE_Infrastructure.CETools.CE_CMD;

public class CE_Sexo extends JPanel implements ActionListener {
    private transient CE_Factory<CESexoDTO> blFactory = new CE_Factory<>(CESexoDAO.class);
    private transient CESexoDTO dtoSexo = new CESexoDTO();
    private Integer regAct  = 0;
    private Integer regMax  = 0;

    public CE_Sexo(){
        try {
            initComponents();
                    
            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);

            btnNuevo.addActionListener(     e -> btnNuevoClick      ());
            btnGuardar.addActionListener(   e -> btnGuardarClick    ());
            btnEliminar.addActionListener(  e -> btnEliminarClick   ());
            btnCancelar.addActionListener(  e -> btnCancelarClick   ());

            loadRowData();
            showRowData();
            showDataTable();
        }   catch (Exception e) {
            CEAppMSG.show("Error al cargar los datos tipo de persona: " + e.getMessage());
        }
    }
    
    private void loadRowData() throws Exception {
        regMax   = blFactory.getMaxReg();
        dtoSexo  = blFactory.getBy(regAct);
    }
    private void showRowData() {
        boolean isDTONull = (dtoSexo == null || dtoSexo.getCEIdCatalogoTipo() == null);
        txtIdSexo.setText   ((isDTONull) ? " " : dtoSexo.getCEIdCatalogoTipo().toString());
        txtNombre.setText   ((isDTONull) ? " " : dtoSexo.getCENombre());
        lblTotalReg.setText (regAct.toString() + " de " + regMax);
    }
    private void showDataTable() throws Exception {
        String[] header = {"IdPT", "Tipo", "Estado"};
        Object[][] data = new Object[regMax][3];
        int index = 0;
        for (CESexoDTO  d : blFactory.getAll()) {
            data[index][0] = d.getCEIdCatalogoTipo();
            data[index][1] = d.getCENombre();
            data[index][2] = d.getCEEstado();
            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setRowSelectionAllowed(true);
        table.setGridColor(Color.lightGray);
        table.setColumnSelectionAllowed(false);
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.setLayout(new BorderLayout()); 
        pnlTabla.add(new JScrollPane(table), BorderLayout.CENTER);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strID = table.getModel().getValueAt(row, 0).toString();
                    regAct = Integer.parseInt(strID);
                    try {
                        dtoSexo = blFactory.getBy(regAct);
                        showRowData();
                    } catch (Exception _) { 
                        System.out.println("");
                    }
                    System.out.println("Tabla.Selected: " + strID);
                }
            }
        });
    }

    private void btnNuevoClick() {
        dtoSexo = null;
        showRowData();
    }
    private void btnGuardarClick() {
        boolean isDTONull = (dtoSexo == null );
        try {
            if (CEAppMSG.showConfirmYesNo("¿Seguro que desea " + ((isDTONull) ? "AGREGAR ?" : "ACTUALIZAR ?"))) {
                if (isDTONull)  
                    dtoSexo = new CESexoDTO(txtNombre.getText().trim(),"");
                else
                    dtoSexo.setCENombre(txtNombre.getText());

                if( !((isDTONull)   ? blFactory.add(dtoSexo) 
                                    : blFactory.upd(dtoSexo))) 
                    throw new Exception("Error al almacenar el registo...");
                
                loadRowData();
                showRowData();
                showDataTable();
            }
        } catch (Exception e) {
            CEAppMSG.showError( e.getMessage());
        }
    }
    private void btnEliminarClick() {
        try {
            if (CEAppMSG.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!blFactory.del(dtoSexo.getCEIdCatalogoTipo()))
                    throw new Exception("Error al eliminar...!");
    
                loadRowData();
                showRowData();
                showDataTable();
            }
        } catch (Exception e) {
            CEAppMSG.showError(e.getMessage());
        }
    }
    private void btnCancelarClick() {
        try {
            if(dtoSexo == null)
                loadRowData();
            showRowData();
        } catch (Exception ex) { CE_CMD.printlnError(ex.toString());}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            regAct = 1;
        if (e.getSource() == btnRowAnt && (regAct > 1))
            regAct--;
        if (e.getSource() == btnRowSig && (regAct < regMax))
            regAct++;
        if (e.getSource() == btnRowFin)
            regAct = regMax;
        try {
            dtoSexo  = blFactory.getBy(regAct);
            showRowData(); 
        } catch (Exception ex) { CE_CMD.printlnError(ex.toString());}
    }
  

    /************************
    * FormDesing : pat_mic
    ************************/
    int tbAncho = 550, tbAlto = 150;  // tabla de datos
    private CE_Label 
            lblTitulo   = new CE_Label("TIPO DE SEXO"),
            lblIdSexo   = new CE_Label(" Código Sexo :"),
            lblNombre   = new CE_Label("*Tipo de Sexo:"),
            lblTotalReg = new CE_Label(" 0 de 0 ");
    private CE_TextBox 
            txtIdSexo   = new CE_TextBox(),
            txtNombre   = new CE_TextBox();
    private CE_Button 
            btnPageIni  = new CE_Button(" |< "),
            btnPageAnt  = new CE_Button(" << "),
            btnPageSig  = new CE_Button(" >> "),
            btnPageFin  = new CE_Button(" >| "),

            btnRowIni   = new CE_Button(" |< "),
            btnRowAnt   = new CE_Button(" << "),
            btnRowSig   = new CE_Button(" >> "),
            btnRowFin   = new CE_Button(" >| "),

            btnNuevo    = new CE_Button("Nuevo"),
            btnGuardar  = new CE_Button("Guardar"),
            btnCancelar = new CE_Button("Cancelar"),
            btnEliminar = new CE_Button("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());
    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdSexo.setEnabled(false);

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new CE_Label(" Page:( "));
        //pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new CE_Label(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(CEAppStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = tbAlto;
        gbc.ipadx = tbAncho;
        pnlTabla.add(new JLabel("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajusta el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdSexo, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdSexo, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtNombre, gbc);

        // gbc.gridy = 7;
        // gbc.gridx = 1;
        // gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(pnlBtnRow, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}

