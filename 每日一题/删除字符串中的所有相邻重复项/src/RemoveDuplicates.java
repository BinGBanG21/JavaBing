public class RemoveDuplicates {
    public static void main(String[] args) {

    }
    public String removeDuplicates(String s) {
        StringBuffer str = new StringBuffer();
        int len = -1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            //如果栈中有字符并且头部字符和ch相等 那么删除
            if(len >= 0 && str.charAt(len) == ch){
                str.deleteCharAt(len);
                len--;
            }else{
                str.append(ch);
                len++;
            }
        }
        return str.toString();
    }
}
