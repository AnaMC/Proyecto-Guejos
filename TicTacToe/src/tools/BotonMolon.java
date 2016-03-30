package tools;

import javax.swing.JButton;

@SuppressWarnings("serial")
/*JButton customizado*/
public class BotonMolon extends JButton {

	private String descripcion;
        private int codigo;
	
	public BotonMolon(String descripcion, int cod){ /* C|:{) */
		super();
		this.descripcion = descripcion;
		this.codigo = cod;
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion(){
		return descripcion;
	
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
		
	}
}
