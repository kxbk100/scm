package entity;

import javax.persistence.*;

@Entity
@Table(name = "teams", schema = "zjscmic", catalog = "")
public class TeamsEntity {
    private int id;
    private Integer rank;
    private String name;
    private String member;
    private int status;
    private String src;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rank")
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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
    @Column(name = "member")
    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
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

        TeamsEntity that = (TeamsEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (rank != null ? !rank.equals(that.rank) : that.rank != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (src != null ? !src.equals(that.src) : that.src != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (src != null ? src.hashCode() : 0);
        return result;
    }
}
