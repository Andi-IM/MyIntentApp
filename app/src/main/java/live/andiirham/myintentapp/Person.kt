package live.andiirham.myintentapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name : String?,
    val age : Int? ,
    val email : String? ,
    val city : String?
) : Parcelable

/**
 * kalo di java ini merupakan kelas yang hanya berisi get set / encapsulation
 *
 * java
 * class person {
 * String name;
 * int age;
 * String email;
 * String city;
 *
 *    public Person(){
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public int getAge() {
return age;
}

public void setAge(int age) {
this.age = age;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}
 */
