package co.com.inversionesxyz.dto;


public class Producto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private Sucursal sucursal;
	private String nombre;
	private String tipo;
	private float valor;

	public String getCodigo() {
		return this.codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Sucursal getSucursal() {
		return this.sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValor() {
		return this.valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
