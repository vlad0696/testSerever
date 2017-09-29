package org.ipps.sisslr.models;

import javax.persistence.*;
import java.security.PublicKey;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//
/// содержит информацию о юридических лицах и индивидуальных предпринимателях
//
@Entity
@Table(name="ULandiE")
public class ULandiE extends BasicEntityTwoDate {

    //
    //Учетный номер налогоплательщика
    //
    @Column(name="Unp",length = 9)
    public String Unp;

    //
    //Наименование (полное) юр. лица (ИП)
    //
    @Column(name="Name",length = 600)
    public String Name;

    //
    //Наименование (краткое) юр. лица (ИП)
    //
    @Column(name="NameShort",length = 500)
    public String NameShort;

    //
    //Адрес
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Address_Id")
    public Address Address_Id;

    //Электронная почта
    @Column(name = "Email")
    public String Email;

    //Номер телефона
    @Column(name = "NumberPhone",length = 15)
    public String NumberPhone;

    //
    //Организационно-правовая форма
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TypeOfCompany_Id")
    public TypeOfCompany TypeOfCompany_Id;

    //
    //Наименование регистрирующего органа
    //
    @Column(name="RegistrationAuthority")
    public String RegistrationAuthority;

    //
    //Признак (2 - ЮЛ или 1 - ИП), указывающий, чья информация  сохранена в записи
    //1 - ИП
    //2 - Физ. лица.
    //3 - Иностр.орг.
    //
    @Column(name="Type")
    public String Type;

    //
    //налоговый орган
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TaxInspection_Id")
    public TaxInspection TaxInspection_Id;

    //Связь с лицензиями
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ULandiЕ_Id")
    public List<License> licenseList;








    public TaxInspection getTaxInspection_Id() {
        return TaxInspection_Id;
    }

    public void setTaxInspection_Id(TaxInspection taxInspection_Id) {
        TaxInspection_Id = taxInspection_Id;
    }

    public String getUnp() {
        return Unp;
    }

    public void setUnp(String unp) {
        Unp = unp;
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

    public Address getAddress_Id() {
        return Address_Id;
    }

    public void setAddress_Id(Address address_Id) {
        Address_Id = address_Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumberPhone() {
        return NumberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        NumberPhone = numberPhone;
    }

    public TypeOfCompany getTypeOfCompany_Id() {
        return TypeOfCompany_Id;
    }

    public void setTypeOfCompany_Id(TypeOfCompany typeOfCompany_Id) {
        TypeOfCompany_Id = typeOfCompany_Id;
    }

    public String getRegistrationAuthority() {
        return RegistrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        RegistrationAuthority = registrationAuthority;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<License> getLicenseList() {
        return licenseList;
    }

    public void setLicenseList(List<License> licenseList) {
        this.licenseList = licenseList;
    }


}
