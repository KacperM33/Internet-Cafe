import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wypozyGUI extends JFrame{
    private JPanel wypozyPanel;
    private JButton backButton;
    private JTable tabelaGry;
    private JButton wypozyczButton;
    DefaultTableModel model;
    DefaultTableModel model2;

    public static void main(String args[]){
        new wypozyGUI().setVisible(true);
    }

    public wypozyGUI(){
        super("Wypożyczalnia");
        this.setContentPane(wypozyPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        setLocationRelativeTo(null);
        backButton.setIcon(new ImageIcon(getClass().getResource("backBut.png")));

        wypoz.listaGry.clear();
        wypoz.connect();

        model = new DefaultTableModel();
        model2 = new DefaultTableModel();

        tabelaGry.setModel(model);
        Object[] column = {"Tytuł", "Wydawca", "Cena"};
        model.setColumnIdentifiers(column);

        Object[] row = new Object[4];
        for(int i=0; i<wypoz.listaGry.size();i++)
        {
            row[0] = wypoz.listaGry.get(i).get_tytul();
            row[1] = wypoz.listaGry.get(i).get_wydawca();
            row[2] = wypoz.listaGry.get(i).get_cena();
            model.addRow(row);
        }
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new mainGUI().setVisible(true);
            }
        });
        wypozyczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = tabelaGry.getSelectedRow();
                String y = toString();
                if(x<0)
                {
                    JOptionPane.showMessageDialog(null, "Nic nie wybrano!");
                }
                else {
                    wypoz.delete(x + 1);
                    wypoz.listaGry.clear();
                    wypoz.connect();

                    tabelaGry.setModel(model2);
                    Object[] column = {"Tytuł", "Wydawca", "Cena"};
                    model2.setColumnIdentifiers(column);

                    Object[] row = new Object[4];
                    for (int i = 0; i < wypoz.listaGry.size(); i++) {
                        row[0] = wypoz.listaGry.get(i).get_tytul();
                        row[1] = wypoz.listaGry.get(i).get_wydawca();
                        row[2] = wypoz.listaGry.get(i).get_cena();
                        model2.addRow(row);
                    }
                }
            }
        });
    }
}
