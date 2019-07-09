package patterns.proxy.cd;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxyRefactor implements Icon {
    ImageIcon imageIcon;  // 此imageIcon是我们希望在加载后显示出来的真正的图像
    URL imageURL;
    Thread retrievalThread;
    boolean retrieving = false;

    State notReady;
    State ready;

    State state;

    public ImageProxyRefactor(URL imageURL) {
        notReady = new ImageIconNotReadyState(this);
        ready = new ImageIconReadyState(this);
        this.imageURL = imageURL;  // 这是我们希望显示的图像所在的位置
    }

    /* 图像加载完毕前，返回默认的宽和高。图像加载完毕后，转给imageIcon处理。 */
    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
            if (!retrieving) {
                retrieving = true;
                // 用另一个线程取出图像（我们不希望挂起整个用户界面）
                retrievalThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 加载图像和ImageIcon是同步的（sync），只有在加载完之后，ImageIcon的构造器才会返回
                            imageIcon = new ImageIcon(imageURL, "CD Cover");
                            // 当图像准备好时，我们告诉Swing，需要重绘
                            c.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                retrievalThread.start();
            }
        }
    }

    /* Getters & Setters */
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
