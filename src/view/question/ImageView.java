package view.question;

import common.FormatHelper;
import javax.swing.*;

/**
 * ImageView class contains question image
 */
public class ImageView extends JLabel {

    public ImageView() {

        setSize(150, 150);
        setImage("src/resources/pics/0.jpeg");

    }

    public void setImage(String imagePath)  {
        ImageIcon newImageIcon = FormatHelper.resizeImageIcon(150, 120, imagePath);
        setIcon(newImageIcon);
        setVisible(true);


    }


}
