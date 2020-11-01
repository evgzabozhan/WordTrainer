package userinterface;

import javax.swing.*;
import java.awt.*;

public class UserInterface {


    public void createUserInterface(){
        JFrame frame = createFrame();
        frame.getContentPane().add(BorderLayout.NORTH,createMenuBar());
        frame.getContentPane().add(BorderLayout.CENTER,createAddPanel());
      //  frame.getContentPane().add(BorderLayout.CENTER,createTranslatePanel());
        frame.setVisible(true);
    }

    private JFrame createFrame(){
        JFrame frame = new JFrame("Word trainer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        return frame;
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu word = new JMenu("Word");
        word.add(new JMenuItem("Add new word"));
        word.add(new JMenuItem("Delete word"));
        word.add(new JMenuItem("Change word"));

        JMenu help = new JMenu("Help");
        help.add(new JMenuItem("About"));

        menuBar.add(word);
        menuBar.add(help);

        return menuBar;

    }

    private JPanel createAddPanel(){
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel language1 = new JLabel("Write word on language 1");
        panel.add(language1,constraints);

        constraints.gridx = 1;
        JTextField textFieldForLanguage1 = new JTextField();
        textFieldForLanguage1.setPreferredSize(new Dimension(150,24));
        panel.add(textFieldForLanguage1,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel language2 = new JLabel("Write word on language 2");
        panel.add(language2,constraints);

        constraints.gridx = 1;
        JTextField textFieldForLanguage2 = new JTextField();
        textFieldForLanguage2.setPreferredSize(new Dimension(150,24));
        panel.add(textFieldForLanguage2,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JButton addNewWord = new JButton("Add");
        panel.add(addNewWord,constraints);

        constraints.gridx = 1;
        JButton cancel = new JButton("Cancel");
        panel.add(cancel,constraints);

        return panel;

    }

    private JPanel createTranslatePanel(){
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel language1 = new JLabel("Word on language 1 : ");
        panel.add(language1,constraints);

        constraints.gridx = 1;
        JLabel word = new JLabel("Hello");
        panel.add(word,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel language2 = new JLabel("Write translate :");
        panel.add(language2,constraints);

        constraints.gridx = 1;
        JTextField textFieldForLanguage2 = new JTextField();
        textFieldForLanguage2.setPreferredSize(new Dimension(150,24));
        panel.add(textFieldForLanguage2,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JButton addNewWord = new JButton("Check");
        panel.add(addNewWord,constraints);

        constraints.gridx = 1;
        JButton cancel = new JButton("Cancel");
        panel.add(cancel,constraints);

        return panel;
    }
}
