package org.ipps.sisslr.models;


import javax.jcr.query.qom.Join;
import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//Услуги видов деятельности
@Entity
@Table(name = "LicenseServices")
public class LicenseServices extends BasicEntityTwoDate{

    //Код услуги
    @Column(name = "CodeService")
    public Integer CodeService;

    //Наименование усгули
    @Column(name = "Name",length = 512)
    public String Name;

    //Ссылка на название группы услуг ( родительская запись)
    @Column(name = "Parent_Id")
    public Integer Parent_Id;

    //Виды деятельности
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LicenseActivity_Id")
    public LicenseActivity LicenseActivity_Id;

    //Кросс таблица связывающая Территории, услуги и действия с лицензией
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "LicenseServices_Id")
    public List<LicenseServicesCross> licenseServicesCrossList;









    public Integer getCodeService() {
        return CodeService;
    }

    public void setCodeService(Integer codeService) {
        CodeService = codeService;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getParent_Id() {
        return Parent_Id;
    }

    public void setParent_Id(Integer parent_Id) {
        Parent_Id = parent_Id;
    }

    public LicenseActivity getLicenseActivity_Id() {
        return LicenseActivity_Id;
    }

    public void setLicenseActivity_Id(LicenseActivity licenseActivity_Id) {
        LicenseActivity_Id = licenseActivity_Id;
    }

    public List<LicenseServicesCross> getLicenseServicesCrossList() {
        return licenseServicesCrossList;
    }

    public void setLicenseServicesCrossList(List<LicenseServicesCross> licenseServicesCrossList) {
        this.licenseServicesCrossList = licenseServicesCrossList;
    }
}
