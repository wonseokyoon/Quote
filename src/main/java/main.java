
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//
//
//
//

public class main {
    private static final List<Quote> quotes=new ArrayList<>();
    private static int nextId=1;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while(true){
            System.out.println("==명언 앱==");
            System.out.print("명령) ");
            String command = scanner.nextLine().trim();

            if(command.equals("종료")){
                break;
            } else if (command.startsWith("등록")) {
                registerQuote(scanner);
            }
        }
        scanner.close();    //리소스해제
    }

    private static void registerQuote(Scanner scanner){ //등록 메서드
        System.out.print("명언: ");
        String content=scanner.nextLine().trim();
        System.out.print("작가: ");
        String author=scanner.nextLine().trim();

        Quote quote=new Quote(nextId++,content,author);
        quotes.add(quote);


        System.out.println(quote.id+"번 명언이 등록되었습니다.");
    }


}