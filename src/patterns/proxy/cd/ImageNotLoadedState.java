package patterns.proxy.cd;

import javax.swing.*;
import java.awt.*;

public class ImageNotLoadedState implements State {
    ImageProxyRefactor proxyRefactor;

    public ImageNotLoadedState(ImageProxyRefactor proxyRefactor) {
        this.proxyRefactor = proxyRefactor;
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public int getIconHeight() {
        return 600;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
        Thread retrievalThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    proxyRefactor.setImageIcon(
                            new ImageIcon(proxyRefactor.getImageURL(), "CD Cover"));
                    proxyRefactor.setState(proxyRefactor.getImageLoadedState());
                    c.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        retrievalThread.start();
    }
}
