/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.stateMachine;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_removeFromTransitions_Command extends ObjectCommand<StateMachine, Boolean>{
   private static final long serialVersionUID = 340280932L;
   private Transition arg;
   public StateMachine_removeFromTransitions_Command(StateMachine receiver, Transition arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromTransitions(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Transition arg(){return this.arg;}
}
