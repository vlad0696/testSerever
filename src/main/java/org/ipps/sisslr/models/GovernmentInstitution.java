package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

// Органы государственной власти и управления. Министерства
@Entity
@Table(name="GovernmentInstitution")
public class GovernmentInstitution extends BasicEntity {

    //Код органа гос. власти
    @Column(name = "CodeGovernmentInstitution")
    public Integer CodeGovernmentInstitution;

    //Наименование органа гос. власти
    @Column(name = "Name",length = 512)
    public String Name;

    //Сокращенное наименование органа гос. власти
    @Column(name="NameCut",length = 128)
    public  String NameCut;

    //Код родителя органа гос. власти
    @Column(name = "ParentId")
    public Integer ParentId;

    //Связь с Лицензирующими органами
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="GovernmentInstitution_Id" )
    public List<LicensedInstitution> licensedInstitution;





    public Integer getCodeGovernmentInstitution() {
        return CodeGovernmentInstitution;
    }

    public void setCodeGovernmentInstitution(Integer codeGovernmentInstitution) {
        CodeGovernmentInstitution = codeGovernmentInstitution;
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

    public Integer getParentId() {
        return ParentId;
    }

    public void setParentId(Integer parentId) {
        ParentId = parentId;
    }

    public List<org.ipps.sisslr.models.LicensedInstitution> getLicensedInstitution() {
        return licensedInstitution;
    }

    public void setLicensedInstitution(List<org.ipps.sisslr.models.LicensedInstitution> licensedInstitution) {
        licensedInstitution = licensedInstitution;
    }

}