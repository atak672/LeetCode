// https://leetcode.com/problems/fraction-addition-and-subtraction

class FractionAdditionAndSubtractionSolution {
    public String fractionAddition(String expression) {
        List<String> fractions = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch) || ch == '/') {
                s.append(ch);
                if (i == expression.length() - 1) {
                    fractions.add(s.toString());
                }
            } else {
                if (s.length() > 0) {
                    fractions.add(s.toString());
                    s.setLength(0);
                }
                if (ch == '-') {
                    s.append(ch);
                }
            }
        }

        String[] arr = fractions.toArray(new String[0]);
        return divideAndConquer(arr, 0, arr.length - 1);
    }


    public String divideAndConquer(String[] arr, int start, int end){
         if (start == end){
            return arr[start];
        }

        int mid = start + ((end - start)/2);
        String fracOne = divideAndConquer(arr, start, mid);
        String fracTwo = divideAndConquer(arr, mid + 1, end);

        String[] a = fracOne.split("/");
        int numOne = Integer.valueOf(a[0]);
        int denOne = Integer.valueOf(a[1]);

        String[] b = fracTwo.split("/");
        int numTwo = Integer.valueOf(b[0]);
        int denTwo = Integer.valueOf(b[1]);


        int numerator = numOne * denTwo + numTwo * denOne;
        int denominator = denTwo * denOne;

        int gcd = gcdNums(numerator, denominator);
        
        return (numerator / gcd) + "/" + (denominator / gcd);
    }


    public int gcdNums(int a, int b){
        if (a == 0){
            return Math.abs(b);
        }
        else {
            return gcdNums(b % a, a);
        }
    } 
}