import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class loginGUI extends JFrame{
    private JPanel loginPanel;
    private JButton backButton;
    private JPasswordField hasloPass;
    private JTextField loginText;
    private JButton loginButton;
    private JLabel obrazek;

    public static void main(String args[]){
        new loginGUI().setVisible(true);
    }

    public loginGUI(){
        super("Logowanie");
        this.setContentPane(loginPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        setLocationRelativeTo(null);
        obrazek.setIcon(new ImageIcon(getClass().getResource("admin2.png")));
        backButton.setIcon(new ImageIcon(getClass().getResource("backBut.png")));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new mainGUI().setVisible(true);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginText.getText();
                String haslo = hasloPass.getText();
                String loginCorrect = "admin";
                String passCorrect = "admin";
                if(login.equals(loginCorrect) && haslo.equals(passCorrect)){
                    dispose();
                    new bazaGUI().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Niepoprawna nazwa użytkownika lub hasło!");
                }
            }
        });
    }
}
