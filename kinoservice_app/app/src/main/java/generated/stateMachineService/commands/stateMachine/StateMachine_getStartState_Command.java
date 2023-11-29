/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.stateMachine;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_getStartState_Command extends ObjectCommand<StateMachine, State>{
   private static final long serialVersionUID = -579793734L;
   public StateMachine_getStartState_Command(StateMachine receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getStartState();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
