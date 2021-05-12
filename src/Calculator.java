

public class Calculator {

    private int expectedThickness;
    private int expectedArea;
    private double mCost;

    /**
     * constant variables.
     */
    final int costKvm = 31;                 // cost of material for 1cm * 100cm * 100cm
    final int costLowThickness = 70;        // work cost for thickness <= 7cm.
    final int costHighThickness = 50;       // work cost for thickness > 7cm.
    final double consumptionVar = 0.35;     // variable for calculation of material consumption.
    final double setupCost = 900;

    /**
     * Creator class
     */
    public Calculator () {
        expectedThickness = 0;
        expectedArea = 0;
        mCost = 0;
    }

    /**
     * Method used for returning the expected Thickness.
     * @return an int representing the Thickness for isolation.
     */
    public int getExpectedThickness() {
        return expectedThickness;
    }

    /**
     * Method used for returning the expected Area.
     * @return an int representing the area to be
     */
    public int getExpectedArea() {
        return expectedArea;
    }

    /**
     * Method used to get m2 cost.
     * @return Double value representing the m2 cost.
     */
    public double getmCost() {
        return mCost;
    }

    /**
     * Method used to get the setup Cost.
     * @return Double value representing setup Cost.
     */
    public double getSetupCost() {
        return setupCost;
    }

    /**
     * Method used to set the expected thickness.
     * @param expectedThickness expected thickness to be sprayed.
     */
    public void setExpectedThickness(int expectedThickness) {
        this.expectedThickness = expectedThickness;
    }

    /**
     * Method used to set the expected thickness.
     * @param expectedArea expected area to be sprayed
     */
    public void setExpectedArea(int expectedArea) {
        this.expectedArea = expectedArea;
    }

    /**
     * Method used to calculate the cost according to height and thickness.
     * @return an int representing the cost rounded to nearest 5th.
     */
    public double calculateCost(){
        double cost = 0;
        if(0 < expectedThickness){
            if (expectedThickness < 7){
                cost = expectedThickness * costKvm + costLowThickness;
            } else if (expectedThickness > 7){
                cost = expectedThickness * costKvm + costHighThickness;
            }
        }
        cost = Math.round(cost/5) * 5;
        mCost =cost;
        cost = cost * expectedArea;
        cost = cost + setupCost;
       return cost;
    }

    /**
     * Method used to calculate the expected material consumption.
     * @return a double value representing the expected material consumption.
     */
    public double averageMaterialConsumption() {
        return expectedThickness * expectedArea * consumptionVar;
    }
}
