package dezbyte.engine.io;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Input extends JComponent {

    boolean[] map;

    public Input()
    {
        this.map = new boolean[256];

        for (int i = 0; i < map.length; i++) {

            final int KEY_CODE = i;

            this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i, 0, false), i);
            this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i, 0, true), ~i);

            this.getActionMap().put(i, new AbstractAction() {
                public void actionPerformed(ActionEvent actionEvent)
                {
                    Input.this.map[KEY_CODE] = true;
                }
            });

            this.getActionMap().put(~i, new AbstractAction() {
                public void actionPerformed(ActionEvent actionEvent)
                {
                    Input.this.map[KEY_CODE] = false;
                }
            });

        }
    }

    public boolean getKey(int keyCode)
    {
        return this.map[keyCode];
    }

    public boolean getUp()
    {
        return this.getKey(KeyEvent.VK_UP);
    }

    public boolean getDown()
    {
        return this.getKey(KeyEvent.VK_DOWN);
    }

    public boolean getLeft()
    {
        return this.getKey(KeyEvent.VK_LEFT);
    }

    public boolean getRight()
    {
        return this.getKey(KeyEvent.VK_RIGHT);
    }

}
