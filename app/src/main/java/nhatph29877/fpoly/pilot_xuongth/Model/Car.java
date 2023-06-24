package nhatph29877.fpoly.pilot_xuongth.Model;

public class Car {
    private int id;
    private String tenxe;
    private String hangxe;
    private int namsx;
    private double giaxe;

    public Car(String tenxe, String hangxe, int namsx, double giaxe) {
        this.tenxe = tenxe;
        this.hangxe = hangxe;
        this.namsx = namsx;
        this.giaxe = giaxe;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public String getHangxe() {
        return hangxe;
    }

    public void setHangxe(String hangxe) {
        this.hangxe = hangxe;
    }

    public int getNamsx() {
        return namsx;
    }

    public void setNamsx(int namsx) {
        this.namsx = namsx;
    }

    public double getGiaxe() {
        return giaxe;
    }

    public void setGiaxe(double giaxe) {
        this.giaxe = giaxe;
    }
}
