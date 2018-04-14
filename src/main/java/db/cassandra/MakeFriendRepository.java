package db.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
@RestController
@RequestMapping(value = "/friends", method = RequestMethod.GET)
public interface MakeFriendRepository extends CassandraRepository<MakeFriends,Integer> {
    @RequestMapping("/findfriends")
    List<MakeFriends> findAll();

    @RequestMapping(value = "/findById",params = {"id"})
    List<MakeFriends> findByPersonId1(@RequestParam("id") Integer id);
}
