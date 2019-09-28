package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootballController {

	@RequestMapping("/")
    public String get(@RequestParam(defaultValue="World") String action) throws MalformedURLException, IOException {
    	return "FootBall Tournament";
    }

    @RequestMapping("/football/countries")
    public String getCountries(@RequestParam(defaultValue="World") String action) throws MalformedURLException, IOException {
    	String url = "https://apiv2.apifootball.com/?action=get_countries&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    	InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          return jsonText;
        } finally {
          is.close();
        }
    }
    
    @RequestMapping("/football/teams")
    public String getTeams(@RequestParam(defaultValue="World") String action) throws MalformedURLException, IOException {
    	String url = "https://apiv2.apifootball.com/?action=get_teams&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    	InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          return jsonText;
        } finally {
          is.close();
        }
    }
    
    @RequestMapping("/football/league")
    public String greeting(@RequestParam(defaultValue="World") String action) throws MalformedURLException, IOException {
    	String url = "https://apiv2.apifootball.com/?action=get_leagues&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    	InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          return jsonText;
        } finally {
          is.close();
        }
    }
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }
    
}