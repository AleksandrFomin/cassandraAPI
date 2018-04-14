package db.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
@RestController
@RequestMapping(value = "/persons", method = RequestMethod.GET)
public interface MakeFriendRepository extends CassandraRepository<MakeFriend,Integer> {
    @RequestMapping("/findfriends")
    @Query(value = "SELECT * FROM makefriends")
    List<MakeFriend> findAll();


}
