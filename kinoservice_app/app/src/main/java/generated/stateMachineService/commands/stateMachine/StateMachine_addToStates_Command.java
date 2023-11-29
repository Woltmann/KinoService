/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.stateMachine;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_addToStates_Command extends ObjectCommand<StateMachine, Void>{
   private static final long serialVersionUID = 1801153096L;
   private State arg;
   public StateMachine_addToStates_Command(StateMachine receiver, State arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToStates(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public State arg(){return this.arg;}
}
