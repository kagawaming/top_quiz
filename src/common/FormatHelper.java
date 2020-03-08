package common;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;


/**
 * FormatHelper contains static functions for formatting
 */
public class FormatHelper {
    //set title format
    public static Font setTitleFont(int size){
        Font font = new Font(Font.SERIF, Font.BOLD | Font.ITALIC, size);
        return font;
    }

    //set text format
    public static Font setTextFont(int size){
        Font font = new Font(Font.SERIF, Font.PLAIN, size);
        return font;
    }

    //set main pane format
    public static void setMainPanelBorder(JPanel panel, String title){
        TitledBorder border = new TitledBorder(title);
        border.setTitleFont(FormatHelper.setTitleFont(20));
        panel.setBorder(border);
    }

    //set image format
    public static JLabel setImageLabel(int width, int height, String path){
        JLabel imageLabel = new JLabel();
        File imageFile = new File(path);
        if(!imageFile.exists())
            return imageLabel;
        ImageIcon imageIcon =  resizeImageIcon(width, height, path);
        imageLabel.setIcon(imageIcon);
        return imageLabel;
    }

    //resize image to same size
    public static ImageIcon resizeImageIcon(int width, int height, String path) {
        ImageIcon originalImageIcon = new ImageIcon(path);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        return resizedImageIcon;
    }

    //set component height
    public static void setHeight(JComponent component, int height) {
        Dimension d = component.getPreferredSize();
        d.height = height;
        component.setPreferredSize(d);
    }

    //set component width
    public static void setWidth(JComponent component, int width) {
        Dimension d = component.getPreferredSize();
        d.width = width;
        component.setPreferredSize(d);
    }

    //set border title
    public static Font getBorderTitleFont(int fontSize){
        Font font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, fontSize);
        return font;
    }

    //set font
    public static Font getFormatFont(int mode, int size){
        Font font = new Font("Times New Roman", Font.PLAIN | mode, size);
        return font;
    }

    //set sub pane format
    public static void setSubPanelBorder(JPanel panel, String title){
        TitledBorder border = new TitledBorder(title);
        border.setTitleFont(getBorderTitleFont(18));
        panel.setBorder(border);
    }

}
