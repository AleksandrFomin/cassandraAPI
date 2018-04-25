package db.cassandra.controllers;

import db.cassandra.classes.GroupAddNews;
import db.cassandra.classes.GroupAddVideo;
import db.cassandra.repositories.GroupAddNewsRepository;
import db.cassandra.repositories.GroupAddVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/groupaddvideo")
public class GroupAddVideoController {
    @Autowired
    GroupAddVideoRepository groupAddVideoRepository;

    @GetMapping("/findall")
    public List<GroupAddVideo> findAll() {
        return groupAddVideoRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public List<GroupAddVideo> findById(@PathVariable Integer id) {
        return groupAddVideoRepository.findByGroupId(id);
    }

    @GetMapping("/add/{id1}/{id2}/{actionDate}")
    public void addFriend(@PathVariable Integer id1,
                          @PathVariable Integer id2,
                          @PathVariable String actionDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        groupAddVideoRepository.save(new GroupAddVideo(id1, id2, format.parse(actionDate)));
    }

    @GetMapping("/removebyid/{id1}/{id2}")
    public void removeFriend(@PathVariable Integer id1,
                             @PathVariable Integer id2){
        groupAddVideoRepository.removeById(id1, id2);
    }
}
