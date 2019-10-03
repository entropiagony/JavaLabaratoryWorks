import java.util.Scanner;

public class UserInterface {
    private Scanner in;

    UserInterface(){
        in = new Scanner(System.in);
    }
    public void getFileName(CommentRemover c) {
        System.out.println("Enter name of your file: ");
        c.setFileName(in.nextLine());
    }
    public void getFileDir(CommentRemover c){
        System.out.println("Enter directory of your file: ");
        c.setDirectory(in.nextLine());
    }
}
