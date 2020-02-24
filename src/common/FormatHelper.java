package util;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;

public class FormatHelper {
    public static Font setTitleFont(int size){
        Font font = new Font(Font.SERIF, Font.BOLD | Font.ITALIC, size);
        return font;
    }

    public static Font setTextFont(int size){
        Font font = new Font(Font.SERIF, Font.PLAIN, size);
        return font;
    }

    public static void setMainPanelBorder(JPanel panel, String title){
        TitledBorder border = new TitledBorder(title);
        border.setTitleFont(FormatHelper.setTitleFont(20));
        panel.setBorder(border);
    }

    public static JLabel setImageLabel(int width, int height, String path){
        JLabel imageLabel = new JLabel();
        File imageFile = new File(path);
        if(!imageFile.exists())
            return imageLabel;
        ImageIcon imageIcon =  resizeImageIcon(width, height, path);
        imageLabel.setIcon(imageIcon);
        return imageLabel;
    }

    public static ImageIcon resizeImageIcon(int width, int height, String path) {
        ImageIcon originalImageIcon = new ImageIcon(path);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        return resizedImageIcon;
    }

    public static void setHeight(JComponent component, int height) {
        Dimension d = component.getPreferredSize();
        d.height = height;
        component.setPreferredSize(d);
    }

    public static void setWidth(JComponent component, int width) {
        Dimension d = component.getPreferredSize();
        d.width = width;
        component.setPreferredSize(d);
    }

}
