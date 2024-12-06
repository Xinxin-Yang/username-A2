import java.util.Queue;
public interface FileManager<T> {
    void exportRideHistory(String fileName);
    Queue<T> importRideHistory(String fileName);
}