package org.ipps.sisslr.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DenisNS on 15.08.2017.
 */

//поля этого класса наследуются сущностями
@MappedSuperclass
public abstract class BasicEntity {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //
    //Пользователь, который создал запись
    //
    @Column(name="OwnerId")
    public Integer OwnerId;

    //
    //Пользователь, который последний редактировал запись
    //
    @Column(name="LastEditorId")
    public Integer LastEditorId;

    //
    //Дата создания
    //
    @Column(name="DateCreate")
    public Date DateCreate;

    //
    //Дата последнего редактирования
    //
    @Column(name="DateLastEdit")
    public Date DateLastEdit;







    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(Integer ownerId) {
        OwnerId = ownerId;
    }

    public Integer getLastEditorId() {
        return LastEditorId;
    }

    public void setLastEditorId(Integer lastEditorId) {
        LastEditorId = lastEditorId;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }

    public Date getDateLastEdit() {
        return DateLastEdit;
    }

    public void setDateLastEdit(Date dateLastEdit) {
        DateLastEdit = dateLastEdit;
    }


}
