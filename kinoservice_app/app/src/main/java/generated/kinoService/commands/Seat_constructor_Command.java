/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class Seat_constructor_Command extends ServiceCommand<Seat>{
   private static final long serialVersionUID = 356072270L;
   private SeatRow seatRow;
   public Seat_constructor_Command(SeatRow seatRow){
      super();
      this.seatRow = seatRow;
   }
   public void execute(){
      try{this.result = Seat.createFresh(seatRow);
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
   public SeatRow seatRow(){return seatRow;}
}
