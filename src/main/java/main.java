
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
            } else if (command.equals("목록")) {
                listQuotes();
            } else if (command.startsWith("삭제?id=")) {
                deleteQuote(command);
            } else if (command.startsWith("수정?id=")) {
                modifyQuote(command,scanner);
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

    private static void listQuotes() {  //목록 확인 메서드
        if(quotes.isEmpty()){
            System.out.println("명언을 등록하세요");
            return;
        }

        System.out.println("번호 / 작가 / 명언 ");
        System.out.println("----------------");

        for(int i=quotes.size()-1;i>=0;i--){    //역순 출력
            Quote quote=quotes.get(i);  //i번째 명언
            System.out.println(quote.id+" / "+
                    quote.author+" / "+ quote.content);
        }
    }

    private static void deleteQuote(String command){    //삭제 메서드
        int id=Integer.parseInt(command.substring(6));  //삭제?id=n, id=6번째 문자

        for(int i=0;i<quotes.size();i++){
            if (quotes.get(i).id==id){  //i번째 명언의 id
                quotes.remove(i);
                System.out.println(id+"번 명언이 삭제되었습니다. ");
                return;
            }
        }

        System.out.println(id+"번 명언은 존재하지 않습니다.");
    }
    private static void modifyQuote(String command,Scanner scanner){    //수정 메서드
        int id=Integer.parseInt(command.substring(6));

        for(Quote quote:quotes){
            if(quote.id==id){
                System.out.println("명언(기존): "+ quote.content);
                System.out.print("명언: ");
                quote.content=scanner.nextLine().trim();

                System.out.println("작가(기존):"+quote.author);
                System.out.print("작가: ");
                quote.author=scanner.nextLine().trim();


                System.out.println(id+"번 명언 수정.");
                return;
            }
        }
        System.out.println(id+ "번 명언은 존재하지 않습니다");
    }







}