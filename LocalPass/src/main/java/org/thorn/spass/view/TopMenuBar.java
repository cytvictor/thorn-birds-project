package org.thorn.spass.view;

import org.thorn.core.context.SpringContext;
import org.thorn.qrcode.listener.LoadQrPanelAction;
import org.thorn.reader.listener.LoadReaderPanelAction;
import org.thorn.spass.listener.*;
import org.thorn.spass.service.LocationService;

import javax.swing.*;

/**
 * @Author: yfchenyun
 * @Since: 13-8-28 下午1:35
 * @Version: 1.0
 */
public class TopMenuBar extends JMenuBar {

    private JMenu startMenu;

    private JMenu helpMenu;

    private JMenu operationMenu;

    private JMenu toolMenu;

    public TopMenuBar() {
        super();

        startMenu = new JMenu();
        startMenu.setText("菜单");

        JMenuItem menuItem = new JMenuItem();
        menuItem.setText("创建新密码本...    ");
        menuItem.addActionListener(new NoteMenuAction(null, true));
        startMenu.add(menuItem);

        startMenu.addSeparator();

        menuItem = new JMenuItem();
        menuItem.setText("打开密码本...    ");
        menuItem.addActionListener(new NoteMenuAction(null, false));
        startMenu.add(menuItem);

        JMenu recentNote = new JMenu();
        recentNote.setText("打开最近密码本    ");

        LocationService locationService = SpringContext.getBean(LocationService.class);
        String[] recentNotes = locationService.getRecentNotes();

        for (String note : recentNotes) {
            menuItem = new JMenuItem();
            menuItem.setText(note);
            menuItem.addActionListener(new NoteMenuAction(note, false));
            recentNote.add(menuItem);
        }
        startMenu.add(recentNote);
        startMenu.addSeparator();

        menuItem = new JMenuItem();
        menuItem.setText("设置密码本目录...    ");
        menuItem.addActionListener(new OpenNotesFolderSettingAction());
        startMenu.add(menuItem);
        startMenu.addSeparator();

        menuItem = new JMenuItem();
        menuItem.setText("退出");
        menuItem.addActionListener(new ExitAction(MFrame.MAIN_FRAME));
        startMenu.add(menuItem);

        this.add(startMenu);

        toolMenu = new JMenu();
        toolMenu.setText("工具");

        menuItem = new JMenuItem();
        menuItem.setText("电子书转换    ");
        menuItem.addActionListener(new LoadReaderPanelAction());
        toolMenu.add(menuItem);

        toolMenu.addSeparator();

        menuItem = new JMenuItem();
        menuItem.setText("二维码生成    ");
        menuItem.addActionListener(new LoadQrPanelAction());
        toolMenu.add(menuItem);

        this.add(toolMenu);

        helpMenu = new JMenu();
        helpMenu.setText("帮助");
        menuItem = new JMenuItem();
        menuItem.setText("关于LocalPass");
        helpMenu.add(menuItem);

        this.add(helpMenu);
    }

    public void addOperationMenus() {

        if(this.operationMenu != null) {
            return ;
        }

        operationMenu = new JMenu();
        operationMenu.setText("操作");

        JMenuItem menuItem = new JMenuItem();
        menuItem.setText("添加账号...    ");
        menuItem.addActionListener(new OpenAccountDialogAction());
        operationMenu.add(menuItem);

        operationMenu.addSeparator();

        menuItem = new JMenuItem();
        menuItem.setText("修改密码...    ");
        menuItem.addActionListener(new OpenModifyPwdAction());
        operationMenu.add(menuItem);

        operationMenu.addSeparator();

        menuItem = new JMenuItem();
        menuItem.setText("注销    ");
        menuItem.addActionListener(new LogoutAction());
        operationMenu.add(menuItem);

        this.removeAll();
        this.add(startMenu);
        this.add(operationMenu);
        this.add(toolMenu);
        this.add(helpMenu);
    }

    public void removeOperationMenus() {
        this.operationMenu = null;
        this.removeAll();
        this.add(startMenu);
        this.add(toolMenu);
        this.add(helpMenu);
    }

}
