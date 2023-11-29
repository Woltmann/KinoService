/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.performance;
import generated.kinoService.*;
import commands.*;
public class Performance_setFilm_Command extends ObjectCommand<Performance, Void>{
   private static final long serialVersionUID = 1796016310L;
   private Film arg;
   public Performance_setFilm_Command(Performance receiver, Film arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setFilm(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Film arg(){return this.arg;}
}
