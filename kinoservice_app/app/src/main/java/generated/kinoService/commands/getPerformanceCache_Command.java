/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class getPerformanceCache_Command extends ServiceCommand<java.util.Map<Integer, generated.kinoService.proxies.PerformanceProxy>>{
   private static final long serialVersionUID = 1262845800L;
   public getPerformanceCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = KinoService.getInstance().getPerformanceCache();
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
}
