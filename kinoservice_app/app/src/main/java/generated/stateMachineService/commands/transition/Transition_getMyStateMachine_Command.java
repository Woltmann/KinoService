/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.transition;
import generated.stateMachineService.*;
import commands.*;
public class Transition_getMyStateMachine_Command extends ObjectCommand<Transition, StateMachine>{
   private static final long serialVersionUID = -1197537453L;
   public Transition_getMyStateMachine_Command(Transition receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getMyStateMachine();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
