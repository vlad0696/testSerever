package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//Типы улиц
@Entity
@Table(name = "TypeStreet")
public class TypeStreet extends BasicEntityTwoDate {

    //Код Типа улиц
    @Column(name = "CodeTypeStreet")
    public Integer CodeTypeStreet;

    //Наименование Типа улиц
    @Column(name = "Name",length = 512)
    public String Name;

    //Краткое наименование Типа улиц
    @Column(name = "NameShort")
    public String NameShort;

    //Ссыкла на улицы
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="TypeStreet_Id")
    public List<Street> streetList;



    public Integer getCodeTypeStreet() {
        return CodeTypeStreet;
    }

    public void setCodeTypeStreet(Integer codeTypeStreet) {
        CodeTypeStreet = codeTypeStreet;
    }

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

    public List<Street> getStreetList() {
        return streetList;
    }

    public void setStreetList(List<Street> streetList) {
        this.streetList = streetList;
    }
}
