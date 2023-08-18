package abc.get.hostels_pg;

class Word1 {
    public String date,hname,type,rent,address,no1;
    public Word1()
    {

    }

    public Word1(String date, String hname, String type,String no1, String rent, String address) {
        this.date = date;
        this.hname = hname;
        this.no1=no1;
        this.type = type;
        this.rent = rent;
        this.address = address;
    }


    public String getDate() {
        return date;
    }
    public String getNo1() {
        return no1;
    }


    public String getHname() {
        return hname;
    }

    public String getType() {
        return type;
    }

    public String getRent() {
        return rent;
    }

    public String getAddress() {
        return address;
    }
}
