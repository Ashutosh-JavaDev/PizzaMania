package main.Java.App.theme;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Custom theme class for Pizza Mania application
 * Provides consistent styling across all application screens
 */
public class PizzaManiaTheme {
    // Color scheme
    public static final Color PRIMARY_RED = new Color(227, 38, 54);
    public static final Color SECONDARY_RED = new Color(196, 30, 58);
    public static final Color ACCENT_YELLOW = new Color(255, 195, 0);
    public static final Color LIGHT_YELLOW = new Color(255, 236, 179);
    public static final Color DARK_TEXT = new Color(51, 51, 51);
    public static final Color LIGHT_TEXT = new Color(250, 250, 250);
    public static final Color BACKGROUND = new Color(252, 252, 252);
    public static final Color PANEL_BACKGROUND = new Color(255, 255, 255);
    
    // Fonts
    public static final Font HEADING_LARGE = new Font("Segoe UI", Font.BOLD, 28);
    public static final Font HEADING_MEDIUM = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font HEADING_SMALL = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font BODY_BOLD = new Font("Segoe UI", Font.BOLD, 14);
    public static final Font BODY_REGULAR = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font BODY_SMALL = new Font("Segoe UI", Font.PLAIN, 12);
    
    /**
     * Applies theme to a button
     */
    public static void styleButton(JButton button, boolean isPrimary) {
        button.setFont(BODY_BOLD);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        
        if (isPrimary) {
            button.setBackground(PRIMARY_RED);
            button.setForeground(LIGHT_TEXT);
        } else {
            button.setBackground(LIGHT_YELLOW);
            button.setForeground(DARK_TEXT);
        }
        
        // Round corners
        button.setBorder(new EmptyBorder(8, 16, 8, 16));
        button.setOpaque(true);
        
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (isPrimary) {
                    button.setBackground(SECONDARY_RED);
                } else {
                    button.setBackground(ACCENT_YELLOW);
                }
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (isPrimary) {
                    button.setBackground(PRIMARY_RED);
                } else {
                    button.setBackground(LIGHT_YELLOW);
                }
            }
        });
    }
    
    /**
     * Applies theme to a text field
     */
    public static void styleTextField(JTextField textField) {
        textField.setFont(BODY_REGULAR);
        textField.setBackground(PANEL_BACKGROUND);
        textField.setForeground(DARK_TEXT);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
    }
    
    /**
     * Applies theme to a password field
     */
    public static void stylePasswordField(JPasswordField passwordField) {
        passwordField.setFont(BODY_REGULAR);
        passwordField.setBackground(PANEL_BACKGROUND);
        passwordField.setForeground(DARK_TEXT);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
    }
    
    /**
     * Applies theme to a label
     */
    public static void styleLabel(JLabel label, boolean isHeading) {
        if (isHeading) {
            label.setFont(HEADING_SMALL);
        } else {
            label.setFont(BODY_REGULAR);
        }
        label.setForeground(DARK_TEXT);
    }
    
    /**
     * Applies theme to a checkbox
     */
    public static void styleCheckBox(JCheckBox checkBox) {
        checkBox.setFont(BODY_REGULAR);
        checkBox.setForeground(DARK_TEXT);
        checkBox.setBackground(PANEL_BACKGROUND);
        checkBox.setFocusPainted(false);
        
        // Add hover effect
        checkBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                checkBox.setForeground(PRIMARY_RED);
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                checkBox.setForeground(DARK_TEXT);
            }
        });
    }
    
    /**
     * Applies theme to a combo box
     */
    public static void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setFont(BODY_REGULAR);
        comboBox.setBackground(PANEL_BACKGROUND);
        comboBox.setForeground(DARK_TEXT);
        comboBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
    }
    
    /**
     * Creates a styled panel with a title
     */
    public static JPanel createStyledPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(PANEL_BACKGROUND);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        if (title != null && !title.isEmpty()) {
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(HEADING_SMALL);
            titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            panel.add(titleLabel, BorderLayout.NORTH);
        }
        
        return panel;
    }
    
    /**
     * Sets up frame defaults
     */
    public static void setupFrame(JFrame frame) {
        frame.getContentPane().setBackground(BACKGROUND);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Center on screen
        frame.setLocationRelativeTo(null);
        
        // Add a little padding around the content
        ((JPanel)frame.getContentPane()).setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );
    }
}