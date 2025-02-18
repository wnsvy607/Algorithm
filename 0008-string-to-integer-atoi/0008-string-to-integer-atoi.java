import java.util.*;

class Solution {
    public int myAtoi(String s) {
        
        StringBuilder sb = new StringBuilder();
        boolean plus = true;
        boolean zero = false;
        boolean sign = false;


        for(var ch : s.toCharArray()) {
            if(zero) {
                if(!Character.isDigit(ch)) return 0;
                else if(ch != '0'){
                    sb.append(ch);
                    zero = false;
                    continue;
                }
            }

            if(!Character.isDigit(ch)) {
                if(sign) break;
                if(ch > 'A') break;
                if(sb.length() > 0) break;
                if(ch == '-') {
                    plus = false;
                    sign = true;
                    continue;
                }
                if(ch == ' ') continue;
                else if(ch == '+') {
                    sign = true;
                    continue;
                }
                else break;
            }

            if(ch == '0' && sb.length() == 0) {
                zero = true;
                continue;
            }

            sb.append(ch);

        }

        if(sb.length() == 0) return 0;

        if(plus && (sb.length() > 10 || Long.parseLong(sb.toString()) > Integer.MAX_VALUE)) return Integer.MAX_VALUE;
        if(!plus && (sb.length() > 10 || Long.parseLong("-" + sb.toString()) < Integer.MIN_VALUE )) return Integer.MIN_VALUE;

        if(plus) {
            return Integer.parseInt(sb.toString());
        } 


        return Integer.parseInt("-" + sb.toString());
    }


}