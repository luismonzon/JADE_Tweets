/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2_201212944;
import  jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
/**
 *
 * @author lmonzon
 */
public class Agente extends Agent {

    
    protected void setup(){
         
        addBehaviour(  // -------- Anonymous SimpleBehaviour 
 
             new SimpleBehaviour( this ) 
             {
                 int n=0;
                 
                 public void action() 
                 {
                      Twitter twitter = TwitterFactory.getSingleton();
                        Query query = new Query("source:twitter4j yusukey");
                        QueryResult result=null;
                     try {
                         result = twitter.search(query);
                     } catch (TwitterException ex) {
                         Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
                     }
                        for (Status status : result.getTweets()) {
                            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                        }
                 }
         
                 public boolean done() {  return n>=3;  }
             }
         );
    
    }
    
    protected void takeDown() { //auí se definen las operaciones de limpieza
        System.out.println("Agente comprador "); // sólo realiza una despedida
    }
        
 
}
