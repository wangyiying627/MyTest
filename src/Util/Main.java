package Util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author 王艺颖
 */
public class Main {
    public static void main(String[] args) {
        List<Box> boxesList = new ArrayList<>(10);
        boxesList.add(nextBox(null));
        for (int i = 0; i < 10; i++) {
            Box box = boxesList.get(i);
            if (openBox(box)) {
                System.out.println(box.toString());
            }
            boxesList.add(nextBox(box));
        }
    }

    /**
     * 获取下个宝箱
     * @param preBox
     * @return
     */
    static Box nextBox(Box preBox) {
        if (Objects.isNull(preBox)) {
            return new Box(1, "", "0", 0);
        }
        return new Box(++preBox.idx, "", preBox.hash, 0);
    }

    /**
     * 开箱验密
     * @param box
     * @return
     */
    static boolean openBox(Box box) {

        while (box.secNo < Long.MAX_VALUE) {
            ++box.secNo;
            box.hash = hash(box);
            if (box.hash.startsWith("00000")) {
                return true;
            }
        }

        return false;
    }

    /**
     *宝箱hash算法
     * @param box
     * @return
     */
    static String hash(Box box) {
        String toHashStr = String.format("%d%s%d", box.idx, box.preHash, box.secNo);
        String res = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(toHashStr.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            String temp = null;
            for (int i = 0; i < bytes.length; i++) {
                temp = Integer.toHexString(bytes[i] & 0xFF);
                if (temp.length() == 1) {
                    sb.append("0");
                }
                sb.append(temp);
            }
            res = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return res;
    }


}


