package com.example.springboot001.service;

import com.example.springboot001.model.Club;
import com.example.springboot001.model.Game;
import com.example.springboot001.model.Post;
import com.example.springboot001.repository.GamesRepository;
import com.example.springboot001.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final PostsRepository postsRepository;
    private final GamesRepository gamesRepository;

    public List<Post> getPosts(){
        List<Post> posts = postsRepository.findPage(PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC,"date")));
        return posts;
    }

    public List<Game> getFinishedGames(){
        List<Game> games = gamesRepository.findPageFinished(PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC,"date")));
        return games;
    }

    public List<Game> getFuturedGames(){
        List<Game> games = gamesRepository.findPageFutured(PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC,"date")));
        return games;
    }

    public List<Club> getLeagueTable() throws IOException {
        URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/lookuptable.php?l=4422&s=2023-2024");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        if(connection.getResponseCode()!=200){
            System.out.println("Response code not 200");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String str;
        StringBuffer stringBuffer = new StringBuffer();

        while((str = reader.readLine())!=null){
            stringBuffer.append(str);
        }

        JSONObject jsonObject = new JSONObject(stringBuffer.toString());
        JSONArray jsonTable = jsonObject.getJSONArray("table");
        List<Club> table = new ArrayList<>();
        for(int i=0;i<jsonTable.length();i++){
            JSONObject object = jsonTable.getJSONObject(i);
            Club club = new Club();
            club.setName(object.getString("strTeam"));
            club.setPoints(object.getInt("intPoints"));
            club.setRank(object.getInt("intRank"));
            table.add(club);
        }
        return table;
    }
}
