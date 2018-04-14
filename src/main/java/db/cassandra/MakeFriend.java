package db.cassandra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Table;
import java.util.Date;

@Table
public class MakeFriend {
    public MakeFriend(Integer personId1, Integer personId2, Date actionDate) {
        this.personId1 = personId1;
        this.personId2 = personId2;
        this.actionDate = actionDate;
    }

    @Getter
    @Setter
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Integer personId1;

    @Getter
    @Setter
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer personId2;

    @Getter
    @Setter
    private Date actionDate;

}
