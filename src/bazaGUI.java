import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bazaGUI extends JFrame{
    private JPanel bazaPanel;
    private JButton button1;

    public static void main(String args[]){
        new bazaGUI().setVisible(true);
    }

    public bazaGUI(){
        super("Użtkownicy");
        this.setContentPane(bazaPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        setLocationRelativeTo(null);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new mainGUI().setVisible(true);
            }
        });
    }
}
