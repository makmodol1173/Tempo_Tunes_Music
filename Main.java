import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AudioPlayer audioPlayer = new AudioPlayer();
        PlayList playList = new PlayList();

        System.out.println("Tempo Tunes");
        System.out.println("1. Load Audio");
        System.out.println("2. Add to Playlist");
        System.out.println("3. View Play List");
        System.out.println("4. Load From Play List");
        System.out.println("5. Shuffle Playlist");
        System.out.println("6. Play/Resume");
        System.out.println("7. Pause");
        System.out.println("8. Stop Playing");
        System.out.println("9. Seek Forward");
        System.out.println("10. Seek Backward");
        System.out.println("11. Exit");

        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the path to the audio file: ");
                    String filePath = scanner.nextLine();
                    audioPlayer.stop();
                    audioPlayer.loadAudio(filePath);
                    break;
                case 2:
                    System.out.print("Enter the path to add to the playlist: ");
                    String playlistFilePath = scanner.nextLine();
                    playList.addToPlayList(playlistFilePath);
                    break;
                case 3:
                    playList.viewPlayList();
                    break;
                case 4:
                    System.out.print("Enter Audio Number: ");
                    int audioIndex=scanner.nextInt();
                    audioIndex--;
                    playList.loadFromPlayList(audioPlayer,audioIndex);
                    break;
                case 5:
                    playList.shufflePlayList();
                    break;
                case 6:
                    audioPlayer.play();
                    break;
                case 7:
                    audioPlayer.pause();
                    break;
                case 8:
                    audioPlayer.stop();
                    break;
                case 9:
                    System.out.print("Enter the seek time in milliseconds to seek forward: ");
                    int forwardMillis = scanner.nextInt();
                    audioPlayer.seekForward(forwardMillis);
                    break;
                case 10:
                    System.out.print("Enter the seek time in milliseconds to seek backward: ");
                    int backwardMillis = scanner.nextInt();
                    audioPlayer.seekBackward(backwardMillis);
                    break;
                case 11:
                    audioPlayer.stop();
                    System.out.println("Exiting the audio player.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
