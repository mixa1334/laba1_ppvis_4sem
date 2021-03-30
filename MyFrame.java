package laba1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {

    MyFrame() {
        super("MyFrame");

        add(new MyPanel("Pick", "Apple", "Samsung", "Meizu"));
        add(new MyPanel("Select", "Java", "C++", "1C"));
        add(new MyPanel("Add", "Mail.ru", "GMAIL", "Yahoo!"));
        add(new MyPanel("Take", "IPhone", "Galaxy s21", "Galaxy Fold"));
        add(new MyPanel("Choose", "VS Code", "Atom", "Sublime"));

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ctrl R"), "ctrl+R_Action");
        rootPane.getActionMap().put("ctrl+R_Action", new CtrlRAction());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        setVisible(true);
        setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 300,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 450,
                600, 900);
    }

    private class CtrlRAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            for (Component temp : getContentPane().getComponents()) {
                new GroupFrame((MyPanel) temp);
            }
            GroupFrame.run();
        }
    }
}
