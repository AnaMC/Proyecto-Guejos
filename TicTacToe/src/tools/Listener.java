package tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import frames.TicTacToe;
import juegos.Juego;
import juegos.Jugador;

/*Implementar ActionListener en otra clase*/
public class Listener implements ActionListener {

    private TicTacToe frame;

    public Listener(TicTacToe frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        BotonMolon clickado = (BotonMolon) e.getSource();

        /*El clic del boton actualiza el codigo (descripcion) del boton haciendolo coincidir con el codigo(descripcion)
         del imageIcon del jugador que tiene el turno, de modo que al compararlos si los codigos (descripciones) no 
         coinciden est� libre, con esto conseguimos que no se pueda hacer clic dos veces sobre el mismo boton.*/
        if (Juego.turnoActual(this.frame.getJuego(), this.frame) && checkOcupado(clickado) == false) {

            cambiarTurno(frame.getJuego().getJ1(), frame.getJuego().getJ2(), clickado);

            winrar();

        } else if (checkOcupado(clickado) == false) {

            cambiarTurno(frame.getJuego().getJ2(), frame.getJuego().getJ1(), clickado);

            winrar();

        }
    }

    public boolean checkOcupado(BotonMolon clickado) {
        String iconoClickado = clickado.getDescripcion();
        String iconoJ1 = Jugador.getDescripcion(this.frame.getJuego().getJ1());
        String iconoJ2 = Jugador.getDescripcion(this.frame.getJuego().getJ2());

        if (iconoClickado.equals(iconoJ1) || iconoClickado.equals(iconoJ2)) {
            return true;
        } else {
            return false;
        }

    }

    private void cambiarTurno(Jugador jPrimario, Jugador jSecundario, BotonMolon clickado) {

        clickado.setIcon(jPrimario.getAvatar());
        clickado.setDescripcion(jPrimario.getAvatar().getDescription());
        ImageIcon ficha = jSecundario.getAvatar();
        frame.setLblIcono(ficha);
        int turno = (frame.getJuego().getAguacate().getContadorTurno()) + 1;
        frame.getJuego().getAguacate().setContadorTurno(turno);
        frame.getLblTurno().setText("Turno " + String.valueOf(turno)); //ValueOf xq turno es un entero y el argumento de setText solo admite cadenas.

    }

    //    C|:{) 
    public void winrar() {

        Analisis ana = frame.getJuego().getAguacate();
        if (ana.doritos() == true) {
            frame.getLblTurno().setText("Winrar");
            burrito();
            frame.setLblIcono(null);

        }

    }

    private void burrito() {
        BotonMolon[][] casillas = frame.getCasillas();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                casillas[i][j].setEnabled(false);

            }
        }
    }


    /*private boolean checkClickado(BotonMolon click){
     BotonMolon[][] casillas = frame.getCasillas();
     BotonMolon clickado = new BotonMolon();
     for (int i = 0; i < casillas.length; i++){
     for (int j = 0; j < casillas[0].length; j++){
     if (casillas[i][j] == clickado){
     return true;
     }
     }
     }
     return false;
     }*/
}
