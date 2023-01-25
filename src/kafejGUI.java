import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class kafejGUI extends JFrame{
    private JPanel kafejPanel;
    private JButton backButton;
    private JTextField imieText;
    private JTextField nazwText;
    private JButton rozpocznijButton;
    private JLabel obrazek;
    private JButton czasButton;
    private JTextField godzZakT;
    private JLabel czasLabel;
    private JTextField minZakT;
    int godzStart = 0;
    int minStart = 0;

    public static void main(String args[]){
        new kafejGUI().setVisible(true);
    }
    public kafejGUI(){
        super("Kafejka");
        add(kafejPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        obrazek.setIcon(new ImageIcon(getClass().getResource("obrazek1.jpg")));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new mainGUI().setVisible(true);
            }
        });
        czasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date czas = new Date();
                SimpleDateFormat godz = new SimpleDateFormat("HH");
                godzStart = Integer.parseInt(godz.format(czas));
                SimpleDateFormat min = new SimpleDateFormat("mm");
                minStart = Integer.parseInt(min.format(czas));

                if(minStart < 10)
                    czasLabel.setText(godzStart+" : 0"+minStart);
                else
                    czasLabel.setText(godzStart+" : "+minStart);
            }
        });
        rozpocznijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String godzZak = godzZakT.getText();
                String minZak = minZakT.getText();

                try{
                    Integer.parseInt(godzZak);
                    Integer.parseInt(minZak);
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Podaj czas w liczbach!");
                    throw new NumberFormatException("zły format");
                }

                if(Integer.parseInt(godzZak)==0){
                    godzZak = "24";
                }

                int godzTrwania = Integer.parseInt(godzZak)-godzStart;
                int minTrwania = Integer.parseInt(minZak)-minStart;

                if(minTrwania < 0){
                    godzTrwania = godzTrwania-1;
                    minTrwania = 60+minTrwania;
                }

                int koszt = 0;
                int godzPom = 0;
                if(godzTrwania<1)
                    koszt = 5;
                else if(godzTrwania >=1 && minTrwania>0) {
                    godzPom = godzTrwania+1;
                    koszt = godzPom * 5;
                }
                else
                    koszt = godzTrwania*5;

                if(imieText.getText().isEmpty() || nazwText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Podaj swoje imie i nazwisko!");
                }
                else if(Integer.parseInt(godzZak) < 0 || Integer.parseInt(godzZak) > 24 ){
                    JOptionPane.showMessageDialog(null, "Złe godziny");
                }
                else if(Integer.parseInt(minZak) < 0 || Integer.parseInt(minZak) > 59 ){
                    JOptionPane.showMessageDialog(null, "Złe minuty");
                }
                else if(godzStart == 0){
                    JOptionPane.showMessageDialog(null, "Naciśnij przycisk Pobierz czas");
                }
                else if(Integer.parseInt(godzZak) < godzStart){
                    JOptionPane.showMessageDialog(null, "Nie prawidłowy czas");
                }
                else if((Integer.parseInt(godzZak) == godzStart && Integer.parseInt(minZak) <= minStart)){
                    JOptionPane.showMessageDialog(null, "Nie prawidłowy czas");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Witaj " + imieText.getText() + "!\nCzas trwania: "
                            + godzTrwania + "h " + minTrwania + "min\nNależność: "+koszt+"zł");

                    uzytkownicy.dodaj(imieText.getText(), nazwText.getText(), godzStart+":"+minStart , godzZak+":"+minZak, koszt+" zł");

                    dispose();
                }
            }
        });
    }
}
