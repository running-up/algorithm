public class ReverseWordsinaString3 {
    public static void main(String []args){

    }

    public static String reverseWords(String s) {
        String result = "";
        String[] splitedS = s.split(" ");
        for(int i = 0 ; i < splitedS.length ; i++) {
            String temp = splitedS[i];            
            result += new StringBuffer(temp).reverse().toString();
            if(i < splitedS.length - 1){
                result += " ";
            }
        }
        return result;
    }
}
