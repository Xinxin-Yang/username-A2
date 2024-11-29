import java.util.Comparator;
public class ComparatorVisitor implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 比较年龄
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison;  // 如果年龄不同，返回比较结果
        }else{
            int nameComparison = v1.getName().compareTo(v2.getName());
            if (nameComparison != 0) {
                return nameComparison;
            }
        }
        return 0;
    }
}


