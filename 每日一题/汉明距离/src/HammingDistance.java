public class HammingDistance {
    public static void main(String[] args) {

    }
    public int hammingDistance(int x, int y) {
        return Integer.bitCount( x ^ y );
    }
}
