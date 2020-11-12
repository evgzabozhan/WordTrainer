package userinterface;

import dictionary.Dictionary;
import word.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserInterface {
    public static int rightWords = 0;

    Dictionary dictionary = new Dictionary();
    JFrame frame = new JFrame("Word trainer");

    public void createUserInterface() throws IOException {
        JFrame frame = createFrame();
        frame.getContentPane().add(BorderLayout.NORTH,createMenuBar(frame));
       frame.getContentPane().add(BorderLayout.CENTER,getTranslatePanel());
        frame.setVisible(true);
    }

    private JFrame createFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        return frame;
    }

    private JMenuBar createMenuBar(final JFrame frame){
        JMenuBar menuBar = new JMenuBar();

        JMenu word = new JMenu("Word");
        JMenuItem add = new JMenuItem("Add new word");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(1);
               frame.getContentPane().add(BorderLayout.CENTER, getAddPanel());
               frame.setVisible(true);
            }
        });
        JMenuItem delete = new JMenuItem("Delete word");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(1);
                frame.getContentPane().add(BorderLayout.CENTER, getDeletePanel());
                frame.setVisible(true);
            }
        });

        JMenuItem change = new JMenuItem("Change word");
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(1);
                frame.getContentPane().add(BorderLayout.CENTER, getChangePanel());
                frame.setVisible(true);
            }
        });

        JMenuItem translate = new JMenuItem("Translate word");
        translate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.getContentPane().remove(1);
                    frame.getContentPane().add(BorderLayout.CENTER, getTranslatePanel());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frame.setVisible(true);
            }
        });

        word.add(add);
        word.add(delete);
        word.add(change);
        word.add(translate);

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(1);
                frame.getContentPane().add(BorderLayout.CENTER, getAboutPanel());
                frame.setVisible(true);
            }
        });
        help.add(about);

        menuBar.add(word);
        menuBar.add(help);

        return menuBar;

    }

    private JPanel getAboutPanel(){
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridx = 0;
        constraints.gridy = 0;

        JLabel about = new JLabel("it's Word Trainer.");
        panel.add(about,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel about1 = new JLabel("This program can help you with learning words on another language.");
        panel.add(about1,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel about2 = new JLabel("Created by evgzabozhan");
        panel.add(about2,constraints);

        return panel;
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
        final JButton addNewWord = new JButton("Add");
        addNewWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dictionary.writeWordToDictionary(new Word(textFieldForLanguage1.getText(),
                            textFieldForLanguage2.getText()));
                    addNewWord.setText("Word added!");
                    textFieldForLanguage1.setText("");
                    textFieldForLanguage2.setText("");
            }
        });
        panel.add(addNewWord,constraints);

        constraints.gridx = 1;
        JButton cancel = new JButton("Cancel");
        panel.add(cancel,constraints);

        return panel;

    }

    private JPanel getTranslatePanel() throws IOException {

        int length = (int) (Math.random() * dictionary.loadDictionary().size());

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel language1 = new JLabel("Word on language 1 : ");
        panel.add(language1,constraints);

        constraints.gridx = 1;
        final JLabel wordText = new JLabel(dictionary.loadDictionary().get(length).getLanguage1());
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
        constraints.gridy = 3;
        final JLabel score = new JLabel("Score : " + rightWords);
        panel.add(score,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        final JButton check = new JButton("Check");
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   if(dictionary.checkWordFromDictionary(new Word(wordText.getText(),textFieldForLanguage2.getText()))){
                       check.setText("You are right!");
                       frame.getContentPane().remove(1);
                       frame.getContentPane().add(BorderLayout.CENTER, getTranslatePanel());
                       rightWords++;
                   } else {
                       check.setText("It's wrong!");
                       frame.getContentPane().remove(1);
                       frame.getContentPane().add(BorderLayout.CENTER, getTranslatePanel());
                       wordText.setText(wordText.getText());
                       rightWords--;
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
        final JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dictionary.removeWordFromDictionary(new Word(textFieldForRemove.getText(),null));
                    delete.setText("Word deleted!");
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

    private JPanel getChangePanel(){
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
        final JButton addNewWord = new JButton("Edit word");
        addNewWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dictionary.changeWordAtDictionary(new Word(textFieldForLanguage1.getText(),
                            textFieldForLanguage2.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                addNewWord.setText("Word changed!");
            }
        });
        panel.add(addNewWord,constraints);

        constraints.gridx = 1;
        JButton cancel = new JButton("Cancel");
        panel.add(cancel,constraints);

        return panel;

    }

}
