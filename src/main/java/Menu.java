import java.awt.event.*;
import javax.swing.*;

public class Menu {

    public JMenuBar menu;
    public JMenu file;
    public JMenuItem newI;
    public JMenuItem open;
    public JMenuItem save;
    public JMenu edit;
    public JMenuItem copy;
    public JMenuItem paste;
    public JMenuItem cut;
    public JMenuItem selectAll;
    public JMenuItem clear;
    public JMenuItem exit;
    public JMenu help;
    public JMenuItem about;
    private JLabel ver;

    public void tMenu() {

        menu = new JMenuBar();
        listentoExit exitL = new listentoExit();
        listentoAbout aboutL = new listentoAbout();

        file = new JMenu("File");
        file.setMnemonic('F');
        menu.add(file);

        newI = new JMenuItem("New");
        newI.setMnemonic('N');
        newI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        file.add(newI);

        open = new JMenuItem("Open");
        open.setMnemonic('O');
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        file.add(open);

        save = new JMenuItem("Save as");
        save.setMnemonic('S');
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        file.add(save);

        file.addSeparator();
        exit = new JMenuItem("Exit");
        exit.setMnemonic('E');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        exit.addActionListener(exitL);
        file.add(exit);

        edit = new JMenu("Edit");
        edit.setMnemonic('E');
        menu.add(edit);

        copy = new JMenuItem("Copy");
        copy.setMnemonic('C');
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        edit.add(copy);

        paste = new JMenuItem("Paste");
        paste.setMnemonic('P');
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        edit.add(paste);

        cut = new JMenuItem("Cut");
        cut.setMnemonic('U');
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        edit.add(cut);

        selectAll = new JMenuItem("Select All");
        selectAll.setMnemonic('S');
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        edit.add(selectAll);

        clear = new JMenuItem("Clear");
        clear.setMnemonic('L');
        clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        edit.add(clear);

        help = new JMenu("Help");
        help.setMnemonic('H');
        menu.add(help);

        about = new JMenuItem("About");
        about.setMnemonic('A');
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        about.addActionListener(aboutL);
        help.add(about);

        menu.add(Box.createHorizontalGlue());
        ver = new JLabel("Rados\u0142aw Madejski ");
        menu.add(ver);
    }


    private class listentoExit implements ActionListener {

        //exit
        public void actionPerformed(ActionEvent e) {

            int q = JOptionPane.showConfirmDialog(null, "Are you sure, do you want to exit?", "Are you sure?", JOptionPane.YES_NO_OPTION);

            if (q == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    private class listentoAbout implements ActionListener {
        //exit
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "This is Notepad\n\nAuthor: Rados\u0142aw Madejski\n");
        }
    }
}
