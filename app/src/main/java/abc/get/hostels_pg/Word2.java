package abc.get.hostels_pg;

public class Word2 {
    private String name,type,address,profession,age,phone,date;
    public Word2()
    {

    }

    public Word2(String name, String type, String address, String profession, String age, String phone, String date) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.profession = profession;
        this.age = age;
        this.phone = phone;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getProfession() {
        return profession;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getDate() {
        return date;
    }
}
