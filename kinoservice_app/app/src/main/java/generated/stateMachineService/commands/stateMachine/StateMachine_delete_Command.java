/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.stateMachine;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_delete_Command extends ObjectCommand<StateMachine, Void>{
   private static final long serialVersionUID = -464879166L;
   public StateMachine_delete_Command(StateMachine receiver){
      super(receiver);
   }
   public void execute(){
      try{StateMachine.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
