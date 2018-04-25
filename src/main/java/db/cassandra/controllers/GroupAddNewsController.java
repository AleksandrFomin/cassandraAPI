package db.cassandra.controllers;

import db.cassandra.classes.GroupAddImage;
import db.cassandra.classes.GroupAddNews;
import db.cassandra.repositories.GroupAddImageRepository;
import db.cassandra.repositories.GroupAddNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/groupaddnews")
public class GroupAddNewsController {
    @Autowired
    GroupAddNewsRepository groupAddNewsRepository;

    @GetMapping("/findall")
    public List<GroupAddNews> findAll() {
        return groupAddNewsRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public List<GroupAddNews> findById(@PathVariable Integer id) {
        return groupAddNewsRepository.findByGroupId(id);
    }

    @GetMapping("/add/{id1}/{id2}/{actionDate}")
    public void addFriend(@PathVariable Integer id1,
                          @PathVariable Integer id2,
                          @PathVariable String actionDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        groupAddNewsRepository.save(new GroupAddNews(id1, id2, format.parse(actionDate)));
    }

    @GetMapping("/removebyid/{id1}/{id2}")
    public void removeFriend(@PathVariable Integer id1,
                             @PathVariable Integer id2){
        groupAddNewsRepository.removeById(id1, id2);
    }
}
