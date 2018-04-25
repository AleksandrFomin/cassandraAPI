package db.cassandra.classes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Table;
import java.util.Date;

@Table
public class UserRepostNews {
    public UserRepostNews(Integer userId, Integer newsId, Date actionDate) {
        this.userId = userId;
        this.newsId = newsId;
        this.actionDate = actionDate;
    }

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Integer userId;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer newsId;

    private Date actionDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
