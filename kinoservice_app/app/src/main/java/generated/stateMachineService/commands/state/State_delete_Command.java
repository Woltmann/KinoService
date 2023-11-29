/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.state;
import generated.stateMachineService.*;
import commands.*;
public class State_delete_Command extends ObjectCommand<State, Void>{
   private static final long serialVersionUID = -1228876060L;
   public State_delete_Command(State receiver){
      super(receiver);
   }
   public void execute(){
      try{State.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
