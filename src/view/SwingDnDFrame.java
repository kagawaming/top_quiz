package view;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * This program demonstrates the basic Swing support for drag and drop.
 *
 * @version 1.10 2007-09-20
 * @author Cay Horstmann
 */
//public class SwingDnDTest {
////    public static void main(String[] args) {
////        EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                JFrame frame = new SwingDnDFrame();
////                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////                frame.setVisible(true);
////            }
////        });
////    }
//
//}

public class SwingDnDFrame extends JPanel {
    private JTabbedPane tabbedPane;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    public SwingDnDFrame() {
//        setTitle("SwingDnDTest");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tabbedPane = new JTabbedPane();
//        JPanel listPanel = new JPanel();

        String[] words = { "a", "i", "n", "p","o" };

        DefaultListModel model = new DefaultListModel();
        for (String word : words)
            model.addElement(word);
        JList list = new JList(model);

        tabbedPane.addTab("Drag List", list);
//        JTable table = SampleComponents.table();
//        tabbedPane.addTab("Table", table);
//        JTree tree = SampleComponents.tree();
//        tabbedPane.addTab("Tree", tree);
//        JFileChooser fileChooser = new JFileChooser();
//        tabbedPane.addTab("File Chooser", fileChooser);
//        JColorChooser colorChooser = new JColorChooser();
//        tabbedPane.addTab("Color Chooser", colorChooser);

        textArea = new JTextArea(3, 35);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Drag text here"));


//        JTextField textField = new JTextField("Drag color here");
//        textField.setTransferHandler(new TransferHandler("background"));

//        tabbedPane.addChangeListener(new ChangeListener() {
//            public void stateChanged(ChangeEvent e) {
//                textArea.setText("");
//            }
//        });

//        tree.setDragEnabled(true);
//        table.setDragEnabled(true);
        list.setDragEnabled(true);
//        fileChooser.setDragEnabled(true);
//        colorChooser.setDragEnabled(true);
//        textField.setDragEnabled(true);

        add(tabbedPane);
        add(scrollPane);
//        add(textField, BorderLayout.SOUTH);
//        pack();
    }

    public JTextArea getTextArea() {
        return textArea;
    }

}

/*
 * This program is a part of the companion code for Core Java 8th ed.
 * (http://horstmann.com/corejava)
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

//class SampleComponents {
////    public static JTree tree() {
////        DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
////        DefaultMutableTreeNode country = new DefaultMutableTreeNode("USA");
////        root.add(country);
////        DefaultMutableTreeNode state = new DefaultMutableTreeNode("California");
////        country.add(state);
////        DefaultMutableTreeNode city = new DefaultMutableTreeNode("San Jose");
////        state.add(city);
////        city = new DefaultMutableTreeNode("Cupertino");
////        state.add(city);
////        state = new DefaultMutableTreeNode("Michigan");
////        country.add(state);
////        city = new DefaultMutableTreeNode("Ann Arbor");
////        state.add(city);
////        country = new DefaultMutableTreeNode("Germany");
////        root.add(country);
////        state = new DefaultMutableTreeNode("Schleswig-Holstein");
////        country.add(state);
////        city = new DefaultMutableTreeNode("Kiel");
////        state.add(city);
////        return new JTree(root);
////    }
//
//    public static JList list() {
//        String[] words = { "Russia", "USA", "China", "Canada" };
//
//        DefaultListModel model = new DefaultListModel();
//        for (String word : words)
//            model.addElement(word);
//        return new JList(model);
//    }
//
////    public static JTable table() {
////        Object[][] cells = { { "Mercury", 2440.0, 0, false, Color.YELLOW },
////                { "Venus", 6052.0, 0, false, Color.YELLOW }, { "Earth", 6378.0, 1, false, Color.BLUE },
////                { "Mars", 3397.0, 2, false, Color.RED }, { "Jupiter", 71492.0, 16, true, Color.ORANGE },
////                { "Saturn", 60268.0, 18, true, Color.ORANGE }, { "Uranus", 25559.0, 17, true, Color.BLUE },
////                { "Neptune", 24766.0, 8, true, Color.BLUE }, { "Pluto", 1137.0, 1, false, Color.BLACK } };
////
////        String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous", "Color" };
////        return new JTable(cells, columnNames);
////    }
//}