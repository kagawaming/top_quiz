package view.question;

import util.FormatHelper;

import javax.swing.*;

public class ImageView extends JLabel {

    public ImageView() {

        setSize(150, 150);
        setImage("src/resources/pics/0.jpeg");
    }

    public void setImage(String imagePath) {
        ImageIcon newImageIcon = FormatHelper.resizeImageIcon(150, 150, imagePath);
        setIcon(newImageIcon);
        setVisible(true);
    }
}
