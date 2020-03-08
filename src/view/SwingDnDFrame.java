package view;

import java.util.List;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


/**
 * SwingDnDFrame class implements drag and drop list
 */

public class SwingDnDFrame extends JPanel {
    private JTabbedPane tabbedPane;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    public SwingDnDFrame(List<String> wordList) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tabbedPane = new JTabbedPane();

        List<String> words = wordList;

        DefaultListModel model = new DefaultListModel();
        for (String word : words)
            model.addElement(word);
        JList list = new JList(model);



        tabbedPane.addTab("Drag List", list);

        textArea = new JTextArea(3, 35);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Drag text here"));

        list.setDragEnabled(true);

        add(tabbedPane);
        add(scrollPane);

    }

    public JTextArea getTextArea() {
        return textArea;
    }

}



