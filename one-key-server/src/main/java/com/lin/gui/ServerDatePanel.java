package com.lin.gui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sli on 12/1/2016.
 */
public class ServerDatePanel {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    private JPanel panel1;
    private JButton buttonQuickR_73;
    private JButton buttonQuickR_35;
    private JButton buttonQuickR;
    private JButton buttonQuickRA1;
    private JTextField textFieldR;
    private JButton buttonR_81;
    private JButton buttonR_80;
    private JButton buttonR_73;
    private JButton buttonR_63;
    private JButton buttonR_57;
    private JButton buttonR_48;


    private JButton buttonR_45;
    private JButton buttonR_35;
    private JButton buttonR_20;
    private JButton buttonR_1;
    private JButton buttonR;
    private JButton buttonRA1;
    private JButton buttonRA5;
    private JButton buttonRA15;
    private JButton buttonRA16;
    private JLabel labelServerTime;
    private JLabel labelR_81;



    private void  init(){
        //To enable text field lost focus when I click outside area of it
        panel1.setFocusable(true);

        textFieldR.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                resetOtherDates();
            }
        });
    }

    /**
     * Reset all other related date values based on R
     */
    private void resetOtherDates(){
        String r=textFieldR.getText();
        if(StringUtils.isNotEmpty(r)){
            try {
                Date rDate=DateUtils.parseDate(r,"yyyy/MM/DD");
                labelR_81.setText(sdf.format(DateUtils.addDays(rDate,-81)));

            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ServerDatePanel");
        ServerDatePanel serverDatePanel=new ServerDatePanel();
        frame.setContentPane(serverDatePanel.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        serverDatePanel.init();

        serverDatePanel.labelServerTime.setText("HEllO");
        serverDatePanel.textFieldR.setText("sssssssssss");

        frame.setVisible(true);


    }
}
