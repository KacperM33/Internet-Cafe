import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wypozyGUI extends JFrame{
    private JPanel wypozyPanel;
    private JButton backButton;

    public static void main(String args[]){
        new wypozyGUI().setVisible(true);
    }

    public wypozyGUI(){
        super("Wypożyczalnia");
        this.setContentPane(wypozyPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        setLocationRelativeTo(null);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new mainGUI().setVisible(true);
            }
        });
    }
}
