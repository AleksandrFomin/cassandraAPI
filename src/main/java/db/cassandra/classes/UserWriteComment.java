package db.cassandra.classes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Table;
import java.util.Date;

@Table
public class UserWriteComment {
    public UserWriteComment(Integer userId, Integer commentId, Integer newsId, Date actionDate) {
        this.userId = userId;
        this.commentId = commentId;
        this.newsId = newsId;
        this.actionDate = actionDate;
    }

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Integer userId;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer commentId;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer newsId;

    private Date actionDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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
