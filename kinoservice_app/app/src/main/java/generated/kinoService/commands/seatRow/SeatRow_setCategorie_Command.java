/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.seatRow;
import generated.kinoService.*;
import commands.*;
public class SeatRow_setCategorie_Command extends ObjectCommand<SeatRow, Void>{
   private static final long serialVersionUID = 2044659921L;
   private Categorie arg;
   public SeatRow_setCategorie_Command(SeatRow receiver, Categorie arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setCategorie(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Categorie arg(){return this.arg;}
}
