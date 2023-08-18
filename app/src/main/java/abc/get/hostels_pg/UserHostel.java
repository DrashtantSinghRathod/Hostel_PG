package abc.get.hostels_pg;
public class UserHostel
{
  public String colony,uid,path,type,gender,hname,oname,email,no1,no2,srent,drent,trent,detail,fulladd,
                  savail,davail,tavail,ac,laundry,ebill,cooler,ro,water_heater,sweeper,bed,matress,kitchen;

  public  UserHostel()
  {

  }

  public UserHostel(String colony, String uid, String path, String type, String gender, String hname, String oname, String email, String no1, String no2, String srent, String drent, String trent, String detail, String fulladd, String savail, String davail, String tavail, String ac, String laundry, String ebill, String cooler, String ro, String water_heater, String sweeper, String bed, String matress, String kitchen) {
    this.colony = colony;
    this.uid = uid;
    this.path = path;
    this.type = type;
    this.gender = gender;
    this.hname = hname;
    this.oname = oname;
    this.email = email;
    this.no1 = no1;
    this.no2 = no2;
    this.srent = srent;
    this.drent = drent;
    this.trent = trent;
    this.detail = detail;
    this.fulladd = fulladd;
    this.savail = savail;
    this.davail = davail;
    this.tavail = tavail;
    this.ac = ac;
    this.laundry = laundry;
    this.ebill = ebill;
    this.cooler = cooler;
    this.ro = ro;
    this.water_heater = water_heater;
    this.sweeper = sweeper;
    this.bed = bed;
    this.matress = matress;
    this.kitchen = kitchen;
  }

  public String getColony() {
    return colony;
  }

  public String getUid() {
    return uid;
  }

  public String getPath() {
    return path;
  }

  public String getType() {
    return type;
  }

  public String getGender() {
    return gender;
  }

  public String getHname() {
    return hname;
  }

  public String getOname() {
    return oname;
  }

  public String getEmail() {
    return email;
  }

  public String getNo1() {
    return no1;
  }

  public String getNo2() {
    return no2;
  }

  public String getSrent() {
    return srent;
  }

  public String getDrent() {
    return drent;
  }

  public String getTrent() {
    return trent;
  }

  public String getDetail() {
    return detail;
  }

  public String getFulladd() {
    return fulladd;
  }

  public String getSavail() {
    return savail;
  }

  public String getDavail() {
    return davail;
  }

  public String getTavail() {
    return tavail;
  }

  public String getAc() {
    return ac;
  }

  public String getLaundry() {
    return laundry;
  }

  public String getEbill() {
    return ebill;
  }

  public String getCooler() {
    return cooler;
  }

  public String getRo() {
    return ro;
  }

  public String getWater_heater() {
    return water_heater;
  }

  public String getSweeper() {
    return sweeper;
  }

  public String getBed() {
    return bed;
  }

  public String getMatress() {
    return matress;
  }

  public String getKitchen() {
    return kitchen;
  }
}