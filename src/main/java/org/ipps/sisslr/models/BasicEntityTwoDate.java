package org.ipps.sisslr.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by DenisNS on 15.08.2017.
 */
//дополнительные поля, которые  наследуются сущностями
@MappedSuperclass
public class BasicEntityTwoDate extends BasicEntity {

    //
    //Дата начала действия
    //
    @Column(name="DateStart")
    public Date DateStart;

    //
    //Дата конца действия
    //
    @Column(name="DateEnd")
    public Date DateEnd;






    public Date getDateStart() {
        return DateStart;
    }

    public void setDateStart(Date dateStart) {
        DateStart = dateStart;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        DateEnd = dateEnd;
    }


}
