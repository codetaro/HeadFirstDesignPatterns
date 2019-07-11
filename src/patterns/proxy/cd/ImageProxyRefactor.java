package patterns.proxy.cd;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxyRefactor implements Icon {

    State imageNotLoadedState;
    State imageLoadedState;

    State state;
    ImageIcon imageIcon;
    URL imageURL;

    public ImageProxyRefactor(URL imageURL) {
        imageNotLoadedState = new ImageNotLoadedState(this);
        imageLoadedState = new ImageLoadedState(this);

        this.imageURL = imageURL;  // 这是我们希望显示的图像所在的位置
        state = imageNotLoadedState;
    }

    /* 图像加载完毕前，返回默认的宽和高。图像加载完毕后，转给imageIcon处理。 */
    @Override
    public int getIconWidth() {
        return state.getIconHeight();
    }

    @Override
    public int getIconHeight() {
        return state.getIconHeight();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        state.paintIcon(c, g, x, y);
    }

    /* Getters & Setters */
    public State getImageNotLoadedState() {
        return imageNotLoadedState;
    }

    public void setImageNotLoadedState(State imageNotLoadedState) {
        this.imageNotLoadedState = imageNotLoadedState;
    }

    public State getImageLoadedState() {
        return imageLoadedState;
    }

    public void setImageLoadedState(State imageLoadedState) {
        this.imageLoadedState = imageLoadedState;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public URL getImageURL() {
        return imageURL;
    }

    public void setImageURL(URL imageURL) {
        this.imageURL = imageURL;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
