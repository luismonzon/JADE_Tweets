/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2_201212944;
import  jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
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
                     System.out.println( "Hello World! My name is " + 
                         myAgent.getLocalName() );
                     n++;
                 }
         
                 public boolean done() {  return n>=3;  }
             }
         );
    
    }
    
    protected void takeDown() { //auí se definen las operaciones de limpieza
        System.out.println("Agente comprador "); // sólo realiza una despedida
    }
        
 
}
