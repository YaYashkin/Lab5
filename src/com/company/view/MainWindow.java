package com.company.view;

import com.company.MyTableModel;
import com.company.data.All;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    private JTable jTable;
    private MyTableModel myTableModel;
    private JComboBox jComboBox;
    private JButton addButton, buttonEnter, buttonDelete, clear;
    private JLabel label1, label2, label3, label4, jLabel;
        private JTextField jTextField, jTextField1, jTextField2, search;
        private TableRowSorter sorter;
        private GridLayout gridLayout;
        private JMenuBar jMenuBar;
        private JMenu jMenu;
        private JMenuItem jMenuItem;
    public MainWindow(){
            super("Наши кадры");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            myTableModel = new MyTableModel(new All());
            jTable = new JTable();
            jTable.setModel(myTableModel);
            JScrollPane jScrollPane = new JScrollPane(jTable);

            buttonDelete = new JButton("Удалить кадра");
            buttonDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        int modelRow = jTable.convertRowIndexToModel( jTable.getSelectedRow() );
                        myTableModel.delete( modelRow );
                    }catch (IndexOutOfBoundsException ex){
                        JDialog jDialog = new JDialog(MainWindow.this, "Выделите кадра", true);
                        jDialog.setLocationRelativeTo(null);
                        jDialog.setSize(300, 15);
                        jDialog.setVisible(true);
                    }
                }
            });

            addButton = new JButton("Добавить кадра");
            buttonEnter = new JButton("Принять");

            addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridLayout = new GridLayout(5, 2, 5, 10);
                jTextField = new JTextField( 30);
                label1 = new JLabel("Имя");
                label2 = new JLabel("Возраст");
                label3 = new JLabel("Кол-во часов");
                label4 = new JLabel("");
                jComboBox.setSelectedIndex(0);

//                KeyAdapter numericKeyAdapter = new KeyAdapter() {
//                    public void keyTyped(KeyEvent e) {
//                        char c = e.getKeyChar();
//                        if (((c >= '0') && (c <= '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
//                            e.consume();
//                        }
//                    }
//                };

//                KeyAdapter alphanumericKeyAdapter = new KeyAdapter() {
//                    public void keyTyped(KeyEvent e) {
//                        // В этом примере разрешаем ввод букв и цифр, а также символа пробела
//                        char c = e.getKeyChar();
//                        if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == KeyEvent.VK_SPACE || c == KeyEvent.VK_BACK_SPACE)) {
//                            e.consume();
//                        }
//                    }
//                };



                jComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(jComboBox.getSelectedIndex() == 0){
                            label3.setText("Кол-во часов");

                            //jTextField2.removeKeyListener(alphanumericKeyAdapter);
                            //jTextField2.addKeyListener(numericKeyAdapter);
                        }else if(jComboBox.getSelectedIndex() == 1){
                            label3.setText("Должность");

//                            jTextField2.removeKeyListener(numericKeyAdapter);
//                            jTextField2.addKeyListener(alphanumericKeyAdapter);
                        }else if(jComboBox.getSelectedIndex() == 2){
                            label3.setText("Кол-во подчинённых людей");

//                            jTextField2.removeKeyListener(alphanumericKeyAdapter);
//                            jTextField2.addKeyListener(numericKeyAdapter);
                        }
                    }
                });
                jTextField1 = new JTextField( 30);
                jTextField2 = new JTextField( 30);

                buttonEnter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if(jComboBox.getSelectedIndex() == 1){
                                myTableModel.AddKadrString(jComboBox.getSelectedIndex(), jTextField.getText(), Integer.parseInt(jTextField1.getText()), jTextField2.getText());
                            }
                            else{
                                myTableModel.AddKadrInt(jComboBox.getSelectedIndex(), jTextField.getText(), Integer.parseInt(jTextField1.getText()), Integer.parseInt(jTextField2.getText()));
                            }
                        }catch (NumberFormatException ex){
                            JDialog jDialog = new JDialog(MainWindow.this, "Ошибка при заполнении полей", true);
                            jDialog.setLocationRelativeTo(null);
                            jDialog.setSize(300, 15);
                            jDialog.setVisible(true);
                            jDialog.dispose();
                        }
                    }
                });

                jTextField1.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume();
                        }
                    }

                });










//                if(jComboBox.getSelectedIndex() == 0 || jComboBox.getSelectedIndex() == 2){
//                    jTextField2.addKeyListener(new KeyAdapter() {
//                        public void keyTyped(KeyEvent e) {
//                            char c = e.getKeyChar();
//                            if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
//                                e.consume();
//                            }
//                        }
//                    });
//                }


                JPanel jPanel = new JPanel(new FlowLayout());

                jPanel.setLayout(gridLayout);
                jPanel.add(label4);
                jPanel.add(jComboBox);
                jPanel.add(label1);
                jPanel.add(jTextField);
                jPanel.add(label2);
                jPanel.add(jTextField1);
                jPanel.add(label3);
                jPanel.add(jTextField2);
                jPanel.add(buttonEnter);

                JDialog jDialog = new JDialog(MainWindow.this, "Добавить", true);
                jDialog.setLocationRelativeTo(null);
                jDialog.setSize(400, 200);
                jDialog.add(jPanel);
                jDialog.setVisible(true);
            }
        });



        jComboBox = new JComboBox(new String[]{
                "Рабочий",
                "Инженер",
                "Администратор"
        });

        sorter = new TableRowSorter<>(jTable.getModel());
        jLabel = new JLabel("Поиск элемента: ");
        jTable.setRowSorter(sorter);
        search = new JTextField(12);
        search.setToolTipText("Поиск");
            search.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    String str = search.getText();
                    if (str.trim().length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    String str = search.getText();
                    if (str.trim().length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {

                }
            });

        clear = new JButton("Очистить поиск");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search.setText("");
            }
        });

            jMenuBar = new JMenuBar();
            jMenu = new JMenu("Справка");

            jMenuItem = new JMenuItem("О программе");
            jMenu.add(jMenuItem);
            jMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Выполнил студент ИСТб-20-2 Богатырёв Михаил Сергеевич");
                }
            });
            jMenuBar.add(jMenu);

        this.setJMenuBar(jMenuBar);
        this.add(jScrollPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(1000, 400);
        this.setVisible(true);
        JPanel p2 = new JPanel();
        p2.add(jLabel);
        p2.add(clear);
        p2.add(search);
        p2.add(buttonDelete);
        p2.add(addButton);
        this.add(p2, BorderLayout.SOUTH);
    }
}