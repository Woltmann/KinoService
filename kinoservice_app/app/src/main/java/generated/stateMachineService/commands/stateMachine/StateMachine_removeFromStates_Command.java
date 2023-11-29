/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.stateMachine;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_removeFromStates_Command extends ObjectCommand<StateMachine, Boolean>{
   private static final long serialVersionUID = 1298995687L;
   private State arg;
   public StateMachine_removeFromStates_Command(StateMachine receiver, State arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromStates(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public State arg(){return this.arg;}
}
