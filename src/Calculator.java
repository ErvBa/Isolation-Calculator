

public class Calculator {

    private int expectedHeight;
    private int expectedArea;

    // creator
    public Calculator () {
        expectedHeight = 0;
        expectedArea = 0;
    }

    public int getExpectedHeight() {
        return expectedHeight;
    }

    public int getExpectedArea() {
        return expectedArea;
    }

    public void setExpectedHeight(int expectedHeight) {
        this.expectedHeight = expectedHeight;
    }

    public void setExpectedArea(int expectedArea) {
        this.expectedArea = expectedArea;
    }
    public double calculateCost(){
        int costKvm = 31;
        double cost = 0;
        if(0 < expectedHeight){
            if (expectedHeight < 7){
                cost = expectedHeight * costKvm + 70;
            } else if (expectedHeight > 7){
                cost = expectedHeight * costKvm + 50;
            }
        }
        cost = Math.round(cost/5) * 5;
        cost = cost * expectedArea;
        return cost;
    }
}
