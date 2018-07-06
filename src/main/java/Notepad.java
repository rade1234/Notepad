import java.awt.event.*;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.Scanner;
import javax.swing.*;

public class Notepad extends JFrame {

    private JTextArea area1;
    private JScrollPane scroll;
    private JPopupMenu popup;
    private JMenuItem pCopy;
    private JMenuItem pPaste;
    private JMenuItem pCut;
    private JMenuItem pSelect;
    private JMenuItem pDelete;

    public Notepad() {

        //Main Text Area
        super("Notepad");
        area1 = new JTextArea();
        add(area1);

        //Scroll
        scroll = new JScrollPane(area1);
        add(scroll);

        //PopUp
        popup = new JPopupMenu();
        pCopy = new JMenuItem("Copy");
        pCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        popup.add(pCopy);
        area1.setComponentPopupMenu(popup);

        pPaste = new JMenuItem("Paste");
        pPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        popup.add(pPaste);
        area1.setComponentPopupMenu(popup);

        pCut = new JMenuItem("Cut");
        pCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        popup.add(pCut);
        area1.setComponentPopupMenu(popup);

        pSelect = new JMenuItem("Select All");
        pSelect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        popup.add(pSelect);
        area1.setComponentPopupMenu(popup);

        listentoClear ListenC = new listentoClear();
        listentoSave ListenS = new listentoSave();
        listentoOpen ListenO = new listentoOpen();

        pDelete = new JMenuItem("Clear");
        pDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        pDelete.addActionListener(ListenC);
        popup.add(pDelete);
        area1.setComponentPopupMenu(popup);

        //TopMenu
        Menu mn = new Menu();
        mn.tMenu();
        setJMenuBar(mn.menu);
        mn.newI.addActionListener(ListenC);
        mn.save.addActionListener(ListenS);
        mn.open.addActionListener(ListenO);
    }

    private class listentoSave implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JFileChooser saveFile = new JFileChooser();

            if (saveFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = saveFile.getSelectedFile();
                try {
                    PrintWriter pw = new PrintWriter(plik);
                    Scanner skaner = new Scanner(area1.getText());
                    while (skaner.hasNext()) {
                        pw.println(skaner.nextLine() + "\n");
                        pw.close();
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private class listentoClear implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            area1.setText("");
        }
    }


    private class listentoOpen implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JFileChooser openFile = new JFileChooser();

            if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = openFile.getSelectedFile();

                try {
                    Scanner skaner = new Scanner(plik);
                    while (skaner.hasNext()) {
                        area1.append(skaner.nextLine() + "\n");
                    }

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}