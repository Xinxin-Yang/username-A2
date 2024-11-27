public interface RideInterface {

    void addVisitorToQueue(Visitor visitor);    // 将访客添加到队列中
    void removeVisitorFromQueue(Visitor visitor); // 从队列中移除访客
    void printQueue();                          // 打印队列中的访客
    void runOneCycle();                         // 执行一个周期
    void addVisitorToHistory(Visitor visitor);  // 将访客添加到历史记录中
    boolean checkVisitorFromHistory(Visitor visitor); // 检查访客是否在历史记录中
    int numberOfVisitors();                     // 返回历史记录中的访客数量
    void printRideHistory();                    // 打印历史记录
}
