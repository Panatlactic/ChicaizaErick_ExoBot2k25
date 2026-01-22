package CE_DataAccess.CE_DTO;

public class CEEstadoCivilDTO {
    
    private Integer CEIdCatalogo    ;
    private Integer CEIdCatalogoTipo;
    private String  CENombre        ;
    private String  CEDescripcion   ;
    private String  CEEstado        ;
    private String  CEFechaCreacion ;
    private String  CEFechaModifica ;

    public CEEstadoCivilDTO (){}
    public CEEstadoCivilDTO(Integer idCatalogo, Integer idCatalogoTipo, String nombre, 
                    String descripcion, String estado, String fechaCreacion, String fechaModifica) {

        this.CEIdCatalogo = idCatalogo;
        this.CEIdCatalogoTipo = idCatalogoTipo;
        this.CENombre = nombre;
        this.CEDescripcion = descripcion;
        this.CEEstado = estado;
        this.CEFechaCreacion = fechaCreacion;
        this.CEFechaModifica = fechaModifica;

    }

    public Integer getCEIdCatalogo() {
        return CEIdCatalogo;
    }
    public void setCEIdCatalogo(Integer CEidCatalogo) {
        CEIdCatalogo = CEidCatalogo;
    }
    public Integer getCEIdCatalogoTipo() {
        return CEIdCatalogoTipo;
    }
    public void setCEIdCatalogoTipo(Integer idCatalogoTipo) {
        CEIdCatalogoTipo = idCatalogoTipo;
    }
    public String getCENombre() {
        return CENombre;
    }
    public void setCENombre(String nombre) {
        CENombre = nombre;
    }
    public String getCEDescripcion() {
        return CEDescripcion;
    }
    public void setCEDescripcion(String descripcion) {
        CEDescripcion = descripcion;
    }
    public String getCEEstado() {
        return CEEstado;
    }
    public void setCEEstado(String estado) {
        CEEstado = estado;
    }
    public String getCEFechaCreacion() {
        return CEFechaCreacion;
    }
    public void setCEFechaCreacion(String fechaCreacion) {
        CEFechaCreacion = fechaCreacion;
    }
    public String getCEFechaModifica() {
        return CEFechaModifica;
    }
    public void setCEFechaModifica(String fechaModifica) {
        CEFechaModifica = fechaModifica;
    }

    @Override
    public String toString(){
        return "\n" + getClass().getName()
        + "\n IdCatalogo "     + getCEIdCatalogo()
        + "\n IdCatalogoTipo " + getCEIdCatalogoTipo()
        + "\n Nombre "         + getCENombre()
        + "\n Descripcion "    + getCEDescripcion()
        + "\n Estado "         + getCEEstado()
        + "\n FechaCreacion "  + getCEFechaCreacion()
        + "\n FechaModifica "  + getCEFechaModifica();
    }

}
