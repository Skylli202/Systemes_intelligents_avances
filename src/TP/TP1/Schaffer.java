package TP.TP1;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;
import jmetal.encodings.variable.Int;
import jmetal.util.JMException;

public class Schaffer extends Problem {
    public Schaffer (String solutionType, Integer numberOfVariables) throws ClassNotFoundException {
        numberOfVariables_      = numberOfVariables;
        numberOfObjectives_     = 1;
        numberOfConstraints_    = 0;
        problemName_            = "Schaffer";

        if (solutionType.compareTo("Real") == 0) {
            solutionType_ = new RealSolutionType(this);
        } else {
            System.out.println("Error: solution type " + solutionType + " invalid.");
            System.exit(-1);
        }

        lowerLimit_ = new double[numberOfVariables_];
        upperLimit_ = new double[numberOfVariables_];

        // définissez les bornes pour (lowerLimit_ et upperLimit_) pour chaque variable de décision.
        for (int i=0; i < numberOfVariables_; i++) {
            lowerLimit_[i] = -100;
            upperLimit_[i] = 100;
        }
    }

    @Override
    public void evaluate(Solution solution) throws JMException {
        Variable[] decisionVariables = solution.getDecisionVariables();

        double [] x = new double[numberOfVariables_];

        for (int i=0; i < numberOfVariables_; i++) {
            x[i] = decisionVariables[i].getValue();
        }

        double f = 0.0;
        // calculez f...

        for (int i = 0; i < numberOfVariables_-1; i++) {
            double xi_xii = (Math.pow(x[i], 2) + Math.pow(x[i+1], 2));
            double tmp = Math.pow(xi_xii, 0.25) * (Math.pow(Math.sin(50*Math.pow(xi_xii, 0.1)), 2));

            f += tmp;
        }
        System.out.println(f);
        solution.setObjective(0, f);

    }

}
