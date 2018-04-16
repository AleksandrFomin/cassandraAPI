package db.cassandra.classes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Table;
import java.util.Date;

@Table
public class GroupAddImage {
    public GroupAddImage(Integer groupId, Integer imageId, Date actionDate) {
        this.groupId = groupId;
        this.imageId = imageId;
        this.actionDate = actionDate;
    }

    @Getter
    @Setter
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Integer groupId;

    @Getter
    @Setter
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer imageId;

    @Getter
    @Setter
    private Date actionDate;

}