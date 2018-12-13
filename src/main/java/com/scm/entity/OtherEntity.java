package com.scm.entity;

import javax.persistence.*;

@Entity
@Table(name = "other")
public class OtherEntity {
    private int id;
    private String value;
    private int status;
    private String src;
    private PointsEntity pointsEntity;
    @OneToOne
    @JoinColumn(name = "point_id")
    public PointsEntity getPointsEntity() {
        return pointsEntity;
    }

    public void setPointsEntity(PointsEntity pointsEntity) {
        this.pointsEntity = pointsEntity;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "src")
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OtherEntity that = (OtherEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (src != null ? !src.equals(that.src) : that.src != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (src != null ? src.hashCode() : 0);
        return result;
    }
}
