package main.Java.App.components;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * A component to display images with various options
 */
public class ImagePanel extends JPanel {
    private Image image;
    private int radius = 0;
    private boolean maintainRatio = true;
    private boolean circle = false;
    
    public ImagePanel(String imagePath) {
        try {
            File file = new File("imagePath");
            if (!file.exists()) {
                System.out.println("Image file not found: " + imagePath);
                return;
            }
            
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            this.image = icon.getImage();
            setOpaque(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ImagePanel(Image image) {
        this.image = image;
        setOpaque(false);
    }
    
    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }
    
    public void setCircle(boolean circle) {
        this.circle = circle;
        repaint();
    }
    
    public void setMaintainRatio(boolean maintainRatio) {
        this.maintainRatio = maintainRatio;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (image == null) return;
        
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        
        // Calculate dimensions based on settings
        int imgWidth = width;
        int imgHeight = height;
        
        if (maintainRatio) {
            double imageRatio = (double) image.getWidth(null) / image.getHeight(null);
            double panelRatio = (double) width / height;
            
            if (imageRatio > panelRatio) {
                imgWidth = width;
                imgHeight = (int) (width / imageRatio);
            } else {
                imgHeight = height;
                imgWidth = (int) (height * imageRatio);
            }
        }
        
        // Position image in center
        int x = (width - imgWidth) / 2;
        int y = (height - imgHeight) / 2;
        
        if (circle) {
            // For circle, use the smaller dimension
            int size = Math.min(width, height);
            Shape clip = new java.awt.geom.Ellipse2D.Float(
                (width - size) / 2, 
                (height - size) / 2, 
                size, 
                size
            );
            g2d.setClip(clip);
            g2d.drawImage(image, x, y, imgWidth, imgHeight, null);
        } else if (radius > 0) {
            // For rounded corners
            Shape clip = new java.awt.geom.RoundRectangle2D.Float(
                0, 0, width, height, radius, radius
            );
            g2d.setClip(clip);
            g2d.drawImage(image, x, y, imgWidth, imgHeight, null);
        } else {
            // Regular image
            g2d.drawImage(image, x, y, imgWidth, imgHeight, null);
        }
        
        g2d.dispose();
    }
}