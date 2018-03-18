package Logic;

import java.util.*;

public class Evaluate {

    public boolean containsMore(ArrayList<Long> factors){
        Set<Long> set = new HashSet<Long>(factors);
        if(set.size()< factors.size() && !factors.isEmpty()){
            return true;
        }
        return false;

    }

    public boolean conatinsExactly2(ArrayList<Long> factors){
        Set<Long> set = new HashSet<Long>(factors);
        if(set.size()== factors.size()-1 && !factors.isEmpty()){
            return true;
        }
        else if(set.size() == factors.size()-2 && !factors.isEmpty()){
            Collections.sort(factors);
            for(int i=0; i< factors.size(); i++){
                if (i+3 < factors.size() && factors.size() > 3 && factors.get(i) == factors.get(i + 3)) {
                    return false;
                }
            }
            return true;
        }
        return false;

    }
}
