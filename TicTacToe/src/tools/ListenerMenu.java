package tools;

import frames.TicTacToe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerMenu implements ActionListener{
    
    private TicTacToe frame;
       
    public ListenerMenu(TicTacToe frame){     
        this.frame = frame;   
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e) {
       
       if (e.getSource() == frame.getMntmSalir()){
           System.exit(0);
       }
       if (e.getSource() == frame.getMntmNuevo()){
           TicTacToe nuevoFrame = new TicTacToe();
           frame.setVisible(false);
           nuevoFrame.setVisible(true);
           nuevoFrame.setResizable(false);
       }
    }
    
    
    
    
}