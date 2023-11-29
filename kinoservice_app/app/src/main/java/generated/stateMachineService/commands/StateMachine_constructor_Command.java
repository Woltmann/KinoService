/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_constructor_Command extends ServiceCommand<StateMachine>{
   private static final long serialVersionUID = 1517537152L;
   private State startState;
   public StateMachine_constructor_Command(State startState){
      super();
      this.startState = startState;
   }
   public void execute(){
      try{this.result = StateMachine.createFresh(startState);
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
   public State startState(){return startState;}
}
