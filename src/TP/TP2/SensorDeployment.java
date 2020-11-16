package TP.TP2;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.encodings.solutionType.RealSolutionType;
import jmetal.util.JMException;

public class SensorDeployment extends Problem {
    public SensorDeployment(String solutionType, String filePath, int nbCapteur, int taillePopulation, int radius, int boxSize) throws ClassNotFoundException {
        /**
         * Vu que les capteurs ont 2 coordonnées (X, Y) le nb de variable est égale à 2 fois le nombre de capteur.
         */
        numberOfVariables_ = nbCapteur * 2;

        /**
         * Comme décrit dans le fichier text, 2 objectifs distincts
         */
        numberOfObjectives_ = 2;

        /**
         * ??
         */
        numberOfConstraints_ = 0;

        /**
         * Nom du problème
         */
        problemName_ = "Sensor";

        /**
         * Nous souhaitons utilisé une solution de type : ""
         */
        if (solutionType.compareTo("Real") == 0) {
            solutionType_ = new RealSolutionType(this);
        } else {
            System.out.println("Error: solution type " + solutionType + " invalid.");
            System.exit(-1);
        }

        /**
         * Limite basse : 0
         * Limite haute : boxSize
         * De cette manière nos capteurs sont compris entre (0;0) et (boxSize;boxSize)
         */
        lowerLimit_ = new double[numberOfVariables_];
        upperLimit_ = new double[numberOfVariables_];

        for (int i = 0; i < numberOfVariables_; i++) {
            lowerLimit_[i] = 0;
            upperLimit_[i] = boxSize;
        }

        //
    }

    @Override
    public void evaluate(Solution solution) throws JMException {

    }
}
