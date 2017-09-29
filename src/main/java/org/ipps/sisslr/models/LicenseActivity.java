package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;


/**
 * Created by DenisNS on 15.08.2017.
 */

 //
//Лицензируемые виды деятельности
 //
@Entity
@Table(name="LicenseActivity")
public class LicenseActivity extends BasicEntityTwoDate {

    //
    //Код Вид деятельности
    //
    @Column(name="CodeActivity")
    public Integer CodeActivity;

    //
    //Наименование Лицензируемого вида деятельности
    //
   @Column(name="Name")
    public String Name;


   //Связь вида деятельности  с вышестоящим гос. органом
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LicensedInstitution_Id")
    public LicensedInstitution LicensedInstitution_Id;

    //Связь вида деятельности  с лицензиями
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "LicenseActivity_Id")
    public List<License> licenseList;

    //Связь с услугами и работами
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "LicenseActivity_Id")
    public List<LicenseServices> licenseServicesList;






    public Integer getCodeActivity() {
        return CodeActivity;
    }

    public void setCodeActivity(Integer codeActivity) {
        CodeActivity = codeActivity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LicensedInstitution getLicensedInstitution_Id() {
        return LicensedInstitution_Id;
    }

    public void setLicensedInstitution_Id(LicensedInstitution licensedInstitution_Id) {
        LicensedInstitution_Id = licensedInstitution_Id;
    }

    public List<License> getLicenseList() {
        return licenseList;
    }

    public void setLicenseList(List<License> licenseList) {
        this.licenseList = licenseList;
    }

    public List<LicenseServices> getLicenseServicesList() {
        return licenseServicesList;
    }

    public void setLicenseServicesList(List<LicenseServices> licenseServicesList) {
        this.licenseServicesList = licenseServicesList;
    }
}
