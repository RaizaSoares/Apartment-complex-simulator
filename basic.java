package soares_raiza;

public class basic extends apartment {
    private int rent= 800;
    private int maint = 450;
    private int remo = 4000;
    public  basic()
    {
        super.setType("1");
        super.SetRent(rent);
        super.SetMaint(maint);
        super.setRemodel(remo);
    }
}
