import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public abstract class GUI{

    public static void createGUI() {
        Wyscig w = new Wyscig();

        JFrame fMain = new JFrame("WYŚCIGI");

        JButton b_list = new JButton("WYŚWIETL LISTĘ");
        b_list.setBounds(320, 25, 140, 40);
        b_list.setForeground(new Color(255, 255, 255));
        b_list.setBackground(new Color(0, 0, 0));

        JLabel zdj = new JLabel(new ImageIcon("src\\car_race.png"));
        zdj.setBounds(0, 100, 800, 500);

        fMain.add(b_list);
        fMain.add(zdj);

        ImageIcon img = new ImageIcon("src\\flagcar.jpg");
        fMain.setIconImage(img.getImage());
        fMain.setSize(800, 580);
        fMain.getContentPane().setBackground(new Color(150, 0, 0));
        fMain.setLayout(null);
        fMain.setResizable(false);
        fMain.setVisible(true);
        fMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //------------------------------------------------------------------------

        new ToyotaCorolla("wyścig1", "01-03-2015", "Argentyna");
        new ToyotaCorolla("wyścig2", "15-04-2012", "Senegal");
        new ToyotaCorolla("wyścig3", "11-12-2014", "Argentyna");
        new ToyotaCorolla("wyścig4", "01-03-2011", "Peru");
        new SubaruImpreza("wyścig5", "01-03-2013", "Chile");
        new SubaruImpreza("wyścig6", "01-03-2019", "Peru");
        new SubaruImpreza("wyścig7", "01-03-2017", "Chile");
        new SubaruImpreza("wyścig8", "01-03-2013", "Argentyna");
        new HondaNSX("wyścig9", "01-03-2018", "Japonia");
        new HondaNSX("wyścig10", "01-03-2011", "Niemcy");
        new HondaNSX("wyścig11", "01-03-2016", "Włochy");
        new HondaNSX("wyścig12", "01-03-2021", "USA");
        new ToyotaSupra("wyścig13", "01-03-2016", "Tajlandia");
        new ToyotaSupra("wyścig14", "01-03-2018", "Holandia");
        new ToyotaSupra("wyścig15", "01-03-2014", "Japonia");
        new ToyotaSupra("wyścig16", "01-03-2020", "Kanada");

        //------------------------------------------------------------------------

        b_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fMain.setVisible(false);

                JFrame fShow = new JFrame("LISTA WYŚCIGÓW");

                JTextArea ta_lista_w = new JTextArea();
                ta_lista_w.setBounds(55, 100, 1620, 500);
                ta_lista_w.setForeground(new Color(255, 255, 255));
                ta_lista_w.setBackground(new Color(0, 0, 0));

                ta_lista_w.append(w.list.toString());
                ta_lista_w.setEditable(false);

                JScrollPane scroll = new JScrollPane(ta_lista_w, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scroll.setLocation(1200, 100);
                scroll.setSize(20, 400);

                JButton b_add = new JButton("DODAJ");
                b_add.setBounds(150, 25, 140, 40);
                b_add.setForeground(new Color(255, 255, 255));
                b_add.setBackground(new Color(0, 0, 0));

                JButton b_delete = new JButton("USUŃ");
                b_delete.setBounds(580, 25, 140, 40);
                b_delete.setForeground(new Color(255, 255, 255));
                b_delete.setBackground(new Color(0, 0, 0));

                JButton b_reload = new JButton("AKTUALIZUJ");
                b_reload.setBounds(1020, 25, 140, 40);
                b_reload.setForeground(new Color(255, 255, 255));
                b_reload.setBackground(new Color(0, 0, 0));

                JButton b_save = new JButton("ZAPISZ DO PLIKU");
                b_save.setBounds(1440, 25, 140, 40);
                b_save.setForeground(new Color(255, 255, 255));
                b_save.setBackground(new Color(0, 0, 0));

                JLabel l_error = new JLabel();
                l_error.setBounds(1600,25,160,40);
                l_error.setForeground(new Color(255, 255, 255));
                l_error.setBackground(new Color(0, 0, 0));

                fShow.add(b_delete);
                fShow.add(b_save);
                fShow.add(b_add);
                fShow.add(b_reload);
                fShow.add(ta_lista_w);
                fShow.add(l_error);
                //fShow.add(scroll, BorderLayout.CENTER);

                ImageIcon img = new ImageIcon("src\\flagcar.jpg");
                fShow.setIconImage(img.getImage());
                fShow.setSize(1750, 700);
                fShow.getContentPane().setBackground(new Color(150, 0, 0));
                fShow.setLayout(null);
                fShow.setResizable(false);
                fShow.setVisible(true);
                fShow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                b_reload.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        fShow.setVisible(true);
                        fShow.dispose();
                    }
                });

                b_save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        PrintWriter zapis = null;

                        try {
                            zapis = new PrintWriter("pliki\\lista.txt");
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        l_error.setText("Plik zapisano!");
                        zapis.println(ta_lista_w.getText());
                        zapis.close();
                    }
                });

                b_delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        fShow.setVisible(false);

                        JFrame fDel = new JFrame("USUŃ WYŚCIG");

                        JLabel l_id = new JLabel("PODAJ ID: ");
                        l_id.setBounds(50, 25, 140, 40);
                        l_id.setForeground(new Color(255, 255, 255));

                        NumberFormat format = NumberFormat.getInstance();
                        NumberFormatter formatter = new NumberFormatter(format);
                        formatter.setValueClass(Integer.class);
                        formatter.setMinimum(0);
                        formatter.setMaximum(w.list.size() - 1);
                        formatter.setAllowsInvalid(false);
                        formatter.setCommitsOnValidEdit(true);
                        JFormattedTextField tf_id = new JFormattedTextField(formatter);
                        //JTextField tf_id = new JTextField();
                        tf_id.setBounds(200, 25, 140, 40);
                        tf_id.setForeground(new Color(255, 255, 255));
                        tf_id.setBackground(new Color(0, 0, 0));

                        JLabel l_error = new JLabel();
                        l_error.setBounds(175,70,160,40);
                        l_error.setForeground(new Color(255, 255, 255));
                        l_error.setBackground(new Color(0, 0, 0));

                        JButton b_remove = new JButton("USUŃ");
                        b_remove.setBounds(125, 110, 140, 40);
                        b_remove.setForeground(new Color(255, 255, 255));
                        b_remove.setBackground(new Color(0, 0, 0));

                        fDel.add(l_id);
                        fDel.add(tf_id);
                        fDel.add(l_error);
                        fDel.add(b_remove);

                        ImageIcon img = new ImageIcon("src\\flagcar.jpg");
                        fDel.setIconImage(img.getImage());
                        fDel.setSize(400, 215);
                        fDel.getContentPane().setBackground(new Color(150, 0, 0));
                        fDel.setLayout(null);
                        fDel.setResizable(false);
                        fDel.setVisible(true);
                        fDel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                        b_remove.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                String i = tf_id.getText().toString();

                                if(i.equals("")) {
                                    l_error.setText("Podaj id!");
                                }
                                else {
                                    l_error.setText("");
                                    int j = Integer.parseInt(i);
                                    w.list.remove(j);
                                    fDel.setVisible(true);
                                    fDel.dispose();
                                }
                            }
                        });

                        fDel.addWindowListener(new WindowListener() {
                            @Override
                            public void windowOpened(WindowEvent e) {

                            }

                            @Override
                            public void windowClosing(WindowEvent e) {

                                fDel.dispose();
                            }

                            @Override
                            public void windowClosed(WindowEvent e) {

                                fShow.setVisible(true);
                            }

                            @Override
                            public void windowIconified(WindowEvent e) {

                            }

                            @Override
                            public void windowDeiconified(WindowEvent e) {

                            }

                            @Override
                            public void windowActivated(WindowEvent e) {

                            }

                            @Override
                            public void windowDeactivated(WindowEvent e) {

                            }
                        });
                    }
                });

                b_add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        fShow.setVisible(false);

                        JFrame fAdd = new JFrame("DODAJ WYŚCIG");

                        JLabel l_name = new JLabel("NAZWA: ");
                        l_name.setBounds(50,25,140,40);
                        l_name.setForeground(new Color(255, 255, 255));

                        JTextField t_name = new JTextField();
                        t_name.setBounds(200,25,140,40);
                        t_name.setForeground(new Color(255, 255, 255));
                        t_name.setBackground(new Color(0, 0, 0));

                        JLabel l_race = new JLabel("WYŚCIG: ");
                        l_race.setBounds(50,75,140,40);
                        l_race.setForeground(new Color(255, 255, 255));

                        String rodzajWyscig[] = {"Wybierz rodzaj wyścigu", "rajdowy", "prędkościowy"};
                        JComboBox c_race = new JComboBox(rodzajWyscig);
                        c_race.setBounds(200,75,140,40);
                        c_race.setForeground(new Color(255, 255, 255));
                        c_race.setBackground(new Color(0, 0, 0));

                        JLabel l_data = new JLabel("DATA: ");
                        l_data.setBounds(50,125,140,40);
                        l_data.setForeground(new Color(255, 255, 255));

                        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        JFormattedTextField t_data = new JFormattedTextField(format);

                        //JTextField t_data = new JTextField();
                        t_data.setBounds(200,125,140,40);
                        t_data.setForeground(new Color(255, 255, 255));
                        t_data.setBackground(new Color(0, 0, 0));

                        JLabel l_country = new JLabel("KRAJ: ");
                        l_country.setBounds(50,175,140,40);
                        l_country.setForeground(new Color(255, 255, 255));

                        JTextField t_country = new JTextField();
                        t_country.setBounds(200,175,140,40);
                        t_country.setForeground(new Color(255, 255, 255));
                        t_country.setBackground(new Color(0, 0, 0));

                        JLabel l_auto = new JLabel("AUTO: ");
                        l_auto.setBounds(50,225,140,40);
                        l_auto.setForeground(new Color(255, 255, 255));

                        JComboBox c_auto = new JComboBox();
                        c_auto.setBounds(200,225,140,40);
                        c_auto.setForeground(new Color(255, 255, 255));
                        c_auto.setBackground(new Color(0, 0, 0));
                        c_auto.addItem("Pierw rodzaj wyścigu");

                        JLabel l_error = new JLabel();
                        l_error.setBounds(130,275,160,40);
                        l_error.setForeground(new Color(255, 255, 255));
                        l_error.setBackground(new Color(0, 0, 0));

                        JButton b_add = new JButton("DODAJ");
                        b_add.setBounds(125,320,140,40);
                        b_add.setForeground(new Color(255, 255, 255));
                        b_add.setBackground(new Color(0, 0, 0));

                        fAdd.add(l_name);
                        fAdd.add(t_name);
                        fAdd.add(l_race);
                        fAdd.add(c_race);
                        fAdd.add(l_data);
                        fAdd.add(t_data);
                        fAdd.add(l_country);
                        fAdd.add(t_country);
                        fAdd.add(l_auto);
                        fAdd.add(c_auto);
                        fAdd.add(b_add);
                        fAdd.add(l_error);

                        ImageIcon img = new ImageIcon("src\\flagcar.jpg");
                        fAdd.setIconImage(img.getImage());
                        fAdd.setSize(400,425);
                        fAdd.getContentPane().setBackground(new Color(150, 0, 0));
                        fAdd.setLayout(null);
                        fAdd.setResizable(false);
                        fAdd.setVisible(true);
                        fAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                        c_race.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                if(c_race.getSelectedItem().equals("rajdowy"))
                                {
                                    c_auto.removeAllItems();
                                    c_auto.addItem("Toyota Corolla");
                                    c_auto.addItem("Subaru Impreza");
                                    c_auto.setSelectedItem(null);
                                }
                                else if(c_race.getSelectedItem().equals("prędkościowy"))
                                {
                                    c_auto.removeAllItems();
                                    c_auto.addItem("Honda NSX");
                                    c_auto.addItem("Toyota Supra");
                                    c_auto.setSelectedItem(null);
                                }
                                else
                                {
                                    c_auto.removeAllItems();
                                    c_auto.addItem("Pierw wybierz rodzaj wyścigu");
                                }
                            }
                        });

                        b_add.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                l_error.setText("");

                                String race = (String) c_race.getSelectedItem();
                                String auto = (String) c_auto.getSelectedItem();

                                if(t_name.getText().equals("") || t_data.getText().equals("") || t_country.getText().equals("") || c_auto.getSelectedItem() == null)
                                {
                                    l_error.setText("Wpisz wszystkie dane!");
                                }
                                else
                                {
                                    l_error.setText("");

                                    if(auto.equals("Toyota Corolla"))
                                    {
                                        new ToyotaCorolla(t_name.getText(), t_data.getText(), t_country.getText());
                                        l_error.setText("Wyścig dodano!");
                                        //System.out.println(ToyotaCorolla.list);
                                        fAdd.setVisible(true);
                                        fAdd.dispose();
                                    }
                                    else if(auto.equals("Subaru Impreza"))
                                    {
                                        new SubaruImpreza(t_name.getText(), t_data.getText(), t_country.getText());
                                        l_error.setText("Wyścig dodano!");
                                        //System.out.println(SubaruImpreza.list);
                                        fAdd.setVisible(true);
                                        fAdd.dispose();
                                    }
                                    else if(auto.equals("Honda NSX"))
                                    {
                                        new HondaNSX(t_name.getText(), t_data.getText(), t_country.getText());
                                        l_error.setText("Wyścig dodano!");
                                        //System.out.println(HondaNSX.list);
                                        fAdd.setVisible(true);
                                        fAdd.dispose();
                                    }
                                    else if(auto.equals("Toyota Supra"))
                                    {
                                        new ToyotaSupra(t_name.getText(), t_data.getText(), t_country.getText());
                                        l_error.setText("Wyścig dodano!");
                                        //System.out.println(ToyotaSupra.list);
                                        fAdd.setVisible(true);
                                        fAdd.dispose();
                                    }
                                    else
                                    {
                                        l_error.setText("Wpisz wszystkie dane!");
                                    }
                                }
                            }
                        });

                        fAdd.addWindowListener(new WindowListener() {
                            @Override
                            public void windowOpened(WindowEvent e) {

                            }

                            @Override
                            public void windowClosing(WindowEvent e) {

                                fAdd.dispose();
                            }

                            @Override
                            public void windowClosed(WindowEvent e) {

                                fShow.setVisible(true);
                            }

                            @Override
                            public void windowIconified(WindowEvent e) {

                            }

                            @Override
                            public void windowDeiconified(WindowEvent e) {

                            }

                            @Override
                            public void windowActivated(WindowEvent e) {

                            }

                            @Override
                            public void windowDeactivated(WindowEvent e) {

                            }
                        });
                    }
                });

                fShow.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {

                        fShow.dispose();
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {

                        fMain.setVisible(true);
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });
            }
        });

    }

    public static void main(String[] args) {

        createGUI();
    }
}
