import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bazaGUI extends JFrame{
    private JPanel bazaPanel;
    private JButton button1;
    private JTable tabelaBaza;
    DefaultTableModel model;
    public static void main(String args[]){
        new bazaGUI().setVisible(true);
    }

    public bazaGUI(){
        super("Użtkownicy");
        this.setContentPane(bazaPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        setLocationRelativeTo(null);
        uzytkownicy.pokaz();

        model = new DefaultTableModel();
        tabelaBaza.setModel(model);
        Object[] column = {"Imie", "Nazwisko", "Czas rozpoczecia", "Czas zakonczenia", "Cena"};
        model.setColumnIdentifiers(column);

        Object[] row = new Object[5];
        for(int i=0; i<uzytkownicy.lista.size();i++)
        {
            row[0] = uzytkownicy.lista.get(i).getImie();
            row[1] = uzytkownicy.lista.get(i).getNazwisko();
            row[2] = uzytkownicy.lista.get(i).getCzas_rozp();
            row[3] = uzytkownicy.lista.get(i).getCzas_zak();
            row[4] = uzytkownicy.lista.get(i).getCena();
            model.addRow(row);
        }

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new mainGUI().setVisible(true);
            }
        });
    }
}
