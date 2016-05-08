import Service.Observeble;
import UserData.ImportantService;

/**
 * Created by a_pan on 08.05.2016.
 */
public class Demo {
    public static void main(String[] args) {
        Observeble importantService = ImportantService.getInstance();
        importantService.createTransactionalConnection();
        importantService.createTransactionalConnection();
        importantService.createTransactionalConnection();
        importantService.createTransactionalConnection();
        importantService.createTransactionalConnection();
        importantService.createTransactionalConnection();
        importantService.createTransactionalConnection();


    }
}
