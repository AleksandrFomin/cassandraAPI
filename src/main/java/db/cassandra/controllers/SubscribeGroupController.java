package db.cassandra.controllers;

import db.cassandra.classes.GroupAddVideo;
import db.cassandra.classes.SubscribeGroup;
import db.cassandra.repositories.GroupAddVideoRepository;
import db.cassandra.repositories.SubscribeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/subscribegroup")
public class SubscribeGroupController {
    @Autowired
    SubscribeGroupRepository subscribeGroupRepository;

    @GetMapping("/findall")
    public List<SubscribeGroup> findAll() {
        return subscribeGroupRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public List<SubscribeGroup> findById(@PathVariable Integer id) {
        return subscribeGroupRepository.findByUserId(id);
    }

    @GetMapping("/add/{id1}/{id2}/{actionDate}")
    public void addFriend(@PathVariable Integer id1,
                          @PathVariable Integer id2,
                          @PathVariable String actionDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        subscribeGroupRepository.save(new SubscribeGroup(id1, id2, format.parse(actionDate)));
    }

    @GetMapping("/removebyid/{id1}/{id2}")
    public void removeFriend(@PathVariable Integer id1,
                             @PathVariable Integer id2){
        subscribeGroupRepository.removeById(id1, id2);
    }
}
