import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Notepad note = new Notepad();
        note.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        note.setVisible(true);
        note.setSize(800, 550);
    }
}