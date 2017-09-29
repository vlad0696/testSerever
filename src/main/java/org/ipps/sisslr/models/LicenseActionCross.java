package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

// Кросс-таблица. действия с лицензией
@Entity
@Table(name = "LicenseActionCross")
public class LicenseActionCross extends BasicEntityTwoDate {

    @Column(name="RegisterNumber")
    public String RegisterNumber;

    @Column(name="NumberDeсision")
    public String NumberDeсision;

    //   особые лиц. требования и условия   (в таблице АисМинсвязи это поле называется Comment)
    @Column(name="AdvancedRequests")
    public String AdvancedRequests;

    //Действия с лицензиями
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LicenseAction_Id")
    public LicenseAction LicenseAction_Id;

    //Лицензии
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "License_Id")
    public License License_Id;

    ////Кросс таблица связывающая Территории, услуги и действия с лицензией
    @OneToMany(fetch = FetchType.LAZY,mappedBy ="LicenseActionCross_Id" )
    public List<LicenseServicesCross> licenseServicesCrossList;


    public String getRegisterNumber() {
        return RegisterNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        RegisterNumber = registerNumber;
    }

    public String getNumberDeсision() {
        return NumberDeсision;
    }

    public void setNumberDeсision(String numberDeсision) {
        NumberDeсision = numberDeсision;
    }

    public String getAdvancedRequests() {
        return AdvancedRequests;
    }

    public void setAdvancedRequests(String advancedRequests) {
        AdvancedRequests = advancedRequests;
    }

    public LicenseAction getLicenseAction_Id() {
        return LicenseAction_Id;
    }

    public void setLicenseAction_Id(LicenseAction licenseAction_Id) {
        LicenseAction_Id = licenseAction_Id;
    }

    public License getLicense_Id() {
        return License_Id;
    }

    public void setLicense_Id(License license_Id) {
        License_Id = license_Id;
    }

    public List<LicenseServicesCross> getLicenseServicesCrossList() {
        return licenseServicesCrossList;
    }

    public void setLicenseServicesCrossList(List<LicenseServicesCross> licenseServicesCrossList) {
        this.licenseServicesCrossList = licenseServicesCrossList;
    }
}
