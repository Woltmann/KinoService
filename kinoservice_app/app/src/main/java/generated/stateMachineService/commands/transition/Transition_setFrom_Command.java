/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands.transition;
import generated.stateMachineService.*;
import commands.*;
public class Transition_setFrom_Command extends ObjectCommand<Transition, Void>{
   private static final long serialVersionUID = 388959881L;
   private State arg;
   public Transition_setFrom_Command(Transition receiver, State arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setFrom(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public State arg(){return this.arg;}
}
