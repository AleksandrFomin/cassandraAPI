package db.cassandra.classes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Table;
import java.util.Date;

@Table
public class UserLikeImage {
    public UserLikeImage(Integer userId, Integer imageId, Date actionDate) {
        this.userId = userId;
        this.imageId = imageId;
        this.actionDate = actionDate;
    }

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Integer userId;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer imageId;

    private Date actionDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}
