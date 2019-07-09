package patterns.proxy.cd;

import javax.swing.*;
import java.awt.*;

public class ImageIconReadyState implements State {
    ImageProxyRefactor imageProxy;

    public ImageIconReadyState(ImageProxyRefactor imageProxy) {
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconWidth() {
        return imageProxy.getImageIcon().getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return imageProxy.getImageIcon().getIconHeight();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        imageProxy.getImageIcon().paintIcon(c, g, x, y);
    }
}
