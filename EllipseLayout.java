package laba1;

import java.awt.*;


public class EllipseLayout implements LayoutManager {

    public void addLayoutComponent(String name, Component comp) {
    }

    public void layoutContainer(Container parent) {
        int x, y, width, height;
        int numberOfComponents = parent.getComponentCount();
        Insets insets = parent.getInsets();
        int centerX = (parent.getSize().width - (insets.left + insets.right)) / 2;
        int centerY = (parent.getSize().height - (insets.top + insets.bottom)) / 2;

        Component component;
        Dimension dimension;

        for (int current = 0; current < numberOfComponents; current++) {
            component = parent.getComponent(current);
            dimension = component.getPreferredSize();
            x = (int) ((centerX * 0.75) * Math.cos(2 * current * Math.PI / numberOfComponents)) + centerX;
            y = (int) ((centerY * 0.75) * Math.sin(2 * current * Math.PI / numberOfComponents)) + centerY;
            width = dimension.width;
            height = dimension.height;
            component.setBounds(x - width / 2, y - height / 2, width, height);
        }

    }

    public Dimension preferredLayoutSize(Container target) {
        return target.getSize();
    }

    public Dimension minimumLayoutSize(Container target) {
        return target.getSize();
    }

    public void removeLayoutComponent(Component comp) {
    }

    public String toString() {
        return this.getClass().getName();
    }

}