import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kafejGUI extends JFrame{
    private JPanel kafejPanel;
    private JButton backButton;

    public static void main(String args[]){
        new kafejGUI().setVisible(true);
    }

    public kafejGUI(){
        super("Kafejka");
        add(kafejPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
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
