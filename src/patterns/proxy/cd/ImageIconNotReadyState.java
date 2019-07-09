package patterns.proxy.cd;

import java.awt.*;

public class ImageIconNotReadyState implements State {
    ImageProxyRefactor imageProxy;

    public ImageIconNotReadyState(ImageProxyRefactor imageProxy) {
        this.imageProxy = imageProxy;
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
//                    imageProxy.setState();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
