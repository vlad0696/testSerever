package org.ipps.sisslr.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//Лицензии
@Entity
@Table(name="License")
public class License extends BasicEntityTwoDate {

    //
    //Владелец лицензии UNP. В Ulandie должны быть ссылки на адрес и населенный пункт
    //
    @Column(name="UnpEgr")
    public BigInteger UnpEgr;


    //
    //Владелец лицензии Id. Справочник филиал или юр лицо в справочнике
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ULandiЕ_Id")
    private ULandiE ULandiЕ_Id;

    //
    //номер в реестре лицензий
    //
    @Column(name="RegisterNumber")
    public BigInteger RegisterNumber;

    //
    // номер бланка строгой отчётности
    //
    @Column(name="NumberForm")
    public String NumberForm;

    //
    //электронный номер лицензии
    //
    @Column(name="ElectronicNumber")
    public String ElectronicNumber;

    //
    //вид деятельности. В виде деятельности необходима ссылка на министерство
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LicenseActivity_Id")
    public LicenseActivity LicenseActivity_Id;

    //
    //номер решения коллегии о выдаче лицензии
    //
    @Column(name="NumberDesicion")
    public String NumberDesicion;

    //
    //Особые лицензинонные требования
    //
    @Column(name="AdvancedRequests")
    public String AdvancedRequests;

    //ссылка на Кросс-таблица. действия с лицензией
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "License_Id")
    public List<LicenseActionCross> licenseActionCrossList;

    //ссылка на Кросс таблица связывающая Территории, услуги и действия с лицензией
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "License_Id")
    public List<LicenseServicesCross> licenseServicesCrossList;



    public BigInteger getUnpEgr() {
        return UnpEgr;
    }

    public void setUnpEgr(BigInteger unpEgr) {
        UnpEgr = unpEgr;
    }

    public ULandiE getULandiЕ_Id() {
        return ULandiЕ_Id;
    }

    public void setULandiЕ_Id(ULandiE ULandiЕ_Id) {
        this.ULandiЕ_Id = ULandiЕ_Id;
    }

    public BigInteger getRegisterNumber() {
        return RegisterNumber;
    }

    public void setRegisterNumber(BigInteger registerNumber) {
        RegisterNumber = registerNumber;
    }

    public String getNumberForm() {
        return NumberForm;
    }

    public void setNumberForm(String numberForm) {
        NumberForm = numberForm;
    }

    public String getElectronicNumber() {
        return ElectronicNumber;
    }

    public void setElectronicNumber(String electronicNumber) {
        ElectronicNumber = electronicNumber;
    }

    public LicenseActivity getLicenseActivity_Id() {
        return LicenseActivity_Id;
    }

    public void setLicenseActivity_Id(LicenseActivity licenseActivity_Id) {
        LicenseActivity_Id = licenseActivity_Id;
    }

    public String getNumberDesicion() {
        return NumberDesicion;
    }

    public void setNumberDesicion(String numberDesicion) {
        NumberDesicion = numberDesicion;
    }

    public String getAdvancedRequests() {
        return AdvancedRequests;
    }

    public void setAdvancedRequests(String advancedRequests) {
        AdvancedRequests = advancedRequests;
    }

    public List<LicenseActionCross> getLicenseActionCrossList() {
        return licenseActionCrossList;
    }

    public void setLicenseActionCrossList(List<LicenseActionCross> licenseActionCrossList) {
        this.licenseActionCrossList = licenseActionCrossList;
    }

    public List<LicenseServicesCross> getLicenseServicesCrossList() {
        return licenseServicesCrossList;
    }

    public void setLicenseServicesCrossList(List<LicenseServicesCross> licenseServicesCrossList) {
        this.licenseServicesCrossList = licenseServicesCrossList;
    }
}
