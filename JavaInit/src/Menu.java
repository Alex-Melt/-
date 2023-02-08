public class Menu {
    private Integer od;
    private String name;
    private Double price;
    private Integer praise;

    public Menu(Integer od, String name, Double price, Integer praise) {
        this.od = od;
        this.name = name;
        this.price = price;
        this.praise = praise;
    }

    public Integer getOd() {
        return od;
    }

    public void setOd(Integer od) {
        this.od = od;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }
}
