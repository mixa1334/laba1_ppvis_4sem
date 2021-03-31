package laba1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GroupFrame extends JFrame {
    private static int current = 0;
    private static final ArrayList<GroupFrame> allFrames = new ArrayList<>(5);
    private static final Timer timer = new Timer(1000, e -> {
        for (GroupFrame temp : allFrames) {
            temp.setVisible(false);
        }
        allFrames.get(current == allFrames.size() ? current = 0 : current).setVisible(true);
        ++current;
    });


    GroupFrame(MyPanel panel) {
        int x = 50;
        int size = 200;
        if (!allFrames.isEmpty()) {
            x = allFrames.get(allFrames.size() - 1).getX() + x + size;
        }
        setBounds(x, 50, size, size);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        allFrames.add(this);
        setVisible(true);

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ctrl S"), "ctrl+S_Action");
        rootPane.getActionMap().put("ctrl+S_Action", new CtrlSAction());
    }

    public static void run() {
        if (!allFrames.isEmpty()) {
            timer.start();
        }
    }

    private static class CtrlSAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (timer.isRunning()) {
                timer.stop();
            } else {
                timer.start();
            }
        }
    }
}
