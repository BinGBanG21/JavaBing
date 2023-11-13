public class TitleToNumber {
    public static void main(String[] args) {

    }

    public int titleToNumber(String columnTitle) {
        //26进制转化成10进制
        int ans = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            ans += k * multiple;
            multiple *= 26;
        }
        return ans;
    }
}
