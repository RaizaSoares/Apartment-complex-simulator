package soares_raiza;

public class apartment
{
    private int rent;
    private int maintenance;
    private int remodel;
    private int timesinceremodel;
    private int currMonth= 0;
    public void increaseRent(int val) {
    rent= rent + val;
    }
    private String type ="";
    public void newMonth()
    {
        currMonth = currMonth + 1;
    }
    public void setType(String t)
    {
        type = t;
    }
    public String getType()
    {
        return type;
    }

    protected void SetRent(int r) {
        rent= r;
    }

    protected void SetMaint(int maint) {
        maintenance = maint;
    }

    protected void setRemodel(int remo) {
        remodel = remo;
    }
    public int getRemodelcost()
    {
        return remodel;
    }

    public int getMaint() {
        return maintenance;
    }

    public int getRent() {
        return rent;
    }
    public int sendMonth()
    {
        return currMonth;
    }
}
