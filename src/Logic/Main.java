package Logic;

import GUI.GUI;

import java.util.ArrayList;

public class Main {

    public ArrayList<Long> squarefrees() {
        PrimFactor primFactor = new PrimFactor();
        Evaluate evaluate = new Evaluate();
        ArrayList<Long> students = new ArrayList<>();
        for (long i = 1; i < 100; i++) {
            ArrayList<Long> factors = new ArrayList<>();
            factors = primFactor.factorize(i);
            if (evaluate.containsMore(factors) == false) {
                students.add(i);
            }
        }
        return students;

    }

    public ArrayList<Long> cubetimesquarefrees() {
        PrimFactor primFactor = new PrimFactor();
        Evaluate evaluate = new Evaluate();
        ArrayList<Long> students = new ArrayList<>();
        for (long i = 1; i < 100; i++) {
            ArrayList<Long> factors = primFactor.factorize(i);
            if (!evaluate.conatinsExactly2(factors)) {
                students.add(i);
            }
        }
        return students;

    }
}
