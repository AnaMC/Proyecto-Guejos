package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import tools.BotonMolon;
import tools.Listener;

import java.awt.GridBagLayout;
import javax.swing.ButtonGroup;

import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;

import juegos.Juego;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import tools.ListenerMenu;
import tools.PanelMolon;

@SuppressWarnings({"serial", "unused"}) /*ECLIPSE*/

public class TicTacToe extends JFrame { /*Class TicTacToe, hereda de JFrame */


    private JPanel contentPane;  //consultar lo de setContentPane
    private JPanel panelTablero;
    private BotonMolon[][] casillas;
    private JLabel lblJugador2 = new JLabel("POllas");
    private JLabel lblJugador1 = new JLabel("POllas");
    private JLabel lblIcono = new JLabel("");
    private Juego juego;
    private JLabel lblTurno;
    private JMenuItem mntmSalir;
    private JMenuItem mntmNuevo;
    private Listener lis;
    private ListenerMenu menuLis;

    /*Getter y Setter*/
    public JMenuItem getMntmNuevo() {
        return mntmNuevo;
    }

    public void setMntmNuevo(JMenuItem mntmNuevo) {
        this.mntmNuevo = mntmNuevo;
    }

    public JMenuItem getMntmSalir() {
        return mntmSalir;
    }

    public void setMntmSalir(JMenuItem mntmSalir) {
        this.mntmSalir = mntmSalir;
    }

    public JPanel getPanelTablero() {
        return panelTablero;
    }

    public JLabel getLblTurno() {
        return lblTurno;
    }

    public void setLblTurno(JLabel lblTurno) {
        this.lblTurno = lblTurno;
    }

    public void setPanelTablero(JPanel panelTablero) {
        this.panelTablero = panelTablero;
    }

    public BotonMolon[][] getCasillas() {
        return casillas;
    }

    public BotonMolon getCasilla(int x, int y) {
        return casillas[x][y];
    }

    public void setCasillas(BotonMolon[][] casillas) {
        this.casillas = casillas;
    }

    public JLabel getLblJugador2() {
        return lblJugador2;
    }

    public void setLblJugador2(String lblJugador2) {
        this.lblJugador2.setText(lblJugador2);
    }

    public JLabel getLblJugador1() {
        return lblJugador1;
    }

    public void setLblJugador1(String lblJugador1) {
        this.lblJugador1.setText(lblJugador1);
    }

    public ImageIcon getLblIcono() {
        ImageIcon icono = (ImageIcon) lblIcono.getIcon();
        return icono;
    }

    public void setLblIcono(ImageIcon lblIcono) {
        this.lblIcono.setIcon(lblIcono);
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    /*Contructor de la clase */
    public TicTacToe() {
        lis = new Listener(this);
        menuLis = new ListenerMenu(this);

        /*Centrar frame*/
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (pantalla.getWidth() / 3), (int) (pantalla.getHeight() / 5), 500, 500);
        setTitle("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*Los componentes que no son atrib. de la clase los ha generado Eclipse,
         después, cuando ha sido necesario lo hemos cambiado a atributos.*/
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnJuego = new JMenu("Juego");
        menuBar.add(mnJuego);

        mntmNuevo = new JMenuItem("Nuevo");
        mnJuego.add(mntmNuevo);
        mntmNuevo.addActionListener(menuLis);

        mntmSalir = new JMenuItem("Salir");
        mnJuego.add(mntmSalir);
        mntmSalir.addActionListener(menuLis);

        JMenu mnJugadores = new JMenu("Jugadores");
        menuBar.add(mnJugadores);

        JMenuItem mntmRegistrarJugador = new JMenuItem("Registrar jugador");
        mnJugadores.add(mntmRegistrarJugador);

        JMenuItem mntmEliminarJugador = new JMenuItem("Eliminar Jugador");
        mnJugadores.add(mntmEliminarJugador);

        JMenuItem mntmMostrarJugadores = new JMenuItem("Mostrar Jugadores");
        mnJugadores.add(mntmMostrarJugadores);

        JMenu mnPuntuacion = new JMenu("Puntuacion");
        menuBar.add(mnPuntuacion);

        JMenuItem mntmMostrarRanking = new JMenuItem("Mostrar ranking");
        mnPuntuacion.add(mntmMostrarRanking);

        JMenu mnApariencia = new JMenu("Apariencia");
        menuBar.add(mnApariencia);

        //check boxes state changed
        JCheckBoxMenuItem chckbxmntmModerno = new JCheckBoxMenuItem("Moderno");
        chckbxmntmModerno.setSelected(true);
        chckbxmntmModerno.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                estiloInicialModerno();
            }
        });
        mnApariencia.add(chckbxmntmModerno);

        JCheckBoxMenuItem chckbxmntmRecargado = new JCheckBoxMenuItem("Recargado");
        chckbxmntmRecargado.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                estiloRecargado();
            }
        });
        mnApariencia.add(chckbxmntmRecargado);

        //Content pane 
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.windowBorder);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //Gridbag layout
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{100, 300, 100,};
        gbl_contentPane.rowHeights = new int[]{129, 300, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0};
        gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JPanel panelDisplay = new JPanel();
        panelDisplay.setLayout(null);
        //Gridbag constraints de panelDisplay
        GridBagConstraints gbc_panelDisplay = new GridBagConstraints();
        gbc_panelDisplay.gridwidth = 3;
        gbc_panelDisplay.insets = new Insets(0, 0, 5, 0);
        gbc_panelDisplay.fill = GridBagConstraints.BOTH;
        gbc_panelDisplay.gridx = 0;
        gbc_panelDisplay.gridy = 0;
        contentPane.add(panelDisplay, gbc_panelDisplay);

        lblJugador1.setBounds(10, 19, 158, 50);
        lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);
        lblJugador1.setHorizontalTextPosition(SwingConstants.LEFT);

        lblJugador2.setBounds(307, 19, 158, 50);
        lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblNewLabel = new JLabel("Jugador X");
        lblNewLabel.setBounds(20, 80, 130, 14);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panelDisplay.add(lblJugador1);

        JLabel lblNewLabel_1 = new JLabel("Jugador O");
        lblNewLabel_1.setBounds(317, 80, 130, 14);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        panelDisplay.add(lblNewLabel_1);
        panelDisplay.add(lblNewLabel);
        panelDisplay.add(lblJugador2);

        lblTurno = new JLabel("Turno");
        lblTurno.setHorizontalAlignment(SwingConstants.CENTER);
        lblTurno.setBounds(227, 0, 46, 14);
        panelDisplay.add(lblTurno);

        PanelMolon panelTurno = new PanelMolon("Img\\ganador.jpg");
        panelTurno.setSize(new Dimension(100, 100));
        panelTurno.setMinimumSize(new Dimension(100, 100));
        panelTurno.setBounds(199, 19, 100, 100);
        panelTurno.setBackground(Color.PINK);
        panelTurno.setMaximumSize(new Dimension(100, 100));
        panelTurno.setPreferredSize(new Dimension(100, 100));
        panelTurno.setLayout(new BorderLayout(0, 0));
        lblIcono.setSize(new Dimension(100, 100));
        lblIcono.setPreferredSize(new Dimension(100, 100));
        lblIcono.setMinimumSize(new Dimension(100, 100));

        lblIcono.setIcon(new ImageIcon("Img\\white.jpg"));
        panelTurno.add(lblIcono);
        panelDisplay.add(panelTurno);

        JPanel horteraIzquierdo = new JPanel();
        horteraIzquierdo.setVisible(false);
        GridBagConstraints gbc_horteraIzquierdo = new GridBagConstraints();
        gbc_horteraIzquierdo.insets = new Insets(0, 0, 0, 5);
        gbc_horteraIzquierdo.fill = GridBagConstraints.BOTH;
        gbc_horteraIzquierdo.gridx = 0;
        gbc_horteraIzquierdo.gridy = 1;
        contentPane.add(horteraIzquierdo, gbc_horteraIzquierdo);

        panelTablero = new JPanel();
        Dimension tamanoTablero = new Dimension(300, 300);
        panelTablero.setMinimumSize(tamanoTablero);
        panelTablero.setPreferredSize(tamanoTablero);
        panelTablero.setSize(tamanoTablero);
        panelTablero.setBackground(SystemColor.windowBorder);
        //Gridbag constraints de panelTablero
        GridBagConstraints gbc_panelTablero = new GridBagConstraints();
        gbc_panelTablero.insets = new Insets(0, 0, 0, 5);
        gbc_panelTablero.anchor = GridBagConstraints.SOUTH;
        gbc_panelTablero.fill = GridBagConstraints.HORIZONTAL;
        gbc_panelTablero.gridx = 1;
        gbc_panelTablero.gridy = 1;
        contentPane.add(panelTablero, gbc_panelTablero);
        panelTablero.setLayout(new GridLayout(3, 3, 1, 1));

        JPanel horteraDerecho = new JPanel();
        horteraDerecho.setVisible(false);
        GridBagConstraints gbc_horteraDerecho = new GridBagConstraints();
        gbc_horteraDerecho.fill = GridBagConstraints.BOTH;
        gbc_horteraDerecho.gridx = 2;
        gbc_horteraDerecho.gridy = 1;
        contentPane.add(horteraDerecho, gbc_horteraDerecho);
        this.rellenarTablero();

        ButtonGroup grupoApariencia = new ButtonGroup();
        grupoApariencia.add(chckbxmntmModerno);
        grupoApariencia.add(chckbxmntmRecargado);

        //
        juego = new Juego(this);
        //
    }

    private void rellenarTablero() {
        casillas = new BotonMolon[3][3];
        int cod = 0;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                casillas[i][j] = new BotonMolon("w", cod);
                casillas[i][j].setIcon(new ImageIcon("Img\\white.jpg", null));
                casillas[i][j].addActionListener(lis);
                panelTablero.add(casillas[i][j]);
                cod++;
            }
        }
    }

    private void estiloInicialModerno() {
        contentPane.setBackground(SystemColor.windowBorder);
    }

    private void estiloRecargado() {
        contentPane.setBackground(new Color(31, 81, 61));
    }

}
