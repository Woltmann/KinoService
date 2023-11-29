/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class Transition_constructor_Command extends ServiceCommand<Transition>{
   private static final long serialVersionUID = 778698032L;
   private Event event;
   private State from;
   private State to;
   private StateMachine  myStateMachine;
   public Transition_constructor_Command(Event event, State from, State to, StateMachine  myStateMachine){
      super();
      this.event = event;
      this.from = from;
      this.to = to;
      this.myStateMachine = myStateMachine;
   }
   public void execute(){
      try{this.result = Transition.createFresh(event, from, to, myStateMachine);
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
   public Event event(){return event;}
   public State from(){return from;}
   public State to(){return to;}
   public StateMachine  myStateMachine(){return myStateMachine;}
}
