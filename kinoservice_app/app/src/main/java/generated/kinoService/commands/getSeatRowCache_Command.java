/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class getSeatRowCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoService.proxies.SeatRowProxy>>{
   private static final long serialVersionUID = 1775344231L;
   public getSeatRowCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoService.getInstance().getSeatRowCache();
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
}
