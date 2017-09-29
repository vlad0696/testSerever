package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//справочник организационно правовых форм
@Entity
@Table(name = "TypeOfCompany")
public class TypeOfCompany extends BasicEntityTwoDate {

    // Наименование (полное) организационно правовой формы
    @Column(name = "Name",length = 512)
    public String Name;

    // Наименование (краткое) организационно правовой формы
    @Column(name = "NameShort")
    public String NameShort;

    //Ссылка на информацию о юридических лицах и индивидуальных предпринимателях
    @OneToMany(fetch = FetchType.LAZY,mappedBy ="TypeOfCompany_Id")
    public List<ULandiE> uLandiEList;







    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNameShort() {
        return NameShort;
    }

    public void setNameShort(String nameShort) {
        NameShort = nameShort;
    }

    public List<ULandiE> getuLandiEList() {
        return uLandiEList;
    }

    public void setuLandiEList(List<ULandiE> uLandiEList) {
        this.uLandiEList = uLandiEList;
    }
}
