package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//Кросс таблица связывающая Территории, услуги и действия с лицензией
@Entity
@Table(name = "LicenseServicesCross")
public class LicenseServicesCross extends BasicEntity {



    //Услуги
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LicenseServices_Id")
    public  LicenseServices LicenseServices_Id;

    //Территории
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LicensedTerritory_Id")
    public LicensedTerritory LicensedTerritory_Id;

    // Кросс-таблица. Действия-Услуги-Территории
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LicenseActionCross_Id")
    public  LicenseActionCross LicenseActionCross_Id;

    //ссылка на Лицензию
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "License_Id")
    public License License_Id;

    // Период. Дата начала действия услуги лицензии
    @Column(name = "StartDateTime")
    public Date StartDateTime;

    // Период. Дата конца действия услуги лицензии
    @Column(name = "EndDateTime")
    public Date EndDateTime;



    public LicenseServices getLicenseServices_Id() {
        return LicenseServices_Id;
    }

    public void setLicenseServices_Id(LicenseServices licenseServices_Id) {
        LicenseServices_Id = licenseServices_Id;
    }

    public LicensedTerritory getLicensedTerritory_Id() {
        return LicensedTerritory_Id;
    }

    public void setLicensedTerritory_Id(LicensedTerritory licensedTerritory_Id) {
        LicensedTerritory_Id = licensedTerritory_Id;
    }

    public LicenseActionCross getLicenseActionCross_Id() {
        return LicenseActionCross_Id;
    }

    public void setLicenseActionCross_Id(LicenseActionCross licenseActionCross_Id) {
        LicenseActionCross_Id = licenseActionCross_Id;
    }

    public License getLicense_Id() {
        return License_Id;
    }

    public void setLicense_Id(License license_Id) {
        License_Id = license_Id;
    }

    public Date getStartDateTime() {
        return StartDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        StartDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return EndDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        EndDateTime = endDateTime;
    }
}
