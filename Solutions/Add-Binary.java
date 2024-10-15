// https://leetcode.com/problems/add-binary

import java.math.BigInteger;
class AddBinarySolution {
    public String addBinary(String a, String b) {
        BigInteger aBigInt = new BigInteger(a, 2);
        BigInteger bBigInt = new BigInteger(b, 2);
        BigInteger sum = aBigInt.add(bBigInt);

        return sum.toString(2);
        
    }
}