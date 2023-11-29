/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.transition;
import generated.stateMachineService.*;
import commands.*;
public class Transition_setEvent_Command extends ObjectCommand<Transition, Void>{
   private static final long serialVersionUID = 1253126078L;
   private Event arg;
   public Transition_setEvent_Command(Transition receiver, Event arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setEvent(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Event arg(){return this.arg;}
}
