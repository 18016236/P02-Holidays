package sg.edu.rp.c346.p02_holidays;

public class holidays {
    private String name;
    private int pic;
    private String date;

    public holidays(String name, int pic, String date) {
        this.name = name;
        this.pic = pic;
        this.date = date;
    }
    public String getName() {
        return name;
    }

    public int getPic() {
        return pic;
    }

    public String getDate() {
        return date;
    }
}
