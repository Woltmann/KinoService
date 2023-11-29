/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class closeDBConnection_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 1769228833L;
   public closeDBConnection_Command(){
      super();
   }
   public void execute(){
      try{KinoService.getInstance().closeDBConnection();
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
}
