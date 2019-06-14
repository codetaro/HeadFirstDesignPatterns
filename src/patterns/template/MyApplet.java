package patterns.template;

import java.applet.Applet;
import java.awt.*;

public class MyApplet extends Applet {
    String message;

    @Override
    public void init() {
        message = "Hello World, I'm alive!";
        repaint();  // repaint()是Applet类的一个具体方法，可让applet的上层组件知道这个applet需要重绘
    }

    @Override
    public void start() {
        message = "Now I'm starting up...";
        repaint();
    }

    @Override
    public void stop() {
        message = "Oh, now I'm being stopped...";
        repaint();
    }

    @Override
    public void destroy() {
        // a hook, same as other overrides
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, 5, 15);
    }
}
