/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.event;
import generated.stateMachineService.*;
import commands.*;
public class Event_delete_Command extends ObjectCommand<Event, Void>{
   private static final long serialVersionUID = -2085848389L;
   public Event_delete_Command(Event receiver){
      super(receiver);
   }
   public void execute(){
      try{Event.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
