import java.util.List;

public interface IDatabaseLoader<T> {
    List<T> load(String fileName);
}
