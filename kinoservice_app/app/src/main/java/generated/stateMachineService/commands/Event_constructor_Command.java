/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class Event_constructor_Command extends ServiceCommand<Event>{
   private static final long serialVersionUID = 577592886L;
   private String  label;
   public Event_constructor_Command(String  label){
      super();
      this.label = label;
   }
   public void execute(){
      try{this.result = Event.createFresh(label);
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
   public String  label(){return label;}
}
