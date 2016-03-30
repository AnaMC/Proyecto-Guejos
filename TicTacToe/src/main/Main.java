package main;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frames.TicTacToe;

import juegos.*;

@SuppressWarnings("unused")
public class Main implements ActionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TicTacToe ventanaTicTac = new TicTacToe();
                    ventanaTicTac.setVisible(true);
                    ventanaTicTac.setResizable(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
