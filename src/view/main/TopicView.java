package view.main;

import common.FormatHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * TopicView class contains quiz logo, username and all topics
 */
public class TopicView extends JPanel{
    private List<JRadioButton> topicRadioButtons = new ArrayList<>();

    private JLabel logo = FormatHelper.setImageLabel(150, 120, "src/resources/pics/0.jpeg");
    private JLabel nameLabel = new JLabel("");
    private JLabel topicLabel = new JLabel(" TOPICS");

    public TopicView(List<String> topics) {
//        FormatHelper.setMainPanelBorder(this, "");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(logo);
        nameLabel.setFont(FormatHelper.setTitleFont(20));
        nameLabel.setMaximumSize(new Dimension(150, 50));
        add(nameLabel);

        add(Box.createVerticalStrut(15));
        topicLabel.setFont(FormatHelper.setTitleFont(15));
        add(topicLabel);
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton topicRadioButton;
        int topicNumber = 0;
        for (String topic : topics) {
            topicRadioButton = new JRadioButton(topic);
            topicRadioButton.setFont(FormatHelper.setTextFont(15));
            topicRadioButtons.add(topicRadioButton);
            buttonGroup.add(topicRadioButton);
            add(topicRadioButton);
            topicNumber++;
        }

    }

    public String getTopic(){
        String topic = null;
        for(JRadioButton button : topicRadioButtons){
            if(button.isSelected()){
                topic = button.getText().toLowerCase();
                break;
            }
        }

        return topic;
    }

    public void addTopicSelectionListener(ActionListener listener) {
        for(JRadioButton topicButton : topicRadioButtons){
            topicButton.addActionListener(listener);
        }
    }

    public void setNameLabel(String username) {
        nameLabel.setText(username);
    }
}
