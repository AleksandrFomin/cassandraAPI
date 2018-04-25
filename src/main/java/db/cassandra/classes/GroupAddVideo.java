package db.cassandra.classes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Table;
import java.util.Date;

@Table
public class GroupAddVideo {
    public GroupAddVideo(Integer groupId, Integer videoId, Date actionDate) {
        this.groupId = groupId;
        this.videoId = videoId;
        this.actionDate = actionDate;
    }

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Integer groupId;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer videoId;

    private Date actionDate;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}