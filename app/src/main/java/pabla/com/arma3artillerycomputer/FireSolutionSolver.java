package pabla.com.arma3artillerycomputer;


import android.util.Log;

public class FireSolutionSolver {
    double sx, sy, sh, tx, ty, th; //source x, y, and height and target x, y, and height
    int selected; //selected artillery type
    double gravity = 9.80665;
    double gravity2 = 96.1703842225;

    double charge = -1.0;
    double charge2 = -1.0;
    double charge4 = -1.0;


    double A,B,range;

    double[][][] chargeTable = new double[][][]
            {
                    // mk6 mortar charge table
                    {
                            {70.0,34.0,499.0},
                            {140.0,139.0,1998.0},
                            {200.0,284.0,4078.0}
                    },

                    // m4 charge table
                    {
                            {153.9,286.0,2415.0},
                            {243.0,2059.0,6012.0},
                            {388.8,5271.0,15414.0},
                            {648.0,14644.0,42818.0},
                            {810.0,22881.0,66903.0}
                    },

                    // m5 charge table
                    {
                            {212.5,799.0,4604.0},
                            {425.0,3918.0,18418.0},
                            {637.5,7196.0,41442.0},
                            {772.5,12793.0,73674.0}
                    }

            };

    public FireSolutionSolver(double sx, double sy, double sh, double tx, double ty, double th, int selected) {
        this.sx = sx;
        this.sy = sy;
        this.sh = sh;
        this.tx = tx;
        this.ty = ty;
        this.th = th;
        this.selected = selected;

        SolveSolution();

    }

    public void SolveSolution() {
        A = tx-sx;
        B = ty-sy;
        range = 10.0*Math.sqrt((A*A) + (B*B));

        double[][] artilleryCharge = chargeTable[selected];
        charge = -1.0;

        for(int i = 0; i<artilleryCharge.length;i++) {
            if(artilleryCharge[i][1]>range && artilleryCharge[i][2]>range) {
                charge = artilleryCharge[i][0];
                break;
            }
        }


        Log.d("FireSolutionSolver",charge+"");

    }
}
