package com.scm.entity;

import javax.persistence.*;

@Entity
@Table(name = "targets", schema = "zjscmic")
public class TargetsEntity {
    private int id;
    private String first;
    private String second;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first")
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Basic
    @Column(name = "second")
    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TargetsEntity that = (TargetsEntity) o;

        if (id != that.id) return false;
        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        if (second != null ? !second.equals(that.second) : that.second != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
