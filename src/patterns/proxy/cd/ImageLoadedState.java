package patterns.proxy.cd;

import java.awt.*;

public class ImageLoadedState implements State {
    ImageProxyRefactor proxyRefactor;

    public ImageLoadedState(ImageProxyRefactor proxyRefactor) {
        this.proxyRefactor = proxyRefactor;
    }

    @Override
    public int getIconWidth() {
        return proxyRefactor.getImageIcon().getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return proxyRefactor.getImageIcon().getIconHeight();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        proxyRefactor.getImageIcon().paintIcon(c, g, x, y);
    }
}
