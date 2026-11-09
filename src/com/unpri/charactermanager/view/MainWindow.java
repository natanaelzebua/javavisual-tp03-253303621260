package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private List<Character> characterList;
    private JPanel mainPanel;
    private JLabel statsLabel;

    public MainWindow(CharacterManager manager) {
        this.characterList = manager.getAllCharacters(); // Mengambil data dari manager

        // Pengaturan Jendela Utama
        setTitle("Character Manager - Sprint #3");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panggil initComponents
        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Judul dengan jumlah karakter dinamis
        JLabel titleLabel = new JLabel("=== Daftar Karakter (" + characterList.size() + ") ===");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        mainPanel.add(titleLabel);

        // Loop setiap Character untuk membuat JLabel masing-masing
        for (Character c : characterList) {
            String info = "- " + c.getName() + " | " + c.getType() +
                          " | Lv." + c.getLevel() +
                          " | HP:" + c.getHitPoints() +
                          " | ATK:" + c.getAttackPower();
            JLabel characterLabel = new JLabel(info);
            characterLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
            characterLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 4, 0));
            mainPanel.add(characterLabel);
        }

        // Kalkulasi statistik rata-rata level untuk Mini-Challenge
        double totalLevel = 0;
        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }
        double avgLevel = characterList.isEmpty() ? 0 : totalLevel / characterList.size();

        statsLabel = new JLabel(String.format("Rata-rata Level: %.2f", avgLevel));
        statsLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        statsLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        mainPanel.add(statsLabel);

        // Bungkus dengan JScrollPane agar rapi dan bisa di-scroll
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane);
    }
}