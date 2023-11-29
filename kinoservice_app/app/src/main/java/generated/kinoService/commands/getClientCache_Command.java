/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class getClientCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoService.proxies.ClientProxy>>{
   private static final long serialVersionUID = 839370682L;
   public getClientCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoService.getInstance().getClientCache();
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
}
