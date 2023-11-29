/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class getReservationCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoService.proxies.ReservationProxy>>{
   private static final long serialVersionUID = -517112476L;
   public getReservationCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoService.getInstance().getReservationCache();
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
}
