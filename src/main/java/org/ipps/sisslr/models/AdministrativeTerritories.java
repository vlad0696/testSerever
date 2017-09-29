package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

//Административное территориальная еденица
@Entity
@Table(name = "AdministrativeTerritories")
public class AdministrativeTerritories extends BasicEntityTwoDate {

    // Код соато
    @Column(name = "SOATO",length = 10)
    public String SOATO;

    // Уникальный Код  административно-территориальной единицы (АТЕ), который всегда уникальный на протяжении всех историй
    @Column(name = "LocalityCode")
    public Integer LocalityCode;

    // наименование населенного пункта
    @Column(name = "LocalityName",length = 100)
    public String LocalityName;

    // код области
    @Column(name = "RegionCode")
    public  Integer RegionCode;

    // Наименование области
    @Column(name = "RegionName",length = 75)
    public  String RegionName;

    // код района
    @Column (name ="DistrictCode")
    public Integer DistrictCode;

    // наименование района
    @Column (name = "DistrictName",length = 75)
    public String DistrictName;

    // код сельсовета
    @Column (name = "SovetCode")
    public Integer SovetCode;

    // наименование сельсовета
    @Column (name = "SovetName",length = 75)
    public String SovetName;

    // Тип населенного пункта
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeLocality_Id")
    public TypeLocality TypeLocality_Id;

    // Код родительского соато
    @Column(name = "PSOATO",length = 10)
    public String PSOATO;



    //Связь с территориями действия лицензий
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "AdministrativeTerritories_Id")
    public List<LicensedTerritory> licensedTerritoryList;








    public String getSOATO() {
        return SOATO;
    }

    public void setSOATO(String SOATO) {
        this.SOATO = SOATO;
    }

    public Integer getLocalityCode() {
        return LocalityCode;
    }

    public void setLocalityCode(Integer localityCode) {
        LocalityCode = localityCode;
    }

    public String getLocalityName() {
        return LocalityName;
    }

    public void setLocalityName(String localityName) {
        LocalityName = localityName;
    }

    public Integer getRegionCode() {
        return RegionCode;
    }

    public void setRegionCode(Integer regionCode) {
        RegionCode = regionCode;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String regionName) {
        RegionName = regionName;
    }

    public Integer getDistrictCode() {
        return DistrictCode;
    }

    public void setDistrictCode(Integer districtCode) {
        DistrictCode = districtCode;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }

    public Integer getSovetCode() {
        return SovetCode;
    }

    public void setSovetCode(Integer sovetCode) {
        SovetCode = sovetCode;
    }

    public String getSovetName() {
        return SovetName;
    }

    public void setSovetName(String sovetName) {
        SovetName = sovetName;
    }

    public TypeLocality getTypeLocality_Id() {
        return TypeLocality_Id;
    }

    public void setTypeLocality_Id(TypeLocality typeLocality_Id) {
        TypeLocality_Id = typeLocality_Id;
    }

    public String getPSOATO() {
        return PSOATO;
    }

    public void setPSOATO(String PSOATO) {
        this.PSOATO = PSOATO;
    }


    public List<LicensedTerritory> getLicensedTerritoryList() {
        return licensedTerritoryList;
    }

    public void setLicensedTerritoryList(List<LicensedTerritory> licensedTerritoryList) {
        this.licensedTerritoryList = licensedTerritoryList;
    }
}
