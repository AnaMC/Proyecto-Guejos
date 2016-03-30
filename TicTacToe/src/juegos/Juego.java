package juegos;


import frames.TicTacToe;
import tools.Analisis;

@SuppressWarnings("unused")
public class Juego{
	
	private Jugador j1, j2;
	private TicTacToe frame; 
	private Analisis aguacate; /*Analizador del juego*/
	
	public Juego(TicTacToe frame){
		this.frame = frame;
		this.aguacate = new Analisis(frame);
		juegoInicial();
	}
	public Juego(Jugador j1, Jugador j2){
		this.j1 = j1;
		this.j2 = j2;
		this.aguacate = new Analisis(this.getFrame());
	}
	
	/*Sho soy su gatita... :3*/
	
	public Juego(Jugador j1, Jugador j2, TicTacToe frame){
		this.j1 = j1;
		this.j2 = j2;
		this.aguacate = new Analisis(frame);
		this.frame = frame;
	}

	public Jugador getJ1() {
		return j1;
	}

	public void setJ1(Jugador j1) {
		this.j1 = j1;
	}

	public Jugador getJ2() {
		return j2;
	}

	public void setJ2(Jugador j2) {
		this.j2 = j2;
	}
	
	public TicTacToe getFrame() {
		return frame;
	}
	public void setFrame(TicTacToe frame) {
		this.frame = frame;
	}

	public Analisis getAguacate(){
		return aguacate;
	}
	
	public void setAguacate(Analisis aguacate){
		this.aguacate = aguacate;
	}
	
	public void juegoInicial(){
		Jugador invitadoX = new Jugador("Invitado","Img\\cross.png", "x");
		Jugador invitadoO = new Jugador("Invitado","Img\\circle.png", "o");
		this.setJ1(invitadoX);
		this.setJ2(invitadoO);
		
		
		frame.setLblJugador1(this.getJ1().getNombre());
		frame.setLblJugador2(this.getJ2().getNombre());
		
		frame.setLblIcono(this.getJ1().getAvatar());
	}
	
	public static boolean turnoActual(Juego juego,TicTacToe frame){
		String turno = frame.getLblIcono().getDescription();
		String iconoX = juego.getJ1().getAvatar().getDescription();
		
		if (turno.equals(iconoX)){
			return true;
		}else{
			return false;		
		}
	}
}
