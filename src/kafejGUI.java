import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kafejGUI extends JFrame{
    private JPanel kafejPanel;
    private JButton backButton;
    private JTextField textField2;
    private JTextField textField1;
    private JButton rozpButton;
    private JLabel cenaLabel;
    private JLabel godzRLabel;
    private JLabel godzZLabel;

    public static void main(String args[]){
        new kafejGUI().setVisible(true);
    }

    public kafejGUI(){
        super("Kafejka");
        add(kafejPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        String godzrozp = godzRLabel.getText();
        String godzzak = godzZLabel.getText();
        //double cena = Integer.getInteger(godzzak)-Integer.getInteger(godzrozp);


        cenaLabel.setText(godzrozp+" "+godzzak);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new mainGUI().setVisible(true);
            }
        });
    }
}
