public class ipToInt {
    public static void main(String[] args) {
        ipToInt ipInt = new ipToInt();
        System.out.println(ipInt.ipToInt("127.0.0.1"));

        System.out.println(ipInt.intToIp(ipInt.ipToInt("127.0.0.1")));
        
    }


    public static int ipToInt(String ipStr) {
        String[] ip = ipStr.split("\\.");
        return (Integer.parseInt(ip[0]) << 24) + (Integer.parseInt(ip[1]) << 16) + (Integer.parseInt(ip[2]) << 8) + Integer.parseInt(ip[3]);
    }

    public static String intToIp(int intIp) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(intIp>> 24)+".");
        builder.append(String.valueOf((intIp& 0x00FFFFFF) >> 16)+".");
        builder.append(String.valueOf((intIp& 0x0000FFFF) >> 8)+".");
        builder.append(String.valueOf((intIp& 0x000000FF)));
        return builder.toString();
    }


}
