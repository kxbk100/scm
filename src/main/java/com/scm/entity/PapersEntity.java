package com.scm.entity;

import javax.persistence.*;

@Entity
@Table(name = "papers")
public class PapersEntity {
    private int id;
    private String title;
    private int firstType;
    private String member;
    private int paperType;
    private int status;
    private String src;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "firstType")
    public int getFirstType() {
        return firstType;
    }

    public void setFirstType(int firstType) {
        this.firstType = firstType;
    }

    @Basic
    @Column(name = "member")
    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    @Basic
    @Column(name = "paperType")
    public int getPaperType() {
        return paperType;
    }

    public void setPaperType(int paperType) {
        this.paperType = paperType;
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

        PapersEntity that = (PapersEntity) o;

        if (id != that.id) return false;
        if (firstType != that.firstType) return false;
        if (paperType != that.paperType) return false;
        if (status != that.status) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (src != null ? !src.equals(that.src) : that.src != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + firstType;
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + paperType;
        result = 31 * result + status;
        result = 31 * result + (src != null ? src.hashCode() : 0);
        return result;
    }
}
