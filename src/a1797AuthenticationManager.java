import java.util.HashMap;
import java.util.Map;

public class a1797AuthenticationManager {
}


class AuthenticationManager {

    private Map<String, Integer> expectedToken;
    private static int TTL;

    public AuthenticationManager(int timeToLive) {
        TTL = timeToLive;
        expectedToken = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        expectedToken.put(tokenId, currentTime + TTL);
    }

    public void renew(String tokenId, int currentTime) {
        int expireTime = expectedToken.getOrDefault(tokenId, -1);
        if (expireTime > currentTime) {
            expectedToken.put(tokenId, currentTime + TTL);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        return (int) expectedToken.values().stream().filter(it -> it > currentTime).count();
    }
}