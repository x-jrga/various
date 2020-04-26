import java.util.ArrayList;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;


/*
* @author  Jorge Garcia de Alba
 */
public class LPModel {

    public static final int GEQ = 1;
    public static final int LEQ = 2;
    public static final int EQ = 3;

    private LinearObjectiveFunction linearObjectiveFunction;
    private ArrayList constraints;
    private double[] point;
    private double cost;
    private LPFormat lpFormat;

    public LPModel() {

        //commons-math3-3.6.1 library on classpath
        constraints = new ArrayList();
        lpFormat = new LPFormat();
    }

    public void addObjective(double[] coefficients) {

        byte constantTerm = 0;
        //Objective function
        linearObjectiveFunction = new LinearObjectiveFunction(coefficients, constantTerm);
        //
        lpFormat.objectiveToLp(coefficients);
    }

    public void addConstraint(double[] coefficients, int rel, double amount) {

        Relationship relationship = null;

        switch (rel) {
            case LPModel.GEQ:
                relationship = Relationship.GEQ;
                //
                break;
            case LPModel.LEQ:
                //
                relationship = Relationship.LEQ;
                break;
            case LPModel.EQ:
                //
                relationship = Relationship.EQ;
                break;
            default:
                relationship = Relationship.GEQ;
                break;
        }

        //Linear Constraint
        LinearConstraint c = new LinearConstraint(coefficients, relationship, amount);
        constraints.add(c);
        //
        lpFormat.constraintToLp(coefficients,rel,amount);
    }

    public void solve() {

        //Constraint Set
        LinearConstraintSet linearConstraintSet = new LinearConstraintSet(constraints);

        //Solution
        GoalType minimize = GoalType.MINIMIZE;
        NonNegativeConstraint nonNegativeConstraint = new NonNegativeConstraint(true);
        PointValuePair solution = (new SimplexSolver()).optimize(new OptimizationData[]{linearObjectiveFunction, linearConstraintSet, minimize, nonNegativeConstraint});
        point = solution.getPoint();
        cost = solution.getSecond();
    }

    public double[] getPoint() {
        return point;
    }

    public double getCost() {
        return cost;
    }

    public String printModel(){
        return lpFormat.getModel();
    }
}
