package Logic;

import java.util.*;

public class Evaluate {

    public boolean containsMore(ArrayList<Long> factors) {
        Set<Long> set = new HashSet<Long>(factors);
        if (set.size() < factors.size() && !factors.isEmpty()) {
            return true;
        }
        return false;

    }

    public boolean conatinsExactly2(ArrayList<Long> factors) {
        Set<Long> set = new HashSet<Long>(factors);
        ArrayList<Long> firstMentioned = new ArrayList<>();
        ArrayList<Long> secondMentioned = new ArrayList<>();

        for (int i = 0; i < factors.size(); i++) {
            if (!firstMentioned.contains(factors.get(i))) {
                firstMentioned.add(factors.get(i));
            } else if (!secondMentioned.contains(factors.get(i))) {
                secondMentioned.add(factors.get(i));
            } else {
                if (i == factors.size()-1) {
                    return false;
                }
            }
        }
        if (firstMentioned.size() == factors.size()) {
            return false;
        }

        return true;

    }

}


