package be.bagofwords.db.filedb;

import be.bagofwords.db.DataInterface;
import be.bagofwords.db.combinator.Combinator;
import be.bagofwords.db.impl.BaseDataInterface;
import be.bagofwords.db.impl.BaseDataInterfaceFactory;
import be.bagofwords.db.methods.ObjectSerializer;
import be.bagofwords.logging.Log;
import be.bagofwords.memory.MemoryManager;
import be.bagofwords.minidepi.ApplicationContext;

public class FileDataInterfaceFactory extends BaseDataInterfaceFactory {

    private final MemoryManager memoryManager;
    private final String directory;

    public FileDataInterfaceFactory(ApplicationContext context) {
        super(context);
        this.memoryManager = context.getBean(MemoryManager.class);
        this.directory = context.getProperty("data_directory");
    }

    @Override
    protected <T extends Object> BaseDataInterface<T> createBaseDataInterface(String name, Class<T> objectClass, Combinator<T> combinator, ObjectSerializer<T> objectSerializer, boolean isTemporaryDataInterface) {
        Log.i("Creating file data interface " + name);
        FileDataInterface<T> result = new FileDataInterface<>(memoryManager, combinator, objectClass, directory, name, isTemporaryDataInterface, asyncJobService, objectSerializer);
        memoryManager.registerMemoryGobbler(result);
        return result;
    }

    @Override
    protected Class<? extends DataInterface> getBaseDataInterfaceClass() {
        return FileDataInterface.class;
    }

}
