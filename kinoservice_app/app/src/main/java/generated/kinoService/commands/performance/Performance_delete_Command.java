/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.performance;
import generated.kinoService.*;
import commands.*;
public class Performance_delete_Command extends ObjectCommand<Performance, Void>{
   private static final long serialVersionUID = -1817870545L;
   public Performance_delete_Command(Performance receiver){
      super(receiver);
   }
   public void execute(){
      try{Performance.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
