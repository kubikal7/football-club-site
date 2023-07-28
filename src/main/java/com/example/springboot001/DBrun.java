package com.example.springboot001;

import com.example.springboot001.model.Game;
import com.example.springboot001.model.Player;
import com.example.springboot001.repository.GamesRepository;
import com.example.springboot001.repository.PlayersRepository;
import com.example.springboot001.model.Post;
import com.example.springboot001.repository.PostsRepository;
import com.example.springboot001.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DBrun implements CommandLineRunner {

    @Autowired
    PlayersRepository playersRepository;

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    GamesRepository gamesRepository;

    List<Player>players = List.of(
            new Player("Wojciech","Szczesny","Polska",'B',190.5f,70f,"Prawa",1),
            new Player("Lukasz","Skorupski","Polska",'B',188.5f,88.5f,"Prawa",34),
            new Player("Sebastian","Sebastianski","Peru",'B',160f,60f,"Prawa",22),

            new Player("Kamil","Glik","Polska",'O',182.5f,83.5f,"Prawa",3),
            new Player("Xen","Loss","Francja",'O',177.5f,80f,"Lewa",5),

            new Player("Jakub","Moder","Polska",'P',182f,90f,"Prawa",8),
            new Player("Mateusz","Mateuszynski","Ghana",'P',172.5f,69.5f,"Lewa",17),
            new Player("Jakub","Jakubski","Niemcy",'P',192.5f,92f,"Prawa",15),
            new Player("Hubert","Modolop","Polska",'P',182f,90.5f,"Lewa",13),

            new Player("Robert","Lewandowski","Polska",'N',180.5f,80.5f,"Prawa",9,"https://upload.wikimedia.org/wikipedia/commons/a/ad/Robert_Lewandowski_2018_%28cropped%29.jpg")

    );

    List<Post>posts=List.of(
            new Post("Pierwszy","description description description description description descriptiondescription description description description description description description description descriptiondescription description description ","https://cdn.galleries.smcloud.net/t/galleries/gf-4ZoU-g1Kv-ywEn_16-ciekawostek-o-pilce-noznej-1920x1080-nocrop.jpg", LocalDateTime.now()),
            new Post("Pierwszy","description description description description description descriptiondescription description description","https://cdn.galleries.smcloud.net/t/galleries/gf-4ZoU-g1Kv-ywEn_16-ciekawostek-o-pilce-noznej-1920x1080-nocrop.jpg", LocalDateTime.now()),
            new Post("Pierwszy","description description description description description descriptiondescription description description","https://cdn.galleries.smcloud.net/t/galleries/gf-4ZoU-g1Kv-ywEn_16-ciekawostek-o-pilce-noznej-1920x1080-nocrop.jpg", LocalDateTime.now()),
            new Post("Pierwszy","description description description description description descriptiondescription description description","https://cdn.galleries.smcloud.net/t/galleries/gf-4ZoU-g1Kv-ywEn_16-ciekawostek-o-pilce-noznej-1920x1080-nocrop.jpg", LocalDateTime.now()),
            new Post("Pierwszy","description description description description description descriptiondescription description description description description description description description descriptiondescription description description ","https://cdn.galleries.smcloud.net/t/galleries/gf-4ZoU-g1Kv-ywEn_16-ciekawostek-o-pilce-noznej-1920x1080-nocrop.jpg", LocalDateTime.now()),
            new Post("Pierwszy","description description description description description descriptiondescription description description","https://cdn.galleries.smcloud.net/t/galleries/gf-4ZoU-g1Kv-ywEn_16-ciekawostek-o-pilce-noznej-1920x1080-nocrop.jpg", LocalDateTime.now()),
            new Post("Pierwszy","description description description description description descriptiondescription description description","https://cdn.galleries.smcloud.net/t/galleries/gf-4ZoU-g1Kv-ywEn_16-ciekawostek-o-pilce-noznej-1920x1080-nocrop.jpg", LocalDateTime.now()),
            new Post("Pierwszy","description description description description description descriptiondescription description description","https://cdn.galleries.smcloud.net/t/galleries/gf-4ZoU-g1Kv-ywEn_16-ciekawostek-o-pilce-noznej-1920x1080-nocrop.jpg", LocalDateTime.now())
    );

    List<Game> games=List.of(
            new Game("Legia Warszawa",'D' ,LocalDateTime.now(),false,null),
            new Game("Lech Poznań",'W' ,LocalDateTime.now(),true,"2:0"),
            new Game("Lechia Gdansk",'D' ,LocalDateTime.now(),true,"3:2"),
            new Game("FC Barcelona",'N' ,LocalDateTime.now(),false,null),
            new Game("FC po nalewce",'D' ,LocalDateTime.now(),true,"0:0")
    );

    @Override
    public void run(String... args) throws Exception {
        playersRepository.saveAll(players);
        postsRepository.saveAll(posts);
        gamesRepository.saveAll(games);
    }
}
