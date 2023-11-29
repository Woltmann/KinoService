/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class SeatRow_constructor_Command extends ServiceCommand<SeatRow>{
   private static final long serialVersionUID = 1632064981L;
   private Categorie categorie;
   private Integer  numberOfSeats;
   public SeatRow_constructor_Command(Categorie categorie, Integer  numberOfSeats){
      super();
      this.categorie = categorie;
      this.numberOfSeats = numberOfSeats;
   }
   public void execute(){
      try{this.result = SeatRow.createFresh(categorie, numberOfSeats);
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
   public Categorie categorie(){return categorie;}
   public Integer  numberOfSeats(){return numberOfSeats;}
}
