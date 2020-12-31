package Util;

class Box {
    int idx;
    long stamp;
    String hash;
    String preHash;
    long secNo;

    public Box(int idx, long stamp, String hash, String preHash, long secNo) {
        super();
        this.idx = idx;
        this.stamp = stamp;
        this.hash = hash;
        this.preHash = preHash;
        this.secNo = secNo;
    }

    @Override
    public String toString() {
        return "Box [idx=" + idx + ", stamp=" + stamp + ", hash=" + hash + ", preHash=" + preHash + ", secNo=" + secNo
                + "]";
    }
}