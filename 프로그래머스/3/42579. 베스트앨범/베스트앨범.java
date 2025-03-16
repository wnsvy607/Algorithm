import java.util.*;

class Solution {
    
    Map<String, TreeSet<Song>> songs = new HashMap<>();
    Map<String, Integer> counts = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        
        int len = genres.length;
        
        
        for(int i = 0; i < len; i++) {
            int count = counts.getOrDefault(genres[i], 0);
            counts.put(genres[i], count + plays[i]);
            
            if(!songs.containsKey(genres[i])) songs.put(genres[i], new TreeSet<>());
            
            var gSet = songs.get(genres[i]);
            
            gSet.add(new Song(i, plays[i]));
            
        }
        
        
        TreeMap<Integer, String> ctm = new TreeMap<>( (a , b) -> {
            return Integer.compare(b, a);
        });
        
        for(var entry : counts.entrySet()) {
            String genre = entry.getKey();
            Integer count = entry.getValue();
            
            ctm.put(count, genre);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(var e : ctm.entrySet()) {
            String genre = e.getValue();
            
            var gSet = songs.get(genre);
            
            res.add(gSet.pollFirst().idx);
            if(!gSet.isEmpty()) res.add(gSet.pollFirst().idx);
        }
        
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Song implements Comparable<Song> { 
        
        int idx;
        int play;
        
        
        Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song s) {
            if(this.play == s.play)
                return Integer.compare(this.idx, s.idx);
            return Integer.compare(s.play, this.play);
            
        }
        
        
        
        
    }
}