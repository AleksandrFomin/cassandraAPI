package db.cassandra.classes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Table;
import java.util.Date;

@Table
public class GroupAddNews {
    public GroupAddNews(Integer groupId, Integer newsId, Date actionDate) {
        this.groupId = groupId;
        this.newsId = newsId;
        this.actionDate = actionDate;
    }

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Integer groupId;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer newsId;

    private Date actionDate;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}