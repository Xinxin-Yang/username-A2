import java.util.Comparator;
public class ComparatorVisitor implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Age comparison
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison;  // If the age is different, the comparison result is returned
        }else{
            int nameComparison = v1.getName().compareTo(v2.getName());
            if (nameComparison != 0) {
                return nameComparison;
            }
        }
        return 0;
    }
}


