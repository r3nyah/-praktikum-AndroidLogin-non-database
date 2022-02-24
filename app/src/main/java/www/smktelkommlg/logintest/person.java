package www.smktelkommlg.logintest;

import android.os.Parcel;
import android.os.Parcelable;

public class person implements Parcelable {
    private String name,email,city;
    private int age;

    protected person(Parcel in) {
        name = in.readString();
        email = in.readString();
        city = in.readString();
        age = in.readInt();
    }

    public static final Creator<person> CREATOR = new Creator<person>() {
        @Override
        public person createFromParcel(Parcel in) {
            return new person(in);
        }

        @Override
        public person[] newArray(int size) {
            return new person[size];
        }
    };
    public person(String name, String email, String city, int age){
        this.name=name;
        this.email=email;
        this.city=city;
        this.age=age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getCity(){
        return city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(city);
        parcel.writeInt(age);
    }
}
