//크로아티아 알파벳
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        int count = 0; //알파벳 개수
        String str = scanner.nextLine();
        
        //중요한 점 : StringIndexOutOfBounds 런타임 에러가 나타나지 않도록!!
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'c') { //c=, c-일 경우
                if(i < str.length() - 1){ 
                    if(str.charAt(i+1) == '=' || str.charAt(i+1) == '-') { 
                        i++;
                    }
                }
            }
            else if(str.charAt(i) == 'd') {
                if(i < str.length() - 2){ //dz=일 경우 --> StringIndexOutOfBounds주의!
                    if(str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') { 
                        i += 2;
                    }
                    
                }
                if(i < str.length() - 1) { //d-일 경우
                    if(str.charAt(i+1) == '-') {
                        i++;
                    }
                }
            }
            else if(str.charAt(i) == 'l' || str.charAt(i) == 'n') { //lj, nj 일 경우
                if(i < str.length() - 1){
                    if(str.charAt(i+1) == 'j') { 
                        i++;
                    }
                } 
                
            }
            else if(str.charAt(i) == 's' || str.charAt(i) == 'z') { //s=, z= 일 
                if(i < str.length() - 1){
                    if(str.charAt(i+1) == '=') { 
                        i++;
                    }
                } 
                
            }
            count++;
        } 
        System.out.println(count);
    }
}
