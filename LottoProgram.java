
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class LottoProgram {
    public static void main(String[] args){

        int cnt = 0;
        int grade = 0;
        int [] lotto = new int [6];
        int [] user = new int [6];

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        while(true){

            //기계 돌림 여부 확인
            System.out.println("==========================================");
            System.out.print("Lotto 추첨을 시작할까요?(Yes/No): ");
            String start = in.nextLine();

            if(start.equals("Yes")){

                //유저 이름 입력 받기
                System.out.print("이름을 입력해주세요: ");
                String name = in.nextLine();

                //유저에게 번호 받기
                System.out.print("번호 6개를 뽑아주세요: ");
                for(int i = 0; i < 6; i++){
                    user[i] = in.nextInt();
                }
                in.nextLine();

                //랜덤으로 번호 추첨
                for(int i = 0; i < 6; i++){
                    lotto[i] = random.nextInt(45) + 1;
                    for(int j = 0; j < i; j++){
                        if(lotto[i] == lotto[j]){
                            i--;
                        }
                    }
                }

                //결과확인
                for(int i = 0; i < 6; i++){
                    for(int j = 0; j < 6; j++){
                        if (lotto[i] == user[j]){
                            cnt++;
                        }
                    }
                }

                //등수 확인 후 결정
                switch (cnt) {
                    case 6:
                        grade = 1;
                    case 5:
                        grade = 2;
                    case 4:
                        grade = 3;
                    default:
                }

                //결과 출력
                if(grade > 0){
                    System.out.println("[로또 결과] " + name + "님, 오늘은 " + grade + "등입니다!");
                }
                else{
                    System.out.println("[로또 결과]" + name + "님, 오늘은 꽝입니다.");
                }

                System.out.println("뽑으신 번호: " + Arrays.toString(user));
                System.out.println("로또 번호: " + Arrays.toString(lotto));

            }

            else if(start.equals("No")){
                break;
            }

            else {
                System.out.println("추첨 여부를 정확히 다시 입력해주세요.");
            }
        }

        in.close();
    }
}
