package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//Территория действия услуги
@Entity
@Table(name = "LicensedTerritory")
public class LicensedTerritory extends BasicEntity {

    //Наименование территории
    @Column(name = "Name", length = 512)
    public String Name;

    //Вышестоящая Административное территориальная единица
    @Column(name = "ParentId")
    public Integer ParentId;

    //Административно территориальная единица
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AdministrativeTerritories_Id")
    public AdministrativeTerritories AdministrativeTerritories_Id;

    //Кросс таблица связывающая Территории, услуги и действия с лицензией
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "LicensedTerritory_Id")
    public List<LicenseServicesCross> licenseServicesCrossList;






    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getParentId() {
        return ParentId;
    }

    public void setParentId(Integer parentId) {
        ParentId = parentId;
    }

    public AdministrativeTerritories getAdministrativeTerritories_Id() {
        return AdministrativeTerritories_Id;
    }

    public void setAdministrativeTerritories_Id(AdministrativeTerritories administrativeTerritories_Id) {
        AdministrativeTerritories_Id = administrativeTerritories_Id;
    }

    public List<LicenseServicesCross> getLicenseServicesCrossList() {
        return licenseServicesCrossList;
    }

    public void setLicenseServicesCrossList(List<LicenseServicesCross> licenseServicesCrossList) {
        this.licenseServicesCrossList = licenseServicesCrossList;
    }
}
