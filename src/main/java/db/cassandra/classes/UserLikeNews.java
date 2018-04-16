package db.cassandra.classes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Table;
import java.util.Date;

@Table
public class UserLikeNews {
    public UserLikeNews(Integer userId, Integer newsId, Date actionDate) {
        this.userId = userId;
        this.newsId = newsId;
        this.actionDate = actionDate;
    }

    @Getter
    @Setter
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Integer userId;

    @Getter
    @Setter
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer newsId;

    @Getter
    @Setter
    private Date actionDate;

}
