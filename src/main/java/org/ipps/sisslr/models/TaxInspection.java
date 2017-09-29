package org.ipps.sisslr.models;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

// Налоговая инспекция
@Entity
@Table(name = "TaxInspection")
public class TaxInspection extends BasicEntityTwoDate {

    // Код налоговой инспекции
    @Column(name = "CodeTaxInspection")
    public Integer CodeTaxInspection;

    // Наименование налоговой инспекции
    @Column(name = "Name",length = 512)
    public String Name;

    // E-mail налоговой инспекции
    @Column(name = "Mail")
    public String Mail;

    // ФИО руководителя
    @Column(name = "FIO")
    public String FIO;

    //Адресс
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Adress_Id")
    public Address Adress_Id;

    // Телефон
    @Column(name = "NumberPhone",length = 15)
    public String NumberPhone;

    // UNP налоговой инспекции
    @Column(name = "UNP",length = 9)
    public String UNP;

    //Связь с юридическими лицами и индивидуальными предпринимателями
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "TaxInspection_Id")
    public List<ULandiE> uLandiEList;






    public Integer getCodeTaxInspection() {
        return CodeTaxInspection;
    }

    public void setCodeTaxInspection(Integer codeTaxInspection) {
        CodeTaxInspection = codeTaxInspection;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Address getAdress_Id() {
        return Adress_Id;
    }

    public void setAdress_Id(Address adress_Id) {
        Adress_Id = adress_Id;
    }

    public String getNumberPhone() {
        return NumberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        NumberPhone = numberPhone;
    }

    public String getUNP() {
        return UNP;
    }

    public void setUNP(String UNP) {
        this.UNP = UNP;
    }

    public List<ULandiE> getuLandiEList() {
        return uLandiEList;
    }

    public void setuLandiEList(List<ULandiE> uLandiEList) {
        this.uLandiEList = uLandiEList;
    }
}
