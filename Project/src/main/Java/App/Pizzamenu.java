package main.Java.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.Java.App.theme.PizzaManiaTheme;
import main.Java.App.components.RoundedPanel;
import main.Java.App.components.ImagePanel;

public class Pizzamenu extends JFrame implements ActionListener {
    // Pizza prices
    private static final int VEG_PIZZA_PRICE = 200;
    private static final int NON_VEG_PIZZA_PRICE = 300;
    private static final int DELUX_VEG_PIZZA_PRICE = 300;
    private static final int DELUX_NON_VEG_PIZZA_PRICE = 350;
    private static final int EXTRA_CHEESE_PRICE = 100;
    private static final int EXTRA_TOPPINGS_PRICE = 150;
    private static final int TAKE_AWAY_PRICE = 20;
    
    // Components
    private RoundedPanel mainPanel, menuPanel, summaryPanel;
    private JLabel welcomeLabel, chooseLabel, priceLabel;
    private JComboBox<String> pizzaTypeCombo;
    private JCheckBox extraCheeseCheck, extraToppingsCheck, takeAwayCheck;
    private JButton orderButton, logoutButton;
    private JTextArea orderSummary;
    private ImagePanel pizzaImagePanel;
    
    private String userEmail;
    
    public Pizzamenu(String email) {
        this.userEmail = email;
        
        // Setup frame
        setTitle("Pizza Mania - Menu");
        PizzaManiaTheme.setupFrame(this);
        setLayout(new BorderLayout(15, 15));
        
        // Create panels
        mainPanel = new RoundedPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(PizzaManiaTheme.PANEL_BACKGROUND);
        
        // Header with welcome message
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        
        welcomeLabel = new JLabel("Welcome to Pizza Mania!");
        welcomeLabel.setFont(PizzaManiaTheme.HEADING_LARGE);
        welcomeLabel.setForeground(PizzaManiaTheme.PRIMARY_RED);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        chooseLabel = new JLabel("Choose your perfect pizza");
        chooseLabel.setFont(PizzaManiaTheme.BODY_REGULAR);
        chooseLabel.setForeground(PizzaManiaTheme.DARK_TEXT);
        
        JPanel welcomeTextPanel = new JPanel();
        welcomeTextPanel.setLayout(new BoxLayout(welcomeTextPanel, BoxLayout.Y_AXIS));
        welcomeTextPanel.setOpaque(false);
        welcomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        chooseLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeTextPanel.add(welcomeLabel);
        welcomeTextPanel.add(chooseLabel);
        
        // Logout button
        logoutButton = new JButton("Logout");
        PizzaManiaTheme.styleButton(logoutButton, false);
        logoutButton.addActionListener(this);
        
        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        logoutPanel.setOpaque(false);
        logoutPanel.add(logoutButton);
        
        headerPanel.add(welcomeTextPanel, BorderLayout.WEST);
        headerPanel.add(logoutPanel, BorderLayout.EAST);
        
        // Content panel with grid layout
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        contentPanel.setOpaque(false);
        
        // Left side - Menu options
        menuPanel = new RoundedPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        menuPanel.setBackground(Color.WHITE);
        
        // Pizza type selection
        JPanel pizzaTypePanel = new JPanel(new BorderLayout(0, 8));
        pizzaTypePanel.setOpaque(false);
        pizzaTypePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        
        JLabel pizzaTypeLabel = new JLabel("Select Pizza Type");
        pizzaTypeLabel.setFont(PizzaManiaTheme.HEADING_SMALL);
        pizzaTypeLabel.setForeground(PizzaManiaTheme.DARK_TEXT);
        
        String[] pizzaTypes = { "Veg Pizza", "Non-Veg Pizza", "Delux Veg Pizza", "Delux Non-Veg Pizza" };
        pizzaTypeCombo = new JComboBox<>(pizzaTypes);
        PizzaManiaTheme.styleComboBox(pizzaTypeCombo);
        pizzaTypeCombo.addActionListener(this);
        
        pizzaTypePanel.add(pizzaTypeLabel, BorderLayout.NORTH);
        pizzaTypePanel.add(pizzaTypeCombo, BorderLayout.CENTER);
        
        // Extra options panel
        JPanel extrasPanel = new JPanel();
        extrasPanel.setLayout(new BoxLayout(extrasPanel, BoxLayout.Y_AXIS));
        extrasPanel.setOpaque(false);
        extrasPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        
        JLabel extrasLabel = new JLabel("Extras & Add-ons");
        extrasLabel.setFont(PizzaManiaTheme.HEADING_SMALL);
        extrasLabel.setForeground(PizzaManiaTheme.DARK_TEXT);
        extrasLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        extrasLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        extraCheeseCheck = new JCheckBox("Extra Cheese (+₹" + EXTRA_CHEESE_PRICE + ")");
        PizzaManiaTheme.styleCheckBox(extraCheeseCheck);
        extraCheeseCheck.setAlignmentX(Component.LEFT_ALIGNMENT);
        extraCheeseCheck.addActionListener(this);
        
        extraToppingsCheck = new JCheckBox("Extra Toppings (+₹" + EXTRA_TOPPINGS_PRICE + ")");
        PizzaManiaTheme.styleCheckBox(extraToppingsCheck);
        extraToppingsCheck.setAlignmentX(Component.LEFT_ALIGNMENT);
        extraToppingsCheck.addActionListener(this);
        
        takeAwayCheck = new JCheckBox("Take Away (+₹" + TAKE_AWAY_PRICE + ")");
        PizzaManiaTheme.styleCheckBox(takeAwayCheck);
        takeAwayCheck.setAlignmentX(Component.LEFT_ALIGNMENT);
        takeAwayCheck.addActionListener(this);
        
        extrasPanel.add(extrasLabel);
        extrasPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        extrasPanel.add(extraCheeseCheck);
        extrasPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        extrasPanel.add(extraToppingsCheck);
        extrasPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        extrasPanel.add(takeAwayCheck);
        
        // Price panel
        JPanel pricePanel = new JPanel(new BorderLayout());
        pricePanel.setOpaque(false);
        pricePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        
        priceLabel = new JLabel("Total: ₹" + VEG_PIZZA_PRICE);
        priceLabel.setFont(PizzaManiaTheme.HEADING_MEDIUM);
        priceLabel.setForeground(PizzaManiaTheme.PRIMARY_RED);
        
        pricePanel.add(priceLabel, BorderLayout.WEST);
        
        // Order button
        orderButton = new JButton("Place Order");
        PizzaManiaTheme.styleButton(orderButton, true);
        orderButton.addActionListener(this);
        
        JPanel orderButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        orderButtonPanel.setOpaque(false);
        orderButtonPanel.add(orderButton);
        
        // Add all panels to menu panel
        menuPanel.add(pizzaTypePanel);
        menuPanel.add(extrasPanel);
        menuPanel.add(pricePanel);
        menuPanel.add(orderButtonPanel);
        
        // Right side - Pizza image and summary
        summaryPanel = new RoundedPanel(new BorderLayout(0, 15));
        summaryPanel.setBackground(Color.WHITE);
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Pizza image
        try {
            String imagePath = "/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/Images/0238e1d8-09ae-4bfd-a506-edd260a59d1c-removebg-preview.png";
            File imageFile = new File(imagePath);
            
            if (imageFile.exists()) {
                ImageIcon pizzaIcon = new ImageIcon(imageFile.getAbsolutePath());
                Image pizzaImage = pizzaIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
                pizzaImagePanel = new ImagePanel(pizzaImage);
                pizzaImagePanel.setPreferredSize(new Dimension(250, 250));
                
                JPanel imageContainerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                imageContainerPanel.setOpaque(false);
                imageContainerPanel.add(pizzaImagePanel);
                
                summaryPanel.add(imageContainerPanel, BorderLayout.NORTH);
            } else {
                System.out.println("Pizza image not found at: " + imagePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Order summary
        JPanel summaryTextPanel = new JPanel(new BorderLayout());
        summaryTextPanel.setOpaque(false);
        
        JLabel summaryLabel = new JLabel("Order Summary");
        summaryLabel.setFont(PizzaManiaTheme.HEADING_SMALL);
        summaryLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        orderSummary = new JTextArea(5, 20);
        orderSummary.setEditable(false);
        orderSummary.setFont(PizzaManiaTheme.BODY_REGULAR);
        orderSummary.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        orderSummary.setText("Your order details will appear here...");
        
        summaryTextPanel.add(summaryLabel, BorderLayout.NORTH);
        summaryTextPanel.add(orderSummary, BorderLayout.CENTER);
        
        summaryPanel.add(summaryTextPanel, BorderLayout.CENTER);
        
        // Add menu and summary panels to content
        contentPanel.add(menuPanel);
        contentPanel.add(summaryPanel);
        
        // Add all to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        // Add main panel to frame
        add(mainPanel, BorderLayout.CENTER);
        
        // Update price and summary on startup
        updatePriceAndSummary();
        
        // Set frame properties
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void updatePriceAndSummary() {
        String selectedPizza = (String) pizzaTypeCombo.getSelectedItem();
        boolean hasExtraCheese = extraCheeseCheck.isSelected();
        boolean hasExtraToppings = extraToppingsCheck.isSelected();
        boolean hasTakeAway = takeAwayCheck.isSelected();
        
        // Calculate base price
        int basePrice = 0;
        if (selectedPizza.equals("Veg Pizza")) {
            basePrice = VEG_PIZZA_PRICE;
        } else if (selectedPizza.equals("Non-Veg Pizza")) {
            basePrice = NON_VEG_PIZZA_PRICE;
        } else if (selectedPizza.equals("Delux Veg Pizza")) {
            basePrice = DELUX_VEG_PIZZA_PRICE;
        } else if (selectedPizza.equals("Delux Non-Veg Pizza")) {
            basePrice = DELUX_NON_VEG_PIZZA_PRICE;
        }
        
        // Add extras
        int totalPrice = basePrice;
        if (hasExtraCheese) {
            totalPrice += EXTRA_CHEESE_PRICE;
        }
        if (hasExtraToppings) {
            totalPrice += EXTRA_TOPPINGS_PRICE;
        }
        if (hasTakeAway) {
            totalPrice += TAKE_AWAY_PRICE;
        }
        
        // Update price label
        priceLabel.setText("Total: ₹" + totalPrice);
        
        // Update summary
        StringBuilder summary = new StringBuilder();
        summary.append("Order Summary\n\n");
        summary.append("Pizza: ").append(selectedPizza).append(" (₹").append(basePrice).append(")\n");
        
        if (hasExtraCheese) {
            summary.append("Extra Cheese: Yes (+₹").append(EXTRA_CHEESE_PRICE).append(")\n");
        }
        if (hasExtraToppings) {
            summary.append("Extra Toppings: Yes (+₹").append(EXTRA_TOPPINGS_PRICE).append(")\n");
        }
        if (hasTakeAway) {
            summary.append("Take Away: Yes (+₹").append(TAKE_AWAY_PRICE).append(")\n");
        }
        
        summary.append("\nTotal Price: ₹").append(totalPrice);
        
        orderSummary.setText(summary.toString());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pizzaTypeCombo || 
            ae.getSource() == extraCheeseCheck || 
            ae.getSource() == extraToppingsCheck || 
            ae.getSource() == takeAwayCheck) {
            
            updatePriceAndSummary();
            
            // Show appropriate message for pizza selection
            if (ae.getSource() == pizzaTypeCombo) {
                String selectedPizza = (String) pizzaTypeCombo.getSelectedItem();
                if (selectedPizza.equals("Veg Pizza")) {
                    JOptionPane.showMessageDialog(
                        this, 
                        "You selected Veg Pizza. Enjoy your green delight!",
                        "Pizza Selection",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else if (selectedPizza.equals("Non-Veg Pizza")) {
                    JOptionPane.showMessageDialog(
                        this, 
                        "Non-Veg Pizza selected. Meaty and delicious!",
                        "Pizza Selection",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else if (selectedPizza.equals("Delux Veg Pizza")) {
                    JOptionPane.showMessageDialog(
                        this, 
                        "Delux Veg Pizza — loaded with extra veggies!",
                        "Pizza Selection",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else if (selectedPizza.equals("Delux Non-Veg Pizza")) {
                    JOptionPane.showMessageDialog(
                        this, 
                        "Delux Non-Veg Pizza — top-tier indulgence!",
                        "Pizza Selection",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
        
        if (ae.getSource() == orderButton) {
            String selectedPizza = (String) pizzaTypeCombo.getSelectedItem();
            boolean hasExtraCheese = extraCheeseCheck.isSelected();
            boolean hasExtraToppings = extraToppingsCheck.isSelected();
            boolean hasTakeAway = takeAwayCheck.isSelected();
            
            // Calculate total
            int totalPrice = 0;
            if (selectedPizza.equals("Veg Pizza")) {
                totalPrice += VEG_PIZZA_PRICE;
            } else if (selectedPizza.equals("Non-Veg Pizza")) {
                totalPrice += NON_VEG_PIZZA_PRICE;
            } else if (selectedPizza.equals("Delux Veg Pizza")) {
                totalPrice += DELUX_VEG_PIZZA_PRICE;
            } else if (selectedPizza.equals("Delux Non-Veg Pizza")) {
                totalPrice += DELUX_NON_VEG_PIZZA_PRICE;
            }
            
            if (hasExtraCheese) {
                totalPrice += EXTRA_CHEESE_PRICE;
            }
            if (hasExtraToppings) {
                totalPrice += EXTRA_TOPPINGS_PRICE;
            }
            if (hasTakeAway) {
                totalPrice += TAKE_AWAY_PRICE;
            }
            
            // Prepare extra items description
            StringBuilder extraItems = new StringBuilder();
            if (hasExtraCheese) {
                extraItems.append("Extra Cheese ");
            }
            if (hasExtraToppings) {
                extraItems.append("Extra Toppings ");
            }
            if (hasTakeAway) {
                extraItems.append("Take Away ");
            }
            
            // Show confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Confirm your order?\n\n" + orderSummary.getText(),
                "Order Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    DatabaseConnectivity conn = new DatabaseConnectivity();
                
                    // Step 1: Fetch CustomerID using the email
                    String fetchQuery = "SELECT CustomerID FROM Registration WHERE Email = ?";
                    PreparedStatement fetchStmt = conn.conn.prepareStatement(fetchQuery);
                    fetchStmt.setString(1, userEmail);
                    ResultSet rs = fetchStmt.executeQuery();
            
                    int customerId = -1;
                    if (rs.next()) {
                        customerId = rs.getInt("CustomerID");
                    }
            
                    // Step 2: Insert into PizzaInformation if CustomerID found
                    if (customerId != -1) {
                        String insertQuery = "INSERT INTO PizzaInformation (CustomerID, Email, PizzaType, ExtraThings, TotalAmt) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement insertStmt = conn.conn.prepareStatement(insertQuery);
                        insertStmt.setInt(1, customerId);
                        insertStmt.setString(2, userEmail);
                        insertStmt.setString(3, selectedPizza);
                        insertStmt.setString(4, extraItems.toString());
                        insertStmt.setInt(5, totalPrice);
            
                        insertStmt.executeUpdate();
                        
                        // Show success message with animated icon
                        ImageIcon icon = null;
                        try {
                            String logoPath = "/home/ashutosh/Desktop/PizzaMania/PizzaMania/Project/src/main/Java/App/Images/0238e1d8-09ae-4bfd-a506-edd260a59d1c-removebg-preview.png";
                            File logoFile = new File(logoPath);
                            
                            if (logoFile.exists()) {
                                ImageIcon logoIcon = new ImageIcon(logoFile.getAbsolutePath());
                                Image logoImage = logoIcon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                                icon = new ImageIcon(logoImage);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        
                        JOptionPane.showMessageDialog(
                            this,
                            "Your order has been placed successfully!\n" +
                            "Your delicious pizza is on its way.",
                            "Order Confirmed",
                            JOptionPane.INFORMATION_MESSAGE,
                            icon
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                            this,
                            "Customer ID not found for email: " + userEmail,
                            "Order Error",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Error saving your order. Please try again.",
                        "Order Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    e.printStackTrace();
                }
            }
        }
        
        if (ae.getSource() == logoutButton) {
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION
            );
            
            if (confirm == JOptionPane.YES_OPTION) {
                setVisible(false);
                new LoginPage().setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String email = "user@example.com"; 
        SwingUtilities.invokeLater(() -> new Pizzamenu(email).setVisible(true));
    }
}