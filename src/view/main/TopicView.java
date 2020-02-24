package view.main;

import com.sun.tools.corba.se.idl.toJavaPortable.Helper;
import util.FormatHelper;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TopicView extends JPanel{
    private List<JRadioButton> topicRadioButtons = new ArrayList<>();
    /**
     * doesn't work
     */
    private JLabel logo = FormatHelper.setImageLabel(150, 120, "src/resources/pics/0.jpeg");
    private JLabel nameLabel = new JLabel("Welcome " + " Cutie ^3^");
    private JLabel topicLabel = new JLabel("TOPICS");

    public TopicView(List<String> topics) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(logo);
        nameLabel.setFont(FormatHelper.setTitleFont(18));
        add(nameLabel);

        add(Box.createVerticalStrut(15));
        topicLabel.setFont(FormatHelper.setTitleFont(15));
        add(topicLabel);
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton topicRadioButton;
        int topicNumber = 0;
        for (String topic : topics) {
            topicRadioButton = new JRadioButton(topic);
            topicRadioButton.setFont(FormatHelper.setTextFont(12));
            topicRadioButtons.add(topicRadioButton);
            buttonGroup.add(topicRadioButton);
            add(topicRadioButton);
            topicNumber++;
        }

    }

}
