package db.cassandra;

import db.cassandra.classes.AddFriend;
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
public interface MakeFriendRepository extends CassandraRepository<AddFriend,Integer> {
    @RequestMapping("/findfriends")
    List<AddFriend> findAll();

    @RequestMapping(value = "/findById",params = {"id"})
    List<AddFriend> findByPersonId1(@RequestParam("id") Integer id);
}
