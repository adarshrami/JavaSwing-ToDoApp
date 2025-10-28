import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setPreferredSize(new Dimension(350, 250));

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a task!");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index != -1) {
                    listModel.remove(index);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a task to delete!");
                }
            }
        });

        frame.add(new JLabel("Enter Task:"));
        frame.add(taskField);
        frame.add(addButton);
        frame.add(deleteButton);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}

