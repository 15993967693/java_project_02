package package_OutputStream;
import java.util.*;
import java.awt.event.*;

import javax.management.Query;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardBuilder {
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizCardBuilder builder=new QuizCardBuilder();
		
	}
	public void go() {
		frame=new JFrame("Quiz Card Builder");
		JPanel mainPanel=new JPanel();
		Font bigFont=new Font("sanserif", Font.BOLD, 24);
		question=new JTextArea(6,20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);
		
		JScrollPane qsJScrollPane=new JScrollPane(question);
		qsJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qsJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		answer=new JTextArea(6,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);
		
		JScrollPane aScroller=new JScrollPane(answer);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton=new JButton("Next Card");
		cardList=new ArrayList<QuizCard>();
		
		JLabel qLabel=new JLabel("Question");
		JLabel aLabel=new JLabel("Answer");
		
		mainPanel.add(qLabel);
		mainPanel.add(qsJScrollPane);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		JMenuBar menuBar=new JMenuBar();
		JMenu fileMenu=new JMenu("File");
		JMenuItem newMenuItem=new JMenuItem("New");
		JMenuItem saveMenuItem=new JMenuItem("Sava");
		newMenuItem.addActionListener(new NewMenuListener());
		
		saveMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500, 600);
		frame.setVisible(true);
	}
	public class NextCardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			//QuizCard cardBuilder=new QuizCard(question.getText(),answer.getText());
			//cardList.add(card);
			clearCard();
		}
		
	}
	public class NewMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cardList.clear();
			clearCard();
		}
		
	}
	public class SaveMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//QuizCard card=new QuizCard(question.getText(),answer.getText());
			//cardList.add(card);
			JFileChooser fileSave=new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
		}
		
	}
	public void saveFile(File file) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(file));
			for(QuizCard card:cardList) {
				//writer.write(card.getQuestion()+"/");
				//writer.write(card.getAnswer()+"\n");
				
			}
			writer.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("could't write the cardList out");
			e.printStackTrace();
		}
	}
	public void clearCard() {
		// TODO Auto-generated method stub
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}
	
}
