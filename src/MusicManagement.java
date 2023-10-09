import java.util.Arrays;
import java.util.Scanner;

public class MusicManagement {
    static Song[] songs = new Song[100];
    static Singer[] singers = new Singer[100];
    static int currentsingerIndex = 0;
    static  int currentSongIndex=0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.print("Chọn nội dung : ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    singerManagement();
                    break;
                case 2:
                    songManagement();
                    break;
                case 3:
                    searchManagement();
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 4);
    }

    private static void searchManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại ");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại ");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4.Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("mời nhập vào tên của ca sĩ");
                    String namSingleId = String.valueOf(Integer.valueOf(scanner.nextLine()));
                    songNamebySingle(namSingleId);

                    break;
                case 2:

                    System.out.println("mời nhập vào tên của Bai hat");
                    String namSong = String.valueOf(Integer.valueOf(scanner.nextLine()));

                    songNameTakeSingle(namSong);
                    break;
                case 3:
                    System.out.println("danh sach theo thứ tự tăng dần");
                   int n = songs.length;
                   for(int i= 0;i<n-1;i++){
                       for(int j=i+1;j < n; j++){
                           if(songs[i].getSongName().compareTo(songs[j].getSongName())>0){
                               Song temp= songs[i];
                               songs[i]=songs[j];
                               songs[j]=temp;

                           }
                       }
                   }





                    System.out.println("----------------------");

                    break;
                case 4:
                    // TODO: Delete song by ID
                    break;
                case 5:
                    System.out.println("Thoát khỏi menu tìm kiếm.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 5);
    }

    private static void songNameTakeSingle(String nameSong) {

        for (int i = 0; i < currentSongIndex; i++) {
            if (songs[i].getSongName() == nameSong) {
                for (int j = i; j < currentSongIndex; j++) {
                    songs[i].getSinger().displayData();
                }

            }
        }
    }

    private static void songNamebySingle(String namSingleId) {

        for (int i = 0; i < currentSongIndex; i++) {
            if (songs[i].getSinger().getSingerName() == namSingleId) {
                for (int j = i; j < currentSongIndex; j++) {
                    songs[i].displayData();
                }

            }
        }
        System.out.println("---------------------");

    }

    private static void songManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice,numberOfSong;

        do {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Nhập vào số lượng bài hát cần thêm ");
                    numberOfSong = Integer.parseInt(scanner.nextLine());


                    for (int i = 0; i < numberOfSong; i++) {
                        addNewSong(scanner);
                        currentSongIndex++;
                    }
                    break;
                case 2:
                    displaySong();
                    break;
                case 3:
                    editSong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 5:
                    System.out.println("Thoát khỏi menu quản lý bài hát.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 5);
    }

    private static void deleteSong() {
        System.out.println("Hãy nhập Id của Bài hát cần xoá:");
        String deletedId = String.valueOf(Integer.parseInt(scanner.nextLine()));
        for (int i = 0; i < currentSongIndex; i++) {
            if (songs[i].getSongId() == deletedId) {
                for (int j = i; j < currentSongIndex; j++) {
                    songs[j] = songs[j + 1];
                }
                currentSongIndex--;
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh với Id vừa nhập");
    }

    private static void editSong() {
        System.out.println("Hãy nhập Id của bai hat cần sửa:");
        String editedId = String.valueOf(Integer.parseInt(scanner.nextLine()));
        for (int i = 0; i < currentSongIndex; i++)
            if (editedId == songs[i].getSongId()) {
                System.out.println("Thông tin của bai hat mà bạn muốn sửa:");
                songs[i].displayData();
                songs[i].inputData(scanner, singers, currentSongIndex);
                System.out.println("Đã cập nhật thông tin của bài hát");
                return;
            }
        System.out.println("Không tìm thấy học sinh với Id vừa nhập");
    }

    private static void displaySong() {
        System.out.println("Danh sách tất cả baif hat:");
        for (int i = 0; i < currentSongIndex; i++) {
            songs[i].displayData();
        }
        System.out.println("----------------------");
    }

    private static void addNewSong(Scanner scanner) {
        Song song = new Song();
        song.inputData(scanner,singers,currentSongIndex );
        songs[currentSongIndex]=song;

    }

    private static void singerManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice,numberOfSinger;

        do {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("nhập vào số lượng ca sĩ");
                    numberOfSinger = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < numberOfSinger; i++) {

                        addNewSinggle(scanner);
                        currentsingerIndex++;


                    }
                  
                    break;
                case 2:
                    displaySingle();
                 
                    break;
                case 3:
                    editSingle();
                  
                    break;
                case 4:
                    deleteSingle();
             
                    break;
                case 5:
                    System.out.println("Thoát khỏi menu quản lý ca sĩ.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 5);
    }

    private static void deleteSingle() {
        System.out.println("Hãy nhập Id của Single cần xoá:");
        int deletedId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentsingerIndex; i++) {
            if (singers[i].getSingerId() == deletedId) {
                for (int j = i; j < currentsingerIndex; j++) {
                    singers[j] = singers[j + 1];
                }
                currentsingerIndex--;
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh với Id vừa nhập");
    }

    private static void editSingle() {
        System.out.println("Hãy nhập Id của single:");
        int editedId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentsingerIndex; i++) {
            if (singers[i].getSingerId() == editedId) {
                System.out.println("Thông tin của single mà bạn muốn sửa:");
                singers[i].displayData();
                singers[i].inputData(scanner,currentsingerIndex);
                System.out.println("Đã cập nhật thông tin cua sigle");
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh với Id vừa nhập");
    }

    private static void displaySingle() {
        System.out.println("Danh sách tất cả cac single:");
        for (int i = 0; i < currentsingerIndex; i++) {
            singers[i].displayData();
        }
        System.out.println("----------------------");
    }

    private static void addNewSinggle(Scanner scanner) {
        Singer singer = new Singer();
        singer.inputData(scanner,currentsingerIndex);
        singers[currentsingerIndex]= singer;

    }
}


