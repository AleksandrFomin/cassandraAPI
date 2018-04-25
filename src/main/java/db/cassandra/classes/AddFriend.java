package db.cassandra.classes;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Table;
import java.util.Date;

@Table
public class AddFriend {
    public AddFriend(Integer personId1, Integer personId2, Date actionDate) {
        this.personId1 = personId1;
        this.personId2 = personId2;
        this.actionDate = actionDate;
    }

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Integer personId1;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer personId2;

    private Date actionDate;

    public Integer getPersonId1() {
        return personId1;
    }

    public void setPersonId1(Integer personId1) {
        this.personId1 = personId1;
    }

    public Integer getPersonId2() {
        return personId2;
    }

    public void setPersonId2(Integer personId2) {
        this.personId2 = personId2;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}
