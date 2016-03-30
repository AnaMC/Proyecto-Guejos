package tools;

import frames.TicTacToe;

@SuppressWarnings("unused")
public class Analisis {

    private int contadorTurno;
    private BotonMolon[][] fresisuis;

    public BotonMolon[][] getFresisuis() {
        return fresisuis;
    }

    public void setFresisuis(BotonMolon[][] fresisuis) {
        this.fresisuis = fresisuis;
    }

    public int getContadorTurno() {
        return contadorTurno;
    }

    public void setContadorTurno(int x) {
        this.contadorTurno = x;
    }

    public Analisis(TicTacToe frame) {
        this.contadorTurno = 0;
        this.fresisuis = frame.getCasillas();

    }

    public void cuentaTurnos() {
        if (contadorTurno >= 5) {

        }
    }

    public boolean doritos() { /*Doritos ▲ es el más tocho, se encarga de analizar la matriz 
          ▲
         ▲ ▲  */

        if (checkFilas() || checkColumnas() || checkDiagonal1() || checkDiagonal2() == true) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkFilas() {
        for (int i = 0; i < fresisuis.length; i++) {
            if (compararCodigos(fresisuis[i][0].getDescripcion(),
                    fresisuis[i][1].getDescripcion(), fresisuis[i][2].getDescripcion()) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnas() {
        for (int i = 0; i < fresisuis.length; i++) {
            if (compararCodigos(fresisuis[0][i].getDescripcion(),
                    fresisuis[1][i].getDescripcion(), fresisuis[2][i].getDescripcion()) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal1() {

        if (compararCodigos(fresisuis[0][0].getDescripcion(),
                fresisuis[1][1].getDescripcion(), fresisuis[2][2].getDescripcion()) == true) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkDiagonal2() {
        if (compararCodigos(fresisuis[0][2].getDescripcion(),
                fresisuis[1][1].getDescripcion(), fresisuis[2][0].getDescripcion()) == true) {
            return true;
        } else {
            return false;
        }
    }

    private boolean compararCodigos(String a, String b, String c) {
        if (a.equals(b) && b.equals(c) && a.equals(c) && (!a.equals("w")) && !b.equals("w") && !c.equals("w")) {
            return true;
        } else {
            return false;
        }
    }

}
