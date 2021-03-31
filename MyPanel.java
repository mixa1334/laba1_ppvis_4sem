package laba1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    private final JCheckBox jCheckBox1, jCheckBox2, jCheckBox3;
    private final JTextField jTextField;

    MyPanel(final String nameOfButton, final String nameOfCheckBox1,
            final String nameOfCheckBox2, final String nameOfCheckBox3) {
        JButton jButton;
        jCheckBox1 = new JCheckBox(nameOfCheckBox1);
        jCheckBox2 = new JCheckBox(nameOfCheckBox2);
        jCheckBox3 = new JCheckBox(nameOfCheckBox3);
        jButton = new JButton(nameOfButton);
        jButton.addActionListener(this);
        jTextField = new JTextField();
        jTextField.setText(nameOfCheckBox1);

        setLayout(new GridLayout(5, 1));
        add(jCheckBox1);
        add(jCheckBox2);
        add(jCheckBox3);
        add(jTextField);
        add(jButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jTextField.getText().equals(jCheckBox1.getText())) {
            jCheckBox1.doClick();
        } else if (jTextField.getText().equals(jCheckBox2.getText())) {
            jCheckBox2.doClick();
        } else if (jTextField.getText().equals(jCheckBox3.getText())) {
            jCheckBox3.doClick();
        } else {
            JOptionPane.showMessageDialog(this, "There is no \"" + jTextField.getText() + "\"");
        }
    }
}