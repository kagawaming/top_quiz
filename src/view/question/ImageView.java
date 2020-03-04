package view.question;

import util.FormatHelper;

import javax.swing.*;
import java.awt.*;

public class ImageView extends JLabel {

    public ImageView() {

        setSize(150, 150);
        setImage("src/resources/pics/1.jpeg");

    }

    public void setImage(String imagePath) {
        ImageIcon newImageIcon = FormatHelper.resizeImageIcon(150, 120, imagePath);
        setIcon(newImageIcon);
        setVisible(true);
    }
}
