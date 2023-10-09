import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Song {

    private static int nextSongId = 1;

    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
        this.songId = generateSongId();
        this.createdDate = new Date();
    }

    public String getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Scanner scanner,Singer[] singers,int index) {
        boolean isExit = true;

        System.out.print("nhập tên bài hát: ");
        do {
            this.songName = scanner.nextLine();
            if (!this.songName.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Tên sách không được để trống!!!");
            }
        } while (isExit);

        System.out.print("nhập mô tả bài hát: ");
        descriptions = scanner.nextLine();

        System.out.println("danh sách các ca sĩ để lựa chọn");
        for (int i = 0; i <index ; i++) {
            singers[i].displayData();
        }
        System.out.println("Select singer by ID:");
        int inpuId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if(inpuId ==   singers[i].getSingerId()){
                this.singer =singers[i];
            }
        }
        System.out.print("Người sáng tác: ");
        this.songWriter = scanner.nextLine();
    }





    public void displayData() {
        System.out.println("Song ID: " + songId);
        System.out.println("Song Name: " + songName);
        System.out.println("Descriptions: " + descriptions);
        System.out.println("Singer: " + singer);
        System.out.println("Song Writer: " + songWriter);
        System.out.println("Created Date: " + createdDate);
        System.out.println("Song Status: " + (songStatus ? "Active" : "Inactive"));
    }

    private String generateSongId() {
        return "S" + String.format("%03d", nextSongId++);
    }
}
