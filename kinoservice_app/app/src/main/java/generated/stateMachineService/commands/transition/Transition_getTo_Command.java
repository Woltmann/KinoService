/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.transition;
import generated.stateMachineService.*;
import commands.*;
public class Transition_getTo_Command extends ObjectCommand<Transition, State>{
   private static final long serialVersionUID = 850449131L;
   public Transition_getTo_Command(Transition receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getTo();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
