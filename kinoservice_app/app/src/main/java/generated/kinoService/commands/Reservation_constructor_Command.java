/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class Reservation_constructor_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = 472742485L;
   private Performance performance;
   private Client client;
   private String  valid;
   public Reservation_constructor_Command(Performance performance, Client client, String  valid){
      super();
      this.performance = performance;
      this.client = client;
      this.valid = valid;
   }
   public void execute(){
      try{this.result = Reservation.createFresh(performance, client, valid);
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
   public Performance performance(){return performance;}
   public Client client(){return client;}
   public String  valid(){return valid;}
}
