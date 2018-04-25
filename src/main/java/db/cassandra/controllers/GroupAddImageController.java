package db.cassandra.controllers;

import db.cassandra.classes.AddFriend;
import db.cassandra.classes.GroupAddImage;
import db.cassandra.repositories.AddFriendRepository;
import db.cassandra.repositories.GroupAddImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/groupaddimage")
public class GroupAddImageController {
    @Autowired
    GroupAddImageRepository groupAddImageRepository;

    @GetMapping("/findall")
    public List<GroupAddImage> findAll() {
        return groupAddImageRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public List<GroupAddImage> findById(@PathVariable Integer id) {
        return groupAddImageRepository.findByGroupId(id);
    }

    @GetMapping("/add/{id1}/{id2}/{actionDate}")
    public void addFriend(@PathVariable Integer id1,
                          @PathVariable Integer id2,
                          @PathVariable String actionDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        groupAddImageRepository.save(new GroupAddImage(id1, id2, format.parse(actionDate)));
    }

    @GetMapping("/removebyid/{id1}/{id2}")
    public void removeFriend(@PathVariable Integer id1,
                             @PathVariable Integer id2){
        groupAddImageRepository.removeById(id1, id2);
    }
}
