package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

// Лицензирующие органы
@Entity
@Table(name="LicensedInstitution")
public class LicensedInstitution extends BasicEntity {

    //Код лицензирующего органа
    @Column(name="CodeLicensedInstitution")
    public Integer CodeLicensedInstitution;

    //Имя лицензирующего органа
    @Column(name="Name")
    public String Name;

    //Сокращенное имя лицензирующего органа
    @Column(name="NameCut")
    public String NameCut;

    //Связь лицензирующего органа с вышестоящим гос. органом
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GovernmentInstitution_Id",nullable = false)
   public GovernmentInstitution GovernmentInstitution_Id;

    //Связь с видами деятельности
    @OneToMany(fetch =FetchType.LAZY,mappedBy ="LicensedInstitution_Id" )
    public List<LicenseActivity> licenseActivityList;




    public Integer getCodeLicensedInstitution() {
        return CodeLicensedInstitution;
    }

    public void setCodeLicensedInstitution(Integer codeLicensedInstitution) {
        CodeLicensedInstitution = codeLicensedInstitution;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNameCut() {
        return NameCut;
    }

    public void setNameCut(String nameCut) {
        NameCut = nameCut;
    }

    public GovernmentInstitution getGovernmentInstitution_Id() {
        return GovernmentInstitution_Id;
    }

    public void setGovernmentInstitution_Id(GovernmentInstitution governmentInstitution_Id) {
        GovernmentInstitution_Id = governmentInstitution_Id;
    }

    public List<LicenseActivity> getLicenseActivityList() {
        return licenseActivityList;
    }

    public void setLicenseActivityList(List<LicenseActivity> licenseActivityList) {
        this.licenseActivityList = licenseActivityList;
    }
}
