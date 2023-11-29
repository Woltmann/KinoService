/**--- Generated at Thu Oct 05 12:31:08 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.stateMachine;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_validate_Command extends ObjectCommand<StateMachine, Boolean>{
   private static final long serialVersionUID = -799850176L;
   private String w;
   public StateMachine_validate_Command(StateMachine receiver, String w){
      super(receiver);
      this.w = w;
   }
   public void execute(){
      try{this.result = this.receiver.validate(w);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public String w(){return this.w;}
}
