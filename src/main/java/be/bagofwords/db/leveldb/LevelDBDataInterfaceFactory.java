package be.bagofwords.db.leveldb;

import be.bagofwords.db.DataInterfaceFactory;
import be.bagofwords.db.combinator.Combinator;
import be.bagofwords.application.memory.MemoryManager;
import be.bagofwords.cache.CachesManager;
import be.bagofwords.db.DataInterface;

import java.io.File;

public class LevelDBDataInterfaceFactory extends DataInterfaceFactory {

    private final String directory;

    public LevelDBDataInterfaceFactory(CachesManager cachesManager, MemoryManager memoryManager, String directory) {
        super(cachesManager, memoryManager);
        this.directory = directory;
        File dirFile = new File(directory);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
    }

    @Override
    protected <T extends Object> DataInterface<T> createBaseDataInterface(String nameOfSubset, Class<T> objectClass, Combinator<T> combinator) {
        return new LevelDBDataInterface<>(directory, nameOfSubset, objectClass, combinator);
    }

    @Override
    public synchronized void close() {
        super.close();
    }
}