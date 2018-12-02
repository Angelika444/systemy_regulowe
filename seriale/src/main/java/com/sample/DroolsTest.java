package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import java.util.Scanner;
/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
            
            
            Zapytanie zapytanie=new Zapytanie();
            zapytanie.setMessage("pregnant?");
            zapytanie.setStatus(Zapytanie.START);
            kSession.insert(zapytanie);
            
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static class Zapytanie {

    	public static final int YES = 0;
        public static final int NO = 1;
        public static final int OTHER =2;
        public static final int OTHER2 =3;
        public static final int START =4;

        private String message;
        private int status;
        private int number;
        private int noMoreQuestions=0;
        private Scanner input;
        private String last="";

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
        public int getNoMoreQuestions() {
            return this.noMoreQuestions;
        }

        public void setNoMoreQuestions(int noMoreQuestions) {
            this.noMoreQuestions = noMoreQuestions;
        }
        public int getNumber() {
            return this.number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
        public String getLast() {
            return this.last;
        }

        public void setLast(String last) {
            this.last = last;
        }
        public void readNumber() {
        	input = new Scanner(System.in);
    		String text = input.nextLine();
    		try
    		{
    			this.number = Integer.parseInt( text); 
    		}
    		catch(NumberFormatException e)
    		{
    		System.out.println("Tu nie ma liczby :[");
    		}
    		
        }
        
   
    }


}
