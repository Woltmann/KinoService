/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.transition;
import generated.stateMachineService.*;
import commands.*;
public class Transition_delete_Command extends ObjectCommand<Transition, Void>{
   private static final long serialVersionUID = 27835260L;
   public Transition_delete_Command(Transition receiver){
      super(receiver);
   }
   public void execute(){
      try{Transition.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
