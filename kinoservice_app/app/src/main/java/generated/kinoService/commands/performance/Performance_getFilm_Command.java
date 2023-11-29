/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.performance;
import generated.kinoService.*;
import commands.*;
public class Performance_getFilm_Command extends ObjectCommand<Performance, Film>{
   private static final long serialVersionUID = 1894969756L;
   public Performance_getFilm_Command(Performance receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getFilm();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
