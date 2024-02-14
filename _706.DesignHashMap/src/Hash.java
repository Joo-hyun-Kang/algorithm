public interface Hash {
    Object hashcodeOrNull(Object value);

    int calculateCollision();
}
