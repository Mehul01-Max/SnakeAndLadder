public class MoveResult {
    final int startPos;
    final int rolled;
    final int finalPos;
    final MoveType type;

    public MoveResult(int startPos, int rolled, int finalPos, MoveType type) {
        this.startPos = startPos;
        this.rolled = rolled;
        this.finalPos = finalPos;
        this.type = type;
    }
}
