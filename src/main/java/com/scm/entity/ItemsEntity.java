package com.scm.entity;

import javax.persistence.*;

@Entity
@Table(name = "items", schema = "zjscmic")
public class ItemsEntity {

    private int id;
    private String name;
    private String leader;
    private int rank;
    private int type;
    private int isImportant;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "leader")
    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    @Basic
    @Column(name = "rank")
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "isImportant")
    public int getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(int isImportant) {
        this.isImportant = isImportant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsEntity that = (ItemsEntity) o;

        if (id != that.id) return false;
        if (rank != that.rank) return false;
        if (type != that.type) return false;
        if (isImportant != that.isImportant) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (leader != null ? !leader.equals(that.leader) : that.leader != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (leader != null ? leader.hashCode() : 0);
        result = 31 * result + rank;
        result = 31 * result + type;
        result = 31 * result + isImportant;
        return result;
    }
}
