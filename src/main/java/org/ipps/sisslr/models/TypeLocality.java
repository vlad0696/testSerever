package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//Тип населенного пункта
@Entity
@Table(name = "TypeLocality")
public class TypeLocality extends BasicEntityTwoDate{

    //Наименование населенного пункта
    @Column(name = "Name",length = 512)
    public String Name;

    //Краткое наименование населенного пункта
    @Column(name = "NameShort",length = 10)
    public String NameShort;

    //Связь с Административное территориальная еденицами
    @OneToMany(fetch = FetchType.LAZY,mappedBy ="TypeLocality_Id")
    public List<AdministrativeTerritories> administrativeTerritoriesList;






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

    public List<AdministrativeTerritories> getAdministrativeTerritoriesList() {
        return administrativeTerritoriesList;
    }

    public void setAdministrativeTerritoriesList(List<AdministrativeTerritories> administrativeTerritoriesList) {
        this.administrativeTerritoriesList = administrativeTerritoriesList;
    }
}
