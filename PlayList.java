import java.util.ArrayList;
import java.util.Collections;

class PlayList{
  static ArrayList<String> playlist = new ArrayList<>();

  void addToPlayList(String playlistFilePath){
    if(playlist.contains(playlistFilePath)){
      System.out.println("Already Added");
    }else{
      playlist.add(playlistFilePath);
      System.out.println("Added to playlist.");
    }
  }

  void viewPlayList(){
    if(playlist.size()>0){
      System.out.println("Play List");
      for(int i=0;i<playlist.size();i++){
        System.out.println((i+1)+". "+playlist.get(i));
      }
    }else{
      System.out.println("Empty Play List");
    }
  }

  void loadFromPlayList(AudioPlayer audioPlayer, int audioIndex){
    if (audioIndex >= 0 && audioIndex < playlist.size()) {
      audioPlayer.stop();
      audioPlayer.loadAudio(playlist.get(audioIndex));
    }else{
      System.out.println("Invalid Audio Number");
    }
  }

  void shufflePlayList(){
    Collections.shuffle(playlist);
    System.out.println("Playlist shuffled.");
  }

}