/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.stateMachine;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_isDeterministic_Command extends ObjectCommand<StateMachine, Boolean>{
   private static final long serialVersionUID = -1153233792L;
   private String W;
   public StateMachine_isDeterministic_Command(StateMachine receiver, String W){
      super(receiver);
      this.W = W;
   }
   public void execute(){
      try{this.result = this.receiver.isDeterministic(W);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public String W(){return this.W;}
}
