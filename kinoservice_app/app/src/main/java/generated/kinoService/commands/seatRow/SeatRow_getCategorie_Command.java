/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.seatRow;
import generated.kinoService.*;
import commands.*;
public class SeatRow_getCategorie_Command extends ObjectCommand<SeatRow, Categorie>{
   private static final long serialVersionUID = -1422771139L;
   public SeatRow_getCategorie_Command(SeatRow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getCategorie();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
