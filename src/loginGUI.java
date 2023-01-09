import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginGUI extends JFrame{
    private JPanel loginPanel;
    private JButton backButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton zalogujButton;

    public static void main(String args[]){
        new loginGUI().setVisible(true);
    }

    public loginGUI(){
        super("Logowanie");
        this.setContentPane(loginPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
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
