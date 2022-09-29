package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button5 = new JButton();

		ArrayList<String> list = new ArrayList<String>();
		button1.setText("Add task");
		button2.setText("View tasks");
		button3.setText("Remove task");
		button4.setText("Save list");
		button5.setText("Load list");
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.setVisible(true);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		button1.addActionListener(e -> {
			list.add(JOptionPane.showInputDialog("What would you like to add to the list?"));
		});
		button2.addActionListener(e -> {
				JOptionPane.showMessageDialog(null, list);
		});
		button3.addActionListener(e -> {
			String[] choices = list.toArray(new String[list.size()]);
			int removed = JOptionPane.showOptionDialog(null, "Remove task", "Which task have you completed", 0, 0, null,
					choices, 0);
			list.remove(removed);
		});
		button4.addActionListener(e -> {
			try {
				FileWriter fw = new FileWriter("List");
				fw.write(list.toString());
				fw.close();
			} catch (IOException arg) {
				arg.printStackTrace();
			}
	});
		button5.addActionListener(e -> {
			try {
				BufferedReader br = new BufferedReader(new FileReader("List"));

				String line = br.readLine();
				list.removeAll(list);
				list.add(line);
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
	}
}
