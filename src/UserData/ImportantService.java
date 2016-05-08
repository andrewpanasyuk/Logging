package UserData;

import Processor.EnableLogging;
import Processor.LogIt;
import Service.ImportantServiceProxy;
import Service.Observeble;

/**
 * Created by a_pan on 08.05.2016.
 */
@EnableLogging
public class ImportantService implements Observeble {
    private static Observeble instance;

    public static Observeble getInstance() {
        if (instance == null) {
            instance = (Observeble) ImportantServiceProxy.getNewProxyObject(new ImportantService(), Observeble.class);
        }
        return instance;
    }

    @LogIt
    @Override
    public boolean createTransactionalConnection() {
        return false;
    }
}
