package db.cassandra;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class TestTable {

    public TestTable(Integer id, Integer n) {
        this.id = id;
        this.n = n;
    }

    @PrimaryKey
    private Integer id;

    private Integer n;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }
}
