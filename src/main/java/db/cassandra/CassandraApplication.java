package db.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CassandraApplication {

    @Autowired
    MakeFriendRepository makeFriendRepository;

    public static void main(String[] args) {

        SpringApplication.run(CassandraApplication.class, args);
//        Cluster cluster = Cluster.builder()
//                .addContactPoints("127.0.0.1").withPort(9142).build();
//        Session session = cluster.connect();
//        MakeFriendRepository makeFriendRepository = new ;
//        Iterable<MakeFriend> makeFriends = makeFriendRepository.findAll();
    }

//    @Bean
//    public int find(){
//            MakeFriend makeFriends = new MakeFriend(1, 5, new Date());
//            makeFriendRepository.save(makeFriends);
//        return 0;
//    }
}
