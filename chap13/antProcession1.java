package chap13;

public class antProcession1 {

	public static void main(String[] args) {
		 // 알고리즘 : 개미수열

        gami(11);

    }

    

    public static void gami(int num) {

        StringBuilder sb = new StringBuilder("1");

        String[] temp = sb.toString().split("");

        for(int i=0;i<num;i++) {

            System.out.println("["+sb.toString()+"]");

            temp = sb.toString().split("");

            String token = temp[0];

            sb = new StringBuilder();

            int cnt = 0;

            for(int j=0;j<temp.length;j++) {

                if(token.equals(temp[j])) {

                    cnt++;

                }else {

                    sb.append(token+""+cnt);

                    token = temp[j];

                    cnt = 1;

                }

            }

            if(cnt >= 1) {

                sb.append(token+""+cnt);

                cnt = 1;

            }

            

        }

        

    }

 
}

