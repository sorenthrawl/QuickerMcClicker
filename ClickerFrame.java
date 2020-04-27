//Author: Soren Thrawl

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

class ClickerFrame extends JFrame implements ActionListener {
    private ArrayList<tTile> targetList = new ArrayList<tTile>();

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

        int targ = (int) (Math.random() * 145);

        for(int i=1; i<145; i++) {
            if (targ == i){
                tTile targetTile = new tTile(true);
                targetList.add(targetTile);
                tilePanel.add(targetTile);
            }
            else {
                tTile targetTile = new tTile();
                targetList.add(targetTile);
                tilePanel.add(targetTile);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Start or Restart");
        int targ = (int) (Math.random() * 145);
        targetList.get(targ).setToRed();
        repaint();
    }
}