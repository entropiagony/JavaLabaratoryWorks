import java.util.List;

public class Database<T extends IType> {
    private List<T> data;
    private IDatabaseLoader<T> loader;
    private  ILogger logger;

    Database(IDatabaseLoader loader) {
        this.loader = loader;
    }

    Database(IDatabaseLoader loader, ILogger logger) {
        this.loader = loader;
        this.logger = logger;
    }

    public void load(String fileName) {
        logger.log("Started loading data");
        data = loader.load(fileName);
        logger.log("Finished loading data");
    }

    public List<T> getList() {
        return data;
    }

}
