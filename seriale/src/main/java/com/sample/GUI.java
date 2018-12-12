package com.sample;
import javax.swing.*;

import com.sun.prism.paint.Color;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
	private JPanel contentPanel;
	private static ArrayList<JButton> answerButtons = new ArrayList<JButton>();
	private JTextField question;
	DroolsTest parent;
	private String answer = null;
	
	public GUI(){
		super("What tv show are you watching?");
		placeComponents();
		this.setSize(600, 430);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	private void placeComponents() {
		contentPanel = new JPanel();
		question = new JTextField("Question");
		question.setPreferredSize(new Dimension(400, 100));
		question.setEditable(false);
		question.setAlignmentX(CENTER_ALIGNMENT);
		question.setAlignmentY(CENTER_ALIGNMENT);
		contentPanel.add(question, BorderLayout.NORTH);
		
		for(int i=0; i<6; i++) {
			JButton newButton = new JButton("Odpowiedz "+ Integer.toString(i));
			newButton.setBackground(java.awt.Color.white);
			newButton.setPreferredSize(new Dimension(500,40));
			newButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,  12));
			newButton.addActionListener(this);
			newButton.setMargin(new Insets(0, 0, 0, 0));
			answerButtons.add(newButton);
			contentPanel.add(newButton, BorderLayout.NORTH);
		}
		
		this.setContentPane(contentPanel);
		hideAnswers();
	}
	
	public void setQuestion(String name) {
		answer = null;
		question.setText(name);
	}
	
	public void hideAnswers() {
		for(JButton b : answerButtons) {
			b.setVisible(false);
		}
	}
	
	public void setAnswers(ArrayList<String> answers) {
		if(answers == null) {
			return;
		}
		
		if(answers.size() > answerButtons.size()) {
			System.out.println("Zbyt duza ilosc opcji do wyboru");
			System.exit(-1);
		}
		
		int i=0;
		for(String answer : answers) {
			answerButtons.get(i).setText(answer);
			
			answerButtons.get(i).setVisible(true);
			i++;
		}
		
		for(i = i; i < answerButtons.size(); i++) {
			answerButtons.get(i).setVisible(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		this.answer = clicked.getText();
	}
}
