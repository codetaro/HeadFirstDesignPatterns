package patterns.compound.dj;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 模型的视图和用户界面控制的视图显示在两个窗口，但是属于同一个class
 */
public class DJView implements ActionListener, BeatObserver, BPMObserver {
    BeatModelInterface model;
    ControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
    BeatBar beatBar;
    JLabel bpmOutputLabel;

    public DJView(ControllerInterface controller, BeatModelInterface model) {
        this.controller = controller;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void updateBPM() {

    }

    @Override
    public void updateBeat() {

    }
}
