package soares_raiza;

public class empty extends apartment{
    private int rent= 0;
    private int maint= 200;
    private int remo =0;
    public  empty()
    {
        super.setType("0");
        super.SetRent(rent);
        super.SetMaint(maint);
        super.setRemodel(remo);
    }
}
