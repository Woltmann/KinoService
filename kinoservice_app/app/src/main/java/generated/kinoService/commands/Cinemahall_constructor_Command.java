/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class Cinemahall_constructor_Command extends ServiceCommand<Cinemahall>{
   private static final long serialVersionUID = -983620768L;
   private String  hallname;
   private Boolean  isFree;
   public Cinemahall_constructor_Command(String  hallname, Boolean  isFree){
      super();
      this.hallname = hallname;
      this.isFree = isFree;
   }
   public void execute(){
      try{this.result = Cinemahall.createFresh(hallname, isFree);
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
   public String  hallname(){return hallname;}
   public Boolean  isFree(){return isFree;}
}
