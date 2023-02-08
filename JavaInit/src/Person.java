public class Person {
    private Integer id;
    private String name;
    private Integer time;
    private  String address;

    private Integer[][] menuNum;
    private Integer prices;

    private String reserve="已预订";

    public Person(Integer id,String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getPrices() {
        return prices;
    }

    public void setPrices(Integer prices) {
        this.prices = prices;
    }

    public Integer getId() {
        return id;
    }

    //public void setId(Integer id) {
    //    this.id = id;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer[][] getMenuNum() {
        return menuNum;
    }

    public void setMenuNum(Integer[][] menuNum) {
        this.menuNum = menuNum;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }
}
