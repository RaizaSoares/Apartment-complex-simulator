package soares_raiza;

public class penthouse extends apartment {
    private int rent= 2000;
    private int maint = 1000;
    private int remo = 10000;
    public  penthouse()
    {
        super.setType("2");
        super.SetRent(rent);
        super.SetMaint(maint);
        super.setRemodel(remo);
    }
}
