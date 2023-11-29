/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.stateMachine;
import generated.stateMachineService.*;
import commands.*;
import java.util.Collection;
public class StateMachine_getStates_Command extends ObjectCommand<StateMachine, Collection<State>>{
   private static final long serialVersionUID = -1863829540L;
   public StateMachine_getStates_Command(StateMachine receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getStates();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
