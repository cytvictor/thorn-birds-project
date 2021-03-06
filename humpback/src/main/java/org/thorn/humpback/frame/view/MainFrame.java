package org.thorn.humpback.frame.view;

import org.thorn.core.swing.GlobalSettingUtils;
import org.thorn.core.swing.ImageUtils;
import org.thorn.humpback.frame.service.Context;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: yfchenyun
 * @Since: 13-8-26 下午2:58
 * @Version: 1.0
 */
public class MainFrame extends JFrame {

    private JPanel contentPane;

    private JPanel bgPanel;

    public MainFrame() throws HeadlessException {
        super();

        Context.MAIN_FRAME = this;

        GlobalSettingUtils.initGlobalFontSetting(new Font("微软雅黑", Font.PLAIN, 13));

        this.setTitle("humpback");
        this.setIconImage(ImageUtils.getIconFromCls("/icons/humpback3.png").getImage());
        this.setBounds(300, 100, 620, 500);

        this.contentPane = new JPanel();
        this.setContentPane(this.contentPane);

        JMenuBar menuBar = new TopMenuBar();
        this.setJMenuBar(menuBar);

        bgPanel = new LogoPanel();
        contentPane.add(bgPanel);
    }

    public void setMainPane(JPanel contentPane) {

        Context.clearSelectedTags();

        this.contentPane.removeAll();
        this.contentPane.add(contentPane);
        this.contentPane.updateUI();
    }

    public void removeMainPane() {
        Context.clearSelectedTags();

        this.contentPane.removeAll();
        contentPane.add(bgPanel);
        this.contentPane.updateUI();
    }
}
