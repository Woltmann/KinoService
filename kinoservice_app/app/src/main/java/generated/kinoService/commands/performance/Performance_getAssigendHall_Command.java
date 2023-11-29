/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.performance;
import generated.kinoService.*;
import commands.*;
public class Performance_getAssigendHall_Command extends ObjectCommand<Performance, Cinemahall>{
   private static final long serialVersionUID = 331749557L;
   public Performance_getAssigendHall_Command(Performance receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAssigendHall();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
