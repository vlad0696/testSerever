package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DenisNS on 15.08.2017.
 */

// Действия с лицензией
@Entity
@Table(name = "LicenseAction")
public class LicenseAction extends BasicEntityTwoDate{

    //Код действия
    @Column(name = "CodeAction")
    public Integer CodeAction;

    //Наименование действия
    @Column(name = "Name",length = 512)
    public String Name;

    // Кросс-таблица. действия с лицензией
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="LicenseAction_Id")
    public List<LicenseActionCross> licenseActionCrossList;







    public Integer getCodeAction() {
        return CodeAction;
    }

    public void setCodeAction(Integer codeAction) {
        CodeAction = codeAction;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<LicenseActionCross> getLicenseActionCrossList() {
        return licenseActionCrossList;
    }

    public void setLicenseActionCrossList(List<LicenseActionCross> licenseActionCrossList) {
        this.licenseActionCrossList = licenseActionCrossList;
    }
}
