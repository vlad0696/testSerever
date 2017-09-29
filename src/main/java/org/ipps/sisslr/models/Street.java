package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//Улицы
@Entity
@Table(name = "Street")
public class Street extends BasicEntityTwoDate {

    //Название улицы
    @Column(name = "Name",length = 512)
    public String Name;

    //Тип улицы
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeStreet_Id")
    public TypeStreet TypeStreet_Id;

    //СОАТО Административную территориальную единицц
    @Column(name = "SOATO")
    public String SOATO;

    //Связь с адресами
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "Street_Id")
    public List<Address> addressList;







    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public TypeStreet getTypeStreet_Id() {
        return TypeStreet_Id;
    }

    public void setTypeStreet_Id(TypeStreet typeStreet_Id) {
        TypeStreet_Id = typeStreet_Id;
    }

    public String getSOATO() {
        return SOATO;
    }

    public void setSOATO(String SOATO) {
        this.SOATO = SOATO;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
