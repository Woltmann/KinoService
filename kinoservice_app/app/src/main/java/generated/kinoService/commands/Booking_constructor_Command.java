/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class Booking_constructor_Command extends ServiceCommand<Booking>{
   private static final long serialVersionUID = -757036364L;
   private Client client;
   private Performance performance;
   public Booking_constructor_Command(Client client, Performance performance){
      super();
      this.client = client;
      this.performance = performance;
   }
   public void execute(){
      try{this.result = Booking.createFresh(client, performance);
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
   public Client client(){return client;}
   public Performance performance(){return performance;}
}
