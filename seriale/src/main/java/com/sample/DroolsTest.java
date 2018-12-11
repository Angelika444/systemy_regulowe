package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
            
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    public static class Fact{
    	private String name;
        private String answer;
        
    	public Fact(String name, String answer) {
        	this.name=name;
            this.answer=answer;
        }
    	
    	public Fact(String answer) {
            this.answer=answer;
            showAnswer();
        }
    	
    	public void showAnswer() {
			//wyswietla nazwe serialu, do ktorej doszedl uzytkownik (answer)
    		System.out.println(answer);
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
    	
    }
    
    
    public static class Question {
        
    	private String question;
    	private static ArrayList<String> answers = new ArrayList<String>();
        private String userAnswer="Yes";
        
        public Question(String q) {
        	this.question = q;
        }
        
        public void showQuestion() {
			//czeka na odpowiedz uzytkownika, ktora wstawia do userAnswer
		}
        
        public void addAns(String a) {
			Question.answers.add(a);
		}
        
		public static ArrayList<String> getAnswers() {
			return answers;
		}
		public static void setAnswers(ArrayList<String> answers) {
			Question.answers = answers;
		}
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}

		public String getUserAnswer() {
			return userAnswer;
		}

		public void setUserAnswer(String userAnswer) {
			this.userAnswer = userAnswer;
		}
    }
}
