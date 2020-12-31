package Util;

/**
 * @author 王艺颖
 * 宝箱实体
 */
public class Box {
    int idx;
    String hash;
    String preHash;
    long secNo;

    public Box(int idx, String hash, String preHash, long secNo) {
        super();
        this.idx = idx;
        this.hash = hash;
        this.preHash = preHash;
        this.secNo = secNo;
    }

    @Override
    public String toString() {
        return "Box [idx=" + idx + ", hash=" + hash + ", preHash=" + preHash + ", secNo=" + secNo
                + "]";
    }
}