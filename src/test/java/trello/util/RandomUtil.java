package trello.util;

public final class RandomUtil {
    private RandomUtil() {}
    public static <T> T pickOne(java.util.List<T> list) {
        return list.get(new java.util.Random().nextInt(list.size()));
    }
}

