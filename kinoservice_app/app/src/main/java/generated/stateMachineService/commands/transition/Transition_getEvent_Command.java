/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.transition;
import generated.stateMachineService.*;
import commands.*;
public class Transition_getEvent_Command extends ObjectCommand<Transition, Event>{
   private static final long serialVersionUID = -1147417675L;
   public Transition_getEvent_Command(Transition receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getEvent();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
