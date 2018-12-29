package com.scm.entity;

import javax.persistence.*;

@Entity
@Table(name = "other")
public class OtherEntity {
    private int id;
    private float value;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value")
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
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
    public String toString() {
        return "OtherEntity{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", status=" + status +
                ", src='" + src + '\'' +
                ", entity=" + pointsEntity.getContent() +
                '}';
    }
}
