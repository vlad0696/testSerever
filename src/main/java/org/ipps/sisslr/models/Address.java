package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */
//Адреса юридических лиц и индивидуальных предпринимателей
@Entity
@Table(name = "Address")
public class Address extends BasicEntityTwoDate {

    //Почтоый индекс
    @Column(name = "PostIndex",length = 6)
    public Integer PostIndex;

    //Улицы
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Street_Id")
    public Street Street_Id;

    //Номер дома
    @Column(name = "HouseNumber",length = 20)
    public Integer  HouseNumber;

    //Связь с юридическими лицами и индивидуальными предпринимателями
    @OneToMany(fetch = FetchType.EAGER,mappedBy ="Address_Id")
    public List<ULandiE> uLandiEList;







    public Integer getPostIndex() {
        return PostIndex;
    }

    public void setPostIndex(Integer postIndex) {
        PostIndex = postIndex;
    }

    public Street getStreet_Id() {
        return Street_Id;
    }

    public void setStreet_Id(Street street_Id) {
        Street_Id = street_Id;
    }

    public Integer getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        HouseNumber = houseNumber;
    }

    public List<ULandiE> getuLandiEList() {
        return uLandiEList;
    }

    public void setuLandiEList(List<ULandiE> uLandiEList) {
        this.uLandiEList = uLandiEList;
    }
}
