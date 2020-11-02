package userinterface;

import dictionary.Dictionary;
import word.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserInterface implements ActionListener{
    Dictionary dictionary = new Dictionary();



    public void createUserInterface(){
        JFrame frame = createFrame();
        frame.getContentPane().add(BorderLayout.NORTH,createMenuBar());
        frame.getContentPane().add(BorderLayout.CENTER,getAddPanel());
      //  frame.getContentPane().add(BorderLayout.CENTER,getTranslatePanel());
      // frame.getContentPane().add(BorderLayout.CENTER,getDeletePanel());
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    private JPanel getAddPanel(){
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel language1 = new JLabel("Write word on language 1");
        panel.add(language1,constraints);

        constraints.gridx = 1;
        final JTextField textFieldForLanguage1 = new JTextField();
        textFieldForLanguage1.setPreferredSize(new Dimension(150,24));
        panel.add(textFieldForLanguage1,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel language2 = new JLabel("Write word on language 2");
        panel.add(language2,constraints);

        constraints.gridx = 1;
        final JTextField textFieldForLanguage2 = new JTextField();
        textFieldForLanguage2.setPreferredSize(new Dimension(150,24));
        panel.add(textFieldForLanguage2,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JButton addNewWord = new JButton("Add");
        addNewWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dictionary.writeWordToDictionary(new Word(textFieldForLanguage1.getText(),
                            textFieldForLanguage2.getText()));
            }
        });
        panel.add(addNewWord,constraints);

        constraints.gridx = 1;
        JButton cancel = new JButton("Cancel");
        panel.add(cancel,constraints);

        return panel;

    }

    private JPanel getTranslatePanel(){
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel language1 = new JLabel("Word on language 1 : ");
        panel.add(language1,constraints);

        constraints.gridx = 1;
        final JLabel wordText = new JLabel("Hello");
        panel.add(wordText,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel language2 = new JLabel("Write translate :");
        panel.add(language2,constraints);

        constraints.gridx = 1;
        final JTextField textFieldForLanguage2 = new JTextField();
        textFieldForLanguage2.setPreferredSize(new Dimension(150,24));
        panel.add(textFieldForLanguage2,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        final JButton check = new JButton("Check");
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   if(dictionary.checkWordFromDictionary(new Word(wordText.getText(),textFieldForLanguage2.getText()))){
                       check.setText("You are right!");
                   } else {
                       check.setText("It's wrong!");
                   }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                //place for result
            }
        });
        panel.add(check,constraints);

        constraints.gridx = 1;
        JButton cancel = new JButton("Cancel");
        panel.add(cancel,constraints);

        return panel;
    }

    private JPanel getDeletePanel(){
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel language1 = new JLabel("Writing word for delete ");
        panel.add(language1,constraints);

        constraints.gridx = 1;
        final JTextField textFieldForRemove = new JTextField();
        textFieldForRemove.setPreferredSize(new Dimension(150,24));
        panel.add(textFieldForRemove,constraints);


        constraints.gridx = 0;
        constraints.gridy = 1;
        JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dictionary.removeWordFromDictionary(new Word(textFieldForRemove.getText(),null));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        panel.add(delete,constraints);

        constraints.gridx = 1;
        JButton cancel = new JButton("Cancel");
        panel.add(cancel,constraints);

        return panel;
    }
}
