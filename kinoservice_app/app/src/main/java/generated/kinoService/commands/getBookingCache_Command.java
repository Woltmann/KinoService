/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class getBookingCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoService.proxies.BookingProxy>>{
   private static final long serialVersionUID = -1896357694L;
   public getBookingCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoService.getInstance().getBookingCache();
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
}
