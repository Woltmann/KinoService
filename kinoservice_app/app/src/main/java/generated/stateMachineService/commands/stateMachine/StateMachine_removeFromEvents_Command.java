/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.stateMachine;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_removeFromEvents_Command extends ObjectCommand<StateMachine, Boolean>{
   private static final long serialVersionUID = 181380233L;
   private Event arg;
   public StateMachine_removeFromEvents_Command(StateMachine receiver, Event arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromEvents(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Event arg(){return this.arg;}
}
