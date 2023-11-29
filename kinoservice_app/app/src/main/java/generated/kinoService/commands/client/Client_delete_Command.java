/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.client;
import generated.kinoService.*;
import commands.*;
public class Client_delete_Command extends ObjectCommand<Client, Void>{
   private static final long serialVersionUID = 185999546L;
   public Client_delete_Command(Client receiver){
      super(receiver);
   }
   public void execute(){
      try{Client.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
