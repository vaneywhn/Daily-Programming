public class ConvertZ {
    public String convert(String s, int numRows) {
        int circle =  2 * numRows - 2;
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<numRows;i++){
            for (int j = 0; j+i < s.length(); j=j+circle) {
                sb.append(s.charAt(i+j));
                if (i != 0 && i != numRows - 1 && j + circle - i < s.length())
                    sb.append(s.charAt(j + circle - i));
            }
        }
        return sb.toString();
    }
}
