package lesson4.gui;

import lesson4.service.BaseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

public class ChatGui extends JFrame {
    BaseService baseService = new BaseService();


    public ChatGui() throws HeadlessException {
        setTitle("Chat Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        jMenuBar.add(m1);
        jMenuBar.add(m2);

        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m12 = new JMenuItem("Save");
        m1.add(m11);
        m1.add(m12);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setFocusable(false);

        JPanel jPanel = new JPanel();
        JTextField tf = new JTextField(10);
        tf.setFocusable(true);

        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getText(tf, jTextArea);

            }
        });


        tf.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {


                if (e.getKeyCode() == KeyEvent.VK_ENTER) {


                    getText(tf, jTextArea);


                }
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jTextArea.setText(null);
                tf.requestFocus();

            }
        });


        jPanel.add(tf);
        jPanel.add(sendButton);
        jPanel.add(resetButton);


        getContentPane().add(BorderLayout.NORTH, jMenuBar);
        getContentPane().add(BorderLayout.CENTER, jTextArea);
        getContentPane().add(BorderLayout.SOUTH, jPanel);

        setVisible(true);


    }

    private void getText(JTextField tf, JTextArea jTextArea) {
        if (tf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(ChatGui.this,
                    "Введите сообщение!");
        } else {
            jTextArea.append("Пользователь " + new Date().toString() + ": " + tf.getText() + "\n");
            tf.setText(null);
            tf.requestFocus();
            tf.setFocusable(true);

        }
    }
}
