import java.util.Scanner;

public class Singer {
    private static int nextSingerId = 1;

    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
        this.singerId = nextSingerId++;
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData(Scanner scanner,int currentsingerIndex) {
        boolean isExit = true;
        this.singerId = currentsingerIndex;


        System.out.println("Nhập thông tin của ca sĩ:");

        System.out.print("Tên ca sĩ: ");
        do {
            this.singerName = scanner.nextLine();
            if (!this.singerName.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Tên sách không được để trống!!!");
            }
        } while (isExit);

            System.out.print("Tuổi: ");

            do {
                this.age = Integer.parseInt(scanner.nextLine());
                if (this.age > 0) {
                    break;
                } else {
                    System.out.println("Tuổi phải lớn hơn 0!!!");
                }

            }
            while (isExit);




            System.out.print("Quốc tịch: ");
            do {
                this.nationality = scanner.nextLine();
                if (!this.nationality.trim().isEmpty()) {
                    break;
                } else {
                    System.err.println("Quốc tịch không được để trống!!!");
                }
            } while (isExit);


            System.out.print("Giới tính (Nam: true, Nữ: false): ");
            gender = Boolean.parseBoolean(scanner.nextLine());
            System.out.print("Thể loại: ");
            genre = scanner.nextLine();
        }


    public void displayData() {
        System.out.println("Thông tin ca sĩ:");
        System.out.println("Mã ca sĩ: " + singerId);
        System.out.println("Tên ca sĩ: " + singerName);
        System.out.println("Tuổi: " + age);
        System.out.println("Quốc tịch: " + nationality);
        System.out.println("Giới tính: " + (gender ? "Nam" : "Nữ"));
        System.out.println("Thể loại: " + genre);
    }
}
