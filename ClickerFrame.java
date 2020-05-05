//Author: Soren Thrawl

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


class ClickerFrame extends JFrame implements ActionListener {
    private ArrayList<tTile> targetList = new ArrayList<tTile>();
    private int onTile;
    private long start;
    private int clickedTiles = 0;
    private double elapsed;
    private JTextField timeTextField;

    public ClickerFrame() {
        setBounds(25,25,650,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container tilesPane = getContentPane();
        tilesPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        tilesPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton startButton = new JButton("Start or Restart");
        buttonPanel.add(startButton);
        startButton.addActionListener(this);

        JPanel tilePanel = new JPanel();
        tilesPane.add(tilePanel, BorderLayout.CENTER);
        tilePanel.setLayout(new GridLayout(12,12));

        JLabel label = new JLabel("Seconds");
        buttonPanel.add(label);
        timeTextField = new JTextField(3);
        buttonPanel.add(timeTextField);

        for(int i=1; i<145; i++) {
            tTile targetTile = new tTile();
            targetList.add(targetTile);
            tilePanel.add(targetTile);

            targetTile.addMouseListener(new MouseListener(){
                public void mouseClicked(MouseEvent e){ 
                    targetTile.setToWhite();
                    int spot = 143 - onTile;
                    if (targetList.indexOf(targetTile) + spot == 143){
                        if (clickedTiles < 9){
                            clickedTiles += 1;
                            int targ = (int) (1. + (Math.random() * 143));

                            if (targ == onTile){
                                if (targ == 143){
                                    targ = 142;
                                }
                                else {
                                    targ = targ + 1;
                                }
                            }
                            targetList.get(targ).setToRed();
                            onTile = targ;
                            repaint();
                        }
                        else{
                            long end = System.nanoTime();
                            double elap = ((double)(end - start))/1000000000.;

                            long fact = (long) Math.pow(10, 2);
                            elap = elap * fact;
                            long tmp = Math.round(elap);
                            elapsed = (double) tmp / fact;

                            timeTextField.setText(String.valueOf(elapsed));
                            System.out.println("It took " + elapsed + " seconds.");
                        }
                    } 
                }
                public void mousePressed(MouseEvent e){};
                public void mouseReleased(MouseEvent e){};
                public void mouseExited(MouseEvent e) {};
                public void mouseEntered(MouseEvent e){};
            });
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Start or Restart");
        targetList.get(onTile).setToWhite();
        timeTextField.setText(String.valueOf(""));

        clickedTiles = 0;
    
        int targ = (int) (1. + (Math.random() * 143));
        targetList.get(targ).setToRed();
        onTile = targ;

        start = System.nanoTime();
        repaint();
    }

}