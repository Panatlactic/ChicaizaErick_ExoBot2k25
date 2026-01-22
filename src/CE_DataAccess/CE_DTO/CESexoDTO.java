package CE_DataAccess.CE_DTO;

public class CESexoDTO {

    private Integer CEIdCatalogo    ;
    private Integer CEIdCatalogoTipo;
    private String  CENombre        ;
    private String  CEDescripcion   ;
    private String  CEEstado        ;
    private String  CEFechaCreacion ;
    private String  CEFechaModifica ;

    public Integer getCEIdCatalogo() {
        return CEIdCatalogo;
    }
    public void setCEIdCatalogo(Integer cEIdCatalogo) {
        CEIdCatalogo = cEIdCatalogo;
    }
    public Integer getCEIdCatalogoTipo() {
        return CEIdCatalogoTipo;
    }
    public void setCEIdCatalogoTipo(Integer cEIdCatalogoTipo) {
        CEIdCatalogoTipo = cEIdCatalogoTipo;
    }
    public String getCENombre() {
        return CENombre;
    }
    public void setCENombre(String cENombre) {
        CENombre = cENombre;
    }
    public String getCEDescripcion() {
        return CEDescripcion;
    }
    public void setCEDescripcion(String cEDescripcion) {
        CEDescripcion = cEDescripcion;
    }
    public String getCEEstado() {
        return CEEstado;
    }
    public void setCEEstado(String cEEstado) {
        CEEstado = cEEstado;
    }
    public String getCEFechaCreacion() {
        return CEFechaCreacion;
    }
    public void setCEFechaCreacion(String cEFechaCreacion) {
        CEFechaCreacion = cEFechaCreacion;
    }
    public String getCEFechaModifica() {
        return CEFechaModifica;
    }
    public void setCEFechaModifica(String cEFechaModifica) {
        CEFechaModifica = cEFechaModifica;
    }
    public CESexoDTO (){}
    public CESexoDTO(Integer idCatalogo, Integer idCatalogoTipo, String nombre, 
                    String descripcion, String estado, String fechaCreacion, String fechaModifica) {

        this.CEIdCatalogo = idCatalogo;
        this.CEIdCatalogoTipo = idCatalogoTipo;
        this.CENombre = nombre;
        this.CEDescripcion = descripcion;
        this.CEEstado = estado;
        this.CEFechaCreacion = fechaCreacion;
        this.CEFechaModifica = fechaModifica;

    }

    public CESexoDTO(String nombre, String descripcion) {
        this.CEIdCatalogoTipo = 0;
        this.CENombre = nombre;
        this.CEDescripcion = descripcion;
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