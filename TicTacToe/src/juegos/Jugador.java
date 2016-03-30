package juegos;

import javax.swing.ImageIcon;

public class Jugador {

	String nombre;
	int ganadas, perdidas;
	ImageIcon avatar;
	
	public Jugador(String nombre, String avatar, String desc){
		this.nombre = nombre;
		ganadas = 0;
		perdidas = 0;
		this.avatar = new ImageIcon(avatar, desc);
	}
	
	public ImageIcon getAvatar(){
		return avatar;
	}
	
	public void setAvatar(ImageIcon avatar){
		this.avatar= avatar;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGanadas() {
		return ganadas;
	}

	public void setGanadas(int ganadas) {
		this.ganadas = ganadas;
	}

	public int getPerdidas() {
		return perdidas;
	}

	public void setPerdidas(int perdidas) {
		this.perdidas = perdidas;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", ganadas=" + ganadas + ", perdidas=" + perdidas + "]";
	}
	
        /*Descripcion del avatar*/
	public static String getDescripcion(Jugador J){
		return J.getAvatar().getDescription();		
	}
	
}
