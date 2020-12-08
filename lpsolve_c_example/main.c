#include <lpsolve/lp_lib.h>

int main() {

    /*******************************************************
    * Refactored example at:                               *
    * http://lpsolve.sourceforge.net/5.5/formulate.htm     *
    * The example model can be formulated as follows in C: *
    *  C/C++                                               *
    *******************************************************/

    //Declare variables
    lprec *lp;
    int *columnNumberArray = NULL;
    double *valuesArray = NULL;
    columnNumberArray = malloc(2 * sizeof(*columnNumberArray));
    valuesArray = malloc(2 * sizeof(*valuesArray));

    //Initialize variables
    columnNumberArray[0] = 1; /* first column */
    columnNumberArray[1] = 2; /* second column */
    valuesArray[0] = 0;
    valuesArray[1] = 0;

    //There are two variables in the model
    lp = make_lp(0, 2);

    //Name variables
    set_col_name(lp, 1, "x");
    set_col_name(lp, 2, "y");

    //Turn add row mode on
    set_add_rowmode(lp, TRUE);

    //Add constraint (120 x + 210 y <= 15000)
    valuesArray[0] = 120;
    valuesArray[1] = 210;
    add_constraintex(lp, 2, valuesArray, columnNumberArray, LE, 15000);
    set_row_name(lp,1,"a");

    //Add constraint (110 x + 30 y <= 4000)
    valuesArray[0] = 110;
    valuesArray[1] = 30;
    add_constraintex(lp, 2, valuesArray, columnNumberArray, LE, 4000);
    set_row_name(lp,2,"b");

    //Add constraint (x + y <= 75)
    valuesArray[0] = 1;
    valuesArray[1] = 1;
    add_constraintex(lp, 2, valuesArray, columnNumberArray, LE, 75);
    set_row_name(lp,3,"c");

    //Turn add row mode off
    set_add_rowmode(lp, FALSE);

    //Add objective function (143 x + 60 y)
    valuesArray[0] = 143;
    valuesArray[1] = 60;
    set_obj_fnex(lp, 2, valuesArray, columnNumberArray);

    //Maximize objective
    set_maxim(lp);
    write_LP(lp, stdout);
    solve(lp);
    set_verbose(lp, IMPORTANT);

    //Get result
    printf("Objective value: %f\n", get_objective(lp));
    get_variables(lp, valuesArray);
    printf("%s: %f\n", get_col_name(lp, 1), valuesArray[0]);
    printf("%s: %f\n", get_col_name(lp, 2), valuesArray[1]);

    //Delete model
    delete_lp(lp);

    //Free memory
    free(valuesArray);
    free(columnNumberArray);

    return 0;
}