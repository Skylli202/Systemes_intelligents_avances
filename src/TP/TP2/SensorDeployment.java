package TP.TP2;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;
import jmetal.util.JMException;

public class SensorDeployment extends Problem {
    private Double[][] targetsCoords;
    private int radius;
    public SensorDeployment(String solutionType, String filePath, int nbCapteur, int radius, int boxSize) throws ClassNotFoundException {
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

        // set the radius of our problem
        this.radius = radius;

        // read sensor position from config file
        this.targetsCoords = readFile.read("C:\\Users\\anaki\\Documents\\GitHub\\Systemes_intelligents_avances\\src\\TP\\TP2\\targets.txt");

    }

    @Override
    public void evaluate(Solution solution) throws JMException {
        int[] tabCouv = new int[this.targetsCoords.length];
        for (int i = 0; i < tabCouv.length; i++) {
            tabCouv[i] = 0;
        }
        Variable[] decisionVariables = solution.getDecisionVariables();

        for (int i = 0; i < numberOfVariables_/2; i=i+2) {
            double x_sensor = decisionVariables[i].getValue();
            double y_sensor = decisionVariables[i+1].getValue();

            for (int j = 0; j < this.targetsCoords.length; j++) {
                double x_target = this.targetsCoords[j][0];
                double y_target = this.targetsCoords[j][1];

                double dist = Math.sqrt(Math.pow((x_sensor-x_target),2) + Math.pow((y_sensor-y_target),2));

                if (dist <= this.radius) {
                    tabCouv[j] = tabCouv[j] + 1;
                }
            }
        }

        // f1 && f2
        // double min = Double.MAX_VALUE;
        double coveredSensors = 0;
        double min = this.numberOfVariables_/2;
        for (int i = 0; i < tabCouv.length; i++) {
            if (tabCouv[i] != 0) {
                coveredSensors++;
            }

            if (tabCouv[i] < min) {
                min = tabCouv[i];
            }
        }

        solution.setObjective(0, coveredSensors*(-1));
        solution.setObjective(1, min*(-1));
    }
}
